package pl.jedenpies.blog.db.hibernate.ds;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "wpisy")
public class WpisDs {

	@Id
	private Integer id;
		
	private Date data;
	private String tytul;
	private String tresc;
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getTytul() {
		return tytul;
	}
	public void setTytul(String tytul) {
		this.tytul = tytul;
	}
	public String getTresc() {
		return tresc;
	}
	public void setTresc(String tresc) {
		this.tresc = tresc;
	}
	public Integer getId() {
		return id;
	}
	
}
