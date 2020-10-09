package Programmers;

import java.util.HashMap;
import java.util.Map;

public class Spy {

    public static void main(String[] args) {

        String[][] input1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        System.out.println(solution(input1));

    }

    public static int solution(String[][] clothes) {
        int answer = 1;
        int size = clothes.length;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < size; i++) {
            String clothType = clothes[i][1];
            map.put(clothType, map.getOrDefault(clothType, 0) + 1);
        }

        for (String cloth : map.keySet()) {
            answer *= (map.get(cloth) + 1);
        }

        answer--;

        return answer;
    }

}
