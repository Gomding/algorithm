package Programmers;

public class test22 {

    public static void main(String[] args) {

        String input1 = "PM 03:29:50";
        String input2 = "AM 11:59:59";
        int n = 10;

        System.out.println(solution(input1, n));
        System.out.println(solution(input2, n));
        System.out.println(solution(input1, 200000));
        System.out.println(solution(input2, 200000));

    }

    public static String solution(String p, int n) {

        String answer = "";

        String amORpm = p.substring(0, 2);
        String timeStr = p.substring(3, p.length());
        String[] timeSplit = timeStr.split(":");

        int[] time = new int[3];

        for (int i = 0; i < 3; i++) {
            time[i] = Integer.parseInt(timeSplit[i]);
        }

        if (amORpm.equals("PM")) {
            time[0] += 12;
        }

        answer = transSecond(n, time);


        return answer;
    }


    public static String transSecond(int n, int[] time) {
        int plushour = 0;
        int plusmin = 0;
        int plussec = 0;

        plushour = n / 3600;
        plusmin = (n % 3600) / 60;
        plussec = n % 60;

        time[0] += plushour;
        time[1] += plusmin;
        time[2] += plussec;

        if (time[2] >= 60) {
            time[1] += time[2] / 60;
            time[2] %= 60;
        }
        if (time[1] >= 60) {
            time[0] += time[1] / 60;
            time[1] %= 60;
        }
        if (time[0] >= 24) {
            time[0] %= 24;
        }


        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 2; i ++) {
            if(time[i] < 10) {
                sb.append("0");
            }
            sb.append(time[i]);
            sb.append(":");
        }
        if (time[2] < 10) {
            sb.append("0");
        }
        sb.append(time[2]);

        return sb.toString();

    }


}
