package Com.GestionEquipe.Metier;

public class Membre {
	private int Id;
	private String nom;
	private String prenom;
	private String adress;
	private String telephone;
	private String email;
        
        
	public Membre() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Membre(int id, String nom, String prenom, String adress, String telephone, String email) {
		super();
		Id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adress = adress;
		this.telephone = telephone;
		this.email = email;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


}
