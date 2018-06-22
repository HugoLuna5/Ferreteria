
package Datos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Conexion {
    static Connection cnn=null;
    static Statement sta=null;
    static ResultSet rst=null;
    
    static String user="root";
    static String pass="";
    static String host="localhost";
    static String dataBase="basededatos_ferreteria";
    static String url="jdbc:mysql://127.0.0.1:3306/basededatos_ferreteria";
    
    
    
    public static Connection enlace(Connection cnn){
        try {
            Class.forName("com.mysql.jdbc.Driver");
             try {
              cnn=DriverManager.getConnection(url, user, pass);//el metodo getConnection siempre espera recibir un url,usuario y un password
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error de url" +ex.getMessage());
            }
           
        } catch (ClassNotFoundException ex) {
        JOptionPane.showMessageDialog(null,"Error de Driver"+ex);    
        }
        return cnn;

} public static Statement declaracion(Statement st){
        try {
            cnn=enlace(cnn);
            st=cnn.createStatement();
            
            
        } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,"Error de declaracion");   
        }
        return st;
}
  public static ResultSet enlacecliente(ResultSet rs){
        try {
            sta=declaracion(sta);
            rs=sta.executeQuery("select * from clientes");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error ");
        }
        return rs;
     }
    public static ResultSet enlaceproducto(ResultSet rs){
        try {
            sta=declaracion(sta);
            rs=sta.executeQuery("select * from productos");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error ");
        }
        return rs;
     }
    
    public static ResultSet enlaceDetalleComprobante(ResultSet rs){
        try {
            sta=declaracion(sta);
            rs=sta.executeQuery("select * from detallecomprobantes");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error ");
        }
        return rs;
     }
   
    public static ResultSet enlaceempleado(ResultSet rs){
        try {
            sta=declaracion(sta);
            rs=sta.executeQuery("select * from empleados");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error ");
        }
        return rs;
     }
     public static ResultSet idComprobante(ResultSet rs) throws SQLException{
	sta=declaracion(sta);
	rs=sta.executeQuery("select idComprobante from comprobantes");
	return rs;
     } 
     public static ResultSet enlaceComprobante(ResultSet rs) throws SQLException{
	sta=declaracion(sta);
	rs=sta.executeQuery("select * from comprobantes");
	return rs;
     } 
      public static ResultSet idEmpleado(ResultSet rs) throws SQLException{
	sta=declaracion(sta);
	rs=sta.executeQuery("select idEmpleado from empleados");
	return rs;
     } 
       public static ResultSet idCliente(ResultSet rs) throws SQLException{
	sta=declaracion(sta);
	rs=sta.executeQuery("select idCliente from clientes");
	return rs;
     } 
       public static ResultSet idProducto(ResultSet rs) throws SQLException{
	sta=declaracion(sta);
	rs=sta.executeQuery("select idProducto from productos");
	return rs;
     } 
}
