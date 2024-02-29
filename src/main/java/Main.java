import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Random;
import java.util.Scanner;


public class Main {

    private static final String randomChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final int tamanyo = 20;

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        String url;
        DownloaderAndZipper downloader = new DownloaderAndZipper();
        ObservableList<String> urls = FXCollections.observableArrayList();
        urls.addListener(downloader);

        while (true) {
            System.out.println("Introduce una URL:");
            url = reader.nextLine();
            if (url.isEmpty()) {
                System.out.println("Se va a proceder a descargar y comprimir los ficheros");
                break;
            }
            String randomString = generarCadenaRandom();
            urls.add(url + " " + randomString);
        }
    }

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