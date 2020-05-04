package SW_algorithm;

/*

SW Expert - 5948. 새샘이의 7-3-5 게임

https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWZ2IErKCwUDFAUQ&categoryId=AWZ2IErKCwUDFAUQ&categoryType=CODE

숫자게임을 좋아하는 새샘이는 서로 다른 7개의 정수 중에서 3개의 정수를 골라 합을 구해서 수를 만들려고 한다.

이렇게 만들 수 있는 수 중에서 5번째로 큰 수를 출력하는 프로그램을 작성하라.


[입력]

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 7개의 서로 다른 정수가 공백으로 구분되어 주어진다. 각 정수는 1이상 100이하이다.


[출력]

각 테스트 케이스마다 첫 번째 줄에는 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고, 답을 출력한다.

입력
2
1 2 3 4 5 6 7
5 24 99 76 1 77 6

출력
#1 14
#2 181



 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NUM5948 {

    private static int[] nums;
    private static int cnt;
    private static ArrayList<Integer> result;

    public static void main(String[] args) throws IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(bf.readLine());

            nums = new int[7];

            for (int i = 0; i < 7; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(nums);
            result = new ArrayList<Integer>();

            for (int i = 6; i > 1; i--) {
                for (int j = i - 1; j > 0; j--) {
                    for (int k = j - 1; k >= 0; k--) {
                        int a = nums[i] + nums[j] + nums[k];
                        if (result.indexOf(a) == -1) {
                            result.add(a);
                        }
                    }
                }
            }

            result.sort(null);

            System.out.println("#" + tc + " " + result.get(result.size() -5));
        }
    }
}
