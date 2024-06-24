package practice.coding;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Closest3Sum {


    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] nums={2,3,8,9,10};
        int result= 0;

        result=twoSum(nums,16);

        System.out.println(result);
    }


    public static int twoSum(int[] nums, int target) {

        nums= Arrays.stream(nums).sorted().toArray();
        Arrays.stream(nums).forEach(System.out::println);

        int length= nums.length;
        int[] result = new int[2];
        boolean found= false;

        int i=0;
        int j=i+1;
        int k=length-1;
        int closest=nums[i]+nums[j]+nums[k];
        while(i<k){
            if(j==k){
                i++;
                j=i+1;
                k=length-1;
                if(j==k){
                    break;
                }
                if(Math.abs(target-closest)>Math.abs(target-nums[i]+nums[j]+nums[k]))
                {closest=nums[i]+nums[j]+nums[k];}
            }
            int temp=nums[i]+nums[j]+nums[k];
            int units=Math.abs(target-temp);
            int closestunits=Math.abs(target-closest);
            if(closestunits>units){
                closest=temp;
                closestunits=units;
                System.out.println("new closes :"+closest);
            }
            if(temp>target){
                k--;
            }else if(temp<target){
                j++;
            }else{
                closest=temp;
                break;
            }
        }

        return closest;
    }

}
