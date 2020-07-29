package SW_algorithm.SW_academy;

/*
SW Expert NO.9317 - 석찬이의 받아쓰기게임

https://swexpertacademy.com/main/solvingProblem/solvingProblem.do


 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NUM9317 {

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        int N; // 석찬이가 받아쓸 문장의 글자 수
        char[] content;     // 받아쓰기 할 문장
        char[] SCContent;   // 석찬이가 받아 쓴 문장
        int passCnt;            // 석찬이가 맞춘 글자 수

        for (int tc = 1; tc <= T; tc++) {

            passCnt = 0;

            N = Integer.parseInt(bf.readLine());

            content = new char[N];
            SCContent = new char[N];

            content = bf.readLine().toCharArray();
            SCContent = bf.readLine().toCharArray();

            for (int i = 0; i < N; i++) {
                if (content[i] == SCContent[i])
                    passCnt++;
            }

            System.out.println("#" + tc + " " + passCnt);
        }
    }
}
