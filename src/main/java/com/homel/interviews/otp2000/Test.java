package com.homel.interviews.otp2000;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {

    // Задача прочитать файл users.txt и замапить в List<User>
    public List<User> getUsers() {

        List<List<String>> users = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("/Users/mac/Documents/projects/java/leetcode_samples/src/main/java/com/homel/leetcode/samples/interview/otp2000/users.txt"))) {
            String line = br.readLine();

            int counter = 0;
            List<String> user = new ArrayList<>();

            while (line != null) {

                if (counter < 5) {
                    user.add(line);
                    counter++;
                } else {
                    users.add(user);
                    counter = 1;
                    user = new ArrayList<>();
                    user.add(line);
                }
                line = br.readLine();
            }
            if (!user.isEmpty()) {
                users.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<User> result = new ArrayList<>();


        for(List<String> user: users) {
            User userReal = new User(user.get(0), user.get(1), user.get(2), user.get(3), user.get(4));
            result.add(userReal);
        }

        return result;
    }

    public static void main(String[] args) {

        Test test = new Test();
        System.out.println(test.getUsers());

    }
}

class User {
    String firstName;
    String lastName;
    String fName;
    String age;
    String passport;

    public User(String firstName, String lastName, String fName, String age, String passport) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fName = fName;
        this.age = age;
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fName='" + fName + '\'' +
                ", age='" + age + '\'' +
                ", passport='" + passport + '\'' +
                '}';
    }
}
