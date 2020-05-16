package SW_algorithm;

/*

[[0,0,0],[0,0,0],[0,0,0]] = 900
[[0,0,0,0,0,0,0,1],[0,0,0,0,0,0,0,0],[0,0,0,0,0,1,0,0],[0,0,0,0,1,0,0,0],[0,0,0,1,0,0,0,1],[0,0,1,0,0,0,1,0],[0,1,0,0,0,1,0,0],[1,0,0,0,0,0,0,0]] = 3800
[[0,0,1,0],[0,0,0,0],[0,1,0,1],[1,0,0,0]] = 2100
[[0,0,0,0,0,0],[0,1,1,1,1,0],[0,0,1,0,0,0],[1,0,0,1,0,1],[0,1,0,0,0,1],[0,0,0,0,0,0]] = 2100

0,0,0 0,0,0 0,0,0

0,0,0
0,0,0
0,0,0

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Kakao2020_4 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        String lines;
        String[] arr;
        String[] line;
        List<Integer> mapLine;
        List<List<Integer>> map;

        for (int tc = 1; tc <= T; tc++) {

            mapLine = new ArrayList<Integer>();
            map = new ArrayList<List<Integer>>();

            lines = bf.readLine();
            arr = lines.split(" ");

            for (int i = 0; i < arr.length; i++) {

                line = arr[i].split(",");

                for (int j = 0; j < line.length; j++) {
                    mapLine.add(Integer.parseInt(line[i]));
                }
                map.add(mapLine);

            }


        }

    }

}
