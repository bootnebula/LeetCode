package practice.coding;

import java.util.HashMap;
import java.util.Map;

public class IntToRoman {

    public static void main(String[] args) {

    /*  System.out.println(intToRoman(1));

        System.out.println(intToRoman(5));

        System.out.println(intToRoman(7));

        System.out.println(intToRoman(10));

        System.out.println(intToRoman(11));
*/
        System.out.println(romanToInt("MCMXCVII"));
    }

    private static Integer romanToInt(String s) {
        HashMap<String,Integer> romanToIntMap=new HashMap<>();
        romanToIntMap.put("I",1);
        romanToIntMap.put("V",5);
        romanToIntMap.put("IV",4);
        romanToIntMap.put("IX",9);
        romanToIntMap.put("X",10);
        romanToIntMap.put("XL",40);
        romanToIntMap.put("L",50);
        romanToIntMap.put("XC",90);
        romanToIntMap.put("C",100);
        romanToIntMap.put("CD",400);
        romanToIntMap.put("D",400);
        romanToIntMap.put("CM",900);
        romanToIntMap.put("M",1000);
        Integer intval=0;

        Integer length=s.length();
        int i=0;
        while (i<length){
           String romanDigit= null;
            if((i+2)<=length)
                romanDigit= s.substring(i,++i+1);
            else
                i++;

           if(romanToIntMap.containsKey(romanDigit)){
               System.out.println(romanDigit);
               intval=intval+romanToIntMap.get(romanDigit);
               i=i+1;
           }else{
               i--;
               romanDigit= s.substring(i,i+1);
               System.out.println(romanDigit);
               if(romanToIntMap.containsKey(romanDigit)){
                   intval=intval+romanToIntMap.get(romanDigit);
               }else {
                   System.out.println(romanDigit+" INVALID input!");
                   return 0;
               }

               i++;
            }
        }

        return intval;
    }


}
