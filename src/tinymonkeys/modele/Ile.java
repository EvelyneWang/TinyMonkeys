package tinymonkeys.modele;

import java.util.Random;
import java.util.Vector;

import javax.swing.event.EventListenerList;

/**
 * Classe Ile. 
 * 
 * @version 1.0
 * @author Camille Constant, Evelyne Wang
 *
 */
public class Ile 
{	
	/**
	 * La carte de l'ile : une matrice indiquant si chaque case est de type mer (0) ou terre (1).
	 */
	private int[][] carte;
	
	/**
	 * Les singes erratiques.
	 */
	private BandeDeSingesErratiques erratiques;
	
	/**
	 * Le tresor.
	 */
	private Tresor tresor;
	
	/**
	 * Le pirate du joueur.
	 */
	private Pirate pirate;

	/**
	 * Liste des Ã©couteurs sur l'ile.
	 */
	final private EventListenerList ileEcouteurs;
	
	/**
	 * Constructeur de la classe Ile. 
	 */
	public Ile()
	{
		this.carte = null;
		this.erratiques = new BandeDeSingesErratiques(this);
		this.tresor = null;
		this.pirate = new Pirate(this);
		this.ileEcouteurs = new EventListenerList();
	}
	
	
	/**
	 * Indique la largeur de la carte en nombre de cases.
	 * 
	 * @return la largeur de la carte.
	 */
	public int getLargeurCarte()
	{
		return this.carte.length;
	}
	
	/**
	 * Indique la longueur de la carte en nombre de cases.
	 * 
	 * @return la longueur de la carte.
	 */
	public int getLongueurCarte()
	{
		return this.carte[0].length;
	}
	
	/**
	 * Permet l'acces en lecture a la valeur de la carte aux coordonnees indiquees.
	 * 
	 * @param x la coordonnee en abscisse.
	 * @param y la coordonnee en ordonnee.
	 * @return la valeur de la case de la carte aux coordonnees indiquees.
	 */
	public int valeurCarte(int x, int y)
	{
		return this.carte[x][y];
	}
	
	/**
	 * Creation de la carte.
	 * 
	 * @param carte la matrice terre-mer. 
	 */
	public void creationCarte(int[][] carte)
	{
		this.carte = carte.clone();
		final IleEcouteur fenetre = this.ileEcouteurs.getListeners(IleEcouteur.class)[0];
		fenetre.creationCarte(this.carte);
	}
	
	/**
	 * Mise Ã  jour de la carte.
	 * 
	 * @param carte la matrice terre-mer. 
	 */
	public void setCarte(int[][] carte)
	{
		this.carte = carte.clone();
	}
	
	/**
	 * Mise à jour de la bande de singes erratiques.
	 * 
	 * @param erratiques la bande de singes
	 */
	public void setErratiques(BandeDeSingesErratiques erratiques) 
	{
		this.erratiques = erratiques;
	}
	
	/**
	 * Accesseur en lecture du pirate de l'ile.
	 * 
	 * @return le pirate.
	 */
	public Pirate getPirate()
	{
		return this.pirate;
	}
	
	/**
	 * Creation du pirate sur l'ile.
	 * 
	 * @param avatar le lien vers l'image du pirate.
	 */
	public void ajoutPirate(String avatar)
	{
		final Random rand = new Random();
		int randX = rand.nextInt(this.getLargeurCarte());
		int randY = rand.nextInt(this.getLongueurCarte());
		while (this.estCaseMer(randX, randY)) {
			randX = rand.nextInt(this.getLargeurCarte());
			randY = rand.nextInt(this.getLongueurCarte());
		}
		this.pirate.setAvatar(avatar);
		this.pirate.positionInitiale(randX, randY);
	}
	
	/**
	 * Methode permettant de faire la demande de deplacement du pirate. 
	 * Cette methode fait suite a un appui sur une fleche directionnelle du clavier.
	 * 
	 * @param dx la direction en abscisse.
	 * @param dy la direction en ordonnee.
	 */
	public void demandeDeplacementPirate(int dx, int dy)
	{
		if (this.tresor != null) {
			this.pirate.demandeDeplacement(dx, dy);
		}
	}
	
	
	/**
	 * Accesseur en lecture de la bande de singes erratiques.
	 * 
	 * @return la bande de singes erratiques.
	 */
	public BandeDeSingesErratiques getSingesErratiques()
	{
		return this.erratiques;
	}
	
