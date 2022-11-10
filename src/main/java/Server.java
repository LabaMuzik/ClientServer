import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static ServerSocket serverSocket;
    private Socket client;

    public Server() {
        init();
    }

    private void init() {
        try {
            serverSocket = new ServerSocket(8088);
            System.out.println("Socked created...");
            System.out.println("Waiting for a connection...");
            client = serverSocket.accept();
            System.out.println("Client connected " + client.getPort());
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            final String name = in.readLine();
            out.println(String.format("Hi %s, your port is %d", name, client.getPort()));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Status not");
        }

    }
}