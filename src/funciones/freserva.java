package funciones;

import clases.Creserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class freserva {
    
   private conexion mysql=new conexion();
   private Connection cn=mysql.conectar();
   private String sSQL="";
   public Integer totalregistros;
   
   
   public DefaultTableModel mostrar(String buscar){
       DefaultTableModel modelo;
       
       String [] titulos = {"ID","Idaula","Numero","idcliente","Solicitante","idtrabajador","Trabajador"};
       
       String [] registro =new String [7];
       
       totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
       
       sSQL="select r.idreserva,r.idaula,a.numero,r.idsolicitante,"+
               "(select nombre from persona where idpersona=r.idsolicitante)as solicitanten,"+
               "(select apaterno from persona where idpersona=r.idsolicitante)as solicitanteap,"+
               "r.idtrabajador,(select nombre from persona where idpersona=r.idtrabajador)as trabajadorn,"+
               "(select apaterno from persona where idpersona=r.idtrabajador)as trabajadorap"+
               " from reserva r inner join aula a on r.idaula=a.idaula where a.numero like '%"+ buscar + "%' order by idreserva desc";
       
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSQL);
           
           while(rs.next()){
               registro [0]=rs.getString("idreserva");
               registro [1]=rs.getString("idaula");
               registro [2]=rs.getString("numero");
               registro [3]=rs.getString("idsolicitante");
               registro [4]=rs.getString("solicitanten") + " " + rs.getString("solicitanteap") ;
               registro [5]=rs.getString("idtrabajador");
               registro [6]=rs.getString("trabajadorn") + " " + rs.getString("trabajadorap");

               
               totalregistros=totalregistros+1;
               modelo.addRow(registro);
               
           }
           return modelo;
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return null;
       }
       
       
       
   } 
   
   public boolean insertar (Creserva dts){
       sSQL="insert into reserva (idaula,idsolicitante,idtrabajador)" +
               "values (?,?,?)";
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setInt(1, dts.getIdaula());
           pst.setInt(2, dts.getIdsolicitante());
           pst.setInt(3, dts.getIdtrabajador());

           
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
   
   public boolean editar (Creserva dts){
       sSQL="update reserva set idaula=?,idsolicitante=?,idtrabajador=?"+
               " where idreserva=?";
           
       
       try {
           PreparedStatement pst=cn.prepareStatement(sSQL);
             pst.setInt(1, dts.getIdaula());
           pst.setInt(2, dts.getIdsolicitante());
           pst.setInt(3, dts.getIdtrabajador());
           
           pst.setInt(4, dts.getIdreserva());
           
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
   
   
   
   
   
   
  
   public boolean eliminar (Creserva dts){
       sSQL="delete from reserva where idreserva=?";
       
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           
           pst.setInt(1, dts.getIdreserva());
           
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
