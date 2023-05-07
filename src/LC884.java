import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Vector<String> vector = new Vector<>();

        String[] Astr = A.split(" ");
        String[] Bstr = B.split(" ");

        HashMap<String,Integer> setA = new HashMap<>();
        HashMap<String,Integer> setB = new HashMap<>();

        for (String str : Astr) {
            setA.merge(str,1,(oldval,newval)->oldval+newval);
        }
        for (String str : Bstr) {
            setB.merge(str,1,(oldval,newval)->oldval+newval);
        }
        for (Map.Entry<String, Integer> entry:setA.entrySet()) {
            if(entry.getValue()==1)
            {
                if(!setB.containsKey(entry.getKey()))
                    vector.add(entry.getKey());
            }
        }

        for (Map.Entry<String, Integer> entry:setB.entrySet()) {
            if(entry.getValue()==1)
            {
                if(!setA.containsKey(entry.getKey()))
                    vector.add(entry.getKey());
            }
        }

        String[] results = new String[vector.size()];
        vector.toArray(results);
        return results;
    }
}