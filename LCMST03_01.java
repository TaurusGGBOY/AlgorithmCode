import java.util.Vector;

class TripleInOne {
    int[] stack;
    int stackSize;
    int[] pos;
    boolean[] isEmptyAre;

    public TripleInOne(int stackSize) {
        stack = new int[stackSize * 3];
        pos = new int[3];
        isEmptyAre = new boolean[3];
        for (int i = 0; i < 3; i++) {
            pos[i] = stackSize * i;
            isEmptyAre[i] = true;
        }
        this.stackSize = stackSize;

    }

    public void push(int stackNum, int value) {
        if(stackSize==0)
            return;
        int startPos = stackNum * stackSize;
        int endPos = stackNum * stackSize + stackSize;
        isEmptyAre[stackNum] = false;
        int tempPos = pos[stackNum];
        if (tempPos == endPos)
            return;
        stack[tempPos] = value;
        pos[stackNum]++;


    }

    public int pop(int stackNum) {
        if(stackSize==0)
            return -1;
        if (isEmpty(stackNum))
            return -1;
        int startPos = stackNum * stackSize;
        int tempPos = pos[stackNum];
        if (tempPos-1 == startPos)
            isEmptyAre[stackNum] = true;

        int temp = stack[tempPos-1];
        pos[stackNum]--;

        return temp;
    }

    public int peek(int stackNum) {
        if(stackSize==0)
            return -1;
        if(isEmpty(stackNum))
            return -1;
        int tempPos = pos[stackNum]-1;
        return stack[tempPos];
    }

    public boolean isEmpty(int stackNum) {
        return isEmptyAre[stackNum];
    }
}

/**
 * Your TripleInOne object will be instantiated and called as such:
 * TripleInOne obj = new TripleInOne(stackSize);
 * obj.push(stackNum,value);
 * int param_2 = obj.pop(stackNum);
 * int param_3 = obj.peek(stackNum);
 * boolean param_4 = obj.isEmpty(stackNum);
 */