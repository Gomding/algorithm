package SW_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

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
