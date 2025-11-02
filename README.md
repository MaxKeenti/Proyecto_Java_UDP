# 💻 Proyecto: Comunicación Cliente / Servidor con UDP

Este proyecto implementa un sistema de comunicación **Cliente-Servidor** utilizando el protocolo **UDP (User Datagram Protocol)** en **Java**.  
Su objetivo es demostrar cómo se pueden **enviar y recibir distintos tipos de datos** (enteros, flotantes, cadenas, arreglos, etc.) entre dos procesos de manera no orientada a conexión.

---

## 🧠 Objetivo General

Implementar un programa en Java que permita la comunicación entre un cliente y un servidor mediante el protocolo UDP, demostrando el envío y recepción de distintos tipos de datos.

---

## 🎯 Objetivos Específicos

- Comprender la diferencia entre los protocolos **TCP** y **UDP**.  
- Utilizar las clases `DatagramSocket` y `DatagramPacket` para la transmisión de datos.  
- Aplicar flujos de datos binarios (`DataInputStream`, `DataOutputStream`) para manejar distintos tipos de información.  
- Analizar el comportamiento del programa a través de pruebas prácticas.

---

## ⚙️ Descripción del Funcionamiento

El proyecto está compuesto por dos programas:

- **UDPServer.java** — Escucha en un puerto fijo (9876) y responde a las solicitudes de los clientes.
- **UDPClient.java** — Envía una solicitud al servidor y procesa la respuesta recibida.

### Flujo de comunicación:

1. El cliente envía el mensaje `SEND_DATA` al servidor.  
2. El servidor recibe la solicitud, genera un conjunto de datos de distintos tipos y los envía al cliente.  
3. El cliente recibe los datos, los interpreta y los muestra en la consola.  

---

## 🧩 Estructura del Proyecto