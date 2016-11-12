package cn.zhanyongzhi.leetcode;

import java.util.Stack;

public class ValidParentheses {
    enum Status {STATUS_START, STATUS_FIRST, STATUS_CLOSE}

    public boolean isValid(String s) {
        Stack targetStack = new Stack();

        Status status = Status.STATUS_START;

        for(int i=0; i<s.length(); i++){
            char item = s.charAt(i);

            if('(' == item || '{' == item || '[' == item){
                char target = ' ';

                if('(' == item) target = ')';
                if('{' == item) target = '}';
                if('[' == item) target = ']';

                if(Status.STATUS_FIRST == status){
                    targetStack.push(target);
                    continue;
                }

                if(Status.STATUS_CLOSE != status && Status.STATUS_START != status)
                    return false;

                status = Status.STATUS_FIRST;
                targetStack.push(target);
            }

            if(')' == item || '}' == item || ']' == item){
                if(Status.STATUS_FIRST != status)
                    return false;

                char target = (Character) targetStack.pop();
                if(item != target)
                    return false;

                if(targetStack.isEmpty())
                    status = Status.STATUS_CLOSE;
                else
                    status = Status.STATUS_FIRST;
            }
        }

        if(Status.STATUS_START == status || Status.STATUS_CLOSE == status)
            return true;

        return false;
    }
}
