import java.util.HashMap;
import java.util.Map;

class Solution {
  public boolean hasGroupsSizeX(int[] deck) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < deck.length; i++) {
      map.merge(deck[i], 1, (oldval, newval) -> oldval + newval);
    }
    int x = 0;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (x == 0) x = entry.getValue();
      x = maxCommonDivisor(x, entry.getValue());
    }
    return x > 1;
  }

  public static int maxCommonDivisor(int m, int n) {
    if (m < n) { // ��֤m>n,��m<n,��������ݽ���
      int temp = m;
      m = n;
      n = temp;
    }
    if (m % n == 0) { // ������Ϊ0,�������Լ��
      return n;
    } else { // ����,���еݹ�,��n����m,����������n
      return maxCommonDivisor(n, m % n);
    }
  }
}
