package aula11.ex05;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main (String args[]) throws IOException {

        Path path = Paths.get("./PDS/src/");
        VisitDir v = new VisitDir();
        Files.walkFileTree(path, v);

        v.getString();
    }
}
