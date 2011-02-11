package pl.jedenpies.blog.db.hibernate.ds;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "uzytkownicy")
public class UzytkownikDs {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)	
	private Integer id;	
	
	@Column(unique = true) 
	private String email;
	@Column(name = "haslo")
	private String hasloHash;
	
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
		return hasloHash;
	}

	public void setHasloHash(String hasloHash) {
		this.hasloHash = hasloHash;
	}
}
