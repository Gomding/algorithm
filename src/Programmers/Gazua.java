package Programmers;

import java.util.Arrays;

public class Gazua {

    public static void main(String[] args) {

        int[] input1 = {1, 2, 3, 2, 3};

        System.out.println(Arrays.toString(solution(input1)));

    }

    public static int[] solution(int[] prices) {
        int size = prices.length;

        int[] answer = new int[size];

        /*boolean[] chk = new boolean[size];

        for (int i = 0; i < size; i++) {
            chk[i] = true;
            for (int j = 0; j < i; j++) {
                if (chk[j]) answer[j]++;
                if (prices[j] > prices[i]) chk[j] = false;
            }

        }*/

        for (int i = 0; i < size; i++) {

            int cnt = 0;

            for (int j = i + 1; j < size; j++) {

                if(prices[i] <= prices[j]) cnt++;
                else {
                    cnt++;
                    break;
                }

            }

            answer[i] = cnt;
        }

        return answer;
    }

}
