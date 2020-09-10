package aTestPaper;

import java.util.Arrays;
import java.util.Scanner;

public class SumMax2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int[] nums = new int[s.length];
        for (int i = 0; i < s.length; i++){
            nums[i] = Integer.parseInt(s[i]);
        }
        System.out.println(findMax(nums));
    }

    public static int findMax(int[] nums){
        int smax = - Integer.MAX_VALUE;
        for (int i = 0; i < nums.length-1; i++){
            for (int j = i; j < nums.length; j++){
                int[] newnums = Arrays.copyOfRange(nums, i, j+1);
                int val = maxV(newnums);
                if (smax < val){
                    smax = val;
                }
            }
        }
        return smax;
    }

    public static int maxV(int[] nums){
        if (nums.length < 2) return nums[0];

        if (nums.length == 2){
            if (nums[0] > 0 && nums[1] > 0){
                return nums[0]+nums[1];
            }else{
                return Math.max(nums[0], nums[1]);
            }
        }

        Arrays.sort(nums);
        int sum = 0;
        int sta = 0;
        if (nums[0] < 0){
            sta = 1;
        }
        if (nums[1] < 0){
            sta = 2;
        }

        for (int i = sta; i < nums.length; i++){
            sum = sum + nums[i];
        }
        return sum;
    }
}
