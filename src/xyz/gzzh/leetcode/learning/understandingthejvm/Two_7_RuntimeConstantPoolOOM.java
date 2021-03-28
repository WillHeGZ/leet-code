package xyz.gzzh.leetcode.learning.understandingthejvm;

import java.util.HashSet;
import java.util.Set;

/*
* VM Args:
*   JDK6-: -XX:PermSize=6M -XX:MaxPermSize=6M
*   JDK8+: -XX:MaxMetaspaceSize=6M
*          -XX:Xmx=6M
*
*
* */
public class Two_7_RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        short i = 0;
        while (true) {
            set.add(String.valueOf(i++).intern());
        }
    }
}
