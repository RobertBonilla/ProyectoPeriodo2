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
public class FacultadForm extends ValidatorForm{

private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;

    public FacultadForm() {
    }

    public FacultadForm(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
