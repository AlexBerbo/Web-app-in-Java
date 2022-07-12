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

import beans.Rezervation;

/**
 * Servlet implementation class ManagerIzmenaRezervacije
 */
@WebServlet("/ManagerIzmenaRezervacije")
public class ManagerIzmenaRezervacije extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerIzmenaRezervacije() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/igraonica", "root", "");
			st=con.createStatement();
			String upit="select * from rezervation where idrez='"+id+"';";
			rs=st.executeQuery(upit);
			while(rs.next()) {
				Rezervation rezervacija=new Rezervation(id, rs.getDate("datum"), rs.getInt("vreme"), rs.getInt("idkorisnik"), rs.getInt("idigraonica"), rs.getInt("idpaket"), rs.getInt("racun"));
				request.setAttribute("RezervacijaIzmena", rezervacija);
				request.getRequestDispatcher("ManagerIzmenaRezervacije.jsp").forward(request, response);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("IDRezervacije"));
		String datum=request.getParameter("DatumRezervacije");
		int vreme=Integer.parseInt(request.getParameter("VremeRezervacije"));
		int idkorisnik=Integer.parseInt(request.getParameter("IDKorisnik"));
		int idigraonica=Integer.parseInt(request.getParameter("IDIgraonica"));
		int idpaket=Integer.parseInt(request.getParameter("IDPaket"));
		int racun=Integer.parseInt(request.getParameter("RacunRezervacije"));
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		if(vreme>24 || vreme<0) {
			request.setAttribute("poruka", "Pogresno unet format vremena!");
			request.getRequestDispatcher("ManagerWelcome.jsp").forward(request, response);
		}
		else {
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/igraonica", "root", "");
				String upit="update rezervation set idrez='"+id+"', datum='"+datum+"', vreme='"+vreme+"', idkorisnik='"+idkorisnik+"', idigraonica='"+idigraonica+"', "
						+ "idpaket='"+idpaket+"', racun='"+racun+"' where idrez='"+id+"';";
				st=con.createStatement();
				st.executeUpdate(upit);
				st.close();
				con.close();
				request.setAttribute("poruka", "Uspesno izmenjena rezervacija");
				request.getRequestDispatcher("ManagerWelcome.jsp").forward(request, response);
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

}
