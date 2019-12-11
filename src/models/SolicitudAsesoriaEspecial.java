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
public class SolicitudAsesoriaEspecial {
    public String solicitudAsesoriaDescripcion;
    public int cotrato_id;
    public int estadoSolicitudId;
    public String solicitudFechaAsesoria;
    public String solicitudResolucion;
    public String solicitudResolucionFecha;
    public int solicitudAsesoriaTipoEspecial;

    public String getSolicitudAsesoriaDescripcion() {
        return solicitudAsesoriaDescripcion;
    }

    public void setSolicitudAsesoriaDescripcion(String solicitudAsesoriaDescripcion) {
        this.solicitudAsesoriaDescripcion = solicitudAsesoriaDescripcion;
    }

    public int getCotrato_id() {
        return cotrato_id;
    }

    public void setCotrato_id(int cotrato_id) {
        this.cotrato_id = cotrato_id;
    }

    public int getEstadoSolicitudId() {
        return estadoSolicitudId;
    }

    public void setEstadoSolicitudId(int estadoSolicitudId) {
        this.estadoSolicitudId = estadoSolicitudId;
    }

    public String getSolicitudFechaAsesoria() {
        return solicitudFechaAsesoria;
    }

    public void setSolicitudFechaAsesoria(String solicitudFechaAsesoria) {
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

    public int getSolicitudAsesoriaTipoEspecial() {
        return solicitudAsesoriaTipoEspecial;
    }

    public void setSolicitudAsesoriaTipoEspecial(int solicitudAsesoriaTipoEspecial) {
        this.solicitudAsesoriaTipoEspecial = solicitudAsesoriaTipoEspecial;
    }
    
    
    
}
