package kelas.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import kelas.Navigator;
import kelas.model.Produk;

public class DetailController {
    @FXML private Label lblKode;
    @FXML private Label lblNama;
    @FXML private Label lblKategori;
    @FXML private Label lblHarga;

    public void setProduk(Produk produk) {
        if (produk != null) {
            lblKode.setText(produk.getKode());
            lblNama.setText(produk.getNama());
            lblKategori.setText(produk.getKategori());
            lblHarga.setText(String.format("Rp %,.0f", produk.getHarga()));
        }
    }

    @FXML
    private void handleKembali() {
        Navigator.navigateTo("/kelas/daftar.fxml");
    }
}