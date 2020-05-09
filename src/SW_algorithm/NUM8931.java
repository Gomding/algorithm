package SW_algorithm;

/*

SW Expert - 8931. 제로

https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW5jBWLq7jwDFATQ&categoryId=AW5jBWLq7jwDFATQ&categoryType=CODE

재현이는 재민이를 도와서 동아리 장부를 관리하고 있다.


재현이는 영수증을 모아서 동아리의 지출 금액을 세고 있고, 재민이는 재현이가 부르는 액수를 순서대로 적고 있다.


재현이는 가끔 잘못된 수를 부르는 실수를 하는데, 이 때마다 0을 외쳐서, 가장 최근에 재민이가 쓰고 지우지 않았던 수를 지우게 시킨다.


재현이가 모든 수를 부른 후 재민이가 받아 적은 수의 합은 무엇일까?





[입력]



첫 번째 줄에 테스트 케이스의 수 TC가 주어진다.

각 테스트 케이스는 다음과 같이 구성되었다.



첫 번째 줄에 정수 K가 주어진다. (1 ≤ K ≤ 100,000)


이후 K개의 줄에 정수가 하나씩 주어진다. 정수는 0 이상 100000 이하의 값이다.


만약 정수가 0일 경우에는 최근에 쓰고 지우지 않았던 수를 지워야 하며, 그렇지 않을 경우 해당 수를 써야 한다.



정수가 0일 경우에 지울 수 있는 수가 있음을 보장할 수 있다.





[출력]

각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,

각 테스트 케이스마다 한 줄씩 재민이가 받아 적은 수의 합을 출력한다.



입력
2
6
10000
10000
0
0
100000
0
10
1
3
5
4
0
0
7
0
0
6

출력
#1 0
#2 7


 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NUM8931 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        int N;
        int chk;
        int result;
        int[] note;
        int idx;

        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(bf.readLine());

            result = 0;
            chk = 0;
            note = new int[N];
            idx = 0;

            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(bf.readLine());
                if (num > 0) {
                    result += num;
                    note[idx++] = num;
                    chk = num;
                }
                else {
                    if (idx > 1) {
                        note[--idx] = 0;
                        result -= chk;
                        chk = note[idx - 1];
                    }
                    else {
                        note[--idx] = 0;
                        result -= chk;
                    }
                }
            }

            System.out.println("#" + tc + " " + result);

        }

    }

}
