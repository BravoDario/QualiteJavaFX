package com.example.dsm_402_qualite_vone;

import com.example.dsm_402_qualite_vone.model.Cliente;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.scene.control.Alert;

public class ControllerCliente {
    public void guardarCliente(Cliente cliente) throws UnirestException {
        String clienteJson = new Gson().toJson(cliente);

        HttpResponse<JsonNode> res = Unirest.post("http://localhost:8080/Optica_Web/servicio/cliente/save")
                .header("Content-type", "application/x-www-form-urlencoded;charset=UTF-8")
                .field("datosCliente", clienteJson)
                .asJson();

        if(cliente.getIdCliente()==0){
            System.out.println("Agregado");
        } else{
            System.out.println("Actualizado");
        }
    }

    public void eliminar(int idCliente) throws UnirestException {
        String url = "http://localhost:8080/Optica_Web/servicio/cliente/deleteCliente?idCliente=" + idCliente;

        HttpResponse<JsonNode> apiResponse = Unirest.get(url).asJson();
        Respuesta respuesta = new Gson().fromJson(apiResponse.getBody().toString(), Respuesta.class);

        System.out.println(respuesta);
    }

    public Cliente[] fillTable() throws UnirestException {
        HttpResponse<JsonNode> apiResponse = null;
        String url = "http://localhost:8080/Optica_Web/servicio/cliente/getAll";
        apiResponse = Unirest.get(url).asJson();
            Cliente[] clientes = new Gson().fromJson(apiResponse.getBody().toString(), Cliente[].class);
        return clientes;
    }
}