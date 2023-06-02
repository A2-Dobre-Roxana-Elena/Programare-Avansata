
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Objects;
import java.util.Scanner;


public class GameClient {
    public static void main (String[] args) throws IOException {
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 8100; // The server's port
        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())) ) {
                // Send a request to the server
                Scanner scanner = new Scanner(System.in);
                boolean opreste = false;
                while(!opreste) {
                    System.out.print("Introduceti comanda : ");
                    String request = scanner.nextLine();
                    System.out.println("Ati introdus comanda : " + request);
                    if (Objects.equals(request, "exit")) {
                        opreste = true;
                        out.println(request);
                    } else {
                        out.println(request);
                        String response = in.readLine();
                        System.out.println(response);
                        if(Objects.equals(response, "Server stopped"))
                        {
                            opreste = true;
                        }
                    }
                }
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }

}