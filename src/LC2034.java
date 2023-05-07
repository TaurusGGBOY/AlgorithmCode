import java.util.*;

class StockPrice {
    int newestStock;
    Map<Integer, Integer> stock;
    TreeMap<Integer, Integer> count;

    public StockPrice() {
        newestStock = 0;
        stock = new HashMap<>();
        count = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        if (stock.containsKey(timestamp)) {
            int oldval = stock.get(timestamp);
            int cnt = count.get(oldval);
            if (cnt == 1) count.remove(oldval);
            else count.put(oldval, cnt - 1);
        }
        stock.put(timestamp, price);
        newestStock = Math.max(timestamp, newestStock);
        count.merge(price, 1, Integer::sum);
    }

    public int current() {
        return stock.get(newestStock);
    }

    public int maximum() {
        return count.lastKey();
    }

    public int minimum() {
        return count.firstKey();
    }
}
