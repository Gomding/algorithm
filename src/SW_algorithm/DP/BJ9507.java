package SW_algorithm.DP;

/*

문제
꿍은 군대에서 진짜 할짓이 없다. 그래서 꿍만의 피보나치를 만들어보려고 한다. 기존의 피보나치는 너무 단순해서 꿍은 좀더 복잡한 피보나치를 만들어보고자 한다. 그래서 다음과 같은 피보나치를 만들었다. 꿍만의 피보나치 함수가 koong(n)이라고 할 때,

n < 2 :                         1
n = 2 :                         2
n = 3 :                         4
n > 3 : koong(n − 1) + koong(n − 2) + koong(n − 3) + koong(n − 4)
이다.

여러분도 꿍 피보나치를 구해보아라.

입력
입력의 첫 번째 줄을 테스트 케이스의 개수 t (0 < t < 69)가 주어진다. 다음 t줄에는 몇 번째 피보나치를 구해야하는지를 나타내는 n(0 ≤ n ≤ 67)이 주어진다.

출력
각 테스트 케이스에 대해, 각 줄에 꿍 피보나치값을 출력하라.

예제 입력 1
8
0
1
2
3
4
5
30
67

예제 출력 1
1
1
2
4
8
15
201061985
7057305768232953720

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9507 {

    static long[] dp;
    static int start;

    /*static void koong(int x) {

        for (int i = start; i <= x; i++) {
            dp[i] = (dp[i - 1] * 2) - dp[i - 5];
        }

    }*/

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        dp = new long[68];
        start = 5;

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        dp[4] = 8;

        for (int i = 5; i < 68; i++) {
            dp[i] = dp[i - 1] * 2 - dp[i - 5];
        }


        for (int tc = 1; tc <= T; tc++) {

            int N = Integer.parseInt(br.readLine());

            /*if (dp[N] == 0) {
                koong(N);
                start = N + 1;
            }*/


            System.out.println(dp[N]);

        }

    }

}