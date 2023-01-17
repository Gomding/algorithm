package Programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        String[] input1 = {"119", "97674223", "1195524421"};
        String[] input2 = {"123", "456", "789"};

        System.out.println(phoneBook.solution2(input1));
        System.out.println(phoneBook.solution2(input2));
    }

    public boolean solution2(String[] input) {
        Map<String, Integer> map = new HashMap<>();
        for (String phoneNumber : input) {
            for (int i =1; i < phoneNumber.length() + 1; i++) {
                String currentWord = phoneNumber.substring(0, i);
                map.put(currentWord, map.getOrDefault(currentWord, 0) + 1);
            }
        }
        return Arrays.stream(input).allMatch(it -> map.get(it) == 1);
    }
}
