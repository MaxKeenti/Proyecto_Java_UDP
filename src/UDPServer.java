import java.net.*;
import java.io.*;

public class UDPServer {
    private static final int PORT = 9876;
    private static DatagramSocket serverSocket;
    
    public static void main(String[] args) {
        try {
            serverSocket = new DatagramSocket(PORT);
            System.out.println("Servidor iniciado en el puerto " + PORT);
            System.out.println("Esperando la conexión del cliente...");
            
            while (true) {
                // Buffer para recibir los datos entrantes
                byte[] receiveData = new byte[1024];
                
                // Recibir el packet del cliente
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                
                // Obtener la información del cliente
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                
                System.out.println("Cliente conectado desde: " + clientAddress + ":" + clientPort);
                
                // Preparar los tipos de datos a enviar
                byte[] responseData = prepareDataTypes();
                
                // Enviar respuesta al cliente
                DatagramPacket sendPacket = new DatagramPacket(
                    responseData, responseData.length, clientAddress, clientPort
                );
                serverSocket.send(sendPacket);
                
                System.out.println("Datos enviados al cliente satisfactoriamente!");
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
    
    private static byte[] prepareDataTypes() {
        try {
            // Usando ByteArrayOutputStream para combinar todos los datos
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            DataOutputStream dataStream = new DataOutputStream(byteStream);
            
            // 1. int
            dataStream.writeUTF("INT");
            dataStream.writeInt(42);
            
            // 2. double
            dataStream.writeUTF("DOUBLE");
            dataStream.writeDouble(12.342);
            
            // 3. float
            dataStream.writeUTF("FLOAT");
            dataStream.writeFloat(1.23f);
            
            // 4. long
            dataStream.writeUTF("LONG");
            dataStream.writeLong(129039023L);
            
            // 5. String
            dataStream.writeUTF("STRING");
            dataStream.writeUTF("Hola Mundo!");
            
            // 6. char
            dataStream.writeUTF("CHAR");
            dataStream.writeChar('C');
            
            // 7. boolean
            dataStream.writeUTF("BOOLEAN");
            dataStream.writeBoolean(true);
            
            // 8. short
            dataStream.writeUTF("SHORT");
            dataStream.writeShort(1000);
            
            // 9. byte
            dataStream.writeUTF("BYTE");
            dataStream.writeByte(127);
            
            // 10. int array
            dataStream.writeUTF("ARRAY_INT");
            int[] intArray = {1, 2, 3, 4, 5};
            dataStream.writeInt(intArray.length);
            for (int value : intArray) {
                dataStream.writeInt(value);
            }
            
            // 11. String array
            dataStream.writeUTF("ARRAY_STRING");
            String[] stringArray = {"Java", "UDP", "Red"};
            dataStream.writeInt(stringArray.length);
            for (String str : stringArray) {
                dataStream.writeUTF(str);
            }
            
            // Marcador de final
            dataStream.writeUTF("END");
            
            dataStream.flush();
            return byteStream.toByteArray();
            
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }
}