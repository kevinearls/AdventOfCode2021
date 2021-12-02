package com.kevinearls.adventofcode2021.common;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MyUtils {
    public static List<String> loadFromFile(String fileName) throws Exception {
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        return lines;
    }

    public static List<Integer> readIntegersFromFile(String fileName) throws Exception {
        List<Integer> values = new ArrayList<>();

        List<String> blah = MyUtils.loadFromFile(fileName);
        for (String b:blah) {
            values.add(Integer.parseInt(b));
        }

        return values;
    }
}
