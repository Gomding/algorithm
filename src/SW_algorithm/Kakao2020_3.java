package SW_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Kakao2020_3 {

    static int start;
    static int end;
    static List<String> jems;
    static String[] table;

    public static void search() {
        for (int i = 0; i < table.length; i++) {
            List<String> jem = new ArrayList<String>();
            jem.addAll(jems);

            for (int j = i; j < table.length; j++) {

                if (jem.indexOf(table[j]) != -1) {

                    jem.remove(table[j]);

                    if (jem.isEmpty()) {
                        if (end - start > j - i) {
                            start = i;
                            end = j;
                        }
                        break;
                    }
                }

            }

            if (table.length - i < jems.size())
                break;

        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        String content;

        for (int tc = 1; tc <= T; tc++) {

            content = bf.readLine();

            table = content.split(",");

            jems = new ArrayList<String>();

            for (int i = 0; i < table.length; i++) {
                if (jems.indexOf(table[i]) == -1) {
                    jems.add(table[i]);
                }
            }

            start = 0;
            end = table.length - 1;

            search();

            System.out.println("#" + tc + " [" + (start + 1) + ", " + (end + 1) + "]");

        }
    }
}
