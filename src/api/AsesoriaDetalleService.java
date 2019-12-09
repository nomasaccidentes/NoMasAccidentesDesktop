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
import models.Asesoria;
import models.AsesoriaDetalle;
import org.json.JSONObject;

/**
 *
 * @author AlexF
 */
public class AsesoriaDetalleService {
     public static final String URL = "http://localhost:63382/api/";
    
      public String getAsesoriaDetalle(){
          String urlAPi = URL + "asesoria/getAsesorias";
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
    
     public String postAsesoriaDetalle(AsesoriaDetalle a) throws Exception{
        String urlAPi = URL + "asesoriaDetalle/insertAsesoriaDetalle";
        try {
             URL url = new URL(urlAPi);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            JSONObject login = new JSONObject();
            login.put("asesoriaDetalleTitulo", a.asesoriaDetalleTitulo);
            login.put("asesoriaDetalleCheck", a.asesoriaDetalleCheck);
            login.put("asesoriaId", a.asesoriaId);
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
     
       public String getAsesoriaDetalleById(String id){
          String urlAPi = URL + "asesoriaDetalle/getAsesoriaDetallebyId/"+id;
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
}
