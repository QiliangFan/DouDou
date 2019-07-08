package dao;

import java.util.List;

import vo.FilmReview;


public interface FilmReviewDao {
	public int addFilmReview(FilmReview m);
	public List<FilmReview> selects();
	public int delete(FilmReview m);
	public int update(FilmReview m);
	public FilmReview selectone(FilmReview m);
}
