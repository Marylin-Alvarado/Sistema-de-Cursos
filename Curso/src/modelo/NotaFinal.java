/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;


/**
 *
 * @author SONY VAIO
 */
public class NotaFinal {
    private Float nota;
    private Date fechaEmision;
    private Integer parametrosCalificar;
    private Cursa cursa;

    public NotaFinal(){
        
    }
    
    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Integer getParametrosCalificar() {
        return parametrosCalificar;
    }

    public void setParametrosCalificar(Integer parametrosCalificar) {
        this.parametrosCalificar = parametrosCalificar;
    }

    public Cursa getCursa() {
        return cursa;
    }

    public void setCursa(Cursa cursa) {
        this.cursa = cursa;
    }
    
    
    
}
