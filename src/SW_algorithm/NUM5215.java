package SW_algorithm;

/*

SW Expert NO.5215 햄버거 다이어트

https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWT-lPB6dHUDFAVT&categoryId=AWT-lPB6dHUDFAVT&categoryType=CODE

평소 햄버거를 좋아하던 민기는 최근 부쩍 늘어난 살 때문에 걱정이 많다.

그렇다고 햄버거를 포기할 수 없었던 민기는 햄버거의 맛은 최대한 유지하면서 정해진 칼로리를 넘지 않는 햄버거를 주문하여 먹으려고 한다.


민기가 주로 이용하는 햄버거 가게에서는 고객이 원하는 조합으로 햄버거를 만들어서 준다.

하지만 재료는 미리 만들어서 준비해놓기 때문에 조합에 들어가는 재료를 잘라서 조합해주지는 않고, 재료를 선택하면 준비해놓은 재료를 그대로 사용하여 조합해준다.

민기는 이 가게에서 자신이 먹었던 햄버거의 재료에 대한 맛을 자신의 오랜 경험을 통해 점수를 매겨놓았다.

민기의 햄버거 재료에 대한 점수와 가게에서 제공하는 재료에 대한 칼로리가 주어졌을 때,

민기가 좋아하는 햄버거를 먹으면서도 다이어트에 성공할 수 있도록 정해진 칼로리 이하의 조합 중에서 민기가 가장 선호하는 햄버거를 조합해주는 프로그램을 만들어보자.

(단 여러 재료를 조합하였을 햄버거의 선호도는 조합된 재료들의 맛에 대한 점수의 합으로 결정되고, 같은 재료를 여러 번 사용할 수 없으며, 햄버거의 조합의 제한은 칼로리를 제외하고는 없다.)



[입력]


첫 번째 줄에 테스트 케이스의 수 T가 주어진다.


각 테스트 케이스의 첫 번째 줄에는 재료의 수, 제한 칼로리를 나타내는 N, L(1 ≤ N ≤ 20, 1 ≤ L ≤ 104)가 공백으로 구분되어 주어진다.


다음 N개의 줄에는 재료에 대한 민기의 맛에 대한 점수와 칼로리를 나타내는 Ti, Ki(1 ≤ Ti ≤ 103, 1 ≤ Ki ≤ 103)가 공백으로 구분되어 주어진다.


[출력]

각 줄마다 "#T" (T는 테스트 케이스 번호)를 출력한 뒤, 주어진 제한 칼로리 이하의 조합중에서 가장 맛에 대한 점수가 높은 햄버거의 점수를 출력한다.

입력
1
5 1000
100 200
300 500
250 300
500 1000
400 400

출력
#1 750

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NUM5215 {

    public static int search(int[] kals, int[] points, int kal, int point, int j, int N, int L, int result) {
        for (; j < N; j++) {
            int po = point + points[j];
            int ka = kal + kals[j];
            if (ka <= L) {
                if (po > result)
                    result = po;
            }
            result = search(kals, points, ka, po, j + 1, N, L, result);
        }
        return result;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        int N;              // 재료의 수
        int L;              // 칼로리 제한
        int[] points;       // 점수표      각 인덱스는 재료 번호를 나타냄
        int[] kals;         // 칼로피표     각 인덱스는 재료 번호를 나타냄
        int result;

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            N = Integer.parseInt(st.nextToken());   // 재료의 개수를 입력받음
            L = Integer.parseInt(st.nextToken());   // 칼로리의 제한을 입력받음

            points = new int[N];
            kals = new int[N];

            for (int i = 0; i < N; i++) {   // 재료의 점수와 칼로리를 입력받음
                st = new StringTokenizer(bf.readLine());
                points[i] = Integer.parseInt(st.nextToken());
                kals[i] = Integer.parseInt(st.nextToken());
            }

            result = 0;

            result = search(kals, points, 0, 0, 0, N, L, result);

            System.out.println("#" + tc + " " + result);

        }
    }
}
