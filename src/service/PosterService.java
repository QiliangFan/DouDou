package service;

import java.util.List;

import vo.Poster;

public interface PosterService {
	public int addPoster(Poster m);
	public List<Poster> selects();
	public int delete(Poster m);
	public int update(Poster m);
	public Poster selectone(Poster m);
}
