import java.util.ArrayList;
import java.util.List;

class Solution {
  int[] times = {1, 2, 4, 8, 16, 32, 60, 120, 240, 480};
  List<String> lists = new ArrayList<>();
  int nowTime;
  int depth = 0;
  int cap;

  public List<String> readBinaryWatch(int num) {
    nowTime = 0;
    cap = num;
    nowTime += times[0];
    depth++;
    bfs(0, true);
    depth--;
    nowTime -= times[0];
    bfs(0, false);
    return lists;
  }

  void bfs(int index, boolean wantIt) {
    if (index >= times.length) return;
    if (depth == cap) {
        String string=getStr();
        if(string.equals("12:00"))
            break;
      lists.add(string);
      return;
    }
      if (index+1 >= times.length) return;
    index++;
    nowTime += times[index];
    depth++;
    bfs(index, true);
    depth--;
    nowTime -= times[index];
    bfs(index, false);
  }

  String getStr() {
    int hour = nowTime / 60;
    int min = nowTime - hour * 60;
    return hour + ":" + (min >= 10 ? "" : "0") + min;
  }
}
