package serlvets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RezervacijaFinalna
 */
@WebServlet("/RezervacijaFinalna")
public class RezervacijaFinalna extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RezervacijaFinalna() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String datum=request.getParameter("datum");
		int cena=Integer.parseInt(request.getParameter("cena"));
		int vreme=Integer.parseInt(request.getParameter("vreme"));
		int poeni=Integer.parseInt(request.getParameter("poeni"));
		int korisnik=Integer.parseInt(request.getParameter("idkorisnik"));
		int paket=Integer.parseInt(request.getParameter("idpaket"));
		int igraonica=Integer.parseInt(request.getParameter("idigraonica"));
		int novipoeni=Integer.parseInt(request.getParameter("poeninovi"));
		int staripoeni=Integer.parseInt(request.getParameter("poenistari"));
		int racun= 0;
		int popust;
		Connection con=null;
		Statement st1, st2= null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/igraonica", "root", "");
			st1=con.createStatement();
			st2=con.createStatement();
			if(poeni==0) {
				racun=cena;
				staripoeni=staripoeni+novipoeni;
				
				String upit1="insert into rezervation values (null, '"+datum+"','"+vreme+"', '"+korisnik+"', '"+igraonica+"', '"+paket+"', '"+racun+"')";
				st1.executeUpdate(upit1);
				st1.close();
					
				String upit2="update korisnik set points='"+staripoeni+"' where id='"+korisnik+"';";
				st2.executeUpdate(upit2);
				
				st2.close();
				con.close();
				request.setAttribute("poruka", "Uspesno te rezervisali igraonicu! Ulogujte se opet da nastavite rad na sajtu");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			else {
				popust=(cena*poeni)/100;
				racun=cena-popust;
				staripoeni=(staripoeni-poeni)+novipoeni;
				
				String upit1="insert into rezervation values (null, '"+datum+"','"+vreme+"', '"+korisnik+"', '"+igraonica+"', '"+paket+"', '"+racun+"')";
				st1.executeUpdate(upit1);
				st1.close();
				
				String upit2="update korisnik set points='"+staripoeni+"' where id='"+korisnik+"';";
				st2.executeUpdate(upit2);
				
				st2.close();
				con.close();
				request.setAttribute("poruka", "Uspesno te rezervisali igraonicu! Ulogujte se opet da nastavite rad na sajtu");
				request.getRequestDispatcher("index.jsp").forward(request, response);
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
