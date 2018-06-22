/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_ferreterial;

import Datos.Conexion;
import Paneles.GenerarCodigo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego
 */
public class JDComprobante extends javax.swing.JDialog {

    static Connection cnn = null;
    static Statement sta = null;
    static Statement sta2 = null;
    static ResultSet rst = null;
    String id_cliente;

    DefaultTableModel dtm = new DefaultTableModel();
    DefaultTableModel dtm1 = new DefaultTableModel();

    public JDComprobante(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.setLocationRelativeTo(this);

        String titulos[] = {"CANTIDAD", "DESCRIPCION", "PRECIO UNITARIO", "VALORDEVENTA"};
        dtm.setColumnIdentifiers(titulos);
        JTDescripcion.setModel(dtm);

//            try{
//   
//        
//        File file=new File("Cliente.txt");//
//        FileWriter fw= new FileWriter(file);
////        StringBuilder sb=new StringBuilder();
//        int fila= JTDescripcion.getRowCount();//este te devuelve el numero de la fila amrcada 
//        
//		String can=JTDescripcion.getValueAt(3,0 ).toString();
//		String des=JTDescripcion.getValueAt(3,1 ).toString();
//		String pre=JTDescripcion.getValueAt(3,2 ).toString();
//		String valor=JTDescripcion.getValueAt(3,3).toString();
//                fw.write(can); 
//                fw.write(des);
//                fw.write(pre);
//                fw.write(valor);
//                fw.flush();
//                fw.close();
//       
//       
//    }catch(IOException ex){
//        JOptionPane.showMessageDialog(null,"error");
//    }
        Calendar c = Calendar.getInstance();
        DateFormat df1 = DateFormat.getDateInstance(DateFormat.FULL);
        lblFecha.setText("" + df1.format(c.getTime()));

    }

    void aceptar() {
        double valorventa = Double.parseDouble(txtUniLLevar.getText()) * Double.parseDouble(txtPrecio.getText());
        int can = Integer.parseInt(txtUnidades.getText());
        int llevar = Integer.parseInt(txtUniLLevar.getText());
        if (llevar <= can) {
            String descripcion[] = new String[4];

            descripcion[0] = txtUniLLevar.getText();
            descripcion[1] = txtBuscar.getText();
            descripcion[2] = txtPrecio.getText();
            descripcion[3] = String.valueOf(valorventa);
            dtm.addRow(descripcion);
            txtBuscar.setText("");
            txtUnidades.setText("");
            txtPrecio.setText("");
            txtUniLLevar.setText("");
            txtBuscar.requestFocus();
        } else {
            JOptionPane.showMessageDialog(null, "Stock No Disponible");
        }
    }

    void limpiarcajacliente() {
        txtDireccion.setText("");
        txtNombre.setText("");
        txtDni.setText("");
        txtRuc.setText("");
    }

    void LimpiarBotones() {

        txtTotal.setText("");
        txtSumaTotal.setText("");
        txtIgv.setText("");

    }

