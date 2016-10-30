package cn.zhanyongzhi.leetcode;

public class ReverseInteger {
    public int reverse(int x) {
        int multiRet = 1;

        if(x < 0){
            x = x * -1;
            multiRet = -1;
        }

        //x * -1 overflow case
        if(x < 0)
            return 0;

        if(x < 10)
            return x * multiRet;

        int val;

        //skip zero
        for(;;){
            val = x % 10;
            x = x / 10;

            if(0 != val)
                break;
        }

        //long contain int value, avoid overflow case happen
        long result = 0;
        while(0 != x || 0 != val){
            result = result * 10 + val;

            val = x % 10;
            x = x / 10;
        }

        if(result > Integer.MAX_VALUE)
            return 0;

        return (int)result * multiRet;
    }
}
