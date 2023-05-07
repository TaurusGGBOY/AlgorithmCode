class BrowserHistory {
    int pos;
    String[] sites;
    int maxPos;

    public BrowserHistory(String homepage) {

        sites = new String[100000];
        sites[0] = homepage;
        pos = 1;
        maxPos=1;
    }

    public void visit(String url) {
        sites[pos++] = url;
        maxPos = pos;
//        for(String str : sites)
//        {
//            System.out.print(str);
//            System.out.print(" ");
//        }
//        System.out.println();
    }

    public String back(int steps) {
        while (steps-- > 0) {
            if(pos==1)
                break;
            pos--;
        }
        return sites[pos - 1];
    }

    public String forward(int steps) {
        while (steps-- > 0) {
            if(pos==maxPos)
                break;
            pos++;
        }

        return sites[pos - 1];
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */