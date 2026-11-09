package kelas.controller;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import kelas.Navigator;
import kelas.data.DataProduk;
import kelas.model.Produk;

public class DaftarController {
    @FXML private TextField txtCari;
    @FXML private TableView<Produk> tableProduk;
    @FXML private TableColumn<Produk, String> colKode;
    @FXML private TableColumn<Produk, String> colNama;
    @FXML private TableColumn<Produk, String> colKategori;
    @FXML private TableColumn<Produk, Double> colHarga;

    private final ObservableList<Produk> masterData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colKode.setCellValueFactory(new PropertyValueFactory<>("kode"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colKategori.setCellValueFactory(new PropertyValueFactory<>("kategori"));
        colHarga.setCellValueFactory(new PropertyValueFactory<>("harga"));

        masterData.setAll(DataProduk.getListProduk());
        tableProduk.setItems(masterData);
    }

    @FXML
    private void handleCari() {
        String keyword = txtCari.getText().toLowerCase().trim();
        if (keyword.isEmpty()) {
            tableProduk.setItems(masterData);
        } else {
            ObservableList<Produk> hasilCari = FXCollections.observableArrayList();
            for (Produk p : masterData) {
                if (p.getNama().toLowerCase().contains(keyword)) {
                    hasilCari.add(p);
                }
            }
            tableProduk.setItems(hasilCari);
        }
    }

    @FXML
    private void handleLihatDetail() {
        Produk selected = tableProduk.getSelectionModel().getSelectedItem();
        if (selected == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Peringatan");
            alert.setHeaderText(null);
            alert.setContentText("Pilih produk pada tabel terlebih dahulu!");
            alert.showAndWait();
            return;
        }

        try {
            FXMLLoader loader = Navigator.getLoader("/kelas/detail.fxml");
            Parent root = loader.load();

            DetailController detailController = loader.getController();
            detailController.setProduk(selected);

            Navigator.showScene(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleTambahBaru() {
        Navigator.navigateTo("/kelas/form.fxml");
    }
}