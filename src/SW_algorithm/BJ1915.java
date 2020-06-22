package SW_algorithm;

/*

DP 백준 1915 - 가장 큰 정사각형

https://www.acmicpc.net/problem/1915

문제
n×m의 0, 1로 된 배열이 있다. 이 배열에서 1로 된 가장 큰 정사각형의 크기를 구하는 프로그램을 작성하시오.

0	1	0	0
0	1	1	1
1	1	1	0
0	0	1	0

위와 같은 예제에서는 가운데의 2×2 배열이 가장 큰 정사각형이다.

입력
첫째 줄에 n, m(1 ≤ n, m ≤ 1,000)이 주어진다. 다음 n개의 줄에는 m개의 숫자로 배열이 주어진다.

출력
첫째 줄에 가장 큰 정사각형의 넓이를 출력한다.

예제 입력 1
4 4
0100
0111
1110
0010

예제 출력 1
4

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1915 {

    static int N, M;
    static int[][] map;
    static int[][] dp;
    static String[] nums;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];

        dp = new int[N + 1][M + 1];

        nums = new String[N + 1];

        int max = 0;

        for (int i = 1; i <= N; i++) {
            nums[i] = bf.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(nums[i].substring(j - 1, j));
                if(map[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }

                max = Math.max(max, dp[i][j]);
            }
        }

        System.out.println(max * max);
        bf.close();

    }

}
