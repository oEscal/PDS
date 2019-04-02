package aula01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class GoodVersion {

    private static int SOAP_MAX_SIZE = 60;

    public static void main(String args[]){

        List<String> options = List.of(args);

        if(options.contains("-s")){
            int index_option = options.indexOf("-s");
            int index_soup_file = index_option + 1;

            if(options.size() <= index_soup_file)
                optionsError();

            String file_name = options.get(index_option + 1);

            resolveSoap(file_name);
        }else
            if(options.contains("-g")){
                int index_option = options.indexOf("-g");
                int index_words_file = index_option + 1;    // word's file is always the first argument
                int index_soup_size = options.size() - 1;   // soup size is always the last argument
                int index_file_save = options.size() - 2;   // file to save is always the penultimate argument

                String words_file_name;
                String result_file_name = "-terminal-";
                int soup_size;

                // verify if arguments of this options exists
                if(options.size() <= index_words_file ||
                        ((options.size() - index_soup_size - 1 == 0)  && !stringIsNumber(options.get(index_soup_size))))
                    optionsError();

                words_file_name = options.get(index_words_file);
                soup_size = Integer.parseInt(options.get(index_soup_size));

                if(options.size() - index_file_save - 1 == 1)
                    result_file_name = options.get(index_file_save);

                generateSoap(words_file_name, result_file_name, soup_size);
            }
    }

    private static void optionsError(){
        System.err.println("Error in arguments!\n\n" +
                "Usages (arguments inside [] are required and arguments inside <> are optional):\n" +
                "$ java aula01.GoodVersion -g [words_file] <result_file> [soup_size]\n" +
                "\t\t\tor\n" +
                "$ java aula01.GoodVersion -s [soup_file]");
        System.exit(1);
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

        SoupSolver soup_solver = new SoupSolver(soap, words);
        results = soup_solver.solve();
        final_time = System.currentTimeMillis();

        // verify if all words are in the soap
        words.forEach(word -> {
            if(!results.containsKey(word)){
                System.out.println(word);
                ErrorsSoap.duplicationInPuzzleError();
            }
        });

        // print results table
        System.out.println("Elapsed time (secs): " + (final_time - initial_time)/1000.0);
        words.forEach(word -> {
            Integer[] positions_and_directions = results.get(word);
            String direction = readDirection(positions_and_directions[2], positions_and_directions[3]);

            // print one line of table's result
            System.out.printf("%-15s %d %6d,%-6d %s\n",
                    word, word.length(), positions_and_directions[0], positions_and_directions[1], direction);
        });
    }

    private static void generateSoap(String words_file_name, String file_name_save, int soap_size){

        List<String> words = new ArrayList<>();
        List<List<Character>> soap;
        List<String> words_file_lines = readFileLines(words_file_name);

        words_file_lines.forEach(line -> createWordsListFromLine(line, words));


        SoupGenerator soap_generator = new SoupGenerator(words, soap_size);
        soap = soap_generator.generate();
        writeSoapToFile(file_name_save, soap, words);
    }

    private static void separateSoapWords(List<String> lines, List<String> soap, List<String> words){

        lines.forEach(line -> {
            if(soap.size() == 0 ||  soap.size() < soap.get(0).length()) {
                // verify soap's size
                if(soap.size() > SOAP_MAX_SIZE)
                    ErrorsSoap.sizeError();

                // verify soap letters's case
                if(!line.equals(line.toUpperCase()))
                    ErrorsSoap.puzzleCaseError();

                soap.add(line);
            }
            else
                createWordsListFromLine(line, words);

        });
    }

    private static void createWordsListFromLine(String line, List<String> words){

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
                        ErrorsSoap.duplicatedOrRedundantWordsError();
                });

                // verify if there are non alphabetic characters
                if(item.matches("^.*[^a-zA-Z].*$")){
                    System.out.println(item);
                    ErrorsSoap.alphabeticCharsError();
                }

                // verify if words have at least three characters
                if(item.length() < 3)
                    ErrorsSoap.wordsSizeError();

                words.add(item.toUpperCase());
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

    private static void writeSoapToFile(String file_name, List<List<Character>> soap, List<String> words) {

        Path path_file = Paths.get(file_name);
        StringBuilder soap_string_builder = new StringBuilder();

        // create a string with the soap generated
        soap.forEach(list -> {
            list.forEach(letter -> soap_string_builder.append(letter));
            soap_string_builder.append('\n');
        });

        // put the words in the soap generated string
        words.forEach(word -> soap_string_builder.append(word.toLowerCase() + ","));

        // write to terminal or file
        if(file_name.equals("-terminal-"))
            System.out.println(soap_string_builder.toString());
        else
            try {
                Files.write(path_file, soap_string_builder.toString().getBytes());
            }catch(IOException e) {
                System.out.println("Error in file opening!");
            }
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

    private static boolean stringIsNumber(String v){
        return v.chars().allMatch(Character::isDigit);
    }
}
