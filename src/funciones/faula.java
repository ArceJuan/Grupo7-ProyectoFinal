
package funciones;

import clases.Caula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class faula {
    
   private conexion mysql=new conexion();
   private Connection cn=mysql.conectar();
   private String sSQL="";
   public Integer totalregistros;
   
   public faula(){}
   
   public DefaultTableModel mostrar(String buscar){
       DefaultTableModel modelo;
       
       String [] titulos = {"ID","Número","Piso","Descripción","Caracteristicas","Estado","Tipo aula"};
       
       String [] registro =new String [7];
       
       totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
       
       sSQL="select * from aula where piso like '%"+ buscar + "%' order by idaula";
       
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSQL);
           
           while(rs.next()){
               registro [0]=rs.getString("idaula");
               registro [1]=rs.getString("numero");
               registro [2]=rs.getString("piso");
               registro [3]=rs.getString("descripcion");
               registro [4]=rs.getString("caracteristicas");
               registro [5]=rs.getString("estado");
               registro [6]=rs.getString("tipo_aula");
               
               totalregistros=totalregistros+1;
               modelo.addRow(registro);
               
           }
           return modelo;
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"Se produjo el siguiente error: "+ e.getMessage());
           return null;
       }
     } 
   
   
   public DefaultTableModel mostrarvista(String buscar){
       DefaultTableModel modelo;
       
       String [] titulos = {"ID","Número","Piso","Descripción","Caracteristicas","Estado","Tipo aula"};
       
       String [] registro =new String [7];
       
       totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
       
       sSQL="select * from aula where piso like '%"+ buscar + "%' and estado='Disponible' order by idaula";
       
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSQL);
           
           while(rs.next()){
               registro [0]=rs.getString("idaula");
               registro [1]=rs.getString("numero");
               registro [2]=rs.getString("piso");
               registro [3]=rs.getString("descripcion");
               registro [4]=rs.getString("caracteristicas");
               registro [5]=rs.getString("estado");
               registro [6]=rs.getString("tipo_aula");
               
               totalregistros=totalregistros+1;
               modelo.addRow(registro);
               
           }
           return modelo;
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"Se produjo el siguiente error: "+ e.getMessage());
           return null;
       }
     } 
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   public boolean insertar (Caula dts){
       sSQL="insert into aula (numero,piso,descripcion,caracteristicas,estado,tipo_aula)" +
               "values (?,?,?,?,?,?)";
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setString(1, dts.getNumero());
           pst.setString(2, dts.getPiso());
           pst.setString(3, dts.getDescripcion());
           pst.setString(4, dts.getCaracteristicas());
           pst.setString(5, dts.getEstado());
           pst.setString(6, dts.getTipo_aula());
           
           int n=pst.executeUpdate();
           
           if (n!=0){
               return true;
           }
           else {
               return false;
           }
           
           
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return false;
       }
   }
   
   public boolean editar (Caula dts){
       sSQL="update aula set numero=?,piso=?,descripcion=?,caracteristicas=?,estado=?,tipo_aula=?"+
               " where idaula=?";
           
       
       try {
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setString(1, dts.getNumero());
           pst.setString(2, dts.getPiso());
           pst.setString(3, dts.getDescripcion());
           pst.setString(4, dts.getCaracteristicas());
           pst.setString(5, dts.getEstado());
           pst.setString(6, dts.getTipo_aula());
           pst.setInt(7, dts.getIdaula());
           
           int n=pst.executeUpdate();
           
           if (n!=0){
               return true;
           }
           else {
               return false;
           }
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return false;
       }
   } 
  
   public boolean desocupar (Caula dts){
       sSQL="update aula set estado='Disponible'"+
               " where idaula=?";
           
       
       try {
           PreparedStatement pst=cn.prepareStatement(sSQL);
          
           pst.setInt(1, dts.getIdaula());
           
           int n=pst.executeUpdate();
           
           if (n!=0){
               return true;
           }
           else {
               return false;
           }
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return false;
       }
   } 
  
   
   public boolean ocupar (Caula dts){
       sSQL="update aula set estado='Ocupado'"+
               " where idaula=?";
           
       
       try {
           PreparedStatement pst=cn.prepareStatement(sSQL);
          
           pst.setInt(1, dts.getIdaula());
           
           int n=pst.executeUpdate();
           
           if (n!=0){
               return true;
           }
           else {
               return false;
           }
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return false;
       }
   } 
   
   
   public boolean eliminar (Caula dts){
       sSQL="delete from aula where idaula=?";
       
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           
           pst.setInt(1, dts.getIdaula());
           
           int n=pst.executeUpdate();
           
           if (n!=0){
               return true;
           }
           else {
               return false;
           }
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return false;
       }
   }
  
   
   
  
   
    
    
}
