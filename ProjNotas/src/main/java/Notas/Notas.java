package Notas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import javax.swing.JFileChooser;


public class Notas {
    private String erro;
    private String nomeDoArquivo;
    private String caminhoDoArquivo;
    private String conteudo;

    
    public Notas() {
        this.erro = "";
        this.nomeDoArquivo = "";
        this.caminhoDoArquivo = "";
        this.conteudo = "";
    }
    
    /**
     Salvar arquivo        
     */
    public boolean salvar(String nome, String conteudo) {
        /* Criar um novo arquivo e escreve no início dele */
        
        /*
        OutputStream é uma classe. Corresponde a um objeto que escreve sequências de bytes em algum lugar.
        */
        OutputStream os;
        OutputStreamWriter osw;
        BufferedWriter bw;
        try {
            os = new FileOutputStream(nome);
            osw = new OutputStreamWriter(os);
            
            bw = new BufferedWriter(osw);
            bw.write(conteudo);
            
            bw.close();
        } catch (FileNotFoundException ex) {
            erro = "Falha ao salvar o arquivo " + nome + ".\n\n"
            + "Tente novamente!";
            return false;
        } catch (IOException ex) {
            erro = "Falha ao escrever ou ao encerrar o arquivo " + nome+ ".\n\n"
            + "Tente novamente!";
            return false;
        }
        
        return true;
    }
    
    /**
     * Exibir uma janela para o que usuário selecione o local e o nome do 
     * arquivo que será salvo no sistema operacional. 
     * Depois da seleção, o método salvar(...) é chamdo para salvar o arquivo.
     * 
     * @param conteudo String sendo o conteúdo do arquivo
     * @return boolean retornando true caso o arquivo tenha sido salvo, 
     *         ou false caso tenha ocorrido um problema
     */
    public boolean salvarComo(String conteudo) {
        
        /*
        Constrói um JFileChooser apontando para O diretório padrão do usuário. Este padrão Depende do sistema operacional . 
        Normalmente, é a pasta "Meus Documentos" no Windows e o diretório pessoal do usuário No Unix.
        */
        JFileChooser arquivo = new JFileChooser(); 
        arquivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        /*
        JFileChooserfornece um mecanismo simples para o usuário escolher um arquivo. 
        Para obter informações sobre como usar JFileChooser, 
        consulte Como usar os seletores de arquivo , uma seção no Tutorial de Java .
        */
     
        
        if (arquivo.showSaveDialog(null)==1){
            /* Botão Cancelar foi clicado */
            return false;
        } else {
            /* Botão Salvar foi clicado */
            this.nomeDoArquivo = arquivo.getSelectedFile().getName();
            this.caminhoDoArquivo = arquivo.getSelectedFile().toString();

            return salvar(arquivo.getSelectedFile().toString(), conteudo);
        }
    }
    
    /**
     * Abrir um arquivo salvo
     */
    public boolean abrir() {
        JFileChooser arquivo = new JFileChooser(); 
        arquivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        if (arquivo.showOpenDialog(null)==1){
            /* Botão Cancelar foi clicado */
            return false;
        } else {
            /* Botão Abrir foi clicado */
            this.nomeDoArquivo = arquivo.getSelectedFile().getName();
            this.caminhoDoArquivo = arquivo.getSelectedFile().toString();

            try {
                // Lendo um arquivo
                InputStream is = new FileInputStream(this.caminhoDoArquivo);
                InputStreamReader ir = new InputStreamReader(is);
                BufferedReader br;

                String s = null;
                try {
                    br = new BufferedReader(ir);
                    do {
                        if (s != null)
                            this.conteudo += (s+"\n");

                    } while ((s = br.readLine()) != null);

                    br.close();
                } catch (IOException ex) {
                    erro = "Falha ao ler o arquivo " + this.nomeDoArquivo + ".\n\n"
                    + "Tente novamente!";
                    return false;
                }  
            } catch (FileNotFoundException ex) {
                erro = "Falha ao abrir o arquivo " + this.nomeDoArquivo + ".\n\n"
                    + "Tente novamente!";
                return false;
            }             
            return true;
        }
    }

    public String getErro() {
        return erro;
    }

    public String getNomeDoArquivo() {
        return nomeDoArquivo;
    }

    public String getCaminhoDoArquivo() {
        return caminhoDoArquivo;
    }

    public String getConteudo() {
        return conteudo;
    }
}
