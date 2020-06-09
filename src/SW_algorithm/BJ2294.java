package SW_algorithm;

/*

DP 백준 2294 - 동전 2

https://www.acmicpc.net/problem/2294

문제
n가지 종류의 동전이 있다. 이 동전들을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다. 그러면서 동전의 개수가 최소가 되도록 하려고 한다. 각각의 동전은 몇 개라도 사용할 수 있다.

사용한 동전의 구성이 같은데, 순서만 다른 것은 같은 경우이다.

입력
첫째 줄에 n, k가 주어진다. (1 ≤ n ≤ 100, 1 ≤ k ≤ 10,000) 다음 n개의 줄에는 각각의 동전의 가치가 주어진다. 동전의 가치는 100,000보다 작거나 같은 자연수이다. 가치가 같은 동전이 여러 번 주어질 수도 있다.

출력
첫째 줄에 사용한 동전의 최소 개수를 출력한다. 불가능한 경우에는 -1을 출력한다.

예제 입력 1
3 15
1
5
12

예제 출력 1
3

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2294 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int des = Integer.parseInt(st.nextToken());

        int[] map = new int[N + 1];

        int[] dp = new int[des + 1];

        for (int i = 1; i <= des; i++) {
            dp[i] = 100001;
        }

        for (int i = 1; i <= N; i++) {
            map[i] = Integer.parseInt(bf.readLine());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = map[i]; j <= des; j++) {
                dp[j] = Math.min(dp[j], dp[j - map[i]] + 1);
            }
        }


        if (dp[des] == 100001) dp[des] = -1;
        System.out.println(dp[des]);

    }


}
