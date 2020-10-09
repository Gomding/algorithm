package Programmers;

public class BiggerNumber {

    public static void main(String[] args) {



    }

    public static int solution(int n) {
        int answer = 0;

        int num1Cnt = Integer.bitCount(n);

        for (int i = n + 1; ; i++) {
            if (num1Cnt == Integer.bitCount(i)) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
