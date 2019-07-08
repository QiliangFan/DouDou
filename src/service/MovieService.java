package service;

import java.util.List;

import vo.Movie;

public interface MovieService {
	public int addMovie(Movie m);
	public List<Movie> selects();
	public int delete(Movie m);
	public int update(Movie m);
	public Movie selectone(Movie m);
	public List<Movie> selects2();
}
