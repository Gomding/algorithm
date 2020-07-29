package SW_algorithm.SW_academy;

/*
SW Expert NO.8189 우편함

https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWwtU7XqhL0DFAWU&categoryId=AWwtU7XqhL0DFAWU&categoryType=CODE


최고의 인기남 선표에게는 많은 팬들이 있고, 이 팬들은 하루에 수십 통의 팬레터를 보낸다.

처음에는 열과 성의를 다해 팬레터를 확인했던 선표지만, 몇 년 동안 계속해서 우편을 확인하면서 너무 지쳐버렸다.

그래서 요즘에는 가끔씩 우편함을 비워줄 뿐이다.

선표는 우편함에 쌓인 편지의 개수가 A개 이상이거나, 가장 오래 기다린 편지가 정확히 B시간 전에 온 편지면 우편함을 비우러 간다.

우편함을 한 번 비울 때, 우편함에 있는 모든 편지를 보는 것은 귀찮기 때문에, 절반 정도의 편지를 확인한다.

정확히 말하자면, 우편함에 편지가 k개 있을 때, 정확히  ⌈k/2⌉개의 편지를 확인한다. 확인하는 편지를 확인할 때는 받은 지 가장 오래된 것부터 확인한다. ( ⌈ ⌉ 기호는 올림을 뜻한다)

선표는 읽는 속도가 매우 빠르기 때문에 편지 읽는 시간은 0이다.

각 편지가 오는 시간이 주어질 때, 각 편지를 선표가 확인하는 시간을 구하는 프로그램을 작성하라.


[입력]

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 세 정수 N, A, B(1 ≤ N, A ≤ 100, 1 ≤ B ≤ 1,000)이 공백 하나로 구분되어 주어진다.

N은 오늘 오는 편지의 개수를 나타낸다.

두 번째 줄에는 N개의 정수 t1, t2, ⋯, tN (1 ≤ t1 < t2 < ⋯ < tN ≤ 1,000)이 공백 하나로 구분되어 주어진다.

ti는 i번째 편지가 온 시간이고, 같은 시간에 도착하는 편지는 없다.


[출력]

각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,

각 테스트 케이스마다 N개의 정수를 공백 하나로 구분하여 출력한다.

i번째 정수는 i번째 편지를 확인하는 시간이어야 한다.

입력
2
4 100 10
1 2 3 4
8 4 50
1 2 3 4 50 90 91 100

출력
#1 11 11 13 14
#2 4 4 53 53 100 100 141 150


 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NUM8189 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        int[] postBox; // 우편함 idx값 = 편지의 순서, 각 배열의 값 = 편지가 도착한 시간
        int N;         // 편지의 개수
        int A;         // 우편함을 지우는 편지의 기준 개수
        int B;         // 우편함에 가장 오래된 편지가 B시간 전에 도착하면 삭제

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int postBoxCnt = 0; // 우편함에 있는 개수
            int hour = 1;       // 현재 시간

            N = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            postBox = new int[N];

            for (int i = 0; i < N; i++) {
                postBox[i] = Integer.parseInt(st.nextToken());
            }

            int lastTime = postBox[N - 1] + B + 1;

            System.out.print("#" + tc + " ");

            while (hour < lastTime) {
                for(int i = 0; i < N; i++) {
                    if(postBox[i] == hour)  postBoxCnt++;
                }
                if(postBoxCnt == A || hour == postBox[0] + B) {
                    int letterChkNum = Math.round((float)postBoxCnt / 2);
                    if(letterChkNum == 0) {
                        letterChkNum = 1;
                    }

                    for (int j = 0; j < letterChkNum; j++)
                        System.out.print(hour + " ");
                    for (int k = 0; k < N - letterChkNum; k++) {
                        postBox[k] = postBox[k + letterChkNum];
                        postBox[k + letterChkNum] = 0;
                    }
                    postBoxCnt -= letterChkNum;
                }

                hour++;
            }


        }
    }
}
