
import java.util.*;

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Queue<int[]> allMeeting = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        Queue<int[]> pendingMeeting = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        Queue<Integer> avaRoom = new PriorityQueue<>();
        int[] count = new int[n];
        Queue<int[]> meetingNow = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < meetings.length; i++) allMeeting.offer(meetings[i]);

        for (int i = 0; i < n; i++) avaRoom.offer(i);

        for (int[] m : allMeeting) {
            // 弹出所有开完的会议室
            int now = m[0];
            while (!meetingNow.isEmpty()) {
                int[] meeting = meetingNow.peek();
                if (meeting[0] > now) break;
                avaRoom.offer(meeting[1]);
                meetingNow.poll();
            }
            // 如果没有会议室 就阻塞
            if (avaRoom.isEmpty()) {
                pendingMeeting.offer(m);
                continue;
            }

            // 否则拿出一个会议室来用
            int poll = avaRoom.poll();
            meetingNow.offer(new int[]{m[1], poll});
            count[poll]++;
        }

        System.out.println(meetingNow.size());
        System.out.println(pendingMeeting.size());
        System.out.println(avaRoom.size());
        System.out.println(Arrays.toString(count));
        // 把正在开会的会议室拿出来排序 如果pending还是空的就一直取
        while (!pendingMeeting.isEmpty()) {
            int[] now = meetingNow.poll();
            System.out.println("poll");
            System.out.println(Arrays.toString(now));
            avaRoom.offer(now[1]);
            while (!avaRoom.isEmpty() && !pendingMeeting.isEmpty()) {
                int[] pending = pendingMeeting.poll();
                int poll = avaRoom.poll();
                meetingNow.offer(new int[]{pending[1]-pending[0]+now[0], poll});
                count[poll]++;
            }
        }
        System.out.println(Arrays.toString(count));
        System.out.println();

        int max = count.length - 1;
        for (int i = count.length - 1; i >= 0; i--) {
            if (count[i] >= count[max]) max = i;
        }

        return max;

    }
}