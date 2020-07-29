package SW_algorithm.SW_academy;

/*

SW Expert - 3142. 영준이와 신비한 뿔의 숲

https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV_6xWk6sbADFAWS&categoryId=AV_6xWk6sbADFAWS&categoryType=CODE

영준이는 신비한 짐승들이 살고 있는 뿔의 숲을 지나왔다.

이 숲에는 뿔이 한 개 달린 유니콘과 뿔이 두 개 달린 트윈혼이 살고 있다.

영준이는 n개의 뿔과 m마리의 짐승을 보았다.

영준이가 본 유니콘의 수와 트윈혼의 수는 몇 마리일까?

만약 영준이가 5개의 뿔과 3마리의 짐승을 봤다면, 아래 그림과 같이 유니콘 1마리와 트윈혼 2마리였을 것이다.




[입력]

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

각 테스트 케이스마다 첫 번째 줄에 두 정수 n, m (1 ≤ n ≤ 300, m ≤ n ≤ 2m)이 공백으로 구분되어 주어진다.


[출력]

각 테스트 케이스마다 영준이가 본 유니콘의 수와 트윈혼의 수를 공백으로 구분하여 출력한다.

입력
2
5 3
7 5

출력
#1 1 2
#2 3 2

 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NUM3142 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        int N;
        int M;
        int corn;
        int horn;

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(bf.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            corn = M;
            horn = 0;

            while (corn > 0) {
                if (N != corn + horn * 2){
                    corn--;
                    horn++;
                }
                else
                    break;
            }
            System.out.println("#" + tc + " " + corn + " " +  horn);
        }
    }
}
