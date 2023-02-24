package com.example.dsm_402_qualite_vone;

import com.example.dsm_402_qualite_vone.model.Cliente;
import com.example.dsm_402_qualite_vone.model.Persona;
import com.jfoenix.controls.JFXBadge;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ControllerViewCliente implements Initializable {
    @FXML
    private JFXTextField txtNombre;
    @FXML
    private JFXTextField txtApellidoPaterno;
    @FXML
    private JFXTextField txtApellidoMaterno;
    @FXML
    private JFXTextField txtFechaNacimiento;
    @FXML
    private JFXTextField txtGenero;
    @FXML
    private JFXTextField txtCalle;
    @FXML
    private JFXTextField txtColonia;
    @FXML
    private JFXTextField txtNumeroCasa;
    @FXML
    private JFXTextField txtCiudad;
    @FXML
    private JFXTextField txtEstado;
    @FXML
    private JFXTextField txtCP;
    @FXML
    private JFXTextField txtCorreoEl;
    @FXML
    private JFXTextField txtTelefonoCasa;
    @FXML
    private JFXTextField txtTelefonoMovil;
    @FXML
    private TableView<Cliente> tblClientes;
    @FXML
    private TableColumn<Cliente, String> colNombre;
    @FXML
    private TableColumn<Cliente, String> colGenero;
    @FXML
    private TableColumn<Cliente, String> colCorreoEl;
    @FXML
    private TableColumn<Cliente, String> colTelefonoMovil;
    @FXML
    private TableColumn<Cliente, String> colEstatus;
    @FXML
    private TableColumn<Cliente, String> colNumeroUnico;
    @FXML
    private AnchorPane menu;
    @FXML
    private AnchorPane insertar;
    @FXML
    private AnchorPane listado;


    @FXML
    private AnchorPane app;
    @FXML
    AnchorPane modal = new AnchorPane();
    @FXML
    Label lblBackground = new Label();
    @FXML
    JFXTextField mTxtNombre = new JFXTextField();
    @FXML
    JFXTextField mTxtApellidoPaterno = new JFXTextField();
    @FXML
    JFXTextField mTxtApellidoMaterno = new JFXTextField();
    @FXML
    JFXTextField mTxtFechaNacimiento = new JFXTextField();
    @FXML
    JFXTextField mTxtGenero = new JFXTextField();
    @FXML
    JFXTextField mTxtCalle = new JFXTextField();
    @FXML
    JFXTextField mTxtColonia = new JFXTextField();
    @FXML
    JFXTextField mTxtNumeroCasa = new JFXTextField();
    @FXML
    JFXTextField mTxtCiudad = new JFXTextField();
    @FXML
    JFXTextField mTxtEstado = new JFXTextField();
    @FXML
    JFXTextField mTxtCP = new JFXTextField();
    @FXML
    JFXTextField mTxtCorreoEl = new JFXTextField();
    @FXML
    JFXTextField mTxtTelefonoCasa = new JFXTextField();
    @FXML
    JFXTextField mTxtTelefonoMovil = new JFXTextField();
    @FXML
    JFXButton mBtnGuardar = new JFXButton();
    @FXML
    JFXButton mBtnEliminar = new JFXButton();
    @FXML
    JFXButton mBtnCancelar = new JFXButton();

    ObservableList<Cliente> listCliente = FXCollections.observableArrayList();

    ControllerCliente cc = new ControllerCliente();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        iniciarTable();
        try {
            listCliente.addAll(cc.fillTable());
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
        tblClientes.setItems(listCliente);
    }

    @FXML
    protected void agregar() throws UnirestException {
        Persona persona = new Persona(
                0,
                txtNombre.getText(),
                txtApellidoPaterno.getText(),
                txtApellidoMaterno.getText(),
                txtGenero.getText(),
                txtFechaNacimiento.getText(),
                txtCalle.getText(),
                txtNumeroCasa.getText(),
                txtColonia.getText(),
                txtCP.getText(),
                txtCiudad.getText(),
                txtEstado.getText(),
                txtTelefonoCasa.getText(),
                txtTelefonoMovil.getText(),
                txtCorreoEl.getText());
        Cliente cliente = new Cliente(0, "", 0, persona);

        cc.guardarCliente(cliente);

        refrescarTabla();
        limpiarForm();
    }

    public void actualizarCliente(int idPersona, int idCliente, String numeroUnico, int estatus) throws UnirestException {
        Persona persona = new Persona(
                idPersona,
                mTxtNombre.getText(),
                mTxtApellidoPaterno.getText(),
                mTxtApellidoMaterno.getText(),
                mTxtGenero.getText(),
                mTxtFechaNacimiento.getText(),
                mTxtCalle.getText(),
                mTxtNumeroCasa.getText(),
                mTxtColonia.getText(),
                mTxtCP.getText(),
                mTxtCiudad.getText(),
                mTxtEstado.getText(),
                mTxtTelefonoCasa.getText(),
                mTxtTelefonoMovil.getText(),
                mTxtCorreoEl.getText());
        Cliente cliente = new Cliente(idCliente, numeroUnico, estatus, persona);
        cc.guardarCliente(cliente);
    }

    public void limpiarForm() {
        mTxtNombre.setText("");
        mTxtApellidoPaterno.setText("");
        mTxtApellidoMaterno.setText("");
        mTxtGenero.setText("");
        mTxtFechaNacimiento.setText("");
        mTxtCalle.setText("");
        mTxtNumeroCasa.setText("");
        mTxtColonia.setText("");
        mTxtCP.setText("");
        mTxtCiudad.setText("");
        mTxtEstado.setText("");
        mTxtTelefonoCasa.setText("");
        mTxtTelefonoMovil.setText("");
        mTxtCorreoEl.setText("");
    }

    public void refrescarTabla() throws UnirestException {
        tblClientes.getItems().clear();
        listCliente.clear();

        listCliente.addAll(cc.fillTable());
        tblClientes.setItems(listCliente);
    }

    public void completarForm() {
        crearVentanaModal();

        mTxtNombre.setText(listCliente.get(tblClientes.getSelectionModel().getSelectedIndex()).getPersona().getNombre());
        mTxtApellidoPaterno.setText(listCliente.get(tblClientes.getSelectionModel().getSelectedIndex()).getPersona().getApellidoPaterno());
        mTxtApellidoMaterno.setText(listCliente.get(tblClientes.getSelectionModel().getSelectedIndex()).getPersona().getApellidoMaterno());
        mTxtFechaNacimiento.setText(listCliente.get(tblClientes.getSelectionModel().getSelectedIndex()).getPersona().getFechaNacimiento());
        mTxtGenero.setText(listCliente.get(tblClientes.getSelectionModel().getSelectedIndex()).getPersona().getGenero());

        mTxtCalle.setText(listCliente.get(tblClientes.getSelectionModel().getSelectedIndex()).getPersona().getCalle());
        mTxtNumeroCasa.setText(listCliente.get(tblClientes.getSelectionModel().getSelectedIndex()).getPersona().getNumero());
        mTxtColonia.setText(listCliente.get(tblClientes.getSelectionModel().getSelectedIndex()).getPersona().getColonia());
        mTxtCiudad.setText(listCliente.get(tblClientes.getSelectionModel().getSelectedIndex()).getPersona().getCiudad());
        mTxtEstado.setText(listCliente.get(tblClientes.getSelectionModel().getSelectedIndex()).getPersona().getEstado());

        mTxtCP.setText(listCliente.get(tblClientes.getSelectionModel().getSelectedIndex()).getPersona().getCp());
        mTxtCorreoEl.setText(listCliente.get(tblClientes.getSelectionModel().getSelectedIndex()).getPersona().getEmail());
        mTxtTelefonoMovil.setText(listCliente.get(tblClientes.getSelectionModel().getSelectedIndex()).getPersona().getTelMovil());
        mTxtTelefonoCasa.setText(listCliente.get(tblClientes.getSelectionModel().getSelectedIndex()).getPersona().getTelCasa());

        mBtnCancelar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                quitarVentanaModal();
            }
        });
        mBtnGuardar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    actualizarCliente(
                            listCliente.get(tblClientes.getSelectionModel().getSelectedIndex()).getPersona().getIdPersona(),
                            listCliente.get(tblClientes.getSelectionModel().getSelectedIndex()).getIdCliente(),
                            listCliente.get(tblClientes.getSelectionModel().getSelectedIndex()).getNumeroUnico(),
                            listCliente.get(tblClientes.getSelectionModel().getSelectedIndex()).getEstatus());
                    refrescarTabla();
                    quitarVentanaModal();
                } catch (UnirestException e) {
                    System.out.println(e);
                }
            }
        });
        mBtnEliminar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setTitle("Alert");
                alert.setContentText("¿Estás seguro de eliminarlo?");


                Optional<ButtonType> action = alert.showAndWait();
                if (action.get() == ButtonType.OK) {
                    try {
                        cc.eliminar(listCliente.get(tblClientes.getSelectionModel().getSelectedIndex()).getIdCliente());
                        refrescarTabla();
                        quitarVentanaModal();
                    } catch (UnirestException e) {
                        System.out.println(e);
                    }
                } else {
                    alert.close();
                }
            }
        });
    }

    public void iniciarTable() {
        colNombre.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getPersona().getNombre()));
        colGenero.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getPersona().getGenero()));
        colCorreoEl.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getPersona().getEmail()));
        colTelefonoMovil.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getPersona().getTelMovil()));
        colEstatus.setCellValueFactory(param -> {
            String estatus = "Activo";
            String color = "-fx-text-fill: #5cb85c;";
            if (param.getValue().getEstatus() == 0) {
                estatus = "Inactivo";
            }
            return new SimpleStringProperty(estatus);
        });
        colNumeroUnico.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getNumeroUnico()));
    }

    public void crearVentanaModal() {
        lblBackground.setStyle("-fx-background-color: rgba(0,0,0,0.166)");
        lblBackground.setLayoutX(-210);
        lblBackground.setLayoutY(0);
        lblBackground.setPrefSize(1263, 645);

        modal.setPrefSize(700, 450);
        modal.setLayoutX(250);
        modal.setLayoutY(100);
        modal.setStyle("-fx-background-color: #FAFAFA");

        mBtnCancelar.setText("X");
        mBtnCancelar.setPrefSize(15, 15);
        mBtnCancelar.setLayoutX(585);
        mBtnCancelar.setLayoutY(0);

        mBtnGuardar.setText("Guardar");
        mBtnGuardar.setPrefSize(100, 10);
        mBtnGuardar.setLayoutX(80);
        mBtnGuardar.setLayoutY(400);
        mBtnGuardar.setStyle("-fx-background-color: #22DD22");

        mBtnEliminar.setText("Eliminar");
        mBtnEliminar.setPrefSize(100, 10);
        mBtnEliminar.setLayoutX(190);
        mBtnEliminar.setLayoutY(400);
        mBtnEliminar.setStyle("-fx-background-color: #DD2222");

        mTxtNombre.setPrefSize(150, 20);
        mTxtNombre.setLayoutX(80);
        mTxtNombre.setLayoutY(50);
        mTxtNombre.setPromptText("Nombre");
        mTxtNombre.setLabelFloat(true);

        mTxtApellidoPaterno.setPrefSize(150, 20);
        mTxtApellidoPaterno.setLayoutX(80);
        mTxtApellidoPaterno.setLayoutY(100);
        mTxtApellidoPaterno.setPromptText("Apellido paterno");
        mTxtApellidoPaterno.setLabelFloat(true);

        mTxtApellidoMaterno.setPrefSize(150, 20);
        mTxtApellidoMaterno.setLayoutX(80);
        mTxtApellidoMaterno.setLayoutY(150);
        mTxtApellidoMaterno.setPromptText("Apellido materno");
        mTxtApellidoMaterno.setLabelFloat(true);

        mTxtFechaNacimiento.setPrefSize(150, 20);
        mTxtFechaNacimiento.setLayoutX(80);
        mTxtFechaNacimiento.setLayoutY(200);
        mTxtFechaNacimiento.setPromptText("Fecha de nacimiento");
        mTxtFechaNacimiento.setLabelFloat(true);

        mTxtGenero.setPrefSize(150, 20);
        mTxtGenero.setLayoutX(80);
        mTxtGenero.setLayoutY(250);
        mTxtGenero.setPromptText("Género");
        mTxtGenero.setLabelFloat(true);

        mTxtCalle.setPrefSize(150, 20);
        mTxtCalle.setLayoutX(250);
        mTxtCalle.setLayoutY(50);
        mTxtCalle.setPromptText("Calle");
        mTxtCalle.setLabelFloat(true);

        mTxtNumeroCasa.setPrefSize(150, 20);
        mTxtNumeroCasa.setLayoutX(250);
        mTxtNumeroCasa.setLayoutY(100);
        mTxtNumeroCasa.setPromptText("Número exterior");
        mTxtNumeroCasa.setLabelFloat(true);

        mTxtColonia.setPrefSize(150, 20);
        mTxtColonia.setLayoutX(250);
        mTxtColonia.setLayoutY(150);
        mTxtColonia.setPromptText("Colonia");
        mTxtColonia.setLabelFloat(true);

        mTxtCiudad.setPrefSize(150, 20);
        mTxtCiudad.setLayoutX(250);
        mTxtCiudad.setLayoutY(200);
        mTxtCiudad.setPromptText("Ciudad");
        mTxtCiudad.setLabelFloat(true);

        mTxtEstado.setPrefSize(150, 20);
        mTxtEstado.setLayoutX(250);
        mTxtEstado.setLayoutY(250);
        mTxtEstado.setPromptText("Estado");
        mTxtEstado.setLabelFloat(true);

        mTxtCP.setPrefSize(150, 20);
        mTxtCP.setLayoutX(420);
        mTxtCP.setLayoutY(50);
        mTxtCP.setPromptText("Código postal");
        mTxtCP.setLabelFloat(true);

        mTxtCorreoEl.setPrefSize(150, 20);
        mTxtCorreoEl.setLayoutX(420);
        mTxtCorreoEl.setLayoutY(100);
        mTxtCorreoEl.setPromptText("Email");
        mTxtCorreoEl.setLabelFloat(true);

        mTxtTelefonoMovil.setPrefSize(150, 20);
        mTxtTelefonoMovil.setLayoutX(420);
        mTxtTelefonoMovil.setLayoutY(150);
        mTxtTelefonoMovil.setPromptText("Teléfono móvil");
        mTxtTelefonoMovil.setLabelFloat(true);

        mTxtTelefonoCasa.setPrefSize(150, 20);
        mTxtTelefonoCasa.setLayoutX(420);
        mTxtTelefonoCasa.setLayoutY(200);
        mTxtTelefonoCasa.setPromptText("Teléfono de casa");
        mTxtTelefonoCasa.setLabelFloat(true);

        modal.getChildren().addAll(
                mTxtNombre, mTxtApellidoPaterno, mTxtApellidoMaterno, mTxtFechaNacimiento, mTxtGenero,//primera fila
                mTxtCalle, mTxtNumeroCasa, mTxtColonia, mTxtCiudad, mTxtEstado,//Segunda fila
                mTxtCP, mTxtCorreoEl, mTxtTelefonoMovil, mTxtTelefonoCasa,//Tercera fila
                mBtnGuardar, mBtnEliminar, mBtnCancelar);//Botones
        app.getChildren().addAll(lblBackground, modal);
    }

    public void quitarVentanaModal() {
        modal.getChildren().removeAll(
                mTxtNombre, mTxtApellidoPaterno, mTxtApellidoMaterno, mTxtFechaNacimiento, mTxtGenero,//primera fila
                mTxtCalle, mTxtNumeroCasa, mTxtColonia, mTxtCiudad, mTxtEstado,//Segunda fila
                mTxtCP, mTxtCorreoEl, mTxtTelefonoMovil, mTxtTelefonoCasa,//Tercera fila
                mBtnGuardar, mBtnEliminar, mBtnCancelar);//Botones
        app.getChildren().removeAll(lblBackground, modal);
    }

    public void mostrarInsertar() {
        insertar.setVisible(true);
        menu.setVisible(false);
    }

    public void mostrarMenu() {
        menu.setVisible(true);
        if (insertar.isVisible()) {
            insertar.setVisible(false);
        } else if (listado.isVisible()) {
            listado.setVisible(false);
        }
    }

    public void mostrarListado() {
        listado.setVisible(true);
        menu.setVisible(false);
    }
}