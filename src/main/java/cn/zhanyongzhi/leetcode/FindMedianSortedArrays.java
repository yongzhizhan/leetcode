package cn.zhanyongzhi.leetcode;

public class FindMedianSortedArrays {
    int[] nums1_val;
    int[] nums2_val;

    int index1 = 0;
    int index2 = 0;

    int len1 = 0;
    int len2 = 0;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        len1 = nums1.length;
        len2 = nums2.length;

        int totalLen = len1 + len2;
        if(0 == totalLen)
            return 0;

        nums1_val = nums1;
        nums2_val = nums2;

        int count = (totalLen - 1) / 2;
        for(int i=0; i<count; i++){
            next();
        }

        if(0 == totalLen % 2){
            int val = getAndIncNum();
            int val2 = getAndIncNum();

            return (double)(val + val2) / 2;
        }

        return getAndIncNum();
    }

    void next(){
        if(index1 >= len1)
            index2++;
        else if(index2 >= len2)
            index1++;
        else{
            int tmpVal1 = nums1_val[index1];
            int tmpVal2 = nums2_val[index2];

            if(tmpVal1 <= tmpVal2){
                index1++;
            }else{
                index2++;
            }
        }
    }

    int getAndIncNum(){
        if(index1 >= len1)
            return nums2_val[index2++];

        if(index2 >= len2)
            return nums1_val[index1++];

        int tmpVal1 = nums1_val[index1];
        int tmpVal2 = nums2_val[index2];

        if(tmpVal1 <= tmpVal2){
            index1++;
            return tmpVal1;
        }

        index2++;
        return tmpVal2;
    }
}
