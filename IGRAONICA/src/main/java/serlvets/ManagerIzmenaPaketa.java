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

import beans.Paket;

/**
 * Servlet implementation class ManagerIzmenaPaketa
 */
@WebServlet("/ManagerIzmenaPaketa")
public class ManagerIzmenaPaketa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerIzmenaPaketa() {
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
			String upit="select * from paket where idpaket='"+id+"';";
			rs=st.executeQuery(upit);
			while(rs.next()) {
				Paket paket=new Paket(id, rs.getString("naziv"), rs.getString("opis"), rs.getInt("cena"), rs.getInt("bodovi"), rs.getInt("idigraonica"));
				request.setAttribute("PaketIzmena", paket);
				request.getRequestDispatcher("ManagerIzmenaPaketa.jsp").forward(request, response);
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
		int id=Integer.parseInt(request.getParameter("IDPaketa"));
		String naziv=request.getParameter("Naziv");
		String opis=request.getParameter("Opis");
		int cena=Integer.parseInt(request.getParameter("Cena"));
		int bodovi=Integer.parseInt(request.getParameter("Bodovi"));
		int idigraonica=Integer.parseInt(request.getParameter("IDIgraonice"));
		
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/igraonica", "root", "");
			st=con.createStatement();
			String upit="update paket set idpaket='"+id+"', naziv='"+naziv+"', opis='"+opis+"', cena='"+cena+"', bodovi='"+bodovi+"', idigraonica='"+idigraonica+"' where idpaket='"+id+"';";
			st.executeUpdate(upit);
			st.close();
			con.close();
			request.setAttribute("poruka", "Uspesno ste azurirali paket!");
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
