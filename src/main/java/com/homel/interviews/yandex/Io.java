package com.homel.interviews.yandex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Io {

    public static void main(String[] args) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/mac/Documents/projects/java/leetcode_samples/src/main/java/com/homel/leetcode/samples/interview/yandex/io/test.txt"))) {

            String a = bufferedReader.readLine();
            String b = bufferedReader.readLine();

            int result = 0;

            for (int i = 0; i < b.length(); i++) {
                char c = b.charAt(i);
                if (a.indexOf(c) >= 0) {
                    result++;
                }
            }

            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
