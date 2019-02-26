import java.util.*;

public class SoupGenerator {

    private static Random rand = new Random();

    private List<String> words;
    private List<List<Character>> soup;
    private List<Integer[]> possible_directions;

    private int soup_size;

    public SoupGenerator(List<String> words, int soup_size){
        this.words = words;
        this.soup_size = soup_size;

        possible_directions = new ArrayList<>();
        generatePossiblePositions();
    }


    public List<List<Character>> generate(){
        soup = new ArrayList<>();
        createSoup();

        for (String word : words)
            insertWord(word);
        putRandomCharsInSoup();

        return soup;
    }

    private void createSoup(){

        for (int index_row = 0; index_row < soup_size; index_row++){
            soup.add(new ArrayList<>());
            for (int index_col = 0; index_col < soup_size; index_col++)
                soup.get(index_row).add(null);
        }
    }

    private void insertWord(String word){

        Integer[] position_to_insert;
        Integer[] direction;

        do{
            position_to_insert = new Integer[]{rand.nextInt(soup_size),
                                                rand.nextInt(soup_size)};

        }while((direction = generateRandomDirection(word, position_to_insert)) == null);

        insertWordInDirection(word, position_to_insert, direction);
    }

    private Integer[] generateRandomDirection(String word, Integer[] initial_position){

        List<Integer[]> current_possible_directions = new ArrayList<>(possible_directions);

        while(current_possible_directions.size() > 0){
            Integer[] direction = current_possible_directions.get(rand.nextInt(current_possible_directions.size()));
            current_possible_directions.remove(direction);

            int index;
            for(index = 0; index < word.length(); index++){
                char character_to_put = word.charAt(index);
                Integer[] position_to_put = {initial_position[0] + index*direction[0],
                                                initial_position[1] + index*direction[1]};

                // verify if word to put in this direction doesn't get out of soup and verify if it intersects with some character
                if((position_to_put[0] < 0 || position_to_put[1] < 0 || position_to_put[0] >= soup.size() || position_to_put[1] >= soup.size()) ||
                        (soup.get(position_to_put[0]).get(position_to_put[1]) != null &&
                        soup.get(position_to_put[0]).get(position_to_put[1]) != character_to_put))
                    break;
            }
            if(index == word.length())
                return direction;

        }

        return null;
    }

    private void insertWordInDirection(String word, Integer[] initial_position, Integer[] direction){

        for(int index = 0; index < word.length(); index++){

            char character_to_put = Character.toUpperCase(word.charAt(index));
            Integer[] position_to_put = {initial_position[0] + index*direction[0],
                    initial_position[1] + index*direction[1]};

            soup.get(position_to_put[0]).set(position_to_put[1], character_to_put);
        }
    }

    private void generatePossiblePositions(){

        int[] coordinate__possible_values = {-1, 0, 1};
        for(int x : coordinate__possible_values)
            for(int y : coordinate__possible_values){
                if(x != 0 || y != 0)
                    possible_directions.add(new Integer[]{x, y});
            }
    }

    private void putRandomCharsInSoup(){

        for(int row_index = 0; row_index < soup.size(); row_index++)
            for(int col_index = 0; col_index < soup.get(row_index).size(); col_index++)
                if(soup.get(row_index).get(col_index) == null)
                    soup.get(row_index).set(col_index, (char)('A' + rand.nextInt(26)));
    }

}
