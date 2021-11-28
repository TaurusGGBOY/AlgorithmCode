import java.util.*;

class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        int[] parents = new int[n];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        parents[firstPerson] = 0;
        for (int[] meeting : meetings) {
            if (meeting[0] > meeting[1]) {
                int temp = meeting[0];
                meeting[0] = meeting[1];
                meeting[1] = temp;
            }
        }
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        int time = meetings[0][2];
        Set<Integer> res = new HashSet<>();
        res.add(0);
        res.add(firstPerson);
        Set<Integer> sameTime = new HashSet<>();

        for (int[] meeting : meetings) {
//            System.out.println("meeting:"+Arrays.toString(meeting));
            if (time != meeting[2]) {
                Iterator<Integer> iterator = sameTime.iterator();
                while (iterator.hasNext()) {
                    int next = iterator.next();
                    if (find(parents, next)==0) {
                        res.add(next);
                    }else{
                        parents[next] = next;
                    }
                }
                sameTime.clear();
                time = meeting[2];
            }
            sameTime.add(meeting[0]);
            sameTime.add(meeting[1]);
            if (find(parents, meeting[0]) == 0 || find(parents, meeting[1]) == 0) {
                parents[meeting[0]] = 0;
                parents[meeting[1]] = 0;
            }else{
                merge(parents, meeting[1], meeting[0]);
            }
//            System.out.println(Arrays.toString(parents));
//            System.out.println(res);
        }
        Iterator<Integer> iterator = sameTime.iterator();
        while (iterator.hasNext()) {
            int next = iterator.next();
            if (find(parents, next)==0) {
                res.add(next);
            }
        }
//        System.out.println();
        List<Integer> list = new ArrayList<>(res);
        list.sort(null);
        return new ArrayList<>(list);
    }

    void merge(int[] parents, int index, int parent) {
        parents[find(parents, index)] = find(parents, parent);
    }

    int find(int[] parents, int index) {
        if (parents[index] == index) {
            return index;
        }
        return find(parents, parents[index]);
    }
}

