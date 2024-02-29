import javafx.collections.ListChangeListener;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class DownloaderAndZipper implements ListChangeListener<String> {

    private List<Path> archivosDescargados = new ArrayList<>();

    @Override
    public void onChanged(Change<? extends String> change) {
        //metodo mientras haya cambios
        while (change.next()) {
            //si se añade un elemento
            if (change.wasAdded()) {
                //separar la url del nombre aleatorio
                String[] parts = change.getAddedSubList().get(0).split(" ");
                System.out.println(parts[0] + " encolado como " + parts[1]);
            }
        }
    }

    //metodo para descargar el fichero
    public CompletableFuture<Void>descargarFichero(String url, String nombreFichero){
        //devuelve un futuro que se ejecutara en un hilo separado
        return CompletableFuture.runAsync(() -> {
            try (InputStream in = new URL(url).openStream()) {
                //creamos el path del fichero
                Path outputPath = Paths.get(nombreFichero);
                //copiamos el contenido del fichero en el path
                Files.copy(in, outputPath);
                //Añadimos el path a la lista de archivos descargados
                archivosDescargados.add(outputPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    public void comprimirArchivo() throws IOException {
        //creamos el zip con nombre compressed.zip
        try (ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(Paths.get("contenidoUrls.zip")))) {

            //recorremos la lista de archivos descargados para ir añadiendolos al zip
            for (Path file : archivosDescargados) {
            //añadimos cada fichero a la compresion
                ZipEntry zipEntry = new ZipEntry(file.getFileName().toString());
                zos.putNextEntry(zipEntry);
                Files.copy(file, zos);
                zos.closeEntry();
            }
        }
    }
}
