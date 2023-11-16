package cwiczenia.c03.e03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerUDP {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(10053);
        DatagramPacket datagramPacketToReceive = new DatagramPacket(
                new byte[1500],
                1500
        );
        socket.receive(datagramPacketToReceive);
        InetAddress clientAddress = datagramPacketToReceive.getAddress();
        int clientPort = datagramPacketToReceive.getPort();
        byte[]data = datagramPacketToReceive.getData();
        int amount = datagramPacketToReceive.getLength();
        String dataString = new String(data, 0, amount);
        System.out.println(dataString);
        for(int i = 0; i < amount; i++) {
            System.out.print((int)data[i] + " ");
        }
        System.out.println();

        DatagramPacket datagramPacket = new DatagramPacket(
                "Ala ma kota".getBytes(),
                "Ala ma kota".getBytes().length,
                clientAddress,
                clientPort
        );
        socket.send(datagramPacket);
    }
}
