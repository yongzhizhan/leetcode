package cn.zhanyongzhi.leetcode;

public class ZigZag {
    StringBuilder builder;
    String str;
    int strLen;

    public String convert(String s, int numRows) {
        str = s;
        strLen = s.length();
        if(0 == strLen || 0 == numRows)
            return "";

        if(1 == strLen || 1 == numRows || strLen <= numRows)
            return s;

        builder = new StringBuilder();

        int diff = 2 * numRows - 2;
        int diff1 = diff - 2;
        int diff2 = 2;

        addRowChar(0, diff);

        for(int i=1; i<numRows - 1; i++){
            addRowCharSwap(i, diff1, diff2);
            diff1 -= 2;
            diff2 += 2;
        }

        addRowChar(numRows - 1 , diff);

        return builder.toString();
    }

    private void addRowChar(int pos, int diff){
        while(pos < strLen){
            builder.append(str.charAt(pos));
            pos += diff;
        }
    }

    private void addRowCharSwap(int pos, int diff1, int diff2){
        boolean swap = false;
        while(pos < strLen){
            builder.append(str.charAt(pos));
            if(false == swap)
                pos += diff1;
            else
                pos += diff2;

            swap = !swap;
        }
    }
}
