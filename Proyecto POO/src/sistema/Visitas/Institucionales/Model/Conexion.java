/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.Visitas.Institucionales.Model;

/**
 *
 * @author Robert Bonilla
 */
import java.sql.Connection;
import java.sql.DriverManager;
public class Conexion {
    private Connection con;
      
    public Connection getCon(){
    String url="jdbc:mysql://localhost:3306/visitasinstitucionales";    
String driver="com.mysql.jdbc.Driver";
        try {
          Class.forName(driver);
          this.con=DriverManager.getConnection(url, "root", "");          
        } catch (Exception e) {
        System.err.println("Error: "+e.getMessage());
        }
    return con;
    }
}
