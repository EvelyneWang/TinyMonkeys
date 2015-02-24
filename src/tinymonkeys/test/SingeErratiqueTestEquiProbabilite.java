package tinymonkeys.test;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tinymonkeys.controleur.Controleur;
import tinymonkeys.modele.Ile;
import tinymonkeys.modele.SingeErratique;

/**
 * Tests pour l'équiprobabilité des déplacements dans toutes les directions.
 * @author Evelyne Wang
 * @version 1.0
 *
 */
public class SingeErratiqueTestEquiProbabilite 
{
	/**
	 * L'île.
	 */
	private Ile ile;
	
	/**
	 * Le singe dont on teste le déplacement.
	 */
	private SingeErratique singe;
	
	/**
	 * Nombre de tests à réaliser.
	 */
	private final static int NOMBRE_TESTS = 100;
	
	/**
	 * Position en abscisse du singe.
	 */
	private int singeX;
	
	/**
	 * Position en ordonnée du singe.
	 */
	private int singeY;
	
	/**
	 * Constructeur.
	 */
	public SingeErratiqueTestEquiProbabilite() 
	{
		this.singe = null;
	}
	
	/**
	 * Instanciation des attributs.
	 * @throws Exception exception
	 */
	@Before
	public void setUp() throws Exception 
	{
		this.ile = new Ile();
		this.ile.setCarte(Controleur.exempleCarte());
		this.singeX = 10;
		this.singeY = 10;
		this.singe = new SingeErratique(this.singeX, this.singeY, this.ile);
	}

	/**
	 * Teste l'équiprobabilité des déplacements.
	 */
	@Test
	public void testEquiProbabilite() 
	{
		int nbHaut = 0;
		int nbBas = 0;
		int nbGauche = 0;
		int nbDroite = 0;
		final double precision = 0.5;
		
		for (int i = 0; i < NOMBRE_TESTS; i++) {
			this.singe.deplacerSinge();
			if (this.singe.coordonneesEgales(this.singeX, this.singeY - 1)) {
				nbHaut++;
			} else if (this.singe.coordonneesEgales(this.singeX, this.singeY + 1)) {
				nbBas++;
			} else if (this.singe.coordonneesEgales(this.singeX - 1, this.singeY)) {
				nbGauche++;
			} else if (this.singe.coordonneesEgales(this.singeX + 1, this.singeY)) {
				nbDroite++;
			}
			this.singe.setPosition(this.singeX, this.singeY);
		}
		
		Assert.assertEquals(NOMBRE_TESTS / 4, nbHaut, NOMBRE_TESTS * precision);
		Assert.assertEquals(NOMBRE_TESTS / 4, nbBas, NOMBRE_TESTS * precision);
		Assert.assertEquals(NOMBRE_TESTS / 4, nbGauche, NOMBRE_TESTS * precision);
		Assert.assertEquals(NOMBRE_TESTS / 4, nbDroite, NOMBRE_TESTS * precision);
	}

}
