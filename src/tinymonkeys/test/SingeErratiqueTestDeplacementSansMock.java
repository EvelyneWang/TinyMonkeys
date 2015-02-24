package tinymonkeys.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tinymonkeys.controleur.Controleur;
import tinymonkeys.modele.BandeDeSingesErratiques;
import tinymonkeys.modele.Ile;
import tinymonkeys.modele.SingeErratique;

/**
 * Classe de tests des singes erratiques sans Mock.
 * @author Evelyne Wang
 * @version 1.0
 *
 */
public class SingeErratiqueTestDeplacementSansMock 
{
	
	/**
	 * L'�le.
	 */
	private Ile ile;
	
	/**
	 * Le singe dont on teste le d�placement.
	 */
	private SingeErratique singe;
	
	/**
	 * La bande de singes.
	 */
	private BandeDeSingesErratiques bandeDeSinges;
	
	/**
	 * Constructeur.
	 */
	public SingeErratiqueTestDeplacementSansMock() 
	{
		
	}
	
	/**
	 * Initialisation des attributs.
	 * @throws Exception 
	 */
	@Before
	public void setUp() throws Exception 
	{
		this.ile = new Ile();
		this.ile.setCarte(Controleur.exempleCarte());
		this.singe = new SingeErratique(10, 10, this.ile);
		this.bandeDeSinges = new BandeDeSingesErratiques(this.ile);
	}
	
	/**
	 * Test du d�placement du singe vers le bas.
	 */
	@Test
	public void testDeplacementBas() 
	{
		this.singe.setPosition(1, 1);
		final SingeErratique singeBloquant = new SingeErratique(2, 1, this.ile);
		this.bandeDeSinges.ajoutSinge(singeBloquant);
		this.ile.setErratiques(this.bandeDeSinges);
		this.testDeplacementRealise(0, 1);
	}
	
	/**
	 * Test du d�placement du singe vers le haut.
	 */
	@Test
	public void testDeplacementHaut() 
	{
		this.singe.setPosition(1, 18);
		final SingeErratique singeBloquant = new SingeErratique(2, 18, this.ile);
		this.bandeDeSinges.ajoutSinge(singeBloquant);
		this.ile.setErratiques(this.bandeDeSinges);
		this.testDeplacementRealise(0, -1);
	}
	
	/**
	 * Test du d�placement du singe vers la droite.
	 */
	@Test
	public void testDeplacementDroite() 
	{
		this.singe.setPosition(1, 1);
		final SingeErratique singeBloquant = new SingeErratique(1, 2, this.ile);
		this.bandeDeSinges.ajoutSinge(singeBloquant);
		this.ile.setErratiques(this.bandeDeSinges);
		this.testDeplacementRealise(1, 0);
	}
	
	/**
	 * Test du d�placement du singe vers la gauche.
	 */
	@Test
	public void testDeplacementGauche() 
	{
		this.singe.setPosition(18, 1);
		final SingeErratique singeBloquant = new SingeErratique(18, 2, this.ile);
		this.bandeDeSinges.ajoutSinge(singeBloquant);
		this.ile.setErratiques(this.bandeDeSinges);
		this.testDeplacementRealise(-1, 0);
	}
	
	/**
	 * Teste si le d�placement souhait� a bien �t� r�alis�.
	 * 
	 * @param dx Delta du d�placement pour l'abscisse
	 * @param dy Delta du d�placement pour l'ordonn�e
	 */
	private void testDeplacementRealise(int dx, int dy) 
	{
		final int x = this.singe.getX() + dx;
		final int y = this.singe.getY() + dy;
		this.singe.deplacerSinge();
		Assert.assertEquals(x, this.singe.getX());
		Assert.assertEquals(y, this.singe.getY());
	}
	
	/**
	 * Test du d�placement du singe dans toutes les directions (le d�placement doit �tre possible).
	 */
	@Test
	public void testToutDeplacementPossible() 
	{
		this.singe.setPosition(10, 10);
		this.testDeplacementHaut(true, false);
		this.testDeplacementBas(true, false);
		this.testDeplacementGauche(true, false);
		this.testDeplacementDroite(true, false);
	}
	
	/**
	 * Test du d�placement du singe du coin haut gauche de la carte :
	 * les d�placements vers le haut et vers la gauche sont impossibles.
	 */
	@Test public void testCoinHautGauche() 
	{
		this.singe.setPosition(1, 1);
		this.testDeplacementHaut(false, false);
		this.testDeplacementBas(true, false);
		this.testDeplacementGauche(false, false);
		this.testDeplacementDroite(true, false);
	}
	
	/**
	 * Test du d�placement du singe du coin bas gauche de la carte :
	 * les d�placements vers le bas et vers la gauche sont impossibles.
	 */
	@Test public void testCoinBasGauche() 
	{
		this.singe.setPosition(1, 18);
		this.testDeplacementHaut(true, false);
		this.testDeplacementBas(false, false);
		this.testDeplacementGauche(false, false);
		this.testDeplacementDroite(true, false);
	}
	
	/**
	 * Test du d�placement du singe du coin haut droite de la carte :
	 * les d�placements vers le haut et vers la droite sont impossibles.
	 */
	@Test public void testCoinHautDroite() 
	{
		this.singe.setPosition(18, 1);
		this.testDeplacementHaut(false, false);
		this.testDeplacementBas(true, false);
		this.testDeplacementGauche(true, false);
		this.testDeplacementDroite(false, false);
	}
	
	/**
	 * Test du d�placement du singe du coin bas droite de la carte :
	 * les d�placements vers le bas et vers la droite sont impossibles.
	 */
	@Test public void testCoinBasDroite() 
	{
		this.singe.setPosition(18, 18);
		this.testDeplacementHaut(true, false);
		this.testDeplacementBas(false, false);
		this.testDeplacementGauche(true, false);
		this.testDeplacementDroite(false, false);
	}
	
	/**
	 * Test du d�placement du singe vers des cases o� il y a d�j� un autre singe.
	 * Test dans les 4 directions.
	 */
	@Test public void testDeplacementImpossibleDansCaseAvecAutreSinge() 
	{
		this.singe.setPosition(10, 10);
		this.bandeDeSinges.getSingesErratiques().clear();
		final SingeErratique singeHaut = new SingeErratique(10, 9, this.ile);
		final SingeErratique singeBas = new SingeErratique(10, 11, this.ile);
		final SingeErratique singeGauche = new SingeErratique(9, 10, this.ile);
		final SingeErratique singeDroite = new SingeErratique(11, 10, this.ile);
		this.bandeDeSinges.ajoutSinge(singeHaut);
		this.bandeDeSinges.ajoutSinge(singeBas);
		this.bandeDeSinges.ajoutSinge(singeGauche);
		this.bandeDeSinges.ajoutSinge(singeDroite);
		this.ile.setErratiques(this.bandeDeSinges);
		this.testDeplacementBas(false, true);
		this.testDeplacementHaut(false, true);
		this.testDeplacementGauche(false, true);
		this.testDeplacementDroite(false, true);
	}
	
	/**
	 * Test lors d'un d�placement possible vers une position x,y.
	 * @param x Position en abscisse
	 * @param y Position en ordonn�e
	 */
	private void testDeplacementOK(int x, int y) 
	{
		Assert.assertTrue(this.ile.estCaseValide(x, y));
		Assert.assertTrue(this.ile.estCaseSansSinge(x, y));
	}
	
	/**
	 * Test lors d'un d�placement impossible vers une position x,y.
	 * @param x Position en abscisse
	 * @param y Position en ordonn�e
	 */
	private void testDeplacementNOK(int x, int y) 
	{
		Assert.assertFalse(this.ile.estCaseValide(x, y));
	}
	
	/**
	 * Test lors d'un d�placement impossible vers une position x,y o� il y a d�j� un singe.
	 * @param x Position en abscisse
	 * @param y Position en ordonn�e
	 */
	private void testDeplacementNOKAvecSinge(int x, int y) 
	{
		Assert.assertFalse(this.ile.estCaseSansSinge(x, y));
	}
	
	/**
	 * Test pour tout d�placement vers le haut.
	 * @param possible Bool�en d�finissant si le d�placement est possible
	 * @param avecSinge Bool�en d�finissant si l'on teste le d�placement d'un singe dans une case
	 * o� il y a potentiellement un autre singe
	 */
	private void testDeplacementHaut(boolean possible, boolean avecSinge) 
	{
		final int x = this.singe.getX();
		final int y = this.singe.getY() - 1;
		if (possible) {
			this.testDeplacementOK(x, y);
		} else if (!avecSinge) {
			this.testDeplacementNOK(x, y);
		} else {
			this.testDeplacementNOKAvecSinge(x, y);
		}
	}
	
	/**
	 * Test pour tout d�placement vers le bas.
	 * @param possible Bool�en d�finissant si le d�placement est possible
	 * @param avecSinge Bool�en d�finissant si l'on teste le d�placement d'un singe dans une case
	 * o� il y a potentiellement un autre singe
	 */
	private void testDeplacementBas(boolean possible, boolean avecSinge) 
	{
		final int x = this.singe.getX();
		final int y = this.singe.getY() + 1;
		if (possible) {
			this.testDeplacementOK(x, y);
		} else if (!avecSinge) {
			this.testDeplacementNOK(x, y);
		} else {
			this.testDeplacementNOKAvecSinge(x, y);
		}
	}
	
	/**
	 * Test pour tout d�placement vers la gauche.
	 * @param possible Bool�en d�finissant si le d�placement est possible
	 * @param avecSinge Bool�en d�finissant si l'on teste le d�placement d'un singe dans une case
	 * o� il y a potentiellement un autre singe
	 */
	private void testDeplacementGauche(boolean possible, boolean avecSinge) 
	{
		final int x = this.singe.getX() - 1;
		final int y = this.singe.getY();
		if (possible) {
			this.testDeplacementOK(x, y);
		} else if (!avecSinge) {
			this.testDeplacementNOK(x, y);
		} else {
			this.testDeplacementNOKAvecSinge(x, y);
		}
	}
	
	/**
	 * Test pour tout d�placement vers la droite.
	 * @param possible Bool�en d�finissant si le d�placement est possible
	 * @param avecSinge Bool�en d�finissant si l'on teste le d�placement d'un singe dans une case
	 * o� il y a potentiellement un autre singe
	 */
	private void testDeplacementDroite(boolean possible, boolean avecSinge) 
	{
		final int x = this.singe.getX() + 1;
		final int y = this.singe.getY();
		if (possible) {
			this.testDeplacementOK(x, y);
		} else if (!avecSinge) {
			this.testDeplacementNOK(x, y);
		} else {
			this.testDeplacementNOKAvecSinge(x, y);
		}
	}

}
