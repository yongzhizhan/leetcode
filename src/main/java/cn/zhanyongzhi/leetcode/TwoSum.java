package cn.zhanyongzhi.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> tHashMap = new HashMap();
        for(int i = 0; i<nums.length; i++){
            int first = nums[i];
            int next  = target - nums[i];

            Integer tNextIndex = tHashMap.get(next);
            if(null == tNextIndex){
                tHashMap.put(first, i);
                continue;
            }

            return new int[]{tNextIndex.intValue(), i};
        }

        return null;
    }
}
