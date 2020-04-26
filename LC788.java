import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
  Map<Integer, Integer> map = new HashMap<>();

    public int rotatedDigits(int N) {
        int sum = 0;
      map.put(0,0);
      map.put(1,1);
      map.put(2,5);
      map.put(5,2);
      map.put(6,9);
      map.put(8,8);
      map.put(9,6);

        for (int i = 1; i <= N; i++) {
            if (isGodd(i))
                sum++;
        }
        return sum;
    }

    boolean isGodd(int i) {
        String str = String.valueOf(i);
        int flag = 0;
      StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < str.length(); j++) {
            if (!map.keySet().contains(str.charAt(j)-'0'))
            {
              flag=1;
              break;
            }
            stringBuilder.append(map.get(str.charAt(j)-'0'));
        }
        if(flag==1)
          return false;
      return !str.equals(stringBuilder.toString());
    }
}

