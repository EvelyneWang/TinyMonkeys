package tinymonkeys.test;

import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import tinymonkeys.modele.BandeDeSingesErratiques;
import tinymonkeys.modele.Ile;
import tinymonkeys.modele.SingeErratique;

/**
 * Classe de tests des singes erratiques avec Mock.
 * @author Evelyne Wang
 * @version 1.0
 *
 */
public class SingeErratiqueTestDeplacementAvecMock extends TestCase 
{
	
	/**
	 * L'île.
	 */
	private Ile ileMock;
	
	/**
	 * Le singe dont on teste le déplacement.
	 */
	private SingeErratique singe;
	
	/**
	 * Constructeur.
	 */
	public SingeErratiqueTestDeplacementAvecMock()
	{
		
	}
	
	/**
	 * Instanciation des attributs.
	 * @throws Exception exception
	 */
	@Before
	public void setUp() throws Exception 
	{
		this.ileMock = EasyMock.createMock(Ile.class);
		this.singe = new SingeErratique(10, 10, this.ileMock);
	}
	
	/**
	 * Test du déplacement du singe vers le haut.
	 */
	@Test
	public void testDeplacementHaut() 
	{
		EasyMock.expect(this.ileMock.getLargeurCarte()).andStubReturn(20);
		EasyMock.expect(this.ileMock.getLongueurCarte()).andStubReturn(20);
		EasyMock.expect(this.ileMock.estCaseValide(10, 9)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseValide(10, 11)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseValide(9, 10)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseValide(11, 10)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseMer(10, 9)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseMer(10, 11)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseMer(9, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseMer(11, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseDansCarte(10, 9)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseDansCarte(10, 11)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseDansCarte(9, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseDansCarte(11, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseSansSinge(10, 9)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseSansSinge(10, 11)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseSansSinge(9, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseSansSinge(11, 10)).andStubReturn(true);
		EasyMock.replay(this.ileMock);
		
		this.testDeplacementRealise(0, -1);
	}
	
	/**
	 * Test du déplacement du singe vers le bas.
	 */
	@Test
	public void testDeplacementBas() 
	{
		EasyMock.expect(this.ileMock.getLargeurCarte()).andStubReturn(20);
		EasyMock.expect(this.ileMock.getLongueurCarte()).andStubReturn(20);
		EasyMock.expect(this.ileMock.estCaseValide(10, 9)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseValide(10, 11)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseValide(9, 10)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseValide(11, 10)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseMer(10, 9)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseMer(10, 11)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseMer(9, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseMer(11, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseDansCarte(10, 9)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseDansCarte(10, 11)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseDansCarte(9, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseDansCarte(11, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseSansSinge(10, 9)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseSansSinge(10, 11)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseSansSinge(9, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseSansSinge(11, 10)).andStubReturn(true);
		EasyMock.replay(this.ileMock);
		
		this.testDeplacementRealise(0, 1);
	}
	
	/**
	 * Test du déplacement du singe vers la gauche.
	 */
	@Test
	public void testDeplacementGauche() 
	{
		EasyMock.expect(this.ileMock.getLargeurCarte()).andStubReturn(20);
		EasyMock.expect(this.ileMock.getLongueurCarte()).andStubReturn(20);
		EasyMock.expect(this.ileMock.estCaseValide(10, 9)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseValide(10, 11)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseValide(9, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseValide(11, 10)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseMer(10, 9)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseMer(10, 11)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseMer(9, 10)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseMer(11, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseDansCarte(10, 9)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseDansCarte(10, 11)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseDansCarte(9, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseDansCarte(11, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseSansSinge(10, 9)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseSansSinge(10, 11)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseSansSinge(9, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseSansSinge(11, 10)).andStubReturn(true);
		EasyMock.replay(this.ileMock);
		
		this.testDeplacementRealise(-1, 0);
	}
	
	/**
	 * Test du déplacement du singe vers la droite.
	 */
	@Test
	public void testDeplacementDroite() 
	{
		EasyMock.expect(this.ileMock.getLargeurCarte()).andStubReturn(20);
		EasyMock.expect(this.ileMock.getLongueurCarte()).andStubReturn(20);
		EasyMock.expect(this.ileMock.estCaseValide(10, 9)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseValide(10, 11)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseValide(9, 10)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseValide(11, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseMer(10, 9)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseMer(10, 11)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseMer(9, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseMer(11, 10)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseDansCarte(10, 9)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseDansCarte(10, 11)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseDansCarte(9, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseDansCarte(11, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseSansSinge(10, 9)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseSansSinge(10, 11)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseSansSinge(9, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseSansSinge(11, 10)).andStubReturn(true);
		EasyMock.replay(this.ileMock);
		
		this.testDeplacementRealise(1, 0);
	}
	
	/**
	 * Teste si le déplacement souhaité a bien été réalisé.
	 * @param dx Delta du déplacement pour l'abscisse
	 * @param dy Delta du déplacement pour l'ordonnée
	 */
	private void testDeplacementRealise(int dx, int dy) 
	{
		final int x = this.singe.getX() + dx;
		final int y = this.singe.getY() + dy;
		this.singe.deplacerSinge();
		assertEquals(x, this.singe.getX());
		assertEquals(y, this.singe.getY());
	}
	
	/**
	 * Test du déplacement du singe dans toutes les directions (le déplacement doit être possible).
	 */
	@Test
	public void testToutDeplacementPossible() 
	{
		EasyMock.expect(this.ileMock.getLargeurCarte()).andStubReturn(20);
		EasyMock.expect(this.ileMock.getLongueurCarte()).andStubReturn(20);
		EasyMock.expect(this.ileMock.getSingesErratiques()).andStubReturn(new BandeDeSingesErratiques(this.ileMock));
		EasyMock.expect(this.ileMock.estCaseValide(10, 9)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseValide(10, 11)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseValide(9, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseValide(11, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseMer(10, 9)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseMer(10, 11)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseMer(9, 10)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseMer(11, 10)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseDansCarte(10, 9)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseDansCarte(10, 11)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseDansCarte(9, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseDansCarte(11, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseSansSinge(10, 9)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseSansSinge(10, 11)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseSansSinge(9, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseSansSinge(11, 10)).andStubReturn(true);
		EasyMock.replay(this.ileMock);
		
		this.testDeplacementHaut(true, false);
		this.testDeplacementBas(true, false);
		this.testDeplacementGauche(true, false);
		this.testDeplacementDroite(true, false);
	}
	
	/**
	 * Test du déplacement du singe du coin haut gauche de la carte :
	 * les déplacements vers le haut et vers la gauche sont impossibles.
	 */
	@Test public void testCoinHautGauche() 
	{
		EasyMock.expect(this.ileMock.getLargeurCarte()).andStubReturn(20);
		EasyMock.expect(this.ileMock.getLongueurCarte()).andStubReturn(20);
		EasyMock.expect(this.ileMock.getSingesErratiques()).andStubReturn(new BandeDeSingesErratiques(this.ileMock));
		EasyMock.expect(this.ileMock.estCaseValide(10, 9)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseValide(10, 11)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseValide(9, 10)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseValide(11, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseMer(10, 9)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseMer(10, 11)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseMer(9, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseMer(11, 10)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseDansCarte(10, 9)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseDansCarte(10, 11)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseDansCarte(9, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseDansCarte(11, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseSansSinge(10, 9)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseSansSinge(10, 11)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseSansSinge(9, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseSansSinge(11, 10)).andStubReturn(true);
		EasyMock.replay(this.ileMock);
		
		this.testDeplacementHaut(false, false);
		this.testDeplacementBas(true, false);
		this.testDeplacementGauche(false, false);
		this.testDeplacementDroite(true, false);
	}
	
	/**
	 * Test du déplacement du singe du coin bas gauche de la carte :
	 * les déplacements vers le bas et vers la gauche sont impossibles.
	 */
	@Test public void testCoinBasGauche() 
	{
		EasyMock.expect(this.ileMock.getLargeurCarte()).andStubReturn(20);
		EasyMock.expect(this.ileMock.getLongueurCarte()).andStubReturn(20);
		EasyMock.expect(this.ileMock.getSingesErratiques()).andStubReturn(new BandeDeSingesErratiques(this.ileMock));
		EasyMock.expect(this.ileMock.estCaseValide(10, 9)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseValide(10, 11)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseValide(9, 10)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseValide(11, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseMer(10, 9)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseMer(10, 11)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseMer(9, 10)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseMer(11, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseDansCarte(10, 9)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseDansCarte(10, 11)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseDansCarte(9, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseDansCarte(11, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseSansSinge(10, 9)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseSansSinge(10, 11)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseSansSinge(9, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseSansSinge(11, 10)).andStubReturn(true);
		EasyMock.replay(this.ileMock);
		
		this.testDeplacementHaut(true, false);
		this.testDeplacementBas(false, false);
		this.testDeplacementGauche(false, false);
		this.testDeplacementDroite(true, false);
	}
	
	/**
	 * Test du déplacement du singe du coin haut droite de la carte :
	 * les déplacements vers le haut et vers la droite sont impossibles.
	 */
	@Test public void testCoinHautDroite() 
	{
		EasyMock.expect(this.ileMock.getLargeurCarte()).andStubReturn(20);
		EasyMock.expect(this.ileMock.getLongueurCarte()).andStubReturn(20);
		EasyMock.expect(this.ileMock.getSingesErratiques()).andStubReturn(new BandeDeSingesErratiques(this.ileMock));
		EasyMock.expect(this.ileMock.estCaseValide(10, 9)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseValide(10, 11)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseValide(9, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseValide(11, 10)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseMer(10, 9)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseMer(10, 11)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseMer(9, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseMer(11, 10)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseDansCarte(10, 9)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseDansCarte(10, 11)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseDansCarte(9, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseDansCarte(11, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseSansSinge(10, 9)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseSansSinge(10, 11)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseSansSinge(9, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseSansSinge(11, 10)).andStubReturn(true);
		EasyMock.replay(this.ileMock);
		
		this.testDeplacementHaut(false, false);
		this.testDeplacementBas(true, false);
		this.testDeplacementGauche(true, false);
		this.testDeplacementDroite(false, false);
	}
	
	/**
	 * Test du déplacement du singe du coin bas droite de la carte :
	 * les déplacements vers le bas et vers la droite sont impossibles.
	 */
	@Test public void testCoinBasDroite() 
	{
		EasyMock.expect(this.ileMock.getLargeurCarte()).andStubReturn(20);
		EasyMock.expect(this.ileMock.getLongueurCarte()).andStubReturn(20);
		EasyMock.expect(this.ileMock.getSingesErratiques()).andStubReturn(new BandeDeSingesErratiques(this.ileMock));
		EasyMock.expect(this.ileMock.estCaseValide(10, 9)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseValide(10, 11)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseValide(9, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseValide(11, 10)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseMer(10, 9)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseMer(10, 11)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseMer(9, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseMer(11, 10)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseDansCarte(10, 9)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseDansCarte(10, 11)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseDansCarte(9, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseDansCarte(11, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseSansSinge(10, 9)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseSansSinge(10, 11)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseSansSinge(9, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseSansSinge(11, 10)).andStubReturn(true);
		EasyMock.replay(this.ileMock);
		
		this.testDeplacementHaut(true, false);
		this.testDeplacementBas(false, false);
		this.testDeplacementGauche(true, false);
		this.testDeplacementDroite(false, false);
	}
	
	/**
	 * Test du déplacement du singe vers des cases où il y a déjà un autre singe.
	 * Test dans les 4 directions
	 */
	@Test public void testDeplacementImpossibleDansCaseAvecAutreSinge() 
	{
		final BandeDeSingesErratiques bandeDeSinges = new BandeDeSingesErratiques(this.ileMock);
		final SingeErratique singeHaut = new SingeErratique(10, 9, this.ileMock);
		final SingeErratique singeBas = new SingeErratique(10, 11, this.ileMock);
		final SingeErratique singeGauche = new SingeErratique(9, 10, this.ileMock);
		final SingeErratique singeDroite = new SingeErratique(11, 10, this.ileMock);
		bandeDeSinges.ajoutSinge(singeHaut);
		bandeDeSinges.ajoutSinge(singeBas);
		bandeDeSinges.ajoutSinge(singeGauche);
		bandeDeSinges.ajoutSinge(singeDroite);
		EasyMock.expect(this.ileMock.getLargeurCarte()).andStubReturn(20);
		EasyMock.expect(this.ileMock.getLongueurCarte()).andStubReturn(20);
		EasyMock.expect(this.ileMock.getSingesErratiques()).andStubReturn(bandeDeSinges);
		EasyMock.expect(this.ileMock.estCaseMer(10, 9)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseMer(10, 11)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseMer(9, 10)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseMer(11, 10)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseDansCarte(10, 9)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseDansCarte(10, 11)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseDansCarte(9, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseDansCarte(11, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseValide(10, 9)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseValide(10, 11)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseValide(9, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseValide(11, 10)).andStubReturn(true);
		EasyMock.expect(this.ileMock.estCaseSansSinge(10, 9)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseSansSinge(10, 11)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseSansSinge(9, 10)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseSansSinge(11, 10)).andStubReturn(false);
		
		EasyMock.replay(this.ileMock);
		
		this.testDeplacementBas(false, true);
		this.testDeplacementHaut(false, true);
		this.testDeplacementGauche(false, true);
		this.testDeplacementDroite(false, true);
		
		EasyMock.verify(this.ileMock);
	}
	
	/**
	 * Test du déplacement du singe hors de la carte.
	 */
	@Test
	public void testDeplacementHorsCarte() 
	{
		this.singe.setPosition(0, 0);
		EasyMock.expect(this.ileMock.getLargeurCarte()).andStubReturn(20);
		EasyMock.expect(this.ileMock.getLongueurCarte()).andStubReturn(20);
		EasyMock.expect(this.ileMock.estCaseValide(-1, 0)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseMer(-1, 0)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseDansCarte(-1, 0)).andStubReturn(false);
		EasyMock.expect(this.ileMock.estCaseSansSinge(-1, 0)).andStubReturn(true);
		EasyMock.replay(this.ileMock);
		
		this.testDeplacementGauche(false, false);
		
		this.singe.setPosition(10, 10);
	}
	
	/**
	 * Test lors d'un déplacement possible vers une position x,y.
	 * @param x Position en abscisse
	 * @param y Position en ordonnée
	 */
	private void testDeplacementOK(int x, int y) 
	{
		assertTrue(this.ileMock.estCaseValide(x, y));
		assertTrue(this.ileMock.estCaseSansSinge(x, y));
	}
	
	/**
	 * Test lors d'un déplacement impossible vers une position x,y.
	 * @param x Position en abscisse
	 * @param y Position en ordonnée
	 */
	private void testDeplacementNOK(int x, int y) 
	{
		assertFalse(this.ileMock.estCaseValide(x, y));
	}
	
	/**
	 * Test lors d'un déplacement impossible vers une position x,y où il y a déjà un singe.
	 * @param x Position en abscisse
	 * @param y Position en ordonnée
	 */
	private void testDeplacementNOKAvecSinge(int x, int y) 
	{
		assertFalse(this.ileMock.estCaseSansSinge(x, y));
	}
	
	/**
	 * Test pour tout déplacement vers le haut.
	 * @param possible Booléen définissant si le déplacement est possible
	 * @param avecSinge Booléen définissant si l'on teste le déplacement d'un singe dans une case
	 * où il y a potentiellement un autre singe
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
	 * Test pour tout déplacement vers le bas.
	 * @param possible Booléen définissant si le déplacement est possible
	 * @param avecSinge Booléen définissant si l'on teste le déplacement d'un singe dans une case
	 * où il y a potentiellement un autre singe
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
	 * Test pour tout déplacement vers la gauche.
	 * @param possible Booléen définissant si le déplacement est possible
	 * @param avecSinge Booléen définissant si l'on teste le déplacement d'un singe dans une case
	 * où il y a potentiellement un autre singe
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
	 * Test pour tout déplacement vers la droite.
	 * @param possible Booléen définissant si le déplacement est possible
	 * @param avecSinge Booléen définissant si l'on teste le déplacement d'un singe dans une case
	 * où il y a potentiellement un autre singe
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
