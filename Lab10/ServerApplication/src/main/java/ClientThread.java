import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;

class ClientThread extends Thread {
    private Socket socket = null ;
    public ClientThread (Socket socket) { this.socket = socket ; }
    public void run () {
        try {
            // Get the request from the input stream: client → server
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            boolean opreste = false;
            while(!opreste){
                String request = in.readLine();
                if(!Objects.equals(request, "null"))
                {
                    System.out.println("Am primit comanda "+ request);
                    // Send the response to the output stream: server → client
                    PrintWriter out = new PrintWriter(socket.getOutputStream());
                    String raspuns = "Server received the request : "+request;
                    if(Objects.equals(request, "stop")){
                        raspuns = "Server stopped";
                        out.println(raspuns);
                        out.flush();
                        socket.close();
                        opreste = true;
                        System.exit(1);
                    }
                    else{
                        if(Objects.equals(request, "exit")) {
                            socket.close();
                            opreste = true;
                        }
                        else {
                            out.println(raspuns);
                            out.flush();
                        }
                    }
                }

            }
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) { System.err.println (e); }
        }
    }
}
