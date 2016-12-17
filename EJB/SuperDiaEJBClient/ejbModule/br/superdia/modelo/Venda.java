package br.superdia.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Venda implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "venda_id", sequenceName = "venda_seq", allocationSize = 1)
	@GeneratedValue(generator = "venda_id", strategy = GenerationType.SEQUENCE)
	private Long id;
	@Temporal(TemporalType.DATE)
	private Calendar data;
	@OneToMany
	private List<Produto> produtos;
	@ManyToOne
	private Usuario usuario;
	
	
}

