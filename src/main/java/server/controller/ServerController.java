package server.controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.SocketHandler;

public class ServerController {
    private ServerSocket serverSocket;
    public ServerController(ServerSocket serverSocket){
        this.serverSocket = serverSocket;
    }
    public void startServer(){
            try {
                ServerSocket serverSocket = new ServerSocket(13000);
            }
            catch (Exception e){
                System.out.println("Error while starting server.");
                e.printStackTrace();
            }
            try {
                System.out.println("server listening...");
                while (true) {
//                    SocketHandler socketHandler = new SocketHandler(serverSocket.accept());
//                    System.out.println("New connection made");
//                    socketHandler.start();
//                    CommandSender commandSender = new CommandSender(serverSocket.accept());
//                    socketHandler.setCommandSender(commandSender);
//                    socketHandlers.add(socketHandler);
                }
            }
            catch (Exception e){
                System.out.println("Error while server listening.");
                e.printStackTrace();
            }

        }


}


