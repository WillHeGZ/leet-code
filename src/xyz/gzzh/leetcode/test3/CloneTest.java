package xyz.gzzh.leetcode.test3;

public class CloneTest implements Cloneable{
    private String a;
    private Man man;

    public Man getMan() {
        return man;
    }

    public void setMan(Man man) {
        this.man = man;
    }

    public CloneTest(String a, Man man) {
        this.a = a;
        this.man = man;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public CloneTest(String a) {
        this.a = a;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "CloneTest{" +
                "a='" + a + '\'' +
                ", man=" + man +
                '}';
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneTest will = new CloneTest("Will",new Man("man"));
        CloneTest clone = (CloneTest) will.clone();

        clone.setA("hhhh");
        will.setA("will111");
        will.setMan(new Man("asdfasdfasd"));

        System.out.println(will);
        System.out.println(clone);
    }
}
