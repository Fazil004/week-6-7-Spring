import java.io.*;
import java.net.*;

public class SimpleHttpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            OutputStream out = clientSocket.getOutputStream();

            String requestLine = in.readLine();
            System.out.println("Received: " + requestLine);

            String response =
                    "HTTP/1.1 200 OK\r\n" +
                    "Content-Type: text/html\r\n\r\n" +
                    "<html><body><h1>Welcome to My Java Web Server!</h1></body></html>";

            out.write(response.getBytes());
            out.flush();
            clientSocket.close();
        }
    }
}