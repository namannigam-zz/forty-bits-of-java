package edu.forty.bits.exception;

import java.lang.StackWalker.StackFrame;

public class StackWalkWithoutInstantiating {

    private StackWalker walker;

    public void init() {
        this.walker = StackWalker.getInstance();
    }

    public void walkTheStack() {
        this.walker.forEach(this::print);
    }

    private void print(StackFrame frame) {
        String className = frame.getClassName();
        String methodName = frame.getMethodName();
        int lineNumber = frame.getLineNumber();
        System.out.println(className + "." + methodName + ":" + lineNumber);
    }
}