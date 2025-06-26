package Arrays.Practice;
import java.util.Arrays;
import java.util.PriorityQueue;

/**PS- You’re given an array of meeting intervals [[start1,end1], [start2,end2], ...].
 Return the minimum number of meeting rooms required so that no meetings overlap.

 * “I first sort the meetings by their start time. Then I use a min-heap to keep track of the end times of meetings currently using rooms.
 *
 * For each meeting, if it starts after the earliest ending one, I reuse that room (remove it from the heap).
 * Otherwise, I add it as a new room.
 *
 * At the end, the size of the heap tells me the minimum number of rooms required.
 *
 * Time complexity is O(n log n) — sorting + heap operations
 *
 * Space complexity is O(n) — heap can grow to n if all meetings overlap.”
 */

public class MeetingRoomAvailability {

        public static int minMeetingRooms(int[][] intervals) {
            // Edge case: no meetings
            if (intervals == null || intervals.length == 0) return 0;
            if (intervals.length == 1) return 1;

            // Step 1: Sort meetings by start time

            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

            // Step 2: Min-heap to store end times of meetings
            PriorityQueue<Integer> endTimeHeap = new PriorityQueue<>();

            for (int[] interval : intervals) {
                // Free up the room if the meeting can reuse it
                if (!endTimeHeap.isEmpty() && interval[0] >= endTimeHeap.peek()) {
                    endTimeHeap.poll();
                }
                // Allocate room for the current meeting
                endTimeHeap.offer(interval[1]);
            }

            // Heap size = total rooms needed
            return endTimeHeap.size();
        }

        public static void main(String[] args) {
            // Test cases
            int[][] test1 = {{0, 30}, {5, 10}, {15, 20}};     // 2 rooms
            int[][] test2 = {{7, 10}, {2, 4}};                // 1 room
            int[][] test3 = {};                               // 0 rooms (no meetings)
            int[][] test4 = {{1, 5}};                         // 1 room
            int[][] test5 = {{1, 5}, {5, 10}};                // 1 room (reuse room)
            int[][] test6 = {{1, 10}, {2, 11}, {3, 12}};      // 3 rooms (all overlap)
            int[][] test7 = {{1, 4}, {2, 3}, {3, 5}};         // 2 rooms
            int[][] test8 = {{0, 5}, {0, 5}, {0, 5}};         // 3 rooms (all start same time)

            System.out.println(minMeetingRooms(test1)); // 2
            System.out.println(minMeetingRooms(test2)); // 1
            System.out.println(minMeetingRooms(test3)); // 0
            System.out.println(minMeetingRooms(test4)); // 1
            System.out.println(minMeetingRooms(test5)); // 1
            System.out.println(minMeetingRooms(test6)); // 3
            System.out.println(minMeetingRooms(test7)); // 2
            System.out.println(minMeetingRooms(test8)); // 3
        }
    }


