package SW_algorithm;

/*
    SW Expert - 7701. 염라대왕의 이름 정렬

    https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWqU0zh6rssDFARG

    염라대왕은 이승의 사람들의 모든 이름을 가지고 있다.

어느날 저승에 일어난 진도 8.0 지진에 항상 정리되어 있던 이승 명부가 흐트러졌다.

이승 명부는 이름의 길이가 짧을수록 이 앞에 있었고, 같은 길이면 사전 순으로 앞에 있었다.

이왕 이렇게 된 김에 모든 이름을 다시 정리하고 같은 이름은 하나만 남겨놓기로 한 염라대왕을 도와주자.


[입력]

첫 번째 줄에 테스트 케이스의 수 T(1 ≤ T ≤ 50)가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 이승 명부의 이름 개수 N(1 ≤ N ≤ 20,000)이 주어진다.

각 테스트 케이스의 두 번째 줄부터 N개의 줄에 걸쳐서 알파벳 소문자로 이루어진 이름들이 주어진다.

이름에는 공백이 포함되지 않으며 최소 1개, 최대 50개의 알파벳으로 이루어져 있다.


[출력]

각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,

정리된 이름을 한 줄에 하나씩 출력하라. 같은 이름은 한 번만 출력해야 하는 것을 주의하라.

입력
2
5
my
name
is
ho
seok
12
s
a
m
s
u
n
g
j
j
a
n
g

출력
#1
ho
is
my
name
seok
#2
a
g
j
m
n
s
u

1
5
abc
abd
acc
acc
acb

abc
abd
acb
acc

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class NUM7701 {

    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());
        int N;      // 이름의 개수

        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(bf.readLine());

            ArrayList<String> names = new ArrayList<String>();    // 이름들

            for (int i = 0; i < N; i++) {
                String name = bf.readLine();
                if (names.indexOf(name) == -1) {
                    names.add(name);
                }
            }

            sort(names, names.size());


            System.out.println("#" + tc);

            for (int i = 0; i < names.size(); i++)
                System.out.println(names.get(i));
        }
    }

    static void sort(ArrayList<String> names, int N) {

        for (int i = 0; i < N - 1; i++) {

            for (int j = N - 1; j > i; j--) {

                if(names.get(j - 1).length() > names.get(j).length())
                    swap(names, j - 1, j);

                else if (names.get(j - 1).length() == names.get(j).length()) {
                    for (int k = 0; k < names.get(j).length(); k++) {

                        if(names.get(j - 1).charAt(k) < names.get(j).charAt(k))
                            break;

                        if(names.get(j - 1).charAt(k) > names.get(j).charAt(k)) {
                            swap(names, j - 1, j);
                            break;
                        }
                    }
                }
            }
        }
    } // sort 함수의 끝

    static void swap (ArrayList<String> names, int idx1, int idx2) {

        String str = names.get(idx1);
        names.set(idx1, names.get(idx2));
        names.set(idx2, str);

    } // swap 함수의 끝
}
