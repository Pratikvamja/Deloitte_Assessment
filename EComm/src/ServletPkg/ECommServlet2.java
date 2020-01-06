package ServletPkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ECommDAO;
import Product.Product1;
import User.User1;


@WebServlet("/ECommServlet2")
public class ECommServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ECommDAO dao;
	PrintWriter out;
	Product1 p1;
	User1 u1;
	ResultSet res;
	public ECommServlet2()
	{
		dao= new ECommDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try
		{
			out=response.getWriter();
			String name=request.getParameter("name");
			res=dao.search(name);
			out.println("<table border=3><tr><th>Product Id</th><th>Product Name</th><th>Price</th><th>Category</th></tr>");
			while(res.next())
			{	
				out.println("<tr>");
				out.println("<td>"+res.getString("id")+"</td>");
				out.println("<td>"+res.getString("name")+"</td>");
				out.println("<td>"+res.getInt("price")+"</td>");
				out.println("<td>"+res.getString("category")+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out=response.getWriter();
		int uid=Integer.parseInt(request.getParameter("loginid"));
		String password=request.getParameter("pass");
		String email="";
		
		u1=new User1(uid, password, email);
		int ra=dao.validate(u1);
		if(ra>0)
			out.println("<font color=greenlogin Unsucccessfully.</font>");
		else{
			out.println("<font color=red>login successful</font></br>");
			out.println("search a product <a href='http://localhost:9080/EComm/searchForm.html'>Click Here</a></br>");
			out.println("list all products<a href='http://localhost:9080/EComm/productInfo.html'>Click Here</a></br>");
		}
		out.println("</br>To Go Back  <a href='http://localhost:9080/EComm/login.html'>Click Here</a>");
	}

}
