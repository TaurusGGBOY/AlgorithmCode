import java.util.*;

class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
    List<String> set = new ArrayList<>();
        set.addAll(Arrays.asList(words));
        for(String str:words)
        {
            for(String test:set)
            {
                if(result.contains(test))
                    continue;
                if(str.contains(test))
                {
                    if(!str.equals(test))
                    {
                        result.add(test);
                    }
                }
            }
        }
    return result;
    }
}