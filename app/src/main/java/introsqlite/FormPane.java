package introsqlite;

import introsqlite.controller.MahasiswaController;
import introsqlite.model.Mahasiswa;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FormPane {

    Button add, update, delete, submit, cancel;
    VBox content;
    MahasiswaController mahasiswaController = new MahasiswaController();
    ListPane listPane;

    public FormPane(ListPane listPane) {
        this.listPane = listPane;
    }

    public VBox getFormPane() {

        add = new Button("Add");
        add.setPrefSize(110, 40);
        add.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #ffffff; -fx-background-radius: 0");
        add.setOnAction(e -> {
            setActive(1);
            setForm(1);
            setSubmit(1);
        });

        update = new Button("Update");
        update.setPrefSize(110, 40);
        update.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #ffffff; -fx-background-radius: 0");
        update.setOnAction(e -> {
            setActive(2);
            setForm(2);
            setSubmit(2);
        });

        delete = new Button("Delete");
        delete.setPrefSize(110, 40);
        delete.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #ffffff; -fx-background-radius: 0");
        delete.setOnAction(e -> {
            setActive(3);
            setForm(3);
            setSubmit(3);
        });

        content = new VBox();
        content.setSpacing(10);
        content.setStyle("-fx-padding: 15px");

        submit = new Button();
        submit.setPrefSize(330, 25);
        submit.setStyle("-fx-background-color: #0faf0f; -fx-text-fill: #ffffff;  -fx-background-radius: 10");
        
        cancel = new Button("Cancel");
        cancel.setPrefSize(330, 25);
        cancel.setStyle("-fx-background-color: #0faf0f; -fx-text-fill: #ffffff;  -fx-background-radius: 10");

        setActive(1);
        setForm(1);
        setSubmit(1);

        HBox tab = new HBox(add, update, delete);
        tab.setAlignment(Pos.BOTTOM_CENTER);

        VBox buttonGroup = new VBox(submit, cancel);
        buttonGroup.setSpacing(10);

        VBox vBox = new VBox(tab, content, buttonGroup);
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

                content.getChildren().addAll(nim);

            }
        }
    }

    void setSubmit(int type) {
        switch (type) {
            case 1 -> {
                submit.setText("Add Data");
                submit.setOnAction(e -> {
                    String nim = ((TextField) ((HBox) content.getChildren().get(0)).getChildren().get(1)).getText();
                    String nama = ((TextField) ((HBox) content.getChildren().get(1)).getChildren().get(1)).getText();
                    String prodi = ((TextField) ((HBox) content.getChildren().get(2)).getChildren().get(1)).getText();
                    mahasiswaController.insert(nim, nama, prodi);
                    listPane.loadData();
                });
            }
            case 2 -> {
                submit.setText("Update Data");
                submit.setOnAction(e -> {
                    String nim = ((TextField) ((HBox) content.getChildren().get(0)).getChildren().get(1)).getText();
                    String nama = ((TextField) ((HBox) content.getChildren().get(1)).getChildren().get(1)).getText();
                    String prodi = ((TextField) ((HBox) content.getChildren().get(2)).getChildren().get(1)).getText();
                    mahasiswaController.update(nim, nama, prodi);
                    listPane.loadData();
                });
            }
            case 3 -> {
                submit.setText("Delete Data");
                submit.setOnAction(e -> {
                    String nim = ((TextField) ((HBox) content.getChildren().get(0)).getChildren().get(1)).getText();
                    Stage stage = new Stage();
                    Button yes = new Button("Yes");
                    yes.setOnAction(e1 -> {
                        mahasiswaController.delete(nim);
                        listPane.loadData();
                        stage.close();
                    });
                    Button no = new Button("No");
                    no.setOnAction(e1 -> stage.close());
                    VBox vBox = new VBox(new Label("Are you sure want to delete this data?"), yes, no);
                    vBox.setSpacing(10);
                    vBox.setStyle("-fx-padding: 20px");
                    vBox.setPrefSize(200, 100);
                    Scene scene = new Scene(vBox);
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.show();
                
                });
                cancel.setOnAction(e -> {
                    String nim = ((TextField) ((HBox) content.getChildren().get(0)).getChildren().get(1)).getText();
                    Mahasiswa m = mahasiswaController.select(nim);
                    System.err.println(m.getNama());
                });
            }
        }
    }

}