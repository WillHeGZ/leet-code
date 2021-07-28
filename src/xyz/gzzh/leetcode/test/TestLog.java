package xyz.gzzh.leetcode.test;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TestLog {

    private final static String BASE_PATH = "src/xyz/gzzh/leetcode/test/";

    @Test
    public void hbOrder() throws IOException {
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(BASE_PATH + "orderNo.txt")), "UTF-8"));
            Map<String, String> orderJsonMap = new HashMap<>();

            String order = null;
            while ((order = bufferedReader.readLine()) != null) {
                System.out.println("查找单号：" + order);
                String orderJson = null;
                //TODO 改数量
                for (int i = 0; i < 20; i++) {
                    orderJson = getOrderJson(order, "gateway.log.2021-07-14." + i);
                    if (orderJson != null) {
                        break;
                    }
                }

                orderJsonMap.put(order, orderJson);
            }

            BufferedWriter bufferedWriter = null;
            BufferedWriter notFoundWriter = null;
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(BASE_PATH + "order_json_result.txt"))));
                notFoundWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(BASE_PATH + "order_not_found.txt"))));
                //输出
                for (Map.Entry<String, String> entry : orderJsonMap.entrySet()) {
//                    bufferedWriter.write("\"" + entry.getKey() + "\",\"" + entry.getValue() + "\"");
                    if (entry.getValue() != null) {
                        bufferedWriter.write(entry.getValue());
                        bufferedWriter.newLine();
                    } else {
                        notFoundWriter.write(entry.getKey());
                        notFoundWriter.newLine();
                    }
                }
            } finally {
                bufferedWriter.close();
                notFoundWriter.close();
            }
        } finally {
            bufferedReader.close();
        }
    }


    private static String getOrderJson(String orderId, String fileName) throws IOException {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(BASE_PATH + fileName)), "UTF-8"));
            String lineText = null;
            while ((lineText = bufferedReader.readLine()) != null) {
                if ((lineText.contains("\"status\":\"CLOSE\"") && lineText.contains(orderId)) || (lineText.contains("\"status\":\"COMPLETE\"") && lineText.contains(orderId))) {
//                if (lineText.contains("\"status\":\"COMPLETE\"") && lineText.contains(orderId)) {
//                    if (lineText.contains("\"status\":\"CLOSE\"") && lineText.contains(orderId)) {
                    return lineText.split("reqJson=")[1];
                }
            }

            return null;
        } finally {
            bufferedReader.close();
        }
    }
}
