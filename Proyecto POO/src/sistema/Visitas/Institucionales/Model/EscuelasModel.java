package sistema.Visitas.Institucionales.Model;
import sistema.Visitas.Institucionales.Form.EscuelaForm;
import sistema.Visitas.Institucionales.Model.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EscuelasModel {
    private Connection cn;
    private String sql;
     public EscuelasModel(){
         this.cn = new Conexion().getCon();
    }

    public Connection getCn() {
        return cn;
    }
     /*------------------------------------------------Escuelas--------------------------------------------------*/
    public boolean guardarEscuela(EscuelaForm escuela)
    {
        boolean resp = false;
        try 
        {
            sql = "INSERT INTO escuelas (nombre,facultad) Values(?,?)";
            PreparedStatement cmd = this.cn.prepareStatement(sql);
            cmd.setString(1, escuela.getNombre());
            cmd.setInt(2, escuela.getId_facultad());
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
    
    public boolean modificarEscuela(EscuelaForm escuela)
    {
        boolean resp = false;
        try 
        {
            sql = "update escuelas set nombre = ?,facultad = ? where id = ?";
            PreparedStatement cmd = this.cn.prepareStatement(sql);
            cmd.setString(1, escuela.getNombre());
            cmd.setInt(2, escuela.getId_facultad());
            cmd.setInt(3, escuela.getId());
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
    
    public List<EscuelaForm> cosultarEscuelas(){
        List<EscuelaForm> listEscuela = new ArrayList<>();
        try{
            Statement cmd = this.cn.createStatement();
            ResultSet rs =cmd.executeQuery("SELECT e.id,e.nombre,e.facultad from escuelas");            
            FacultadModel faCont = new FacultadModel();
            while(rs.next()){
               listEscuela.add(new EscuelaForm(rs.getInt(1),rs.getString(2),rs.getInt(3),faCont.cosultarFacultad(rs.getInt(3))));
            }
            if(!this.cn.isClosed())
            {
                this.cn.close();
            }
        }
        catch(Exception e){
        System.err.println("Error" + e.getMessage());
        }
        return listEscuela;
        }
        public EscuelaForm cosultarEscuela(int id){
        List<EscuelaForm> listEscuela = new ArrayList<>();
        try{
            Statement cmd = this.cn.createStatement();
            ResultSet rs =cmd.executeQuery("SELECT e.id,e.nombre,e.facultad from escuelas e where e.id = "+id);            
            FacultadModel faCont = new FacultadModel();
            while(rs.next()){
               listEscuela.add(new EscuelaForm(rs.getInt(1),rs.getString(2),rs.getInt(3),faCont.cosultarFacultad(rs.getInt(3))));
            }
            if(!this.cn.isClosed())
            {
                this.cn.close();
            }
        }
        catch(Exception e){
        System.err.println("Error" + e.getMessage());
        }
        return listEscuela.get(1);
        }
     public boolean eliminarEscuela(int id)
    {
        boolean resp = false;
        try 
        {
            sql = "Delete From escuelas  where id = "+id;
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