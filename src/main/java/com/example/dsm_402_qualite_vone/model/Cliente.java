/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dsm_402_qualite_vone.model;

/**
 *
 * @author adria
 */
public class Cliente {
    
    int idCliente;
    String numeroUnico;
    int estatus;
    Persona persona;

    public Cliente(int idCliente, String numeroUnico, int estatus, Persona persona) {
        this.idCliente = idCliente;
        this.numeroUnico = numeroUnico;
        this.estatus = estatus;
        this.persona = persona;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNumeroUnico() {
        return numeroUnico;
    }

    public void setNumeroUnico(String numeroUnico) {
        this.numeroUnico = numeroUnico;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }


    public String mostrarDatos() {
        String var = "idCliente             : " + this.getIdCliente() + "\n" +
                "nombre                : " + this.getPersona().getNombre() + "\n" +
                "idPersona             : " + this.getPersona().getIdPersona() + "\n" +
                "numero unico Cliente  : " + this.getNumeroUnico();
        return var;
    }
}
