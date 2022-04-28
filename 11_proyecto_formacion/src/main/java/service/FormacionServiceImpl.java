package service;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.AlumnosDao;
import dao.CursosDao;
import model.Alumno;
import model.Curso;

@Service
public class FormacionServiceImpl implements FormacionService {

	CursosDao cursosDao;
	
	AlumnosDao alumnosDao;
	
	public FormacionServiceImpl(@Autowired AlumnosDao alumnosDao, @Autowired CursosDao cursosDao) {
		this.alumnosDao = alumnosDao;
		this.cursosDao = cursosDao;
	}

	@Override
	public Alumno validarUsuario(String usuario, String password) {
		try{
			return alumnosDao.findByUsuarioAndPassword(usuario, password);
		}catch(NoResultException e){
			return null;
		}
	}

	@Override
	public List<Curso> cursosDelAlumno(String usuario) {
		return cursosDao.findByAlumno(usuario);
	}

	@Override
	public List<Curso> findAllCursos() {
		return cursosDao.findAll();
	}
	
	@Override
	public List<Alumno> findAllAlumnos() {
		return alumnosDao.findAll();
	}

	@Override
	public List<Alumno> alumnosDelCurso(String curso) {
		return alumnosDao.findByCurso(curso);
	}

	@Override
	public boolean matricular(String usuario, int idCurso) {
		Curso curso = cursosDao.findById(idCurso);
		Alumno alumno = alumnosDao.findById(usuario);
		if(curso!=null&&alumno!=null) {
			alumno.getCursos().add(curso);
			alumnosDao.update(alumno);
			return true;
		}
		return false;
	}

}
