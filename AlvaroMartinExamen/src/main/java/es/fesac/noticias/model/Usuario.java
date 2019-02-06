package es.fesac.noticias.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnTransformer;

@Entity
public class Usuario {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String nombreUsuario;

    private String email;

    @ColumnTransformer(write=" MD5(?) ")
    private String password;
    
    
	
}
