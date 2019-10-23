/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import models.Contrato;
import models.Profesional;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author AlexF
 */
public class ContratoService {
     public static final String URL = "http://localhost:63382/api/";
    
    
      public String getContrato(){
        String urlAPi = URL + "contrato/GetContrato";
        try {
            URL url = new URL(urlAPi);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            if(conn.getResponseCode() != 200){
                 throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
            }
            
            
                        BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
            }
            in.close();
            JSONObject obj = new JSONObject(response);

            return response.toString();

        } catch (Exception e) {
            System.out.println(e);
        }
        
        return null;
    }
      
    public String getLastInsertContratoId(){
        String urlAPi = URL + "contrato/getLastContrato";
        try {
            URL url = new URL(urlAPi);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            if(conn.getResponseCode() != 200){
                 throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
            }
            
            
                        BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
            }
            in.close();
            JSONObject obj = new JSONObject(response);

            return response.toString();

        } catch (Exception e) {
            System.out.println(e);
        }
        
        return null;
    }
    
     public String postContrato(Contrato c) throws Exception{
        String urlAPi = URL + "contrato/InsertContrato";
        try {
            URL url = new URL(urlAPi);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            JSONObject login = new JSONObject();
            login.put("contrato_descripcion", c.contrato_descripcion);
            login.put("contrato_fecha_inicio", c.contrato_fecha_inicio);
            login.put("contrato_fecha_fin", c.contrato_fecha_fin);
            login.put("cant_capacitacion", c.cant_capacitacion);
            login.put("cant_asesoria", c.cant_asesoria);
            login.put("contrato_activo", c.contrato_activo);
            login.put("cliente_id", c.cliente_id);            
            
            conn.setDoOutput(true);
            
            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            
            
            wr.writeBytes(login.toString());            
            wr.flush();
            wr.close();

            int responseCode = conn.getResponseCode();
            
            if(responseCode == 404){
                return "404";
            }
            
            
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
            }
            in.close();
            JSONObject obj = new JSONObject(response);
            return response.toString();
        } catch (Exception e) {
             throw e;
        }
         
    }
    
    public String putProfesional(Profesional p, int id) throws Exception{
        String urlAPi = URL + "profesional/EditaProfesional/"+id;
        try {
            URL url = new URL(urlAPi);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            JSONObject login = new JSONObject();
            login.put("profesional_nombre", p.profesional_nombre);
            login.put("profesional_apellido", p.profesional_apellido);
            login.put("profesional_rut", p.profesional_rut);
            login.put("profesional_activo", p.profesional_activo);
            conn.setDoOutput(true);
            
            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            
            
            wr.writeBytes(login.toString());            
            wr.flush();
            wr.close();

            int responseCode = conn.getResponseCode();
            
            if(responseCode == 404){
                return "404";
            }
            
            
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
            }
            in.close();
            JSONObject obj = new JSONObject(response);
            return response.toString();
        } catch (Exception e) {
             throw e;
        }
         
    }
    
      public String deleteProfesional(int id) throws Exception{
        String urlAPi = URL + "profesional/DeleteProfesional/"+id;
        try {
            URL url = new URL(urlAPi);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            conn.setRequestMethod("DELETE");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            
            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
              
            wr.flush();
            wr.close();

            int responseCode = conn.getResponseCode();
            
            if(responseCode == 404){
                return "404";
            }
            
            
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
            }
            in.close();
            JSONObject obj = new JSONObject(response);
            return response.toString();
        } catch (Exception e) {
             throw e;
        }
         
    }
}
