package ejemplos.struts2.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import ejemplos.struts2.actions.dao.DaoUsuarioImpl;
import nl.captcha.Captcha;

public class AccionValidarCodigo extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
 		@Override
		public String execute() throws Exception {
 			
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
		HttpSession session = request.getSession();
		Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
		request.setCharacterEncoding("UTF-8");
		String parametroCaptcha = request.getParameter("captcha");
		String parametroUsuario= request.getParameter("usuario");
		String parametroPassword = request.getParameter("password");
		
		DaoUsuarioImpl daoUsuarioImpl = new DaoUsuarioImpl();
		boolean usuario = false;
		
		if (captcha.isCorrect(parametroCaptcha)) {
		    usuario = daoUsuarioImpl.validarUsuario(parametroUsuario, parametroPassword);
			if(usuario) {
				return SUCCESS;
			}else {
				addActionError("Usuario y/o clave incorrecto");
				return ERROR;
			}
		  
		} else {
		addActionError("Código inválido, trate nuevamente.");
		
		return ERROR;
		
	 }
		
	}	

}
