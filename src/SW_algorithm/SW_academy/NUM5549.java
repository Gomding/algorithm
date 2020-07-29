package SW_algorithm.SW_academy;

/*

SW Expert - NO.5549 홀수일까 짝수일까

https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWWxpEDaAVoDFAW4&categoryId=AWWxpEDaAVoDFAW4&categoryType=CODE

양의 정수가 주어질 때, 이 수가 홀수인지 짝수인지 판별하는 프로그램을 작성하라.


[입력]

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 100자리 이하의 양의 정수가 주어진다.

[출력]

각 테스트 케이스마다 첫 번째 줄에는‘#T’(T는 테스트케이스 번호를 의미하며 1부터 시작한다.)를 출력하고, 주어진 수가 홀수이면 “Odd”를, 짝수이면 “Even”을 출력한다.

입력
5
1
10
100
185787124368712386825387273871
82518881239123819238912929292

출력
#1 Odd
#2 Even
#3 Even
#4 Odd
#5 Even

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NUM5549 {

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        String content;

        for (int tc = 1; tc <= N; tc++) {

            content = bf.readLine();

            System.out.print("#" + tc + " ");

            if (Character.getNumericValue(content.charAt(content.length() - 1)) % 2 != 0)
                System.out.print("Odd");
            else
                System.out.print("Even");

            System.out.println();
        }
    }
}
