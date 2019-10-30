package com.xiazeyu.express;

import com.xiazeyu.express.parser.KeyWordDefine;
import com.xiazeyu.express.parser.Word;
import com.xiazeyu.express.parser.WordSplit;

public class ExpressRunner {

    public static void main(String[] args) {
        //Word[] parse = WordSplit.parse("2*3/(2-1)+3*(4-1)", KeyWordDefine.splitWords);
        Word[] parse = WordSplit.parse("(1 + 4) * 3 + 10 / 5", KeyWordDefine.splitWords);
    }

}
