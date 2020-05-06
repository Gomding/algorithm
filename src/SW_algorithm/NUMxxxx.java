package SW_algorithm;

/*

다음 표처럼 N x N 칸에 숫자가 적힌 판이 주어지고 각 칸에서는 오른쪽이나 아래로만 이동할 수 있다.

맨 왼쪽 위에서 오른쪽 아래까지 이동할 때, 지나는 칸에 써진 숫자의 합계가 최소가 되도록 움직였다면

이때의 합계가 얼마인지 출력하는 프로그램을 만드시오.

1 2 3
2 3 4
3 4 5

표의 경우 1, 2, 3, 4, 5 순으로 움직이고 최소 합계는 15가 된다. 가능한 모든 경로에 대해 합을 계산한 다음 최소값을 찾아도 된다.

[입력]
첫 줄에 테스트케이스의 수 T가 주어진다. 1 <= T <= 50

다음줄 부터 테스트 케이스의 별로 첫 줄에 가로 세로 칸 수 N이 주어지고, 다음 줄 부터 N개씩 N개의 줄에 걸쳐 10 이하의 자연수가 주어진다. 3 <= N <= 13


입력
3
3
1 2 3
2 3 4
3 4 5
4
2 4 1 3
1 1 7 1
9 1 7 10
5 7 2 4
5
6 7 1 10 2
10 2 7 5 9
9 3 2 9 6
1 6 8 2 9
8 3 8 2 1

출력
#1 15
#2 18
#3 33

 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NUMxxxx {

    public static int search (int[][] map, int result, int N, int x, int y, int min) {
        result += map[y][x];

        if (x != N - 1 || y != N - 1) {
            if (x == N - 1) {
                min = search(map, result, N, x, y + 1, min);
            } else if (y == N - 1) {
                min = search(map, result, N, x + 1, y, min);
            } else {
                min = search(map, result, N, x + 1, y, min);
                min = search(map, result, N, x, y + 1, min);
            }
        }
        else if (x == N - 1 && y == N - 1) {
            if (result < min) min = result;
        }

        return min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());
        int N;
        int[][] map;
        int result;
        int min;


        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st;

            N = Integer.parseInt(bf.readLine());

            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            result = 0;
            min = 250;

            min = search(map, result, N, 0, 0, min);


            System.out.println("#" + tc + " " + min);
        }
    }
}
