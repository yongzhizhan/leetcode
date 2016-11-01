package cn.zhanyongzhi.leetcode;

public class LongestCommonPrefix {
    String[] strs;

    public String longestCommonPrefix(String[] strs) {
        if(0 == strs.length)
            return "";

        if(1 == strs.length)
            return strs[0];

        this.strs = strs;

        String minStr = strs[0];
        for(int i=1; i<strs.length; i++){
            if(minStr.length() > strs[i].length())
                minStr = strs[i];
        }

        for(int i=0; i<minStr.length(); i++){
            if(false == isEqual(minStr.charAt(i), i))
                return minStr.substring(0, i);
        }

        return minStr;
    }

    private boolean isEqual(char c, int index){
        for(int i=0; i<strs.length; i++){
            if(c != strs[i].charAt(index))
                return false;
        }

        return true;
    }
}
