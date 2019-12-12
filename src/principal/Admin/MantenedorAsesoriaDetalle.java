/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.Admin;

import api.ActividadMejoraService;
import api.AsesoriaDetalleService;
import api.AsesoriaService;
import api.TipoAsesoriaService;
import com.google.gson.JsonObject;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Button;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ScrollBar;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.tree.DefaultTreeCellEditor;
import models.ActividadMejora;
import models.Asesoria;
import models.AsesoriaDetalle;
import models.TipoAsesoria;
import models.Usuario;
import org.json.JSONArray;
import org.json.JSONObject;


/**
 *
 * @author AlexF
 */
public class MantenedorAsesoriaDetalle extends javax.swing.JFrame {

    
    int posicion = 100;
    
    int idElemento = 0;
    public JLabel label;
    String idAsesoria;
    String idContrato;
    private HashMap componentMap;
    String tipoAsesoriaDetalle;

    @Override
    public void setExtendedState(int i) {
        super.setExtendedState(i); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Creates new form MantenedorAsesoriaDetalle
     */
    public MantenedorAsesoriaDetalle() {
        initComponents();
    }

    public MantenedorAsesoriaDetalle(String id, String contratoId, String tipoAsesoria) throws Exception {
        idContrato = (contratoId);
        idAsesoria = (id);    
        tipoAsesoriaDetalle = tipoAsesoria;
        
        
        
        
       
      
        AsesoriaDetalleService ads = new AsesoriaDetalleService();
        String array = ads.getAsesoriaDetalleById(idAsesoria);   
        
        AsesoriaService as = new AsesoriaService();
        
        String asesoria = as.getAsesoriaById(Integer.parseInt(idAsesoria));
        
        JSONObject jo = new JSONObject(asesoria);
        System.out.println(jo.getJSONObject("data"));
        int asesoriaFinalizada = jo.getJSONObject("data").getInt("ASESORIA_FINALIZADA");
        TipoAsesoriaService asesoriaService = new TipoAsesoriaService();
        TipoAsesoria ta  = new TipoAsesoria();
        ta.tipoAsesoriaNombre = tipoAsesoriaDetalle;
        String tipoAsesoriaStringService = asesoriaService.getTipoAsesoriaByNombre(ta);
        JSONObject objTipoAsesoria = new JSONObject(tipoAsesoriaStringService);        
       
        int tipoAsesoriaId = objTipoAsesoria.getJSONObject("data").getInt("TIPO_ASESORIA_ID");      
        
        JSONObject obj = new JSONObject(array);        
        Usuario u = new Usuario();
        JSONArray data = obj.getJSONArray("data");   
        initComponents();
        this.numAsesoria.setText(id);
        if(data.length() != 0){
            botonAgregaDetalle.setVisible(false);
            btnCierraDetalle.setVisible(false);
            for (int i = 0; i < data.length(); i++) {
                    JSONObject row = data.getJSONObject(i);
                    System.out.println(row);
                    JTextField textField = new JTextField();
                    JCheckBox check = new JCheckBox();
                    textField.setVisible(true);
                    textField.setText(row.getString("ASESORIA_DETALLE_TITULO"));
                    textField.setBounds(10, posicion, 500, 50);
                    check.setVisible(true);
                    textField.setEditable(false);
                    if(row.getInt("ASESORIA_DETALLE_CHECK") == 1){
                        check.setSelected(true);
                    }else{
                        check.setSelected(false);
                    }
                    check.setBounds(540, posicion, 500, 50);
                    
                    panelAlmacenaDetalle.add(textField);
                    panelAlmacenaDetalle.add(check);
                    panelAlmacenaDetalle.repaint();
                    panelAlmacenaDetalle.revalidate();
                    
                    
                    idElemento +=1;
                    posicion += 50;
            }
        }else{
            this.botonAgregaDetalle.setVisible(true);
            this.btnCierraDetalle.setVisible(true);
            this.panelFinalizaAsesoria.setVisible(true);
        }
        
        
        
        if(asesoriaFinalizada == 1){
            btnAgregarActividadMejora.setVisible(false);
            btnFinalizaAseasoria.setVisible(false);
            botonAgregaDetalle.setVisible(false);
            btnCierraDetalle.setVisible(false);
            btnReportarAccidente.setVisible(false);
            String comentario = jo.getJSONObject("data").getString("ASESORIA_COMENTARIO_RESOLUCION");
            txaComentarioCierre.setText(comentario);
        }
        
         if(tipoAsesoriaId != 2){
            btnReportarAccidente.setVisible(false);
            System.out.println("No tiene accidente");
        }
         
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelAlmacenaDetalle = new javax.swing.JPanel();
        btnCierraDetalle = new javax.swing.JButton();
        botonAgregaDetalle = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        numAsesoria = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnAgregarActividadMejora = new javax.swing.JButton();
        btnReportarAccidente = new javax.swing.JButton();
        panelFinalizaAsesoria = new javax.swing.JPanel();
        btnFinalizaAseasoria = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaComentarioCierre = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelAlmacenaDetalle.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle Asesoria"));

        btnCierraDetalle.setText("Agregar Detalle");
        btnCierraDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCierraDetalleActionPerformed(evt);
            }
        });

        botonAgregaDetalle.setText("+");
        botonAgregaDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregaDetalleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAlmacenaDetalleLayout = new javax.swing.GroupLayout(panelAlmacenaDetalle);
        panelAlmacenaDetalle.setLayout(panelAlmacenaDetalleLayout);
        panelAlmacenaDetalleLayout.setHorizontalGroup(
            panelAlmacenaDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlmacenaDetalleLayout.createSequentialGroup()
                .addContainerGap(631, Short.MAX_VALUE)
                .addGroup(panelAlmacenaDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCierraDetalle, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonAgregaDetalle, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        panelAlmacenaDetalleLayout.setVerticalGroup(
            panelAlmacenaDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAlmacenaDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonAgregaDetalle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 390, Short.MAX_VALUE)
                .addComponent(btnCierraDetalle)
                .addGap(30, 30, 30))
        );

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Detalle Asesoria Id:");

        numAsesoria.setText("jLabel2");

        jButton1.setText("Cerrar ventana");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnAgregarActividadMejora.setText("Agregar Actividades de Mejora");
        btnAgregarActividadMejora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActividadMejoraActionPerformed(evt);
            }
        });

        btnReportarAccidente.setText("Reportar Accidente");
        btnReportarAccidente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportarAccidenteActionPerformed(evt);
            }
        });

        panelFinalizaAsesoria.setBorder(javax.swing.BorderFactory.createTitledBorder("Finalizar Asesoria"));

        btnFinalizaAseasoria.setText("Agregar Comentario Y Finalizar Asesoria");
        btnFinalizaAseasoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizaAseasoriaActionPerformed(evt);
            }
        });

        txaComentarioCierre.setColumns(20);
        txaComentarioCierre.setRows(5);
        jScrollPane1.setViewportView(txaComentarioCierre);

        jLabel2.setText("Comentario");

        javax.swing.GroupLayout panelFinalizaAsesoriaLayout = new javax.swing.GroupLayout(panelFinalizaAsesoria);
        panelFinalizaAsesoria.setLayout(panelFinalizaAsesoriaLayout);
        panelFinalizaAsesoriaLayout.setHorizontalGroup(
            panelFinalizaAsesoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFinalizaAsesoriaLayout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addComponent(btnFinalizaAseasoria)
                .addGap(61, 61, 61))
            .addGroup(panelFinalizaAsesoriaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFinalizaAsesoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(panelFinalizaAsesoriaLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelFinalizaAsesoriaLayout.setVerticalGroup(
            panelFinalizaAsesoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFinalizaAsesoriaLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFinalizaAseasoria)
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(377, 377, 377)
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addComponent(numAsesoria)
                        .addGap(371, 371, 371)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(panelAlmacenaDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAgregarActividadMejora)
                                    .addComponent(btnReportarAccidente, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(panelFinalizaAsesoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(numAsesoria))
                    .addComponent(jButton1))
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregarActividadMejora)
                        .addGap(74, 74, 74)
                        .addComponent(btnReportarAccidente)
                        .addGap(46, 46, 46)
                        .addComponent(panelFinalizaAsesoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelAlmacenaDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAgregaDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregaDetalleActionPerformed
        // TODO add your handling code here:
        
        
        JTextField textField = new JTextField();
        JCheckBox check = new JCheckBox();
        textField.setVisible(true);
        textField.setName("tituloCheck"+idElemento);
        textField.setBounds(10, posicion, 500, 50);
        check.setVisible(true);
        check.setName("check"+idElemento);
        check.setBounds(520, posicion, 500, 50);
         JScrollPane scroll = new JScrollPane(
                            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, 
                            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS
                    );
        panelAlmacenaDetalle.add(scroll);
        panelAlmacenaDetalle.add(textField);
        panelAlmacenaDetalle.add(check);
        panelAlmacenaDetalle.repaint();
        panelAlmacenaDetalle.revalidate();
   
        idElemento +=1;
        posicion += 50;
        
    }//GEN-LAST:event_botonAgregaDetalleActionPerformed

    private void btnCierraDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCierraDetalleActionPerformed

        
        
        AsesoriaDetalleService ads = new AsesoriaDetalleService();
        
        int totalComponentes = panelAlmacenaDetalle.getComponentCount();
        
        String titulo = "";
        int isChecked = 0;
         int finaliado = 0;
         String nombre = "";
       
         String aprobado = "";
        String textoDetallePdf = "Asesoria N° "+idAsesoria+"\n ";
        for (int i = 0; i < idElemento; i++) {
            AsesoriaDetalle as = new AsesoriaDetalle();
          
            nombre = (( JTextField) findComponentByName(panelAlmacenaDetalle, "tituloCheck"+i)).getText();
//             System.out.println(nombre);
            as.asesoriaDetalleTitulo = nombre;
            textoDetallePdf += "- " + nombre + " ";
            if((( JCheckBox) findComponentByName(panelAlmacenaDetalle, "check"+i)).isSelected()){
                isChecked = 1;
                aprobado = "Aprobado";
            }else{
                isChecked = 0;
                aprobado = "No Aprobado";
            }
            textoDetallePdf += "- " + aprobado + " \n";
            as.asesoriaDetalleCheck = isChecked;
            as.asesoriaId = Integer.parseInt(idAsesoria);
            try {
               ads.postAsesoriaDetalle(as);
               finaliado = 1;
           } catch (Exception ex) {
               Logger.getLogger(MantenedorAsesoriaDetalle.class.getName()).log(Level.SEVERE, null, ex);
           }        
        }
        
        if(finaliado == 1){
            
            MantenedorAsesoriaDetalle asesoriaDetalle;
            try {
                
             
                
              
                asesoriaDetalle = new MantenedorAsesoriaDetalle(idAsesoria, idContrato, tipoAsesoriaDetalle);
                asesoriaDetalle.setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(MantenedorAsesoriaDetalle.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.setVisible(false);
            
            
            JOptionPane.showMessageDialog(null, "Detalle Asesoria Insertado");
        }
        
    }//GEN-LAST:event_btnCierraDetalleActionPerformed

    
    
    public void generarPdfByAsesoriaId(String asesoriaId) throws FileNotFoundException, DocumentException, IOException, MessagingException{
        
        
        AsesoriaService as = new AsesoriaService();
        String asesoria = as.getAsesoriaById(Integer.parseInt(idAsesoria));
        String nombrePdf = "Asesoria-"+idContrato+"-"+idAsesoria+"";
        String textoDetallePdf = "lalalalala";
        String ruta = "/Users/AlexF/Documents/pdfprueba/"+  nombrePdf +".pdf";
        FileOutputStream archivo = new FileOutputStream(ruta);
        Document doc = new Document();
        PdfWriter.getInstance(doc, archivo);
        doc.open();
        doc.addTitle("Detalle Asesoria N°"+ idAsesoria);
        doc.addCreationDate();
        
        JSONObject obj = new JSONObject(asesoria);         
        String str = "<html><head></head><body> ";
        String tablaPincipal = " <p style='text-align:center'> Asesoria </p> <table border='1'>  <tr><td>Asesoria Detalle</td><td>Fecha</td> <td>Profesional</td></tr>";
       
        tablaPincipal += "<tr>"
                    + "<td>"+ obj.getJSONObject("data").getString("ASESORIA_DETALLE") +"</td>"
                    + "<td>"+obj.getJSONObject("data").getString("ASESORIA_FECHA")+ "<td>"
                     + "<td>"+obj.getJSONObject("data").getInt("CONTRATO_ID")+ "<td></tr>";

       
        tablaPincipal += "</table>";
        
        str += tablaPincipal;
        
        /**
         * DETALLE ASESORIA
         */
        
        AsesoriaDetalleService ads = new AsesoriaDetalleService();
        String asesoriaDetalle = ads.getAsesoriaDetalleById((idAsesoria));
        JSONObject objDetalle = new JSONObject(asesoriaDetalle);      
        JSONArray datDetallea = objDetalle.getJSONArray("data");     
          String detalleAsesria = " <br> <p style='text-align:center'> Detalle Asesoria </p> <br><br>"
                  + "<table border='1'>"
                    + "<tr>"
                        + "<td>Detalle Titulo</td>"
                        + "<td>Estado</td>"
                  + "</tr>";
         for (int i = 0; i < datDetallea.length(); i++) {
            JSONObject row = datDetallea.getJSONObject(i);
            String aprob = "";
            if(row.getInt("ASESORIA_DETALLE_CHECK") == 1){
                aprob = "Aprobado";
                
            }else{
                aprob = "No Aprobado";
            }
            detalleAsesria += "<tr>"
                    + "<td>"+ row.getString("ASESORIA_DETALLE_TITULO") +"</td>"
                    + "<td>"+aprob + i + "<td></tr>";
         }
         
        detalleAsesria += "</table>";
        str += detalleAsesria;
        HTMLWorker htmlWorker = new HTMLWorker(doc);
        htmlWorker.parse(new StringReader(str));
        doc.close();
        archivo.close();
        
        enviaCorreoConAdjunto(ruta, nombrePdf);
        
        JOptionPane.showMessageDialog(null, "Pdf correctamente creado");
    }
    
    
    
    
    
    
    
    public void enviaCorreoConAdjunto(String ruta, String nombre) throws MessagingException{
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.user", "nomasaccidentess@gmail.com");
        props.setProperty("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props, null);
        session.setDebug(true);
         // Se compone la parte del texto
        BodyPart texto = new MimeBodyPart();
        texto.setText("Se adjunta PDF de Asesoria,Saludos!!");

        // Se compone el adjunto con la imagen
        BodyPart adjunto = new MimeBodyPart();
        adjunto.setDataHandler(
            new DataHandler(new FileDataSource(ruta)));
        adjunto.setFileName(nombre+".pdf");

        // Una MultiParte para agrupar texto e imagen.
        MimeMultipart multiParte = new MimeMultipart();
        multiParte.addBodyPart(texto);
        multiParte.addBodyPart(adjunto);

        // Se compone el correo, dando to, from, subject y el
        // contenido.
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("alex.fredes.l@gmail.com"));
        message.addRecipient(
            Message.RecipientType.TO,
            new InternetAddress("alex.fredes.l@gmail.com"));
        message.setSubject("Prueba enviando un adjnto");
        message.setContent(multiParte);

        // Se envia el correo.
        Transport t = session.getTransport("smtp");
        t.connect("nomasaccidentess@gmail.com", "fwhbskbqvucomxzb");
        t.sendMessage(message, message.getAllRecipients());
        t.close();
        JOptionPane.showMessageDialog(null, "Correo enviado a cliente");
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnReportarAccidenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportarAccidenteActionPerformed
        // TODO add your handling code here:
        
        MantenedorInsertRegistroAcciente acciente = new MantenedorInsertRegistroAcciente(Integer.parseInt(idAsesoria), Integer.parseInt(idContrato));
        acciente.setVisible(true);
    }//GEN-LAST:event_btnReportarAccidenteActionPerformed

    private void btnAgregarActividadMejoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActividadMejoraActionPerformed

        MantenedorActividadesMejora actividadesMejora = new MantenedorActividadesMejora(idAsesoria);
        actividadesMejora.setVisible(true);
    }//GEN-LAST:event_btnAgregarActividadMejoraActionPerformed

    private void btnFinalizaAseasoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizaAseasoriaActionPerformed
        // TODO add your handling code here:
        
        Asesoria a  = new Asesoria();
        a.asesoriaComentarioResolucion = txaComentarioCierre.getText();
        a.asesoria_finalizada = 1;
        
        AsesoriaService as = new AsesoriaService();
        
        try {
            this.generarPdfByAsesoriaId(idAsesoria);
            as.finalizaAsesoria(a, Integer.parseInt(idAsesoria));
            JOptionPane.showMessageDialog(null, "Asesoria Finalizada");
            MantenedorAsesoriaDetalle asesoriaDetalle;
            try {
                asesoriaDetalle = new MantenedorAsesoriaDetalle(idAsesoria, idContrato, tipoAsesoriaDetalle);
                asesoriaDetalle.setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(MantenedorAsesoriaDetalle.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.setVisible(false);
        } catch (Exception ex) {
            Logger.getLogger(MantenedorAsesoriaDetalle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnFinalizaAseasoriaActionPerformed

    
    public Component findComponentByName(Container container, String componentName) {
        for (Component component: container.getComponents()) {
          if (componentName.equals(component.getName())) {
            return component;
          }
          if (component instanceof JRootPane) {
            // According to the JavaDoc for JRootPane, JRootPane is
            // "A lightweight container used behind the scenes by JFrame,
            // JDialog, JWindow, JApplet, and JInternalFrame.". The reference
            // to the RootPane is set up by implementing the RootPaneContainer
            // interface by the JFrame, JDialog, JWindow, JApplet and
            // JInternalFrame. See also the JavaDoc for RootPaneContainer.
            // When a JRootPane is found, recurse into it and continue searching.
            JRootPane nestedJRootPane = (JRootPane)component;
            return findComponentByName(nestedJRootPane.getContentPane(), componentName);
          }
          if (component instanceof JPanel) {
            // JPanel found. Recursing into this panel.
            JPanel nestedJPanel = (JPanel)component;
            return findComponentByName(nestedJPanel, componentName);
          }
        }
        return null;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MantenedorAsesoriaDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantenedorAsesoriaDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantenedorAsesoriaDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantenedorAsesoriaDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new MantenedorAsesoriaDetalle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregaDetalle;
    private javax.swing.JButton btnAgregarActividadMejora;
    private javax.swing.JButton btnCierraDetalle;
    private javax.swing.JButton btnFinalizaAseasoria;
    public static javax.swing.JButton btnReportarAccidente;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel numAsesoria;
    private javax.swing.JPanel panelAlmacenaDetalle;
    private javax.swing.JPanel panelFinalizaAsesoria;
    private javax.swing.JTextArea txaComentarioCierre;
    // End of variables declaration//GEN-END:variables
}
