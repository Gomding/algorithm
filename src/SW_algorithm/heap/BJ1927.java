package SW_algorithm.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// PriorityQueue 를 이용해서 풀수 있음
public class BJ1927 {

    static int N;
    static List<Integer> heap;
    static int cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        heap = new ArrayList<>();
        cnt = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (cnt == 0) System.out.println(0);
                else delHeap();
            } else {
                addHeap(num);
            }
        }

    }

    public static void addHeap(int x) {
        int left = 0;
        int right = cnt - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (heap.get(mid) > x) left++;
            else right--;
        }
        heap.add(left, x);
        cnt++;
    }

    public static void delHeap() {
        System.out.println(heap.remove(cnt - 1));
        cnt--;
    }

}
