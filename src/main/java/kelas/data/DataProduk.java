package kelas.data;

import java.util.ArrayList;
import java.util.List;
import kelas.model.Produk;

public class DataProduk {
    private static final List<Produk> listProduk = new ArrayList<>();

    public static List<Produk> getListProduk() {
        return listProduk;
    }

    public static void tambahProduk(Produk produk) {
        listProduk.add(produk);
    }
}