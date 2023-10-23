package cwiczenia.c02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerUdp1 {
    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(1053);

        byte[] toReceive = new byte[1500];
        DatagramPacket packetToReceive = new DatagramPacket(toReceive, toReceive.length);
        socket.receive(packetToReceive);

        System.out.println(new String(packetToReceive.getData(), 0, packetToReceive.getLength()));



        byte[] toSend = {0x08, 0x54, 0x01, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x03, 0x77, 0x77, 0x77, 0x02, 0x77, 0x70, 0x02, 0x70, 0x6c, 0x00, 0x00, 0x01, 0x00, 0x01};

        DatagramPacket packet = new DatagramPacket(toSend, toSend.length, packetToReceive.getAddress(), packetToReceive.getPort());

        socket.send(packet);



    }
}
