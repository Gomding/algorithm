package SW_algorithm;

/*

SW Expert - 1860. 진기의 최고급 붕어빵

https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LsaaqDzYDFAXc&categoryId=AV5LsaaqDzYDFAXc&categoryType=CODE&&&

진기는 붕어빵 가게를 운영하고 있다.

진기가 파는 붕어빵은 그냥 붕어빵이 아니라 겉은 바삭! 속은 말랑! 한입 물면 팥 앙금이 주르륵 흘러 입안에서 춤을 추며,

절로 어릴 적 호호 불며 먹었던 뜨거운 붕어빵의 추억이 떠올라 눈물이 나오게 되는 최고급 붕어빵이다.

진기는 이런 붕어빵을 보통 사람들에게는 팔지 않는다.

그는 무조건 예약제로만 손님을 받으며, 예약을 하려는 손님들은 진기의 까다로운 자격 검증에서 합격해야만 붕어빵을 맛 볼 자격을 얻는다.

그래서 오늘은 N명의 사람이 자격을 얻었다.

진기는 0초부터 붕어빵을 만들기 시작하며, M초의 시간을 들이면 K개의 붕어빵을 만들 수 있다.

서빙은 진기가 하는 것이 아니기 때문에, 붕어빵이 완성되면 어떤 시간 지연도 없이 다음 붕어빵 만들기를 시작할 수 있다.

0초 이후에 손님들이 언제 도착하는지 주어지면, 모든 손님들에게 기다리는 시간없이 붕어빵을 제공할 수 있는지 판별하는 프로그램을 작성하라.


[입력]

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 세 자연수 N, M, K(1 ≤ N, M, K ≤ 100)가 공백으로 구분되어 주어진다.

두 번째 줄에는 N개의 정수가 공백으로 구분되어 주어지며,

각 정수는 각 사람이 언제 도착하는지를 초 단위로 나타낸다. 각 수는 0이상 11,111이하이다.


[출력]

각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,

모든 손님에 대해 기다리는 시간이 없이 붕어빵을 제공할 수 있으면 “Possible”을, 아니라면 “Impossible”을 출력한다.


[예제 풀이]

2번째 테스트 케이스의 경우, 2초가 지날 때마다 붕어빵을 2개씩 만들 수 있다.

하지만 손님 1명은 1초에 도착하므로 이 손님에게는 붕어빵을 바로 제공할 수 없다.

따라서 결과값으로 Impossible 출력한다.

입력
4
2 2 2
3 4
2 2 2
1 2
2 2 1
4 2
2 2 1
3 2

출력
#1 Possible
#2 Impossible
#3 Possible
#4 Impossible


 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NUM1860 {

    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());
        int N;  // 예약 손님의 수
        int M;  // 붕어빵을 만드는데 걸리는 시간
        int K;  // M 초가 지났을 때 만들어지는 붕어빵의 개수
        int max;
        int bread;  // 현재 만들어진 빵의 개수
        String result;

        int[] reg;  // 예약 기록

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            reg = new int[11112];

            max = 0;
            bread = 0;

            st = new StringTokenizer(bf.readLine());

            for (int i = 0; i < N; i++) {       // 손님이 몇초에
                int a = Integer.parseInt(st.nextToken());
                reg[a]++;
                if (a > max) max = a;
            }

            result = "Impossible";

            if (reg[0] == 0) {
                for (int i = 0; i <= max; i++) {
                    if (i != 0 && i % M == 0) {
                        bread += K;
                    }
                    if (reg[i] > 0) {
                        if (bread >= reg[i]) {
                            result = "Possible";
                            bread -= reg[i];
                        } else {
                            result = "Impossible";
                            break;
                        }
                    }
                }
            }

            System.out.println("#" + tc + " " + result);
        }
    }
}
