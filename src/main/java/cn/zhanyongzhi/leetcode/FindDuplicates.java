package cn.zhanyongzhi.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList(nums.length);

        int item = 0;
        int next = 0;

        int curIndex = 0;

        while(curIndex < nums.length){
            item = nums[curIndex];
            int itemIndex = item - 1;
            if(-1 == item || itemIndex == curIndex){
                curIndex++;
                continue;
            }

            next = nums[itemIndex];
            if(next == item){
                result.add(item);
                nums[itemIndex] = -1;
                curIndex++;
                continue;
            }

            nums[itemIndex] = nums[curIndex];
            nums[curIndex] = next;
        }

        return result;
    }

    public static void main(String[] args){
        FindDuplicates tFindDuplicates = new FindDuplicates();
        tFindDuplicates.findDuplicates(new int[]{2,1});
    }
}
