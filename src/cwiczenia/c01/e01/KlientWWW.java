package cwiczenia.c01.e01;

import java.io.*;
import java.net.Socket;

public class KlientWWW {
    public static void main(String[] args) throws IOException {
        String serverName = "128.119.245.12";
        int serverPort = 80;
        String request1 = "GET /ethereal-labs/lab2-1.html HTTP/1.1\r\n";
        log("Connecting to the server: " + serverName + ":" + serverPort);
        Socket clientConnection = new Socket(serverName, serverPort);
        log("Connected to the server: " + serverName + ":" + serverPort);
        log("Stream collecting");
        InputStream is = clientConnection.getInputStream();
        OutputStream os = clientConnection.getOutputStream();
        InputStreamReader isr = new InputStreamReader(is);
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedReader br = new BufferedReader(isr);
        BufferedWriter bw = new BufferedWriter(osw);
        log("Sending req 1: " + request1);
        bw.write(request1);
        bw.newLine();
        bw.flush();
        log("Receiving answer");
        String answer = br.readLine();
        log("Received answer 1: " + answer);

        log("Closing connection to the server: " + serverName + ":" + serverPort);
        clientConnection.close();
        log("Closed connection to the server: " + serverName + ":" + serverPort);
    }

    public static void log(String mesg) {
        System.out.println("[K]: " + mesg);
        System.out.flush();
    }
}