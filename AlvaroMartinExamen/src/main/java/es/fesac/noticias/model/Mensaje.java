package es.fesac.noticias.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Mensajes")
public class Mensaje {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Lob
	private String contenido;

	@ManyToOne
	private Usuario usuario;
	
	@OneToMany
	private ArrayList<Comentario> comentarios;
	
}
