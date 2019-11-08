package com.xiazeyu.express;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.ql.util.express.IExpressContext;

public class QLTest {

    public static void main(String[] args) throws Exception {
        //本文以helloworld案例,开启了两个打印日志的参数，实际使用通常不建议打开。
        boolean printParseLog = true;//语法分析日志开关
        boolean printExecuteLog = false;//每一条指令执行开关
        ExpressRunner runner = new ExpressRunner(true, printParseLog);
        IExpressContext<String, Object> context = new DefaultContext<String, Object>();
        String script = "sum=0;for(i=0;i<10;i=i+1){sum=sum+i;};return sum;";
        Object result = runner.execute(script, context, null, true, printExecuteLog);
        System.out.println(result);
        //结果输出：45
    }

}