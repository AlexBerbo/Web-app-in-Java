package serlvets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
 * Servlet implementation class Registracija
 */
@WebServlet("/Registracija")
public class Registracija extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registracija() {
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
		//HttpSession session = request.getSession();
		
		String ime=request.getParameter("ime");
		String prezime=request.getParameter("prezime");
		String email=request.getParameter("email");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		int count=0;
		Korisnik korisnik=new Korisnik();
		
		Connection con=null;
		Statement st, st2=null;
		ResultSet rs, rsCount=null;
		ResultSetMetaData rsmd=null;
		
		if(ime!=null && ime.length()>0 && prezime!=null && prezime.length()>0 && email!=null && email.length()>0 && username!=null && username.length()>0 && password!=null && password.length()>0) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/igraonica", "root", "");
				st=con.createStatement();
				st2=con.createStatement();
				String upit="select * from korisnik where username='"+username+"';";
				String upit2="select * from korisnik";
				rs=st.executeQuery(upit);
				rsCount=st2.executeQuery(upit2);
				//rsCount.last();
				//count=rsCount.getRow();
				//rs.beforeFirst();
				
				if(rs.next()) {
					request.setAttribute("poruka", "Username vec postoji");
					request.getRequestDispatcher("Register.jsp").forward(request, response);
				}
				else {
					while(rsCount.last()) {
						int idK=rsCount.getInt(1);
						String upit1="insert into korisnik values('"+(idK+1)+"', '"+ime+"', '"+prezime+"', '"+username+"','"+email+"', '"+password+"', '"+0+"')";
						st.executeUpdate(upit1);
						request.setAttribute("poruka", "Uspesno ste se registrovali, ulogujte se!");
						request.getRequestDispatcher("Login.jsp").forward(request, response);
						korisnik.setId(idK+1);
						korisnik.setIme(ime);
						korisnik.setPrezime(prezime);
						korisnik.setEmail(email);
						korisnik.setUsername(username);
						korisnik.setPassword(password);
						
						st.close();
						con.close();
					}
				}
			} catch (SQLException e){
				//session.invalidate();
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
		else {
			request.setAttribute("poruka", "Niste popunili sva polja!");
			request.getRequestDispatcher("Register.jsp").forward(request, response);
		}
	}

}
