import java.util.*;

public class SoapGenerator {

    private static final int MAX_SIZE = 60;

    public static List<List<Character>> generate(List<String> words , int soap_size){

        List<List<Character>> current_soap = new ArrayList<>();
        List<Integer[]> possible_positions = new ArrayList<>();
        Map<Character, List<Integer[]>> positions = new TreeMap<>();
        int[][] possible_directions = generatePossiblePositions();
        Random rand = new Random();

        create_soap( current_soap, soap_size);
        create_possible_positions( possible_positions, soap_size);

        for (String word : words) {

            if(rand.nextDouble() < 0.5)
                insertWithIntersection(current_soap, positions, word);
            else
                insertRandom(current_soap, possible_positions, positions, word, possible_directions);
        }



        return current_soap;
    }

    private static void insertRandom(List<List<Character>> current_soap,
                                     List<Integer[]> possible_positions,
                                     Map<Character, List<Integer[]>> positions,
                                     String word, int[][] possible_directions){

        boolean try_new_position;
        Integer[] position_to_insert;

        //do{
        //    Random rand = new Random();
        //    position_to_insert = possible_positions.get(rand.nextInt(possible_positions.size()));
//
        //    try_new_position = generateRandomDirection(current_soap, word, possible_directions, position_to_insert);
        //}while(try_new_position);
//
        //possible_positions.remove(position_to_insert);
//
        }

    private static void insertWithIntersection(List<List<Character>> current_soap,
                                               Map<Character, List<Integer[]>> positions,
                                               String word){


    }



    private static boolean generateRandomDirection(List<List<Character>> current_soap,
                                                   String word, int[][] possible_directions, Integer[] position){


        return false;
    }

    private static int[][] generatePossiblePositions(){

        int[][] possible_directions = new int[8][2];
        int[] coordinate__possible_values = {-1, 0, 1};
        int indexes = 0;
        for(int n1 : coordinate__possible_values)
            for(int n2 : coordinate__possible_values){
                possible_directions[indexes][0] = n1;
                if(n1 != 0 || n2 != 0)
                    possible_directions[indexes++][1] = n2;
            }

        return possible_directions;
    }

    private static void create_soap(List<List<Character>> current_soap, int soap_size){
        for ( int i = 0; i < soap_size; i++ )
            for (int j = 0; j < soap_size; j++)
                current_soap.get(i).add(null);
    }

    private static void create_possible_positions(List<Integer[]> possible_positions, int soap_size){

        for ( int i = 0; i < soap_size; i++ )
            for (int j = 0; j < soap_size; j++)
                possible_positions.add(new Integer[]{i,j});

    }

}
