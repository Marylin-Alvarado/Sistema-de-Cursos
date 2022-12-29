package controlador;

import modelo.Asignatura;

/**
 * fecha: 26/12/2022
 * @author: CEAS 
 */
public class ControladorAsignatura {
   private Asignatura asignatura;

    public Asignatura getAsignatura() {
        if (asignatura==null) {
            asignatura=new Asignatura();
        }
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }
    
    public Boolean guardar() {
        return true;

    }

    public Boolean borrar() {
        return true;

    }

    public Boolean actualizar() {
        return true;

    }
}
