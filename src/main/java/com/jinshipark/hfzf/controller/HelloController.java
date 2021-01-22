package com.jinshipark.hfzf.controller;

import com.jinshipark.hfzf.mapper.LincensePlateMapper;
import com.jinshipark.hfzf.mapper2.JinshiparkApakeyMapper;
import com.jinshipark.hfzf.utils.ClientThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.DataOutputStream;
import java.net.Socket;

@RestController
public class HelloController {
    public static final String IP = "192.168.1.132";//服务器地址
    @Autowired
    private LincensePlateMapper lincensePlateMapper;
    @Autowired
    private JinshiparkApakeyMapper jinshiparkApakeyMapper;

    @GetMapping("/add")
    public Object add() {
        String str = "add,3205830001";
        Socket socket = null;
        try {
            //和服务器端建立连接
            socket = new Socket(IP, 5555);  //ip,port
            //建立连接后获取输出流
            ClientThread thread = new ClientThread(socket);
            thread.start();
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.write(str.getBytes("UTF-8"));
            outputStream.flush();
        } catch (Exception e) {
            System.out.println("服务器异常");
        }
        return "ok";
    }

    @GetMapping("/insert")
    public Object hello() {
        String str = "insert,3205830001,苏E12345";
        Socket socket = null;
        try {
            //和服务器端建立连接
            socket = new Socket(IP, 5555);  //ip,port
            //建立连接后获取输出流
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.write(str.getBytes("UTF-8"));
            outputStream.flush();
        } catch (Exception e) {
            System.out.println("服务器异常");
        }
        return "ok";
    }
}
