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
public class RegistroAccidente {
    public int registroAccidenteId;
    public String registroAccidenteNombre;
    public String registroAccidenteFecha;
    public int profesionalId;
    public int contratoId;
    public int asesoriaId;

    public int getRegistroAccidenteId() {
        return registroAccidenteId;
    }

    public void setRegistroAccidenteId(int registroAccidenteId) {
        this.registroAccidenteId = registroAccidenteId;
    }

    public String getRegistroAccidenteNombre() {
        return registroAccidenteNombre;
    }

    public void setRegistroAccidenteNombre(String registroAccidenteNombre) {
        this.registroAccidenteNombre = registroAccidenteNombre;
    }

    public String getRegistroAccidenteFecha() {
        return registroAccidenteFecha;
    }

    public void setRegistroAccidenteFecha(String registroAccidenteFecha) {
        this.registroAccidenteFecha = registroAccidenteFecha;
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

    public int getAsesoriaId() {
        return asesoriaId;
    }

    public void setAsesoriaId(int asesoriaId) {
        this.asesoriaId = asesoriaId;
    }

   
    
    
}
