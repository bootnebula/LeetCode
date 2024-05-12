package practice.coding;

import java.util.Arrays;
import java.util.stream.IntStream;

public class TwoSum {


    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] nums={1,2,8,3};
        int[] result= new int[2];

        result=twoSum( nums, 3);
        System.out.println(result[0]+":"+result[1]);
    }


    public static int[] twoSum(int[] nums, int target) {

        nums= Arrays.stream(nums).sorted().toArray();
        Arrays.stream(nums).forEach(System.out::println);

        int length= nums.length;
        int[] result = new int[2];
        boolean found= false;

        for (int i=0;i<nums.length-1&&nums[i]<target&&!found;i++){
            for (int j=i+1;j<nums.length&&nums[j]<target&&!found;j++) {
                if (target == nums[i]+nums[j]){
                    result[0]=nums[i];
                    result[1]=nums[j];
                    found = true;
                }
            }

        }

        result[0] = findIndex(nums, result[0]);
        result[1] = findIndex(nums, result[1]);

        return result;
    }

    public static int findIndex(int arr[], int t)
    {
        int len = arr.length;
        return IntStream.range(0, len)
                .filter(i -> t == arr[i])
                .findFirst()// first occurrence
                .orElse(-1); // No element found
    }


    public static int findSecondIndex(int arr[], int t)
    {
        int len = arr.length;
        return IntStream.range(0, len)
                .filter(i -> t == arr[i])
                .skip(1)
                .findFirst()// first occurrence
                .orElse(-1); // No element found
    }
}
