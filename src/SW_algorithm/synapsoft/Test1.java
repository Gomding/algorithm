package SW_algorithm.synapsoft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test1 {

    static boolean[][] ladder;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String cmd;

        ladder = new boolean[12][7];

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

            int start = Integer.parseInt(cmd);

            if (start > 0 && start <=6){
                ladderGame(cmd);
            }else {
                System.out.println("1이상 6이하의 숫자를 입력해주세요");
            }



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

            ladder[y][x] = true;
            ladder[y][x + 1] = true;

        } catch (NumberFormatException e) {
            System.out.println("입력 실패!사다리 정보는 다음과 같이 입력하세요.ex)> 1 6");
        } catch (RuntimeException e) {
            System.out.println("입력 실패! 첫번째 값은 1이상 10이하 두번째 값은 1이상 6이하로 입력해주세요.");
        }

    }

    static void ladderGame(String cmd) {

        int x = Integer.parseInt(cmd);
        int y = 0;

        while (y != 11) {

            if (ladder[y][x]) {
                x = x < 6 ? (ladder[y][x + 1] ? x + 1 : x - 1) : x - 1;
            }
            y++;
        }

        System.out.println(x);

    }


}
