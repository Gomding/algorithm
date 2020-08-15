package SW_algorithm.DP;

/*

https://www.acmicpc.net/problem/1038

문제
음이 아닌 정수 X의 자릿수가 가장 큰 자릿수부터 작은 자릿수까지 감소한다면, 그 수를 감소하는 수라고 한다.

예를 들어, 321과 950은 감소하는 수지만, 322와 958은 아니다. N번째 감소하는 수를 출력하는 프로그램을 작성하시오.

0은 0번째 감소하는 수이고, 1은 1번째 감소하는 수이다. 만약 N번째 감소하는 수가 없다면 -1을 출력한다.

입력
첫째 줄에 N이 주어진다. N은 1,000,000보다 작거나 같은 자연수 또는 0이다.

출력
첫째 줄에 N번째 감소하는 수를 출력한다.

예제 입력 1
18

예제 출력 1
42

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1038 {

    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        reduceNum();
    }

    public static void reduceNum() {

        int count = 0;
        long num = 0;

        if (N > 1022) {
            System.out.println(-1);
            return;
        }

        while(true) {
            boolean isReduce = true;
            long temp = num;
            long jump = 1;
            long before = -1;

            while(temp != 0) {

                if (temp % 10 <= before) {
                    isReduce = false;
                }

                if (!isReduce && temp % 10 > before) {
                    break;
                }

                jump *= 10;
                before = temp % 10;
                temp /= 10;

            }

            if (isReduce) {
                if (N == count++) {
                    break;
                }
                num++;
            }else {
                jump /= 10;
                num += jump;
                num = num / jump * jump;
                //System.out.println(num);
                continue;
            }

        }
        System.out.println(num);

    }

}
