import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (String string : cpdomains) {
            String[] stringArr = string.split("[.]");
            String[] timesPlusDomain = stringArr[0].split(" ");
            //System.out.println(stringArr.length);
            int times = Integer.parseInt(timesPlusDomain[0]);
            if(stringArr.length==3)
            {
                map.merge(stringArr[2],times,(newval, oldval)->newval+oldval);
                map.merge(stringArr[1]+"."+stringArr[2],times,(newval, oldval)->newval+oldval);
                map.merge(timesPlusDomain[1]+"."+stringArr[1]+"."+stringArr[2],times,(newval, oldval)->newval+oldval);
            }
            if(stringArr.length==2)
            {
                map.merge(stringArr[1],times,(newval, oldval)->newval+oldval);
                map.merge(timesPlusDomain[1]+"."+stringArr[1],times,(newval, oldval)->newval+oldval);
            }
        }
        //System.out.println(map.toString());
        for(Map.Entry<String, Integer> entry:map.entrySet())
        {
            list.add(String.valueOf(entry.getValue()) + " " + entry.getKey());
        }
        return list;
    }
}