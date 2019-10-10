package com.stackoverflow.nullpointer.lang;

public class PolyglotRawStrings {

    public static void main(String[] args) {
        // Before JEP-326
        String script = "function hello() {\n" +
                "   print(\'\"Hello World\"\');\n" +
                "}\n" +
                "\n" +
                "hello();\n";
//        ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
//        Object obj = engine.eval(script);


        // After JEP-326
        String scriptNow = `function hello() {
                    print('"Hello World"');
                 }

                 hello();
                `;

//        ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
//        Object obj = engine.eval(script);
    }
}