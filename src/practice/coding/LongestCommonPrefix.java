package practice.coding;

public class LongestCommonPrefix {

    public static void main(String[] args) {

        args = new String[]{"ab", "a"};

        System.out.println(longestCommonPrefix(args));
    }

    public static String longestCommonPrefix(String[] strs) {

        String longestCommonPrefix=strs[0];
        int inpputLength=strs.length;
        for (int i=1;i<inpputLength;i++){
                int longestCommonPrefixLength=longestCommonPrefix.length();
                String currentInput=strs[i];
                 int currentInputLen=currentInput.length();
                int newPrefixLengthMaxPossiblity = (longestCommonPrefixLength<currentInputLen)
                        ?longestCommonPrefixLength:currentInputLen;
                int newPrefixLen=0;
                for (int j=0;j<newPrefixLengthMaxPossiblity;j++){

                    if(longestCommonPrefix.charAt(j)==currentInput.charAt(j)){
                        newPrefixLen=j+1;
                        continue;
                    }else {
                        newPrefixLen=j;
                        break;
                    }

                }
            longestCommonPrefix=longestCommonPrefix.substring(0,newPrefixLen);

        }

        return longestCommonPrefix;
    }
}
