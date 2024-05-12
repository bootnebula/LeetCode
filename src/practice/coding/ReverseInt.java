package practice.coding;

public class ReverseInt {
    public static void main(String[] args) {
        int x=2147483647;
        x++;
        x++;
        System.out.println(reverse(2147483647));



    }

     static int  reverse(int x){
        int i=0;
        long reverse=0;
        while(!(x>-1&&x<1)){
            int reminder=x%10;
            x=x/10;
            i++;
            if ((reverse*10) > Integer.MAX_VALUE || (reverse*10) < Integer.MIN_VALUE) {
                return 0;
            }

                reverse=(reverse*10)+reminder;


        }

        return (int)reverse;
    }
}
