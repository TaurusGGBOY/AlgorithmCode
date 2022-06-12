import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {

            String[] strs1 = email.split("@");
            String[] strs2 = strs1[0].split("\\+");
            strs2[0] = strs2[0].replace(".", "");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(strs2[0]).append("@").append(strs1[1]);
            set.add(stringBuilder.toString());
        }
        return set.size();
    }
}