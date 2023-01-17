package Programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42576
 */
public class Marathon {

    public static void main(String[] args) {

        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        System.out.println(solution(participant, completion));

    }

    public static String solution (String[] participant, String[] completion) {
        Map<String, Integer> nameMap = new HashMap<>();

        for (String name : participant) nameMap.put(name, nameMap.getOrDefault(name, 0) + 1);
        for (String name : completion) nameMap.put(name, nameMap.getOrDefault(name, 0) - 1);

        for (String name : nameMap.keySet()) {
            if (nameMap.get(name) > 0) {
                return name;
            }
        }

        throw new IllegalArgumentException("완주하지 못한 사람을 찾는데 실패했습니다.");
    }

}
