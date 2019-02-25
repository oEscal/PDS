import java.util.*;

public class SoapGenerator {

    private static Random rand = new Random();

    public static List<List<Character>> generate(List<String> words, int soap_size){

        List<List<Character>> current_soap = new ArrayList<>();
        List<Integer[]> possible_positions = new ArrayList<>();
        Map<Character, List<Integer[]>> positions = new TreeMap<>();
        List<Integer[]> possible_directions = generatePossiblePositions();

        create_soap( current_soap, soap_size);
        create_possible_positions( possible_positions, soap_size);

        for (String word : words) {

            if(rand.nextDouble() < 1)
                insertWithIntersection(current_soap, positions, word);
            else
                insertRandom(current_soap, possible_positions, positions, word, possible_directions);
        }

        return current_soap;
    }

    private static void insertRandom(List<List<Character>> current_soap,
                                     List<Integer[]> possible_positions,
                                     Map<Character, List<Integer[]>> positions,
                                     String word, List<Integer[]> possible_directions){

        List<Integer[]> current_possible_positions = new ArrayList<>(possible_positions);
        Integer[] position_to_insert;
        Integer[] direction;

        do{
            position_to_insert = current_possible_positions.get(rand.nextInt(possible_positions.size()));
            current_possible_positions.remove(position_to_insert);
        }while((direction = generateRandomDirection(current_soap, position_to_insert, word, possible_directions)) != null);

        possible_positions.remove(position_to_insert);
        insertWordInDirection(current_soap, positions, word, position_to_insert, direction);
    }

    private static void insertWithIntersection(List<List<Character>> current_soap,
                                               Map<Character, List<Integer[]>> positions,
                                               String word){



    }

    // se não for possivel, retorna null
    private static Integer[] generateRandomDirection(List<List<Character>> current_soap,
                                                 Integer[] initial_position,
                                                 String word, List<Integer[]> possible_directions){

        List<Integer[]> current_possible_directions = new ArrayList<>(possible_directions);

        while(current_possible_directions.size() > 0){
            Integer[] direction = current_possible_directions.get(rand.nextInt(possible_directions.size()));
            current_possible_directions.remove(direction);

            int index;
            for(index = 0; index < word.length(); index++){
                char character_to_put = word.charAt(index);
                Integer[] position_to_put = {initial_position[0] + index + direction[0],
                                                initial_position[1] + index + direction[1]};

                if(current_soap.get(position_to_put[0]).get(position_to_put[1]) != character_to_put)
                    break;

                current_soap.get(position_to_put[0]).add(position_to_put[1], character_to_put);
            }
            if(index == word.length())
                return direction;

        }


        return null;
    }

    private static List<Integer[]> generatePossiblePositions(){

        List<Integer[]> possible_directions = new ArrayList<>();
        int[] coordinate__possible_values = {-1, 0, 1};
        for(int n1 : coordinate__possible_values)
            for(int n2 : coordinate__possible_values){
                possible_directions.add(new Integer[]{n1, 0});
                if(n1 != 0 || n2 != 0)
                    possible_directions.get(possible_directions.size() - 1)[1] = n1;
            }

        return possible_directions;
    }

    private static void insertWordInDirection(List<List<Character>> current_soap,
                                              Map<Character, List<Integer[]>> positions,
                                              String word,
                                              Integer[] initial_position, Integer[] direction){

        for(int index = 0; index < word.length(); index++){
            char character_to_put = word.charAt(index);
            Integer[] position_to_put = {initial_position[0] + index + direction[0],
                                            initial_position[1] + index + direction[1]};

            current_soap.get(position_to_put[0]).add(position_to_put[1], character_to_put);

            if(!positions.keySet().contains(character_to_put))
                positions.put(character_to_put, new ArrayList<>());
            positions.get(character_to_put).add(position_to_put);
        }
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
