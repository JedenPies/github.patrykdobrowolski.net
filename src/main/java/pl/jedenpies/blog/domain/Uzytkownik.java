package pl.jedenpies.blog.domain;

import pl.jedenpies.blog.util.MD5Encoder;

public class Uzytkownik implements Identifiable {

	private Integer id;
	private String email;
	private String haslo;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHasloHash() {
		return haslo;
	}
	public void setHasloHash(String haslo) {
		this.haslo = haslo;
	}
	public void setHaslo(String haslo) {
		this.haslo = MD5Encoder.encode(haslo);		
	}
}
