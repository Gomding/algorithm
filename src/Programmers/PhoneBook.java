package Programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        String[] input1 = {"119", "97674223", "1195524421"};
        String[] input2 = {"123", "456", "789"};

        System.out.println(phoneBook.solution(input1));
        System.out.println(phoneBook.solution(input2));

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
        System.out.println(map);
        return Arrays.stream(input).allMatch(it -> map.get(it) == 1);
    }

    public boolean solution(String[] input) {
        int phoneNumberTotalCount = input.length;

        for (int i = 0; i < phoneNumberTotalCount; i++) {
            String currentPhoneNumber = input[i];

            for (int j = 0; j < phoneNumberTotalCount; j++) {
                String currentTargetPhoneNumber = input[j];
                if (isSkipStatus(currentPhoneNumber, currentTargetPhoneNumber)) {
                    continue;
                }
                if (isMatchedPrefix(currentPhoneNumber, currentTargetPhoneNumber)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isMatchedPrefix(String currentPhoneNumber, String currentTargetPhoneNumber) {
        return currentPhoneNumber.equals(currentTargetPhoneNumber.substring(0, currentPhoneNumber.length()));
    }

    private boolean isSkipStatus(String currentPhoneNumber, String currentTargetPhoneNumber) {
        return isSamePhoneNumber(currentPhoneNumber, currentTargetPhoneNumber) || 
                isLessThanCurrentPhoneNumberLength(currentPhoneNumber, currentTargetPhoneNumber);
    }

    private boolean isLessThanCurrentPhoneNumberLength(String currentPhoneNumber, String currentTargetPhoneNumber) {
        return currentPhoneNumber.length() > currentTargetPhoneNumber.length();
    }

    private boolean isSamePhoneNumber(String currentPhoneNumber, String currentTargetPhoneNumber) {
        return currentPhoneNumber.equals(currentTargetPhoneNumber);
    }
}
