package Programmers;

import java.util.*;

public class Printer {
    public static void main(String[] args) {
        int[] priorities1 = {2, 1, 3, 2};
        int location1 = 2;
        int[] priorities2 = {1, 1, 9, 1, 1, 1};
        int location2 = 0;

        System.out.println(solution(priorities1, location1));
        System.out.println(solution(priorities2, location2));
    }

    public static int solution(int[] priorities, int location) {
        int answer = location;
        int printed = 0;
        Queue<Integer> prints = new LinkedList<>();
        List<Integer> list = new LinkedList<>();

        for (int num : priorities) {
            list.add(num);
            prints.offer(num);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        while (!prints.isEmpty()) {
            int priority = list.get(0);

            if (priority <= prints.peek()) {
                prints.poll();
                list.remove(0);
                printed++;
                if (answer == 0) break;
                answer--;
            } else {
                prints.offer(prints.poll());
                if (answer == 0) answer = prints.size() - 1;
                else answer--;

            }
        }

        return printed;
    }
}
