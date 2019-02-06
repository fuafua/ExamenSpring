package es.fesac.noticias.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import es.fesac.noticias.model.Usuario;

public interface UserRepository extends CrudRepository<Usuario, Integer> {
	@Query(
	  value = "SELECT * FROM USER WHERE EMAIL = :email AND PASSWORD = MD5(:password)", 
	  nativeQuery = true
	  )
	public Usuario getByEmailAndPassword(String email, String password);
}
