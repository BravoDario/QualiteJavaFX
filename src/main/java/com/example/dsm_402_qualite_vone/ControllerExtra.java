package com.example.dsm_402_qualite_vone;

import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Base64;
import java.util.ResourceBundle;

public class ControllerExtra implements Initializable {

    @FXML
    private ImageView ivImagen;
    @FXML
    private Button btnBuscar;

    public void imprimit(Image imagne) throws IOException {
        //String imgJSON = new Gson().toJson(imagne);
        //System.out.println(imgJSON);

        File file = new File("image_path");
        byte[] bytes = new byte[(int)file.length()];
        FileInputStream fis = new FileInputStream(file);
        fis.read(bytes);
        fis.close();
        String ef = Base64.getEncoder().encodeToString(bytes);
        Image image = new Image(file.toURI().toString());
        System.out.println(image);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        btnBuscar.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Buscar Imagen");

            // Agregar filtros para facilitar la busqueda
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("All Images", "*.*"),
                    new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                    new FileChooser.ExtensionFilter("PNG", "*.png")
            );

            // Obtener la imagen seleccionada
            File imgFile = fileChooser.showOpenDialog(null);

            // Mostar la imagen
            if (imgFile != null) {
                Image image = new Image("file:" + imgFile.getAbsolutePath());
                ivImagen.setImage(image);
                try {
                    imprimit(image);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
