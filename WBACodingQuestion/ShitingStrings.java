package WBACodingQuestion;

//DONE 

/*
PS:  s = "abcdefg",  leftShifts = 2,  rightShifts = 4

After 2 left shifts  →  "cdefgab"
After 4 right shifts →  "fgabcde"   ← answer */
public class ShitingStrings {

       

    public static String shiftString(String s, int leftShifts, int rightShifts) {
        int n = s.length();
        if (n == 0) return s;

        // Net shift: positive = right shift, negative = left shift
        int netShift = ((rightShifts - leftShifts) % n + n) % n;

        // A right shift by k = s[n-k .. n-1] + s[0 .. n-k-1]
        return s.substring(n - netShift) + s.substring(0, n - netShift);
    }

    public static void main(String[] args) {
        System.out.println(shiftString("abcdefg", 2, 4)); // → fgabcde
        System.out.println(shiftString("abcd",    1, 2)); // → dabc
        System.out.println(shiftString("abcde",   0, 0)); // → abcde
        System.out.println(shiftString("a",    1000000000, 999999999)); // → z (no, 'a')
    }
}

/*
    int netShift = ((rightShifts - leftShifts) % n + n) % n;

    rightShifts - leftShifts
    Left and right shifts are opposites — they cancel each other out. Subtracting gives the net direction and magnitude.

    Positive result → net right shift
    Negative result → net left shift
    Zero → no movement

    % n (first one)
    Shifts are circular — after n shifts you're back to the original. So only the remainder matters. Reduces a billion shifts down to at most n-1.
    
    + n
    Java's % returns negative values for negative inputs. For example -3 % 7 = -3 in Java. Adding n pushes it into positive territory. e.g. -3 + 7 = 4.
    
    % n (second one)
    If the net was already positive, + n may have overshot past n. The second % n brings it back down. e.g. 6 + 7 = 13, 13 % 7 = 6 — correct.
*/

/*
return s.substring(n - netShift) + s.substring(0, n - netShift);
This single line performs the entire rotation. 
Here's why it works:
A right shift by k positions means the last k characters jump to the front:
"abcdefg",  k=2

Last 2 chars  →  s.substring(7-2)     =  s.substring(5)  =  "fg"
First 5 chars →  s.substring(0, 7-2)  =  s.substring(0,5) =  "abcde"

Result: "fg" + "abcde" = "fgabcde"  ✓
Visually:
index:   0  1  2  3  4  5  6
string:  a  b  c  d  e  f  g
                          |
                     split here (n - netShift = 5)

LEFT part:  s[5..6]  =  "fg"    → goes to front
RIGHT part: s[0..4]  =  "abcde" → goes to back */


