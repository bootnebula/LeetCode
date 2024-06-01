package practice.coding;

public class StringToInt {

    public static void main(String[] args) {



        myAtoi("2147483647");

        System.out.println();
        myAtoi("09a");
        System.out.println();
        myAtoi("42");
        System.out.println();

        myAtoi("   -042");
        System.out.println();

        myAtoi("1337c0d3");

        myAtoi("0-1");
        System.out.println();

        myAtoi("words and 987");
        System.out.println();
    }


    public static int myAtoi(String s) {

        Integer number = 0;
        Integer strnumber=0;
        s=s.trim();
        int length=s.length();
        char c;
        boolean flagvalid=true;
        boolean negative=false;
        int max=Integer.MAX_VALUE;
        int min=Integer.MIN_VALUE;

        for (int i=0;i<length;i++){
        c=s.charAt(i);

            System.out.print(c);
            System.out.println(" int value:"+(int)Character.getNumericValue(c));


        if(c=='-'&&flagvalid&&i==0){
            negative=true;
            continue;
        } else if (c=='+'&&flagvalid&&i==0) {
            negative=false;
            continue;
        }else if(flagvalid){
            if(c>=48&&c<58){
                flagvalid=true;

                int digit=c-'0';
                if(strnumber>max/10 || (strnumber==max/10 && digit>max%10)){
                    return (negative == false) ? max : min;
                }

                strnumber=strnumber*10+digit;
                System.out.println(strnumber);
            }else{
                flagvalid=false;
            }
        }

        if(!flagvalid){
            break;
        }
        }


        if(negative)
            number=(number*-1);
        System.out.println("Output :"+number);
        return number;
    }
}
