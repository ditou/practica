package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "LIBROS")
public class Libro {
	
	

	@Id
	@Column(name="LIBRO_ID")
	private Long id;
	
	@Column(name="TITULO")
	private String titulo;
	
	//el lazy no carga la base de datos al menos que lo pidan
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "AUTOR_ID")
	private Autor autor;
	
	
	public Libro () {
		
	}
	
	public Libro(Long id, String titulo, Autor autor) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public Autor getAutor() {
		return autor;
	}


	public void setAutor(Autor autor) {
		this.autor = autor;
	}


	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + "]";
	}
	
	
	
	

}
