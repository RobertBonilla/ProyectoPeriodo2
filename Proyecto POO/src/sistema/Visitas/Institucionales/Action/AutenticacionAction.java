package sistema.Visitas.Institucionales.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import sistema.Visitas.Institucionales.Form.AutenticacionForm;
import sistema.Visitas.Institucionales.Model.AutenticacionModel;


public class AutenticacionAction extends DispatchAction {
	
	public ActionForward autenticar(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {	
				AutenticacionModel aut = new AutenticacionModel();
		        AutenticacionForm datos = (AutenticacionForm) form;
		        if(aut.Validar(datos)){
		            return mapping.findForward("menu");
		        }else{
		            return mapping.findForward("login");
		        }
			}
	}

