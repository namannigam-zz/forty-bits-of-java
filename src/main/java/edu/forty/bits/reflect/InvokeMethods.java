package edu.forty.bits.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public abstract class InvokeMethods extends CalculatorInvocation {

    public static void main(String[] args) {
        InvocationHandler invocationHandler = new CalculatorInvocation();
        Calculator c = (Calculator) Proxy.newProxyInstance(Calculator.class.getClassLoader(), new Class[]{Calculator.class}, invocationHandler);
        System.out.println(c.methodA(1, 3));
    }
}