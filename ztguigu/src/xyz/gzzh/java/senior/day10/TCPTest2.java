package xyz.gzzh.java.senior.day10;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TCPTest2 {
    /*
     * 实现TCP网络编程
     * 客户端发送文件到服务端，服务端将文件保存在本地
     * */

    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        BufferedInputStream bis = null;
        ByteArrayOutputStream baos = null;
        try {
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inetAddress, 8090);
            os = socket.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(new File("1.jpg")));

            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = bis.read(bytes)) != -1) {
                os.write(bytes, 0, len);
            }
            socket.shutdownOutput();

            baos = new ByteArrayOutputStream();
            InputStream is = socket.getInputStream();
            while ((len = is.read(bytes)) != -1) {
                baos.write(bytes, 0, len);
            }
            socket.shutdownInput();
            System.out.println("接收到来自服务端的返回信息 : " + baos.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (baos != null) {
                try {
                    baos.close();
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
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void server() {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        BufferedOutputStream bos = null;
        OutputStream os = null;

        try {
            ss = new ServerSocket(8090);
            socket = ss.accept();
            is = socket.getInputStream();
            bos = new BufferedOutputStream(new FileOutputStream(new File("2.jpg")));

            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = is.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
            socket.shutdownInput();

            os = socket.getOutputStream();
            os.write("图片接收到啦，很好看哦！！！".getBytes(StandardCharsets.UTF_8));
            socket.shutdownOutput();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
