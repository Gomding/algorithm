package SW_algorithm;

/*

[1,3,4,5,8,2,1,4,5,9,5] "right" => "LRLLLRLLRRL"
[7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2] "left"  => "LRLLRRLLLRR"
[1,2,3,4,5,6,7,8,9,0]   "right" => "LLRLLRLLRL"

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kakao2020_1 {



    static int rightX;
    static int rightY;
    static int leftX;
    static int leftY;
    static String h;

    public static String pos(int middleY) {

        String str = "";

        int a = Math.abs(1 - leftX) + Math.abs(middleY - leftY);
        int b = Math.abs(1 - rightX) + Math.abs(middleY - rightY);

        if (a < b){
            leftX = 1;
            leftY = middleY;
            str = "L";
        }
        else if (b < a) {
            rightY = middleY;
            rightX = 1;
            str = "R";
        }
        else {
            if (h.equals("L")) {
                leftX = 1;
                leftY = middleY;
            }
            else {
                rightY = middleY;
                rightX = 1;
            }

            str = h;
        }

        return str;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        char[] push;
        String hand;

        for (int tc = 1; tc <= T; tc++) {

            StringBuilder sb = new StringBuilder();

            sb.append("#" + tc + " ");

            push = bf.readLine().toCharArray();

            hand = bf.readLine();

            leftX = 0;
            leftY = 3;
            rightX = 2;
            rightY = 3;


            if (hand.equals("left"))
                h = "L";
            else
                h = "R";



            for (int i = 0; i < push.length; i++) {

                switch (push[i]) {
                    case '1':
                        leftY = 0;
                        leftX = 0;
                        sb.append("L");
                        break;
                    case '4':
                        leftY = 1;
                        leftX = 0;
                        sb.append("L");
                        break;
                    case '7':
                        leftY = 2;
                        leftX = 0;
                        sb.append("L");
                        break;
                    case '*':
                        leftY = 3;
                        leftX = 0;
                        sb.append("L");
                        break;
                    case '3':
                        rightX = 2;
                        rightY = 0;
                        sb.append("R");
                        break;
                    case '6':
                        rightX = 2;
                        rightY = 1;
                        sb.append("R");
                        break;
                    case '9':
                        rightX = 2;
                        rightY = 2;
                        sb.append("R");
                        break;
                    case '#':
                        rightX = 2;
                        rightY = 3;
                        sb.append("R");
                        break;
                    case '2':
                        sb.append(pos(0));
                        break;
                    case '5':
                        sb.append(pos(1));
                        break;
                    case '8':
                        sb.append(pos(2));
                        break;
                    case '0':
                        sb.append(pos(3));
                        break;

                }

            }
            System.out.println(sb);
        }
    }
}
