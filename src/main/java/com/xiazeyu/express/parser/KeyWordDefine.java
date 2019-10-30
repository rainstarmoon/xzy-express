package com.xiazeyu.express.parser;

public interface KeyWordDefine {

    static String generateSplitRegexString(String[] words) {
        StringBuilder regexStringBuilder = new StringBuilder();
        for (String word : words) {
            regexStringBuilder.append("\\").append(word).append("|");
        }
        if (regexStringBuilder.length() > 0) {
            regexStringBuilder.deleteCharAt(regexStringBuilder.length() - 1);
        }
        return regexStringBuilder.toString();
    }

    String[] splitWords = new String[]{
            "(", ")", // 小括号 优先级改变运算符 注意：必须匹配
            "+", "-", "*", "/", "%" // 计算类 双目运算符
    };

}
