package xyz.gzzh.java.senior.day09;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class FileTest {

    @Test
    public void test1() throws IOException {
        File file = new File("hello.txt");

        System.out.println(file.createNewFile());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalFile());
        System.out.println(file.getCanonicalPath());
        System.out.println(file.getPath());
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        file.deleteOnExit();
    }

    @Test
    public void test2() {
        BufferedWriter bufferedWriter = null;
        try {
            File writerFile = new File("hello.txt");

            bufferedWriter = new BufferedWriter(new FileWriter(writerFile, false));
            bufferedWriter.write("abceerasdfawefa中国asdfasdf\n");
            bufferedWriter.newLine();
            bufferedWriter.write("I am the best!\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        BufferedReader bufferedReader = null;
        try {
            File readerFile = new File("hello.txt");
            bufferedReader = new BufferedReader(new FileReader(readerFile));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test3() throws IOException {
        File file = new File("hello.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

        byte[] bytes = new byte[5];
        while ((fileInputStream.read(bytes)) != -1) {
            Charset cs = Charset.forName("UTF-8");
            ByteBuffer bb = ByteBuffer.allocate(bytes.length);
            bb.put(bytes);
            bb.flip();
            CharBuffer cb = cs.decode(bb);
            System.out.println(cb.array());
        }

        fileInputStream.close();

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File("hello.txt")));

        bufferedOutputStream.write(new byte[]{1, 34, 54, 23});

        bufferedInputStream.close();
    }

    @Test
    public void test4() throws IOException {
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;

        try {
            inputStreamReader = new InputStreamReader(new FileInputStream("先看.txt"), Charset.forName("UTF-8"));
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream("先看1.txt"), Charset.forName("GBK"));

            char[] buff = new char[10];
            int length = 0;
            while ((length = inputStreamReader.read(buff)) != -1) {
                outputStreamWriter.write(buff, 0, length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }
        }
    }
}
