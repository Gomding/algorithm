package SW_algorithm;

/*

DP 다이나믹 프로그래밍

백준 9095 - 1, 2, 3 더하기

https://www.acmicpc.net/problem/9095

문제
정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.

1+1+1+1
1+1+2
1+2+1
2+1+1
2+2
1+3
3+1
정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 11보다 작다.

출력
각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 출력한다.

예제 입력 1
3
4
7
10

예제 출력 1
7
44
274

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9095 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());
        int[] map = new int[11];

        map[1] = 1;
        map[2] = 2;
        map[3] = 4;

        for (int i = 4; i <= 10; i++) {
            map[i] = map[i - 1] + map[i - 2] + map[i - 3];
        }

        for (int tc = 0; tc < T; tc++) {

            int N = Integer.parseInt(bf.readLine());

            System.out.println(map[N]);
        }

    }

}
