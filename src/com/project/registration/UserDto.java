package com.project.registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDto {
	public static Connection getConnection(){  
		Connection con=null;  
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vidya","root","swathi");  
		}catch(Exception e){System.out.println(e);}  
		return con;  
	} 

	public static int save(User e){  
		int status=0;  
		try{  
			Connection con=getConnection();  
			PreparedStatement ps=con.prepareStatement(  
					"insert into user(username,password,email,girlfriendname) values (?,?,?,?)");  
			ps.setString(1,e.getUserName());  
			ps.setString(2,e.getPassword());  
			ps.setString(3,e.getEmail());  
			ps.setString(4,e.getGirlFriendName());  

			status=ps.executeUpdate();  

			con.close();  
		}catch(Exception ex){ex.printStackTrace();}  

		return status;  
	}  

	public static int update(User e, String userName){  
		int status=0;  
		try{  
			Connection con=getConnection();  
			PreparedStatement ps=con.prepareStatement(  
					"update user set username=?,password=?,email=?,girlfriendname=? where username=?");  
			ps.setString(1,e.getUserName());  
			ps.setString(2,e.getPassword());  
			ps.setString(3,e.getEmail());  
			ps.setString(4,e.getGirlFriendName()); 
			ps.setString(5,userName); 

			status=ps.executeUpdate();  

			con.close();  
		}catch(Exception ex){ex.printStackTrace();}  

		return status;  
	}  
	public static int delete(String userName){  
		int status=0;  
		try{  
			Connection con=getConnection();  
			PreparedStatement ps=con.prepareStatement("delete from user where username=?");  
			ps.setString(1,userName);  
			status=ps.executeUpdate();  

			con.close();  
		}catch(Exception e){e.printStackTrace();}  

		return status;  
	}  
	public static User getUserById(String userName){  
		User e= new User(); 

		try{  
			Connection con=getConnection();  
			PreparedStatement ps=con.prepareStatement("select * from user where userName=?");  
			ps.setString(1,userName);  
			ResultSet rs=ps.executeQuery();  
			if(rs.next()){  
				e.setUserName(rs.getString(1));  
				e.setPassword(rs.getString(2));  
				e.setEmail(rs.getString(3));  
				e.setGirlFriendName(rs.getString(4));  
			}  
			con.close();  
		}catch(Exception ex){ex.printStackTrace();}  

		return e;  
	}  
	public static List<User> getAllUser(){  
		List<User> list=new ArrayList<User>();  

		try{  
			Connection con=getConnection();  
			PreparedStatement ps=con.prepareStatement("select * from user");  
			ResultSet rs=ps.executeQuery();  
			while(rs.next()){  
				User e=new User();  
				e.setUserName(rs.getString(1));  
				e.setPassword(rs.getString(2));  
				e.setEmail(rs.getString(3));  
				e.setGirlFriendName(rs.getString(4));  
				list.add(e);  
			}  
			con.close();  
		}catch(Exception e){e.printStackTrace();}  

		return list;  
	}  
}  

