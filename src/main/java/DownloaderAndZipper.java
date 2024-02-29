import javafx.collections.ListChangeListener;

public class DownloaderAndZipper implements ListChangeListener<String> {
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
}