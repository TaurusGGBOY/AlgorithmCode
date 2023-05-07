import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] masterMind(String solution, String guess) {
        Map<Character,Integer> set = new HashMap<>();
        Set<Character> fakeset = new HashSet<>();
        int right = 0;
        for(int i =0;i<solution.length();i++)
        {
            right+=solution.charAt(i)==guess.charAt(i)?1:0;
            set.merge(solution.charAt(i),1,(oldval,newval)->oldval+newval);
            fakeset.add(guess.charAt(i));
        }
        int faker = 0;
        for (char c:guess.toCharArray()) {
            if(set.containsKey(c))
            {
                int num = set.get(c);
                if(num!=0)
                {
                    faker++;
                    set.put(c, num - 1);
                }
                else
                    set.remove(c);

            }

        }
        return new int[]{right,faker-right};
    }
}