package demo.classes;

import demo.interfaces.Converter;

public class LambdaScope {

    private int outerNum;
    private static int outerStaticNum;

    public void testScope() {
        Converter<String, Integer> converter_2 = (from) -> {
            outerNum = 23;
            return String.valueOf(from + this.outerNum);
        };

        Converter<String, Integer> converter_3 = (from) -> {
            outerStaticNum = 32;
            return String.valueOf(from + this.outerStaticNum);
        };
        System.out.println(converter_2.convert(0) + " " + converter_3.convert(0));
        System.out.println("It has both read and write access to instance fields and static variables from within lambda expressions.");
        System.out.println("Default methods cannot be accessed from within lambda expressions.");
    }
}