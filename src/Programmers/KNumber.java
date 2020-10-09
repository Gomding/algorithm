package Programmers;

import java.util.*;

public class KNumber {

    public static void main(String[] args) {

        int[] array1 = {1, 5, 2, 6, 3, 7, 4};
        int[][] command1 = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] result = solution(array1, command1);

        System.out.println(Arrays.toString(result));

    }

    public static int[] solution(int[] array, int[][] commands) {

        int size = commands.length;
        int[] answer = new int[size];

        for (int i = 0; i < size; i++) {
            int a = commands[i][0];
            int b = commands[i][1];
            int k = commands[i][2];

            List<Integer> list = new ArrayList<>();

            for (int j = a - 1; j < b; j++) {
                list.add(array[j]);
            }

            Collections.sort(list, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });

            answer[i] = list.get(k - 1);

        }


        return answer;
    }

}
