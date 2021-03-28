package xyz.gzzh.leetcode.learning.understandingthejvm;

/*
* VM Args： -Xss2M
*
* */
public class Two_3_JavaVMStackSOF {
    private void dontStop() {
        while (true) {

        }
    }

    public void stackLeakByThread() {
        while (true) {
            new Thread(() -> {
                dontStop();
            }
            ).start();
        }
    }

    public static void main(String[] args) {
        Two_3_JavaVMStackSOF javaVMStackSOF = new Two_3_JavaVMStackSOF();
        javaVMStackSOF.stackLeakByThread();
    }
}
