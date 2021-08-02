package xyz.gzzh.java.senior.day09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class OtherStreamTest {

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader reader1 = new BufferedReader(reader);

        while (true) {
            String data = reader1.readLine();

            System.out.println(data.toUpperCase(Locale.ROOT));
            if ("exit".equalsIgnoreCase(data)) {
                break;
            }
        }

        reader1.close();
    }
}
