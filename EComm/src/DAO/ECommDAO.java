package DAO;
import java.sql.*;
import User.User1;
public class ECommDAO {

	Connection con;
	PreparedStatement pre;
	ResultSet res;
	
	public ECommDAO()
	{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","seed1234");
			System.out.println("Connection Successful");
		}
		catch(Exception e)
		{
			System.out.println("Exception in DAO class"+e);
		}
		
	}
	public int register(User1 u)
	{
		System.out.println("REGISTER");
		int ra=0;
		try
		{
			pre=con.prepareStatement("insert into user1 values(?,?,?)");
			pre.setInt(1, u.getLoginId());
			pre.setString(2,u.getPassword());
			pre.setString(3,u.getEmail());
			
			ra=pre.executeUpdate();
			//pre.close();
		
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return ra;
	}
	public int validate(User1 u)
	{
		int ra=0;
		{
			
			try
			{
				pre=con.prepareStatement("select * from user1");
				res=pre.executeQuery();
				while(res.next())
				{
					if(res.getInt("loginid")==u.getLoginId() && res.getString("password")==u.getPassword())
						{
							ra++;
						}
				}
				//pre.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return ra;
		}
	}
	public ResultSet retrieve()
	{
		System.out.println("DISPLAY ALL");
		try
		{
			
			pre=con.prepareStatement("select * from products");
			res=pre.executeQuery();
			//pre.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return res;
	}
	public ResultSet search(String name)
	{
		System.out.println("DISPLAY for Searched Product name");
		try
		{
			
			pre=con.prepareStatement("select * from products where name=?");
			pre.setString(1, name);
			res=pre.executeQuery();
			if(res.next()!=false)
				System.out.println("data retrieved...");
			//pre.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return res;
	}
	
}