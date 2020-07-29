package SW_algorithm.SW_academy;

/*

SW Expert NO5431 - 민석이의 과제 체크하기

https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWVl3rWKDBYDFAXm&categoryId=AWVl3rWKDBYDFAXm&categoryType=CODE

민석이는 교수가 되었고, 이번에 처음으로 맡은 과목에 수강생이 N명이다.

민석이는 처음으로 과제를 내었다.

그리고 제출한 사람의 목록을 받았다.

수강생들은 1번에서 N번까지 번호가 매겨져 있고, 어떤 번호의 사람이 제출했는지에 대한 목록을 받은 것이다.

과제를 제출하지 않은 사람의 번호를 오름차순으로 출력하는 프로그램을 작성하라.


[입력]

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 수강생의 수를 나타내는 정수 N(2≤N≤100)과 과제를 제출한 사람의 수를 나타내는 정수 K(1≤K≤N)가 공백으로 구분되어 주어진다.

두 번째 줄에는 과제를 제출한 사람의 번호 K개가 공백으로 구분되어 주어진다. 번호는 1이상 N이하의 정수이며 같은 번호가 두 번 이상 주어지는 경우는 없다.


[출력]

각 테스트 케이스마다 과제를 제출하지 않은 사람의 번호를 오름차순으로 출력한다.

입력
2
5 3
2 5 3
7 2
4 6

출력
#1 1 4
#2 1 2 3 5 7

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NUM5431 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        int N;
        int K;
        List<Integer> report;

        for (int tc = 1; tc <= T; tc++) {

            StringBuilder sb = new StringBuilder();

            sb.append("#" + tc + " ");

            StringTokenizer st = new StringTokenizer(bf.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            report = new ArrayList<Integer>();

            st = new StringTokenizer(bf.readLine());

            for (int i = 0; i < K; i++) {
                report.add(Integer.parseInt(st.nextToken()));
            }

            for (int i = 1; i <= N; i++) {
                if (report.indexOf(i) != -1)
                    continue;
                sb.append(i + " ");
            }

            System.out.println(sb);

        }

    }
}
