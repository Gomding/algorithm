package Programmers;

import java.util.*;

public class Dev {
    public static void main(String[] args) {
        int[] progresses1 = {93, 30, 55};
        int[] speeds1 = {1, 30, 5};
        int[] progresses2 = {95, 90, 99, 99, 80, 99};
        int[] speeds2 = {1,1,1,1,1,1};

        System.out.println(Arrays.toString(solution(progresses1, speeds1)));
        System.out.println(Arrays.toString(solution(progresses2, speeds2)));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> index = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int days = 1;

        for (int i = 0; i < progresses.length; i++) {
            index.offer(i);
        }

        while (!index.isEmpty()) {
            int progress = progresses[index.peek()];
            int speed = speeds[index.peek()];
            int finish = 0;
            if (progress + (speed * days) >= 100) {
                while (!index.isEmpty() && progresses[index.peek()] + (speeds[index.peek()] * days) >= 100) {
                    index.poll();
                    finish++;
                }
                list.add(finish);
            }
            days++;
        }

        int[] answer = new int[list.size()];

        for (int i=0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

}
