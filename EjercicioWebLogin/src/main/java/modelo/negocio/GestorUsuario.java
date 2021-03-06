package modelo.negocio;

import modelo.entidad.Usuario;
import modelo.persistencia.DaoUsuarioMySql;
import modelo.persistencia.interfaz.DaoUsuario;

public class GestorUsuario {
	
	private DaoUsuario daoUsuario = new DaoUsuarioMySql();
	
	public boolean estaRegistrado(String nombre, String contraseņa) {
		Usuario u = daoUsuario.buscarPorCredenciales(nombre, contraseņa);
		
		if(u==null) {
			return false;
		}else{
			return true;
		}
	}
	
}
