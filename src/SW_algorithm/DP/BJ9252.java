package SW_algorithm.DP;

/*

DP 백준 9252 - LCS2

https://www.acmicpc.net/problem/9252

문제
LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.

예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.

입력
첫째 줄과 둘째 줄에 두 문자열이 주어진다. 문자열은 알파벳 대문자로만 이루어져 있으며, 최대 1000글자로 이루어져 있다.

출력
첫째 줄에 입력으로 주어진 두 문자열의 LCS의 길이를, 둘째 줄에 LCS를 출력한다.

LCS가 여러 가지인 경우에는 아무거나 출력하고, LCS의 길이가 0인 경우에는 둘째 줄을 출력하지 않는다.

예제 입력 1
ACAYKP
CAPCAK

예제 출력 1
4
ACAK

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9252 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String A = bf.readLine();
        String B = bf.readLine();

        String[][] dp = new String[A.length() + 1][B.length() + 1];

        dp[0][0] = "";

        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (i == 1) {
                    dp[i - 1][j] = "";
                }
                if (j == 1) {
                    dp[i][j - 1] = "";
                }
                if (A.charAt(i - 1) != B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j].length() > dp[i][j - 1].length() ? dp[i - 1][j] : dp[i][j - 1];
                }
                else {
                    dp[i][j] = dp[i - 1][j - 1] + A.charAt(i - 1);
                }
            }
        }


        System.out.println(dp[A.length()][B.length()].length());
        System.out.println(dp[A.length()][B.length()]);

    }
}
