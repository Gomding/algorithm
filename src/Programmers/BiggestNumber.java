package Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class BiggestNumber {

    public static void main(String[] args) {

        int[] input1 = {6, 10, 2};
        int[] input2 = {3, 30, 34, 5, 9};

        System.out.println(solution(input1));
        System.out.println(solution(input2));
    }

    public static String solution(int[] numbers) {
        String answer = "";

        int size = numbers.length;

        String[] strings = new String[size];

        for (int i = 0; i < size; i++) {
            strings[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        if (strings[0].charAt(0) == '0') return "0";

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            sb.append(strings[i]);
        }

        answer = sb.toString();

        return answer;
    }

}
