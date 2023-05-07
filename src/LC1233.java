import java.util.*;

class Solution {
    class Node {
        boolean isFolder;
        Map<String, Node> map;
    }

    public List<String> removeSubfolders(String[] folder) {
        Node root = new Node();
        List<String> list = new ArrayList<>(Arrays.asList(folder));
        List<String> res = new ArrayList<>();
        list.sort((o1, o2) -> {
            int l = o1.split("/").length;
            int r = o2.split("/").length;
            if (l != r) return l - r;
            return o1.compareTo(o2);
        });
//        System.out.println(list);

        for (String s : list) {
            String[] strs = s.split("/");
            Node temp = root;
            // 路径中包含有文件夹
            boolean contains = false;
            for (String str : strs) {
                if (temp.map == null) temp.map = new HashMap<>();
                if (!temp.map.keySet().contains(str)) {
                    Node node = new Node();
                    temp.map.put(str, node);
                    temp = node;
                } else {
                    temp = temp.map.get(str);
                    if(temp.isFolder) contains = true;
                }
            }
            temp.isFolder = true;
            if(!contains) res.add(s);

        }
        return res;
    }
}