import java.util.*;

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        Vector<Integer> vector = new Vector<>();
        int total = 0;
//        Arrays.sort(arr);
        for(int num:arr)
        {
            vector.add(num);
            counts.merge(num, 1, (oldval, newval) -> oldval + newval);
            if(counts.get(num)==1)
                total++;
        }
        vector.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return counts.get(o1)-counts.get(o2);
            }
        });
//        System.out.println(vector);
        for(int i =0;i<k;i++)
        {
            System.out.print(vector.get(i)+" ");
        }
        System.out.println();
        for(int i =k;i<arr.length;i++)
        {
            System.out.print(vector.get(i)+" ");
        }
        for(int i =0;i<k;i++)
        {
            counts.put(vector.get(i),counts.get(vector.get(i))-1);
            if(counts.get(vector.get(i))==0)
                total--;
        }
        return total;

    }

}

//[24,119,157,446,251,117,22,168,374,373,323,311,441,213,120,412,200,236,328,24,164,104,331,32,19,223,89,114,152,82,456,381,355,343,157,245,443,368,229,49,82,16,373,142,240,125,8]
//        41