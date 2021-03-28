package xyz.gzzh.leetcode.learning.understandingthejvm;

import java.util.ArrayList;
import java.util.List;

/*
* VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
* */
public class Two_1_HeapOOM {
    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> oomObjects = new ArrayList<>();

        while (true) {
            oomObjects.add(new OOMObject());
        }
    }
}
