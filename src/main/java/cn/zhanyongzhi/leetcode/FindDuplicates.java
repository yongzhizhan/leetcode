package cn.zhanyongzhi.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 额外空间和速度都是O(n)的基数排序
 */

public class FindDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList(nums.length);

        for(int i=0; i<nums.length; i++){
            int item = Math.abs(nums[i]);
            int val = nums[item - 1];

            //小于0表示之前访问过
            if(val < 0){
                result.add(item);
            }else{
                nums[item - 1] = -1 * val;
            }
        }

        return result;
    }
}
