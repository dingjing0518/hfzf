package com.jinshipark.hfzf.utils;

import java.io.IOException;
import java.util.List;

public class ServerThread extends Thread {
    private ParkSocket parkSocket;
    private List<ParkSocket> list;

    public ServerThread(ParkSocket parkSocket, List<ParkSocket> list) {
        this.parkSocket = parkSocket;
        this.list = list;
    }

    public void run() {
        boolean isSocketClosed = false;
        try {
            // 信息的格式：(add||remove||chat),收件人,...,收件人,发件人,信息体
            //不断地读取客户端发过来的信息
            byte[] bytes = new byte[2048];
            parkSocket.getInputStream().read(bytes);
            String msg = new String(bytes, "utf-8");
            String[] str = msg.split(",");
            //转发消息
            switch (str[0]) {
                case "insert":
                    isSocketClosed = true;
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getParkName().trim().equals(str[1].trim())) {
                            list.get(i).getOutputStream().write(msg.getBytes("UTF-8"));
                            list.get(i).getOutputStream().flush();
                            break;
                        }
                    }
                    break;
                case "add":
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getParkName().trim().equals(str[1].trim())) {
                            break;
                        }
                        parkSocket.setParkName(str[1].trim());
                        list.add(parkSocket);
                    }
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            System.out.println("消息回复异常");
        } finally {
            try {
                if (isSocketClosed) {
                    parkSocket.getSocket().close();
                    parkSocket.getOutputStream().close();
                    parkSocket.getInputStream().close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
