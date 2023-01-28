/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


/**
 *
 * @author Victor
 */
public class Administrador extends Persona{
    
    private Integer idAdministrador;
    private String Cargo;
    private Persona persona;
    
    public Administrador(Integer idAdministrador,String Cargo,Persona persona){
        this.idAdministrador = idAdministrador;
        this.Cargo = Cargo;
        this.persona = persona;
    }

    public Integer getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(Integer idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "idAdministrador=" + idAdministrador + ", Cargo=" + Cargo + ", persona=" + persona;
    }
    
    
    
}
