package serlvets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Igraonica;

/**
 * Servlet implementation class DodajMenadzer
 */
@WebServlet("/DodajMenadzer")
public class DodajMenadzer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DodajMenadzer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		ArrayList<Igraonica>igraonicas=new ArrayList<Igraonica>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/igraonica", "root", "");
			st=con.createStatement();
			String upit="select * from igraonica";
			rs=st.executeQuery(upit);
			 while(rs.next()) {
				 igraonicas.add(new Igraonica(rs.getInt("idigraonica"), rs.getString("naziv"), rs.getString("adresa"), rs.getString("telefon"), rs.getString("slika")));
				 request.setAttribute("igraonica", igraonicas);
			 }
			 request.getRequestDispatcher("DodajMenadzera.jsp").forward(request, response);
		} catch(Exception e) {
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ime=request.getParameter("ime");
		String prezime=request.getParameter("prezime");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		int idigraonica=Integer.parseInt(request.getParameter("igraonica"));
		//int count=0;
		
		Connection con=null;
		Statement st, st2=null;
		ResultSet rs, rsCount=null;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/igraonica", "root", "");
			st=con.createStatement();
			st2=con.createStatement();
			String upit="select * from manager where username='"+username+"';";
			String upit1="select * from manager";
			rs=st.executeQuery(upit);
			rsCount=st2.executeQuery(upit1);
			//rsCount.last();
			//count=rsCount.getRow();
			//rsCount.beforeFirst();
			if(rs.next()) {
				request.setAttribute("poruka", "Menadzer sa tim username-om vec postoji!");
				request.getRequestDispatcher("AdminWelcome.jsp").forward(request, response);
			}
			else {
				while(rsCount.last()){
					int idM=rsCount.getInt(1);
					String upit2="insert into manager values ('"+(idM+1)+"', '"+ime+"', '"+prezime+"', '"+username+"', '"+password+"', '"+idigraonica+"')";
					st.executeUpdate(upit2);
					request.setAttribute("poruka", "Uspesno ste dodali Menadzera");
					request.getRequestDispatcher("AdminWelcome.jsp").forward(request, response);
						
					st.close();
					st2.close();
					con.close();
				}
			}
			
		} catch (SQLException e){
			String errormsg=e.getMessage();
			if(con!=null) {
				try {
					con.close();
				}catch (SQLException ex){
					errormsg+=ex.getMessage();
				}
				
			}
			request.setAttribute("errormsg", errormsg);
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}
		catch (ClassNotFoundException e) {
			request.setAttribute("poruka", "Nije ucitan drajver!: " + e);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
