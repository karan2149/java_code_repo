package String;

import java.util.HashMap;

public class CountNumberOfOccuringCharacter {
    
    public static void main(String[] args) {
        String str="my name is karan";

        HashMap<Character,Integer> map=new HashMap<>();
            for(int i=0 ;i<str.length();i++){  //O(n)
                char c = str.charAt(i);
                if(map.containsKey(c)){
                    map.put(c, map.get(c)+1);
                }
                else{
                    map.put(c, 1);
                }
            }
            for (Character keyString : map.keySet()) {
                System.out.println(keyString+" = "+map.get(keyString));
            }
        
    }
}
