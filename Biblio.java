import java.util.ArrayList;

class Auteur {

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
	// Completer la classe Auteur ici
	private String nom;
	private boolean prime;
	
	public Auteur(String nom, boolean prime){
		this.nom = nom;
		this.prime = prime;
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public boolean getPrix(){
		return this.prime;
	}
	
}

class Oeuvre
{
 	// Completer la classe Oeuvre ici
	private String titre;
	private Auteur auteur;
	private String langue;
	
	
	public Oeuvre(String titre, Auteur auteur, String langue){
		this.titre = titre;
		this.auteur = auteur;
		this.langue = langue;
	}
	
	public Oeuvre(String titre, Auteur auteur) {
		this(titre, auteur, "francais");
	}
	
	public String getTitre(){
		return titre;
	}
	
	public Auteur getAuteur(){
		return auteur;
	}
	
	public String getLangue(){
		return langue;
	}
	
	public void afficher(){
		System.out.println(titre + ", " + auteur.getNom() + ", en " + langue);
	}
	
}

class Exemplaire{
	private Oeuvre oeuvre;
	
	public Exemplaire(Oeuvre oeuvre){
		this.oeuvre = oeuvre;
		System.out.print("Nouvel exemplaire -> ");
		oeuvre.afficher();
	}
	
	public Exemplaire(Exemplaire explaireCopy){
		this.oeuvre = explaireCopy.oeuvre;
		System.out.println("Copie d'un exemplaire -> ") ;
		oeuvre.afficher();
	}
	
	public Oeuvre getOeuvre() {
		return oeuvre;
	}
	
	public void afficher(){
		System.out.print("Un exemplaire de ");
		oeuvre.afficher();
	}
}

class Bibliotheque{
	private String nom;
	private ArrayList<Exemplaire> exemplaires;
	
	public Bibliotheque(String nom){
		this.nom = nom;
		exemplaires = new ArrayList<Exemplaire>();
		System.out.println("La bibliothèque"+ nom + " est ouverte !" );
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public int getNbExemplaires(){
		if (exemplaires != null){
			return exemplaires.size();
		}else return 0;
	}
	
	public void stocker(Oeuvre oeuvre, int nbExemplaire) {
		for (int i = 0; i < nbExemplaire; i++){
			exemplaires.add(new Exemplaire(oeuvre));
		}
	}
	
	public void stocker(Oeuvre oeuvre){
		stocker(oeuvre, 1);
	}
	
	public ArrayList<Exemplaire> listerExemplaires(String langue) {
		ArrayList<Exemplaire> res = new ArrayList<Exemplaire>();
		for (Exemplaire e: exemplaires){
			if(e.getOeuvre().getLangue() == langue){
				res.add(e);
			}
		}
		return res;
	}
	
	public ArrayList<Exemplaire> listerExemplaires() {
		return exemplaires;
	}
	
	
	public int compterExemplaires(Oeuvre oeuvre) {
		int n = 0;
		for (Exemplaire e: exemplaires){
			if (e.getOeuvre() == oeuvre){
				n++;
			}
		}
		return n;
	}
	
	public void afficherAuteur(boolean prix) {
		for(Exemplaire e: exemplaires){
			if (e.getOeuvre().getAuteur().getPrix() == prix){
				System.out.println(e.getOeuvre().getAuteur().getNom());
			}
		}
	}
	
	public void afficherAuteur() {
		afficherAuteur(true);
	}
	
}

// completer les autres classes ici


/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/
/*******************************************
 * Ce qui suit est propose' pour vous aider
 * dans vos tests, mais votre programme sera
 * teste' avec d'autres donnees.
 *******************************************/

public class Biblio {

    public static void afficherExemplaires(ArrayList<Exemplaire> exemplaires) {
        for (Exemplaire exemplaire : exemplaires) {
            System.out.print("\t");
            exemplaire.afficher();
        }
    }

    public static void main(String[] args) {
        // create and store all the exemplaries
        Auteur a1 = new Auteur("Victor Hugo", false);
        Auteur a2 = new Auteur("Alexandre Dumas", false);
        Auteur a3 = new Auteur("Raymond Queneau", true);

        Oeuvre o1 = new Oeuvre("Les Miserables", a1, "francais");
        Oeuvre o2 = new Oeuvre("L\'Homme qui rit", a1, "francais");
        Oeuvre o3 = new Oeuvre("Le Comte de Monte-Cristo", a2, "francais");
        Oeuvre o4 = new Oeuvre("Zazie dans le metro", a3, "francais");
        Oeuvre o5 = new Oeuvre("The count of Monte-Cristo", a2, "anglais");

        Bibliotheque biblio = new Bibliotheque("municipale");
        biblio.stocker(o1, 2);
        biblio.stocker(o2);
        biblio.stocker(o3, 3);
        biblio.stocker(o4);
        biblio.stocker(o5);

        // ...
        System.out.println("La bibliotheque " + biblio.getNom() + " offre ");
        afficherExemplaires(biblio.listerExemplaires());
        String langue = "anglais";
        System.out.println("Les exemplaires en " + langue + " sont  ");
        afficherExemplaires(biblio.listerExemplaires(langue));
        System.out.println("Les auteurs a succes sont  ");
        biblio.afficherAuteur();
        System.out.print("Il y a " + biblio.compterExemplaires(o3) + " exemplaires");
        System.out.println(" de  " + o3.getTitre());
    }
}
