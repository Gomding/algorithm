package Programmers;

import java.util.HashSet;
import java.util.Set;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/1845
 *
 * N/2 마리 포켓몬을 가져감
 * 포켓몬은 종류에 따라 번호를 붙여서 구분
 * 같은 종류라면 같은 번호를 가짐
 */
public class PhoneKetMon {

    public static void main(String[] args) {
        PhoneKetMon phoneKetMon = new PhoneKetMon();
        int[] nums = {1, 2, 2, 3};
        int result = phoneKetMon.solution(nums);
        System.out.println(result);
    }

    public int solution(int[] nums) {
        int phoneKetMonKindCount = calcPhoneKetMonKindCount(nums);
        int selectableCount = getSelectableCount(nums);
        int answer = Math.min(phoneKetMonKindCount, selectableCount);
        return answer;
    }

    private static int getSelectableCount(int[] phoneKetMons) {
        return phoneKetMons.length / 2;
    }

    private int calcPhoneKetMonKindCount(int[] phoneKetMons) {
        Set<Integer> phoneKetMonKind = new HashSet<>();
        for (int phoneKetMon : phoneKetMons) {
            phoneKetMonKind.add(phoneKetMon);
        }
        return phoneKetMonKind.size();
    }
}
