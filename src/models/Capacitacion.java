/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author AlexF
 */
public class Capacitacion {
    
    public String capacitacionDetalle;
    public String capacitacionFecha;
    public int contrato_id;
    public int profesionalId;

    public Capacitacion(String capacitacionDetalle, String capacitacionFecha, int contrato_id, int profesionalId) {
        this.capacitacionDetalle = capacitacionDetalle;
        this.capacitacionFecha = capacitacionFecha;
        this.contrato_id = contrato_id;
        this.profesionalId = profesionalId;
    }

    public Capacitacion() {
    }

    public String getCapacitacionDetalle() {
        return capacitacionDetalle;
    }

    public void setCapacitacionDetalle(String capacitacionDetalle) {
        this.capacitacionDetalle = capacitacionDetalle;
    }

    public String getCapacitacionFecha() {
        return capacitacionFecha;
    }

    public void setCapacitacionFecha(String capacitacionFecha) {
        this.capacitacionFecha = capacitacionFecha;
    }

    public int getContrato_id() {
        return contrato_id;
    }

    public void setContrato_id(int contrato_id) {
        this.contrato_id = contrato_id;
    }

    public int getProfesionalId() {
        return profesionalId;
    }

    public void setProfesionalId(int profesionalId) {
        this.profesionalId = profesionalId;
    }

    @Override
    public String toString() {
        return "Capacitacion{" + "capacitacionDetalle=" + capacitacionDetalle + ", capacitacionFecha=" + capacitacionFecha + ", contrato_id=" + contrato_id + ", profesionalId=" + profesionalId + '}';
    }

   
    
    
}
