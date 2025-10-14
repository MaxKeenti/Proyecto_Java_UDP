// Necesitas investigar:
DatagramSocket socket = new DatagramSocket(port);
DatagramPacket packet = new DatagramPacket(buffer, length);
socket.send(packet);
socket.receive(packet);