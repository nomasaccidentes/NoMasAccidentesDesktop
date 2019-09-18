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
public class ProfesionalCombobox {
    public int profesional_id;
    
    public String profesional_nombre;
    public String profesional_apellido;

    public ProfesionalCombobox(int profesional_id, String profesional_nombre, String profesional_apellido) {
        this.profesional_id = profesional_id;
        this.profesional_nombre = profesional_nombre;
        this.profesional_apellido = profesional_apellido;
    }


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

   

    @Override
    public String toString() {
        return profesional_nombre + " " + profesional_apellido;
    }
    
    
    
}
