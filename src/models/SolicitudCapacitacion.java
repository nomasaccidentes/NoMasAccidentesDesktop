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
public class SolicitudCapacitacion {
    
    
    public int solicitudCapacitacionId;
    public String solicitudCapaticacionDesc;
    public int contratoId;
    public int estadoSolicitudId;
    public Date solicitudFechaCapaticacion;
    public String solicitudResolucion;
    public String solicitudResolucionFecha;

    public SolicitudCapacitacion(int solicitudCapacitacionId, String solicitudCapaticacionDesc, int contratoId, int estadoSolicitudId, Date solicitudFechaCapaticacion, String solicitudResolucion, String solicitudResolucionFecha) {
        this.solicitudCapacitacionId = solicitudCapacitacionId;
        this.solicitudCapaticacionDesc = solicitudCapaticacionDesc;
        this.contratoId = contratoId;
        this.estadoSolicitudId = estadoSolicitudId;
        this.solicitudFechaCapaticacion = solicitudFechaCapaticacion;
        this.solicitudResolucion = solicitudResolucion;
        this.solicitudResolucionFecha = solicitudResolucionFecha;
    }

    public SolicitudCapacitacion() {
    }
    
    

    public int getSolicitudCapacitacionId() {
        return solicitudCapacitacionId;
    }

    public void setSolicitudCapacitacionId(int solicitudCapacitacionId) {
        this.solicitudCapacitacionId = solicitudCapacitacionId;
    }

    public String getSolicitudCapaticacionDesc() {
        return solicitudCapaticacionDesc;
    }

    public void setSolicitudCapaticacionDesc(String solicitudCapaticacionDesc) {
        this.solicitudCapaticacionDesc = solicitudCapaticacionDesc;
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

    public Date getSolicitudFechaCapaticacion() {
        return solicitudFechaCapaticacion;
    }

    public void setSolicitudFechaCapaticacion(Date solicitudFechaCapaticacion) {
        this.solicitudFechaCapaticacion = solicitudFechaCapaticacion;
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
