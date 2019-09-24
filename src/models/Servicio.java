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
public class Servicio {
    public int servicio_id;
    
    public String servicio_nombre;
    
    public int servicio_activo;

    public int getServicio_id() {
        return servicio_id;
    }

    public void setServicio_id(int servicio_id) {
        this.servicio_id = servicio_id;
    }

    public String getServicio_nombre() {
        return servicio_nombre;
    }

    public void setServicio_nombre(String servicio_nombre) {
        this.servicio_nombre = servicio_nombre;
    }

    public int getServicio_activo() {
        return servicio_activo;
    }

    public void setServicio_activo(int servicio_activo) {
        this.servicio_activo = servicio_activo;
    }
    
    
}
