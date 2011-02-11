package pl.jedenpies.blog.db.hibernate.assembler;

import pl.jedenpies.blog.db.hibernate.ds.UzytkownikDs;
import pl.jedenpies.blog.domain.Uzytkownik;

public class UzytkownikAssembler {

	public static void copyData(UzytkownikDs ds, Uzytkownik dto) {
				
		dto.setEmail(ds.getEmail());
		dto.setHasloHash(ds.getHasloHash());
		dto.setId(ds.getId());		
	}
	
	public static void copyData(Uzytkownik dto, UzytkownikDs ds) {
		
		ds.setEmail(dto.getEmail());
		ds.setHasloHash(dto.getHasloHash());
		ds.setId(dto.getId());	
	}
	
	public static Uzytkownik ds2Dto(UzytkownikDs ds) {
		
		Uzytkownik result = new Uzytkownik();
		copyData(ds, result);
		return result;
	}
	
	public static UzytkownikDs dto2Ds(Uzytkownik dto) {
		
		UzytkownikDs result = new UzytkownikDs();
		copyData(dto, result);		
		return result;
	}
}