    void ActualizarJTable() {
        try {
            int cantfilas = dtm.getRowCount();//te devuelve el numero de filas
            if (cantfilas > 0) {//si existe un registro
                for (int i = 0; i < cantfilas; i++) {//recorres tu arreglo
                    dtm.removeRow(0);
                }

            }

            rst = Conexion.enlaceDetalleComprobante(rst);
            String datos[] = new String[5];

            while (rst.next()) {
                datos[0] = rst.getString(1);
                datos[1] = rst.getString(2);
                datos[2] = rst.getString(3);
                datos[3] = rst.getString(4);
                datos[4] = rst.getString(5);

                dtm.addRow(datos);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error garrafal");
        }
    }

    void ActualizarJTableClientes() {
        try {
            int cantfilas = dtm1.getRowCount();//te devuelve el numero de filas
            if (cantfilas > 0) {//si existe un registro
                for (int i = 0; i < cantfilas; i++) {//recorres tu arreglo
                    dtm1.removeRow(0);
                }

            }

            rst = Conexion.enlacecliente(rst);
            String datos[] = new String[8];

            while (rst.next()) {
                datos[0] = rst.getString(1);
                datos[1] = rst.getString(2);
                datos[2] = rst.getString(3);
                datos[3] = rst.getString(4);
                datos[4] = rst.getString(5);
                datos[5] = rst.getString(6);
                datos[6] = rst.getString(7);
                datos[7] = rst.getString(8);

                dtm1.addRow(datos);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error garrafal");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        JTDescripcion = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtRuc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnClientes = new javax.swing.JButton();
        btnMantenimiento = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        btnBorrarCajas = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtSumaTotal = new javax.swing.JTextField();
        txtIgv = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnImprimir = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        txtUnidades = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txtUniLLevar = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnEnviar = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        btnRealizarCalculos = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        optFactura = new javax.swing.JRadioButton();
        optBoleta = new javax.swing.JRadioButton();
        optNota = new javax.swing.JRadioButton();
        optNotaPedidos = new javax.swing.JRadioButton();
        txtId = new javax.swing.JLabel();

        setTitle("COMPROBANTE");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        JTDescripcion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cantidad", "Descripcion", "Precio Unitario", "Valor de Venta"
            }
        ));
        JTDescripcion.setName("Descripcion"); // NOI18N
        JTDescripcion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTDescripcionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTDescripcion);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("R.U.C.:12345678910 ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("N°");

        jPanel1.setBackground(new java.awt.Color(17, 196, 196));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Cliente"));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Nombre:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Direccion:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("RUC:");

        btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.gif"))); // NOI18N
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        btnMantenimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevo empleado.png"))); // NOI18N
        btnMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMantenimientoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("DNI:");

        txtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniActionPerformed(evt);
            }
        });

        btnBorrarCajas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton_limpiar.png"))); // NOI18N
        btnBorrarCajas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarCajasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnBorrarCajas, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBorrarCajas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Descripcion:");

        jLabel8.setText("Suma Total:");

        jLabel9.setText("IGV:");

        jLabel10.setText("Total:  S/. ");

        jLabel11.setText("Seleccione Comprobante:");

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton_imprimir.gif"))); // NOI18N

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/save1.png"))); // NOI18N
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Fecha:");

        lblFecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblFecha.setText("..");

        jPanel2.setBackground(new java.awt.Color(17, 196, 196));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Productos"));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Producto:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Unidades en Stock:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Precio Unitario:");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.gif"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Ingrese Unidades a Llevar:");

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton-aceptar.jpg"))); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel16)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtUnidades, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                .addComponent(txtPrecio)))
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUniLLevar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(14, 14, 14))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)))
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtUniLLevar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        btnEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Back.png"))); // NOI18N
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        btnQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton_limpiar.png"))); // NOI18N
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        btnRealizarCalculos.setText("Realizar Calculos");
        btnRealizarCalculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarCalculosActionPerformed(evt);
            }
        });

        buttonGroup1.add(optFactura);
        optFactura.setText("Factura");
        optFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optFacturaActionPerformed(evt);
            }
        });

        buttonGroup1.add(optBoleta);
        optBoleta.setText("Boleta");
        optBoleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optBoletaActionPerformed(evt);
            }
        });

        buttonGroup1.add(optNota);
        optNota.setText("Nota de Venta");
        optNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optNotaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(optFactura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(optBoleta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(optNota))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(optFactura)
                    .addComponent(optBoleta)
                    .addComponent(optNota)))
        );

        buttonGroup1.add(optNotaPedidos);
        optNotaPedidos.setText("Nota de Pedido");
        optNotaPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optNotaPedidosActionPerformed(evt);
            }
        });

        txtId.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtId.setText("..");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblFecha)
                                        .addGap(35, 35, 35))
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(optNotaPedidos)
                                .addGap(149, 149, 149)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnRealizarCalculos))
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(43, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnImprimir)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSumaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtIgv, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblFecha)
                                .addComponent(jLabel15)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(optNotaPedidos)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtId))
                        .addGap(23, 23, 23)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(btnRealizarCalculos)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnEnviar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnQuitar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtSumaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIgv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMantenimientoActionPerformed
        JDClientes jclientes = new JDClientes(null, rootPaneCheckingEnabled);
        jclientes.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_btnMantenimientoActionPerformed

    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (btnBuscar.isEnabled()) {

            try {
                cnn = Conexion.enlace(cnn);
                sta = cnn.createStatement();
                rst = sta.executeQuery("select * from PRODUCTOS");
                boolean bandera = false;
                String pro = txtBuscar.getText();

                while (rst.next()) {
                    if (pro.equalsIgnoreCase(rst.getString(2))) {
                        txtUnidades.setText(rst.getString(3));
                        txtPrecio.setText(rst.getString(5));
                        bandera = true;
                        break;
                    }
                }
                if (bandera == false) {
                    JOptionPane.showMessageDialog(null, "Producto no Registrado");

                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR DE BUSQUEDA");
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        aceptar();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnRealizarCalculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarCalculosActionPerformed
        double total = 0;
        double IGV = 0;
        // <editor-fold desc="Suma total"> 
        double a;
        double b = 0;
        for (int i = 0; i < dtm.getRowCount(); i++) {
            String Calculo = String.valueOf(dtm.getValueAt(i, 3));
            a = Double.parseDouble(Calculo);
            b = b + a;
            if (i == dtm.getRowCount() - 1) {
                txtSumaTotal.setText("" + b);
                IGV = b * 0.19;
                total = b;
            }
        }
        // </editor-fold> 
        //<editor-fold desc="IGV">
        txtIgv.setText(IGV + "");
        //</editor-fold>
        //<editor-fold desc="Total">
        txtTotal.setText("" + (total + IGV));
        //</editor-fold>
    }//GEN-LAST:event_btnRealizarCalculosActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed


    }//GEN-LAST:event_btnEnviarActionPerformed

    private void JTDescripcionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTDescripcionMouseClicked

    }//GEN-LAST:event_JTDescripcionMouseClicked

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        int fila = JTDescripcion.getSelectedRow();//este te devuelve el numero de la fila amrcada 
//		String id=JTDescripcion.getValueAt(fila,0 ).toString();
//		String nom=JTDescripcion.getValueAt(fila,1 ).toString();
//		String res=JTDescripcion.getValueAt(fila,2 ).toString();
//		String fec=JTDescripcion.setValueAt(fila, fila, fila);

