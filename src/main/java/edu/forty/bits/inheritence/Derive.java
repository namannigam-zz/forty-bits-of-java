package edu.forty.bits.inheritence;

class Derive extends Base {
    public String getName() { //Not compiling
        return "derived";
    }

    private String className = "Derived"; //Compiling successfully
}