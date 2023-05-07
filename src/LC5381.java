import java.util.*;

class Solution {
  public int[] processQueries(int[] queries, int m) {
    LinkedList<Integer> list = new LinkedList<>();
    List<Integer> result = new ArrayList<>();
    for(int i=1;i<=m;i++)
    {
      list.add(i);
    }
    for(int query:queries)
    {
      int index = list.indexOf(query);
      result.add(index);
      int num = list.get(index);
      list.remove(index);
      list.addFirst(num);
    }
    int[] resArr = new int[result.size()];
    for (int i = 0; i < resArr.length; i++) {
      resArr[i]=result.get(i);
    }

    return resArr;
  }
}