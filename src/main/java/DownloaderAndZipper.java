import javafx.collections.ListChangeListener;

public class DownloaderAndZipper implements ListChangeListener<String> {
    @Override
    public void onChanged(Change<? extends String> change) {
        while (change.next()) {
            if (change.wasAdded()) {
                String[] parts = change.getAddedSubList().get(0).split(" ");
                System.out.println(parts[0] + " encolado como " + parts[1]);
            }
        }
    }
}