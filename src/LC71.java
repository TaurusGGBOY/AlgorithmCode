class Solution {
    public String simplifyPath(String path) {
        Deque<String> deque = new ArrayDeque<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : path.split("/+"))
            switch (str) {
                case "..": if (!deque.isEmpty()) deque.pollLast(); break;
                case ".": case "": break;
                default: deque.offerLast(str); break;
            }
        while (!deque.isEmpty()) stringBuilder.append("/").append(deque.pollFirst());
        return stringBuilder.length() == 0 ? "/" : stringBuilder.toString();
    }
}