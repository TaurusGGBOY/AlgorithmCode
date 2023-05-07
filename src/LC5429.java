import java.util.*;

import static java.lang.Math.abs;

class Solution {
    public int[] getStrongest(int[] arr, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(arr);
        int m = arr[(arr.length - 1) / 2];


        List<Integer> list = new ArrayList<>();
        for(int num:arr)
        {
            list.add(num);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int ai =  Math.abs(o1-m);
                int aj = Math.abs(o2-m);
                if(ai!=aj)
                {
                    return ai-aj;
                }
                return o1-o2;
            }
        });
//        for(int i =0;i<arr.length;i++)
//            System.out.println(list.get(i));
        for(int i =0;i<k;i++)
        {
            res[i] = list.get(arr.length - 1 - i);
        }
        return res;
    }
}