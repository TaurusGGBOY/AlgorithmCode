import java.util.*;

class StockPrice {

    TreeMap<Integer, Integer> timePrice;
    TreeMap<Integer, Set<Integer>> priceTimes;

    public StockPrice() {
        timePrice = new TreeMap<>();
        priceTimes = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        if (timePrice.containsKey(timestamp)) {
            int oldPirce = timePrice.get(timestamp);
            Set<Integer> set = priceTimes.get(oldPirce);
            set.remove(timestamp);
            if (set.isEmpty()) {
                priceTimes.remove(oldPirce);
            }
        }
        timePrice.put(timestamp, price);
        Set<Integer> set = priceTimes.getOrDefault(price, new TreeSet<>());
        set.add(timestamp);
        priceTimes.put(price, set);
    }

    public int current() {
        return timePrice.lastEntry().getValue();
    }

    public int maximum() {
        return priceTimes.lastKey();
    }

    public int minimum() {
        return priceTimes.firstKey();
    }

}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */