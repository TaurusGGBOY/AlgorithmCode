import java.util.Vector;

class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        Vector<String> vector = new Vector<>();
        String[] arr = text.split(" ");
        for(int i=0;i<arr.length-2;i++)
        {
            if(arr[i].equals(first)&&arr[i+1].equals(second))
                vector.add(arr[i + 2]);
        }
        String[] strings = new String[vector.size()];
        vector.toArray(strings);
        return strings;
    }
}