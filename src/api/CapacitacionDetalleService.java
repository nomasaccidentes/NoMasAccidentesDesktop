/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author AlexF
 */
public class CapacitacionDetalleService {
    public static final String URL = "http://localhost:63382/api/";
    
    public JSONArray getCapacitacionDetalleById(int id){
        String urlAPi = URL + "capacitacionDetalle/getCapacitacionDetalleById/"+id;
       try {
            URL url = new URL(urlAPi);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            if(conn.getResponseCode() != 200){
                 throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
            }

            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;  
            
             JSONArray array = new JSONArray(br.readLine());
             
             
             return array;
        } catch (Exception e) {
            System.out.println(e);
        }
       return null;
    }
}
