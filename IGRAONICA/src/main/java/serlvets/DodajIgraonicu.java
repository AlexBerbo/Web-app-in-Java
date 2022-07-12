package serlvets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DodajIgraonicu
 */
@WebServlet("/DodajIgraonicu")
public class DodajIgraonicu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DodajIgraonicu() {
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
		String naziv=request.getParameter("naziv");
		String adresa=request.getParameter("adresa");
		String telefon=request.getParameter("telefon");
		int count=0;
		
		Connection con=null;
		Statement st, st2=null;
		ResultSet rs=null;
		ResultSet rsCount=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/igraonica", "root", "");
			
			st2=con.createStatement();
			String upit2="select * from igraonica";
			rsCount=st2.executeQuery(upit2);
			//rsCount.last();
			//count=rsCount.getRow();
			//rsCount.beforeFirst();
			
			while(rsCount.last()) {
				int idI=rsCount.getInt(1);
				st=con.createStatement();
				String upit="insert into igraonica values ('"+(idI+1)+"', '"+naziv+"', '"+adresa+"', '"+telefon+"', '"+"Slika"+"')";
				st.executeUpdate(upit);
				request.setAttribute("poruka", "Uspesno ste dodali igraonicu!");
				request.getRequestDispatcher("AdminWelcome.jsp").forward(request, response);
			}
			
			
		} catch (Exception e) {
			request.setAttribute("poruka", "Greska u radu sa bazom");
			request.getRequestDispatcher("AdminWelcome.jsp").forward(request, response);
		}
	}

}
