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
public class EscuelaForm extends ValidatorForm{

private static final long serialVersionUID = 1L;
	private int id;
	private int id_facultad;
	private String nombre;
	private FacultadForm listFacultad;
    public EscuelaForm() {
        
    }

    public EscuelaForm(int id,  String nombre,int id_facultad) {
        this.id = id;
        this.id_facultad = id_facultad;
        this.nombre = nombre;
    }
     public EscuelaForm(int id,  String nombre,int id_facultad,FacultadForm listFacultad) {
        this.id = id;
        this.id_facultad = id_facultad;
        this.nombre = nombre;
        this.listFacultad = listFacultad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_facultad() {
        return id_facultad;
    }

    public void setId_facultad(int id_facultad) {
        this.id_facultad = id_facultad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public FacultadForm getListFacultad() {
        return listFacultad;
    }

    public void setListFacultad(FacultadForm listFacultad) {
        this.listFacultad = listFacultad;
    }

  
    
    
}
