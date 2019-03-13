package aula03;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class lab3 {

    //Initialize global variables
    private static final int  MIN_NUMBER_DOOR = 1;
    static Scanner input = new Scanner(System.in);

    public static void main(String args[]){

        TreeSet <Member> street = new TreeSet<>(new MemberNameComparator());
        List<String> commands_from_file = readFileLines(args[0]);

        while(true) {
            String[] option;

            if (commands_from_file.size() == 0){
                System.out.print("\n\nLoad, Map, Add, Remove, List, LookUp, Clear, Quit\n" +
                        "Command: ");
                option = input.nextLine().split("[\\s]+");

            }else
                option = commands_from_file.remove(0).split("[\\s]+");

            menu(street, option);
        }
    }

    private static void menu(TreeSet<Member> street, String[] option){

        System.out.println();

        switch (option[0].toLowerCase()){
            case "load":
                if (verifySizeOption(option, 2)) {
                    List<String> content = readFileLines(option[1]);
                    getFamilies(content, street);
                }
                break;
            case "map":
                map(street);
                break;
            case "add":
                if(verifySizeOption(option, 4)){
                    List<String> new_member_info = new ArrayList<>(Arrays.asList(option));
                    new_member_info.remove(0);
                    addMember(new_member_info,street);
                }
                break;
            case "remove":
                if(verifySizeOption(option, 2))
                    removeMember(option[1],street);
                break;
            case "list":
                list(street);
                break;
            case "lookup":
                if(verifySizeOption(option, 2))
                    lookUp(option[1],street);
                break;
            case "clear":
                clearStreet(street);
                break;
            case "quit":
                System.exit(0);
                break;
            default:
                System.err.println("Option don't recognized!");
        }
    }

    /*
    Function to read files
    */
    private static List<String> readFileLines(String file_name) {

        Path path_file = Paths.get(file_name);
        List<String> file_lines = new ArrayList<>();

        try {
            Files.lines(path_file).forEach(line -> file_lines.add(line));
        }catch(IOException e) {
            System.out.println("Error in file opening!");
        }

        return file_lines;
    }

    /*
    Function to put families in street's data structure
    */
    private static void getFamilies(List<String> content, TreeSet <Member> street){

        for (String member : content){

            String[] line_words = member.split("[-\\s]+");

            List<String> new_member_info = new ArrayList<>(Arrays.asList(line_words));
            new_member_info.add(0, new_member_info.remove(2));

            addMember(new_member_info, street);
        }
    }

    private static void map(TreeSet<Member> street){

        StreetMap street_map = new StreetMap();
        street_map.addAll(new ArrayList<>(street));

        List<TreeSet<Member>> map_doors = street_map.getDoors();

        List<Member> current_line_struct = new ArrayList<>();
        for (int door_index = 0; door_index < map_doors.size(); door_index++) {

            System.out.print(door_index + 1 + " ");

            // verify if last street remains in current door
            for(int member_index = current_line_struct.size() - 1; member_index >= 0 ; member_index--){
                if(!setContainsMember(map_doors.get(door_index), current_line_struct.get(member_index)))
                    current_line_struct.remove(member_index);
                else
                    break;
            }

            // add new elements to the current door
            for(Member member : map_doors.get(door_index))
                if(!current_line_struct.contains(member))
                    current_line_struct.add(member);


            for (Member member : current_line_struct) {
                if(setContainsMember(map_doors.get(door_index), member))
                    System.out.print(": " + member.getName());
                else
                    System.out.printf("  " + generateWhiteString(member.getName().length()));
            }
            System.out.println();
        }
    }

    private static void list(TreeSet<Member> street){

        street.forEach(member ->
                System.out.printf("%s %d %d\n",
                        member.getName(),
                        member.getNum_initial(),
                        member.getNum_final())
        );
    }

    /*
    Function to add resident on street
    If resident exist already, send error
     */
    private static void addMember(List<String> new_member_info, TreeSet <Member> street){

        String name = new_member_info.get(0),
                x1_str = new_member_info.get(1),
                x2_str = new_member_info.get(2);

        if(!isInteger(x1_str) || !isInteger(x2_str)){
            System.err.println("Doors's numbers must be integers!");
            return ;
        }

        int x1 = Integer.parseInt(x1_str),
                x2 = Integer.parseInt(x2_str);

        checkDoors(x1, x2);

        Member new_member = Member.factory(name, x1, x2);
        if(new_member == null) {
            ErrorStreet.memberNameError();
            return ;
        }
        if (street.contains(new_member)){
            System.err.println("Resident already exists!");
            return ;
        }
        street.add(new_member);
    }

    /*
    Function to remove resident
    If resident don't exist, give error
     */
    private static void removeMember(String name, TreeSet <Member> street){

        Member member_remove = checkIfMember(name, street);
        if(member_remove != null){
            street.remove(member_remove);
            return ;
        }

        System.err.println("Member doesn't exist!");
    }


    /*
    Function to find family from one name
     */
    private static void lookUp(String nameMember, TreeSet <Member> street){

        StreetMap street_map = new StreetMap();
        street_map.addAll(new ArrayList<>(street));

        Member member = checkIfMember(nameMember, street);
        if(member == null){
            System.err.println("Member doesn't exist!");
            return ;
        }

        final int door_init = member.getNum_initial();
        final int door_final = member.getNum_final();

        System.out.printf("%d %d :", door_init, door_final);
        street_map.getInDoor(door_init).forEach(member_in_door -> {
            if(door_final == member_in_door.getNum_final() &&
                    door_init == member_in_door.getNum_initial())
                System.out.print(" " + member_in_door.getName());
        });
        System.out.println();
    }

    private static void clearStreet(TreeSet <Member> street){
        street.clear();
    }

    private static void checkDoors(int x1 , int x2){

        if ( x1 < MIN_NUMBER_DOOR || x2 < MIN_NUMBER_DOOR )
            ErrorStreet.nonExistDoorError();
        if ( x1 > x2 )
            ErrorStreet.doorsIntervalError();
    }

    private static boolean setContainsMember(TreeSet<Member> set, Member member_to_check){
        AtomicBoolean result = new AtomicBoolean(false);
        set.forEach(item -> {
            if(item.equals(member_to_check))
                result.set(true);
        });
        return result.get();
    }

    private static String generateWhiteString(int size){
        String result = "";
        for(int n = 0; n < size; n++)
            result += " ";
        return result;
    }

    private static Member checkIfMember(String name, TreeSet <Member> street){

        for (Member member : street) {
            if(member.getName().equals(name))
                return member;
        }

        return null;
    }

    private static boolean isInteger(String word){
        return word.chars().allMatch(Character::isDigit);
    }

    private static boolean verifySizeOption(String[] option, int size){

        if(option.length != size){
            System.err.println("Error in arguments's number!");
            return false;
        }

        return true;
    }
}
