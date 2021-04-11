import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MKAverage {
    List<Integer> list;
    int minNum;
    int kNum;

    public MKAverage(int m, int k) {
        list = new ArrayList<>();
        minNum = m;
        kNum = k;
    }

    public void addElement(int num) {
        list.add(num);
    }

    public int calculateMKAverage() {
        if (list.size() < minNum) {
            return -1;
        }
        List<Integer> temp = new ArrayList<>();
        for (int i = list.size() - minNum; i < list.size(); i++) {
            temp.add(list.get(i));
        }
        temp.sort(Collections.reverseOrder());
        System.out.println(temp.toString());
        int sum = 0;
        for (int i = kNum; i < temp.size()  - kNum; i++) {
            sum += temp.get(i);
        }
        System.out.println(sum);
        double res = sum * 1.0f / (temp.size() - 2 * kNum);
//        if (res - (int) res >= 0.5) {
//            return (int) res + 1;
//        }
        return (int) res;
    }
}

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */