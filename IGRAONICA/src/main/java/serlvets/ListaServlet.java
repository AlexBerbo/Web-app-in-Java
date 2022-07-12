package serlvets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Igraonica;
import beans.Korisnik;
import beans.Manager;

/**
 * Servlet implementation class ListaServlet
 */
@WebServlet("/ListaServlet")
public class ListaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ispis=request.getParameter("ispis");
		Connection con=null;
		Statement st=null;
		ResultSet rs1=null;
		ResultSet rs2=null;
		ArrayList<Korisnik>korisniks=new ArrayList<Korisnik>();
		ArrayList<Manager>managers=new ArrayList<Manager>();
		ArrayList<Igraonica>igraonicas=new ArrayList<Igraonica>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/igraonica", "root", "");
			st=con.createStatement();
			if(ispis.equals("igraonica")) {
				String upit="select * from igraonica;";
				rs1=st.executeQuery(upit);
				while(rs1.next()) {
					igraonicas.add(new Igraonica(rs1.getInt("idigraonica"), rs1.getString("naziv"), rs1.getString("adresa"), rs1.getString("telefon"), rs1.getString("slika")));
					request.setAttribute("Igraonice", igraonicas);
				}
				request.getRequestDispatcher("ListaIgraonica.jsp").forward(request, response);
			}
			else if(ispis.equals("menadzer")) {
				String upit1="select * from manager;";
				rs2=st.executeQuery(upit1);
				while(rs2.next()) {
					managers.add(new Manager(rs2.getInt("idmanager"), rs2.getString("ime"), rs2.getString("prezime"), rs2.getString("username"), rs2.getString("password"), rs2.getInt("idigraonica")));
					request.setAttribute("Menadzeri", managers);
				}
				request.getRequestDispatcher("ListaMenadzera.jsp").forward(request, response);
			}
			else if(ispis.equals("korisnik")) {
				String upit2="select * from korisnik;";
				rs2=st.executeQuery(upit2);
				while(rs2.next()) {
					korisniks.add(new Korisnik(rs2.getInt("id"), rs2.getString("ime"), rs2.getString("prezime"), rs2.getString("username"), rs2.getString("email"), rs2.getString("password"), rs2.getInt("points")));
					request.setAttribute("Korisnici", korisniks);
				}
				request.getRequestDispatcher("ListaKorisnik.jsp").forward(request, response);
			}
		}catch(Exception e) {
			
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
