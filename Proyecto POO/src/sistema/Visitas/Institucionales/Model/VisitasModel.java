package sistema.Visitas.Institucionales.Model;
import sistema.Visitas.Institucionales.Form.VisitasForm;
import sistema.Visitas.Institucionales.Model.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VisitasModel {
    private Connection cn;
    private String sql;
     public VisitasModel(){
         this.cn = new Conexion().getCon();
    }

    public Connection getCn() {
        return cn;
    }
    
     /*------------------------------------------------Visitas--------------------------------------------------*/
     public boolean guardarVisita(VisitasForm visita)
    {
        boolean resp = false;
        try 
        {
            sql = "INSERT INTO visitas (usuario,usuarioAsigno,institucion,fechaInicio,fechaFin,visitaRealizadaestado,estado,comentarios,comentariosVisita)";
            sql += " Values(?,?,?,  ?,?,?, ?,?,? )";
            PreparedStatement cmd = this.cn.prepareStatement(sql);
            cmd.setInt(1, visita.getId_usuario());
            cmd.setInt(2, visita.getId_usuarioAsigno());
            cmd.setInt(3, visita.getId_institucion());
            
            cmd.setString(4, visita.getFechaInicio());
            cmd.setString(5, visita.getFechaFin());
            cmd.setBoolean(6, visita.getvisitaRealizada());
            
            cmd.setString(7, visita.getEstado());
            cmd.setString(8, visita.getComentarios());
            cmd.setString(9, visita.getComentariosVisita());
            
            
            cmd.executeUpdate();
            if(!this.cn.isClosed())
            {
                this.cn.close();
            }
            resp = true;
        } 
        catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return resp;
    }
     public boolean modificarVisita(VisitasForm visita)
    {
        boolean resp = false;
        try 
        {
            sql = "update visitas set usuario=?,usuarioAsigno=?,institucion=?,fechaInicio=?,fechaFin=?,visitaRealizadaestado=?,estado=?,comentarios=?,comentariosVisita=?";
            sql += " where fechaInicio = ? and fechaFin =? and usuario = ?";
            PreparedStatement cmd = this.cn.prepareStatement(sql);
            cmd.setInt(1, visita.getId_usuario());
            cmd.setInt(2, visita.getId_usuarioAsigno());
            cmd.setInt(3, visita.getId_institucion());
            
            cmd.setString(4, visita.getFechaInicio());
            cmd.setString(5, visita.getFechaFin());
            cmd.setBoolean(6, visita.getvisitaRealizada());
            
            cmd.setString(7, visita.getEstado());
            cmd.setString(8, visita.getComentarios());
            cmd.setString(9, visita.getComentariosVisita());
            
            cmd.setInt(10, visita.getId_usuario());
            cmd.setString(11, visita.getFechaInicio());
            cmd.setString(12, visita.getFechaFin());
            
            
            cmd.executeUpdate();
            if(!this.cn.isClosed())
            {
                this.cn.close();
            }
            resp = true;
        } 
        catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return resp;
    }
     public List<VisitasForm> cosultarVisitas(){
        List<VisitasForm> listVisita = new ArrayList<>();
        try{
            Statement cmd = this.cn.createStatement();
            ResultSet rs =cmd.executeQuery("SELECT v.usuario,v.institucion,v.usuarioAsigno,v.fechaInicio,v.fechaFin,v.visitaRealizada,v.estado,v.comentarios,v.comentariosVisita FROM visitas v");
            UsuariosModel usCont = new UsuariosModel();
            InstitucionesModel insCont = new InstitucionesModel();
            while(rs.next()){
               listVisita.add(new VisitasForm(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getBoolean(6),rs.getString(7),rs.getString(8),rs.getString(9),usCont.cosultarUsuario(rs.getInt(1)),insCont.cosultarInstitucion(rs.getInt(2)),usCont.cosultarUsuario(rs.getInt(3))));
            }
            if(!this.cn.isClosed())
            {
                this.cn.close();
            }
        }
        catch(Exception e){
        System.err.println("Error" + e.getMessage());
        }
        return listVisita;
        }
     public VisitasForm cosultarVisita(String User){
        List<VisitasForm> listVisita = new ArrayList<>();
        try{
            Statement cmd = this.cn.createStatement();
            ResultSet rs =cmd.executeQuery("SELECT v.usuario,v.institucion,v.usuarioAsigno,v.fechaInicio,v.fechaFin,v.visitaRealizada,v.estado,v.comentarios,v.comentariosVisita FROM visitas v where v.usuario = "+User);
            UsuariosModel usCont = new UsuariosModel();
            InstitucionesModel insCont = new InstitucionesModel();
            while(rs.next()){
               listVisita.add(new VisitasForm(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getBoolean(6),rs.getString(7),rs.getString(8),rs.getString(9),usCont.cosultarUsuario(rs.getInt(1)),insCont.cosultarInstitucion(rs.getInt(2)),usCont.cosultarUsuario(rs.getInt(3))));
            }
            if(!this.cn.isClosed())
            {
                this.cn.close();
            }
        }
        catch(Exception e){
        System.err.println("Error" + e.getMessage());
        }
        return listVisita.get(1);
        }
         public boolean eliminarVisita(VisitasForm visita)
    {
        boolean resp = false;
        try 
        {
            sql = "Delete From visitas  where usuario = ? and fechaInicio = ? and fechaFin =?";
            PreparedStatement cmd = this.cn.prepareStatement(sql);
            cmd.setInt(1, visita.getId_usuario());
            cmd.setString(2, visita.getFechaInicio());
            cmd.setString(3, visita.getFechaFin());
            cmd.executeUpdate();
            if(!this.cn.isClosed())
            {
                this.cn.close();
            }
            resp = true;
        } 
        catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return resp;
    }
}
