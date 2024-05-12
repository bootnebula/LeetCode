package practice.coding;

import java.util.Arrays;

public class LongestPalindrome {


    public static void main(String[] args) {
       // System.out.println(findlongestPalindrome("hhfgfabccbaklm"));
        System.out.print(findlongestPalindromeDp("abcdef"));
    }
    public static int findlongestPalindrome(String s){
        int maxLen=1;
        int length=s.length();
        //check in all substrings
        for (int i=0;i<length;i++){
            for (int j=i+maxLen;j<length;j++){
                int windowLen=j+1;
                String subString=s.substring(i,windowLen);
                if(isPalindrome(subString)){
                    if(maxLen<subString.length()){
                        maxLen=subString.length();
                        System.out.println("New maxlength "+maxLen+" string "+subString);
                    }
                }
            }
        }



        return maxLen;
    }


    public static boolean isPalindrome(String s){
        Boolean result=false;
        int length=s.length();
        if(length==1){
            result=true;
        } else if (length>1) {
            for (int i=0,j=length-1;i<j;i++,j--){
                if(s.charAt(i)==s.charAt(j)){
                    result=true;
                    continue;
                }else {
                    result=false;
                    break;
                }
            }
        }
        return result;
    }


    static String findlongestPalindromeDp(String s) {
    String maxLen= String.valueOf(s.charAt(0));
    int inputLength=s.length();
    int dp[][] = new int[inputLength][inputLength];

        for (int i=0;i<inputLength;i++){
           dp[i][i]=1;
           if(i!=inputLength-1) {
               if (s.charAt(i) == s.charAt(i + 1)) {
                    dp[i][i+1]=1;
                   maxLen=s.substring(i,i+2);
               }
               if(i-1!=-1){
                   if (s.charAt(i) == s.charAt(i-1)) {
                      // dp[i][i-1]=1;
                      // maxLen=s.substring(i-1,i);
                   }
               }
           }

        }


               //  System.out.print(Arrays.deepToString(dp));
        display(dp,inputLength);


    for (int i=2;i<inputLength;i++){
        System.out.println();
        System.out.print("Length "+i+" ");
        for (int j=0; j+i<inputLength;j++){
            System.out.print(j+""+(j+i)+" ");

            if(s.charAt(j)!=s.charAt(j+i)){
                    dp[j][j+i]=0;
            }else{
                if(dp[j+1][j+i-1]==1){
                    dp[j][j+i]=1;
                    maxLen=s.substring(j,j+i+1);
                }else{
                    dp[j][j+i]=0;
                }
            }

        }
    }

        display(dp,inputLength);

    return maxLen;
    }



    static void display(int[][] dp, int inputLength) {
        for (int i = 0; i < inputLength; i++) {
            System.out.println();
            for (int j = 0; j < inputLength; j++) {
                System.out.print(dp[i][j] + " ");

            }
        }
    }
}

