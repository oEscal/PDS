import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class GoodVersion {

    private static int SOAP_MAX_SIZE = 60;

    public static void main(String args[]){

        resolveSoap("pratica1/soap.txt");
        List<String> words = new ArrayList<>();

        words.add("list");
        words.add("set");
        words.add("graph");
        words.add("queue");
        words.add("stack");
        words.add("tree");

        System.out.println(SoapGenerator.generate(words, 10));

    }

    private static void resolveSoap(String soap_file_name){
        long initial_time,
                final_time;

        List<String> soap_file_lines;
        List<String> soap = new ArrayList<>();
        List<String> words = new ArrayList<>();

        Map<String, Integer[]> results;


        soap_file_lines = readFileLines(soap_file_name);
        initial_time = System.currentTimeMillis();
        separateSoapWords(soap_file_lines, soap, words);

        results = SoapSolver.solve(soap, words);
        final_time = System.currentTimeMillis();

        // verify if all words are in the soap
        words.forEach(word -> {
            if(!results.containsKey(word))
                ErrorsSoapSolver.duplicationInPuzzleError();
        });

        // print results table
        System.out.println("Elapsed time (secs): " + (final_time - initial_time)/1000.0);
        words.forEach(word -> {
            Integer[] positions_and_directions = results.get(word);
            String direction = readDirection(positions_and_directions[2], positions_and_directions[3]);

            // print one line of table's result
            System.out.printf("%-10s %d %6d,%-6d %s\n",
                    word, word.length(), positions_and_directions[0], positions_and_directions[1], direction);
        });
    }

    private static void separateSoapWords(List<String> lines, List<String> soap, List<String> words){

        lines.forEach(line -> {
            if(soap.size() == 0 ||  soap.size() < soap.get(0).length()) {
                // verify soap's size
                if(soap.size() > SOAP_MAX_SIZE)
                    ErrorsSoapSolver.sizeError();

                // verify soap letters's case
                if(!line.equals(line.toUpperCase()))
                    ErrorsSoapSolver.puzzleCaseError();

                soap.add(line);
            }
            else{
                // separate words
                String[] words_this_line = line.replace(' ', ',')
                                                .replace(';', ',')
                                                .split(",");

                // verify which words are not empty and add them to words list
                Arrays.asList(words_this_line).forEach(item -> {
                    if(item.length() > 0){
                        // verify if there are duplicated or redundant words
                        words.forEach(w -> {
                            if(w.contains(item.toUpperCase()) || item.toUpperCase().contains(w))
                                ErrorsSoapSolver.duplicatedOrRedundantWordsError();
                        });

                        // verify if there are non alphabetic characters
                        if(item.matches("^.*[^a-zA-Z].*$"))
                            ErrorsSoapSolver.alphabeticCharsError();

                        // verify if words have at least three characters
                        if(item.length() < 3)
                            ErrorsSoapSolver.wordsSizeError();

                        words.add(item.toUpperCase());
                    }
                });
            }

        });
    }

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

    private static String readDirection(int x, int y){
        if(y == 1) {
            if (x == 1)
                return "right";
            if (x == -1)
                return "left";
        }

        if(y == -1) {
            if (x == 1)
                return "down";
            if (x == -1)
                return "up";
        }

        if(y == 2){
            if (x == 2)
                return "downright";
            if (x == -2)
                return "upleft";
        }

        if(y == -2){
            if (x == 2)
                return "upright";
            if (x == -2)
                return "downleft";
        }

        return "none";
    }

}
