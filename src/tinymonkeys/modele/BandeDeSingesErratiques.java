package tinymonkeys.modele;

import java.util.Random;
import java.util.Vector;

import javax.swing.event.EventListenerList;

/**
 * Classe d'une bande de singes erratiques.
 * 
 * @version 1.0
 * @author Camille Constant, Evelyne Wang
 *
 */
public class BandeDeSingesErratiques extends Thread
{
	
	/**
	 * Vecteur contenant l'ensemble des singes erratiques.
	 */
	private Vector<SingeErratique> erratiques;
	
	/**
	 * L'ile.
	 */
	private Ile monkeyIsland;
	
	/**
	 * Liste des Ã©couteurs sur la bande de singes erratiques.
	 */
	final private EventListenerList bandeSingesEcouteurs;
	
	/**
	 * Constructeur d'une bande de singes erratiques vide.
	 * 
	 * @param ile l'ile contenant l'ensemble des elements de celle-ci.
	 */
	public BandeDeSingesErratiques(Ile ile)
	{
		super();
		this.erratiques = new Vector<SingeErratique>();
		this.monkeyIsland = ile;
		this.bandeSingesEcouteurs = new EventListenerList();
	}
	
	/**
	 * Accesseur en lecture a l'ensemble des singes erratiques.
	 * 
	 * @return le vecteur de singes erratiques.
	 */
	public Vector<SingeErratique> getSingesErratiques()
	{
		return this.erratiques;
	}

	
	/**
	 * Ajout du nombre indique de singes erratiques a des positions libres aleatoires.
	 * 
	 * @param n le nombre de singes a ajouter.
	 */
	public void ajoutSingesErratiques(int n)
	{	
		final Random rand = new Random();
		int randX;
		int randY;
		final int largeur = this.monkeyIsland.getLargeurCarte();
		final int longueur = this.monkeyIsland.getLongueurCarte();
		final BandeDeSingesErratiquesEcouteur fenetreSinges = this.bandeSingesEcouteurs.getListeners(BandeDeSingesErratiquesEcouteur.class)[0];
		
		for (int i = 0; i < n; i++) {
			randX = rand.nextInt(largeur);
			randY = rand.nextInt(longueur);
			
			while (this.monkeyIsland.estCaseMer(randX, randY)) {
				randX = rand.nextInt(largeur);
				randY = rand.nextInt(longueur);
			}

			fenetreSinges.creationSingeErratique(i, randX, randY);
			this.erratiques.add(new SingeErratique(randX, randY, this.monkeyIsland));
		}
		
	}
	
	/**
	 * Ajout d'un singe dans la bande.
	 * @param singe Singe à ajouter
	 */
	public void ajoutSinge(SingeErratique singe) 
	{
		this.erratiques.add(singe);
	}

	
	
	/**
	 * Enregistre dans la liste des ecouteurs de bande de singes l'ecouteur passe en parametre.
	 * @param ecouteur ecouteur de la bande de singes.
	 */
	public void enregistreEcBandeSinges(BandeDeSingesErratiquesEcouteur ecouteur)
	{
		this.bandeSingesEcouteurs.add(BandeDeSingesErratiquesEcouteur.class, ecouteur);
	}

	@Override
	public void run() 
	{
		final int tempsSleep = 20;
		while (!this.monkeyIsland.getPirate().isMort()) {

			for (int i = 0; i < this.erratiques.size(); i++) {
				this.erratiques.get(i).deplacerSinge();
				
				final BandeDeSingesErratiquesEcouteur fenetreSinges = this.bandeSingesEcouteurs.getListeners(BandeDeSingesErratiquesEcouteur.class)[0];
				fenetreSinges.deplacementSingeErratique(i, this.erratiques.get(i).getX(), this.erratiques.get(i).getY());
				if (this.monkeyIsland.getPirate().getX() == this.erratiques.get(i).getX() && this.monkeyIsland.getPirate().getY() == this.erratiques.get(i).getY()) {
					this.monkeyIsland.getPirate().tuerPirate();
				}
				try {
					sleep(tempsSleep);
				} 
				catch (Exception e) {
					System.out.println("Thread problems");
				}
			}
		}
	}

}
