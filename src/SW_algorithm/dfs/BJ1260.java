package SW_algorithm.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1260 {

    static int[][] map;
    static boolean[] visit;
    static StringBuilder sb;
    static int N, M, V;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }

        dfs(V);

        System.out.println(sb);

        sb = new StringBuilder();
        visit = new boolean[N + 1];

        bfs(V);

        System.out.println(sb);

    }

    public static void dfs(int x) {
        visit[x] = true;
        sb.append(x);
        sb.append(" ");

        for (int i = 1; i <= N; i++) {
            if(map[x][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        visit[x] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            sb.append(temp);
            sb.append(" ");

            for (int i = 1; i <= N; i++) {
                if (map[temp][i] == 1 && !visit[i]) {
                    visit[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

}
