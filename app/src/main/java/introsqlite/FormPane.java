package introsqlite;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FormPane {

    Button add = new Button("Add");
    Button update = new Button("Update");
    Button delete = new Button("Delete");
    VBox content = new VBox();

    public VBox getFormPane() {

        add.setPrefSize(110, 40);
        add.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #ffffff; -fx-background-radius: 0");
        add.setOnAction(e -> {
            setActive(1);
            setForm(1);
        });
        update.setPrefSize(110, 40);
        update.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #ffffff; -fx-background-radius: 0");
        update.setOnAction(e -> {
            setActive(2);
            setForm(2);
        });
        delete.setPrefSize(110, 40);
        delete.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #ffffff; -fx-background-radius: 0");
        delete.setOnAction(e -> {
            setActive(3);
            setForm(3);
        });

        content.setSpacing(10);
        content.setStyle("-fx-padding: 15px");

        setActive(1);
        setForm(1);

        HBox hBox = new HBox(add, update, delete);
        hBox.setAlignment(Pos.BOTTOM_CENTER);

        VBox vBox = new VBox(hBox, content);
        vBox.setStyle("-fx-padding: 20px");
        vBox.setPrefSize(370, 600);

        return vBox;
    }

    void setActive(int button) {
        add.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #ffffff;  -fx-background-radius: 0");
        update.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #ffffff; -fx-background-radius: 0");
        delete.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #ffffff; -fx-background-radius: 0");
        switch (button) {
            case 1 -> add.setStyle("-fx-background-color: #00ffff; -fx-text-fill: #000000; -fx-background-radius: 0");
            case 2 -> update.setStyle("-fx-background-color: #00ffff; -fx-text-fill: #000000; -fx-background-radius: 0");
            case 3 -> delete.setStyle("-fx-background-color: #00ffff; -fx-text-fill: #000000; -fx-background-radius: 0");
        }
    }

    void setForm(int type) {
        switch (type) {
            case 1 -> {
                content.getChildren().clear();

                Label lb_nim = new Label("NIM");
                lb_nim.setPrefSize(100, 20);
                TextField tf_nim = new TextField();
                tf_nim.setPrefSize(200, 20);

                HBox nim = new HBox(lb_nim, tf_nim);

                Label lb_nama = new Label("Nama");
                lb_nama.setPrefSize(100, 20);
                TextField tf_nama = new TextField();
                tf_nama.setPrefSize(200, 20);

                HBox nama = new HBox(lb_nama, tf_nama);

                Label lb_prodi = new Label("Program Studi");
                lb_prodi.setPrefSize(100, 20);
                TextField tf_prodi = new TextField();
                tf_prodi.setPrefSize(200, 20);

                HBox prodi = new HBox(lb_prodi, tf_prodi);

                content.getChildren().addAll(nim, nama, prodi);
            }
            case 2 -> {
                content.getChildren().clear();

                Label lb_nim = new Label("NIM");
                lb_nim.setPrefSize(100, 20);
                TextField tf_nim = new TextField();
                tf_nim.setPrefSize(200, 20);

                HBox nim = new HBox(lb_nim, tf_nim);

                Label lb_nama = new Label("Nama");
                lb_nama.setPrefSize(100, 20);
                TextField tf_nama = new TextField();
                tf_nama.setPrefSize(200, 20);

                HBox nama = new HBox(lb_nama, tf_nama);

                Label lb_prodi = new Label("Program Studi");
                lb_prodi.setPrefSize(100, 20);
                TextField tf_prodi = new TextField();
                tf_prodi.setPrefSize(200, 20);

                HBox prodi = new HBox(lb_prodi, tf_prodi);

                content.getChildren().addAll(nim, nama, prodi);

            }
            case 3 -> {
                content.getChildren().clear();

                Label lb_nim = new Label("NIM");
                lb_nim.setPrefSize(100, 20);
                TextField tf_nim = new TextField();
                tf_nim.setPrefSize(200, 20);

                HBox nim = new HBox(lb_nim, tf_nim);

                Label lb_nama = new Label("Nama");
                lb_nama.setPrefSize(100, 20);
                TextField tf_nama = new TextField();
                tf_nama.setPrefSize(200, 20);

                HBox nama = new HBox(lb_nama, tf_nama);

                Label lb_prodi = new Label("Program Studi");
                lb_prodi.setPrefSize(100, 20);
                TextField tf_prodi = new TextField();
                tf_prodi.setPrefSize(200, 20);

                HBox prodi = new HBox(lb_prodi, tf_prodi);

                content.getChildren().addAll(nim, nama, prodi);

            }
        }
    }

}
