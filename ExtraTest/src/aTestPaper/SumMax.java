package aTestPaper;

import java.util.Scanner;

public class SumMax {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int[] nums = new int[s.length];
        for (int i = 0; i < s.length; i++){
            nums[i] = Integer.parseInt(s[i]);
        }

        System.out.println(findSumMax(nums));

    }

    public static int findSumMax(int[] nums){
        quickSort(nums, 0, nums.length-1);

        if (nums[nums.length-1] <= 0) return 0;
        int maxV = 0;
        for (int i = 0; i < nums.length; i++){
            int ans = 0;
            for (int j = i; j < nums.length; j++){
                ans = ans + (j-i+1)*nums[j];
            }
            if (ans > maxV){
                maxV = ans;
            }
        }
        return maxV;
    }

    public static int partition(int[] nums, int low, int high){
        int i = low - 1, pivot = nums[high];
        for (int j = low; j < high; j++){
            if (nums[j] <= pivot){
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        int temp = nums[i+1];
        nums[i+1] = nums[high];
        nums[high] = temp;
        return i+1;
    }

    public static void quickSort(int[] nums, int low, int high){
        if (low < high){
            int mid = partition(nums, low, high);

            quickSort(nums, low, mid-1);
            quickSort(nums, mid+1, high);
        }
    }
}
