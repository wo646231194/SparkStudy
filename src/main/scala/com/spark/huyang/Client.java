package com.spark.huyang;

import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args)
    {
        try {
            System.out.println("Defining new Socket");
            ServerSocket soc = new ServerSocket(9090);
            System.out.println("Waiting for Incoming Connection");
            Socket clientSocket = soc.accept();
            System.out.println("Connected Received");

            OutputStream outputStream = clientSocket.getOutputStream();
            while (true){
                PrintWriter out = new PrintWriter(outputStream, true);
                BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Waiting for user to input some data");
                String data = read.readLine();
                System.out.println("Data received adn now writing it to socket");
                out.println(data);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
