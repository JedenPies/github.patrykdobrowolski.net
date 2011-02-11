package pl.jedenpies.blog.db.hibernate.assembler;

import pl.jedenpies.blog.db.hibernate.ds.WpisDs;
import pl.jedenpies.blog.domain.Wpis;

public class WpisAssembler implements Assembler<Wpis, WpisDs> {

	@Override
	public void copyDataDs2Dto(WpisDs ds, Wpis dto) {		
		dto.setData(ds.getData());
		dto.setId(ds.getId());
		dto.setTresc(ds.getTresc());
		dto.setTytul(ds.getTytul());
	}

	@Override
	public void copyDataDto2Ds(Wpis dto, WpisDs ds) {		
		ds.setData(dto.getData());
		ds.setId(dto.getId());
		ds.setTresc(dto.getTresc());
		ds.setTytul(dto.getTytul());
	}

	@Override
	public Wpis ds2Dto(WpisDs ds) {
		Wpis dto = new Wpis();
		copyDataDs2Dto(ds, dto);
		return dto;
	}

	@Override
	public WpisDs dto2Ds(Wpis dto) {
		WpisDs ds = new WpisDs();
		copyDataDto2Ds(dto, ds);
		return ds;
	}

}
