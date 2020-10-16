package Programmers;

public class Network {

    public static void main(String[] args) {
        int[][] input1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] input2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        System.out.println(solution(3, input1));
        System.out.println(solution(3, input2));
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] chk = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!chk[i]) {
                dfs(computers, i, chk);
                answer++;
            }
        }
        return answer;
    }

    public static void dfs(int[][] computers, int i, boolean[] chk) {
        chk[i] = true;

        for (int j = 0; j < computers.length; j++) {
            if (i != j && computers[i][j] == 1 && chk[j] == false) {
                dfs(computers, j, chk);
            }
        }
    }
}
