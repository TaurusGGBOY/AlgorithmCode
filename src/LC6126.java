import java.util.*;

class FoodRatings {


    Map<String, String> map;

    Map<String, TreeMap<Integer, TreeSet<String>>> revertedMap;


    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        map = new HashMap<>();
        revertedMap = new HashMap<>();
        for (int i = 0; i < foods.length; i++) {
            TreeMap<Integer, TreeSet<String>> treeMap = revertedMap.getOrDefault(cuisines[i], new TreeMap<>());
            TreeSet<String> treeSet = treeMap.getOrDefault(ratings[i], new TreeSet<>());
            treeSet.add(foods[i]);
            treeMap.put(ratings[i], treeSet);
            revertedMap.put(cuisines[i], treeMap);
            map.put(foods[i], cuisines[i] + "," + ratings[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        String strs = map.get(food);
        String[] split = strs.split(",");
        TreeMap<Integer, TreeSet<String>> treeMap = revertedMap.get(split[0]);
        TreeSet<String> treeSet = treeMap.get(Integer.parseInt(split[1]));
        treeSet.remove(food);
        if(treeSet.isEmpty()) treeMap.remove(Integer.parseInt(split[1]));

        treeSet = treeMap.getOrDefault(newRating, new TreeSet<>());
        treeSet.add(food);
        treeMap.put(newRating, treeSet);
        map.put(food, split[0] + "," + newRating);


    }

    public String highestRated(String cuisine) {
        TreeMap<Integer, TreeSet<String>> treeMap = revertedMap.get(cuisine);
        return treeMap.lastEntry().getValue().first();
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */

//Line 29: java.lang.NullPointerException: Cannot invoke "java.util.TreeSet.remove(Object)" because "<local6>" is null