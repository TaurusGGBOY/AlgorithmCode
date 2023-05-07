import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Vector<String> vector = new Vector<>();
        Queue<String> queue = new LinkedList<>();
        for (String str : logs) {
            int blank = str.indexOf(" ");
            if (str.substring(blank).matches(".*\\d+.*"))
                queue.add(str);
            else
                vector.add(str);
        }
//        for(String str:queue)
//          System.out.println(str);
        vector.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int blank1 = o1.indexOf(" ");
                int blank2 = o2.indexOf(" ");
                String pre1 = o1.substring(0, blank1);
                String pre2 = o2.substring(0, blank2);
                String add1 = o1.substring(blank1 + 1);
                String add2 = o2.substring(blank2 + 1);
                if (add1.equals(add2))
                    return pre1.compareTo(pre2);
                else
                    return add1.compareTo(add2);
            }
        });
        String[] res = new String[logs.length];
        int pos = 0;
        for (String str : vector)
            res[pos++] = str;
        while (!queue.isEmpty())
            res[pos++] = queue.poll();
        return res;
    }
}