package practice.coding;

import java.util.HashSet;
import java.util.Set;

public class LongetsSbustringBoot {

    public static void main(String[] args) {

        int output=lengthOfLongestSubstring("abccbcbb");
        System.out.println("Output :"+output);
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxlength=0;
        int size=s.length();
        int left=0;
        int right=0;
        int window=0;

        Set<Character> charSet=new HashSet<>();
        for ( right=0;right <size;right++){

            if(!charSet.contains(s.charAt(right))){
                charSet.add(s.charAt(right));
                window=right-left+1;
                maxlength=Math.max(window,maxlength);
            }else{

                    while(s.charAt(right)!=s.charAt(left)) //block itirate and remove non duplicate characters which  is used for duplicate check;
                    {
                        charSet.remove(s.charAt(left));
                        left++;
                    }
                    charSet.remove(s.charAt(left));//duplicating character removal
                    left++; // left reset to new position to open window
                    window=0;
                    charSet.add(s.charAt(right));
            }

        }
        return maxlength;
    }
}
