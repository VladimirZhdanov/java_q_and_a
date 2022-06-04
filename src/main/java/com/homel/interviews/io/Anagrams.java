package com.homel.interviews.io;

import java.util.HashSet;
import java.util.Set;

public class Anagrams {

    public int isAnagram(String first, String second) {
        Set<Character> core = new HashSet<>();

        for (char c : first.toCharArray()) {
            core.add(c);
        }

        for (char c : second.toCharArray()) {
            core.add(c);
        }

        return core.size() == first.length() ? 1 : 0;
    }

    public static void main(String[] args) {

        Anagrams anagrams = new Anagrams();
        System.out.println(anagrams.isAnagram("abc", "bac"));
        System.out.println(anagrams.isAnagram("abc", "bac1"));

    }

}
