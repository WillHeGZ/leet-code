package xyz.gzzh.java.senior.day10;

import org.junit.Test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class UDPTest1 {

    @Test
    public void sender() {
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket();
            byte[] data = "发送了一个UDP数据".getBytes(StandardCharsets.UTF_8);
            DatagramPacket dp = new DatagramPacket(data, 0, data.length, InetAddress.getByName("127.0.0.1"), 8090);
            ds.send(dp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ds.close();
        }
    }

    @Test
    public void receiver() {
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(8090);
            byte[] bytes = new byte[1024];
            DatagramPacket pd = new DatagramPacket(bytes, 0, bytes.length);
            ds.receive(pd);

            System.out.println("从客户端接收到的数据是：" + new String(pd.getData(), 0, pd.getLength()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ds != null) {
                ds.close();
            }
        }
    }
}
