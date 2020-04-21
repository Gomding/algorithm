package SW_algorithm;

/*

SW Expert NO.7675 통역사 성경이

https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWqPvqoqSLQDFAT_&categoryId=AWqPvqoqSLQDFAT_&categoryType=CODE&&&

성경이는 대통령 직속 통역관이다.

대통령은 사람 이름을 외우는 것을 굉장히 중요시 한다.

따라서 외국 대사와의 대화에서 나오는 모든 이름을 외워달라고 성경이에게 부탁했다.

외국 대사는 총 N개의 문장을 말했다.

각 문장의 마지막 단어는 세 가지 구두점 ‘.’, ‘?’, ‘!’ 중 하나를 마지막에 포함한다.

문장은 대소문자 알파벳와 숫자로 이루어진 단어들이 공백을 사이에 두고 구성되어 있으며, 예외적으로 마지막 단어는 구두점으로 끝나게 된다.

이름은 대문자 알파벳으로 시작하며 나머지는 소문자 알파벳인 단어들이다.

예외적으로, 단어의 마지막이 구두점일 경우에도 이름이며, 대문자 한글자도 이름이다.

성경이는 대통령을 위해서 외국 대사와의 대화를 문서로 받아서 이름이 몇 번 나오는 지를 알려줘야 한다.

N개의 문장을 받아서 문장 별로 이름의 개수를 구하여라.


[입력]

첫 번째 줄에 테스트 케이스의 수 T(1 ≤ T ≤ 11)가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 문장의 개수 N(1 ≤ N ≤ 5)이 주어진다.

두 번째 줄에는 N개의 문장이 주어지며, 총 문자의 개수는 1,000개 이하이다.


[출력]

각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,

N개의 수를 공백 하나로 구분하여 출력해야 하며, 각수는 각 문장에 속한 이름의 개수여야 한다.



입력
2
2
Annyung Hasae Yo! LoL!
3
my name is Hye Soo. my id is Rhs0266. what your id Bro?

출력
#1 3 0
#2 2 0 1

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NUM7675 {

    public static void main(String[] args)  throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        int N;      // 외국인이 말하는 문장의 개수
        int cnt;
        boolean name;

        String content;

        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(bf.readLine());

            //ArrayList<String> content = new ArrayList<String>();

            content = bf.readLine();
            cnt = 0;
            name = false;

            System.out.print("#" + tc);

            if (Character.isUpperCase(content.charAt(0))) {
                name = true;
                cnt++;
            }

            for (int i = 1; i < content.length(); i++) {
                if(content.charAt(i) == '!' || content.charAt(i) == '.' || content.charAt(i) == '?') {
                    System.out.print(" " + cnt);
                    cnt = 0;
                }
                else if(content.charAt(i) == ' ') {
                    if (name == true) {
                        name = false;
                    }
                    i++;
                    if (Character.isUpperCase(content.charAt(i))) {
                        name = true;
                        cnt++;
                    }
                }
                else if (Character.isLowerCase(content.charAt(i)) == false) {
                    if (name == true) {
                        name = false;
                        cnt--;
                    }
                }
            }
            System.out.println();
        }
    }
}
