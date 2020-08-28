package SW_algorithm.Brandi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BrandiTest_1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int start = 0;

        int[] map = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
            if (map[i] == 1) {
                start = i;
                break;
            }
        }

        int cnt = 2;

        if (K == N) cnt = 1;
        else if (K <= N / 2) {
            int left = start - 1;
            int right = N - start;
            boolean chk = (left % (K - 1)) + (right % (K - 1)) == 0;

            cnt = (left / (K - 1)) + (right / (K - 1));

            if (!chk) cnt++;
        }

        System.out.println(cnt);

    }

}
