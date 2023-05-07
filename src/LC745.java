class WordFilter {

    String[] ws;

    public WordFilter(String[] words) {
        ws = words;
    }

    public int f(String pref, String suff) {
        for (int i = ws.length - 1; i >= 0; i--) {
            if (ws[i].startsWith(pref) && ws[i].endsWith(suff)) {
                return i;
            }
        }
        return -1;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */