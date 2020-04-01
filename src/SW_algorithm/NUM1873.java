package SW_algorithm;

import java.io.*;
import java.util.StringTokenizer;

/*
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LyE7KD2ADFAXc
SW Expert 1873번 문제 [상호의 배틀필드]

상호는 전차로 시가전을 하는 것을 테마로 한 새로운 게임 “배틀 필드”를 개발하기로 했다.

그래서 먼저 간단하게 프로토 타입 게임을 만들었다.

이 프로토 타입에서 등장하는 전차는 사용자의 전차 하나뿐이며, 적이나 아군으로 만들어진 전차는 등장하지 않는다.

사용자의 전차는 사용자의 입력에 따라 격자판으로 이루어진 게임 맵에서 다양한 동작을 한다.

다음 표는 게임 맵의 구성 요소를 나타낸다.

문자	의미
.	평지(전차가 들어갈 수 있다.)
*	벽돌로 만들어진 벽
#	강철로 만들어진 벽
-	물(전차는 들어갈 수 없다.)
^	위쪽을 바라보는 전차(아래는 평지이다.)
v	아래쪽을 바라보는 전차(아래는 평지이다.)
<	왼쪽을 바라보는 전차(아래는 평지이다.)
>	오른쪽을 바라보는 전차(아래는 평지이다.)
다음 표는 사용자가 넣을 수 있는 입력의 종류를 나타낸다.

문자	동작
U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
전차가 이동을 하려고 할 때, 만약 게임 맵 밖이라면 전차는 당연히 이동하지 않는다.

전차가 포탄을 발사하면, 포탄은 벽돌로 만들어진 벽 또는 강철로 만들어진 벽에 충돌하거나 게임 맵 밖으로 나갈 때까지 직진한다.

만약 포탄이 벽에 부딪히면 포탄은 소멸하고, 부딪힌 벽이 벽돌로 만들어진 벽이라면 이 벽은 파괴되어 칸은 평지가 된다.

강철로 만들어진 벽에 포탄이 부딪히면 아무 일도 일어나지 않는다.

게임 맵 밖으로 포탄이 나가면 아무런 일도 일어나지 않는다.

초기 게임 맵의 상태와 사용자가 넣을 입력이 순서대로 주어질 때, 모든 입력을 처리하고 나면 게임 맵의 상태가 어떻게 되는지 구하는 프로그램을 작성하라.


[입력]

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 두 정수 H, W (2 ≤ H, W ≤ 20) 이 공백으로 구분되어 주어진다.

이는 게임 맵의 높이가 H, 너비가 W임을 나타낸다.

즉, 게임 맵은 H x W크기의 격자판이다.

다음 H개의 각각의 줄에는 길이가 W인 문자열이 주어진다.

각각의 문자는 위의 게임 맵 구성 요소 표에 있는 문자들만 포함하며, 전차는 단 하나만 있다.

다음 줄에는 사용자가 넣을 입력의 개수를 나타내는 정수 N(0 < N ≤ 100) 이 주어진다.

다음 줄에는 길이가 N인 문자열이 주어진다.

각각의 문자는 위의 사용자가 넣을 수 있는 입력의 종류를 나타내는 표에 있는 문자들만 포함된다.


[출력]

각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고 한 칸을 띄운 후, 모든 입력을 처리하고 난 후의 게임 맵을 H개의 줄에 걸쳐 출력한다.

*/

/*
테스트 케이스
1
3 7
***....
*-..#**
#<.****
23
SURSSSSUSLSRSSSURRDSRDS

출력 정답
#1 **....v
.-..#..
#......

 */
class NUM1873 {
    static char[][] move(char[][] table,int X, int Y, String command, int maxY, int maxX) {
        char[][] field = table;
        int posX = X;
        int posY = Y;
        char cmd;
        for(int c = 0; c < command.length(); c++) {
            cmd = command.charAt(c);
            switch (cmd) {
                case 'U':
                    if (posY > 0 && field[posY - 1][posX] == '.') {
                        field[posY][posX] = '.';
                        field[--posY][posX] = '^';
                    }else {
                        field[posY][posX] = '^';
                    }
                    break;
                case 'D':
                    if (posY < maxY - 1 && field[posY + 1][posX] == '.') {
                        field[posY][posX] = '.';
                        field[++posY][posX] = 'v';
                    }else {
                        field[posY][posX] = 'v';
                    }
                    break;
                case 'L':
                    if (posX > 0 && field[posY][posX - 1] == '.') {
                        field[posY][posX] = '.';
                        field[posY][--posX] = '<';
                    }else {
                        field[posY][posX] = '<';
                    }
                    break;
                case 'R':
                    if (posX < maxX - 1 && field[posY][posX + 1] == '.') {
                        field[posY][posX] = '.';
                        field[posY][++posX] = '>';
                    }else {
                        field[posY][posX] = '>';
                    }
                    break;
                case 'S':
                    switch (field[posY][posX]) {
                        case '^':
                            for (int i = posY; i >= 0; i--) {
                                if(field[i][posX] == '#') break;
                                if (field[i][posX] == '*') {
                                    field[i][posX] = '.';
                                    break;
                                }
                            }
                            break;
                        case 'v':
                            for (int i = posY; i < maxY; i++) {
                                if(field[i][posX] == '#') break;
                                if (field[i][posX] == '*') {
                                    field[i][posX] = '.';
                                    break;
                                }
                            }
                            break;
                        case '<':
                            for (int i = posX; i >= 0; i--) {
                                if(field[posY][i] == '#') break;
                                if (field[posY][i] == '*') {
                                    field[posY][i] = '.';
                                    break;
                                }
                            }
                            break;
                        case '>':
                            for (int i = posX + 1; i < maxX; i++) {
                                if(field[posY][i] == '#') break;
                                if (field[posY][i] == '*') {
                                    field[posY][i] = '.';
                                    break;
                                }
                            }
                            break;
                    }

            }
        }
        return field;
    }

    public static void main(String args[]) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bf.readLine());
        char[][] table = new char[20][20];
        int N;
        int M;
        String command;

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int posX = 0;
            int posY = 0;
            command = "";


            for (int i = 0; i < N; i++) {
                String temp = bf.readLine();
                for (int j = 0; j < M; j++) {
                    table[i][j] = temp.charAt(j);
                    if (table[i][j] == '^' || table[i][j] == '<' || table[i][j] == '>' || table[i][j] == 'v') {
                        posY = i;
                        posX = j;
                    }
                }
            }

            int commandNum = Integer.parseInt(bf.readLine());
            command = bf.readLine();


            table = move(table, posX, posY, command, N, M);

            System.out.print("#" + test_case + " ");
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    System.out.print(table[i][j]);
                }
                System.out.println();
            }
        }
    }
}
