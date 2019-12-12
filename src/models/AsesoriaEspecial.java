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
public class AsesoriaEspecial {
    
    public int asesoriaEspecialId;
    public String asesoriaEspecialNombre;
    public String asesoriaEspecialFecha;
    public int profesionalId;
    public int contratoId;  
    public int tipoAsesoriaEspecialId;
    public int asesoriaFinalizada;
    public String asesoriaComentarioResolucion;

    public int getAsesoriaEspecialId() {
        return asesoriaEspecialId;
    }

    public void setAsesoriaEspecialId(int asesoriaEspecialId) {
        this.asesoriaEspecialId = asesoriaEspecialId;
    }

    public String getAsesoriaEspecialNombre() {
        return asesoriaEspecialNombre;
    }

    public void setAsesoriaEspecialNombre(String asesoriaEspecialNombre) {
        this.asesoriaEspecialNombre = asesoriaEspecialNombre;
    }

    public String getAsesoriaEspecialFecha() {
        return asesoriaEspecialFecha;
    }

    public void setAsesoriaEspecialFecha(String asesoriaEspecialFecha) {
        this.asesoriaEspecialFecha = asesoriaEspecialFecha;
    }

    public int getProfesionalId() {
        return profesionalId;
    }

    public void setProfesionalId(int profesionalId) {
        this.profesionalId = profesionalId;
    }

    public int getContratoId() {
        return contratoId;
    }

    public void setContratoId(int contratoId) {
        this.contratoId = contratoId;
    }

    public int getTipoAsesoriaEspecialId() {
        return tipoAsesoriaEspecialId;
    }

    public void setTipoAsesoriaEspecialId(int tipoAsesoriaEspecialId) {
        this.tipoAsesoriaEspecialId = tipoAsesoriaEspecialId;
    }

    public int getAsesoriaFinalizada() {
        return asesoriaFinalizada;
    }

    public void setAsesoriaFinalizada(int asesoriaFinalizada) {
        this.asesoriaFinalizada = asesoriaFinalizada;
    }

    public String getAsesoriaComentarioResolucion() {
        return asesoriaComentarioResolucion;
    }

    public void setAsesoriaComentarioResolucion(String asesoriaComentarioResolucion) {
        this.asesoriaComentarioResolucion = asesoriaComentarioResolucion;
    }
    
    
             
}
