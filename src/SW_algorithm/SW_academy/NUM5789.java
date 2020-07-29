package SW_algorithm.SW_academy;

/*

SW Expert - 5789. 현주의 상자 바꾸기

https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWYygN36Qn8DFAVm&categoryId=AWYygN36Qn8DFAVm&categoryType=CODE

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NUM5789 {

    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());
        int N;
        int Q;
        int L;
        int R;
        int[] map;

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            N = Integer.parseInt(st.nextToken());
            Q = Integer.parseInt(st.nextToken());

            map = new int[N + 1];

            for (int i = 1; i <= Q; i++) {
                st = new StringTokenizer(bf.readLine());

                L = Integer.parseInt(st.nextToken());
                R = Integer.parseInt(st.nextToken());

                for (int j = L; j <= R; j++) {
                    map[j] = i;
                }
            }

            System.out.print("#" + tc + " ");
            for (int i = 1; i <= N; i++) {
                System.out.print(map[i] + " ");
            }
            System.out.println();


        }
    }
}