	/**
	 * Ajout du nombre indique de singes erratiques dans la liste des singes erratiques.
	 * 
	 * @param n le nombre de singes erratiques a ajouter.
	 */
	public void ajoutSingesErratiques(int n)
	{
		this.erratiques.ajoutSingesErratiques(n);
	}
	
	
	/**
	 * Accesseur en lecture du tresor.
	 * 
	 * @return le tresor.
	 */
	public Tresor getTresor()
	{
		return this.tresor;
	}
	
	/**
	 * Creation du tresor a une position aleatoire.
	 */
	public void creationTresor()
	{	
		final Random rand = new Random();
		int randX = rand.nextInt(this.getLargeurCarte());
		int randY = rand.nextInt(this.getLongueurCarte());
		
		while (this.estCaseMer(randX, randY)) {
			randX = rand.nextInt(this.getLargeurCarte());
			randY = rand.nextInt(this.getLongueurCarte());
		}
		this.tresor = new Tresor(randX, randY);
		
		final IleEcouteur fenetre = this.ileEcouteurs.getListeners(IleEcouteur.class)[0];
		fenetre.creationTresor(this.tresor.getX(), this.tresor.getY());
		
	}
	
	
	/**
	 * Suppression du tresor.  
	 */ 
	public void suppressionTresor()
	{		
		this.tresor = null;
		final IleEcouteur fenetre = this.ileEcouteurs.getListeners(IleEcouteur.class)[0];
		fenetre.suppressionTresor();
	}
	

	/**
	 * Enregistre dans la liste des ecouteurs de l'ile l'ecouteur passe en parametre.
	 * @param ecouteur ecouteur de l'ile.
	 */
	public void enregistreEcIle(IleEcouteur ecouteur)
	{
		this.ileEcouteurs.add(IleEcouteur.class, ecouteur);
	}
	
	/**
	 * Informe si la case est une case mer.
	 * @param x Position sur l'abscisse
	 * @param y Position sur l'ordonnée
	 * @return un booléen selon si la case est mer
	 */
	public boolean estCaseMer(int x, int y) 
	{

		return this.carte[x][y] == 0;
	}
	
	/**
	 * Informe si la case est libre.
	 * @param x Position sur l'abscisse
	 * @param y Position sur l'ordonnée
	 * @return vrai si la case est libre
	 */
	public boolean estCaseLibre(int x, int y) 
	{
		
		boolean trouve = false;
		final Vector<SingeErratique> vectorSinges = this.erratiques.getSingesErratiques();
		for (int i = 0; i < vectorSinges.size(); i++) {
			if (vectorSinges.get(i).coordonneesEgales(x, y)) {
				trouve = true;
			}
		}
		return trouve;
	}
	
	/**
	 * Informe si la case est dans la carte.
	 * @param x Position sur l'abscisse
	 * @param y Position sur l'ordonnée
	 * @return vrai si la case est dans la carte
	 */
	public boolean estCaseDansCarte(int x, int y) 
	{
		return x < this.getLargeurCarte() && x >= 0 && y < this.getLongueurCarte() && y >= 0;
	}
	
	/**
	 * Informe si la case est valide. 
	 * @param x Position sur l'abscisse
	 * @param y Position sur l'ordonnée
	 * @return vrai si la case est valide
	 */
	public boolean estCaseValide(int x, int y) 
	{	

		return this.estCaseDansCarte(x, y) && !this.estCaseMer(x, y);
			
	}
	
	/**
	 * Informe si la case ne contient un singe.
	 * @param x Position sur l'abscisse
	 * @param y Position sur l'ordonnée
	 * @return vrai si la case ne contient pas un singe
	 */
	public boolean estCaseSansSinge(int x, int y) 
	{
		boolean estCaseSansSinge = true;
		for (int i = 0; i < this.erratiques.getSingesErratiques().size(); i++) {
			if (this.erratiques.getSingesErratiques().get(i).coordonneesEgales(x, y)) {
				estCaseSansSinge = false;
			}
		}
		return estCaseSansSinge;
	}
}
