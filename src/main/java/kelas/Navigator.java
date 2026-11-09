package kelas;

import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Navigator {
    private static Stage mainStage;

    public static void setStage(Stage stage) {
        mainStage = stage;
    }

    public static void navigateTo(String fxmlPath) {
        try {
            URL fxmlUrl = Navigator.class.getResource(fxmlPath);
            if (fxmlUrl == null) {
                System.err.println("File FXML tidak ditemukan: " + fxmlPath);
                return;
            }
            FXMLLoader loader = new FXMLLoader(fxmlUrl);
            Parent root = loader.load();
            Scene scene = new Scene(root);
            applyCss(scene);
            mainStage.setScene(scene);
            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static FXMLLoader getLoader(String fxmlPath) {
        return new FXMLLoader(Navigator.class.getResource(fxmlPath));
    }

    public static void showScene(Parent root) {
        Scene scene = new Scene(root);
        applyCss(scene);
        mainStage.setScene(scene);
        mainStage.show();
    }

    private static void applyCss(Scene scene) {
        URL cssUrl = Navigator.class.getResource("/kelas/styles/app.css");
        if (cssUrl != null) {
            scene.getStylesheets().add(cssUrl.toExternalForm());
        }
    }

    public static Stage getStage() {
        return mainStage;
    }
}