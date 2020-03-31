package SW_algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;

    /*
       https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWQl9TIK8qoDFAXj
       SW EXPERT -> 4613번 문제
     */

    /*
    테스트 케이스

    2
    4 5
    WRWRW
    BWRWB
    WRWRW
    RWBWR
    6 14
    WWWWWWWWWWWWWW
    WWRRWWBBBBBBWW
    WRRRWWWBWWWWRB
    WWBWBWWWBWRRRR
    WBWBBWWWBBWRRW
    WWWWWWWWWWWWWW

    */
    class NUM4613
    {
        static List<Integer> cntChange(String[] rus, int N, int M) {
            List<Integer> cnt= new ArrayList<Integer>();
            int cntNum = 0;
            for(int W = 1; W < N - 1; W++) {
                for(int B = 1; B < N - 1; B++) {
                    for(int R = 1; R < N - 1; R++) {
                        if(W + B + R == N) {
                            cntNum = 0;
                            for(int i = 0; i < W; i++) {
                                for(int j = 0; j < M; j++) {
                                    if(rus[i].charAt(j) != 'W') {
                                        cntNum++;
                                    }
                                }
                            }
                            for(int i = W; i < W + B; i++) {
                                for(int j = 0; j < M; j++) {
                                    if(rus[i].charAt(j) != 'B') {
                                        cntNum++;
                                    }
                                }
                            }
                            for(int i = W + B; i < N; i++) {
                                for(int j = 0; j < M; j++) {
                                    if(rus[i].charAt(j) != 'R') {
                                        cntNum++;
                                    }
                                }
                            }
                            cnt.add(cntNum);
                        }
                    }
                }
            }
            return cnt;
        }



        public static void main(String args[]) throws Exception
        {

            Scanner sc = new Scanner(System.in);
            int T;
            T=sc.nextInt();

            for(int test_case = 1; test_case <= T; test_case++)
            {

                List<Integer> cntArr = new ArrayList<Integer>();
                int N = sc.nextInt();
                int M = sc.nextInt();
                String[] str = new String[N];
                for(int i = 0; i < N; i++) {

                    str[i] = sc.next();
                }
                cntArr = cntChange(str, N, M);

                System.out.println("#" + test_case + " " + Collections.min(cntArr));

        }
    }
}
