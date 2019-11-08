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

    /**
     * 先看优先级，若优先级一样看结合性
     */
    String[] splitWords = new String[]{
            // 方法调用，属性获取 // 从左向右
            "(", ")",
            "[", "]",
            "{", "}",
            ".",
            ",",
            ";", // 分隔符

            // 自定义函数

            // 自定义单目运算符

            // 逻辑非、按位取反 // 从右向左
            "!",// 正号，负号
            "~",
            "++", "--",

            // 自定义双目 计算 运算符

            // 乘、除、取模（余数） // 从左向右
            "*", "/", "%",
            // 加、减 // 从左向右
            "+", "-",
            // 左位移、右位移、无符号右移 // 从左向右
            "<<", ">>", ">>>",

            // 自定义双目 关系 运算符

            // 小于、小于等于、大于、大于等于、对象类型判断是否属于同类型 // 从左向右
            "<", "<=", ">", ">=", "instanceof",
            // 2个值是否相等、2个值是否不等于 // 从左向右
            "==", "!=","<>",
            // 按位与 // 从左向右
            "&",
            // 按位异或 // 从左向右
            "^", // xor
            // 按位或 // 从左向右
            "|",
            // 短路与 // 从左向右
            "&&", // and // AND
            // 短路或 // 从左向右
            "||", // or // OR
            // 条件运算符 // 从右向左
            "?:",
            // 混合赋值运算符 // 从右向左
            "=", "+=", "-=", "*=", "/=", "%=", "&=", "|=", "^=", "<<=", ">>=", ">>>="
    };

    /*
min,max,round,print,println,like,in

for，break、continue、if then else

mod

import com.ql.util.express.test.OrderQuery;
//系统自动会import java.lang.*,import java.util.*;

     */


}
