package Kakao2020;

/*

문제 설명
직사각형을 만드는 데 필요한 4개의 점 중 3개의 좌표가 주어질 때, 나머지 한 점의 좌표를 구하려고 합니다. 점 3개의 좌표가 들어있는 배열 v가 매개변수로 주어질 때, 직사각형을 만드는 데 필요한 나머지 한 점의 좌표를 return 하도록 solution 함수를 완성해주세요. 단, 직사각형의 각 변은 x축, y축에 평행하며, 반드시 직사각형을 만들 수 있는 경우만 입력으로 주어집니다.

제한사항
v는 세 점의 좌표가 들어있는 2차원 배열입니다.
v의 각 원소는 점의 좌표를 나타내며, 좌표는 [x축 좌표, y축 좌표] 순으로 주어집니다.
좌표값은 1 이상 10억 이하의 자연수입니다.
직사각형을 만드는 데 필요한 나머지 한 점의 좌표를 [x축 좌표, y축 좌표] 순으로 담아 return 해주세요.
입출력 예
v	result
[[1, 4], [3, 4], [3, 10]]	[1, 10]
[[1, 1], [2, 2], [1, 2]]	[2, 1]
입출력 예 설명
입출력 예 #1
세 점이 [1, 4], [3, 4], [3, 10] 위치에 있을 때, [1, 10]에 점이 위치하면 직사각형이 됩니다.

입출력 예 #2
세 점이 [1, 1], [2, 2], [1, 2] 위치에 있을 때, [2, 1]에 점이 위치하면 직사각형이 됩니다.

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DemoTest {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] v;

        v = new int[][]{{1, 4}, {3, 4}, {3, 10}};


        int[] result = solution(v);


        System.out.println(result[0] + ", " + result[1]);

    }

    public static int[] solution(int[][] v) {

        int[] answer = new int[2];

        int x1 = v[0][0];
        int y1 = v[0][1];
        int x2 = v[1][0];
        int y2 = v[1][1];
        int x3 = v[2][0];
        int y3 = v[2][1];

        if (x1 == x2) {
            answer[0] = x3;
        } else if (x1 == x3) {
            answer[0] = x2;
        } else {
            answer[0] = x1;
        }


        if (y1 == y2) {
            answer[1] = y3;
        } else if (y1 == y3) {
            answer[1] = y2;
        } else {
            answer[1] = y1;
        }

        return answer;
    }

}
