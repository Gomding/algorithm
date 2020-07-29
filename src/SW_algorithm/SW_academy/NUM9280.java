package SW_algorithm.SW_academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
SW Expert - NO.9280 진용이네 주차타워
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW9j74FacD0DFAUY

부지런한 진용이는 정문 앞에서 유료 주차장 운영하고 있다. 이 주차장은 1 부터 n 까지 번호가 매겨진 n 개의 주차 공간을 가지고 있다.
매일 아침 모든 주차 공간이 비어 있는 상태에서 영업을 시작하며, 다음과 같은 방식으로 운영된다.



차가 주차장에 도착하면, 진용이는 비어있는 주차 공간이 있는지 검사한다.

비어있는 공간이 없다면, 빈 공간이 생길 때까지 차량을 입구에서 기다리게 한다.

빈 주차 공간이 있으면 진용이는 곧바로 주차를 시키며, 주차 가능한 공간 중 번호가 가장 작은 주차 공간에 주차하도록 한다.

만약 주차를 기다리는 차량이 여러 대라면, 입구의 대기장소에서 자기 차례를 기다려야 한다. 운전자들은 예의가 바르기 때문에 새치기를 하지 않는다.


주차요금은 차량의 무게와 주차 공간마다 따로 책정된 단위 무게당 금액을 곱한 가격이다. 진용이네 주차장에서는 종일 이용권만을 판매하기 때문에 이용시간은 고려하지 않는다.


진용이는 오늘 주차장을 이용할 m 대의 차량들이 들어오고 나가는 순서를 알고 있다.
진용이의 주차장이 오늘 하루 벌어들일 총 수입을 계산하는 프로그램을 작성하라.


[입력]



첫 번째 줄에 테스트 케이스의 수 TC 가 주어진다.
이후 TC 개의 테스트 케이스가 새 줄로 구분되어 주어진다.
각 테스트 케이스는 다음과 같이 구성되어 있다.



첫 번째 줄에 자연수  n 과  m 이 주어진다. (1 ≤ n  ≤ 100, 1 ≤ m  ≤ 2000)
n 개의 줄에 i 번째 주차 공간의 단위 무게당 요금 Ri 가 정수로 주어진다. (1 ≤ Ri  ≤ 100)
m 개의 줄에 차량 i 의 무게 Wi 가 정수로 주어진다. 차량번호 i 와 차량의 도착 순서는 아무런 관계가 없다. (1 ≤ Wi  ≤ 10000)
이후  2m 개의 줄에 차량들의 주차장 출입 순서가 하나의 정수  x 로 주어진다.
주어진 정수 x 가 양수면, x 번 차가 주차장에 들어옴을 뜻한다.
x 가 음수면, -x 번 차가 주차장을 나감을 뜻한다.


주차장에 들어오지 않은 차량이 주차장에서 나가는 경우는 주어지지 않는다.
1 번부터 m 번까지 모든 차량은 정확하게 한 번씩 주차장에 들어오고, 한 번씩 주차장에서 나간다.
또한 입구에서 대기 중인 차량이 주차를 하지 못하고 그냥 돌아가는 경우는 없다.

[출력]

각 테스트 케이스마다 ‘#t ’(t 는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고, 진용이가 오늘 하룻동안 벌어들일 수입을 출력하라.



2           // 테스트 케이스 개수 TC = 2
3 4         // 첫 번째 테스트 케이스 n = 3,  m = 4
2           // 단위 무게당 요금 R_i = {2, 3, 5}
3
5
2           // 차량의 무게 W_i = {2, 1, 3, 8}
1
3
8
3           // i = 3 인 차량이 들어옴
2           // i = 2 인 차량이 들어옴
-3          // i = 3 인 차량이 나감
1           // i = 1 인 차량이 들어옴
4           // i = 4 인 차량이 들어옴
-4          // i = 4 인 차량이 나감
-2          // i = 2 인 차량이 나감
-1          // i = 1 인 차량이 나감

