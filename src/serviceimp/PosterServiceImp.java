package serviceimp;

import java.util.ArrayList;
import java.util.List;

import dao.PosterDao;
import daoimp.PosterDaoImp;
import service.PosterService;
import vo.Poster;

public class PosterServiceImp implements PosterService{
	PosterDao td=new PosterDaoImp();
	@Override
	public int addPoster(Poster m) {
		int a=0;
		a=td.addPoster(m);
		return a;
	}

	@Override
	public List<Poster> selects() {
		List<Poster> list=new ArrayList<Poster>();
		list=td.selects();
		return list;
	}

	@Override
	public int delete(Poster m) {
		int a=0;
		a=td.delete(m);
		return a;
	}

	@Override
	public int update(Poster m) {
		int a=0;
		a=td.update(m);
		return a;
	}

	@Override
	public Poster selectone(Poster p) {
		Poster tp=new Poster();
		tp=td.selectone(p);
		return tp;
	}

}
