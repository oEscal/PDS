import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SoapGenerator {

    private static final int MAX_SIZE = 60;

    public static List<List<Character>> generate(List<String> words){



        int[][] possible_diretions = generatePossiblePositions();

        return null;
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

    private static void resizeSoap(List<List<Character>> current_soap,
                                   List<Integer[]> possible_positions,
                                   String word, int min_size){



    }

    private static boolean generateRandomDirection(List<List<Character>> current_soap,
                                                   String word, int[] possible_directions, Integer[] position){


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

}
