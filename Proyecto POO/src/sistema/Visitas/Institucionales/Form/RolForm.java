/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.Visitas.Institucionales.Form;
import org.apache.struts.validator.ValidatorForm;
/**
 *
 * @author Robert Bonilla
 */
public class RolForm extends ValidatorForm{

	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
    public RolForm(){
            id=0;
            nombre="";
            }
    
     public RolForm(int ID,String NAME){
            id=ID;
            nombre=NAME;
            }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }
    
}
