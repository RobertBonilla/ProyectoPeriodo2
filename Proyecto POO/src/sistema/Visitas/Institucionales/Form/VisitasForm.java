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
public class VisitasForm extends ValidatorForm{

		private static final long serialVersionUID = 1L;
		private int id_usuario;
		private int id_institucion;
		private int id_usuarioAsigno;
		private String fechaInicio;
		private String fechaFin;
		private boolean visitaRealizada;
		private String estado;
		private String comentarios;
		private String comentariosVisita;
		private UsuarioForm listUsario;
		private InstitucionForm listInstitucion;
		private UsuarioForm listUsarioAsigno;

    public VisitasForm() {
    }

    public VisitasForm(int id_usuario, int id_institucion, int id_usuarioAsigno, String fechaInicio, String fechaFin, boolean visitaRealizada, String estado, String comentarios, String comentariosVisit) {
        this.id_usuario = id_usuario;
        this.id_institucion = id_institucion;
        this.id_usuarioAsigno = id_usuarioAsigno;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.visitaRealizada = visitaRealizada;
        this.estado = estado;
        this.comentarios = comentarios;
        this.comentariosVisita = comentariosVisit;
    }
    
     public VisitasForm(int id_usuario, int id_institucion, int id_usuarioAsigno, String fechaInicio, String fechaFin, boolean visitaRealizada, String estado, String comentarios, String comentariosVisit,UsuarioForm listUsuario,InstitucionForm listInstitucion,UsuarioForm listUsuarioAsigno) {
        this.id_usuario = id_usuario;
        this.id_institucion = id_institucion;
        this.id_usuarioAsigno = id_usuarioAsigno;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.visitaRealizada = visitaRealizada;
        this.estado = estado;
        this.comentarios = comentarios;
        this.comentariosVisita = comentariosVisit;
        this.listUsario = listUsuario;
        this.listInstitucion = listInstitucion;
        this.listUsarioAsigno = listUsuarioAsigno;
    }

    public String getComentariosVisita() {
        return comentariosVisita;
    }

    public void setComentariosVisita(String comentariosVisita) {
        this.comentariosVisita = comentariosVisita;
    }

   

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_institucion() {
        return id_institucion;
    }
    public boolean getvisitaRealizada() {
        return visitaRealizada;
    }
    public void setvisitaRealizada(boolean visitaRealizada) {
        this.visitaRealizada = visitaRealizada;
    }
    
    public void setId_institucion(int id_institucion) {
        this.id_institucion = id_institucion;
    }

    public int getId_usuarioAsigno() {
        return id_usuarioAsigno;
    }

    public void setId_usuarioAsigno(int id_usuarioAsigno) {
        this.id_usuarioAsigno = id_usuarioAsigno;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isVisitaRealizada() {
        return visitaRealizada;
    }

    public void setVisitaRealizada(boolean visitaRealizada) {
        this.visitaRealizada = visitaRealizada;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public UsuarioForm getListUsario() {
        return listUsario;
    }

    public void setListUsario(UsuarioForm listUsario) {
        this.listUsario = listUsario;
    }

    public InstitucionForm getListInstitucion() {
        return listInstitucion;
    }

    public void setListInstitucion(InstitucionForm listInstitucion) {
        this.listInstitucion = listInstitucion;
    }

    public UsuarioForm getListUsarioAsigno() {
        return listUsarioAsigno;
    }

    public void setListUsarioAsigno(UsuarioForm listUsarioAsigno) {
        this.listUsarioAsigno = listUsarioAsigno;
    }

   

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    
    
    
}
