package xyz.gzzh.leetcode.learning.understandingthejvm;

/*
 * VM Args: -Xss128k
 * */
public class Two_2_JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLength() {
        stackLength++;
        stackLength();
    }

    public static void main(String[] args) {
        Two_2_JavaVMStackSOF javaVMStackSOF = new Two_2_JavaVMStackSOF();

        try {
            javaVMStackSOF.stackLength();
        } catch (Throwable t) {
            System.out.println("stack length: " + javaVMStackSOF.stackLength);
            throw t;
        }
    }
}
