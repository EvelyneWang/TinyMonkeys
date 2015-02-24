package tinymonkeys.modele;


/**
 * Classe du singe erratique.
 * 
 * @version 1.0
 * @author Camille Constant, Evelyne Wang
 *
 */

public class SingeErratique extends Singe
{
	/**
	 * Constructeur de la classe SingeErratique. 
	 * 
	 * @param x la coordonnee en abscisse du singe.
	 * @param y la coordonnee en ordonnee du singe.
	 * @param ile l'ile sur laquelle vit le singe.
	 */
	public SingeErratique(int x, int y, Ile ile)
	{
		super(x, y, ile);
	}
	
	/**
	 * Deplacement aleatoire du singe erratique.
	 */
	public void deplacerSinge()
	{
		
		int dx = 0;
		int dy = 0;
		final int gauche = 1;
		final int haut = 2;
		final int droite = 3;
		final int bas = 4;
		final int nbMouvementsPossible = 4;
		
		int choix = 0;
		do {
			choix = (int) ((Math.random() * nbMouvementsPossible) + 1);
			if (choix == gauche) {
				dx = -1;
				dy = 0;
			}
			if (choix == haut) {
				dx = 0;
				dy = -1;
			}
			if (choix == droite) {
				dx = 1;
				dy = 0;
			}
			if (choix == bas) {
				dx = 0;
				dy = 1;
			}
		} while (!this.monkeyIsland.estCaseValide(this.x + dx, this.y + dy) || !this.monkeyIsland.estCaseSansSinge(this.x + dx, this.y + dy));
		this.setPosition(this.x + dx, this.y + dy);
	}
}
