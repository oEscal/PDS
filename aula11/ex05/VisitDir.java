package aula11.ex05;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class VisitDir extends SimpleFileVisitor<Path> {

    private double sum = 0;
    private Map<String, Double> current_sum = new HashMap<>();
    private List<String> tree = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        sum += file.toFile().length();
        return visitNode(file);
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        String[] path_array = dir.toString().split("/");
        current_sum.put(path_array[path_array.length - 1], sum);

        return visitNode(dir);
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        String[] path_array = dir.toString().split("/");
        current_sum.put(path_array[path_array.length - 1], (sum - current_sum.get(path_array[path_array.length - 1])));

        return FileVisitResult.CONTINUE;
    }

    private FileVisitResult visitNode(Path dir) throws IOException {
        String[] path_array = dir.toString().split("/");
        String result = "";

        for (String l : Arrays.asList(path_array)) {
            result += " ";
        }
        if (path_array.length > 0)
            result += "|->";
        result += path_array[path_array.length - 1];

        if (!Files.isDirectory(dir))
            result += "\t" + Files.size(dir)/1024.0 + "kb";

        tree.add(result);
        return FileVisitResult.CONTINUE;
    }

    public String getString() {
        tree.forEach(l -> {
            if (current_sum.get(l.split("->")[1]) != null)
                System.out.println(l + "\t" + current_sum.get(l.split("->")[1])/1024.0 + "kb");
            else
                System.out.println(l);
        });
        return "";
    }
}
