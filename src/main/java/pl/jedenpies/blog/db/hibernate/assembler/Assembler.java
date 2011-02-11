package pl.jedenpies.blog.db.hibernate.assembler;

import pl.jedenpies.blog.db.hibernate.ds.HibernateIdentifiable;
import pl.jedenpies.blog.domain.Identifiable;

public interface Assembler<TDTO extends Identifiable, TDS extends HibernateIdentifiable> {

	public void copyDataDs2Dto(TDS ds, TDTO dto);	
	public void copyDataDto2Ds(TDTO dto, TDS ds);
	
	public TDTO ds2Dto(TDS ds);
	public TDS dto2Ds(TDTO dto);	
}
