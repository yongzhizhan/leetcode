package cn.zhanyongzhi.leetcode;

/**
 * 使用两个指针，分别指向首尾(i, j)，当ai < aj 时，i++，
 * 因为，ai是短板，只能通过改变短板，提高面积。
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        int len = height.length;

        int startIndex = 0;
        int endIndex = len - 1;

        for(int i=0; i<len; i++){
            int startVal = height[startIndex];
            int endVal = height[endIndex];

            int width = endIndex - startIndex;
            int minHeight = 0;

            if(startVal > endVal){
                endIndex--;
                minHeight = endVal;
            }else{
                startIndex++;
                minHeight = startVal;
            }

            int area = width * minHeight;
            if(area > max)
                max = area;

            if(startIndex == endIndex)
                break;
        }

        return max;
    }
}
