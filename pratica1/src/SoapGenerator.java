import java.util.*;


public class SoapGenerator {

    private static final int MAX_SIZE = 60;

    public static List<List<Character>> generate(List<String> words){

        List<List<Character>> current_soap = new ArrayList<>();
        List<Integer[]> possible_positions = new ArrayList<>();
        Map<Character, List<Integer[]>> positions = new TreeMap<>();
        Random rand = new Random();

        for (String word : words) {
            (rand.nextDouble() < 0.5) ? insertWithIntersection(current_soap, positions, word) : insertRandom(current_soap, possible_positions,
                                                                                                        positions, word, possible_directions);
        }

        return null;
    }

    private static void insertRandom(List<List<Character>> current_soap, List<Integer[]> possible_positions,
                                     Map<Character, List<Integer[]>> positions , String word, int[][] possible_directions){


    }

    private static void insertWithIntersection(List<List<Character>> current_soap,
                                               Map<Character, List<Integer[]>> positions , String word){



    }

    private static void resizeSoap(List<List<Character>> current_soap, String word, int min_size){



    }

    private static boolean generateRandomDirection(List<List<Character>> current_soap, String word ,
                                                   int[] possible_directions, Integer[] position){


        return false;
    }

}
