package aula03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class lab3 {

    //Data Structures
    private final int  MIN_NUMBER_DOOR = 1;
    private List <Member> street = new ArrayList<>();


    /*
    Function to read files
    */
    private List<String> readFileLines(String file_name) {

        Path path_file = Paths.get(file_name);
        List<String> file_lines = new ArrayList<>();

        try {
            Files.lines(path_file).forEach(line -> file_lines.add(line));
        }catch(IOException e) {
            System.out.println("Error in file opening!");
        }

        return file_lines;
    }


    private void checkDoors(int x1 , int x2){
        if ( x1 < MIN_NUMBER_DOOR || x2 < MIN_NUMBER_DOOR ) ErrorStreet.nonExistDoorError();
        if ( x1 > x2 ) ErrorStreet.errDoorsIntervalError();
    }

    /*
    Function to put families in data structure street
    */
    private void getFamilies(List <String> content){

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
    private void addMember(String[] option){

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
    private void removeMember(String name){

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
    private void showFamily(String nameMember){

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

    private void clearResidents(){
        street.clear();
    }

    private void menu(){

        Scanner keyBoard = new Scanner(System.in);

        System.out.print("Load, Map, Add, Remove, List, LookUp, Clear, Quit\nCommand: ");
        String[] option = keyBoard.nextLine().split("[\\s]+");


        switch (option[0].toLowerCase()){
            case "load":
                List<String> content = readFileLines(option[1]);
                getFamilies(content);
                break;
            case "mapa":
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

    public void main(String args[]){

        while(true)
            menu();

    }

}
