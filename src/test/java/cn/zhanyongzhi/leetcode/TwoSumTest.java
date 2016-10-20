package cn.zhanyongzhi.leetcode;

import junit.framework.Assert;

import java.util.Arrays;

public class TwoSumTest {
    @org.junit.Test
    public void twoSum() throws Exception {
        Assert.assertTrue(Arrays.equals(new int[]{1, 2}, TwoSum.twoSum(new int[]{3, 2, 4}, 6)));
    }
    
}