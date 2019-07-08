package daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.FilmReviewDao;
import db.Shujuku;
import vo.FilmReview;

public class FilmReviewDaoImp implements FilmReviewDao{
	Connection con=null;
	PreparedStatement ps=null;
	Statement st=null;
	ResultSet rs=null;
	@Override
	public int addFilmReview(FilmReview m) {
		int a=0;
		try {
			//连接数据库
			con=Shujuku.conn();
			String sql="insert into filmreview values(?,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, m.getReview());
			ps.setString(2, m.getImageName());
			ps.setString(3, m.getReadnum());
			ps.setString(4, m.getAuthor());
			ps.setString(5, m.getMovieName());
			ps.setString(6, m.getTime());
			
			//System.out.println(m.getMovieName());
			a=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public List<FilmReview> selects() {
		List<FilmReview> list=new ArrayList<FilmReview>();
		try {
			//连接数据库
			con=Shujuku.conn();
			String sql="select * from filmreview";
			st = con.createStatement();
			rs=st.executeQuery(sql); 
			//System.out.println(sql);
			while(rs.next()){
				FilmReview fr=new FilmReview();
				fr.setAuthor(rs.getString("author"));
				fr.setImageName(rs.getString("imageName"));
				fr.setMovieName(rs.getString("movieName"));
				fr.setReadnum(rs.getString("readnum"));
				fr.setReview(rs.getString("review"));
				fr.setTime(rs.getString("time"));
				list.add(fr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(list.isEmpty());
		return list;
	}

	@Override
	public int delete(FilmReview m) {
		int a=0;		
		try {
			con=Shujuku.conn();
			String sql="delete from filmreview where movieName='"+m.getMovieName()+"' and author='"+m.getAuthor()+"' and time='"+m.getTime()+"'";
			//System.out.println(sql);
			ps=con.prepareStatement(sql);
			a=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public int update(FilmReview m) {
		int a=0;
		try {
			con=Shujuku.conn();
			String sql="update filmreview set review=?,imageName=?,readnum=? where author=? and movieName=? and time=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,m.getReview());
			ps.setString(2,m.getImageName());
			ps.setString(3, m.getReadnum());
			ps.setString(4,m.getAuthor());
			ps.setString(5, m.getMovieName());
			ps.setString(6,m.getTime());
			//System.out.println(m.getMovieName());
			a=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public FilmReview selectone(FilmReview m) {
		FilmReview fr=new  FilmReview();
		try {
			con=Shujuku.conn();
			String sql="select * from filmreview where author=? and movieName=? and time=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, m.getAuthor());
			ps.setString(2, m.getMovieName());
			ps.setString(3, m.getTime());
			rs=ps.executeQuery();
			if(rs.next()){
				fr.setAuthor(rs.getString("author"));
				fr.setImageName(rs.getString("imageName"));
				fr.setMovieName(rs.getString("movieName"));
				fr.setReadnum(rs.getString("readnum"));
				fr.setReview(rs.getString("review"));
				fr.setTime(rs.getString("time"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return fr;
	}
}
