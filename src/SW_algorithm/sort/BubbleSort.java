package SW_algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BubbleSort {

    static void swap (int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    /* 버블 정렬 (버전1)
    static void bubbleSort(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                }
            }
        }
    }*/

    // 버블 정렬 (버전 2)
    /*static void bubbleSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            int exchg = 0;
            for (int j = n - 1; j > i; j--) {
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                    exchg++;
                }
            }

            if (exchg == 0) break;
        }
    }*/

    // 버블 정렬 (버전 3)
    static void bubbleSort(int[] a, int n) {
        int k = 0;
        while (k < n - 1) {
            int last = n - 1;
            for (int j = n - 1; j > k; j--) {
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                    last = j;
                }
            }
            k = last;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("버블 정렬");
        System.out.print("요솟수 : ");

        int nx = Integer.parseInt(br.readLine());
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = Integer.parseInt(br.readLine());
        }

        bubbleSort(x, nx);

        System.out.println("오름차순으로 정렬했습니다.");

        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "]=" + x[i]);
        }
    }
}
