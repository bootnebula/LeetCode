package practice.coding;

public class RomanToInt {

    public static void main(String[] args) {

    /*  System.out.println(intToRoman(1));

        System.out.println(intToRoman(5));

        System.out.println(intToRoman(7));

        System.out.println(intToRoman(10));

        System.out.println(intToRoman(11));
*/
        System.out.println(intToRoman(3749));
    }


    public static String intToRoman(int num) {
        String roman="";
        int i=1;

        int reminder=0;
        int block;
        do {
            reminder=num%10;

            block=reminder*i;
            if(reminder==4 || reminder == 9){

                String upperbase="";
                String distanceunit="";
                upperbase=findBaseUpper(block);
                distanceunit=findDistanceUnit(i);
                roman=distanceunit+upperbase+roman;

            } else if(reminder==5 || reminder == 0){
                String base="";
                String distanceunit="";
                base=findBase(block);
                roman=base+roman;

            }else{
                String base="";
                String distanceunit="";
                String distance="";
                base=findBase(block);
                distanceunit=findDistanceUnit(i);


                if(reminder<5){
                    for (int j=1;j<=reminder;j++){
                        distance=distance+distanceunit;
                    }
                    roman=distance+roman;
                }else{

                    reminder=reminder-5;

                    for (int j=1;j<=reminder;j++){
                        distance=distance+distanceunit;
                    }
                    roman=base+distance+roman;
                }
            }
            num=num/10;
            i=i*10;
            System.out.println(num +" "+roman);
        }while(num >= 1);

        return roman;
    }

    public static String findBase(int i){
        String base="";
        if(i>=1000){
            base="M";
        }
        else if (i>=500) {
            base="D";
        }
        else if(i>=100){
            base="C";
        }
            else if (i>=50) {
                base="L";
            }
            else if(i>=10){
                base="X";
            }
            else if (i>=5) {
                base="V";
            }else{
                base="";
            }

        return base;
    }

    public static String findBaseUpper(int i){
        String base="";
         if (i<5) {
            base="V";
        }else if (i<10) {
            base="X";
        }
        else if(i<50){
            base="L";
        } else if (i<100) {
             base="C";
         } else if (i<500) {
            base="D";
        }
        else if(i<1000){
            base="M";
        }

        return base;
    }
    public static String findDistanceUnit(int i){
        String distanceUnit="";
        if(i>=1000){
            distanceUnit="M";
        }
        else if(i>=100){
            distanceUnit="C";
        }
        else if(i>=10){
            distanceUnit="X";
        }else{
            distanceUnit="I";
        }

        return distanceUnit;
    }
}
