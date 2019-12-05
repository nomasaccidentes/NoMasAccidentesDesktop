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
public class AsesoriaDetalle {
    public int asesoriaDetalleId;
    public String asesoriaDetalleTitulo;
    public int asesoriaDetalleCheck;
    public int asesoriaId;

    public int getAsesoriaDetalleId() {
        return asesoriaDetalleId;
    }

    public void setAsesoriaDetalleId(int asesoriaDetalleId) {
        this.asesoriaDetalleId = asesoriaDetalleId;
    }

    public String getAsesoriaDetalleTitulo() {
        return asesoriaDetalleTitulo;
    }

    public void setAsesoriaDetalleTitulo(String asesoriaDetalleTitulo) {
        this.asesoriaDetalleTitulo = asesoriaDetalleTitulo;
    }

    public int getAsesoriaDetalleCheck() {
        return asesoriaDetalleCheck;
    }

    public void setAsesoriaDetalleCheck(int asesoriaDetalleCheck) {
        this.asesoriaDetalleCheck = asesoriaDetalleCheck;
    }

    public int getAsesoriaId() {
        return asesoriaId;
    }

    public void setAsesoriaId(int asesoriaId) {
        this.asesoriaId = asesoriaId;
    }

    @Override
    public String toString() {
        return "AsesoriaDetalle{" + "asesoriaDetalleId=" + asesoriaDetalleId + ", asesoriaDetalleTitulo=" + asesoriaDetalleTitulo + ", asesoriaDetalleCheck=" + asesoriaDetalleCheck + ", asesoriaId=" + asesoriaId + '}';
    }


    
    
    
    
}
