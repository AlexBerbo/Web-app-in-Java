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
import javax.servlet.http.HttpSession;

import beans.Korisnik;
import beans.Rezervation;

/**
 * Servlet implementation class MojNalog
 */
@WebServlet("/MojNalog")
public class MojNalog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MojNalog() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("korisnik");
		ArrayList<Rezervation>rezervations=new ArrayList<Rezervation>();
		
		if(username.length()==0 || username==null) {
			request.setAttribute("poruka", "Morate se prvo ulogovati!");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else {
			Connection con=null;
			Statement st, st1=null;
			ResultSet rs, rs1=null;
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/igraonica", "root", "");
				
				st=con.createStatement();
				String upit="select * from korisnik where username='"+username+"';";
				rs=st.executeQuery(upit);
				while(rs.next()) {
					Korisnik korisnik=new Korisnik(rs.getInt("id"), rs.getString("ime"), rs.getString("prezime"), rs.getString("username"), rs.getString("email"), rs.getString("password"), rs.getInt("points"));
					request.setAttribute("korisnikMojNalog", korisnik);
					
					st1=con.createStatement();
					String upit1="select * from rezervation where idkorisnik='"+rs.getInt("id")+"';";
					rs1=st1.executeQuery(upit1);
					while(rs1.next()) {
						rezervations.add(new Rezervation(rs1.getInt("idrez"), rs1.getDate("datum"), rs1.getInt("vreme"), rs1.getInt("idkorisnik"), 
								rs1.getInt("idigraonica"), rs1.getInt("idpaket"), rs1.getInt("racun")));
						request.setAttribute("rezervationsMojNalog", rezervations);
					}
					if(rezervations.isEmpty()) {
						st.close();
						st1.close();
						con.close();
						request.getRequestDispatcher("MojNalogPrazneRez.jsp").forward(request, response);
					}
					else {
						st.close();
						st1.close();
						con.close();
						request.getRequestDispatcher("MojNalogPuneRez.jsp").forward(request, response);
					}
				}
			} catch (SQLException e){
				session.invalidate();
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
