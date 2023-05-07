import java.util.ArrayList;
import java.util.List;

class LC5389 {
  int[] times = {1, 2, 4, 8, 16, 32, 60, 120, 240, 480};
  List<String> lists = new ArrayList<>();
  int minTime;
  int hourTime;
  int depth = 0;
  int cap;
  int hour;
  int min;

  public List<String> readBinaryWatch(int num) {
    minTime = 0;
    hourTime = 0;
    cap = num;
    minTime += times[0];
    depth++;
    bfs(0, true);
    depth--;
    minTime -= times[0];
    bfs(0, false);
//    lists.sort(
//        new Comparator<String>() {
//          @Override
//          public int compare(String o1, String o2) {
//            String[] strs1 = o1.split(":");
//            String[] strs2 = o2.split(":");
//            int hour1 = Integer.parseInt(strs1[0]);
//            int min1 = Integer.parseInt(strs1[1]);
//            int hour2 = Integer.parseInt(strs2[0]);
//            int min2 = Integer.parseInt(strs2[1]);
//            return hour1 - hour2 == 0 ? min1 - min2 : hour1 - hour2;
//          }
//        });
    return lists;
  }

  void bfs(int index, boolean wantIt) {
    if (index >= times.length) return;
    if (depth == cap) {
      String string = getStr();
      if (hour >= 12) return;
      if (minTime >= 60) return;
      lists.add(string);
      return;
    }
    if (index + 1 >= times.length) return;
    index++;
    if (index > 5) {
      hourTime += times[index];
    } else {
      minTime += times[index];
    }
    depth++;
    bfs(index, true);
    depth--;
    if (index > 5) {
      hourTime -= times[index];
    } else {
      minTime -= times[index];
    }
    bfs(index, false);
  }

  String getStr() {
    hour = hourTime / 60;
    min = minTime;
    return hour + ":" + (min >= 10 ? "" : "0") + min;
  }

}
