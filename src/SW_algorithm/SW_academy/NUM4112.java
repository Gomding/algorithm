package SW_algorithm.SW_academy;

/*

SW Expert - NO.4112 이상한 피라미드 게임

https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWJHmLraeEwDFAUH

민지가 이상한 피라미드를 발견했다.

이 피라미드는 아래와 같이, 같은 크기의 무수히 많은 원 모양의 방들로 구성되어 있다.



피라미드를 조사하던 중 민지는 보물이 있는 방의 위치를 알아내어 그곳으로 이동하려 한다.

민지는 인접한 방으로만 이동할 수 있으며, 두 방이 인접하려면 두 방 사이에 접점이 존재해야 한다.

예를 들어, 5번 방은 2번, 3번, 4번, 6번, 8번, 9번과는 인접하지만 1번, 7번과는 인접하지 않는다.

또한, 1번 방과 인접한 방은 2번과 3번뿐이다.

1 단위시간에 인접한 한 방으로 이동할 수 있다고 가정하자.

민지와 보물이 있는 방의 위치가 주어질 때, 민지가 보물을 찾을 때까지 걸리는 최소시간을 구하는 프로그램을 작성하시오.


[입력]

첫 번째 줄에 테스트 케이스의 수 T(1 ≤ T ≤ 1,000)가 주어진다.

각 테스트 케이스에 해당하는 줄에는 두 개의 자연수 a, b(1 ≤ a, b ≤ 10,000)가 주어진다. 두 자연수는 각각 민지와 보물이 위치해 있는 방의 번호이다.


[출력]

각 테스트 케이스마다 해당하는 줄에 민지가 보물을 찾아가는데 필요한 최소 단위시간을 출력한다.


 입력
3
5 2
7 7
100 1000

출력
#1 1
#2 0
#3 31

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NUM4112 {

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        int a;          // 민지의 위치
        int b;          // 보물의 위치
        int routeA;     // 양옆 끝의 값 중 왼쪽의 값을 나타냄
        int routeB;     // 양옆 끝의 값 중 오른쪽 값을 나타냄
        int minZA;
        int minZB;
        int plusA;      //
        int plusB;
        int moveCnt;    // 움직인 횟수
        // 시작한 값을 찾으면( routeA <= MinZpos <= routeB 일때)  moveCnt를 0으로 초기화 하고 움직이기 시작함


        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(bf.readLine());

            a = Integer.parseInt(st.nextToken());   // 민지의 위치 입력
            b = Integer.parseInt(st.nextToken());   // 보물의 위치 입력

            routeA = 1; // 첫번째 이동이 + 1
            routeB = 1; // 첫번째 이동이 + 2
            plusA = 1;  // 왼쪽의 이동값
            plusB = 2;  // 오른쪽의 이동값
            moveCnt = 0;    // 이동한 값
            minZA = 0;  // 민지의 왼쪽 이동값
            minZB = 0;  // 민지의 오른쪽 이동값
            if(a != b){
                if (a > b) {
                    int t = a;
                    a = b;
                    b = t;
                }
                while (a > routeB) {
                    routeA += plusA++;
                    routeB += plusB++;
                    if (a >= routeA) {
                        minZA = a;
                        minZB = a;
                    }
                }
                while (b > routeB) {
                    minZA += plusA;
                    minZB += plusB;
                    routeA += plusA++;
                    routeB += plusB++;
                    moveCnt++;
                }

                if (b < minZA) {
                    moveCnt += minZA - b;
                } else if (b > minZB) {
                    moveCnt += b - minZB;
                }
            }

            System.out.println("#" + tc + " " + moveCnt);

        }
    }
}
