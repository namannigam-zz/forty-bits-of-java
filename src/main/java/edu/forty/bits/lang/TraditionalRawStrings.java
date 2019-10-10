package com.stackoverflow.nullpointer.lang;

public class TraditionalRawStrings {

    public static void main(String[] args) {
        // Before JEP-326
        String html = "<html>\n" +
                "    <body>\n" +
                "		    <p>Hello World.</p>\n" +
                "    </body>\n" +
                "</html>\n";

        // After JEP-326
        String htmlnow = `<html>
                   <body>
                       <p>Hello World.</p>
                   </body>
               </html>
              `;
    }
}
