/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Projeto.Views.membros;

import Projeto.Classes.Flash;
import Projeto.Classes.Generator;
import Projeto.Classes.RequisitosFuncionais;
import Projeto.Controllers.AlunoController;
import Projeto.Models.Aluno;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leonardo
 */
public class Alunos extends javax.swing.JInternalFrame {
    
    AlunoController aluno;
    String modo = "Criar";
    
    /** Creates new form jAlunos
     * @param aluno */
    public Alunos(AlunoController aluno ) {
        // variavel da classe recebe dados do controller inicializado no main
        this.aluno = aluno;
        initComponents();
        
        //carrega tabela da interface
        carregaTabela();
        
        // realiza o controle de campos
        controleCampos(false);
        jbEditar.setEnabled(false);
        jbRemover.setEnabled(false);
        jbSalvar.setEnabled(false);
    }
        
    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }    
       
    private void carregaTabela(){
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{ "Matricula", "Nome"}, 0 ){
            @Override
            public boolean isCellEditable(int row, int column) { 
                return false;
            }
        };
        
        for( int i=0; i < aluno.index().size(); i++){
            modelo.addRow(new Object[]{ 
                aluno.index().get(i).getMatricula(), 
                aluno.index().get(i).getNome()
            });
        }
        
        modelo.isCellEditable(0, 0); // desativa a edição da tabela
        TableAlunos.setModel(modelo); // seta o modelo pré definido na tabela de alunos
    }
    
    private void limpaCampos(){
        tfMatricula.setText("");
        tfNome.setText("");
    }
     
    private void controleCampos(boolean status){
        tfMatricula.setEnabled(false);
        tfNome.setEnabled(status);
    }
    
    // função para cadastrar e editar registros
    private void cadastrarEditar(){
        String[] dados = { tfMatricula.getText(), tfNome.getText()  };
        
        if( !tfNome.getText().equals("") ){
            
            if(modo.equals("Criar")){
                aluno.store(dados);
                Flash.success("Aluno matriculado.");
                jbSalvar.setEnabled(false);
                jbNovo.setEnabled(true);
                jbEditar.setEnabled(false);
                jbRemover.setEnabled(false);
                
            }else if(modo.equals("Editar")){
                aluno.update(dados, Integer.valueOf(TableAlunos.getValueAt(TableAlunos.getSelectedRow(), 0).toString()));
                Flash.success("Informações salvas.");
                jbSalvar.setText("Matricular");
                
                jbSalvar.setEnabled(false);
                jbNovo.setEnabled(true);
                jbEditar.setEnabled(false);
                jbRemover.setEnabled(false);
            }
            // atualiza dados da tabela, apaga campos e faz o controle de botoes
            carregaTabela();  
            limpaCampos();
            controleCampos(false);
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
        tfNome = new javax.swing.JTextField();
        tfMatricula = new javax.swing.JFormattedTextField();
        jlMatricula = new javax.swing.JLabel();
        jlNome = new javax.swing.JLabel();
        jbNovo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableAlunos = new javax.swing.JTable();
        jbEditar = new javax.swing.JButton();
        jbSalvar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jbRemover = new javax.swing.JButton();

        setClosable(true);
        setTitle("Alunos");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(52, 73, 114));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Projeto/Public/images/reading.png"))); // NOI18N
        jLabel1.setText(" ALUNOS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 839, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addContainerGap())
        );

        tfNome.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        tfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfNomeKeyPressed(evt);
            }
        });

        tfMatricula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#########"))));
        tfMatricula.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        jlMatricula.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jlMatricula.setText("Matricula:");

        jlNome.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jlNome.setText("Nome:");

        jbNovo.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jbNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Projeto/Public/icons/add.png"))); // NOI18N
        jbNovo.setText("Novo");
        jbNovo.setBorder(null);
        jbNovo.setBorderPainted(false);
        jbNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoActionPerformed(evt);
            }
        });

        TableAlunos.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        TableAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TableAlunos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TableAlunos.setSelectionBackground(new java.awt.Color(26, 66, 97));
        TableAlunos.getTableHeader().setReorderingAllowed(false);
        TableAlunos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableAlunosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableAlunos);
        TableAlunos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jbEditar.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jbEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Projeto/Public/icons/edit.png"))); // NOI18N
        jbEditar.setText("Editar");
        jbEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jbSalvar.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jbSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Projeto/Public/icons/checked.png"))); // NOI18N
        jbSalvar.setText("Matricular");
        jbSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jbRemover.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jbRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Projeto/Public/icons/substract.png"))); // NOI18N
        jbRemover.setText("Desmatricular");
        jbRemover.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbRemover.setPreferredSize(new java.awt.Dimension(89, 25));
        jbRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jbNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(jbSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(jbRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jlMatricula)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tfMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(jlNome)
                            .addGap(9, 9, 9)
                            .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(44, 44, 44)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlMatricula))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jlNome))
                                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbSalvar))
                                .addGap(9, 9, 9)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbEditar)
                                    .addComponent(jbRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(42, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        int linha = TableAlunos.getSelectedRow();
        
        if( linha>=0 && linha < aluno.index().size() ){
            Aluno a = aluno.search(Integer.valueOf(TableAlunos.getValueAt(linha, 0).toString()));
            tfMatricula.setText(String.valueOf(a.getMatricula()));
            tfNome.setText(a.getNome());
            
            modo = "Editar";
            controleCampos(true);
            
            jbSalvar.setText("Modificar");
            
            jbSalvar.setEnabled(true);
            jbNovo.setEnabled(false);
            jbEditar.setEnabled(true);
            jbRemover.setEnabled(true);
            
        }
        
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRemoverActionPerformed
        int linha = TableAlunos.getSelectedRow();
        if( linha>=0 && linha< aluno.index().size() ){
            if (Flash.confirm("Deseja desmatricular esse aluno?", "warning") == 0) {
                aluno.delete(Integer.valueOf(TableAlunos.getValueAt(linha, 0).toString()));
                carregaTabela();
                limpaCampos();
                jbSalvar.setEnabled(false);
                jbNovo.setEnabled(true);
                jbEditar.setEnabled(false);
                jbRemover.setEnabled(false);
            }
        }
    }//GEN-LAST:event_jbRemoverActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        cadastrarEditar();        
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void TableAlunosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableAlunosMouseClicked
        jbSalvar.setEnabled(false);
        jbNovo.setEnabled(true);
        jbEditar.setEnabled(true);
        jbRemover.setEnabled(true);
        limpaCampos();
        controleCampos(false);
    }//GEN-LAST:event_TableAlunosMouseClicked

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoActionPerformed
        if( aluno.index().size() <= RequisitosFuncionais.quantidadeAlunos ){
            jbSalvar.setEnabled(true);
            jbNovo.setEnabled(false);
            jbEditar.setEnabled(false);
            jbRemover.setEnabled(false);

            controleCampos(true);
            jbSalvar.setText("Matricular");
            limpaCampos();
            modo = "Criar";
            carregaTabela();
            tfMatricula.setText(String.valueOf(Generator.getProximaMatricula()) ); 
            tfNome.requestFocus();
        }else{
            Flash.error("Número máximo de alunos permitidos.");
        }
    }//GEN-LAST:event_jbNovoActionPerformed

    private void tfNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNomeKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) 
            cadastrarEditar();
    }//GEN-LAST:event_tfNomeKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableAlunos;
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
    private javax.swing.JFormattedTextField tfMatricula;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables

}