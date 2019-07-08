package dao;

import java.util.List;

import vo.Poster;

public interface PosterDao {
	public int addPoster(Poster m);
	public List<Poster> selects();
	public int delete(Poster m);
	public int update(Poster m);
	public Poster selectone(Poster m);
}
