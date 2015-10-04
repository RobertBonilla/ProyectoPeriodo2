package sistema.Visitas.Institucionales.Model;
import sistema.Visitas.Institucionales.Form.AspiranteForm;
import sistema.Visitas.Institucionales.Model.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AspirantesModel {
    private Connection cn;
    private String sql;
     public AspirantesModel(){
         this.cn = new Conexion().getCon();
    }

    public Connection getCn() {
        return cn;
    }
   
    /*------------------------------------------------Aspirante--------------------------------------------------*/
      public boolean guardarAspirante(AspiranteForm aspirante)
    {
        boolean resp = false;
        try 
        {
            sql = "INSERT INTO aspirantes (nombre,apellido,correo,fechaIngreso,carrera1,carrera2,institucion,telefono)";
            sql += " Values(?,?,?,?,  ?,?,?,?)";
            PreparedStatement cmd = this.cn.prepareStatement(sql);
            cmd.setString(1, aspirante.getNombre());
            cmd.setString(2, aspirante.getApellido());
            cmd.setString(3, aspirante.getCorreo());
            cmd.setString(4, aspirante.getFechaIngreso());
            cmd.setInt(5,aspirante.getId_carrera1());
            cmd.setInt(6,aspirante.getId_carrera2());
            cmd.setInt(7,aspirante.getId_institucion());
            cmd.setString(8, aspirante.getTelefono());
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
    public boolean modificarAspirante(AspiranteForm aspirante)
    {
        boolean resp = false;
        try 
        {
            sql = "update aspirantes set nombre = ?,apellido=?,correo=?,fechaIngreso=?,carrera1=?,carrera2=?,institucion=?,telefono=? ";
            sql += " where id = ?";
            PreparedStatement cmd = this.cn.prepareStatement(sql);
            cmd.setString(1, aspirante.getNombre());
            cmd.setString(2, aspirante.getApellido());
            cmd.setString(3, aspirante.getCorreo());
            cmd.setString(4, aspirante.getFechaIngreso());
            cmd.setInt(5,aspirante.getId_carrera1());
            cmd.setInt(6,aspirante.getId_carrera2());
            cmd.setInt(7,aspirante.getId_institucion());
            cmd.setString(8, aspirante.getTelefono());
            cmd.setInt(9,aspirante.getId());
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
    
    public List<AspiranteForm> cosultarAspirantes(){
        List<AspiranteForm> listAspirante = new ArrayList<>();
        try{
            Statement cmd = this.cn.createStatement();
            ResultSet rs =cmd.executeQuery("Select a.id,a.nombre,a.apellido,a.telefono,a.correo,a.fechaIngreso,a.carrera1,a.carrera2,a.institucion  from aspirantes a ");
            InstitucionesModel instCont = new InstitucionesModel();
            EscuelasModel escCont = new EscuelasModel();
            while(rs.next()){
             listAspirante.add(new AspiranteForm(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),instCont.cosultarInstitucion(rs.getInt(1)),escCont.cosultarEscuela(rs.getInt(7)),escCont.cosultarEscuela(rs.getInt(8))));
            }
            if(!this.cn.isClosed())
            {
                this.cn.close();
            }            
        }
        catch(Exception e){
        System.err.println("Error" + e.getMessage());
        }
        return listAspirante;
        }
    
        public AspiranteForm cosultarAspirante(int id){
        List<AspiranteForm> listAspirante = new ArrayList<>();
        try{
            Statement cmd = this.cn.createStatement();
            ResultSet rs =cmd.executeQuery("Select a.id,a.nombre,a.apellido,a.correo,a.fechaIngreso,a.carrera1,a.carrera2,a.institucion  from aspirantes a  where a.id = "+id);
           InstitucionesModel instCont = new InstitucionesModel();
            EscuelasModel escCont = new EscuelasModel();
            while(rs.next()){
             listAspirante.add(new AspiranteForm(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),instCont.cosultarInstitucion(rs.getInt(1)),escCont.cosultarEscuela(rs.getInt(7)),escCont.cosultarEscuela(rs.getInt(8))));
            }
            if(!this.cn.isClosed())
            {
                this.cn.close();
            }            
        }
        catch(Exception e){
        System.err.println("Error" + e.getMessage());
        }
        return listAspirante.get(1);
        }
   
     public boolean eliminarAspirante(int id)
    {
        boolean resp = false;
        try 
        {
            sql = "Delete From aspirantes  where id = "+id;
            PreparedStatement cmd = this.cn.prepareStatement(sql);
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
