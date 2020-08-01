package SW_algorithm.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ2667 {

    static int N, cnt;
    static int[][] map;
    static int[] nx = {0, 1, 0, -1};
    static int[] ny = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();

        int total = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (map[i][j] == 1) {
                    cnt = 0;
                    dfs(i, j);
                    total++;
                    q.offer(cnt);
                }
            }
        }

        sb.append(total + "\n");
        while (!q.isEmpty()) {
            sb.append(q.poll() + "\n");
        }

        System.out.println(sb);

    }


    static void dfs(int x, int y) {
        map[x][y] = 0;
        cnt++;

        for (int i = 0; i < 4; i++) {
            int xx = x + nx[i];
            int yy = y + ny[i];

            if (xx >= 0 && xx < N && yy >= 0 && yy < N) {
                if (map[xx][yy] == 1) {
                    dfs(xx, yy);
                }
            }

        }
    }

}
