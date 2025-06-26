package Arrays.Practice;

import java.util.Arrays;
import java.util.Comparator;

/**
 * PS- You are given n meeting time intervals. Can a person attend all of them without any overlaps?
 * “I sort the intervals by their start time. Then I loop through the sorted list and check if any meeting starts before the previous one ends — if so, there's an overlap, and we return false.
 * Time complexity is O(n log n) for sorting, and space is O(1).”
 */

public class CanIAttendAllMeeting {
        public static boolean canAttendAllMeetings(int[][] intervals) {
            if (intervals == null || intervals.length == 0) return true;

            // Sort by start time
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            for (int i = 1; i < intervals.length; i++) {
                // Check for overlap
                if (intervals[i][0] < intervals[i - 1][1]) {
                    return false;
                }
            }
            return true;
        }

        public static void main(String[] args) {
            int[][] test1 = {{0, 30}, {5, 10}, {15, 20}}; // Overlaps
            int[][] test2 = {{7, 10}, {2, 4}};            // No overlap
            int[][] test3 = {};                           // Edge case: empty input
            int[][] test4 = {{1, 5}};                     // One meeting only
            int[][] test5 = {{1, 5}, {5, 10}};            // Touching meetings

            System.out.println(canAttendAllMeetings(test1)); // false
            System.out.println(canAttendAllMeetings(test2)); // true
            System.out.println(canAttendAllMeetings(test3)); // true
            System.out.println(canAttendAllMeetings(test4)); // true
            System.out.println(canAttendAllMeetings(test5)); // true
        }
    }


