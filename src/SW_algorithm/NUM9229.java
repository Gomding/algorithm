package SW_algorithm;

/*

SW Expert - 9229. 한빈이와 Spot Mart

https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW8Wj7cqbY0DFAXN&categoryId=AW8Wj7cqbY0DFAXN&categoryType=CODE


한빈이는 퇴근길에 스팟마트에 들러 과자 두 봉지를 사서 양 손에 하나씩 들고 가려고 한다.
스팟마트에는 N개의 과자 봉지가 있으며, 각 과자 봉지는 ai그램의 무게를 가진다.
배가 많이 고픈 한빈이는 최대한 양이 많은 (무게가 많이 나가는) 과자 봉지를 고르고 싶으나,
과자 두 봉지의 무게가 M 그램을 초과하면 무거워서 과자를 들고 다닐 수 없다.
한빈이가 들고 다닐수 있는 과자들의 최대 무게 합을 출력하라. 한빈이는 과자를 “정확히” 두 봉지 사야 함에 유의하라.

[입력]
첫 번째 줄에 테스트 케이스의 수 TC 가 주어진다.
이후 TC 개의 테스트 케이스가 새 줄로 구분되어 주어진다. 각 테스트 케이스는 다음과 같이 구성되었다.
첫 번째 줄에 과자 봉지의 개수와 무게 합 제한을 나타내는 자연수 N, M이 주어진다.
(2 ≤ N ≤ 1000 , 2 ≤ M ≤ 2000000)
이후 N개의 줄에 각 과자봉지의 무게 가 주어진다. (1 ≤ ai ≤ 1000000)

[출력]

각 테스트 케이스마다 ‘#x’(x는 테스트 케이스 번호를 의미, 1부터 시작)를 출력하고,

한빈이가 들고 갈 수 있는 과자 봉지의 무게 합 최대를 출력하라.

만약 한빈이가 두 과자를 들고 갈 방법이 없는 경우에는 -1을출력한다.


입력
4
3 45
20 20 20
6 10
1 2 5 8 9 11
4 100
80 80 60 60
4 20
10 5 10 16

출력
#1 40
#2 10
#3 -1
#4 20

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NUM9229 {

    public static int search(int result, int N, int M, int[]map) {

        loop:
        for (int i = N - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (map[i] + map[j] <= M && map[i] + map[j] > result) {
                    result = map[i] + map[j];
                }
                if(result == M) break loop;
            }
        }

        return result;
    }

    private static int N;      // 과자의 종류
    private static int M;      // 들고갈 수 있는 무게의 제한
    private static int[] map;  // 각 과자의 무게표
    private static int result;

    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(bf.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N];

            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < N; i++) {
                map[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(map);


            result = -1;
            result = search(result, N, M, map);

            System.out.println("#" + tc + " " + result);


        }
    }
}