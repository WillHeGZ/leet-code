package xyz.gzzh.java.senior.day10;

import org.junit.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLTest {

    @Test
    public void test() {
        HttpURLConnection connection = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            URL url = new URL("https://static.runoob.com/images/demo/demo2.jpg");
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            bis = new BufferedInputStream(connection.getInputStream());
            bos = new BufferedOutputStream(new FileOutputStream(new File("demo2.jpg")));

            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }

            System.out.println("下载完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
