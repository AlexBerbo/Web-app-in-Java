package beans;

public class Paket {
	
	private int idpaket;
	private String naziv;
	private String opis;
	private int cena;
	private int bodovi;
	private int idigraonica;
	
	public Paket() {
		idpaket=0;
		naziv="";
		opis="";
		cena=0;
		bodovi=0;
		idigraonica=0;
	}
	
	public Paket(int idpaket, String naziv, String opis, int cena, int bodovi, int idigraonica) {
		super();
		this.idpaket=idpaket;
		this.naziv=naziv;
		this.opis=opis;
		this.cena=cena;
		this.bodovi=bodovi;
		this.idigraonica=idigraonica;
	}
	
	public int getIdpaket() {
		return idpaket;
	}
	public void setIdpaket(int idpaket) {
		this.idpaket = idpaket;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public int getCena() {
		return cena;
	}
	public void setCena(int cena) {
		this.cena = cena;
	}
	public int getBodovi() {
		return bodovi;
	}
	public void setBodovi(int bodovi) {
		this.bodovi = bodovi;
	}
	public int getIdigraonica() {
		return idigraonica;
	}
	public void setIdigraonica(int idigraonica) {
		this.idigraonica = idigraonica;
	}
	
	
}
