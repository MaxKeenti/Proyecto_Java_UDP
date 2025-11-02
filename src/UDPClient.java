import java.net.*;
import java.io.*;

public class UDPClient {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 9876;
    
    public static void main(String[] args) {
        DatagramSocket clientSocket = null;
        
        try {
            // Create client socket
            clientSocket = new DatagramSocket();
            
            // Server address
            InetAddress serverAddress = InetAddress.getByName(SERVER_HOST);
            
            // Send request to server (just a simple trigger message)
            String request = "SEND_DATA";
            byte[] sendData = request.getBytes();
            
            DatagramPacket sendPacket = new DatagramPacket(
                sendData, sendData.length, serverAddress, SERVER_PORT
            );
            
            System.out.println("Sending request to server...");
            clientSocket.send(sendPacket);
            
            // Receive response from server
            byte[] receiveData = new byte[65507]; // Maximum UDP packet size
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            
            System.out.println("Waiting for server response...");
            clientSocket.receive(receivePacket);
            
            // Process received data
            processReceivedData(receivePacket.getData(), receivePacket.getLength());
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (clientSocket != null) {
                clientSocket.close();
            }
        }
    }
    
    private static void processReceivedData(byte[] data, int length) {
        try {
            ByteArrayInputStream byteStream = new ByteArrayInputStream(data, 0, length);
            DataInputStream dataStream = new DataInputStream(byteStream);
            
            System.out.println("\n=== DATA RECEIVED FROM SERVER ===");
            
            String dataType;
            while (!(dataType = dataStream.readUTF()).equals("END")) {
                switch (dataType) {
                    case "INT":
                        int intValue = dataStream.readInt();
                        System.out.println("int: " + intValue);
                        break;
                        
                    case "DOUBLE":
                        double doubleValue = dataStream.readDouble();
                        System.out.println("double: " + doubleValue);
                        break;
                        
                    case "FLOAT":
                        float floatValue = dataStream.readFloat();
                        System.out.println("float: " + floatValue);
                        break;
                        
                    case "LONG":
                        long longValue = dataStream.readLong();
                        System.out.println("long: " + longValue);
                        break;
                        
                    case "STRING":
                        String stringValue = dataStream.readUTF();
                        System.out.println("String: " + stringValue);
                        break;
                        
                    case "CHAR":
                        char charValue = dataStream.readChar();
                        System.out.println("char: " + charValue);
                        break;
                        
                    case "BOOLEAN":
                        boolean booleanValue = dataStream.readBoolean();
                        System.out.println("boolean: " + booleanValue);
                        break;
                        
                    case "SHORT":
                        short shortValue = dataStream.readShort();
                        System.out.println("short: " + shortValue);
                        break;
                        
                    case "BYTE":
                        byte byteValue = dataStream.readByte();
                        System.out.println("byte: " + byteValue);
                        break;
                        
                    case "ARRAY_INT":
                        int arrayLength = dataStream.readInt();
                        int[] intArray = new int[arrayLength];
                        System.out.print("arrayInt: [");
                        for (int i = 0; i < arrayLength; i++) {
                            intArray[i] = dataStream.readInt();
                            System.out.print(intArray[i]);
                            if (i < arrayLength - 1) System.out.print(", ");
                        }
                        System.out.println("]");
                        break;
                        
                    case "ARRAY_STRING":
                        int strArrayLength = dataStream.readInt();
                        String[] strArray = new String[strArrayLength];
                        System.out.print("arrayString: [");
                        for (int i = 0; i < strArrayLength; i++) {
                            strArray[i] = dataStream.readUTF();
                            System.out.print("\"" + strArray[i] + "\"");
                            if (i < strArrayLength - 1) System.out.print(", ");
                        }
                        System.out.println("]");
                        break;
                }
            }
            
            System.out.println("=== END OF DATA ===");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}