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
public class SolicitudAsesoria {
    public int solicitudAsesoriaId;
    public String solicitudAsesoriaDescripcion;
    public int contratoId;
    public int estadoSolicitudId;
    public Date solicitudFechaAsesoria;
    public String solicitudResolucion;
    public String solicitudResolucionFecha;

    public SolicitudAsesoria() {
    }

    public int getSolicitudAsesoriaId() {
        return solicitudAsesoriaId;
    }

    public void setSolicitudAsesoriaId(int solicitudAsesoriaId) {
        this.solicitudAsesoriaId = solicitudAsesoriaId;
    }

    public String getSolicitudAsesoriaDescripcion() {
        return solicitudAsesoriaDescripcion;
    }

    public void setSolicitudAsesoriaDescripcion(String solicitudAsesoriaDescripcion) {
        this.solicitudAsesoriaDescripcion = solicitudAsesoriaDescripcion;
    }

    public int getContratoId() {
        return contratoId;
    }

    public void setContratoId(int contratoId) {
        this.contratoId = contratoId;
    }

    public int getEstadoSolicitudId() {
        return estadoSolicitudId;
    }

    public void setEstadoSolicitudId(int estadoSolicitudId) {
        this.estadoSolicitudId = estadoSolicitudId;
    }

    public Date getSolicitudFechaAsesoria() {
        return solicitudFechaAsesoria;
    }

    public void setSolicitudFechaAsesoria(Date solicitudFechaAsesoria) {
        this.solicitudFechaAsesoria = solicitudFechaAsesoria;
    }

    public String getSolicitudResolucion() {
        return solicitudResolucion;
    }

    public void setSolicitudResolucion(String solicitudResolucion) {
        this.solicitudResolucion = solicitudResolucion;
    }

    public String getSolicitudResolucionFecha() {
        return solicitudResolucionFecha;
    }

    public void setSolicitudResolucionFecha(String solicitudResolucionFecha) {
        this.solicitudResolucionFecha = solicitudResolucionFecha;
    }
    
    
    
}
