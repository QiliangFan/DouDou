package serviceimp;

import java.util.ArrayList;
import java.util.List;

import dao.FilmReviewDao;
import daoimp.FilmReviewDaoImp;
import service.FilmReviewService;
import vo.FilmReview;

public class FilmReviewServiceImp implements FilmReviewService{
	FilmReviewDao frd=new FilmReviewDaoImp();
	@Override
	public int addFilmReview(FilmReview m) {
		int a=0;
		a=frd.addFilmReview(m);
		return a;
	}

	@Override
	public List<FilmReview> selects() {
		List<FilmReview> list=new ArrayList<FilmReview>();
		list=frd.selects();
		return list;
	}

	@Override
	public int delete(FilmReview m) {
		int a=0;
		a=frd.delete(m);
		return a;
	}

	@Override
	public int update(FilmReview m) {
		int a=0;
		a=frd.update(m);
		return a;
	}

	@Override
	public FilmReview selectone(FilmReview m) {
		FilmReview tp=new FilmReview();
		tp=frd.selectone(m);
		return tp;
	}

}
