package Programmers;

public class PhoneBook {

    public static void main(String[] args) {

        String[] input1 = {"119", "97674223", "1195524421"};
        String[] input2 = {"123", "456", "789"};

        System.out.println(solution(input1));
        System.out.println(solution(input2));

    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        int size = phone_book.length;

        for (int i = 0; i < size; i++) {
            int nowNumber_length = phone_book[i].length();

            for (int j = 0; j < size; j++) {

                if (i == j) continue;

                if (nowNumber_length > phone_book[j].length()) continue;

                if (phone_book[i].equals(phone_book[j].substring(0, nowNumber_length))) {

                    return false;
                }

            }


        }

        return answer;
    }

}
