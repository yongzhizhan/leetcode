package cn.zhanyongzhi.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> compareSet = new HashSet(20);
        int incIndex = 0;
        int maxLen = 0;
        int size = 0;
        char ele;

        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);
            if(!compareSet.contains(curr)){
                compareSet.add(curr);
                continue;
            }

            size = compareSet.size();
            if(size > maxLen)
                maxLen = size;

            for(; incIndex<i; incIndex++){
                ele = s.charAt(incIndex);
                if(curr == ele){
                    incIndex++;
                    break;
                }

                compareSet.remove(ele);
            }
        }

        size = compareSet.size();
        if(size > maxLen)
            return size;

        return maxLen;
    }
}
