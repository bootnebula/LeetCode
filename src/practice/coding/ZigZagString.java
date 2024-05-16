package practice.coding;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ZigZagString {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",4));
    }

    public static String convert(String s, int numRows) {

        HashMap<Integer,String> map=new HashMap<>();
        String zigzag=null;
        int length=s.length();
        char c=s.charAt(0);
        if(length==1){
            zigzag = String.valueOf(c);
            return zigzag;
        }else{
            zigzag="";
        }
        int position=0;
        int direction=1;
        for(int i=0;i<length;i++) {
            c=s.charAt(i);
                if(position==numRows){
                    direction=-1;
                }
                if(position==0){
                    direction=1;
                }

            if(position==1&& direction ==-1){
                direction=1;
            }

            position=position+direction;
            String zigs=map.get(position);
            if(zigs!=null){
                zigs=zigs+String.valueOf(c);
            }else {
                zigs=String.valueOf(c);
            }
            map.put(position,zigs);
        }

        for (Integer key : map.keySet()) {
            zigzag=zigzag+map.get(key);
        }
        return zigzag;
    }



}
