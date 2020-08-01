package SW_algorithm.DP;

/*

DP 백준 2167 - 2차원 배열의 합

문제
2차원 배열이 주어졌을 때 (i, j) 위치부터 (x, y) 위치까지에 저장되어 있는 수들의 합을 구하는 프로그램을 작성하시오. 배열의 (i, j) 위치는 i행 j열을 나타낸다.

입력
첫째 줄에 배열의 크기 N, M(1 ≤ N, M ≤ 300)이 주어진다. 다음 N개의 줄에는 M개의 정수로 배열이 주어진다. 배열에 포함되어 있는 수는 절댓값이 10,000보다 작거나 같은 정수이다. 그 다음 줄에는 합을 구할 부분의 개수 K(1 ≤ K ≤ 10,000)가 주어진다. 다음 K개의 줄에는 네 개의 정수로 i, j, x, y가 주어진다(i ≤ x, j ≤ y).

출력
K개의 줄에 순서대로 배열의 합을 출력한다. 배열의 합은 231-1보다 작거나 같다.

예제 입력 1
2 3
1 2 4
8 16 32
3
1 1 2 3
1 2 1 2
1 3 2 3

예제 출력 1
63
2
36

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2167 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][M + 1];
        int[][] dp = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j] + map[i][j] - dp[i - 1][j - 1];
            }
        }

        int K = Integer.parseInt(bf.readLine());

        for (int k = 1; k <= K; k++) {
            st = new StringTokenizer(bf.readLine());
            int I = Integer.parseInt(st.nextToken());
            int J = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            System.out.println(dp[X][Y] - dp[X][J - 1] - dp[I - 1][Y] + dp[I - 1][J -1]);

        }

    }
}