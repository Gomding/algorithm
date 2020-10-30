package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class TruckBridge {
    public static void main(String[] args) {
        int bridge_length1 = 2;
        int weight1 = 10;
        int[] truck_weights1 = {7, 4, 5, 6};
        int bridge_length2 = 100;
        int weight2 = 100;
        int[] truck_weights2 = {10};
        int bridge_length13 = 100;
        int weight3 = 100;
        int[] truck_weights3 = {10,10,10,10,10,10,10,10,10,10};

        System.out.println(solution(bridge_length1, weight1, truck_weights1));
        System.out.println(solution(bridge_length2, weight2, truck_weights2));
        System.out.println(solution(bridge_length13, weight3, truck_weights3));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue onTheRoad = new LinkedList();
        int size = truck_weights.length;
        int now_weight = 0;

        for (int w : truck_weights) {

            while (true) {

                if (onTheRoad.isEmpty()) {
                    onTheRoad.offer(w);
                    now_weight += w;
                    answer++;
                    break;
                } else if (onTheRoad.size() == bridge_length) {
                    now_weight -= (int)onTheRoad.poll();
                }else {
                    if (now_weight + w > weight) {
                        onTheRoad.offer(0);
                        answer++;
                    }else {
                        onTheRoad.offer(w);
                        now_weight += w;
                        answer++;
                        break;
                    }
                }
            }
        }

        return answer + bridge_length;
    }
}
