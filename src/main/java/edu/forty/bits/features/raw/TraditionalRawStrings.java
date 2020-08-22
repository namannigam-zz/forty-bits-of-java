package edu.forty.bits.features.raw;

public class TraditionalRawStrings {

    // TODO : check this
    public static void main(String[] args) {
        // Before JEP-326
        String html = "<html>\n" +
                "    <body>\n" +
                "		    <p>Hello World.</p>\n" +
                "    </body>\n" +
                "</html>\n";

        // After JEP-326
//        String htmlnow = ```<html>
//                   <body>
//                       <p>Hello World.</p>
//                   </body>
//               </html>
//              `;
    }
}
