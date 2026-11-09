package kelas;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        Navigator.setStage(primaryStage);
        primaryStage.setTitle("Aplikasi Daftar Produk Toko");
        Navigator.navigateTo("/kelas/form.fxml");
    }

    public static void main(String[] args) {
        launch(args);
    }
}