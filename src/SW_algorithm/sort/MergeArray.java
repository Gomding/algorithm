package SW_algorithm.sort;

public class MergeArray {

    static void merge(int[] a, int na, int[] b, int nb, int[] c) {
        int pa = 0;
        int pb = 0;
        int pc = 0;

        while (pa < na && pb < nb) {
            c[pc++] = (pa <= pb) ? a[pa++] : b[pb++];
        }
        while (pa < na) {
            c[pc++] = a[pa++];
        }
        while (pb < nb) {
            c[pc++] = a[pb++];
        }
    }

}
