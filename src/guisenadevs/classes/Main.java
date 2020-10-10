package guisenadevs.classes;
import java.io.File;
import java.net.URISyntaxException;

/**
 * @author Guilherme
 */

public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        criarPastas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Organizador de Arquivos");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("O organizador já está em execução.");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel2.setText("<html>Jogue os seus arquivos na pasta Arquivos e em seguida clique em organizar.</html>");

        jButton1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jButton1.setText("Organizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String caminho = getPath();
        File file = new File(caminho + "Arquivos");
        File[] arquivos = file.listFiles();
        String extensao = "";
        boolean mover;
        for (File files: arquivos){
            extensao = getFileExtension(files.toString());
            if (extensao.equals("txt") || extensao.equals("docx") || extensao.equals("doc") || extensao.equals("xlsx")){
                mover = files.renameTo(new File(getPath() + "Documentos", files.getName()));
            }else if (extensao.equals("png") || extensao.equals("jpg")|| extensao.equals("jpeg")){
                mover = files.renameTo(new File(getPath() + "Imagens", files.getName()));
            }else if (extensao.equals("mp4") || extensao.equals("flv")|| extensao.equals("wmv")){
                mover = files.renameTo(new File(getPath() + "Vídeos", files.getName()));
            }else if (extensao.equals("pptx")){
                mover = files.renameTo(new File(getPath() + "Apresentações", files.getName()));
            }else if (extensao.equals("mp3") || extensao.equals("ogg") || extensao.equals("opus")){
                mover = files.renameTo(new File(getPath() + "Músicas", files.getName()));
            }
            
        }
        
        	 
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
    static String getFileExtension(String name){
        if (name.contains(".")){
            return name.substring(name.lastIndexOf(".") + 1);
        } else{
            return "";
        }
    }
    static String getPath(){
        String retorno = "";
         try{
            String caminho = Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
            caminho = caminho.substring(1, caminho.lastIndexOf('/') + 1);
            retorno = caminho;
        } catch(URISyntaxException e){
            e.printStackTrace();
        }
        return retorno;
    }
    static void criarPastas(){
        boolean p1 = (new File(getPath() + "Arquivos").mkdir());
        boolean p2 = (new File(getPath() + "Imagens").mkdir());
        boolean p3 = (new File(getPath() + "Documentos").mkdir());
        boolean p4 = (new File(getPath() + "Vídeos").mkdir());
        boolean p5 = (new File(getPath() + "Apresentações").mkdir());
        boolean p6 = (new File(getPath() + "Músicas").mkdir());
    }
}
