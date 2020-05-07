package SW_algorithm;

/*

입력
3
3
0 18 34
48 0 55
18 7 0
4
0 83 65 97
82 0 78 6
19 19 0 82
6 34 94 0
5
0 9 26 85 42
14 0 84 31 27
58 88 0 16 46
83 61 94 0 17
40 71 24 38 0

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NUMxx {

    public static int search (int[][] map, boolean[] nums, int result, int min, int start, int arrival, int N, boolean move) {

        nums[arrival] = true;
        result += map[start][arrival];
        boolean chk = true;

        if (!move) {
            for (int i = 1; i < N; i++) {
                if (!nums[i]) {
                    boolean[] n = new boolean[N];
                    for (int j = 0; j < N; j++) {
                        n[j] = nums[j];
                    }
                    chk = false;
                    min = search(map, n, result, min, arrival, i, N, chk);
                }
            }
            if (chk)
                min = search(map, nums, result, min, arrival, 0, N, chk);
        }

        else if (start > 0 && arrival == 0) {
            if (result < min) {
                min = result;
            }
        }

        return min;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        int[][] map;
        int N;
        int result;
        int min;
        boolean[] nums;

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

            min = 10000;
            result = 0;
            nums = new boolean[N];


            min = search(map, nums, result, min, 0, 0, N, false);

            System.out.println("#" + tc + " " + min);
        }
    }
}
