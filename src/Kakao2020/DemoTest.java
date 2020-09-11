package Kakao2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DemoTest {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] v;

        v = new int[][]{{1, 4}, {3, 4}, {3, 10}};


        int[] result = solution(v);


        System.out.println(result[0] + ", " + result[1]);

    }

    public static int[] solution(int[][] v) {

        int[] answer = new int[2];

        int x1 = v[0][0];
        int y1 = v[0][1];
        int x2 = v[1][0];
        int y2 = v[1][1];
        int x3 = v[2][0];
        int y3 = v[2][1];

        if (x1 == x2) {
            answer[0] = x3;
        } else if (x1 == x3) {
            answer[0] = x2;
        } else {
            answer[0] = x1;
        }


        if (y1 == y2) {
            answer[1] = y3;
        } else if (y1 == y3) {
            answer[1] = y2;
        } else {
            answer[1] = y1;
        }

        return answer;
    }

}
