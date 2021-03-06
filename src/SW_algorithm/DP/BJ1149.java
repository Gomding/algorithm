package SW_algorithm.DP;

/*

DP 다이나믹 프로그래밍

백준 11726 - 2xn 타일링

문제
RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.

집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.

1번 집의 색은 2번 집의 색과 같지 않아야 한다.
N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
입력
첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다. 집을 칠하는 비용은 1,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.

예제 입력 1
3
26 40 83
49 60 57
13 89 99

예제 출력 1
96

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1149 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int[][] map = new int[1001][3];
        int[][] list = new int[1001][3];


        StringTokenizer st;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }

        list[1][0] = map[1][0];
        list[1][1] = map[1][1];
        list[1][2] = map[1][2];

        for (int i = 2; i <= N; i++) {
            list[i][0] = Math.min(list[i-1][1], list[i - 1][2]) + map[i][0];
            list[i][1] = Math.min(list[i-1][0], list[i - 1][2]) + map[i][1];
            list[i][2] = Math.min(list[i-1][0], list[i - 1][1]) + map[i][2];
        }

        System.out.println(Math.min(Math.min(list[N][0], list[N][1]), list[N][2]));

    }
}
