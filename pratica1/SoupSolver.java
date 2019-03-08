package pratica1;

import java.util.*;

public class SoupSolver {

    private List<String> soup;
    private List<String> soup_transposed;
    private List<String> soup_reversed;
    private List<String> words;

    public SoupSolver(List<String> soup, List<String> words){

        this.soup = soup;
        this.words = words;

        transposeSoup();
        reverseSoup();
    }


    public Map<String, Integer[]> solve(){

        Map<String, Integer[]> result = new SoupMap();

        // search lines and columns in "normal soup"
        searchLines(soup).forEach((word, position) -> {
            Integer[] position_and_order = {position[0], position[1],
                                            position[2], 1};
            result.put(word, position_and_order);
        });

        // search lines and columns in "transposed soup"
        searchLines(soup_transposed).forEach((word, position) -> {
            Integer[] position_and_order = {position[1], position[0],
                                            position[2], -1};
            result.put(word, position_and_order);
        });

        // search diagonals in "normal soup"
        searchDiagonals(soup).forEach((word, position) -> {
            Integer[] position_and_order = {position[1], position[0],
                    position[2], 2};
            result.put(word, position_and_order);
        });

        // search diagonals in "reversed soup"
        searchDiagonals(soup_reversed).forEach((word, position) -> {
            Integer[] position_and_order = {soup.size() - position[1] + 1, position[0],
                    position[2], -2};
            result.put(word, position_and_order);
        });

        return result;
    }

    private Map<String, Integer[]> searchLines(List<String> soup){

        Map<String, Integer[]> result = new SoupMap();

        for(int row_index = 0; row_index < soup.size(); row_index++){
            final int y_index = row_index;

            String current_line = soup.get(row_index);
            String current_line_reversed = new StringBuilder(current_line).reverse().toString();

            findWords(current_line).forEach((word, x_index) ->
                result.put(word, new Integer[]{y_index + 1, x_index + 1, 1})
            );
            findWords(current_line_reversed).forEach((word, x_index) ->
                result.put(word, new Integer[]{y_index + 1, soup.size() - x_index, -1})
            );
        }

        return result;
    }

    private Map<String, Integer[]> searchDiagonals(List<String> soup){

        Map<String, Integer[]> result = new SoupMap();
        StringBuilder diagonal_builder_bottom_triangle,
                        diagonal_builder_upper_triangle;

        for(int row_index = 0; row_index < soup.size(); row_index++){
            final int y_index = row_index;
            diagonal_builder_bottom_triangle = new StringBuilder();
            diagonal_builder_upper_triangle = new StringBuilder();

            for(int col_index = 0; col_index < (soup.size() - row_index); col_index++){
                diagonal_builder_bottom_triangle.append(soup.get(row_index + col_index).charAt(col_index));
                if(row_index > 0)
                    diagonal_builder_upper_triangle.append(soup.get(col_index).charAt(row_index + col_index));
            }

            // find diagonals in bottom triangle of soup
            findWords(diagonal_builder_bottom_triangle.toString()).forEach((word, x_index) ->
                    result.put(word, new Integer[]{x_index + 1, y_index + x_index + 1, 2})
            );
            // find diagonals in upper triangle of soup
            findWords(diagonal_builder_upper_triangle.toString()).forEach((word, x_index) ->
                    result.put(word, new Integer[]{y_index + x_index + 1, x_index + 1, 2})
            );
            // find reversed diagonals in bottom triangle of soup
            findWords(diagonal_builder_bottom_triangle.reverse().toString()).forEach((word, x_index) ->
                    result.put(word, new Integer[]{soup.size() - (y_index + x_index), soup.size() - x_index, -2})
            );
            // find reversed diagonals in upper triangle of soup
            findWords(diagonal_builder_upper_triangle.reverse().toString()).forEach((word, x_index) ->
                    result.put(word, new Integer[]{soup.size() - x_index, soup.size() - (y_index + x_index), -2})
            );
        }

        return result;
    }

    private Map<String, Integer> findWords(String line){

        Map<String, Integer> result = new TreeMap<>();
        for(int n = 0; n < words.size(); n++){
            int index = line.indexOf(words.get(n));

            if(index >= 0)
                result.put(words.get(n), index);
        }

        return result;
    }

    private void transposeSoup(){

        soup_transposed = new ArrayList<>();

        for(int col_index = 0; col_index < soup.size(); col_index++){
            final int current_col_index = col_index;
            StringBuilder col_builder = new StringBuilder();

            soup.forEach(line -> col_builder.append(line.charAt(current_col_index)));

            soup_transposed.add(col_builder.toString());
        }
    }

    private void reverseSoup(){

        soup_reversed = new ArrayList<>(soup);
        Collections.reverse(soup_reversed);
    }
}
