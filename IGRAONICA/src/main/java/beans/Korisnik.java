package beans;

public class Korisnik {
	
	private int id;
	private String ime;
	private String prezime;
	private String username;
	private String email;
	private String password;
	private int points;
	
	public Korisnik() {
		id=0;
		ime="";
		prezime="";
		username="";
		email="";
		password="";
		points=0;
	}
	
	public Korisnik(int id, String ime, String prezime, String username, String email, String password, int points) {
		super();
		this.id=id;
		this.ime=ime;
		this.prezime=prezime;
		this.username=username;
		this.email=email;
		this.password=password;
		this.points=points;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
	
}
