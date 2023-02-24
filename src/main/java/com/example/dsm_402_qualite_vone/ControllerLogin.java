package com.example.dsm_402_qualite_vone;

import com.example.dsm_402_qualite_vone.Respuesta;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class ControllerLogin {

    @FXML
    private TextField txtNombre;

    @FXML
    private PasswordField pssClave;

    @FXML
    private Button btnLogin;

    public void iniciarSesionRest(ActionEvent event) {
        HttpResponse<JsonNode> apiResponse = null;
        Alert alerta = null;
        try {
            String url="http://localhost:8080/Optica_Web/servicio/empleado/login?user=" + txtNombre.getText()
                    + "&password="+pssClave.getText();

            apiResponse = Unirest.get(url).asJson();
            Respuesta respuesta = new Gson().fromJson(apiResponse.getBody().toString(),Respuesta.class);
            mostrarVentana();
        } catch (Exception e) {
            int status = apiResponse.getStatus();
            alerta = new Alert(Alert.AlertType.ERROR, "Error: " + status);
            alerta.show();
            System.out.println(e);
        }
    }

    public void mostrarVentana() throws IOException {
        Parent principal = FXMLLoader.load(this.getClass().getResource("Nuevo.fxml"));
        Scene scene = new Scene(principal);
        Stage window = new Stage();
        window.setScene(scene);
        window.setTitle("Bienvenido");
        window.show();
        window.setResizable(true);

        Stage windowLogin = (Stage) btnLogin.getScene().getWindow();
        windowLogin.close();

    }
}