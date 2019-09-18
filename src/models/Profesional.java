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
public  class Profesional {
    public int profesional_id;
    public String profesional_nombre;
    public String profesional_apellido;
    public String profesional_rut;
    public int profesional_activo;
    public Date profesional_ts_creacion;

    public int getProfesional_id() {
        return profesional_id;
    }

    public void setProfesional_id(int profesional_id) {
        this.profesional_id = profesional_id;
    }

    public String getProfesional_nombre() {
        return profesional_nombre;
    }

    public void setProfesional_nombre(String profesional_nombre) {
        this.profesional_nombre = profesional_nombre;
    }

    public String getProfesional_apellido() {
        return profesional_apellido;
    }

    public void setProfesional_apellido(String profesional_apellido) {
        this.profesional_apellido = profesional_apellido;
    }

    public String getProfesional_rut() {
        return profesional_rut;
    }

    public void setProfesional_rut(String profesional_rut) {
        this.profesional_rut = profesional_rut;
    }

    public int getProfesional_activo() {
        return profesional_activo;
    }

    public void setProfesional_activo(int profesional_activo) {
        this.profesional_activo = profesional_activo;
    }

    public Date getProfesional_ts_creacion() {
        return profesional_ts_creacion;
    }

    public void setProfesional_ts_creacion(Date profesional_ts_creacion) {
        this.profesional_ts_creacion = profesional_ts_creacion;
    }

   
    
    
}
