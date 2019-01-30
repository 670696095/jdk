package com.cuizhiwen.jdk.socket;

import java.io.*;
import java.net.Socket;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/30 13:34
 */
public class GreetingClient {
    public static void main(String [] args)
    {
        String serverName ="localhost";
        int port = 8080;
        try
        {
            System.out.println("连接到主机：" + serverName + " ，端口号：" + port);
            Socket client = new Socket(serverName, port);
            System.out.println("远程主机地址：" + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            out.writeUTF("Hello from " + client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println("服务器响应： " + in.readUTF());
            client.close();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
