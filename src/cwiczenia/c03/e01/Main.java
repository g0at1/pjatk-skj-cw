package cwiczenia.c03.e01;

import java.io.IOException;
import java.net.*;

public class Main {
    public static void main(String[] args) throws IOException {

        byte[]doWyslania = {0x08, 0x54, 0x01, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x03, 0x77, 0x77, 0x77, 0x02, 0x77, 0x70, 0x02, 0x70, 0x6c, 0x00, 0x00, 0x01, 0x00, 0x01};
        String dnsName = "8.8.8.8";
        int dnsPort = 53;
        InetAddress dnsAddress = InetAddress.getByName(dnsName);
        DatagramPacket datagramPacket = new DatagramPacket(
                doWyslania,
                doWyslania.length,
                dnsAddress,
                dnsPort
        );
        DatagramSocket socket = new DatagramSocket();
        socket.send(datagramPacket);
        DatagramPacket datagramPacketToReceive = new DatagramPacket(
                new byte[1500],
                1500
        );
        socket.receive(datagramPacketToReceive);
        InetAddress serverAddress = datagramPacketToReceive.getAddress();
        int serverPort = datagramPacketToReceive.getPort();
        byte[]data = datagramPacketToReceive.getData();
        int amount = datagramPacketToReceive.getLength();
        String dataString = new String(data, 0, amount);
        System.out.println(dataString);
        for(int i = 0; i < amount; i++) {
            System.out.print((int)data[i] + " ");
        }
        System.out.println();
    }
}
