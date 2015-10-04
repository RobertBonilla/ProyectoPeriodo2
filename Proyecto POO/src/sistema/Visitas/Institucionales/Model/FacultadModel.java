/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.Visitas.Institucionales.Model;
import sistema.Visitas.Institucionales.Form.FacultadForm;
import sistema.Visitas.Institucionales.Model.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author L.Michelle
 */
public class FacultadModel {
    private Connection cn;
     private String sql;
     
     public FacultadModel(){
         this.cn = new Conexion().getCon();
    }

    public Connection getCn() {
        return cn;
    }
     /*------------------------------------------------Facultad--------------------------------------------------*/
    public boolean guardarFacultad(FacultadForm facultad)
    {
        boolean resp = false;
        try 
        {
            sql = "INSERT INTO facultad (nombre) Values(?)";
            PreparedStatement cmd = this.cn.prepareStatement(sql);
            cmd.setString(1, facultad.getNombre());
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
    
    public boolean modificarFacultad(FacultadForm facultad)
    {
        boolean resp = false;
        try 
        {
            sql = "update facultad set nombre = ? where id = ?";
            PreparedStatement cmd = this.cn.prepareStatement(sql);
            cmd.setString(1, facultad.getNombre());
            cmd.setInt(2, facultad.getId());
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
    
    public List<FacultadForm> cosultarFacultades(){
        List<FacultadForm> listFacultad = new ArrayList<>();
        try{
            Statement cmd = this.cn.createStatement();
            ResultSet rs =cmd.executeQuery("SELECT f.id,f.nombre from facultad f");            
            while(rs.next()){
               listFacultad.add(new FacultadForm(rs.getInt(1),rs.getString(2)));
            }
            if(!this.cn.isClosed())
            {
                this.cn.close();
            }
        }
        catch(Exception e){
        System.err.println("Error" + e.getMessage());
        }
        return listFacultad;
        }
     public FacultadForm cosultarFacultad(int id){
        List<FacultadForm> listFacultad = new ArrayList<>();
        try{
            Statement cmd = this.cn.createStatement();
            ResultSet rs =cmd.executeQuery("SELECT f.id,f.nombre from facultad f where f.id = "+id);            
            while(rs.next()){
               listFacultad.add(new FacultadForm(rs.getInt(1),rs.getString(2)));
            }
            if(!this.cn.isClosed())
            {
                this.cn.close();
            }
        }
        catch(Exception e){
        System.err.println("Error" + e.getMessage());
        }
        return listFacultad.get(1);
        }
     public boolean eliminarFacultad(int id)
    {
        boolean resp = false;
        try 
        {
            sql = "Delete From facultad  where id = "+id;
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
