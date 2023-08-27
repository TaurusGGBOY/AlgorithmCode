// ʧ��
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class Solution {

    public boolean canMeasureWater(int x, int y, int z) {
        // ����
        if (z == 0) {
            return true;
        }
        if (x + y < z) {
            return false;
        }

        State initState = new State(0, 0);

        // ������ȱ���ʹ�ö���
        Queue<State> queue = new LinkedList<>();
        Set<State> visited = new HashSet<>();

        queue.offer(initState);
        visited.add(initState);

        while (!queue.isEmpty()) {
            State head = queue.poll();

            int curX = head.getX();
            int curY = head.getY();

            // curX + curY == z �Ƚ����׺���
            if (curX == z || curY == z || curX + curY == z) {
                return true;
            }

            // �ӵ�ǰ״̬������п��ܵ���һ����״̬
            List<State> nextStates = getNextStates(curX, curY, x, y);

            // ���Ա��ڹ۲죬���Դ���
            // System.out.println(head + " => " + nextStates);

            for (State nextState : nextStates) {
                if (!visited.contains(nextState)) {
                    queue.offer(nextState);
                    // ���ӵ������Ժ󣬱�����������Ϊ�Ѿ����ʣ�����������ѭ��
                    visited.add(nextState);
                }
            }
        }
        return false;
    }

    private List<State> getNextStates(int curX, int curY, int x, int y) {
        List<State> nextStates = new ArrayList<>(8);

        // ��������״̬����Ӧ���� 1
        // �ⲿ��ˮ��ʹ�� A ��
        State nextState1 = new State(x, curY);
        // �ⲿ��ˮ��ʹ�� B ��
        State nextState2 = new State(curX, y);

        // ��������״̬����Ӧ���� 2
        // �� A ���
        State nextState3 = new State(0, curY);
        // �� B ���
        State nextState4 = new State(curX, 0);

        // �����ĸ�״̬����Ӧ���� 3
        // �� A �� B��ʹ�� B ����A ����ʣ
        State nextState5 = new State(curX - (y - curY), y);
        // �� A �� B����ʱ A ��ˮ̫�٣�A ������B û����
        State nextState6 = new State(0, curX + curY);

        // �� B �� A��ʹ�� A ����B ����ʣ��
        State nextState7 = new State(x, curY - (x - curX));
        // �� B �� A����ʱ B ��ˮ̫�٣�B ������A û����
        State nextState8 = new State(curX + curY, 0);

        // û������ʱ�򣬲���Ҫ��ˮ
        if (curX < x) {
            nextStates.add(nextState1);
        }
        if (curY < y) {
            nextStates.add(nextState2);
        }

        // ��ˮ��ʱ�򣬲���Ҫ����
        if (curX > 0) {
            nextStates.add(nextState3);
        }
        if (curY > 0) {
            nextStates.add(nextState4);
        }

        // ��ʣ��ŵ�
        if (curX - (y - curY) > 0) {
            nextStates.add(nextState5);
        }
        if (curY - (x - curX) > 0) {
            nextStates.add(nextState7);
        }

        // ����ȥ�������ŵ�
        if (curX + curY < y) {
            nextStates.add(nextState6);
        }
        if (curX + curY < x) {
            nextStates.add(nextState8);
        }
        return nextStates;
    }

    private class State {
        private int x;
        private int y;

        public State(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return "State{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            State state = (State) o;
            return x == state.x &&
                    y == state.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        int x = 3;
        int y = 5;
        int z = 4;

//        int x = 2;
//        int y = 6;
//        int z = 5;

//        int x = 1;
//        int y = 2;
//        int z = 3;
        boolean res = solution.canMeasureWater(x, y, z);
        System.out.println(res);
    }
}