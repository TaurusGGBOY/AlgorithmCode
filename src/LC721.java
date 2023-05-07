import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // 用来统计同名同性的有多少人
        Map<String, Integer> countMap = new HashMap<>();
        // 倒排表 用来查找该邮箱地址的主人
        Map<String, String> revertedMap = new HashMap<>();
        // 结果表
        Map<String, Set<String>> res = new HashMap<>();

        // 1. 遍历accounts 获取表1 2 3
        for (List<String> account : accounts) {
            String name = account.get(0);
            int flag = 0;
            List<String> names = new ArrayList<>();
            for (int i = 1; i < account.size(); i++) {
                if (revertedMap.containsKey(account.get(i))) {
                    flag = 1;
                    name = revertedMap.get(account.get(i));
                    // 如果有多个name， 那么将所有的后面的加入第一个name，并且修改倒排表
                    names.add(name);
                }
            }
            // 全放在最后一个
            if (flag != 1) {
                countMap.merge(name, 1, (oldval, newval) -> oldval + newval);
                name = name + "_" + countMap.get(name);
            }
            // 如果flag==1 说明可能有不只一个需要合并
            Set<String> set = res.getOrDefault(name, new HashSet<>());

            for (String s : names) {
                // 倒排表改一下
                if (s.equals(name))
                    continue;
                for (Map.Entry<String, String> entry : revertedMap.entrySet()) {
                    if (entry.getValue().equals(s)) {
                        entry.setValue(name);
                    }
                }
                // 将res加入到真res中
                set.addAll(res.getOrDefault(s,new HashSet<>()));
                res.remove(s);
            }
            for (int i = 1; i < account.size(); i++) {
                revertedMap.put(account.get(i), name);
                set.add(account.get(i));
            }
            res.put(name, set);
        }
//        System.out.println(res.toString());
        List<List<String>> list = new ArrayList<>();
        for (Map.Entry<String, Set<String>> entry : res.entrySet()) {
            LinkedList<String> temp = new LinkedList<>();
            temp.addAll(entry.getValue());
            temp.sort(Comparator.naturalOrder());
            temp.addFirst(entry.getKey().split("_")[0]);
            list.add(temp);
        }
        return list;


    }
}