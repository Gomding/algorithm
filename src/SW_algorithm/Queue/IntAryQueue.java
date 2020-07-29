package SW_algorithm.Queue;

public class IntAryQueue {

    private int max;
    private int num;
    private int[] que;

    // 실행시 예외 : 스택이 비어있음
    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() {}
    }

    // 싱행 시 예외 : 스택이 가득 참
    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() {}
    }

    public IntAryQueue(int capacity) {
        que = new int[capacity];
        max = capacity;
        num = 0;
    }

    public int enque(int x) {
        if (num >= max) {
            throw new OverflowIntQueueException();
        }
        return que[num++] = x;
    }

    public int deque() {

        if (num <= 0) {
            throw new EmptyIntQueueException();
        }
        int n = que[0];
        for (int i = num - 1; i >= 0; i--) {
            que[i - 1] = que[i];
        }
        num--;
        return n;
    }



}
