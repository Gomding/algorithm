package Programmers;

import java.util.Arrays;

public class HIndex {

    public static void main(String[] args) {

        int[] input1 = {3, 0, 6, 1, 5};
        int[] input2 = {2, 10, 13, 1, 0};
        int[] input3 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] input4 = {5, 5, 5, 5};

        System.out.println(solution(input1));
        System.out.println(solution(input2));
        System.out.println(solution(input3));
        System.out.println(solution(input4));
    }

    public static int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        int size = citations.length;

        loop:
        for (int h = Math.min(size, citations[size - 1]); h >= 0; h--) {
            for (int i = size - 1; i >= 0; i--) {

                int num = citations[i];

                if (num < h) break;

                if (size - i >= h) {
                        answer = h;
                        break loop;
                }

            }
        }

        return answer;
    }

    /*

    public int solution(int[] citations) {
        Arrays.sort(citations);

        int max = 0;
        for(int i = citations.length-1; i > -1; i--){
            int min = (int)Math.min(citations[i], citations.length - i);
            if(max < min) max = min;
        }

        return max;
    }

     */

}
