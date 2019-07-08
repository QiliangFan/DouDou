package daoimp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.PosterDao;
import db.Shujuku;
import vo.Poster;

public class PosterDaoImp implements PosterDao{
	Connection con=null;
	PreparedStatement ps=null;
	Statement st=null;
	ResultSet rs=null;
	@Override
	public int addPoster(Poster m) {
		int a=0;
		try {
			//�������ݿ�
			con=Shujuku.conn();
			String sql="insert into Poster values(?,?,?)";   //����id����
			ps=con.prepareStatement(sql);
			ps.setString(1, m.getPicturename());
			ps.setString(2, m.getImage_address());
			ps.setString(3, m.getMovieName());
			
			System.out.println(m.getMovieName());
			a=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	@Override
	public List<Poster> selects() {
		List<Poster> list=new ArrayList<Poster>();
		try {
			//�������ݿ�
			con=Shujuku.conn();
			String sql="select * from Poster";
			st = con.createStatement();
			rs=st.executeQuery(sql); 
			while(rs.next()){
				Poster ty=new Poster();
				ty.setPicturename(rs.getString("picturename"));
				ty.setImage_address(rs.getString("image_address"));
				ty.setMovieName(rs.getString("movieName"));
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
	public int delete(Poster m) {
		int a=0;		
		try {
			con=Shujuku.conn();
			String sql="delete from Poster where movieName='"+m.getMovieName()+"'";
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
	public int update(Poster m) {
		int a=0;
		try {
			con=Shujuku.conn();
			String sql="update Poster set picturename=?,image_address=? where movieName=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, m.getPicturename());
			ps.setString(2, m.getImage_address());
			ps.setString(3, m.getMovieName());
			//System.out.println(m.getMovieName());
			a=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	@Override
	public Poster selectone(Poster m) {
		Poster tp=new  Poster();
		try {
			con=Shujuku.conn();
			String sql="select * from Poster where moviename=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, m.getMovieName());
			rs=ps.executeQuery();
			if(rs.next()){
				tp.setMovieName(rs.getString("moviename"));
				tp.setImage_address(rs.getString("image_address"));
				tp.setPicturename(rs.getString("picturename"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return tp;
	} 
}
