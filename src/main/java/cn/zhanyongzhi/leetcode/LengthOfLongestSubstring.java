package cn.zhanyongzhi.leetcode;

public class LengthOfLongestSubstring {
    String str;
    int strlen;

    public String longestPalindrome(String s) {
        str = s;
        strlen = s.length();
        String longestStr = s.substring(0, 1);

        for(int i=0; i<strlen - 1; i++){
            String tmpStr = getPalindromeStr(i);
            if(tmpStr.length() > longestStr.length())
                longestStr = tmpStr;

            tmpStr = getPalindromeStr2(i);
            if(tmpStr.length() > longestStr.length())
                longestStr = tmpStr;
        }

        return longestStr;
    }

    String getPalindromeStr(int index){
        int count = Math.min(index, strlen - index - 2);

        for(int i=0; i<=count; i++){
            char left = str.charAt(index - i);
            char right = str.charAt(index + i + 1);

            if(left != right){
                return str.substring(index - i + 1, index + i + 1);
            }

            if(i == count)
                return str.substring(index - i, index + i + 2);
        }

        return str.substring(index, index + 1);
    }

    String getPalindromeStr2(int index){
        int count = Math.min(index, strlen - index - 1);

        for(int i=1; i<=count; i++){
            char left = str.charAt(index - i);
            char right = str.charAt(index + i);

            if(left != right){
                return str.substring(index - i + 1, index + i);
            }

            if(i == count)
                return str.substring(index - i, index + i + 1);
        }

        return str.substring(index, index + 1);
    }

    public static void main(String[] args){
        LengthOfLongestSubstring tLengthOfLongestSubstring = new LengthOfLongestSubstring();
        String tSubStr = tLengthOfLongestSubstring.longestPalindrome("ccc");

        System.out.println(tSubStr);
    }
}
