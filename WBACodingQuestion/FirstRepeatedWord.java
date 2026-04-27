package WBACodingQuestion;

//DONE-----------

import java.util.*;


public class FirstRepeatedWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String[] split = str.split("[\\s,;:\\-\\.]+");
        HashSet<String> set = new HashSet<>();

        for (String s : split) {
            if (s.isEmpty()) continue;   // handle leading delimiters
            if (set.contains(s)) {
                System.out.println(s);
                return;
            }
            set.add(s);
        }

        sc.close();
    }
}
