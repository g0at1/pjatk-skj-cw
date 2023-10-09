package cwiczenia.c01.e02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        int serverPort = 8000;
        log("Starting server: " + serverPort);
        ServerSocket welcomeConnection = new ServerSocket(serverPort);
        log("Started server: " + serverPort);
        log("Listening at port " + serverPort);
        Socket clientConnection = welcomeConnection.accept();
        log("Client connected: " + clientConnection.getInetAddress() + ":" + clientConnection.getPort());
        log("Stream collecting");
        InputStream is = clientConnection.getInputStream();
        OutputStream os = clientConnection.getOutputStream();
        InputStreamReader isr = new InputStreamReader(is);
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedReader br = new BufferedReader(isr);
        BufferedWriter bw = new BufferedWriter(osw);

        log("Closing connection to the client: " + serverPort);
        clientConnection.close();
        log("Closed connection to the server: " + serverPort);
    }
    public static void log(String mesg) {
        System.out.println("[S]: " + mesg);
        System.out.flush();
    }
}
 