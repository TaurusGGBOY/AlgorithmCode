import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<String> stringMatching(String[] words) {
        Set<String> res = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if(words[j].contains(words[i])) res.add(words[i]);
                if(words[i].contains(words[j])) res.add(words[j]);
            }
        }
        return new ArrayList<>(res);
    }
}