package devmatching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test1 {

    public static void main(String[] args) {

        int[][] input1 = {{1, 4}, {3, 4}, {3, 10}};

        System.out.println(Arrays.toString(solution(input1)));

    }

    public static int[] solution(int[][] v) {
        int[] answer = new int[2];

        Map<Integer, Integer> xmap = new HashMap<>();
        Map<Integer, Integer> ymap = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            xmap.put(v[i][0], xmap.getOrDefault(v[i][0], 0) + 1);
            ymap.put(v[i][1], ymap.getOrDefault(v[i][1], 0) + 1);
        }

        for (int x : xmap.keySet()) {
            if (xmap.get(x) == 1) answer[0] = x;
        }

        for (int y : ymap.keySet()) {
            if (ymap.get(y) == 1) answer[1] = y;
        }

        return answer;
    }

}
