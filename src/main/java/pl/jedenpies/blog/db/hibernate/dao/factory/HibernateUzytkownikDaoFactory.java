package pl.jedenpies.blog.db.hibernate.dao.factory;

import pl.jedenpies.blog.dao.GenericDao;
import pl.jedenpies.blog.db.hibernate.assembler.Assembler;
import pl.jedenpies.blog.db.hibernate.dao.HibernateGenericDao;
import pl.jedenpies.blog.db.hibernate.ds.UzytkownikDs;
import pl.jedenpies.blog.domain.Uzytkownik;

public class HibernateUzytkownikDaoFactory implements HibernateConcreteDaoFactory {

	@Override
	public GenericDao<Uzytkownik> create() {		
		Assembler<Uzytkownik, UzytkownikDs> assembler = new UzytkownikAssembler();
		GenericDao<Uzytkownik> r = new HibernateGenericDao<Uzytkownik, UzytkownikDs>(assembler, UzytkownikDs.class);			
		return r;
	}
	
	private static class UzytkownikAssembler implements Assembler<Uzytkownik, UzytkownikDs> {

		@Override
		public void copyDataDs2Dto(UzytkownikDs ds, Uzytkownik dto) {					
			dto.setEmail(ds.getEmail());
			dto.setHasloHash(ds.getHasloHash());
			dto.setId(ds.getId());		
		}
		@Override
		public void copyDataDto2Ds(Uzytkownik dto, UzytkownikDs ds) {			
			ds.setEmail(dto.getEmail());
			ds.setHasloHash(dto.getHasloHash());
			ds.setId(dto.getId());	
		}
		@Override
		public Uzytkownik ds2Dto(UzytkownikDs ds) {			
			Uzytkownik result = new Uzytkownik();
			copyDataDs2Dto(ds, result);
			return result;
		}
		@Override
		public UzytkownikDs dto2Ds(Uzytkownik dto) {			
			UzytkownikDs result = new UzytkownikDs();
			copyDataDto2Ds(dto, result);		
			return result;
		}
	}
}
