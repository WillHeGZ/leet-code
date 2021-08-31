package xyz.gzzh.leetcode.test3;

public class Man implements Cloneable{
    public String a = "person";

    public Man() {
    }

    public Man(String a) {
        this.a = a;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Man{" +
                "a='" + a + '\'' +
                "} " + super.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
