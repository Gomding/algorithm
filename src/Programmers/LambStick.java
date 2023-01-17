package Programmers;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/120830">문제 링크</a>
 */
public class LambStick {

    private static final int LAMB_STICK_PRICE = 12_000;
    private static final int DRINK_STICK_PRICE = 2_000;
    private static final int DRINK_SERVICE_COUNT_CRITERIA = 10;

    public static void main(String[] args) {
        LambStick lambStick = new LambStick();
        int result = lambStick.solution(10, 10);
        System.out.println(result);
    }

    public int solution(int n, int k) {
        int answer = calcPrice(n, k);
        return answer;
    }

    private int calcPrice(int lambStickCount, int drinkCount) {
        int drinkServiceCount = calcDrinkService(lambStickCount);
        int price = (lambStickCount * LAMB_STICK_PRICE) + ((drinkCount - drinkServiceCount) * DRINK_STICK_PRICE);
        return price;
    }

    private int calcDrinkService(int lambStickCount) {
        return lambStickCount / DRINK_SERVICE_COUNT_CRITERIA;
    }
}