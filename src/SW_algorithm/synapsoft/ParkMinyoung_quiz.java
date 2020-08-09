package SW_algorithm.synapsoft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ParkMinyoung_quiz {

    static int[][] ladder;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cmd;

        ladder = new int[12][7];

        System.out.println("사다리 정보를 입력하세요(x는 입력 완료).");

        while (true) {

            System.out.print("> ");
            cmd = br.readLine();

            if (cmd.equals("x")) {
                break;
            }
            setLadder(cmd);

        }

        System.out.println("사다리 게임을 시작할 출발 지점을 입력하세요(x는 입력 완료).");

        while (true){

            System.out.print("> ");
            cmd = br.readLine();

            if (cmd.equals("x")) {
                break;
            }

            ladderGame(cmd);

        }

    } // main 메소드의 끝

    static void setLadder(String cmd) {
        StringTokenizer st = new StringTokenizer(cmd);

        try {

            int y = Integer.parseInt(st.nextToken());
            if (y < 1 || y > 10) {
                throw new RuntimeException();
            }

            int x = Integer.parseInt(st.nextToken());
            if (x < 1 || x > 6) {
                throw new RuntimeException();
            }

            ladder[y][x] = x + 1;
            ladder[y][x + 1] = x;

        } catch (NumberFormatException e) {
            System.out.println("입력 실패!사다리 정보는 다음과 같이 입력하세요.ex)> 1 6");
        } catch (RuntimeException e) {
            System.out.println("입력 실패! 첫번째 값은 1이상 10이하 두번째 값은 1이상 6이하로 입력해주세요. ex)> 1 2");
        }

    }

    static void ladderGame(String cmd) {

        try {

            int start = Integer.parseInt(cmd);

            if (start > 0 && start <= 6) {
                int x = start;
                int y = 0;

                while (y != 11) {

                    if (ladder[y][x] > 0) {
                        x = ladder[y][x];
                    }
                    y++;
                }

                System.out.println(x);
            } else {
                System.out.println("1이상 6이하의 숫자를 입력해주세요");
            }
        } catch (NumberFormatException e) {
            System.out.println("입력 실패! 1에서 6사이의 정수를 입력해주세요.");
        }
    }

}
