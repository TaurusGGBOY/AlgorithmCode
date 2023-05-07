import java.util.*;

class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> res = new ArrayList<>();
        Map<String, Vector<Integer>> map = new HashMap<>();
        for (int i=0;i<favoriteCompanies.size();i++) {
            for (String str : favoriteCompanies.get(i)) {
                if(map.containsKey(str)){
                    Vector<Integer> vector = map.get(str);
                    vector.add(i);
                    map.put(str, vector);
                }
                else
                {
                    Vector<Integer> vector = new Vector<>();
                    vector.add(i);
                    map.put(str, vector);
                }
            }
        }
        for(int i=0;i<favoriteCompanies.size();i++)
        {
            List<String> list = favoriteCompanies.get(i);
            String str = list.get(0);
            Vector<Integer> vector = new Vector<>(map.get(str));
            for (int j=1;j<list.size();j++) {
                Iterator<Integer> iterator = vector.iterator();
                while (iterator.hasNext())
                {
                    int num = iterator.next();
                    if(!map.get(list.get(j)).contains(num))
                    {
                        iterator.remove();
                    }
                }
                if(vector.isEmpty())
                    break;
            }
//            System.out.println(vector.size());

            if(vector.size()==1)
                res.add(i);
        }
        return res;
    }
}