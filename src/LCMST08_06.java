import java.util.List;

class Solution {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        bfs(A.size(), A, B, C);
    }

    void move(List<Integer> from, List<Integer> to) {
        int pop = from.remove(from.size() - 1);
        to.add(pop);
    }

    void bfs(int size, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (size == 1) {
            move(A, C);
        } else {
            bfs(size - 1, A, C, B);
            move(A, C);
            bfs(size - 1, B, A, C);
        }
    }
}