package Programmers;

public class Protractor {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(180);
        System.out.println(result);
    }
}

class Solution {
    private static final int ACUTE_ANGLE_SYMBOL = 1;
    private static final int RIGHT_ANGLE_SYMBOL = 2;
    private static final int OBTUSE_ANGLE_SYMBOL = 3;
    private static final int FLAT_ANGLE_SYMBOL = 4;

    public int solution(int angle) {
        if (isAcuteAngle(angle)) {
            return ACUTE_ANGLE_SYMBOL;
        }

        if (isRightAngle(angle)) {
            return RIGHT_ANGLE_SYMBOL;
        }

        if (isObtuseAngle(angle)) {
            return OBTUSE_ANGLE_SYMBOL;
        }
        if (isFlatAngle(angle)) {
            return FLAT_ANGLE_SYMBOL;
        }
        throw new IllegalArgumentException("지원하지 않는 각도 입니다.");
    }

    private boolean isAcuteAngle(int angle) {
        return angle > 0 && angle < 90;
    }

    private boolean isRightAngle(int angle) {
        return angle == 90;
    }

    private boolean isObtuseAngle(int angle) {
        return angle > 90 && angle < 180;
    }

    private boolean isFlatAngle(int angle) {
        return angle == 180;
    }
}