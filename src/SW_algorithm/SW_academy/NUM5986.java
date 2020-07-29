package SW_algorithm.SW_academy;

/*

SW Expert - NO.5986 새샘이와 소수

https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWaJ3q8qV-4DFAUQ&categoryId=AWaJ3q8qV-4DFAUQ&categoryType=CODE&&&

정수론에서, 세 소수 문제란 다음과 같다.

“5보다 큰 모든 홀수는 정확히 세 소수의 합으로 표현될 수 있다. (같은 소수를 합에 사용해도 된다.)”

예를 들어, 7 = 2 + 2 + 3, 11 = 2 + 2 + 7, 25 = 7 + 7 + 11로 나타낼 수 있다.

1939년 러시아 수학자 I. M. Vinogradov는 충분히 큰 홀수는 세 소수의 합으로 표현할 수 있다는 것을 증명했다.

여기서 충분히 크다는 것은 3의 3승의 15승 ≈ 10의 7000000승 이상의 수라는 의미이다.

현재 가장 발전된 하한은 약 e의 3100 승 ≈ 10의 1346승  이상의 수이다.

러시아 수학자 I. M. Vinogradov 를 존경하는 새샘이는 직접 세 소수 문제를 풀어보기로 했다.

하지만 이 수는 너무 크기 때문에 컴퓨터로도 이 범위까지의 모든 수를 증명할 수는 없었다.

대신 어떤 크지 않은 홀수에 대해, 세 소수의 합으로 나타낼 수 있는 경우의 수를 구하기로 했다.

5보다 큰 홀수 N을 입력 받아 N = x + y + z (단, x ≤ y ≤ z 이고, x, y, z는 소수) 로 나타나는 경우의 수를 구하는 프로그램을 작성

하라.

[입력]

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

각 테스트 케이스의 첫 번째 줄에 하나의 정수 N ( 7 ≤ N ≤ 999 ) 이 주어진다.

N은 홀수이다.


[출력]

각 테스트 케이스마다 첫 번째 줄에는 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,

N을 세 소수의 합으로 나타낼 수 있는 경우의 수를 출력한다.


입력
3
7
11
25

출력
#1 1
#2 2
#3 5

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class NUM5986 {

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());
        int N;  // 5보다 큰 모든 홀수 중 입력받는 숫자 7 <= N <= 999
        int result = 0; // 세소수의 경우의 수
        int x;  // 세 소수의 값 x <= y <= z
        int y;
        int z;

        ArrayList<Integer> cNum = new ArrayList<Integer>(); // 소수를 담을 배열

        cNum.add(2);

        for (int i = 3; i < 1000; i++) {
            for (int j = 0; j < cNum.size(); j++) {
                if (i % cNum.get(j) == 0)   // i 를 i 보다 작은 소수로 나눴을 때 몫이 있다면 소수가 아니므로 break
                    break;
                if (j == cNum.size() - 1)   // cNum 배열의 끝까지 검사했는데 소수로 판정 됐다면
                    cNum.add(i);
            }
        }

        int[] map = new int[1000];
        for (int i = 0; i < cNum.size(); i++) {
            x = cNum.get(i);
            for (int j = i; j < cNum.size(); j++) {
                y = cNum.get(j);
                for (int k = j; k < cNum.size(); k++) {
                    z = cNum.get(k);
                    int sum = x + y + z;
                    if (sum < 1000) {
                        map[sum]++;
                    }
                }
            }
        }

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(bf.readLine());
            System.out.println("#" + tc + " " + map[N]);
        }
    }
}
