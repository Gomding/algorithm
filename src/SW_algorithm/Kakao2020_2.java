package SW_algorithm;

/*

"100-200*300-500+20" = 60420
"50*6-3*2" = 300

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Kakao2020_2 {

    static List<Integer> nums;
    static List<Character> operator;
    static int max;

    public static void work (char a, char b, char c) {

        List<Character> oper = new ArrayList<Character>();
        oper.addAll(operator);
        List<Integer> n = new ArrayList<Integer>();
        n.addAll(nums);

        while (!oper.isEmpty()) {

            if (oper.indexOf(a) != -1) {
                int idx = oper.indexOf(a);
                System.out.println(idx);
                n.add(idx, cal(n.remove(idx), n.remove(idx), oper.remove(idx)));
            }
            else if (oper.indexOf(b) != -1) {
                int idx = oper.indexOf(b);
                n.add(idx, cal(n.remove(idx), n.remove(idx), oper.remove(idx)));
            }
            else if (oper.indexOf(c) != -1) {
                int idx = oper.indexOf(c);
                n.add(idx, cal(n.remove(idx), n.remove(idx), oper.remove(idx)));
            }
            System.out.println(n.toString());
            System.out.println(oper.toString());

        }

        int result = Math.abs(n.get(0));

        System.out.println("result = " + result + "max = " + max);

        if (max < result) {
            max = result;
        }

    }

    public static int cal (int a, int b, char c) {
        int result;

        if (c == '+') result = a + b;
        else if (c == '-') result = a - b;
        else result = a * b;

        return result;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        char[] content;
        String num;

        for (int tc = 1; tc <= T; tc++) {

            content = bf.readLine().toCharArray();
            num = "";
            operator = new ArrayList<Character>();
            nums = new ArrayList<Integer>();
            max = 0;

            for (int i = 0; i < content.length; i++) {

                if (content[i] == '+' || content[i] == '-' || content[i] == '*') {
                    operator.add(content[i]);
                    nums.add(Integer.parseInt(num));
                    num = "";
                }
                else {
                    num += content[i];
                }

            }

            nums.add(Integer.parseInt(num));

            System.out.println(nums.toString());
            System.out.println(operator.toString());

            work ('+', '-', '*');
            work ('+', '*', '-');
            work ('-', '+', '*');
            work ('-', '*', '+');
            work ('*', '+', '-');
            work ('*', '-', '+');

            System.out.println("#" + tc + " " + max);


        }
    }


}
