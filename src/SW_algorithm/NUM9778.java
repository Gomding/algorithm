package SW_algorithm;

/*

SW Expert - 9778. 카드게임

https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXE0YJiK3QcDFAVX&categoryId=AXE0YJiK3QcDFAVX&categoryType=CODE

[문제]

카드 게임을 좋아하는 승현이는 요즘 블랙잭에 빠져 있다. 잘생긴 승현이와 함께 블랙잭의 규칙을 알아보자!

블랙잭을 처음 시작할 때, 덱에는 2, 3, 4, 5, 6, 7, 8, 9의 가치를 가지는 카드가 각각 4장,

11의 가치를 가지는 카드(Ace) 4장, 10의 가치를 가지는 카드 16장 (Ten, Jack, Queen, King), 총 52장의 카드가 올려져 있다.

맨 처음에 모든 카드는 가치를 알 수 없게 뒤집어져 있다.

승현이는 선택한 카드들의 가치의 합이 21을 넘지 않으면서도 가능한 가치의 합이 커지도록 카드를 뽑고 싶다.

지금 승현이는 이미 N장의 카드를 뽑아서 덱에는 52-N장의 카드가 남아 있으며, 승현이는 여기서 카드를 한 장 더 뽑을 지 말지 고민하고 있다.

승현이는 덱에 남아있는 카드 중 하나를 뽑았을 때,

"뽑은 모든 카드의 가치의 합이 21보다 크게 만드는 카드의 개수"가 "뽑았을 때 가치의 합을 21 이하로 만드는 카드의 개수"보다 크거나 같다면 게임을 그만 둘 것이다.

승현이가 뽑은 모든 카드의 가치가 주어질 때, 승현이가 게임을 그만 둬야 하는지 판단해주자!


[입력]

첫 번째 줄에 테스트 케이스의 수 TC가 주어진다.

이후 TC개의 테스트 케이스는 각각 다음과 같은 구성과 조건을 따른다.

        - 첫 번째 줄에는 카드의 개수 N이 주어진다. (1 ≤ N ≤ 52)

        - 이후 N개의 줄에 승현이가 뽑아 놓은 카드의 가치가 주어진다.

        - 문제에 주어진 조건에서 벗어나는 경우의 입력은 존재하지 않는다.
             (각 카드의 가치는 모두 2이상 11이하의 정수이며, 2가 5번 이상 등장하지 않는 등)

[출력]


각 테스트 케이스마다 ‘#t’( t 는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,

승현이가 게임을 그만 둬야 한다면 “STOP”을, 계속 해도 된다면 “GAZUA”를 출력한다.


입력
3
6
2
3
2
3
2
3
1
10
2
6
5

출력
#1 STOP
#2 GAZUA
#3 GAZUA

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NUM9778 {

    static public void deck() {
        for (int i = 2; i < 12; i++) {
            cards[i] = 4;
        }
        cards[10] += 12;
    }

    static int N, M, hand, up;
    static int[] cards;
    static String shout;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());


        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(bf.readLine());
            M = 52 - N;

            cards = new int[12];

            deck();

            hand = 0;

            for (int i = 0; i < N; i++) {
                int now = Integer.parseInt(bf.readLine());
                cards[now]--;
                hand += now;
            }

            up = 0;

            for (int i = 21 - hand + 1; i < 12; i++) {
                up += cards[i];
            }

            shout = "GAZUA";

            if (up * 2 - M >= 0) {
                shout = "STOP";
            }

            System.out.println("#" + tc + " " + shout);

        }
    }
}
