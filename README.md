**Ejercicio 1 examen final 2Ev PSP**
Esta aplicación Java implementa un sistema reactiva para la gestión de URLs proporcionadas por el usuario. Las URLs son almacenadas junto con una cadena única generada aleatoriamente de 20 caracteres. 
Una clase DownloaderAndZipper actúa como observador de este listado, mostrando mensajes por consola cada vez que se añade un elemento al mismo.

**Funcionalidades**
Gestión de URLs: Los usuarios pueden proporcionar direcciones URL que serán almacenadas junto con una cadena aleatoria de 20 caracteres.
Descarga y Compresión: Cuando se añade una URL, si está vacía, se muestra un mensaje indicando que se procederá a descargar y comprimir los ficheros.
Patrón Observer-Listener: Se implementa el patrón Observer-Listener para la actualización de la clase DownloaderAndZipper cada vez que se añade una URL al listado.
Estructura del Proyecto
src/: Contiene el código fuente de la aplicación.
Main.java: Punto de entrada del programa.
URLManager.java: Clase encargada de gestionar las URLs proporcionadas por el usuario y generar las cadenas únicas.
DownloaderAndZipper.java: Clase que actúa como observador del listado de URLs y muestra mensajes por consola.
README.md: Este archivo que proporciona información sobre el proyecto y su funcionamiento.
**Ejecución**
Clona este repositorio en tu máquina local.
Abre el proyecto en IntelliJ IDEA.
Ejecuta el archivo Main.java para iniciar la aplicación.
Sigue las instrucciones en la consola para proporcionar URLs y observar la funcionalidad de descarga y compresión.
**Requisitos**
Java Development Kit (JDK) instalado en tu sistema.
IntelliJ IDEA o cualquier otro entorno de desarrollo compatible con Java.
