package cn.zhanyongzhi.leetcode;

public class StringToInteger {
    public int myAtoi(String str) {
        int strLen = str.length();
        int index = 0;
        int result = 0;
        boolean negative = false;
        int overflowVal = Integer.MAX_VALUE;

        if(0 == strLen)
            return 0;

        for(;index<strLen;index++){
            char item = str.charAt(index);
            if(' ' != item)
                break;
        }

        char signChar = str.charAt(index);
        if('-' == signChar){
            index++;
            negative = true;
            overflowVal = Integer.MIN_VALUE;
        }

        if('+' == signChar){
            index++;
        }

        //skip start
        for(;index<strLen;index++){
            char item = str.charAt(index);
            if('0' == item)
                continue;

            break;
        }

        int resultLen = 0;

        //get value
        for(;index<strLen;index++){
            char item = str.charAt(index);
            int val = item - '0';

            if(val < 0 || val > 9)
                break;

            if(resultLen >= 10){
                return overflowVal;
            }

            resultLen++;
            result = result * 10 + val;
        }

        if(0 > result)
            return overflowVal;

        if(true == negative){
            return result * -1;
        }

        return result;
    }
}
