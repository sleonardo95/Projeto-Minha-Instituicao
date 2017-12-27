/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Projeto.Views;

import Projeto.Classes.*;
import Projeto.Controllers.*;
import Projeto.Models.Disciplina;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leonardo
 */
public class Disciplinas extends javax.swing.JInternalFrame {
    
    DisciplinaController disciplina;
    TurmaController turma;
    String modo = "Criar";
    String nomeAtual;
    
    /** Creates new form jProfessores
     * @param disciplina 
     * @param turma */
    public Disciplinas(DisciplinaController disciplina, Projeto.Controllers.TurmaController turma) {
        this.disciplina = disciplina;
        this.turma = turma;
        initComponents();
        carregaTabela();
        controleCampos(false);
        
        jbEditar.setEnabled(false);
        jbRemover.setEnabled(false);
        jbSalvar.setEnabled(false);
    }
    
    private void carregaTabela(){
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{ "ID", "Nome" }, 0 ){
            @Override
            public boolean isCellEditable(int row, int column) { 
                return false;
            }
        };
        
        for( int i=0; i < disciplina.index().size(); i++){
            modelo.addRow(new Object[]{ 
                disciplina.index().get(i).getId(), 
                disciplina.index().get(i).getNome()
            });
        }
        
        TableDisciplina.setModel(modelo);
    }
    
    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }
  
    private void limpaCampos(){
        tfId.setText("");
        tfNome.setText("");
    }
    
    private void controleCampos(boolean status){
        tfId.setEnabled(false);
        tfNome.setEnabled(status);
    }
    
    private void cadastrarEditar(){
        String[] dados = { tfId.getText(), tfNome.getText() };
        
        if( !tfNome.getText().equals("") ){
            if(modo.equals("Criar")){
                if( ! ( ( RequisitosFuncionais.permiteDisciplinasIguais ) ? false : disciplina.equalsNome(dados[1]) ) ){
                    disciplina.store(dados);
                    Flash.success("Disciplina cadastrada.");
                    jbSalvar.setEnabled(false);
                    jbNovo.setEnabled(true);
                    jbEditar.setEnabled(false);
                    jbRemover.setEnabled(false);
                    
                    carregaTabela();  
                    limpaCampos();
                    controleCampos(false);
                    
                }else{
                    Flash.error("Disciplina já cadastrada.");
                }
            
            }else if(modo.equals("Editar")){
                if( ! nomeAtual.equals(dados[1])){
                    if( ! ( ( RequisitosFuncionais.permiteDisciplinasIguais ) ? false : disciplina.equalsNome(dados[1]) ) ){
                        disciplina.update(dados, Integer.valueOf(TableDisciplina.getValueAt(TableDisciplina.getSelectedRow(),0).toString()));
                        Flash.success("Disciplina modificada.");
                        
                        jbSalvar.setText("Adicionar");
                
                        jbSalvar.setEnabled(false);
                        jbNovo.setEnabled(true);
                        jbEditar.setEnabled(false);
                        jbRemover.setEnabled(false);
                        
                        carregaTabela();  
                        limpaCampos();
                        controleCampos(false);
                    }else{
                        Flash.error("Disciplina já cadastrada.");
                    }
                }
            }
        }else{
            Flash.error("Alguns campos não devem ficar vazios.");
        }
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlNome = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        tfNome = new javax.swing.JTextField();
        jlMatricula = new javax.swing.JLabel();
        jbSalvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableDisciplina = new javax.swing.JTable();
        jbEditar = new javax.swing.JButton();
        jbRemover = new javax.swing.JButton();
        jbNovo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setClosable(true);
        setTitle("Disciplinas");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(67, 96, 158));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Projeto/Public/images/discipline.png"))); // NOI18N
        jLabel1.setText("  Disciplinas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jlNome.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jlNome.setText("Nome:");

        tfId.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        tfNome.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        tfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfNomeKeyPressed(evt);
            }
        });

        jlMatricula.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jlMatricula.setText("ID:");

        jbSalvar.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jbSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Projeto/Public/icons/add.png"))); // NOI18N
        jbSalvar.setText("Salvar");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        TableDisciplina.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        TableDisciplina.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TableDisciplina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableDisciplinaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableDisciplina);

        jbEditar.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jbEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Projeto/Public/icons/edit.png"))); // NOI18N
        jbEditar.setText("Editar");
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jbRemover.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jbRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Projeto/Public/icons/substract.png"))); // NOI18N
        jbRemover.setText("Remover");
        jbRemover.setPreferredSize(new java.awt.Dimension(89, 25));
        jbRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRemoverActionPerformed(evt);
            }
        });

        jbNovo.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jbNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Projeto/Public/icons/checked.png"))); // NOI18N
        jbNovo.setText("Novo");
        jbNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlNome, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlMatricula, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfNome)
                            .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jbNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jbSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jbEditar, jbNovo, jbRemover, jbSalvar});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlMatricula))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlNome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbSalvar))
                        .addGap(61, 61, 61))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tfId, tfNome});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jbEditar, jbNovo, jbRemover, jbSalvar});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        cadastrarEditar();        
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        int linha = TableDisciplina.getSelectedRow();
        
        if( linha>=0 && linha < disciplina.index().size() ){
            Disciplina d = disciplina.search(Integer.valueOf(TableDisciplina.getValueAt(linha,0).toString()));
            tfId.setText( String.valueOf(d.getId()) );
            tfNome.setText(d.getNome());
            modo = "Editar";
            nomeAtual = tfNome.getText();
            controleCampos(true);
            
            jbSalvar.setText("Modificar");
            
            jbSalvar.setEnabled(true);
            jbNovo.setEnabled(false);
            jbEditar.setEnabled(true);
            jbRemover.setEnabled(true);
            
        }        
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRemoverActionPerformed
        int linha = TableDisciplina.getSelectedRow();
        if( linha>=0 && linha< disciplina.index().size() ){
            if (Flash.confirm("Deseja remover esta disciplina?", "warning") == 0) {
                if( turma.buscaDisciplina(Integer.valueOf(TableDisciplina.getValueAt(linha, 0).toString())) ){
                
                    disciplina.delete(Integer.valueOf(TableDisciplina.getValueAt(linha, 0).toString()));
                    carregaTabela();
                    limpaCampos();
                    controleCampos(false);

                    jbSalvar.setEnabled(false);
                    jbNovo.setEnabled(true);
                    jbEditar.setEnabled(false);
                    jbRemover.setEnabled(false);
                    
                }else{
                    Flash.warning("Disciplina vinculado a turma(s). Encerre-a primeiro, para remover.");                    
                }
            }
        }
    }//GEN-LAST:event_jbRemoverActionPerformed

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoActionPerformed
        if( disciplina.index().size() <= RequisitosFuncionais.quantidadeDisciplinas ){
            jbSalvar.setEnabled(true);
            jbNovo.setEnabled(false);
            jbEditar.setEnabled(false);
            jbRemover.setEnabled(false);

            controleCampos(true);
            jbSalvar.setText("Adicionar");

            limpaCampos();
            modo = "Criar";
            tfId.setText( String.valueOf(Generator.getProximoId()) );
            tfNome.requestFocus();
        }else{
            Flash.error("Número máximo de disciplinas permitidas.");
        }
    }//GEN-LAST:event_jbNovoActionPerformed

    private void TableDisciplinaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableDisciplinaMouseClicked
        jbSalvar.setEnabled(false);
        jbNovo.setEnabled(true);
        jbEditar.setEnabled(true);
        jbRemover.setEnabled(true);
        limpaCampos();
        controleCampos(false);
    }//GEN-LAST:event_TableDisciplinaMouseClicked

    private void tfNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNomeKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) 
            cadastrarEditar();
    }//GEN-LAST:event_tfNomeKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableDisciplina;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbNovo;
    private javax.swing.JButton jbRemover;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JLabel jlMatricula;
    private javax.swing.JLabel jlNome;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables

}