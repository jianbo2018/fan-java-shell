package com.academiccity.darkside.command.core;

import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @Author jianbo
 * @Date 2023/3/1 01:02
 * @Version 1.0
 * @Description <br/>
 *
 */
@Component
public class UnixShell implements FanShell {

    @Override
    public void exec(String cmdStr) {

        try {
            Process process = Runtime.getRuntime().exec(new String[]{"/bin/bash", "-c", cmdStr}
                    , null
                    , new File("/Users/jianbo/tmp/"));

            new Thread(() -> {
                BufferedInputStream oin = null;
                BufferedReader oReader = null;
                BufferedInputStream ein = null;
                BufferedReader eReader = null;
                OutputStream os = null;
                try {
                    oin = new BufferedInputStream(process.getInputStream());
                    oReader = new BufferedReader(new InputStreamReader(oin));
                    ein = new BufferedInputStream(process.getErrorStream());
                    eReader = new BufferedReader(new InputStreamReader(ein));
                    String s;
                    //先读stdout

                    int cnt = 0;
                    while (cnt == 0) {
                        cnt = oin.available();
                    }
                    byte[] bs = new byte[cnt];
                    oin.read(bs);
                    System.out.println(new String(bs));

//                    while ((s = stdoutReader.readLine()) != null) {
//                        System.out.println(s);
//                    }
                    //再读stderr
//                    while ((s = stdErrReader.readLine()) != null) {
//                        System.out.println(s);
//                    }

                    os = process.getOutputStream();
                    if (os != null) {
                        Scanner scanner = new Scanner(System.in);
                        String val = scanner.nextLine();
                        os.write(val.getBytes(StandardCharsets.UTF_8));
                        os.flush();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } finally {
                    if (os != null) {
                        try {
                            os.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (oin != null) {
                        try {
                            oin.close();
                        } catch (IOException e) {
                        }
                    }
                    if (oReader != null) {
                        try {
                            oReader.close();
                        } catch (IOException e) {
                        }
                    }
                    if (ein != null) {
                        try {
                            ein.close();
                        } catch (IOException e) {
                        }
                    }
                    if (eReader != null) {
                        try {
                            eReader.close();
                        } catch (IOException e) {
                        }
                    }
                }
            }).start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
