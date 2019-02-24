import java.util.*;

public class ChessSolver {

    public static Map<String, Integer[]> solve(List<String> soap, List<String> words){

        Map<String, Integer[]> result = new SoapMap();
        List<String> soap_transposed = transposeSoap(soap);
        List<String> soap_reversed = reverseSoap(soap);

        // search lines and columns in "normal soap"
        searchLines(soap, words).forEach((word, position) -> {
            Integer[] position_and_order = {position[0], position[1],
                                            position[2], 1};
            result.put(word, position_and_order);
        });

        // search lines and columns in "transposed soap"
        searchLines(soap_transposed, words).forEach((word, position) -> {
            Integer[] position_and_order = {position[1], position[0],
                                            position[2], -1};
            result.put(word, position_and_order);
        });

        // search diagonals in "normal soap"
        searchDiagonals(soap, words).forEach((word, position) -> {
            Integer[] position_and_order = {position[1], position[0],
                    position[2], 2};
            result.put(word, position_and_order);
        });

        // search diagonals in "reversed soap"
        searchDiagonals(soap_reversed, words).forEach((word, position) -> {
            Integer[] position_and_order = {soap.size() - position[1] + 1, position[0],
                    position[2], -2};
            result.put(word, position_and_order);
        });

        return result;
    }

    private static Map<String, Integer[]> searchLines(List<String> soap, List<String> words){

        Map<String, Integer[]> result = new SoapMap();

        for(int row_index = 0; row_index < soap.size(); row_index++){
            final int y_index = row_index;

            String current_line = soap.get(row_index);
            String current_line_reversed = new StringBuilder(current_line).reverse().toString();

            findWords(current_line, words).forEach((word, x_index) ->
                result.put(word, new Integer[]{y_index + 1, x_index + 1, 1})
            );
            findWords(current_line_reversed, words).forEach((word, x_index) ->
                result.put(word, new Integer[]{y_index + 1, soap.size() - x_index, -1})
            );
        }

        return result;
    }

    private static Map<String, Integer[]> searchDiagonals(List<String> soap, List<String> words){

        Map<String, Integer[]> result = new SoapMap();
        StringBuilder diagonal_builder_bottom_triangle,
                        diagonal_builder_upper_triangle;

        for(int row_index = 0; row_index < soap.size(); row_index++){
            final int y_index = row_index;
            diagonal_builder_bottom_triangle = new StringBuilder();
            diagonal_builder_upper_triangle = new StringBuilder();

            for(int col_index = 0; col_index < (soap.size() - row_index); col_index++){
                diagonal_builder_bottom_triangle.append(soap.get(row_index + col_index).charAt(col_index));
                if(row_index > 0)
                    diagonal_builder_upper_triangle.append(soap.get(col_index).charAt(row_index + col_index));
            }

            // find diagonals in bottom triangle of soap
            findWords(diagonal_builder_bottom_triangle.toString(), words).forEach((word, x_index) ->
                    result.put(word, new Integer[]{x_index + 1, y_index + x_index + 1, 2})
            );
            // find diagonals in upper triangle of soap
            findWords(diagonal_builder_upper_triangle.toString(), words).forEach((word, x_index) ->
                    result.put(word, new Integer[]{y_index + x_index + 1, x_index + 1, 2})
            );
            // find reversed diagonals in bottom triangle of soap
            findWords(diagonal_builder_bottom_triangle.reverse().toString(), words).forEach((word, x_index) ->
                    result.put(word, new Integer[]{soap.size() - (y_index + x_index), soap.size() - x_index, -2})
            );
            // find reversed diagonals in upper triangle of soap
            findWords(diagonal_builder_upper_triangle.reverse().toString(), words).forEach((word, x_index) ->
                    result.put(word, new Integer[]{soap.size() - x_index, soap.size() - (y_index + x_index), -2})
            );
        }

        return result;
    }

    private static Map<String, Integer> findWords(String line, List<String> words){

        Map<String, Integer> result = new TreeMap<>();
        for(int n = 0; n < words.size(); n++){
            int index = line.indexOf(words.get(n));

            if(index >= 0)
                result.put(words.get(n), index);
        }

        return result;
    }

    private static List<String> transposeSoap(List<String> soap){

        List<String> result = new ArrayList<>();

        for(int col_index = 0; col_index < soap.size(); col_index++){
            final int current_col_index = col_index;
            StringBuilder col_builder = new StringBuilder();

            soap.forEach(line -> col_builder.append(line.charAt(current_col_index)));

            result.add(col_builder.toString());
        }

        return result;
    }

    private static List<String> reverseSoap(List<String> soap){

        List<String> result = new ArrayList<>(soap);
        Collections.reverse(result);

        return result;
    }
}
