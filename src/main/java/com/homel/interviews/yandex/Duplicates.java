package com.homel.interviews.yandex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Duplicates {

    public static void main(String[] args) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/mac/Documents/projects/java/leetcode_samples/src/main/java/com/homel/leetcode/samples/interview/yandex/io/duplicates.txt"))) {

            Set<String> result = new HashSet<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.add(line);
            }

            System.out.println(result);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
