/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author AlexF
 */
public class Asesoria {
    public int asesoriaId;
    public String asesoriaDetalle;
    public String asesoriaFecha;
    public int contratoId;
    public int profesionalId;
    public int tipoAsesoriaId;
    
    public String asesoriaComentarioResolucion;
    public int asesoria_finalizada;
    
    public int getAsesoriaId() {
        return asesoriaId;
    }

    public void setAsesoriaId(int asesoriaId) {
        this.asesoriaId = asesoriaId;
    }

    public String getAsesoriaDetalle() {
        return asesoriaDetalle;
    }

    public void setAsesoriaDetalle(String asesoriaDetalle) {
        this.asesoriaDetalle = asesoriaDetalle;
    }

    public String getAsesoriaFecha() {
        return asesoriaFecha;
    }

    public void setAsesoriaFecha(String asesoriaFecha) {
        this.asesoriaFecha = asesoriaFecha;
    }

    public int getContratoId() {
        return contratoId;
    }

    public void setContratoId(int contratoId) {
        this.contratoId = contratoId;
    }

    public int getProfesionalId() {
        return profesionalId;
    }

    public void setProfesionalId(int profesionalId) {
        this.profesionalId = profesionalId;
    }

    public int getTipoAsesoriaId() {
        return tipoAsesoriaId;
    }

    public void setTipoAsesoriaId(int tipoAsesoriaId) {
        this.tipoAsesoriaId = tipoAsesoriaId;
    }

    public String getAsesoriaComentarioResolucion() {
        return asesoriaComentarioResolucion;
    }

    public void setAsesoriaComentarioResolucion(String asesoriaComentarioResolucion) {
        this.asesoriaComentarioResolucion = asesoriaComentarioResolucion;
    }

    public int getAsesoria_finalizada() {
        return asesoria_finalizada;
    }

    public void setAsesoria_finalizada(int asesoria_finalizada) {
        this.asesoria_finalizada = asesoria_finalizada;
    }
    
    
}
