package SW_algorithm.SW_academy;

/*

SW Expert - NO.4530 극한의 청소 작업

https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWO6cgzKOIEDFAWw&categoryId=AWO6cgzKOIEDFAWw&categoryType=CODE&&&

돈을 많이 번 민기는 지하 999,999,999,999층에서 지상 999,999,999,999층에 이르는 거대한 건물을 건설했다.

지상에 있는 층은 1층에서부터 시작하여 999,999,999,999층까지 한 층씩 높아지는 식인데,

4라는 숫자를 싫어하는 우리나라의 정서를 반영하여 수에 숫자 4가 들어가는 모든 층을 건너뛰어 건물을 건설하였다.

즉, 4, 14, 24, 34, 40, 41, …, 48, 49, 54, … 층을 생략하고 건물을 건설 한 것이다.

지하도 지상과 같은 방식으로 지하 1층에서부터 시작하여 숫자 4가 들어가는 모든 층을 건너뛰어 지하 999,999,999,999층 까지를 건설했다.

실제로는 지하인 층에는 앞에 B가 붙어서 지하 13층의 경우 B13로 나타나지만, 입력의 편의를 위해 B를 -로 바꿔 음수인 -13로 나타내도록 한다. 건물에 0층 같은 것은 존재하지 않는다.

인계동에 사는 은비는 이 건물을 청소하는 일을 하고 있다.

이 건물에는 엘리베이터가 없어서 은비는 걸어서 층을 이동해야 한다.

은비는 청소를 위해 A층에서 B층으로 올라가려고 한다. 과연 몇 층을 올라가야 할까?


[입력]

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
각 테스트 케이스의 첫 번째 줄에는 두 정수 A,B(-1012 < A < B < 1012)가 공백으로 구분되어 주어진다.
A와 B를 이루는 숫자에는 4가 들어있지 않다.

[출력]

각 줄마다 "#T" (T는 테스트 케이스 번호)를 출력한 뒤,  A층에서 B층으로 올라가려면 몇 층을 올라가야 하는지 출력하라.


입력
3
-1 1
-5 3
-123123123123 789789789789

출력
#1 1
#2 6
#3 255660802939

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NUM4530 {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        long A; // 시작 층
        long B; // 목표 층

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            A = Long.parseLong(st.nextToken());
            B = Long.parseLong(st.nextToken());

            if ((A > 0 && B > 0) || (A < 0 && B < 0)) {
                long temp = Math.abs(find(A) - find(B));
                System.out.println("#" + tc + " " + temp);
            } else {
                System.out.println("#" + tc + " " + (find(A) + find(B) - 1));
            }
        }
    }

    static long find(long num) {
        if (num < 0) {
            num = -num;
        }
        long temp = num;
        long sum = 0;
        int N = 0;
        while (temp != 0) {
            temp = temp / 10;
            N++;
        }
        while (N != 0) {
            long x = (long) (num / Math.pow(10, N - 1));
            num = (long) (num % Math.pow(10, N - 1));
            if (x > 4) {
                sum += (x - 1) * Math.pow(9, N - 1);
            } else {
                sum += x * Math.pow(9, N - 1);
            }
            N--;
        }
        return sum;
    }
}
