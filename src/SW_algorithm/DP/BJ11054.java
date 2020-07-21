package SW_algorithm.DP;

/*

DP 백준 11054 - 가장 긴 바이토닉 부분 수열

https://www.acmicpc.net/problem/11054

문제
수열 S가 어떤 수 Sk를 기준으로 S1 < S2 < ... Sk-1 < Sk > Sk+1 > ... SN-1 > SN을 만족한다면, 그 수열을 바이토닉 수열이라고 한다.

예를 들어, {10, 20, 30, 25, 20}과 {10, 20, 30, 40}, {50, 40, 25, 10} 은 바이토닉 수열이지만,  {1, 2, 3, 2, 1, 2, 3, 2, 1}과 {10, 20, 30, 40, 20, 30} 은 바이토닉 수열이 아니다.

수열 A가 주어졌을 때, 그 수열의 부분 수열 중 바이토닉 수열이면서 가장 긴 수열의 길이를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 수열 A의 크기 N이 주어지고, 둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ N ≤ 1,000, 1 ≤ Ai ≤ 1,000)

출력
첫째 줄에 수열 A의 부분 수열 중에서 가장 긴 바이토닉 수열의 길이를 출력한다.

예제 입력 1
10
1 5 2 1 4 3 4 5 2 1

예제 출력 1
7

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11054 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int[] nums = new int[N + 1];

        int[][] dp = new int[N + 1][3]; // 1번 증가하는 수열
                                        // 2번 바이토닉 수열
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            dp[i][1] = 1;
            dp[i][2] = 1;
            for (int j = 1; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i][1] = Math.max(dp[j][1] + 1, dp[i][1]);
                    dp[i][2] = Math.max(dp[i][1], dp[i][2]);
                }
                if (nums[i] < nums[j]) {
                    dp[i][2] = Math.max(dp[i][2], dp[j][2] + 1);
                }
            }

        }

        int max = 0;

        for (int i = 1; i <= N; i++){
            max = Math.max(max, dp[i][2]);
        }

        System.out.println(max);

    }

}
