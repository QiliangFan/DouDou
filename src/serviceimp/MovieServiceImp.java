package serviceimp;

import java.util.ArrayList;
import java.util.List;

import dao.MovieDao;
import daoimp.MovieDaoImp;
import service.MovieService;
import vo.Movie;

public class MovieServiceImp implements MovieService{

	MovieDao td=new MovieDaoImp();
	@Override
	public int addMovie(Movie m) {//注意返回数据不要忘记修改
		int a=0;
		a=td.addMovie(m);
		return a;
	}

	@Override
	public List<Movie> selects() {
		List<Movie> list=new ArrayList<Movie>();
		list=td.selects();
		return list;
	}

	@Override
	public int delete(Movie m) {
		int a=0;
		a=td.delete(m);
		return a;
	}

	@Override
	public int update(Movie m) {
		int a=0;
		a=td.update(m);
		return a;
	}

	@Override
	public Movie selectone(Movie m) {
		Movie tp=new Movie();
		tp=td.selectone(m);
		return tp;
	}

	@Override
	public List<Movie> selects2() {
		List<Movie> list=new ArrayList<Movie>();
		list=td.selects2();
		return list;
	}

}
