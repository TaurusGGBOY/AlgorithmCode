import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public String predictPartyVictory(String senate) {
        int RCount = 0;
        int DCount = 0;
        int RKillD = 0;
        int DKillR = 0;
        List<Character> list = new LinkedList<>();
        for (char c : senate.toCharArray()) {
            list.add(c);
            if (c == 'R')
                RCount++;
            else
                DCount++;
        }
//        System.out.println("Start");
        Iterator<Character> iterator = list.iterator();
        while (RCount != 0 && DCount != 0) {
//            System.out.println(RCount+" "+DCount+" "+ RKillD+" "+DKillR);
//            System.out.println(list.toString());
            char temp;
            if (iterator.hasNext()) {
                temp = iterator.next();
            } else {
                iterator = list.iterator();
                continue;
            }
            if (temp == 'R') {
                if (DKillR > 0) {
                    DKillR--;
                    RCount--;
                    iterator.remove();
                } else {
                    RKillD++;

                }
            } else {
                if (RKillD > 0) {
                    RKillD--;
                    DCount--;
                    iterator.remove();
                } else {
                    DKillR++;

                }
            }
        }
        return RCount == 0 ? "Dire" : "Radiant";
    }
}


