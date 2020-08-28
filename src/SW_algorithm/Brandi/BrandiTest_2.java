package SW_algorithm.Brandi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BrandiTest_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            st = new StringTokenizer(br.readLine());

            long N = Long.parseLong(st.nextToken()); // 시즌 한정
            long M = Long.parseLong(st.nextToken()); // 일반

            long cnt = 0;

            long eventN = N / 5;
            long eventM = M / 7;

            cnt = Math.min(eventM, eventN);

            if (eventN > eventM) {
                long restN = ((eventN - eventM) * 5) + eventN % 5;
                long restM = (M % 7);

                long rest = (restN + restM) / 12;
                cnt += rest;
            }

            System.out.println(cnt);

        }

    }

}
