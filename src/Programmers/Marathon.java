package Programmers;

import java.util.HashMap;
import java.util.Map;

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

        return null;
    }

}
