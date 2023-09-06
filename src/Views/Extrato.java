package Views;

import Models.Transacoes;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import DAO.postGres.contaDaoPostgres;

public class Extrato extends javax.swing.JPanel {

    public Extrato() {
        initComponents();
    }
    
    private void carregarExtrato(){
        ArrayList <Transacoes> listaTransacoes = listaTransacoes;
        
        DefaultTableModel table =(DefaultTableModel) this.tabelaExtrato.getModel();
        
        for(Transacoes item : listaTransacoes){
            Object[] novaLinha = (item.getId(), item.getData(), item.get);
            table.addRow(novaLinha);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaExtrato = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        tabelaExtrato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Chave", "Data", "Tipo transação", "Valor", "Saldo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaExtrato);
        if (tabelaExtrato.getColumnModel().getColumnCount() > 0) {
            tabelaExtrato.getColumnModel().getColumn(0).setResizable(false);
            tabelaExtrato.getColumnModel().getColumn(0).setHeaderValue("Title 1");
            tabelaExtrato.getColumnModel().getColumn(1).setHeaderValue("Title 2");
            tabelaExtrato.getColumnModel().getColumn(2).setHeaderValue("Title 3");
            tabelaExtrato.getColumnModel().getColumn(3).setHeaderValue("Title 4");
        }

        jLabel1.setFont(new java.awt.Font("Engravers MT", 0, 18)); // NOI18N
        jLabel1.setText("Extrato");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(jLabel1)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaExtrato;
    // End of variables declaration//GEN-END:variables
}
