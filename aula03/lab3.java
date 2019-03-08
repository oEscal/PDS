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

    static Scanner keyBoard = new Scanner(System.in);

    public static void main(String args[]){

        while(true)
            menu();

    }

    private static void map(List<TreeSet<Member>> map_doors){

        List<Member> current_line_struct = new ArrayList<>();
        for (int door_index = 0; door_index < map_doors.size(); door_index++) {

            System.out.print(door_index + 1 + " ");

            // verify if last members remains in current door
            for(int member_index = current_line_struct.size() - 1; member_index >= 0 ; member_index--){
                if(!contains(map_doors.get(door_index), current_line_struct.get(member_index)))
                    current_line_struct.remove(member_index);
                else
                    break;
            }

            // add new elements to the current door
            for(Member member : map_doors.get(door_index))
                if(!current_line_struct.contains(member))
                    current_line_struct.add(member);


            for (Member member : current_line_struct) {
                if(contains(map_doors.get(door_index), member))
                    System.out.print(": " + member.getName());
                else
                    System.out.printf("  " + generateWhiteString(member.getName().length()));
            }
            System.out.println();
        }
    }

    private static boolean contains(TreeSet<Member> set, Member member_to_check){
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


    //Data Structures
    private static final int  MIN_NUMBER_DOOR = 1;
    private static List <Member> street = new ArrayList<>();


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


    private static void checkDoors(int x1 , int x2){
        if ( x1 < MIN_NUMBER_DOOR || x2 < MIN_NUMBER_DOOR ) ErrorStreet.nonExistDoorError();
        if ( x1 > x2 ) ErrorStreet.errDoorsIntervalError();
    }

    /*
    Function to put families in data structure street
    */
    private static void getFamilies(List <String> content){

        int x1,x2;
        content.remove(0);

        for (String family : content){


            x1 = Integer.parseInt(family.split("-")[0]);
            x2 = Integer.parseInt(family.split("-")[2]);
            checkDoors(x1,x2);

            if ( street.contains(Member.factory(family.split("\\s")[1], x1, x2)) )
                System.err.println("Resident already exist!");
            else
                street.add( Member.factory(family.split("\\s")[1], x1, x2) );
        }

    }

    /*
    Function to add resident on street
    If resident exist already, send error
     */
    private static void addMember(String[] option){

        int x1,x2;

        try{
            x1 = Integer.parseInt(option[2]);
            x2 = Integer.parseInt(option[3]);
            checkDoors(x1,x2);
            street.add( Member.factory( option[1] , x1 ,x2 ) );
        }catch (ArithmeticException e){
            System.err.println("Numbers of door not int!");
        }


    }

    /*
    Function to remove resident
    If resident dont exist, give error
     */
    private static void removeMember(String name){

        boolean checkExistence = true;

        for ( Member member : street )
            if ( member.getName() == name) {
                street.remove(member);
                checkExistence = false;
                break;
            }

        if (checkExistence)
            System.err.println("Não existe!");
    }


    /*
    Function to find family from one name
     */
    private static void showFamily(String nameMember){

        int num_initial,num_final;

        for ( Member resident : street ) {

            if (resident.getName() == nameMember) {
                num_initial = resident.getNum_initial();
                num_final = resident.getNum_final();

                System.out.print(num_initial + " " + num_final + " : ");
                for (Member habitant : street)
                    if (habitant.getNum_initial() == num_initial && habitant.getNum_final() == num_final)
                        System.out.print(habitant.getName() + " ");
                System.out.println();
            }

        }

    }

    private static void clearResidents(){
        street.clear();
    }

    private static void menu(){



        System.out.print("Load, Map, Add, Remove, List, LookUp, Clear, Quit\nCommand: ");
        String[] option = keyBoard.nextLine().split("[\\s]+");


        switch (option[0].toLowerCase()){
            case "load":
                List<String> content = readFileLines(option[1]);
                getFamilies(content);
                break;
            case "map":
                break;
            case "add":
                addMember(option);
                break;
            case "remove":
                removeMember(option[1]);
                break;
            case "list":
                break;
            case "lookup":
                showFamily(option[1]);
                break;
            case "clear":
                clearResidents();
                break;
            case "quit":
                System.exit(1);
                break;
        }

    }

}
