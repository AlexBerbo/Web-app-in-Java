package beans;

public class Igraonica {

	private int idigraonica;
	private String naziv;
	private String adresa;
	private String telefon;
	private String slika;
	
	public Igraonica() {
		idigraonica=0;
		naziv="";
		adresa="";
		telefon="";
		slika="";
	}
	
	public Igraonica(int idigraonica, String naziv, String adresa, String telefon, String slika ) {
		super();
		this.idigraonica=idigraonica;
		this.naziv=naziv;
		this.adresa=adresa;
		this.telefon=telefon;
		this.slika=slika;
	}
	
	public int getIdigraonica() {
		return idigraonica;
	}
	public void setIdigraonica(int idigraonica) {
		this.idigraonica = idigraonica;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getSlika() {
		return slika;
	}
	public void setSlika(String slika) {
		this.slika = slika;
	}
	
	
}
