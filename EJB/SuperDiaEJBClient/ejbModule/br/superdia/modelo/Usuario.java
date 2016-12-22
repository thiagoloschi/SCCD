package br.superdia.modelo;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "usuario_id", sequenceName = "usuario_seq", allocationSize = 1)
	@GeneratedValue(generator = "usuario_id", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(nullable = false, length = 40)
	private String usuario;

	@Column(nullable = false)
	private String senha;

	@Column(nullable = false)
	private String perfil;

	private String token;

	public Usuario() {
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		/*
		 * String senhaCriptografada = null; MessageDigest algorithm; try {
		 * algorithm = MessageDigest.getInstance("SHA-256"); byte
		 * messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));
		 * 
		 * senhaCriptografada = new String(messageDigest,
		 * StandardCharsets.UTF_8); } catch (NoSuchAlgorithmException |
		 * UnsupportedEncodingException e) { e.printStackTrace(); }
		 */

		// MERDA DE CRIPTOGRAFIA...

		this.senha = senha;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void setToken(String token){
		this.token = token;
	}
	
	public String getToken() {
		return token;
	}

	public String generateToken() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String token = this.usuario + ":" + this.senha + ":" + this.perfil;

		
			MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
	        byte messageDigest[] = algorithm.digest(token.getBytes("UTF-8"));
	         
	        StringBuilder hexString = new StringBuilder();
	        for (byte b : messageDigest) {
	          hexString.append(String.format("%02X", 0xFF & b));
	        }
	        String senhahex = hexString.toString();
	        
	        this.token = senhahex;
	        return senhahex;
	}

}
