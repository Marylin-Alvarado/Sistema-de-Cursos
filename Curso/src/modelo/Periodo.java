/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import modelo.enums.DescripcionPeriodo;
import modelo.enums.Meses;

/**
 *
 * @author SONY VAIO
 */
public class Periodo {
    private Integer id;
    private Meses mesInicio;
    private Meses mesFin;
    private DescripcionPeriodo especificacion;

    public Periodo(){
        
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Meses getMesInicio() {
        return mesInicio;
    }

    public void setMesInicio(Meses mesInicio) {
        this.mesInicio = mesInicio;
    }

    public Meses getMesFin() {
        return mesFin;
    }

    public void setMesFin(Meses mesFin) {
        this.mesFin = mesFin;
    }

    public DescripcionPeriodo getEspecificacion() {
        return especificacion;
    }

    public void setEspecificacion(DescripcionPeriodo especificacion) {
        this.especificacion = especificacion;
    }


    
}
