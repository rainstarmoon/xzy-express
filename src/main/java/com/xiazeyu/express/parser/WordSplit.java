package com.xiazeyu.express.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 自然语句 切分成 引擎分词 工具类
 */
public class WordSplit {

    public static Word[] parse(String sourceText, String[] splitWords) {
        List<Word> list = new ArrayList<>();
        String regexString = KeyWordDefine.generateSplitRegexString(splitWords);
        Pattern pattern = Pattern.compile(regexString);
        Matcher matcher = pattern.matcher(sourceText);
        String[] texts = pattern.split(sourceText);
        for (String text : texts) {
            if (text.length() != 0) { // 等价于 !"".equals(text)
                list.add(new Word(text));
            }
            if (matcher.find()) {
                list.add(new Word(matcher.group()));
            }
        }
        Word[] result = new Word[list.size()];
        list.toArray(result);
        return result;
    }

}
