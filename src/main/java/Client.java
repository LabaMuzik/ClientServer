import java.io.*;
import java.net.Socket;

public class Client {
    private final int PORT = 8088;
    private final String SERVER_ADDRESS = "127.0.0.1";

    public Client() {
        init();
    }

    private void init() {
        try {
            Socket socket = new Socket(SERVER_ADDRESS, PORT);
            String name = "John";
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer.println(name);
            System.out.println(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}