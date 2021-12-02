package Interface;

import Notas.Notas;
//
import Interface.JanelaSobre;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Toolkit;

/**
 * Criar a janela principal do Smart Notes.

 */
public class JanelaPrincipal extends javax.swing.JFrame {

    /**
     * Bloquer ou desbloquer as opções 'Salvar' e 'Salvar como' 
     * do menu 'Arquivo'
     * 
     */
    private void bloquerBotaoSalvar(boolean bloquear) {
        menuSalvar.setEnabled(!bloquear);
        menuSalvarComo.setEnabled(!bloquear);
    }
    
   
    public JanelaPrincipal() {
        initComponents();
        
        /* Centralizar a janela */
        setLocationRelativeTo(null);
        
       
        /* Definindo com 4 caracteres o espaço do <TAB> */
        txtTexto.setTabSize(4);
        
        /* Inicializando as variáveis */
        alteracoesNoDocumento = 0;
        nomeDoArquivo = "Sem título";
        caminhoDoArquivo = "";
        tituloDaJanela = nomeDoArquivo + " - Smart Notes";
        
        /* Colocando o título da janela */
        setTitle(tituloDaJanela);
        
        /* Bloqueando 'Salvar' e 'Salvar Como' */
        bloquerBotaoSalvar(true);
        
        /* Verificando as alterações no documento, sendo que quando acontecerem
           a variável interna alteracoesNoDocumento será alterada, além dos 
           botões 'Salvar' e 'Salvar Como' serem habilitados 
        */
        txtTexto.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void removeUpdate(DocumentEvent e) {
            alteracoesNoDocumento = 1;
                bloquerBotaoSalvar(false);
                
                tituloDaJanela = nomeDoArquivo + "* - Smart Notes";
                
                /* Colocando o título da janela */
                setTitle(tituloDaJanela);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                alteracoesNoDocumento = 1;
                bloquerBotaoSalvar(false);
                
                tituloDaJanela = nomeDoArquivo + "* - Smart Notes";
                
                /* Colocando o título da janela */
                setTitle(tituloDaJanela);
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtTexto = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        menuNovo = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuAbrir = new javax.swing.JMenuItem();
        menuSalvar = new javax.swing.JMenuItem();
        menuSalvarComo = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuSair = new javax.swing.JMenuItem();
        menuAjuda = new javax.swing.JMenu();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        menuSobre = new javax.swing.JMenuItem();
        AjudaDesenvolvedores = new javax.swing.JMenuItem();
        AjudaUtilizacao = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:/Users/fhigo/Downloads/icone2.png")
        );
        setMinimumSize(new java.awt.Dimension(300, 200));

        txtTexto.setBackground(new java.awt.Color(204, 255, 204));
        txtTexto.setColumns(20);
        txtTexto.setRows(5);
        txtTexto.setAutoscrolls(false);
        jScrollPane1.setViewportView(txtTexto);

        menuArquivo.setText("Arquivo");

        menuNovo.setText("Novo");
        menuNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNovoActionPerformed(evt);
            }
        });
        menuArquivo.add(menuNovo);
        menuArquivo.add(jSeparator2);

        menuAbrir.setText("Abrir");
        menuAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAbrirActionPerformed(evt);
            }
        });
        menuArquivo.add(menuAbrir);

        menuSalvar.setText("Salvar");
        menuSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalvarActionPerformed(evt);
            }
        });
        menuArquivo.add(menuSalvar);

        menuSalvarComo.setText("Salvar como...");
        menuSalvarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalvarComoActionPerformed(evt);
            }
        });
        menuArquivo.add(menuSalvarComo);
        menuArquivo.add(jSeparator1);

        menuSair.setText("Sair");
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        menuArquivo.add(menuSair);

        jMenuBar1.add(menuArquivo);

        menuAjuda.setText("Ajuda");
        menuAjuda.add(jSeparator3);

        menuSobre.setText("Sobre");
        menuSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSobreActionPerformed(evt);
            }
        });
        menuAjuda.add(menuSobre);

        AjudaDesenvolvedores.setText("Ajuda Desenvolvedores");
        AjudaDesenvolvedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjudaDesenvolvedoresActionPerformed(evt);
            }
        });
        menuAjuda.add(AjudaDesenvolvedores);

        AjudaUtilizacao.setText("Ajuda Utilização");
        AjudaUtilizacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjudaUtilizacaoActionPerformed(evt);
            }
        });
        menuAjuda.add(AjudaUtilizacao);

        jMenuBar1.add(menuAjuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void menuNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNovoActionPerformed
        if (alteracoesNoDocumento == 1) {
            int resposta=0;
  
            if (resposta == 0) {
                bloquerBotaoSalvar(true);

                txtTexto.setText("");
                alteracoesNoDocumento=0;
                nomeDoArquivo = "Sem título";
                caminhoDoArquivo = "";
                tituloDaJanela = nomeDoArquivo + " - Smart Notes";

                /* Colocando o título da janela */
                setTitle(tituloDaJanela);
            }            
        } else
            bloquerBotaoSalvar(true);

            txtTexto.setText("");
            alteracoesNoDocumento=0;
            nomeDoArquivo = "Sem título";
            caminhoDoArquivo = "";
            tituloDaJanela = nomeDoArquivo + " - Smart Notes";

            /* Colocando o título da janela */
            setTitle(tituloDaJanela);
    }//GEN-LAST:event_menuNovoActionPerformed
    
    
    private void menuSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSobreActionPerformed
        JanelaSobre sobre = new JanelaSobre(null, true);
        sobre.setVisible(true);
        
        txtTexto.requestFocus();
    }//GEN-LAST:event_menuSobreActionPerformed

    
    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_menuSairActionPerformed

    private void menuSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalvarActionPerformed
        Notas arquivo = new Notas();

        /* Salvando o arquivo */
        if (nomeDoArquivo.equals("Sem título"))
            menuSalvarComoActionPerformed(evt);
        else
            if (!arquivo.salvar(caminhoDoArquivo, txtTexto.getText()))
                JOptionPane.showMessageDialog(null,arquivo.getErro(),
                            "Erro!", JOptionPane.ERROR_MESSAGE); 
            else {
                tituloDaJanela = nomeDoArquivo + " - Smart Notes";
                alteracoesNoDocumento = 0;
                menuSalvar.setEnabled(false);

                /* Colocando o título da janela */
                setTitle(tituloDaJanela);
            }
    }//GEN-LAST:event_menuSalvarActionPerformed

    
    private void menuSalvarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalvarComoActionPerformed
        Notas arquivo = new Notas();
        
        /* Salvando o arquivo */
        if (!arquivo.salvarComo(txtTexto.getText()))
            if(arquivo.getErro().length()>0)
                JOptionPane.showMessageDialog(null,arquivo.getErro(),
                        "Erro!", JOptionPane.ERROR_MESSAGE);
        
        nomeDoArquivo = arquivo.getNomeDoArquivo();
        caminhoDoArquivo = arquivo.getCaminhoDoArquivo();
        tituloDaJanela = nomeDoArquivo + " - Smart Notes";
        alteracoesNoDocumento = 0;
        menuSalvar.setEnabled(false);

        /* Título da janela */
        setTitle(tituloDaJanela);
    }//GEN-LAST:event_menuSalvarComoActionPerformed
    
    //Ao pressionar o botão abrir o aqruivo sera aberto
    private void menuAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAbrirActionPerformed
         if (alteracoesNoDocumento == 1) {
           int resposta = 0;
            
            
            if (resposta == 0) {
                Notas arquivo = new Notas();

                /* Abrindo o arquivo */
                if (!arquivo.abrir())
                    if(arquivo.getErro().length()>0)
                        JOptionPane.showMessageDialog(null,arquivo.getErro(),
                                "Erro!", JOptionPane.ERROR_MESSAGE);

                txtTexto.setText(arquivo.getConteudo());
                txtTexto.setCaretPosition(0);

                nomeDoArquivo = arquivo.getNomeDoArquivo();
                caminhoDoArquivo = arquivo.getCaminhoDoArquivo();
                tituloDaJanela = nomeDoArquivo + " - Smart Notes";
                alteracoesNoDocumento = 0;
                menuSalvar.setEnabled(false);

                /* Colocando o título da janela */
                setTitle(tituloDaJanela);
            }            
        } else {
            Notas arquivo = new Notas();

            /* Abrindo o arquivo */
            if (!arquivo.abrir())
                if(arquivo.getErro().length()>0)
                    JOptionPane.showMessageDialog(null,arquivo.getErro(),
                            "Erro!", JOptionPane.ERROR_MESSAGE);

            txtTexto.setText(arquivo.getConteudo());
            txtTexto.setCaretPosition(0);

            nomeDoArquivo = arquivo.getNomeDoArquivo();
            caminhoDoArquivo = arquivo.getCaminhoDoArquivo();
            tituloDaJanela = nomeDoArquivo + " - Smart Notes";
            alteracoesNoDocumento = 0;
            menuSalvar.setEnabled(false);

            /* Colocando o título da janela */
            setTitle(tituloDaJanela);
        }
    }//GEN-LAST:event_menuAbrirActionPerformed

    private void AjudaDesenvolvedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjudaDesenvolvedoresActionPerformed
        AjudaDesenvolvedores desenvolvedor = new AjudaDesenvolvedores(null, true);
        desenvolvedor.setVisible(true);
        
        txtTexto.requestFocus();
    }//GEN-LAST:event_AjudaDesenvolvedoresActionPerformed

    private void AjudaUtilizacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjudaUtilizacaoActionPerformed
        AjudaUtilizacao utilizacao = new AjudaUtilizacao(null, true);
        utilizacao.setVisible(true);
        
        txtTexto.requestFocus();
    }//GEN-LAST:event_AjudaUtilizacaoActionPerformed

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
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaPrincipal().setVisible(true);
            }
        });
    }
    /* Variáveis do Smart Notes */
    private int alteracoesNoDocumento;
    private String nomeDoArquivo;
    private String caminhoDoArquivo;
    private String tituloDaJanela;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AjudaDesenvolvedores;
    private javax.swing.JMenuItem AjudaUtilizacao;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JMenuItem menuAbrir;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenuItem menuNovo;
    private javax.swing.JMenuItem menuSair;
    private javax.swing.JMenuItem menuSalvar;
    private javax.swing.JMenuItem menuSalvarComo;
    private javax.swing.JMenuItem menuSobre;
    private javax.swing.JTextArea txtTexto;
    // End of variables declaration//GEN-END:variables

}