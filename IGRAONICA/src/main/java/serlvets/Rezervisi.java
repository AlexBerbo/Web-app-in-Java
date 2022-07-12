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
import javax.servlet.http.HttpSession;

import beans.Korisnik;
import beans.Paket;

/**
 * Servlet implementation class Rezervisi
 */
@WebServlet("/Rezervisi")
public class Rezervisi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Rezervisi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("korisnik");
		int id=Integer.parseInt(request.getParameter("id"));
		if(username==null || username.length()==0) {
			request.setAttribute("poruka", "Morate se prvo ulogovati");
			session.invalidate();
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		else {
			Connection con=null;
			Statement st, st1=null;
			ResultSet rs, rs1=null;
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/igraonica", "root", "");
				st=con.createStatement();
				String upit="select * from paket where idpaket='"+id+"';";
				rs=st.executeQuery(upit);
				while(rs.next()) {
					Paket paket=new Paket(id, rs.getString("naziv"), rs.getString("opis"), rs.getInt("cena"), rs.getInt("bodovi"), rs.getInt("idigraonica"));
					request.setAttribute("Paket", paket);
				}
				st1=con.createStatement();
				String upit1="select * from korisnik where username='"+username+"';";
				rs1=st1.executeQuery(upit1);
				while(rs1.next()) {
					Korisnik korisnik=new Korisnik(rs1.getInt("id"), rs1.getString("ime"), rs1.getString("prezime"), rs1.getString("username"), rs1.getString("email"), rs1.getString("password"),
							rs1.getInt("points"));
					request.setAttribute("KorisnikRez", korisnik);
				}
				st.close();
				st1.close();
				con.close();
				request.getRequestDispatcher("FormaZaRez.jsp").forward(request, response);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
