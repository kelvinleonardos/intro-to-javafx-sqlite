package introsqlite;

import introsqlite.controller.MahasiswaController;
import introsqlite.model.Mahasiswa;
import javafx.collections.ObservableList;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.control.TableColumn;

public class ListPane {

    TableView<Mahasiswa> tableView;
    MahasiswaController mahasiswaController = new MahasiswaController();

    public StackPane getListPane() {

        tableView = new TableView<>();
        TableColumn<Mahasiswa, String> nimColumn = new TableColumn<>("nim");
        nimColumn.setCellValueFactory(new PropertyValueFactory<>("nim"));
        TableColumn<Mahasiswa, String> namaColumn = new TableColumn<>("nama");
        namaColumn.setCellValueFactory(new PropertyValueFactory<>("nama"));
        TableColumn<Mahasiswa, String> prodiColumn = new TableColumn<>("prodi");
        prodiColumn.setCellValueFactory(new PropertyValueFactory<>("prodi"));

        tableView.getColumns().add(nimColumn);
        tableView.getColumns().add(namaColumn);
        tableView.getColumns().add(prodiColumn);

        ScrollPane scrollPane = new ScrollPane(tableView);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        StackPane stackPane = new StackPane(scrollPane);
        stackPane.setStyle("-fx-padding: 20px");
        stackPane.setPrefSize(430, 600);

        loadData();

        return stackPane;

    }

    public void loadData() {
        ObservableList<Mahasiswa> mahasiswa = mahasiswaController.selectAll();
        tableView.setItems(mahasiswa);
    }

}
