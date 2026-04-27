package WBACodingQuestion;

//DONE

import java.util.*;

public class FlightFarePredictor {

    public static String predictFareTrend(List<Integer> prices) {
        int increase = 0;
        int decrease = 0;

        // Compare consecutive prices
        for (int i = 1; i < prices.size(); i++) {
            if (prices.get(i) > prices.get(i - 1)) {
                increase++;
            } else if (prices.get(i) < prices.get(i - 1)) {
                decrease++;
            }
        }

        // Decision
        if (increase > decrease) {
            return "BUY";
        } else {
            return "WAIT";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // number of routes

        while (T-- > 0) {
            System.out.println("Enter the size");
            int n = sc.nextInt();

            List<Integer> prices = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                prices.add(sc.nextInt());
            }

            System.out.println(predictFareTrend(prices));
        }
    }
}

/*
. Problem Statement

What are we doing?
Given a list of historical flight prices:
→ Compare each price with the next one
→ Count how many times price INCREASED
→ Count how many times price DECREASED
→ If increases > decreases → "BUY"
→ Otherwise              → "WAIT"

Simple Example
Prices = [100, 200, 300, 400]

Compare consecutive pairs:
  100 → 200 : increased ↑   increaseCount = 1
  200 → 300 : increased ↑   increaseCount = 2
  300 → 400 : increased ↑   increaseCount = 3

decreaseCount = 0

increases(3) > decreases(0) → "BUY" ✓

Walkthrough All 3 Sample Cases
Case 1 — [210, 200, 190, 180, 185]:
210 → 200 : decreased ↓   decreaseCount = 1
200 → 190 : decreased ↓   decreaseCount = 2
190 → 180 : decreased ↓   decreaseCount = 3
180 → 185 : increased ↑   increaseCount = 1

increases(1) > decreases(3)? NO → "WAIT" ✓
*/