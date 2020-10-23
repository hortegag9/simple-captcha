package ejemplos.struts2.actions.dao;

import ejemplos.struts2.model.Usuario;

public class DaoUsuarioImpl {
	
	private Usuario user;
	
	public DaoUsuarioImpl() {
		
	}
	
	public boolean validarUsuario(String usuario, String clave) {
	
	user = new Usuario();
	user.setUsuario("captcha");
	user.setPassword("clave");

		
		if((usuario.equals(user.getUsuario())) && (clave.equals(user.getPassword()))) {
			return true;
		}
			
		return false;
	}

}
