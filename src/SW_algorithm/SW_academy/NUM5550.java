package SW_algorithm.SW_academy;

/*

SW Expert NO.5550 나는 개구리로소이다.

https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWWxqfhKAWgDFAW4&categoryId=AWWxqfhKAWgDFAW4&categoryType=CODE&&&

개구리 한 마리가 한번 울면 “croak”하는 소리가 난다. 개구리 한 마리가 계속 여러 번 울면 울음소리가 다음처럼 나타날 수 있다.

“croakcroak”, “croak”, “croakcroakcroakcroak”

영은이는 개구리를 연구하기 위해 많은 개구리를 사육한다. 영은이는 개구리들을 키우는 우리에 들어와 울음소리를 녹음했다.

여러 개구리가 동시에 울면 울음소리가 섞여서 녹음된다.

이 때 한 개구리의 울음소리는 녹음된 울음소리에서 부분 문자열로 나타난다. 이 부분 문자열은 연속하지 않아도 된다. 예를 들어 "crcoarkcoroakak"와 같을 수 있다.

그렇다면, 녹음을 할 때 있었던 개구리는 최소 몇 마리일까?


[입력]

첫 번째 줄에 테스트 케이스의 수가 주어진다.

각 테스트 케이스의 첫 번째 줄에 개구리들의 울음소리를 나타내는 길이 5 이상 2,500이하인 문자열이 주어진다. 이 문자열은 ‘c’, ‘r’, ‘o’, ‘a’, ‘k’로만 이루어져 있다.

[출력]

각 테스트 케이스마다 첫번째 줄에는 ‘#T’(T는 테스트케이스 번호를 의미하며 1부터 시작한다.)를 출력하고, 개구리의 최소 수를 출력한다.

개구리의 울음소리로 불가능한 경우 -1을 출력하면 된다.

입력
8
crcoarkcoroakak
ccccrrrrooooaaaakkkk
karoc
croakcorakcroak
ccroak
croakcroakcroakcroakcroakcroakcroakcroakcroakcroak
ccccccccccrrrrrrrrrrooooooooooaaaaaaaaaakkkkkkkkkk
crcocrroaokacakkrocrakcorakoak

출력
#1 2
#2 4
#3 -1
#4 -1
#5 -1
#6 1
#7 10
#8 3

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NUM5550 {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        char[] frogCry;         // 개구리의 울음소리

        for (int tc = 1; tc <= T; tc++) {

            int waitFrog = 0;       // 대기중인 개구리 숫자 = 현재 개구리의 숫자
            int cryingFrog = 0;     // 현재 울고 있는 개구리 숫자
            int[] frog = new int[5]; // 울음소리가 올바른지 판단하는 배열

            frogCry = bf.readLine().toCharArray();

            // crcoarkcoroakak
            for (int j = 0; j < frogCry.length; j++) {
                if (frogCry[j] == 'c') {
                    if (waitFrog != 0) {    // 대기중인 개구리가 있다면
                        waitFrog--;         // 대기중인 개구리를
                        cryingFrog++;       // 우는개구리로 만듬
                    }
                    else                    // 대기중인 개구리가 없다면
                        cryingFrog++;       // 우는 개구리를 새로 만듬
                    frog[0]++;
                } else if (frogCry[j] == 'r') frog[1]++;
                else if (frogCry[j] == 'o') frog[2]++;
                else if (frogCry[j] == 'a') frog[3]++;
                else if (frogCry[j] == 'k') {   // 개구리의 울음소리가 끝나면
                    frog[4]++;
                    cryingFrog--;           // 우는 개구리를
                    waitFrog++;             // 대기중인 개구리로 바꿔줌
                }
                // 개구리의 울음소리 순서가 틀리다면 -1을 반환
                if (frog[0] < frog[1] || frog[1] < frog[2] || frog[2] < frog[3] || frog[3] < frog[4]) {
                    waitFrog = -1;
                    break;
                }
            }
            // 개구리의 울음소리중 각각의 알파벳 개수가 같지않다면 -1을 반환
            if (frog[0] != frog[1] || frog[1] != frog[2] || frog[2] != frog[3] || frog[3] != frog[4]) {
                waitFrog = -1;
            }
            System.out.println("#" + tc + " " + waitFrog);
        }
    } // 테스트 케이스 반복문의 끝
}


