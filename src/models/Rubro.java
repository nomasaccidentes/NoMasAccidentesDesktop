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
public class Rubro {
    public int rubro_id;
    public String rubro_nombre;
    public int rubro_activo;

    public Rubro(int rubro_id, String rubro_nombre, int rubro_activo) {
        this.rubro_id = rubro_id;
        this.rubro_nombre = rubro_nombre;
        this.rubro_activo = rubro_activo;
    }

    public Rubro() {
    }

    
    
    public int getRubro_id() {
        return rubro_id;
    }

    public void setRubro_id(int rubro_id) {
        this.rubro_id = rubro_id;
    }

    public String getRubro_nombre() {
        return rubro_nombre;
    }

    public void setRubro_nombre(String rubro_nombre) {
        this.rubro_nombre = rubro_nombre;
    }

    public int getRubro_activo() {
        return rubro_activo;
    }

    public void setRubro_activo(int rubro_activo) {
        this.rubro_activo = rubro_activo;
    }

    @Override
    public String toString() {
        return rubro_nombre ;
    }

    
    
}
