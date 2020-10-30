package Programmers;

import java.util.Arrays;
import java.util.Stack;

public class Stock {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(solution(input)));
    }

    public static int[] solution(int[] prices) {
        Stack st = new Stack();
        Stack indexSt = new Stack();
        int size = prices.length;
        int[] answer = new int[size];
        st.push(prices[0]);
        indexSt.push(0);

        for (int i = 1; i < size; i++) {

            while (!st.empty() && (int) st.peek() > prices[i]) {
                int index = (int) indexSt.pop();
                st.pop();
                answer[index] = i - index;
            }

            st.push(prices[i]);
            indexSt.push(i);
        }

        while (!indexSt.empty()) {
            int index = (int) indexSt.pop();
            answer[index] = size - index - 1;
        }

        return answer;
    }
}
