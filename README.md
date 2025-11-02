#  Proyecto: Comunicación Cliente / Servidor con UDP

Este proyecto implementa un sistema de comunicación **Cliente-Servidor** utilizando el protocolo **UDP (User Datagram Protocol)** en **Java**.  
Su objetivo es demostrar cómo se pueden **enviar y recibir distintos tipos de datos** (enteros, flotantes, cadenas, arreglos, etc.) entre dos procesos de manera no orientada a conexión.

---

##  Objetivo General

Implementar un programa en Java que permita la comunicación entre un cliente y un servidor mediante el protocolo UDP, demostrando el envío y recepción de distintos tipos de datos.

---

##  Objetivos Específicos

- Comprender la diferencia entre los protocolos **TCP** y **UDP**.  
- Utilizar las clases `DatagramSocket` y `DatagramPacket` para la transmisión de datos.  
- Aplicar flujos de datos binarios (`DataInputStream`, `DataOutputStream`) para manejar distintos tipos de información.  
- Analizar el comportamiento del programa a través de pruebas prácticas.

---

##  Descripción del Funcionamiento

El proyecto está compuesto por dos programas:

- **UDPServer.java** — Escucha en un puerto fijo (9876) y responde a las solicitudes de los clientes.
- **UDPClient.java** — Envía una solicitud al servidor y procesa la respuesta recibida.

### Flujo de comunicación:

1. El cliente envía el mensaje `SEND_DATA` al servidor.  
2. El servidor recibe la solicitud, genera un conjunto de datos de distintos tipos y los envía al cliente.  
3. El cliente recibe los datos, los interpreta y los muestra en la consola.  

---

##  Estructura del Proyecto

---

## Explicación del Código

### Servidor (UDPServer.java)

- Escucha conexiones en el puerto `9876`.
- Utiliza `DatagramSocket` para recibir mensajes.
- Genera diferentes tipos de datos (int, double, String, boolean, arrays, etc.) y los envía como flujo binario.
- Envía los datos codificados al cliente e indica el final de la transmisión.

### Cliente (UDPClient.java)

- Crea un socket UDP y envía un mensaje de solicitud (`SEND_DATA`) al servidor.
- Espera la respuesta, la recibe y procesa los datos usando `DataInputStream`.
- Muestra todos los tipos de datos recibidos en la consola de forma legible.

---

## Ejemplo de Ejecución

### Servidor

```
Servidor iniciado en el puerto 9876
Esperando la conexión del cliente...
Cliente conectado desde: /127.0.0.1:54321
Datos enviados al cliente satisfactoriamente.
```

### Cliente

```
=== DATOS RECIBIDOS DEL SERVIDOR ===
int: 42
double: 12.342
float: 1.23
long: 129039023
String: Hola Mundo!
char: C
boolean: true
short: 1000
byte: 127
arrayInt: [1, 2, 3, 4, 5]
arrayString: ["Java", "UDP", "Red"]
=== FIN DE DATOS ===
```

---

## Instrucciones de Ejecución

1. Compilar los programas:

```bash
javac UDPServer.java UDPClient.java
```

2. Ejecutar el servidor:

```bash
java UDPServer
```

3. Ejecutar el cliente (en una nueva terminal):

```bash
java UDPClient
```

*Nota:* Ambos programas deben ejecutarse en la misma red o en la misma máquina utilizando `localhost`.

---

## Tecnologías Utilizadas

- Lenguaje: Java  
- Protocolo de comunicación: UDP  
- Clases principales: `DatagramSocket`, `DatagramPacket`, `DataInputStream`, `DataOutputStream`

---

## Conclusiones

Este proyecto permitió comprender el funcionamiento del protocolo UDP y sus principales características.  
Se evidenció que es un protocolo rápido y eficiente, aunque no garantiza la entrega ni el orden de los mensajes.  

Asimismo, se reforzó el uso de flujos binarios en Java para la transmisión de distintos tipos de datos, demostrando cómo se pueden implementar sistemas de comunicación eficaces en entornos distribuidos.

---

## Datos del Equipo

**Equipo 3**

- García Salgado Ángel Gabriel  
- García Zavala Sebastián  
- Garrido Cázares Ashley Elizabeth  
- González Calzada Maximiliano  
- Espinosa Esquivias Mauricio Genaro  

**Profesor:** Hernández Cerón Ricardo  
**Unidad de Aprendizaje:** Redes y Conectividad  
**Secuencia:** 5NM52  
**Institución:** Instituto Politécnico Nacional – UPIICSA  
**Práctica:** Comunicación Cliente / Servidor con UDP – Noviembre 2025