package xyz.gzzh.leetcode.test;

import org.junit.Test;

import java.util.Arrays;

public class TestCode {

    @Test
    public void test() {
        String key = "未知,未知,未知,131,,18344561785,";
//        String key = entry.getKey().endsWith("_") ? entry.getKey() + "_" : entry.getKey();
        String[] split = key.split(",");

        System.out.println(Arrays.toString(split));
    }
}
