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

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		String poruka, ime, prezime, email;
		int points;
		String username=request.getParameter("username1");
		String password=request.getParameter("password1");
		Korisnik korisnik=new Korisnik();
		korisnik.setUsername(username);
		korisnik.setPassword(password);
		session.setAttribute("korisnik", username);
		
		if(username.isEmpty() || password.isEmpty()) {
			poruka="Niste popunili sva polja!";
			request.setAttribute("poruka", poruka);
			request.getRequestDispatcher("Login.jsp").forward(request, response);	
		}
		
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/igraonica", "root", "");
			st=con.createStatement();
			String upit="select * from korisnik where username='"+username+"' and password='"+password+"';";
			rs=st.executeQuery(upit);
			if(rs.next()) {
				ime=rs.getString("ime");
				prezime=rs.getString("prezime");
				email=rs.getString("email");
				points=rs.getInt("points");
				korisnik.setIme(ime);
				korisnik.setPrezime(prezime);
				korisnik.setEmail(email);
				korisnik.setPoints(points);
				st.close();
				con.close();
			}
			else {
				poruka="Neispravno korisnicko ime ili password!";
				request.setAttribute("poruka", poruka);
				korisnik.setPassword("");
				st.close();
				con.close();
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
		}
		catch (SQLException e){
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
		
		request.setAttribute("poruka", "Login Succesful");
		request.getRequestDispatcher("Welcome.jsp").forward(request, response);
	}

}
