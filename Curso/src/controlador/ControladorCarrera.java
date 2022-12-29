package controlador;

import modelo.Carrera;

/**
 * fecha: 26/12/2022
 *
 * @author: CEAS
 */
public class ControladorCarrera {

    private Carrera carrera;
    private final Float APROBADO = 7.00F;

    public Carrera getCarrera() {
        if (carrera == null) {
            carrera = new Carrera();
        }
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
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

    public Boolean aprobacionCiclo(Float nota) {
        if (nota >= APROBADO) {
            return true;
        }
        return false;
    }

}
