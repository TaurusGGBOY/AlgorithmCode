/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

import java.util.*;

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int[] score = new int[2001];
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        ListIterator<Employee> iterator = employees.listIterator();
        while (iterator.hasNext()) {
            Employee e = iterator.next();
            score[e.id] = e.importance;
            if (e.id == id) {
                sum = e.importance;
                set.addAll(e.subordinates);
                iterator.remove();
            }
            if (set.contains(e.id)) {
                set.addAll(e.subordinates);
                iterator.remove();
            }
        }
        int pre = set.size();
        do {
            iterator = employees.listIterator();
            pre = set.size();
            while (iterator.hasNext()) {
                Employee e = iterator.next();
                if (set.contains(e.id)) {
                    set.addAll(e.subordinates);
                    iterator.remove();
                }
            }
        } while (pre != set.size());

        for (int a : set) {
//            System.out.println(a);
            sum += score[a];
        }


        return sum;

    }
}