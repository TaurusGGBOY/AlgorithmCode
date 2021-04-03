import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int pos = 0;
        switch (ruleKey) {
            case "type":
                pos = 0;
                break;
            case "color":
                pos = 1;
                break;
            case "name":
                pos = 2;
                break;
            default:
                break;
        }
        final int finalPos = pos;
        return (int) items.stream().filter((item) -> item.get(finalPos).equals(ruleValue)).count();

    }
}