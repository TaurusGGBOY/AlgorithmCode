import java.util.*;

class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<String, Map<String, Integer>> map = new HashMap<>();
        Set<String> dishs = new HashSet<>();
        Set<String> tables = new HashSet<>();
        for(List<String> list :orders)
        {
            String table =list.get(1);
            String dish = list.get(2);
            tables.add(table);
            dishs.add(dish);
            if(map.containsKey(table))
            {
                map.get(table).merge(dish, 1, (oldval, newval) -> oldval + newval);
            }
            else
            {
                map.put(table,new HashMap<>());
                map.get(table).merge(dish, 1, (oldval, newval) -> oldval + newval);
            }
        }
        Vector<String> tablevec = new Vector<>();
        tablevec.addAll(tables);
        tablevec.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1)-Integer.parseInt(o2);
            }
        });

        Vector<String> dishVec = new Vector<>();
        dishVec.addAll(dishs);
        dishVec.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        List<List<String>> res = new ArrayList<>();
        List<String> title = new ArrayList<>();
        title.add("Table");
        title.addAll(dishVec);
        res.add(title);
        for(int i=0;i<tablevec.size();i++)
        {
            List<String> list = new ArrayList<>();
            list.add(tablevec.get(i));
            Map<String, Integer> dishmap = map.get(tablevec.get(i));
            for(int j=0;j<dishVec.size();j++)
            {
                list.add(String.valueOf(dishmap.getOrDefault(dishVec.get(j),0)));
            }
            res.add(list);
        }
        return res;

    }
}