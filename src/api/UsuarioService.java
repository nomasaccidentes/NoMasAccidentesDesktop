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
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import models.Rubro;
import models.Usuario;
import models.UsuarioInsert;
import org.json.*;

/**
 *
 * @author AlexF
 */
public class UsuarioService {

    public static final String URL = "http://localhost:63382/api/";
    
    
    public String getUserLogin(String username, String clave) throws IOException{
        
        String urlApiLogin = URL + "usuario/GetUserLogin";
        
       
        try {
            URL url = new URL(urlApiLogin);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            JSONObject login = new JSONObject();
            login.put("username", username);
            login.put("clave", clave);
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
            
            
            System.out.println(response);
            JSONObject obj = new JSONObject(response);
            return response.toString();
        } catch (Exception e) {
            throw e;
        }
    
            
    }
    
      public JSONArray getUsuarios(){
        String urlAPi = URL + "usuario/GetUsuarios";
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
      
      
      public String postUsuario(UsuarioInsert usuario) throws Exception{
        String urlAPi = URL + "usuario/InsertUsuario";
        try {
            URL url = new URL(urlAPi);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            JSONObject login = new JSONObject();
            login.put("usuario_username", usuario.usuario_username);
            login.put("usuario_clave", usuario.usuario_clave);
            login.put("usuario_activo", usuario.usuario_activo);
            login.put("cliente_id", usuario.cliente_id);
            login.put("profesional_id", usuario.profesional_id);                
            login.put("rol_id", usuario.rol_id);

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
      
      
      public String putUsuario(UsuarioInsert u, int id) throws Exception{
        String urlAPi = URL + "usuario/EditaUsuario/"+id;
        try {
            URL url = new URL(urlAPi);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            JSONObject login = new JSONObject();
            login.put("usuario_activo", u.usuario_activo);

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
}
