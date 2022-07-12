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
import javax.servlet.http.HttpSession;

import beans.Korisnik;

/**
 * Servlet implementation class PromeniSifru
 */
@WebServlet("/PromeniSifru")
public class PromeniSifru extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PromeniSifru() {
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
		HttpSession session=request.getSession();
		Korisnik korisnik=(Korisnik)session.getAttribute("korisnik");
		String username=request.getParameter("username1");
		String noviPw=request.getParameter("password1");
		String potvrdiPw=request.getParameter("password2");
		
		if(username.isEmpty() || noviPw.isEmpty() || potvrdiPw.isEmpty()) {
			request.setAttribute("poruka", "Morate uneti sva polja");
			request.getRequestDispatcher("PromenaSifre.jsp").forward(request, response);	
		}
		else if(noviPw.equals(potvrdiPw)){
			try {
				Connection con=null;
				Statement st=null;
				ResultSet rs=null;
				
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/igraonica", "root", "");
				
				try {
					st=con.createStatement();
					String upit="select * from korisnik where username='"+username+"';";
					rs=st.executeQuery(upit);
					if(rs.next()==true) {
						String upit1="update korisnik set password='"+noviPw+"' where username='"+username+"';";
						st=con.createStatement();
						st.executeUpdate(upit1);
						st.close();
						con.close();
						request.setAttribute("poruka", "Uspesno ste promenili sifru");
						request.getRequestDispatcher("Login.jsp").forward(request, response);
					}
					else{
						request.setAttribute("poruka", "Uneti username ne postoji");
						request.getRequestDispatcher("PromenaSifre.jsp").forward(request, response);
					}
					
				} catch(Exception e) {
					
				}
				
			} catch(Exception e) {
				request.setAttribute("poruka", "Greska");
				request.getRequestDispatcher("PromenaSifre.jsp").forward(request, response);
			}
		}
		else {
			request.setAttribute("poruka", "Sifre se ne poklapaju");
			request.getRequestDispatcher("PromenaSifre.jsp").forward(request, response);
		}
	}

}
