/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import models.Contrato;
import models.Rol;
import models.TipoAsesoria;
import models.UsuarioInsert;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author AlexF
 */
public class TipoAsesoriaService {
     public static final String URL = "http://localhost:63382/api/";

    
    public String getTipoAsesoria(){
        String urlAPi = URL + "tipoAsesoria/getTiposAsesoria";
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
    
     public String postTipoAseaoria(TipoAsesoria tipo) throws Exception{
        String urlAPi = URL + "tipoAsesoria/insertTipo";
        try {
            URL url = new URL(urlAPi);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            JSONObject login = new JSONObject();
            login.put("tipoAsesoriaNombre", tipo.tipoAsesoriaNombre);
            login.put("tipoAsesoriaActivo", tipo.tipoAsesoriaActivo);
            
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
     
      public String putTipoAsesoria(TipoAsesoria tipo, int id) throws Exception{
        String urlAPi = URL + "tipoAsesoria/editTipoAsesoria/"+id;
        try {
            URL url = new URL(urlAPi);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            JSONObject login = new JSONObject();
            login.put("tipoAsesoriaNombre", tipo.tipoAsesoriaNombre);
            login.put("tipoAsesoriaActivo", tipo.tipoAsesoriaActivo);

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
    
      public String deleteTipoAsesoria(int id) throws Exception{
         String urlAPi = URL + "tipoAsesoria/editTipoAsesoria/"+id;
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
      
      
      
//    public String getTipoAsesoriaByNombre(String nombre){
//        String urlAPi = URL + "tipoAsesoria/getTipoAsesoriaByName/"+nombre;
//        try {
//            URL url = new URL(urlAPi);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            
//            if(conn.getResponseCode() != 200){
//                 throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
//            }
//            
//            
//                        BufferedReader in = new BufferedReader(
//                    new InputStreamReader(conn.getInputStream()));
//            String inputLine;
//            StringBuffer response = new StringBuffer();
//
//            while ((inputLine = in.readLine()) != null) {
//                    response.append(inputLine);
//            }
//            in.close();
//            JSONObject obj = new JSONObject(response);
//
//            return response.toString();
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        
//        return null;
//    }
    
        public String getTipoAsesoriaByNombre(TipoAsesoria tipo) throws Exception{
        String urlAPi = URL + "tipoAsesoria/getTipoAsesoriaByName";
        try {
            URL url = new URL(urlAPi);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            JSONObject login = new JSONObject();
            login.put("tipoAsesoriaNombre", tipo.tipoAsesoriaNombre);
            
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
    
//    public JSONArray getTipoAsesoriaByNombre(String nombre){
//         String urlAPi = URL + "tipoAsesoria/getTipoAsesoriaByName/"+nombre;
//        try {
//            URL url = new URL(urlAPi);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            
//            if(conn.getResponseCode() != 200){
//                 throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
//            }
//
//            InputStreamReader in = new InputStreamReader(conn.getInputStream());
//            BufferedReader br = new BufferedReader(in);
//            String output;  
//            
//             JSONArray array = new JSONArray(br.readLine());
//             
//             
//             
//             return array;
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        
//        return null;
//    }

}
