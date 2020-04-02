package SW_algorithm;


    import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWRKWITqfvIDFAV8

SW Expert NO. 4676 - 늘어지는 소리 만들기

단어의 중간에 ‘-’(하이픈)을 넣어 늘어지는 소리를 표현해보자.

예를 들어 “wow”같은 문자열에서 두 번째 문자 ‘o’의 뒤편에 두 개의 하이픈을, 세 번째 문자 ‘w’의 뒤편에 한 개의 하이픈을 넣는다고 해보자. 그러면 문자열은 “wo--w-“가 될 것이다.

알파벳 소문자로 이루어진 문자열과 어떤 문자의 뒤편에 하이픈을 넣을 지 여부가 주어질 때 하이픈을 모두 넣고 나면 문자열이 어떻게 되는지 출력하는 프로그램을 작성하라.


 [입력]

첫 번째 줄에 테스트 케이스의 수 T(T ≤ 1000)가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 길이가 1이상 20이하인 문자열이 주어진다. 이 문자열은 알파벳 소문자만으로 이루어져 있다. 이 문자열의 길이를 L이라고 하자.

두 번째 줄에는 몇 개의 하이픈을 넣을지를 의미하는 자연수 H(1 ≤ H ≤ 100)이 주어진다.

세 번째 줄에는 하이픈을 넣을 위치를 의미하는 H개의 0이상 L이하인 정수가 공백으로 구분되어 주어진다.

예를 들어 주어진 문자열이 “abc”이고 하이픈을 넣을 위치가 0이라면 “-abc”가 되고, 문자열이 “abc”이고 하이픈을 넣을 위치가 2이라면 “ab-c“가 된다.

 [출력]

각 줄마다 "#T" (T는 테스트 케이스 번호)를 출력한 뒤, 주어진 문자열에 하이픈을 넣어서 출력한다.

[입력 예제]
2
wow
3
2 3 2
hoi
3
0 0 0

[예제 결과]
#1 wo--w-
#2 ---hoi

 */

public class NUM4676 {

        static String[] addH(String[] c, int [] idx) {
            for(int i = 0; i < idx.length; i++) {
                c[idx[i]] += '-';
            }
            return c;
        }

        public static void main(String args[]) throws Exception{

            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int T = Integer.parseInt(bf.readLine());
            //StringTokenizer st = new StringTokenizer(bf.readLine());
            String word;
            String[] wordAdd;
            int H;
            int[] idxArr;

            for(int test_case = 1; test_case <= T; test_case++)
            {
                word = bf.readLine();
                H = Integer.parseInt(bf.readLine());
                StringTokenizer st = new StringTokenizer(bf.readLine());

                idxArr = new int[H];
                for(int i = 0; i < H; i++) {
                    idxArr[i] = Integer.parseInt(st.nextToken());
                }

                wordAdd = new String[word.length() + 1];
                wordAdd[0] = "";
                for(int i = 1; i <= word.length(); i++) {
                    wordAdd[i] = String.valueOf(word.charAt(i - 1));
                }

                wordAdd = addH(wordAdd, idxArr);
                System.out.print("#" + test_case + " ");
                for(int i = 0; i < wordAdd.length; i++) {
                    System.out.print(wordAdd[i]);
                }
                System.out.println();
            }


    }
}
