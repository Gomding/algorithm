package SW_algorithm;

/*

SW Expert NO.6959 이상한 나라의 덧셈게임ㄴ

https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWjlH0k63joDFAVT

앨리스와 토끼는 덧셈을 이용한 간단한 게임을 같이 하기로 했다.

먼저 어떤 양의 정수를 하나 정해 그 수로 게임을 시작한다.

둘은 서로의 차례에 인접한 두 자리를 선택하고, 이 두 자리를 선택된 두 숫자의 합으로 교체하여 상대에게 차례를 넘긴다.

예를 들어, “1234”의 십의 자리와 백의 자리를 선택하면 다음 차례에는 수가 “154”가 된다.

“5678”의 십의 자리와 백의 자리를 선택하면 다음 차례에는 수가 “5138”이 된다.

이렇게 차례를 반복 하다가 자기 차례에 넘어온 수가 한 자리가 되면 그 사람이 패배하게 된다.

게임을 시작할 때의 정수가 주어진다.

앨리스가 먼저 차례를 가지고,

서로 최선을 다해 게임을 한다고 할 때 어떤 사람이 게임에서 승리하게 될 것인지 구하는 프로그램을 작성하라.


[입력]

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 1000자리 이하의 양의 정수가 하나 주어진다.

제일 첫 번째 자리는 0이 아니다.


[출력]

각 테스트 케이스마다 앨리스가 이기면 ‘A’를, 토끼가 이기면 ‘B’를 출력한다.

입력
3
1234
5678
9

출력
#1 B
#2 A
#3 B

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NUM6959 {

    public static void main(String[] args) throws  Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        char victory;   // 승자 'A' or 'B'
        char[] num;     // 입력받은 숫자
        int plusNum; // 두자의 값을 더한 숫자
        int idx;
        int length;

        for (int tc = 1; tc <= T; tc++) {
            victory = 'B';
            num = bf.readLine().toCharArray();
            plusNum = 0;
            idx = 0;
            length = num.length;

            if(num.length != 1) {       // 자리수가 1자리가 아니라면 게임을 계속함  / 1자리면 앨리스의 패배 (졸렬한 토끼)
                while (length > 1) {  // num 의 끝에서 두번째 자리가 0 이 아니라면 반복을 계속함
                    if(victory == 'B') victory = 'A';   // 승자가 B로 되어 있다면 A로 바꿈
                    else if(victory == 'A') victory = 'B';
                    plusNum = Character.getNumericValue(num[idx]) + Character.getNumericValue(num[idx + 1]);
                    // plusNum 의 값을 두 자리의 값을 더한 값으로 초기화

                    if(plusNum < 10) {                  // plusNum 이 한자리 라면
                        num[idx++] = '0';                // 고른 두자리 중 첫번째 자리를 0 으로 해서 배열에 넣고 다음 칸으로 가기위해 idx++ 해준다
                        num[idx] = Character.forDigit(plusNum, 10); // 두자리 중 두번 쨰 자리를 넣어준다
                        length--;
                    }
                    else {  // plusNum 이 두자리 라면
                        num[idx] = Character.forDigit(plusNum / 10, 10);        // 각각의 배열에 첫째자리 둘째 자리를 넣어줌
                        num[idx + 1] = Character.forDigit(plusNum % 10, 10);
                    }
                }
            }
            System.out.println("#" + tc + " " + victory);
        }
    }
}
