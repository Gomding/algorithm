package SW_algorithm.SW_academy;

/*
SW Expert No.6109 추억의 2048 게임

https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWbrg9uabZsDFAWQ&categoryId=AWbrg9uabZsDFAWQ&categoryType=CODE&&&#

2048이라는 추억의 게임을 아는가? 2048은 한 때 유명했던 1인용 게임으로, 격자 위에서 숫자가 적힌

타일들을 밀어서 합치고 최종적으로 2048을 만들어 내는 것이 목표인 게임이다.

한번 타일을 밀 때는 상하좌우를 정해서 밀어야 한다.

방향을 정하면 격자 위에 있는 모든 타일이 그 방향으로 밀린다.

만약 어떤 타일이 밀리는 방향에 다른 타일이 있고, 두 타일에 적힌 숫자가 같다면 두 타일은 합쳐져

새로운 하나의 타일이 되고 이 타일에 적힌 숫자는 합쳐진 숫자들의 합이 된다.

이렇게 합쳐져서 만들어진 새로운 타일은 숫자가 같은 다른 타일이 밀려와도 합쳐져서는 안 된다.

만약 같은 숫자가 적힌 타일이 세 개 이상 있을 때는 헷갈리는 경우를 없애기 위해 빨리 벽에 닿게 될 타일을 먼저 민다고

생각한다.

예를 들어 “2 2 4 2 2 2”가 적힌 타일들이 있을 때, 이 타일들을 왼쪽으로 밀면 결과는 “4 4 4 2 0 0”이 된다.

0은 타일이 없는 빈 칸을 나타낸다.

우리는 2048게임을 N×N 크기의 격자에서 하려고 한다.

현재 격자에 어떤 식으로 타일이 있는지 주어지고, 타일들을 이동시킬 방향이 주어질 때,

타일을 모두 이동시키고 나면 격자가 어떻게 변할 지 계산하는 프로그램을 작성하라.

[입력]

각 테스트 케이스의 첫 번째 줄에는 하나의 정수 N(1≤N≤20)과 하나의 문자열 S가 공백 하나로 구분되어 주어진다.

S는 “left”, “right”, “up”, “down”의 넷 중 하나이며 각각 타일들을 왼쪽, 오른쪽, 위쪽, 아래쪽으로 이동시키겠다는 뜻이다.

다음 N개의 줄의 i번째 줄에는 N개의 정수가 공백 하나로 구분되어 주어진다.

이 정수들은 0이거나 2이상 1024이하의 2의 제곱수들이다.

i번째 줄의 j번째 정수는 격자의 위에서 i번째 줄의 왼쪽에서 j번째에 있는 칸에 있는 타일에 어떤 정수가 적혀 있는지 나타내며,

0이면 이 칸에 타일이 없음을 의미한다.


[출력]

각 테스트 케이스마다 ‘#t’(t는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고 한 줄을 띄운 후,

N줄에 걸쳐 격자의 어떤 위치에 어떤 숫자가 적힌 타일이 있는지 입력 형식과 같은 형식으로 출력한다.

입력
2
5 up
4 8 2 4 0
4 4 2 0 8
8 0 2 4 4
2 2 2 2 8
0 2 2 0 0
2 down
16 2
0 2

출력
#1
8 8 4 8 8
8 4 4 2 4
2 4 2 0 8
0 0 0 0 0
0 0 0 0 0
#2
0 0
16 4

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NUM6109 {

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        int N;                  // 격자판의 크기를 지정할 값
        int[][] field;         // 게임을 할 격자판
        String cmd;             // 밀어낼 방향의 커맨드 up, down, right, left
        int posX;               // 현재 저장할 X 의 위치
        int posY;               // 현재 저장할 Y의 위치
        int chkField;           // 현재 검사중인 필드
        int temp;               // 현재 저장해둔 값

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer tokens = new StringTokenizer(bf.readLine());

            N = Integer.parseInt(tokens.nextToken());    // 격자판의 크기를 입력받음
            cmd = tokens.nextToken();   // 명령어를 입력받음
            field = new int[N][N];      // 격자판을 생성함

            for (int i = 0; i < N; i++) {       // 격자판의 값을 입력받음
                tokens = new StringTokenizer(bf.readLine());
                for (int j = 0; j < N; j++) {
                    field[i][j] = Integer.parseInt(tokens.nextToken());
                }
            }

            if(cmd.equals("up")) {
                for (int x = 0; x < N; x++) {
                    temp = 0;               // 배열에 넣을 값을 저장하기 위한 변수
                    posY = 0;               // 위에서부터 초기화하기 위한 위치값
                    chkField = 0;           // 0보다 큰 값을 찾아 다니면서 temp 와 비교될 변수
                    for (int y = 0; y < N; y++) {
                        chkField = field[y][x];             // 값을 chkField 에 저장함
                        field[y][x] = 0;
                        if(chkField != 0) {
                            if(temp == 0) temp = chkField;
                            else if (temp == chkField) {
                                field[posY++][x] = temp * 2;
                                temp = 0;
                            }
                            else if (temp != chkField) {
                                field[posY++][x] = temp;
                                temp = chkField;
                            }
                        }
                    }
                    if(temp != 0) {
                        field[posY++][x] = temp;

                    }
                }
            }
            else if(cmd.equals("down")) {
                for (int x = 0; x < N; x++) {
                    temp = 0;
                    posY = N - 1;
                    chkField = 0;
                    for(int y = N -1 ; y >= 0; y--) {
                        chkField = field[y][x];
                        field[y][x] = 0;
                        if(chkField != 0) {
                            if(temp == 0) temp = chkField;
                            else if (temp == chkField) {
                                field[posY--][x] = temp * 2;
                                temp = 0;
                            }
                            else if (temp != chkField) {
                                field[posY--][x] = temp;
                                temp = chkField;
                            }
                        }
                    }
                    if(temp != 0) {
                        field[posY--][x] = temp;
                    }
                }
            }

            else if (cmd.equals("right")) {
                for (int y = 0; y < N; y++) {
                    temp = 0;
                    posX = N - 1;
                    chkField = 0;
                    for (int x = N - 1; x >= 0; x--) {
                        chkField = field[y][x];
                        field[y][x] = 0;
                        if(chkField != 0) {
                            if(temp == 0) temp = chkField;
                            else if (temp == chkField) {
                                field[y][posX--] = temp * 2;
                                temp = 0;
                            }
                            else if (temp != chkField) {
                                field[y][posX--] = temp;
                                temp = chkField;
                            }
                        }
                    }
                    if(temp != 0) {
                        field[y][posX--] = temp;
                    }
                }
            }
            else if(cmd.equals("left")) {
                for (int y = 0; y < N; y++) {
                    temp = 0;
                    posX = 0;
                    chkField = 0;
                    for (int x = 0; x < N; x++) {
                        chkField = field[y][x];
                        field[y][x] = 0;
                        if (chkField != 0) {
                            if (temp == 0) temp = chkField;
                            else if (temp == chkField) {
                                field[y][posX++] = temp * 2;
                                temp = 0;
                            }
                            else if (temp != chkField) {
                                field[y][posX++] = temp;
                                temp = chkField;
                            }
                        }
                    }
                    if(temp != 0) {
                        field[y][posX] = temp;
                    }
                }
            }
            System.out.println("#" + tc);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(field[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
