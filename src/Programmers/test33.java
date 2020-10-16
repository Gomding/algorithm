package Programmers;

import java.util.*;

public class test33 {

    public static void main(String[] args) {

        String[] votes1 = {"AVANT", "PRIDO", "SONATE", "RAIN", "MONSTER", "GRAND", "SONATE", "AVANT", "SONATE", "RAIN", "MONSTER", "GRAND", "SONATE", "SOULFUL", "AVANT", "SANTA"};

        System.out.println(solution(votes1, 2));
    }

    public static String solution(String[] votes, int k) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        int size = votes.length;

        for (int i = 0; i < size; i++) {
            map.put(votes[i], map.getOrDefault(votes[i], 0) + 1);
        }

        for (String name : map.keySet()) {
            list.add(name);
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (map.get(o1) == map.get(o2)) {
                    return o2.compareTo(o1);
                }else {
                    return map.get(o1) - map.get(o2);
                }
            }
        });

        int list_size = list.size();
        int maxVote = 0;

        for (int i = list_size - 1; i > list_size -1 - k; i--) {
            maxVote += map.get(list.get(i));
        }

        int outVote = 0;
        for (int i = 0; i < list_size; i++) {
            outVote += map.get(list.get(i));
            if (outVote >= maxVote) {
                answer = list.get(i - 1);
                break;
            }
        }

        return answer;
    }
}
