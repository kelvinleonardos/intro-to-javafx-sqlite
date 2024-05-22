package introsqlite;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;

public class ListPane {

    public StackPane getListPane() {

        ScrollPane scrollPane = new ScrollPane();

        StackPane stackPane = new StackPane(scrollPane);
        stackPane.setStyle("-fx-padding: 20px");
        stackPane.setPrefSize(430, 600);

        return stackPane;

    }

}
