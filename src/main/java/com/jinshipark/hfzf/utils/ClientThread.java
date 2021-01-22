package com.jinshipark.hfzf.utils;

import java.io.DataInputStream;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket;
    private DataInputStream inputStream;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            inputStream = new DataInputStream(socket.getInputStream());
            // 信息的格式：(add||remove||chat),发送人,收发人,信息体
            while (true) {
                byte[] bytes = new byte[2048];
                inputStream.read(bytes);
                String msg = new String(bytes, "utf-8");
                String[] str = msg.split(",");
                switch (str[0]) {
                    case "insert":
                        System.out.println(str[2].trim());
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
