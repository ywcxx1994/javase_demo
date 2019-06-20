package com.yw.structure.stack;

/**
 * 利用uitl.stack，完成括号匹配，队列的使用
 *
 * @author 18765
 */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new ArrayStack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                //如果遍历完了，都不在包含这些字符，那么返回false
                if (stack.isEmpty())
                    return false;
                //取出栈顶元素
                Character topChar = stack.pop();
                if (c == ')' && topChar != '(')
                    return false;
                if (c == ']' && topChar != '[')
                    return false;
                if (c == '}' && topChar != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "([{)])";
        Solution s = new Solution();
        System.out.println(s.isValid(str));
    }
}
