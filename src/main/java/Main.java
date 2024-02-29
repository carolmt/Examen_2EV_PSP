import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

/*Amplía la aplicación anterior para que en el momento de que el usuario introduzca una URL vacía, se proceda a descargar
 todas las URLs cada una con un nombre
 de fichero (el nombre aleatorio único creado) y al terminar este proceso se comprimirán todos los archivos en un
  único archivo .ZIP. Esto lo deberás hacer
 usando Futuros de Java, de modo que la descarga de todos los archivos es la primera parte del futuro y cuando este
 proceso termina se ejecuta la
compresión de todos ellos en un archivo .zip.*/

public class Main {
//creamos una cadena de caracteres aleatoria
    private static final String randomChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    //tamaño de la cadena
    private static final int tamanyo = 20;

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        String url;
        DownloaderAndZipper downloader = new DownloaderAndZipper();
        ObservableList<String> urls = FXCollections.observableArrayList();
        urls.addListener(downloader);

        //lista de futuros para las descargas
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        //bucle infinito para introducir urls
        while (true) {
            System.out.println("Introduce una URL:");
            url = reader.nextLine();

            //condicion de fin d bucle
            if (url.isEmpty()) {
                System.out.println("Se va a proceder a descargar y comprimir los ficheros");
                CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).thenRun(() -> {
                    try {
                        downloader.comprimirArchivo();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                        });
                break;
            }
            //llamos al metodo para generar la clave aleatoria
            String randomString = generarCadenaRandom();
            urls.add(url + " " + randomString);
            //añadimos a la lista de futuros la descarga del fichero
            futures.add(downloader.descargarFichero(url, randomString));

        }
    }

    //metodo para generar la cadena aleatoria
    private static String generarCadenaRandom() {
        Random random = new Random();
        StringBuilder builder = new StringBuilder(tamanyo);
        for (int i = 0; i < tamanyo; i++) {
            int characterIndex = random.nextInt(randomChars.length());
            builder.append(randomChars.charAt(characterIndex));
        }
        return builder.toString();
    }
}