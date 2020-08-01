package SW_algorithm.DP;

/*

동적 프로그래밍(DP)

백준 1463 - 1로 만들기

문제
정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

X가 3으로 나누어 떨어지면, 3으로 나눈다.
X가 2로 나누어 떨어지면, 2로 나눈다.
1을 뺀다.
정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.

입력
첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어진다.

출력
첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.

예제 입력 1
2

예제 출력 1
1

예제 입력 2
10

예제 출력 2
3

힌트
10의 경우에 10 -> 9 -> 3 -> 1 로 3번 만에 만들 수 있다.


 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1463 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int[] map = new int[1000001];

        for (int i = 2; i <= N; i++) {
            map[i] = map[i - 1] + 1;

            if (i % 2 == 0) {
                map[i] = Math.min(map[i], map[i / 2] + 1);
            }
            if (i % 3 == 0) {
                map[i] = Math.min(map[i], map[i / 3] + 1);
            }
        }

        System.out.println(map[N]);

    }
}