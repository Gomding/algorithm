package Programmers;

import java.util.*;

public class MockTest {
    public static void main(String[] args) {
        int[] answers1 = {1, 2, 3, 4, 5};
        int[] answers2 = {1, 3, 2, 4, 2};

        System.out.println(Arrays.toString(solution(answers1)));
        System.out.println(Arrays.toString(solution(answers2)));
    }

    public static int[] solution(int[] answers) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 5, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] scores = new int[3];

        for (int i=0; i < answers.length; i++) {
            if (answers[i] == pattern1[i % pattern1.length]) {
                scores[0]++;
            }
            if (answers[i] == pattern2[i % pattern2.length]) {
                scores[1]++;
            }
            if (answers[i] == pattern3[i % pattern3.length]) {
                scores[2]++;
            }
        }

        int max = 0;

        for (int i=0; i < 3; i++) {
            max = Math.max(max, scores[i]);
        }
        for (int i=0; i < 3; i++) {
            if (scores[i] == max) list.add(i + 1);
        }

        answer = list.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}
