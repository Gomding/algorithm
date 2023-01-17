package Programmers;

public class PhoneBook {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        String[] input1 = {"119", "97674223", "1195524421"};
        String[] input2 = {"123", "456", "789"};

        System.out.println(phoneBook.solution(input1));
        System.out.println(phoneBook.solution(input2));
    }

    public boolean solution(String[] input) {
        int phoneNumberTotalCount = input.length;

        for (int i = 0; i < phoneNumberTotalCount; i++) {
            String currentPhoneNumber = input[i];

            for (int j = 0; j < phoneNumberTotalCount; j++) {
                String currentTargetPhoneNumber = input[j];
                if (isSkipStatus(currentPhoneNumber, currentTargetPhoneNumber)) {
                    continue;
                }
                if (isMatchedPrefix(currentPhoneNumber, currentTargetPhoneNumber)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isMatchedPrefix(String currentPhoneNumber, String currentTargetPhoneNumber) {
        return currentPhoneNumber.equals(currentTargetPhoneNumber.substring(0, currentPhoneNumber.length()));
    }

    private boolean isSkipStatus(String currentPhoneNumber, String currentTargetPhoneNumber) {
        return isSamePhoneNumber(currentPhoneNumber, currentTargetPhoneNumber) || 
                isLessThanCurrentPhoneNumberLength(currentPhoneNumber, currentTargetPhoneNumber);
    }

    private boolean isLessThanCurrentPhoneNumberLength(String currentPhoneNumber, String currentTargetPhoneNumber) {
        return currentPhoneNumber.length() > currentTargetPhoneNumber.length();
    }

    private boolean isSamePhoneNumber(String currentPhoneNumber, String currentTargetPhoneNumber) {
        return currentPhoneNumber.equals(currentTargetPhoneNumber);
    }
}
