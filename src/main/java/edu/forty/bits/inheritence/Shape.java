package com.stackoverflow.nullpointer.inheritence;

import java.io.Serializable;

public abstract class Shape implements Serializable {
    private static final long serialVersionUID = -1231855623100981927L;

    public abstract boolean draw();

    public abstract String area();

    public abstract String perimeter();

    public abstract String characteristic();
}