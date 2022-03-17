package presentation;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import data.*;
import javax.swing.JOptionPane;

public class DataTable extends javax.swing.JFrame {
    private Conector con = new Conector();
    private Statement st;
    private ResultSet rs;
    DefaultTableModel model;
    int id = 0;

    public DataTable() {
        initComponents();
        this.setLocationRelativeTo(null);
        loadData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        btnEdit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "name", "job", "status", "vaccine", "doses", "dateDose"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla);
        if (Tabla.getColumnModel().getColumnCount() > 0) {
            Tabla.getColumnModel().getColumn(0).setResizable(false);
            Tabla.getColumnModel().getColumn(1).setResizable(false);
            Tabla.getColumnModel().getColumn(2).setResizable(false);
            Tabla.getColumnModel().getColumn(3).setResizable(false);
            Tabla.getColumnModel().getColumn(4).setResizable(false);
            Tabla.getColumnModel().getColumn(5).setResizable(false);
            Tabla.getColumnModel().getColumn(6).setResizable(false);
        }

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnEdit)
                        .addGap(237, 237, 237))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEdit)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_vaccination", "root", "");
            PreparedStatement ps = cn.prepareStatement("select * from tabemployees where id = ?");
            ps.setString(1, String.valueOf(id));
            rs = ps.executeQuery();
            
            if(rs.next()){
                UpdateEmployees oo = new UpdateEmployees(id);
                
                oo.setVisible(true);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
        id = Integer.parseInt((String) Tabla.getValueAt(Tabla.getSelectedRow(), 0) .toString());
    }//GEN-LAST:event_TablaMouseClicked

    private void loadData(){
        String command = "select * from tabemployees";
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_vaccination", "root", "");
            st = cn.createStatement();
            rs = st.executeQuery(command);
            Object[] cliente = new Object[7];
            model = (DefaultTableModel) Tabla.getModel();
            
            while(rs.next()){
                cliente[0] = rs.getInt("id");
                cliente[1] = rs.getString("name");
                cliente[2] = rs.getInt("job");
                cliente[3] = rs.getString("status");
                cliente[4] = rs.getInt("vaccine");
                cliente[5] = rs.getInt("doses");
                cliente[6] = rs.getString("dateDose");
                
                model.addRow(cliente);
            }
            
            Tabla.setModel(model);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    private void limpiarTabla(){
        for(int i = 0; i <= Tabla.getRowCount(); i++){
            model.removeRow(i);
            i=i-1;
        }
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla;
    private javax.swing.JButton btnEdit;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
