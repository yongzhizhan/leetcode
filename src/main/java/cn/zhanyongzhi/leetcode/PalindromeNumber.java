package cn.zhanyongzhi.leetcode;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(0 > x)
            return false;

        if(10 > x)
            return true;

        if(0 == x % 10)
            return false;

        int num = 0;
        int next;

        for(;;){
            num = num * 10 + (x % 10);
            next = x / 10;

            if(x == num || next == num)
                return true;

            if(num > next)
                return false;

            x = next;
        }
    }
}
