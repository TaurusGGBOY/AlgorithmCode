import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Solution {
    public String minimumString(String a, String b, String c) {
        List<String> list = new ArrayList<>();
        list.add(deal(a, b, c));
        list.add(deal(a, c, b));
        list.add(deal(b, a, c));
        list.add(deal(b, c, a));
        list.add(deal(c, a, b));
        list.add(deal(c, b, a));
        list.sort((o1, o2) -> {
            if (o1.length() - o2.length() == 0) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });
//        System.out.println(list.toString());
        return list.get(0);
    }

    public String deal(String a, String b, String c) {
        StringBuilder stringBuilder = new StringBuilder(a);

        boolean found = false;
        if (a.contains(b)) {
            found = true;
        } else {
            for (int i = b.length(); i > 0; i--) {
                if (a.endsWith(b.substring(0, i))) {
                    stringBuilder.append(b.substring(i));
                    found = true;
                    break;
                }
            }
        }


        if (!found) {
            stringBuilder.append(b);
        }

        String temp = stringBuilder.toString();
//        System.out.println(temp);

        found = false;
        if (temp.contains(c)) {
            found = true;
        } else {
            for (int i = c.length(); i > 0; i--) {
                if (temp.endsWith(c.substring(0, i))) {
//                System.out.println(c.substring(0, i));
                    stringBuilder.append(c.substring(i));
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }
}