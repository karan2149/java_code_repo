package WBACodingQuestion;
import java.util.*;

// DONE --------

/*
Maria's deck:   [2, 1, 3]
Andrea's deck:  [1, 2, 3]
                 ↑
            face down, index 0 is top card

Step 1 — Roll the Die
Before anything, a die is rolled once. This decides where to start.
Die = Even  →  start from index 0 (top card)
Die = Odd   →  skip index 0, start from index 1
Even:                        Odd:
Index:  0     1     2        Index:  0     1     2
      [PLAY][SKIP][PLAY]            [SKIP][PLAY][SKIP]
         ↑                                  ↑ */
public class FindTheWinner {

    public static String findWinner(int[] andrea, int[] maria, String dieRoll) {

        // Edge case: null or mismatched decks
        if (andrea == null || maria == null) {
            return "Invalid input";
        }
        if (andrea.length != maria.length) {
            return "Invalid input";
        }

        int n = andrea.length;

        // Determine starting index based on die roll
        // Even → start at 0, Odd → start at 1
        int start = dieRoll.equalsIgnoreCase("Odd") ? 1 : 0;

        // positive → Andrea ahead
        // negative → Maria ahead
        // zero     → Tie
        int score = 0;
        for (int i = start; i < n; i += 2) {
            score += (andrea[i] - maria[i]);
        }

        // Determine winner
        if (score > 0) {
            return "Andrea";
        } else if (score < 0) {
            return "Maria";
        } else {
            return "Tie";
        }
    }

    public static void main(String[] args) {

        // Example from problem
        System.out.println(findWinner(
            new int[]{1, 2, 3},
            new int[]{2, 1, 3},
            "Even"
        )); // → Maria

        // Die is Odd — skip index 0, play index 1, 3...
        System.out.println(findWinner(
            new int[]{1, 2, 3, 4},
            new int[]{4, 1, 2, 3},
            "Odd"
        )); // → Andrea

        // Tie case
        System.out.println(findWinner(
            new int[]{1, 2},
            new int[]{1, 2},
            "Even"
        )); // → Tie

        // Edge case: n=2 minimum size, Even
        System.out.println(findWinner(
            new int[]{5, 3},
            new int[]{3, 5},
            "Even"
        )); // → Andrea (plays index 0: andrea=5 > maria=3)

        // Edge case: all equal cards
        System.out.println(findWinner(
            new int[]{3, 3, 3},
            new int[]{3, 3, 3},
            "Even"
        )); // → Tie

        // Edge case: null input
        System.out.println(findWinner(
            null,
            new int[]{1, 2},
            "Even"
        )); // → Invalid input

        // Edge case: Odd die, only index 1 played
        System.out.println(findWinner(
            new int[]{5, 1},
            new int[]{5, 3},
            "Odd"
        )); // → Maria (plays index 1: maria=3 > andrea=1)
    }
}