//            int cantfilas=dtm.getRowCount();//te devuelve el numero de filas
        if (fila >= 0) {//si existe un registro
            for (int i = -1; i < fila; i++) {//recorres tu arreglo
                dtm.removeRow(fila);

//		txtCodigo.setText(id);
//		txtNombre.setText(nom);
//		txtResolucion.setText(res);
//		txtFecha.setText(fec);
//		this.Activabotones(false,true,true,false);
            }
        }
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void optFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optFacturaActionPerformed
        try {

            rst = Conexion.idComprobante(rst);

            GenerarCodigo idmas = new GenerarCodigo();
            String idparaCampo = idmas.idMasUno(rst);
            txtId.setText("C" + idparaCampo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO SE PUDO CREAR CODIGO");
        }
        if (optFactura.isSelected()) {
            txtUnidades.setEnabled(false);
            txtPrecio.setEnabled(false);
            txtBuscar.setEnabled(false);
            btnBuscar.setEnabled(false);
            btnQuitar.setEnabled(false);
            btnEnviar.setEnabled(false);
            txtIgv.setEnabled(true);
            txtTotal.setEnabled(true);
            txtDireccion.setEnabled(true);
            txtNombre.setEnabled(true);
            txtRuc.setEnabled(true);
            btnMantenimiento.setEnabled(true);
            btnClientes.setEnabled(true);
            txtDni.setEnabled(true);
        }

    }//GEN-LAST:event_optFacturaActionPerformed

    private void optBoletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optBoletaActionPerformed
        try {

            rst = Conexion.idComprobante(rst);

            GenerarCodigo idmas = new GenerarCodigo();
            String idparaCampo = idmas.idMasUno(rst);
            txtId.setText("C" + idparaCampo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO SE PUDO CREAR CODIGO");
        }
        if (optBoleta.isSelected()) {
            txtRuc.setEnabled(false);
            txtBuscar.setEnabled(false);
            txtUnidades.setEnabled(false);
            txtPrecio.setEnabled(false);
            btnQuitar.setEnabled(false);
            btnEnviar.setEnabled(false);
            btnBuscar.setEnabled(false);
            btnAceptar.setEnabled(false);
            txtUniLLevar.setEnabled(false);
            txtIgv.setEnabled(false);
            txtTotal.setEnabled(false);
            txtDireccion.setEnabled(true);
            txtNombre.setEnabled(true);
            txtRuc.setEnabled(true);
            btnMantenimiento.setEnabled(true);
            btnClientes.setEnabled(true);
            txtDni.setEnabled(true);
        }


    }//GEN-LAST:event_optBoletaActionPerformed

    private void optNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optNotaActionPerformed
        try {

            rst = Conexion.idComprobante(rst);

            GenerarCodigo idmas = new GenerarCodigo();
            String idparaCampo = idmas.idMasUno(rst);
            txtId.setText("C" + idparaCampo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO SE PUDO CREAR CODIGO");
        }
        if (optNota.isSelected()) {
            txtDni.setEnabled(false);
            txtDireccion.setEnabled(false);
            txtNombre.setEnabled(false);
            txtRuc.setEnabled(false);
            txtBuscar.setEnabled(false);
            txtUnidades.setEnabled(false);
            txtUniLLevar.setEnabled(false);
            txtPrecio.setEnabled(false);
            btnBuscar.setEnabled(false);
            btnMantenimiento.setEnabled(false);
            btnClientes.setEnabled(false);
            btnAceptar.setEnabled(false);
            btnQuitar.setEnabled(false);
            btnEnviar.setEnabled(false);
            txtIgv.setEnabled(false);
            txtTotal.setEnabled(false);
            btnGuardar.setEnabled(true);
        }
    }//GEN-LAST:event_optNotaActionPerformed

    private void optNotaPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optNotaPedidosActionPerformed
        if (optNotaPedidos.isSelected()) {
            txtDni.setEnabled(true);
            txtDireccion.setEnabled(true);
            txtNombre.setEnabled(true);
            txtRuc.setEnabled(true);
            txtBuscar.setEnabled(true);
            txtUnidades.setEnabled(true);
            txtUniLLevar.setEnabled(true);
            txtPrecio.setEnabled(true);
            btnBuscar.setEnabled(true);
            btnMantenimiento.setEnabled(true);
            btnClientes.setEnabled(true);
            btnAceptar.setEnabled(true);
            btnQuitar.setEnabled(true);
            btnEnviar.setEnabled(true);
            txtIgv.setEnabled(true);
            txtTotal.setEnabled(true);
        }
    }//GEN-LAST:event_optNotaPedidosActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed

        if (btnClientes.isEnabled()) {

            try {
                cnn = Conexion.enlace(cnn);
                sta = cnn.createStatement();
                rst = sta.executeQuery("select * from clientes");
                boolean bandera = false;
                String buscar = txtDni.getText();

                while (rst.next()) {
                    if (buscar.equalsIgnoreCase(rst.getString(4))) {//aqui te falta darle el valor del dni en la base de datos

                        txtNombre.setText(rst.getString(2));
                        txtDireccion.setText(rst.getString(7));
                        txtRuc.setText(rst.getString(6));
                        id_cliente = rst.getString(1);
                        bandera = true;
                        break;
                    }
                }
                if (bandera == false) {
                    JOptionPane.showMessageDialog(null, "Nombre no Registrado");

                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR DE BUSQUEDA");
            }
        }
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnBorrarCajasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarCajasActionPerformed
        txtDni.setText("");
        txtNombre.setText("");
        txtDireccion.setText("");
        txtRuc.setText("");
    }//GEN-LAST:event_btnBorrarCajasActionPerformed

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        // TODO add your handling code here:
        
         String tipo = "";
        int resp = JOptionPane.showConfirmDialog(null, "¿Desea Guardar el Comprobante?", "Pregunta", 0);//el cero quiere decir que si la respuesta es correcta es cero

        if (resp == 0) {
            try {
                cnn = Conexion.enlace(cnn);
                sta = Conexion.declaracion(sta);
                sta2 = Conexion.declaracion(sta2);

                if (optBoleta.isSelected()) {
                    tipo = "boleta";
                } else if (optFactura.isSelected()) {
                    tipo = "factura";

                } else if (optNotaPedidos.isSelected()) {
                    tipo = "Nota de pedido";
                } else {
                    tipo = "Nota de Venta";
                }
                String idNota = "";
                int numero = 0;
                String id = txtId.getText();
                String fecha = lblFecha.getText();
                String SumaTotal = txtSumaTotal.getText();
                String Igv = txtIgv.getText();
                String montoTotal = txtTotal.getText();

                String comando1 = "insert into comprobantes values('" + id + "','" + fecha + "','" + tipo + "','" + numero + "','" + id_cliente + "')";//id_cliente
                System.out.println(comando1);
                
                sta.execute(comando1);
                //ActualizarJTable();

                
                
                
                String comando = "insert into detallecomprobantes values('" + id + "','" + idNota + "','" + SumaTotal + "','" + Igv + "','" + montoTotal + "')";
                sta.executeUpdate(comando);
              
                //ActualizarJTable();
                cnn.close();

                LimpiarBotones();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error de Guardar"+ex.getMessage());
            }
        }
        
        
    }//GEN-LAST:event_btnGuardarMouseClicked

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
            java.util.logging.Logger.getLogger(JDComprobante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDComprobante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDComprobante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDComprobante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDComprobante dialog = new JDComprobante(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTDescripcion;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBorrarCajas;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnMantenimiento;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnRealizarCalculos;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JRadioButton optBoleta;
    private javax.swing.JRadioButton optFactura;
    private javax.swing.JRadioButton optNota;
    private javax.swing.JRadioButton optNotaPedidos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDni;
    private javax.swing.JLabel txtId;
    private javax.swing.JTextField txtIgv;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtRuc;
    private javax.swing.JTextField txtSumaTotal;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtUniLLevar;
    private javax.swing.JTextField txtUnidades;
    // End of variables declaration//GEN-END:variables
}
