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

import beans.Igraonica;

/**
 * Servlet implementation class DodajPaket
 */
@WebServlet("/DodajPaket")
public class DodajPaket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DodajPaket() {
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
			 request.getRequestDispatcher("DodajPaket.jsp").forward(request, response);
		} catch(Exception e) {
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("igraonica"));
		String naziv=request.getParameter("naziv");
		String opis=request.getParameter("opis");
		int cena=Integer.parseInt(request.getParameter("cena"));
		int bodovi=Integer.parseInt(request.getParameter("bodovi"));
		int count=0;
		
		Connection con=null;
		Statement st, st2=null;
		ResultSet rsCount, rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/igraonica", "root", "");
			st2=con.createStatement();
			String upit1="select * from paket";
			rsCount=st2.executeQuery(upit1);
			//rsCount.last();
			//count=rsCount.getRow();
			//rsCount.beforeFirst();
			while(rsCount.last()) {
				int idP=rsCount.getInt(1);
				st=con.createStatement();
				String upit="insert into paket values ('"+(idP+1)+"', '"+naziv+"', '"+opis+"', '"+cena+"', '"+bodovi+"', '"+id+"')";
				st.executeUpdate(upit);
				
				request.setAttribute("poruka", "Uspesno ste dodali novi paket");
				request.getRequestDispatcher("ManagerWelcome.jsp").forward(request, response);
				
				st2.close();
				st.close();
				con.close();
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
