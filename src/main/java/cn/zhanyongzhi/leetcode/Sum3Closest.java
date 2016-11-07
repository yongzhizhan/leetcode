package cn.zhanyongzhi.leetcode;

import java.util.Arrays;

public class Sum3Closest {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;

        Arrays.sort(nums);

        int result = nums[0] + nums[1] + nums[2];
        int minCloset = Math.abs(result - target);

        for(int i=0; i<len-2; i++){
            int leftNum = nums[i];

            for(int j = i+1; j<len-1; j++){
                int rightNum = nums[j];

                int find = target - (leftNum + rightNum);
                int pos = closet(nums, j+1, len, find);

                int sum = leftNum + rightNum + nums[pos];
                int sumCloset = Math.abs(sum - target);

                if(sumCloset < minCloset){
                    result = sum;
                    minCloset = sumCloset;
                }

                while(j<len - 1 && nums[j+1] == rightNum)
                    j++;
            }

            while(i<len - 2 && nums[i+1] == leftNum)
                i++;
        }

        return result;
    }

    private int closet(int[] nums, int start, int end, int val){
        int pos = start;
        int minCloset = Math.abs(nums[start] - val);

        for(int i=start + 1; i<end; i++){
            int cur = Math.abs(nums[i] - val);
            if(cur > minCloset)
                break;

            minCloset = cur;
            pos = i;
        }

        return pos;
    }

    public static void main(String[] args){
        new Sum3Closest().threeSumClosest(new int[]{1,2,4,8,16,32,64,128}, 82);

    }
}
