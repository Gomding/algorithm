package SW_algorithm.DP;

/*

https://www.acmicpc.net/problem/11060

BJ 11060 - 점프 점프

문제
재환이가 1×N 크기의 미로에 갇혀있다. 미로는 1×1 크기의 칸으로 이루어져 있고, 각 칸에는 정수가 하나 쓰여 있다.

i번째 칸에 쓰여 있는 수를 Ai라고 했을 때, 재환이는 Ai이하만큼 오른쪽으로 떨어진 칸으로 한 번에 점프할 수 있다.

예를 들어, 3번째 칸에 쓰여 있는 수가 3이면, 재환이는 4, 5, 6번 칸 중 하나로 점프할 수 있다.

재환이는 지금 미로의 가장 왼쪽 끝에 있고, 가장 오른쪽 끝으로 가려고 한다.

이때, 최소 몇 번 점프를 해야 갈 수 있는지 구하는 프로그램을 작성하시오. 만약, 가장 오른쪽 끝으로 갈 수 없는 경우에는 -1을 출력한다.

입력
첫째 줄에 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄에는 Ai (0 ≤ Ai ≤ 100)가 주어진다.

출력
재환이가 최소 몇 번 점프를 해야 가장 오른쪽 끝 칸으로 갈 수 있는지 출력한다. 만약, 가장 오른쪽 끝으로 갈 수 없는 경우에는 -1을 출력한다.

예제 입력 1
10
1 2 0 1 3 2 1 5 4 2

예제 출력 1
5

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11060 {

    static int N;
    static int[] map;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N + 1];
        dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {

            map[i] = Integer.parseInt(st.nextToken());

        }

        dp[1] = 1;

        for (int i = 1; i <= N; i++) {

            if (dp[i] == 0) {
                continue;
            }

            jump(i);

        }

        for (int i = 1; i <= N; i++) {
            System.out.print(dp[i] + " ");
        }
            System.out.println();

        System.out.println(dp[N] == 0 ? -1 : dp[N] - 1);

    }

    static void jump(int i) {
        for (int j = 1; j <= map[i] && j + i <= N; j++) {
            if (dp[i + j] <= 0 || dp[i + j] > dp[i] + 1) {
                dp[i + j] = dp[i] + 1;
            }
        }
    }

}
