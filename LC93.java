import java.util.*;

class Solution {

    static int pointNum;
    static StringBuilder prefix;

    boolean isLegalPart(StringBuilder stringBuilder) {
        if (Integer.parseInt(stringBuilder.toString()) > 255) return false;
        if (stringBuilder.length() >= 2 && stringBuilder.charAt(0) == '0') return false;
        return true;
    }

    boolean isLegalIp(StringBuilder stringBuilder) {
        if (stringBuilder.charAt(stringBuilder.length() - 1) == '.') return false;
        return pointNum == 3;
    }

    void dfs(String s, List<String> res, StringBuilder ipStr, boolean chunkHere, int pos) {
        // 当pos到达dfs的叶子节点中止
        if (pos == s.length()) {
            if (chunkHere && isLegalIp(ipStr)) res.add(ipStr.toString());
            return;
        }
        if (pointNum > 4) return;
        String temp = prefix.toString();
        prefix.append(s.charAt(pos));

        if (!isLegalPart(prefix)) {
            prefix = new StringBuilder(temp);
            return;
        }

        ipStr.append(s.charAt(pos));
        if (chunkHere) {
            ipStr.append(".");
            pointNum++;
            prefix.setLength(0);
        }

        dfs(s, res, ipStr, true, pos + 1);
        dfs(s, res, ipStr, false, pos + 1);

        // 回溯之后恢复
        prefix = new StringBuilder(temp);
        ipStr.deleteCharAt(ipStr.length() - 1);
        if (chunkHere) {
            ipStr.deleteCharAt(ipStr.length() - 1);
            pointNum--;
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        pointNum = 0;
        prefix = new StringBuilder();
        dfs(s, res, new StringBuilder(), true, 0);
        dfs(s, res, new StringBuilder(), false, 0);
        return res;
    }
}