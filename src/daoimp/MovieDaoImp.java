package daoimp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.MovieDao;
import vo.Movie;
import db.Shujuku;

public class MovieDaoImp implements MovieDao{
	Connection con=null;
	PreparedStatement ps=null;
	Statement st=null;
	ResultSet rs=null;
	@Override
	public int addMovie(Movie m) {
		int a=0;
		try {
			//连接数据库
			con=Shujuku.conn();
			String sql="insert into movie values(?,?,?,?,?,?,?,?,?,?)";   //设置id自增
			ps=con.prepareStatement(sql);
			ps.setString(1, m.getMovieName());
			ps.setString(2, m.getTime());
			ps.setString(3, m.getCountry());
			ps.setString(4, m.getScreenwriter());
			ps.setString(5, m.getMoviekind());
			ps.setString(6, m.getDirector());
			ps.setDouble(7, m.getGrade());
			ps.setDouble(8, m.getNumOfPeople());
			ps.setInt(9, m.getPrice());
			ps.setString(10, m.getActor());
			System.out.println(m.getMovieName());
			a=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public List<Movie> selects() {
		// TODO Auto-generated method stub
		List<Movie> list=new ArrayList<Movie>();
		try {
			//连接数据库
			con=Shujuku.conn();
			String sql="select * from movie";
			st = con.createStatement();
			rs=st.executeQuery(sql); 
			while(rs.next()){
				Movie ty=new Movie();
				ty.setActor(rs.getString("actor"));
				ty.setCountry(rs.getString("country"));
				ty.setTime(rs.getString("time"));
				ty.setDirector(rs.getString("director"));
				ty.setGrade(rs.getDouble("grade"));
				ty.setMoviekind(rs.getString("moviekind"));
				ty.setMovieName(rs.getString("movieName"));
				ty.setNumOfPeople(rs.getDouble("numOfPeople"));
				ty.setScreenwriter(rs.getString("screenwriter"));
				ty.setPrice(rs.getInt("price"));
				list.add(ty);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(list.isEmpty());
		return list;
	}

	@Override
	public int delete(Movie m) {
		int a=0;		
		try {
			con=Shujuku.conn();
			String sql="delete from movie where movieName='"+m.getMovieName()+"'";
			System.out.println(sql);
			ps=con.prepareStatement(sql);
			a=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public int update(Movie m) {
		int a=0;
		try {
			con=Shujuku.conn();
			String sql="update movie set time=?,country=?,screenwriter=?,moviekind=?,director=?,grade=?,numOfPeople=?,price=?,actor=? where movieName=?";
			ps=con.prepareStatement(sql);
			ps.setString(10, m.getMovieName());
			ps.setString(1, m.getTime());
			ps.setString(2, m.getCountry());
			ps.setString(3, m.getScreenwriter());
			ps.setString(4, m.getMoviekind());
			ps.setString(5, m.getDirector());
			ps.setDouble(6, m.getGrade());
			ps.setDouble(7, m.getNumOfPeople());
			ps.setInt(8, m.getPrice());
			ps.setString(9, m.getActor());
			System.out.println(m.getMovieName());
			a=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public Movie selectone(Movie m) {
		Movie tp=new  Movie();
		try {
			con=Shujuku.conn();
			String sql="select * from movie where movieName=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, m.getMovieName());
			rs=ps.executeQuery();
			if(rs.next()){
				tp.setMovieName(rs.getString("moviename"));
				tp.setActor(rs.getString("actor"));
				tp.setCountry(rs.getString("country"));
				tp.setTime(rs.getString("time"));
				tp.setDirector(rs.getString("director"));
				tp.setGrade(rs.getDouble("grade"));
				tp.setMoviekind(rs.getString("moviekind"));
				tp.setNumOfPeople(rs.getDouble("numOfPeople"));
				tp.setScreenwriter(rs.getString("screenwriter"));
				tp.setPrice(rs.getInt("price"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return tp;
	}

	@Override
	public List<Movie> selects2() {
		List<Movie> list=new ArrayList<Movie>();
		try {
			//连接数据库
			con=Shujuku.conn();
			String sql="SELECT * FROM movie where (select (UNIX_TIMESTAMP((select DATE(CURDATE()))) - UNIX_TIMESTAMP(time))/(60*60*24) dif_minute)<30 order by time DESC;";
			st = con.createStatement();
			rs=st.executeQuery(sql); 
			while(rs.next()){
				Movie ty=new Movie();
				ty.setActor(rs.getString("actor"));
				ty.setCountry(rs.getString("country"));
				ty.setTime(rs.getString("time"));
				ty.setDirector(rs.getString("director"));
				ty.setGrade(rs.getDouble("grade"));
				ty.setMoviekind(rs.getString("moviekind"));
				ty.setMovieName(rs.getString("movieName"));
				ty.setNumOfPeople(rs.getDouble("numOfPeople"));
				ty.setScreenwriter(rs.getString("screenwriter"));
				list.add(ty);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(list.isEmpty());
		return list;
	}

}
