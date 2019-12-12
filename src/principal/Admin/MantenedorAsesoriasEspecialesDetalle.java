/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.Admin;

import api.AsesoriaDetalleService;
import api.AsesoriaEspecialDetalleService;
import api.AsesoriaEspecialService;
import api.AsesoriaService;
import api.TipoAsesoriaEspecialService;
import api.TipoAsesoriaService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Component;
import java.awt.Container;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import models.AsesoriaEspecial;
import models.AsesoriaEspecialDetalle;
import models.TipoAsesoria;
import models.TipoAsesoriaEspecial;
import models.Usuario;
import org.json.JSONArray;
import org.json.JSONObject;
import static principal.Admin.MantenedorAsesoriaDetalle.btnReportarAccidente;

/**
 *
 * @author AlexF
 */
public class MantenedorAsesoriasEspecialesDetalle extends javax.swing.JFrame {

    
    String asesoriaEspecialID;
    String profesionalId;
    String contratoId;
    String tipoAsesoriaId;
     int posicion = 100;
    int idElemento = 0;
    public JLabel label;
     private HashMap componentMap;
    /**
     * Creates new form MantenedorAsesoriasEspecialesDetalle
     */
    public MantenedorAsesoriasEspecialesDetalle() {
        initComponents();
    }

    public MantenedorAsesoriasEspecialesDetalle(String idAsesoriaEspecial, String profesional, String contrato, String tipoAsesoria) throws Exception {
        initComponents();
        asesoriaEspecialID = idAsesoriaEspecial;
        profesionalId = profesional;
        contratoId = contrato;
        tipoAsesoriaId = tipoAsesoria;
        lblIdAsesoriaDetalle.setText(asesoriaEspecialID);
        
        System.out.println(asesoriaEspecialID);
        AsesoriaEspecialDetalleService ads = new AsesoriaEspecialDetalleService();
        String array = ads.getAsesoriaEspecialDetalleById((asesoriaEspecialID));   
        
        AsesoriaService as = new AsesoriaService();
            
        String asesoria = as.getAsesoriaById(Integer.parseInt(asesoriaEspecialID));
        
        JSONObject jo = new JSONObject(asesoria);
        int asesoriaFinalizada = jo.getJSONObject("data").getInt("ASESORIA_FINALIZADA");
        TipoAsesoriaEspecialService asesoriaService = new TipoAsesoriaEspecialService();
        TipoAsesoriaEspecial ta  = new TipoAsesoriaEspecial();
        ta.tipoAsesoriaEspecialNombre = tipoAsesoria ;
        String tipoAsesoriaStringService = asesoriaService.getTipoAsesoriaByNombre(ta);
        JSONObject objTipoAsesoria = new JSONObject(tipoAsesoriaStringService);        
       
        int tipoAsesoriaId = objTipoAsesoria.getJSONObject("data").getInt("TIPO_ASESORIA_ESPECIAL_ID");      
        
        JSONObject obj = new JSONObject(array);        
        Usuario u = new Usuario();
        JSONArray data = obj.getJSONArray("data");   
        initComponents();
        if(data.length() != 0){
            botonAgregaDetalleEspecial.setVisible(false);
            btnCierraDetalleEspecial.setVisible(false);
            for (int i = 0; i < data.length(); i++) {
                    JSONObject row = data.getJSONObject(i);
                    System.out.println(row);
                    JTextField textField = new JTextField();
                    JCheckBox check = new JCheckBox();
                    textField.setVisible(true);
                    textField.setText(row.getString("ASESORIA_ESPECIAL_DET_TITULO"));
                    textField.setBounds(10, posicion, 500, 50);
                    check.setVisible(true);
                    textField.setEditable(false);
                    if(row.getInt("ASESORIA_ESPECIAL_DET_CHECK") == 1){
                        check.setSelected(true);
                    }else{
                        check.setSelected(false);
                    }
                    check.setBounds(540, posicion, 500, 50);
                    
                    panelAlmacenaDetalleEspecial.add(textField);
                    panelAlmacenaDetalleEspecial.add(check);
                    panelAlmacenaDetalleEspecial.repaint();
                    panelAlmacenaDetalleEspecial.revalidate();
                    
                    
                    idElemento +=1;
                    posicion += 50;
            }
        }else{
            this.botonAgregaDetalleEspecial.setVisible(true);
            this.btnCierraDetalleEspecial.setVisible(true);
            this.panelFinalizaAsesoriaEsepecial.setVisible(true);
        }
        
        
        
        if(asesoriaFinalizada == 1){
//            btnAgregarActividadMejora.setVisible(false);
            btnFinalizaAseasoriaEspecial.setVisible(false);
            botonAgregaDetalleEspecial.setVisible(false);
            btnCierraDetalleEspecial.setVisible(false);
            btnReportarAccidente.setVisible(false);
            String comentario = jo.getJSONObject("data").getString("ASESORIA_COMENTARIO_RESOLUCION");
            txaComentarioCierreEspecial.setText(comentario);
        }
        
//         if(tipoAsesoriaId != 2){
//            btnReportarAccidente.setVisible(false);
//            System.out.println("No tiene accidente");
//        }
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblIdAsesoriaDetalle = new javax.swing.JLabel();
        lblIdAsesoriaDetalleDet = new javax.swing.JLabel();
        panelAlmacenaDetalleEspecial = new javax.swing.JPanel();
        btnCierraDetalleEspecial = new javax.swing.JButton();
        botonAgregaDetalleEspecial = new javax.swing.JButton();
        panelFinalizaAsesoriaEsepecial = new javax.swing.JPanel();
        btnFinalizaAseasoriaEspecial = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaComentarioCierreEspecial = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Detalle de Asesoria Especial N° :");

        lblIdAsesoriaDetalle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblIdAsesoriaDetalleDet.setText("jLabel3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(363, 363, 363)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblIdAsesoriaDetalle))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblIdAsesoriaDetalleDet)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblIdAsesoriaDetalle)
                    .addComponent(lblIdAsesoriaDetalleDet))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        panelAlmacenaDetalleEspecial.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle Asesoria"));

        btnCierraDetalleEspecial.setText("Agregar Detalle");
        btnCierraDetalleEspecial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCierraDetalleEspecialActionPerformed(evt);
            }
        });

        botonAgregaDetalleEspecial.setText("+");
        botonAgregaDetalleEspecial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregaDetalleEspecialActionPerformed(evt);
            }
        });

        panelFinalizaAsesoriaEsepecial.setBorder(javax.swing.BorderFactory.createTitledBorder("Finalizar Asesoria"));

        btnFinalizaAseasoriaEspecial.setText("Agregar Comentario Y Finalizar Asesoria");
        btnFinalizaAseasoriaEspecial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizaAseasoriaEspecialActionPerformed(evt);
            }
        });

        txaComentarioCierreEspecial.setColumns(20);
        txaComentarioCierreEspecial.setRows(5);
        jScrollPane1.setViewportView(txaComentarioCierreEspecial);

        jLabel2.setText("Comentario");

        javax.swing.GroupLayout panelFinalizaAsesoriaEsepecialLayout = new javax.swing.GroupLayout(panelFinalizaAsesoriaEsepecial);
        panelFinalizaAsesoriaEsepecial.setLayout(panelFinalizaAsesoriaEsepecialLayout);
        panelFinalizaAsesoriaEsepecialLayout.setHorizontalGroup(
            panelFinalizaAsesoriaEsepecialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFinalizaAsesoriaEsepecialLayout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(btnFinalizaAseasoriaEspecial)
                .addGap(61, 61, 61))
            .addGroup(panelFinalizaAsesoriaEsepecialLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelFinalizaAsesoriaEsepecialLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        panelFinalizaAsesoriaEsepecialLayout.setVerticalGroup(
            panelFinalizaAsesoriaEsepecialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFinalizaAsesoriaEsepecialLayout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnFinalizaAseasoriaEspecial)
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout panelAlmacenaDetalleEspecialLayout = new javax.swing.GroupLayout(panelAlmacenaDetalleEspecial);
        panelAlmacenaDetalleEspecial.setLayout(panelAlmacenaDetalleEspecialLayout);
        panelAlmacenaDetalleEspecialLayout.setHorizontalGroup(
            panelAlmacenaDetalleEspecialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlmacenaDetalleEspecialLayout.createSequentialGroup()
                .addContainerGap(637, Short.MAX_VALUE)
                .addGroup(panelAlmacenaDetalleEspecialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAlmacenaDetalleEspecialLayout.createSequentialGroup()
                        .addGroup(panelAlmacenaDetalleEspecialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCierraDetalleEspecial, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botonAgregaDetalleEspecial, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(412, 412, 412))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAlmacenaDetalleEspecialLayout.createSequentialGroup()
                        .addComponent(panelFinalizaAsesoriaEsepecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        panelAlmacenaDetalleEspecialLayout.setVerticalGroup(
            panelAlmacenaDetalleEspecialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAlmacenaDetalleEspecialLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonAgregaDetalleEspecial)
                .addGap(12, 12, 12)
                .addComponent(panelFinalizaAsesoriaEsepecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addComponent(btnCierraDetalleEspecial)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelAlmacenaDetalleEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(panelAlmacenaDetalleEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCierraDetalleEspecialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCierraDetalleEspecialActionPerformed

        AsesoriaEspecialDetalleService ads = new AsesoriaEspecialDetalleService();

        int totalComponentes = panelAlmacenaDetalleEspecial.getComponentCount();

        String titulo = "";
        int isChecked = 0;
        int finaliado = 0;
        String nombre = "";

        String aprobado = "";
        String textoDetallePdf = "Asesoria Especial N° "+asesoriaEspecialID+"\n ";
        for (int i = 0; i < idElemento; i++) {
            AsesoriaEspecialDetalle as = new AsesoriaEspecialDetalle();

            nombre = (( JTextField) findComponentByName(panelAlmacenaDetalleEspecial, "tituloCheckEspecial"+i)).getText();
            //             System.out.println(nombre);
            as.asesoriaEspecialDetalleTitulo = nombre;
            textoDetallePdf += "- " + nombre + " ";
            if((( JCheckBox) findComponentByName(panelAlmacenaDetalleEspecial, "check"+i)).isSelected()){
                isChecked = 1;
                aprobado = "Aprobado";
            }else{
                isChecked = 0;
                aprobado = "No Aprobado";
            }
            textoDetallePdf += "- " + aprobado + " \n";
            as.asesoriaEspecialDetalleCheck = isChecked;
            as.asesoriaEspecialId = Integer.parseInt(asesoriaEspecialID);
            try {
                ads.postAsesoriaEspecialDetalle(as);
                finaliado = 1;
            } catch (Exception ex) {
                Logger.getLogger(MantenedorAsesoriaDetalle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if(finaliado == 1){

            MantenedorAsesoriasEspecialesDetalle asesoriaDetalle;
            try {

                asesoriaDetalle = new MantenedorAsesoriasEspecialesDetalle(asesoriaEspecialID, profesionalId, contratoId, tipoAsesoriaId);
                asesoriaDetalle.setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(MantenedorAsesoriaDetalle.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.setVisible(false);

            JOptionPane.showMessageDialog(null, "Detalle Asesoria Insertado");
        }

    }//GEN-LAST:event_btnCierraDetalleEspecialActionPerformed

    private void botonAgregaDetalleEspecialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregaDetalleEspecialActionPerformed
        // TODO add your handling code here:

        JTextField textField = new JTextField();
        JCheckBox check = new JCheckBox();
        textField.setVisible(true);
        textField.setName("tituloCheckEspecial"+idElemento);
        textField.setBounds(10, posicion, 500, 50);
        check.setVisible(true);
        check.setName("checkEspecial"+idElemento);
        check.setBounds(520, posicion, 500, 50);
        JScrollPane scroll = new JScrollPane(
            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS
        );
        panelAlmacenaDetalleEspecial.add(scroll);
        panelAlmacenaDetalleEspecial.add(textField);
        panelAlmacenaDetalleEspecial.add(check);
        panelAlmacenaDetalleEspecial.repaint();
        panelAlmacenaDetalleEspecial.revalidate();

        idElemento +=1;
        posicion += 50;

    }//GEN-LAST:event_botonAgregaDetalleEspecialActionPerformed

    private void btnFinalizaAseasoriaEspecialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizaAseasoriaEspecialActionPerformed
        // TODO add your handling code here:

        AsesoriaEspecial a  = new AsesoriaEspecial();
        a.asesoriaComentarioResolucion = txaComentarioCierreEspecial.getText();
        a.asesoriaFinalizada = 1;

        AsesoriaEspecialService as = new AsesoriaEspecialService();

        try {
            this.generarPdfByAsesoriaId(asesoriaEspecialID);
            as.finalizaAsesoria(a, Integer.parseInt(asesoriaEspecialID));
            JOptionPane.showMessageDialog(null, "Asesoria Finalizada");
            MantenedorAsesoriasEspecialesDetalle asesoriaDetalle;
            try {
                asesoriaDetalle = new MantenedorAsesoriasEspecialesDetalle(asesoriaEspecialID, profesionalId, contratoId, tipoAsesoriaId);
                asesoriaDetalle.setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(MantenedorAsesoriaDetalle.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.setVisible(false);
        } catch (Exception ex) {
            Logger.getLogger(MantenedorAsesoriaDetalle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnFinalizaAseasoriaEspecialActionPerformed

    
    
     public void generarPdfByAsesoriaId(String asesoriaId) throws FileNotFoundException, DocumentException, IOException, MessagingException{
        
        
        AsesoriaEspecialService as = new AsesoriaEspecialService();
        String asesoria = as.getAsesoriaById(Integer.parseInt(asesoriaEspecialID));
        String nombrePdf = "Asesoria-"+contratoId+"-"+asesoriaEspecialID+"";
        String textoDetallePdf = "lalalalala";
        String ruta = "/Users/AlexF/Documents/pdfprueba/"+  nombrePdf +".pdf";
        FileOutputStream archivo = new FileOutputStream(ruta);
        Document doc = new Document();
        PdfWriter.getInstance(doc, archivo);
        doc.open();
        doc.addTitle("Detalle Asesoria N°"+ asesoriaEspecialID);
        doc.addCreationDate();
        
        JSONObject obj = new JSONObject(asesoria);         
        String str = "<html><head></head><body> ";
        String tablaPincipal = " <p style='text-align:center'> Asesoria </p> <table border='1'>  <tr><td>Asesoria Especial Detalle</td><td>Fecha</td> <td>Profesional</td></tr>";
       
        tablaPincipal += "<tr>"
                    + "<td>"+ obj.getJSONObject("data").getString("ASESORIA_ESPECIAL_NOMBRE") +"</td>"
                    + "<td>"+obj.getJSONObject("data").getString("ASESORIA_ESPECIAL_FECHA")+ "<td>"
                     + "<td>"+obj.getJSONObject("data").getInt("CONTRATO_ID")+ "<td></tr>";

       
        tablaPincipal += "</table>";
        
        str += tablaPincipal;
        
        /**
         * DETALLE ASESORIA
         */
        
        AsesoriaEspecialDetalleService ads = new AsesoriaEspecialDetalleService();
        String asesoriaDetalle = ads.getAsesoriaEspecialDetalleById((asesoriaEspecialID));
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
            if(row.getInt("ASESORIA_ESPECIAL_DET_CHECK") == 1){
                aprob = "Aprobado";
                
            }else{
                aprob = "No Aprobado";
            }
            detalleAsesria += "<tr>"
                    + "<td>"+ row.getString("ASESORIA_ESPECIAL_DET_TITULO") +"</td>"
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
            java.util.logging.Logger.getLogger(MantenedorAsesoriasEspecialesDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantenedorAsesoriasEspecialesDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantenedorAsesoriasEspecialesDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantenedorAsesoriasEspecialesDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantenedorAsesoriasEspecialesDetalle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregaDetalleEspecial;
    private javax.swing.JButton btnCierraDetalleEspecial;
    private javax.swing.JButton btnFinalizaAseasoriaEspecial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIdAsesoriaDetalle;
    private javax.swing.JLabel lblIdAsesoriaDetalleDet;
    private javax.swing.JPanel panelAlmacenaDetalleEspecial;
    private javax.swing.JPanel panelFinalizaAsesoriaEsepecial;
    private javax.swing.JTextArea txaComentarioCierreEspecial;
    // End of variables declaration//GEN-END:variables
}
