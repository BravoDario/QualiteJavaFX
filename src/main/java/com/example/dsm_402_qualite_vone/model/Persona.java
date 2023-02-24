package com.example.dsm_402_qualite_vone.model;

/**
 *
 * @author LiveGrios
 */
public class Persona
{
    int idPersona;
    String nombre;
    String apellidoPaterno;
    String apellidoMaterno;
    String genero;
    String fechaNacimiento;
    String calle;
    String numero;
    String colonia;
    String cp;
    String ciudad;
    String estado;
    String telCasa;
    String telMovil;
    String email;

    public Persona(int idPersona, String nombre, String apellidoPaterno, String apellidoMaterno, String genero, String fechaNacimiento, String calle, String numero, String colonia, String cp, String ciudad, String estado, String telCasa, String telMovil, String email) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.cp = cp;
        this.ciudad = ciudad;
        this.estado = estado;
        this.telCasa = telCasa;
        this.telMovil = telMovil;
        this.email = email;
    }

    public int getIdPersona()
    {
        return idPersona;
    }

    public void setIdPersona(int idPersona)
    {
        this.idPersona = idPersona;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getApellidoPaterno()
    {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno)
    {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno()
    {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno)
    {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getGenero()
    {
        return genero;
    }

    public void setGenero(String genero)
    {
        this.genero = genero;
    }

    public String getFechaNacimiento()
    {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento)
    {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCalle()
    {
        return calle;
    }

    public void setCalle(String calle)
    {
        this.calle = calle;
    }

    public String getNumero()
    {
        return numero;
    }

    public void setNumero(String numero)
    {
        this.numero = numero;
    }

    public String getColonia()
    {
        return colonia;
    }

    public void setColonia(String colonia)
    {
        this.colonia = colonia;
    }

    public String getCp()
    {
        return cp;
    }

    public void setCp(String cp)
    {
        this.cp = cp;
    }

    public String getCiudad()
    {
        return ciudad;
    }

    public void setCiudad(String ciudad)
    {
        this.ciudad = ciudad;
    }

    public String getEstado()
    {
        return estado;
    }

    public void setEstado(String estado)
    {
        this.estado = estado;
    }

    public String getTelCasa()
    {
        return telCasa;
    }

    public void setTelCasa(String telCasa)
    {
        this.telCasa = telCasa;
    }

    public String getTelMovil()
    {
        return telMovil;
    }

    public void setTelMovil(String telMovil)
    {
        this.telMovil = telMovil;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }



    public String mostrarDatos() {
        String var =    "idPersona        : " + this.getIdPersona() + "\n" +
                "Apellido Paterno : " + this.getNombre() + "\n" +
                "Apellido MAterno : " + this.getApellidoPaterno() + "\n" +
                "Genero           : " + this.getApellidoMaterno() + "\n" +
                "CP               : " + this.getCp() + "\n" +
                "Correo           : " + this.getEmail();
        return var;
    }
}
