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
public class UsuarioForm extends ValidatorForm{

private static final long serialVersionUID = 1L;
     int id;
     private String nombre;
     private String apellido;
     private String correo;
     private String usuario;
     private int id_rol;
     private String telefono;
     private String contrasena;
     private int id_escuela;
     private boolean tiempoCompleto;
     private RolForm listRol;
     private EscuelaForm listEscuela;

    public UsuarioForm() {
    }

    public UsuarioForm(int id, String nombre, String apellido, String correo, String usuario, int id_rol, String telefono, String contrasena,int escuela,boolean tCompleto) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.usuario = usuario;
        this.id_rol = id_rol;
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.id_escuela = escuela;
        this.tiempoCompleto = tCompleto;
    }
      public UsuarioForm(int id, String nombre, String apellido, String correo, String usuario, int id_rol, String telefono, String contrasena,int escuela,boolean tCompleto,RolForm listRol,EscuelaForm listEscuela) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.usuario = usuario;
        this.id_rol = id_rol;
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.id_escuela = escuela;
        this.tiempoCompleto = tCompleto;
        this.listEscuela = listEscuela;
        this.listRol = listRol;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getcontrasena() {
        return contrasena;
    }

    public RolForm getListRol() {
        return listRol;
    }

    public void setListRol(RolForm listRol) {
        this.listRol = listRol;
    }

    public EscuelaForm getListEscuela() {
        return listEscuela;
    }

    public void setListEscuela(EscuelaForm listEscuela) {
        this.listEscuela = listEscuela;
    }


    public void setcontrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getId_escuela() {
        return id_escuela;
    }

    public void setId_escuela(int id_escuela) {
        this.id_escuela = id_escuela;
    }

    public boolean isTiempoCompleto() {
        return tiempoCompleto;
    }

    public void setTiempoCompleto(boolean tiempoCompleto) {
        this.tiempoCompleto = tiempoCompleto;
    }
    
    
}