2 4         // 두 번째 테스트 케이스 n = 2,  m = 4
5           // 단위 무게당 요금 R_i = {5, 2}
2
100         // 차량의 무게 W_i = {100, 500, 1000, 2000}
500
1000
2000
3           // i = 3 인 차량이 들어옴
1           // i = 3 인 차량이 들어옴
2           // i = 3 인 차량이 들어옴
4           // i = 3 인 차량이 들어옴
-1          // i = 1 인 차량이 나감
-3          // i = 3 인 차량이 나감
-2          // i = 2 인 차량이 나감
-4          // i = 4 인 차량이 나감
 */

public class NUM9280 {

    public static void main(String[] args) throws IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());
        int[] R;        // N = 주차장의 자리 개수
        int[] W;        // M = 차량의 개수
        int[] waitLine; // waitLine = 대기중인 차


        for (int tc = 1; tc <= T; tc++) {
            int[] chkR; // 자리의 주차여부
            int chkCar = 0;     // 모든차가 들어왔다가 나갔는지 검사
            int result = 0;     // 오늘의 수익

            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());       // N = 주차장의 자리 개수
            int M = Integer.parseInt(st.nextToken());       // M = 차량의 개수

            R = new int[N];     // R = 주차장 각 자리의 무게당 요금표
            W = new int[M];     // W = 각 차량의 무게
            waitLine = new int[M];  // 대기중인 차
            chkR = new int[N];      // chkR = 오늘 들어올 차번호의 총 합

            for (int i = 0; i < N; i++) {
                R[i] = Integer.parseInt(bf.readLine());     // 각 자리의 무게당 요금을 지정함
                chkR[i] = 0;
            }
            for (int j = 0; j < M; j++) {
                W[j] = Integer.parseInt(bf.readLine());     // 각 차량의 무게를 지정함
                waitLine[j] = 0;
                chkCar += j + 1;
            }

            while (chkCar != 0) {

                int cmd = Integer.parseInt(bf.readLine());


                if (cmd > 0) {
                    for (int i = 0; i < N; i++) {   // 주차장 자리를 제일 낮은곳 부터 검색
                        if (chkR[i] == 0) {         // 주차장 자리가 비어있다면
                            chkR[i] = cmd;          // 주차장에 차량번호 기록
                            result += W[cmd - 1] * R[i];    // 오늘의 수익에 차량 무게와 자리의 요금을 곱해서 수익에 더해줌
                            break;
                        }else if (i == N - 1) {             // 주차장 자리가 없을 때
                            for (int j = 0; j < M; j++) {   // 대기열을 검사함
                                if(waitLine[j] == 0) {      // 대기열을 비어있는 자리를 찾았다면
                                    waitLine[j] = cmd;      // 대기열에 해당 차 번호를 입력
                                    break;
                                }
                            }
                        }
                    }
                }else if(cmd < 0) {      // 명령어가 음수(차를 주차장에서 뺄 때)
                    for (int i = 0; i < N; i++) {   // 입력한 차가 주차된 자리는 낮은곳부터 검색
                        if(chkR[i] == cmd * -1) {   // 해당 차의 번호가 있는 자리를 찾았다면~
                            chkR[i] = 0;            // 해당 자리를 0으로 비움 표시
                            chkCar += cmd;          // 해당 차의 예약을 삭제
                            if (waitLine[0] != 0) {     // 대기열에 손님이 있다면
                                chkR[i] = waitLine[0];  // 방금 나온 자리에 대기열 손님을 주차시킴
                                result += W[waitLine[0] - 1] * R[i];    // 자리에 넣고 요금을 계산함
                                for (int j = 0; j < M - 1; j++) {       // 대기열을 재정렬함
                                    waitLine[j] = waitLine[j + 1];      // 대기열을 한칸씩 앞으로 보내줌
                                    if(waitLine[j + 1] == 0) {              // 이후 대기열이 0 이라면
                                        waitLine[j] = 0;            // 지워지지않은 마지막 대기열을 삭제후
                                        break;                          // 정렬을 멈춤
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println("#" + tc + " " + result);
        }
    }
}
