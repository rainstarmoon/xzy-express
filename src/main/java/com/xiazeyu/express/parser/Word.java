package com.xiazeyu.express.parser;

/**
 * 引擎分词
 * 引擎中可识别的最小单元
 */
public class Word {

    public String word;

    public Word(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return word;
    }
}
