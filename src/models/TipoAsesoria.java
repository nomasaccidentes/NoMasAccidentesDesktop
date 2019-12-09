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
public class TipoAsesoria {
    public int tipoAsesoriaId;
    public String tipoAsesoriaNombre;
    public int tipoAsesoriaActivo;

    public int getTipoAsesoriaId() {
        return tipoAsesoriaId;
    }

    public void setTipoAsesoriaId(int tipoAsesoriaId) {
        this.tipoAsesoriaId = tipoAsesoriaId;
    }

    public String getTipoAsesoriaNombre() {
        return tipoAsesoriaNombre;
    }

    public void setTipoAsesoriaNombre(String tipoAsesoriaNombre) {
        this.tipoAsesoriaNombre = tipoAsesoriaNombre;
    }

    public int getTipoAsesoriaActivo() {
        return tipoAsesoriaActivo;
    }

    public void setTipoAsesoriaActivo(int tipoAsesoriaActivo) {
        this.tipoAsesoriaActivo = tipoAsesoriaActivo;
    }
    
    
    
}
