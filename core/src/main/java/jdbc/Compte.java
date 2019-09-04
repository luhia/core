package jdbc;

public class Compte {
	private int id;
	private String nom;
	private double solde;
	
	
	
	public Compte(int id, String nom, double solde) {
		super();
		this.id = id;
		this.nom = nom;
		this.solde = solde;
	}


	
	@Override
	public String toString() {
		return "Compte [id=" + id + ", nom=" + nom + ", solde=" + solde + "]";
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	
}
