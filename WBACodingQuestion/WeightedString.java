package WBACodingQuestion;

//DONE

import java.util.*;
/*
i=1:  weights[1] = (1+2) × weights[0] = 3  × 1   = 3
i=2:  weights[2] = (2+2) × weights[1] = 4  × 3   = 12
i=3:  weights[3] = (3+2) × weights[2] = 5  × 12  = 60
i=4:  weights[4] = (4+2) × weights[3] = 6  × 60  = 360
i=5:  weights[5] = (5+2) × weights[4] = 7  × 360 = 2520
...

weights = [1, 3, 12, 60, 360, 2520, ...]
           A  B   C   D    E     F
           
           */

public class WeightedString {

    public static String smallestString(long weight) {
        // Step 1: Precompute weights for A-Z
        long[] weights = new long[26];
        weights[0] = 1; // A

        for (int i = 1; i < 26; i++) {
            weights[i] = (i + 2) * weights[i - 1]; 
        }

        // Step 2: Greedy selection
        int[] freq = new int[26];

        for (int i = 25; i >= 0; i--) {
            if (weights[i] <= weight) {
                long count = weight / weights[i];
                freq[i] = (int) count;
                weight -= count * weights[i];
            }
        }

        // Step 3: Build lexicographically smallest string
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            while (freq[i]-- > 0) {
                result.append((char) ('A' + i));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        long weight = 25;
        System.out.println(smallestString(weight)); // ACC
    }
}


/*
Explanation line by line 
To minimize length → use LARGEST letter possible first
Like making change → use largest coin first

weight=25:
  Largest usable letter = C (12)
  25/12 = 2 C's → remaining = 25 - 24 = 1
  Next = B (3) → 1/3 = 0 → skip
  Next = A (1) → 1/1 = 1 A → remaining = 0
  
  Characters used: C,C,A → sorted → "ACC"

2. Line by Line Explanation + Dry Run

Setup
javapublic static String smallestString(long weight) {
Takes target weight as long because constraint says up to 10^16 — way beyond int range.
int  max = 2,147,483,647     (~2×10^9)
long max = 9,223,372,036,854,775,807  (~9×10^18)

weight up to 10^16 → must use long ✓

Step 1 — Precompute Weights
javalong[] weights = new long[26];
Array of 26 slots — one for each letter A to Z.
index:  0  1  2  3  4 ... 25
letter: A  B  C  D  E ... Z

javaweights[0] = 1; // A

Base case. A = 1 by definition.
weights = [1, 0, 0, 0, 0, ... 0]
           A


javafor (int i = 1; i < 26; i++) {
    weights[i] = (i + 2) * weights[i - 1];
}

Fill weights for B to Z using the formula.
Why (i+2)?
i=1 (B): multiplier = 1+2 = 3  → B = 3  × A = 3  × 1  = 3
i=2 (C): multiplier = 2+2 = 4  → C = 4  × B = 4  × 3  = 12
i=3 (D): multiplier = 3+2 = 5  → D = 5  × C = 5  × 12 = 60
i=4 (E): multiplier = 4+2 = 6  → E = 6  × D = 6  × 60 = 360
Dry run — filling weights array:
i=1:  weights[1] = (1+2) × weights[0] = 3  × 1   = 3
i=2:  weights[2] = (2+2) × weights[1] = 4  × 3   = 12
i=3:  weights[3] = (3+2) × weights[2] = 5  × 12  = 60
i=4:  weights[4] = (4+2) × weights[3] = 6  × 60  = 360
i=5:  weights[5] = (5+2) × weights[4] = 7  × 360 = 2520
...

weights = [1, 3, 12, 60, 360, 2520, ...]
           A  B   C   D    E     F

Step 2 — Greedy Selection
javaint[] freq = new int[26];
Frequency array — stores how many times each letter is used.
index:  0  1  2  3 ... 25
letter: A  B  C  D ... Z
freq:  [0, 0, 0, 0 ... 0]   ← all zero initially

javafor (int i = 25; i >= 0; i--) {
Loop from Z (index 25) DOWN to A (index 0).
Why reverse? Because we want largest letter first to minimize total character count.
i=25 → Z (largest, try first)
i=24 → Y
...
i=2  → C
i=1  → B
i=0  → A (smallest, try last)

java if (weights[i] <= weight) {
Only use this letter if its weight fits within remaining weight.
weight=25, i=3 (D): weights[3]=60
  60 <= 25? NO → skip D

weight=25, i=2 (C): weights[2]=12
  12 <= 25? YES → use C

javalong count = weight / weights[i];
Integer division — how many of this letter fit?
weight=25, weights[2]=12
count = 25/12 = 2    → 2 C's fit

javafreq[i] = (int) count;
Store the count in frequency array.
freq[2] = 2   → use 2 C's
Cast long to int — safe here because count is always small (max letters of same type in any valid answer is small given factorial growth of weights).

javaweight -= count * weights[i];
Subtract the total weight used by these letters from remaining.
weight = 25 - 2×12 = 25 - 24 = 1

Step 3 — Build String
java StringBuilder result = new StringBuilder();
for (int i = 0; i < 26; i++) {
Now loop from A (index 0) UP to Z (index 25).
Why forward this time? Because appending A before B before C gives alphabetically smallest string automatically — no sorting needed.
i=0 → A first
i=1 → B next
i=2 → C last
...
Result is always alphabetical ✓

javawhile (freq[i]-- > 0) {
    result.append((char) ('A' + i));
}
For each letter, append it freq[i] times.
(char)('A' + i) converts index back to character:
i=0 → 'A' + 0 = 'A'
i=1 → 'A' + 1 = 'B'
i=2 → 'A' + 2 = 'C'
freq[i]-- — post decrement:
freq[2]=2:
  iteration 1: freq[2]-- checks 2>0 → TRUE  → append 'C' → freq[2]=1
  iteration 2: freq[2]-- checks 1>0 → TRUE  → append 'C' → freq[2]=0
  iteration 3: freq[2]-- checks 0>0 → FALSE → stop

javareturn result.toString();
Convert StringBuilder to String and return.

Full Dry Run — weight = 25
Step 1 — Precompute:
weights[0] = 1    → A
weights[1] = 3    → B
weights[2] = 12   → C
weights[3] = 60   → D
...rest all > 25
Step 2 — Greedy loop:
weight = 25
freq   = [0,0,0,0,...,0]

i=25 to i=3:
  weights[i] > 25 → condition FALSE → skip all

i=2 (C): weights[2]=12
  12 <= 25? YES
  count = 25/12 = 2
  freq[2] = 2
  weight  = 25 - 2×12 = 1
  ┌─────────────────────────┐
  │ freq = [0,0,2,0,...,0]  │
  │ weight = 1              │
  └─────────────────────────┘

i=1 (B): weights[1]=3
  3 <= 1? NO → skip

i=0 (A): weights[0]=1
  1 <= 1? YES
  count = 1/1 = 1
  freq[0] = 1
  weight  = 1 - 1×1 = 0
  ┌─────────────────────────┐
  │ freq = [1,0,2,0,...,0]  │
  │ weight = 0              │
  └─────────────────────────┘
Step 3 — Build string:
i=0 (A): freq[0]=1
  append 'A' → result = "A"

i=1 (B): freq[1]=0
  0>0? NO → skip

i=2 (C): freq[2]=2
  append 'C' → result = "AC"
  append 'C' → result = "ACC"

i=3 to i=25: freq=0 → skip

return "ACC" ✓

One More Dry Run — weight = 4
Step 2 Greedy:
  weight=4

  i=2 (C): 12 <= 4? NO → skip
  i=1 (B): 3  <= 4? YES
    count = 4/3 = 1
    freq[1] = 1
    weight  = 4 - 3 = 1

  i=0 (A): 1 <= 1? YES
    count = 1/1 = 1
    freq[0] = 1
    weight  = 0

  freq = [1,1,0,...,0]

Step 3 Build:
  i=0 (A): append 'A' → "A"
  i=1 (B): append 'B' → "AB"

return "AB" ✓  (A+B = 1+3 = 4 ✓)

Complexity
Time:
  Step 1 precompute  → O(26)  = O(1)
  Step 2 greedy      → O(26)  = O(1)
  Step 3 build       → O(L)   L = result length
  No sort needed     → O(1)   saved vs my approach
  Overall            → O(L)

Space:
  weights array      → O(26)  = O(1)
  freq array         → O(26)  = O(1)
  result string      → O(L)
  Overall            → O(L)
*/