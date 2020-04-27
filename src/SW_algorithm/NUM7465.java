package SW_algorithm;

/*

SW Expert NO.7465 창용 마을 무리의 개수

https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWngfZVa9XwDFAQU&categoryId=AWngfZVa9XwDFAQU&categoryType=CODE&&&

창용 마을에는 N명의 사람이 살고 있다.

사람은 편의상 1번부터 N번 사람까지 번호가 붙어져 있다고 가정한다.

두 사람은 서로를 알고 있는 관계일 수 있고, 아닐 수 있다.

두 사람이 서로 아는 관계이거나 몇 사람을 거쳐서 알 수 있는 관계라면,

이러한 사람들을 모두 다 묶어서 하나의 무리라고 한다.

창용 마을에 몇 개의 무리가 존재하는지 계산하는 프로그램을 작성하라.


[입력]

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 각각 창용 마을에 사는 사람의 수와 서로를 알고 있는 사람의 관계 수를 나타내는

두 정수 N, M(1 ≤ N ≤ 100, 0 ≤ M ≤ N(N-1)/2) 이 공백 하나로 구분되어 주어진다.

이후 M개의 줄에 걸쳐서 서로를 알고 있는 두 사람의 번호가 주어진다.

같은 관계는 반복해서 주어지지 않는다.


[출력]

각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,

무리의 개수를 출력한다.

입력
2
6 5
1 2
2 5
5 1
3 4
4 6
6 8
1 2
2 5
5 1
3 4
4 6
5 4
2 4
2 3

출력
#1 2
#2 1

6 4
1 3
3 2
4 5
3 4

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NUM7465 {

    public static void main(String[] args) throws  Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        int N;      // 마을 사람의 숫자
        int M;      // 마을 사람간의 관계 수
        int[] chk;    // 마을 사람간의 관계 표
        int result;
        int group;
        int[] groups;

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            chk = new int[N + 1];
            groups = new int[N + 1];

            result = 0;
            group = 1;

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (chk[a] > 0 && chk[b] > 0) {
                    if (chk[a] != chk[b]) {
                        result--;
                        if (groups[chk[a]] >= groups[chk[b]]) {
                            int bb = chk[b];
                            for (int j = 1; j < N; j++) {
                                if (chk[j] == bb) chk[j] = chk[a];
                            }
                        }
                        else {
                            int aa = chk[a];
                            for (int j = 1; j < N; j++) {
                                if (chk[j] == aa) chk[j] = chk[b];
                            }
                        }
                    }
                }
                else if (chk[a] == 0 && chk[b] == 0) {
                    result++;
                    groups[group] = 2;
                    chk[a] = chk[b] = group++;
                }
                else {
                    if (chk[a] == 0) {
                        chk[a] = chk[b];
                        groups[chk[a]]++;
                    }
                    else {
                        chk[b] = chk[a];
                        groups[chk[b]]++;
                    }
                }
                System.out.println("현재 몇번째 입력인가? " + i + " 번째 이다.");
                System.out.println("a = " + a + ", b = " + b);
                System.out.println("result = " + result);
                for (int j = 0; j < N + 1; j++) {
                    System.out.println("chk[" + j + "] = " + chk[j]);
                }

            }

            for (int i = 1; i < N + 1; i++) {
                if (chk[i] == 0) result++;
            }

            System.out.println("#" + tc + " " + result);
        }
    }
}
