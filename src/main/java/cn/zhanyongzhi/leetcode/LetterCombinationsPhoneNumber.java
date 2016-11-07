package cn.zhanyongzhi.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsPhoneNumber {
    public List<String> letterCombinations(String digits) {
        int digitLen = digits.length();
        if(0 == digitLen)
            return new ArrayList();

        int itemsLen = (int)Math.pow(3, digitLen);
        for(int i=0; i<digits.length(); i++){
            if(digits.charAt(i) == '7' || digits.charAt(i) == '9')
                itemsLen++;
        }

        List<String> items = new ArrayList(itemsLen);
        helper(new StringBuilder(digitLen), items, digits, 0);
        return items;
    }

    private void helper(StringBuilder strBuilder, List<String> items, String digits, int curIndex){
        if(curIndex == digits.length()){
            items.add(strBuilder.toString());
            return;
        }

        char curChar = digits.charAt(curIndex);
        char startIndex;
        char endIndex;

        if('7' == curChar){
            startIndex = 'p';
            endIndex = 'p' + 4;
        }
        else if('8' == curChar){
            startIndex = 't';
            endIndex = 't' + 3;
        }
        else if('9' == curChar){
            startIndex = 'w';
            endIndex = 'w' + 4;
        }
        else{
            startIndex = (char)(3 * (digits.charAt(curIndex) - '2') + 'a');
            endIndex = (char)(startIndex + 3);
        }

        for(; startIndex < endIndex; startIndex++){
            strBuilder.append(startIndex);
            helper(strBuilder, items, digits, curIndex+1);

            strBuilder.setLength(strBuilder.length() - 1);
        }
    }
}
