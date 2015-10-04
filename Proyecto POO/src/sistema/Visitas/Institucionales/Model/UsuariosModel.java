package sistema.Visitas.Institucionales.Model;
import sistema.Visitas.Institucionales.Form.UsuarioForm;
import sistema.Visitas.Institucionales.Model.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuariosModel{
    private Connection cn;
    private String sql;
     public UsuariosModel(){
         this.cn = new Conexion().getCon();
    }

    public Connection getCn() {
        return cn;
    }
     /*------------------------------------------------Usuarios--------------------------------------------------*/
      public boolean guardarUsuario(UsuarioForm usuario)
    {
        boolean resp = false;
        try 
        {
            sql = "INSERT INTO usuarios (nombre,apellido,contrasena,correo,escuela,rol,telefono,tiempoCompleto,usuario)";
            sql += " Values(?,?,?,  ?,?,?, ?,?,? )";
            PreparedStatement cmd = this.cn.prepareStatement(sql);
            cmd.setString(1, usuario.getNombre());
            cmd.setString(2, usuario.getApellido());
            cmd.setString(3, usuario.getcontrasena());
            
            cmd.setString(4, usuario.getCorreo());
            cmd.setInt(5, usuario.getId_escuela());
            cmd.setInt(6, usuario.getId_rol());
            
            cmd.setString(7, usuario.getTelefono());
            cmd.setBoolean(8, usuario.isTiempoCompleto());
            cmd.setString(9, usuario.getUsuario());
            
            
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
    public boolean modificarUsuario(UsuarioForm usuario)
    {
        boolean resp = false;
        try 
        {
            sql = "UPDATE usuarios set nombre=?,apellido=?,contrasena=?,correo=?,escuela=?,rol=?,telefono=?,tiempoCompleto=?,usuario=? ";
            sql += " where id = ?";
            PreparedStatement cmd = this.cn.prepareStatement(sql);
            cmd.setString(1, usuario.getNombre());
            cmd.setString(2, usuario.getApellido());
            cmd.setString(3, usuario.getcontrasena());
            
            cmd.setString(4, usuario.getCorreo());
            cmd.setInt(5, usuario.getId_escuela());
            cmd.setInt(6, usuario.getId_rol());
            
            cmd.setString(7, usuario.getTelefono());
            cmd.setBoolean(8, usuario.isTiempoCompleto());
            cmd.setString(9, usuario.getUsuario());
            cmd.setInt(10, usuario.getId());
            
            
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
    public List<UsuarioForm> cosultarUsuarios(){
       List<UsuarioForm> listUsuario = new ArrayList<>();
        try{
            Statement cmd = this.cn.createStatement();
            ResultSet rs =cmd.executeQuery("SELECT u.id,u.nombre,u.apellido,u.correo,u.usuario,u.rol,u.telefono,u.contrasena,u.escuela,u.tiempoCompleto FROM usuarios u");
            RolesModel rolCont = new RolesModel();
            EscuelasModel escCont = new EscuelasModel();
            while(rs.next()){
               listUsuario.add(new UsuarioForm(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getBoolean(10),rolCont.cosultarRol(rs.getInt(6)),escCont.cosultarEscuela(rs.getInt(9))));
            }
            if(!this.cn.isClosed())
            {
                this.cn.close();
            }
        }
        catch(Exception e){
        System.err.println("Error" + e.getMessage());
        }
        return listUsuario;
        }
    public UsuarioForm cosultarUsuario(int id){
       List<UsuarioForm> listUsuario = new ArrayList<>();
        try{
            Statement cmd = this.cn.createStatement();
            ResultSet rs =cmd.executeQuery("SELECT u.id,u.nombre,u.apellido,u.correo,u.usuario,u.rol,u.telefono,u.contrasena,u.escuela,u.tiempoCompleto FROM usuarios u where u.id = "+id);
            RolesModel rolCont = new RolesModel();
            EscuelasModel escCont = new EscuelasModel();
            while(rs.next()){
               listUsuario.add(new UsuarioForm(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getBoolean(10),rolCont.cosultarRol(rs.getInt(6)),escCont.cosultarEscuela(rs.getInt(9))));
            }
            if(!this.cn.isClosed())
            {
                this.cn.close();
            }
        }
        catch(Exception e){
        System.err.println("Error" + e.getMessage());
        }
        return listUsuario.get(1);
        }
     public boolean eliminarUsuario(int id)
    {
        boolean resp = false;
        try 
        {
            sql = "Delete From usuarios  where id = "+id;
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
