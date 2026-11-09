package kelas.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import kelas.Navigator;
import kelas.data.DataProduk;
import kelas.model.Produk;

public class FormController {
    @FXML private TextField txtKode;
    @FXML private TextField txtNama;
    @FXML private ChoiceBox<String> cbKategori;
    @FXML private TextField txtHarga;

    @FXML
    public void initialize() {
        cbKategori.setItems(FXCollections.observableArrayList("Makanan", "Minuman"));
        cbKategori.getSelectionModel().selectFirst();
    }

    @FXML
    private void handleSimpan() {
        String kode = txtKode.getText().trim();
        String nama = txtNama.getText().trim();
        String kategori = cbKategori.getValue();
        String strHarga = txtHarga.getText().trim();

        if (kode.isEmpty() || nama.isEmpty()) {
            showAlert("Validasi Gagal", "Kode dan Nama produk tidak boleh kosong!");
            return;
        }

        double harga;
        try {
            harga = Double.parseDouble(strHarga);
            if (harga <= 0) {
                showAlert("Validasi Gagal", "Harga produk harus lebih dari 0!");
                return;
            }
        } catch (NumberFormatException e) {
            showAlert("Validasi Gagal", "Harga harus berupa angka yang valid!");
            return;
        }

        Produk produkBaru = new Produk(kode, nama, kategori, harga);
        DataProduk.tambahProduk(produkBaru);

        Navigator.navigateTo("/kelas/daftar.fxml");
    }

    @FXML
    private void handleLihatDaftar() {
        Navigator.navigateTo("/kelas/daftar.fxml");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}