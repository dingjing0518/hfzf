package com.jinshipark.hfzf;

import com.jinshipark.hfzf.utils.ParkSocket;
import com.jinshipark.hfzf.utils.ServerThread;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitSocketServer implements ApplicationRunner {
    private ServerSocket serverSocket;

    private List<ParkSocket> list = new ArrayList<>();

    @Override
    public void run(ApplicationArguments args) {
        startServerSocket(5555);
    }

    public void startServerSocket(int port) {
        try {
            //存放 连接上服务器的用户 列表
            serverSocket = new ServerSocket(5555);//开启服务的端口，需和客户端一致
            System.out.println("服务端已经启动，等待客户端连接");
            while (true) {
                Socket socket = serverSocket.accept();
                ParkSocket parkSocket = new ParkSocket(socket);
                System.out.println("客户端的IP：" + socket.getInetAddress().getHostAddress());
                new ServerThread(parkSocket, list).start();//开启输入和输出的多线程
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }
}
