package testers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import classes.Kingdom;

public class KingdomTester {
	Kingdom kingdom1, kingdom2, kingdom3, kingdom4, kingdom5;
	ArrayList<String> princes1, princes2, princes3, princes4, princes5;
	
	@Before
	public void setUp() {
		princes1 = new ArrayList<String>(Arrays.asList("Alberto", "Carlos", "Fernando"));
		princes2 = new ArrayList<String>(Arrays.asList("Elvin", "Harry"));
		princes3 = new ArrayList<String>(Arrays.asList("Andres", "Alberto", "Elvin"));
		princes4 = new ArrayList<String>(Arrays.asList("Fernando", "Carlos", "Alberto"));
		princes5 = new ArrayList<String>(Arrays.asList("Harry", "Andres"));

		kingdom1 = new Kingdom("Alfredo", princes1, 17, 50000, 87000);
		kingdom2 = new Kingdom("Pedro", princes2, 14, 43000, 42000);
		kingdom3 = new Kingdom("Bienve", princes3, 19, 150000, 132000);
		kingdom4 = new Kingdom("José", princes4, 6, 19000, 22000);
		kingdom5 = new Kingdom("Manuel", princes5, 10, 38000, 38000);
	}
	
	@Test
	public void testMaxExpansion() {
		Kingdom max1 = new Kingdom("Alfredo", princes1, 21, 2000, 87000);
		int expanded1 = kingdom1.maxExpansion(12000);
		assertEquals(max1, kingdom1);
		assertTrue(expanded1 == 4);
		
		Kingdom max2 = new Kingdom("Pedro", princes2, 17, 1000, 42000);
		int expanded2 = kingdom2.maxExpansion(14000);
		assertEquals(max2, kingdom2);
		assertTrue(expanded2 == 3);
		
		Kingdom max3 = new Kingdom("Bienve", princes3, 29, 0, 132000);
		int expanded3 = kingdom3.maxExpansion(15000);
		assertEquals(max3, kingdom3);
		assertTrue(expanded3 == 10);
		
	}
	
	@Test
	public void testGoToWar() {
		Kingdom enemy1 = new Kingdom("Josian", princes1, 10, 65000, 50000);
		Kingdom enemy2 = new Kingdom("Heidy", princes2, 10, 28000, 47000);
		Kingdom enemy3 = new Kingdom("Juan", princes2, 10, 95000, 198000);
		Kingdom enemy4 = new Kingdom("Keije", princes1, 12, 57000, 35000);
		Kingdom enemy5 = new Kingdom("Jaime", princes2, 7, 49000, 38000);
		
		assertTrue(kingdom1.goToWar(enemy1));
		assertFalse(kingdom2.goToWar(enemy2));
		assertTrue(kingdom3.goToWar(enemy3));
		assertFalse(kingdom4.goToWar(enemy4));
		assertFalse(kingdom5.goToWar(enemy5));	
	}
	
	@Test
	public void testNewKing() {
		ArrayList<String> names2 = new ArrayList<>(Arrays.asList("Juan", "Heidy", "Pedro", "Harry", "Alberto", "Josian"));
		String newKing2 = kingdom2.newKing(names2);
		assertTrue(newKing2.equals("Harry"));
		
		ArrayList<String> names4 = new ArrayList<>(Arrays.asList("Bienve", "Manuel", "Fernando", "Keije", "Josian"));
		String newKing4 = kingdom4.newKing(names4);
		assertTrue(newKing4.equals("Fernando"));
		
		ArrayList<String> names5 = new ArrayList<>(Arrays.asList("Josian", "José", "Jaime", "Juan"));
		String newKing5 = kingdom5.newKing(names5);
		assertTrue(newKing5.equals("Harry"));
	}
	
	@Test
	public void testFixLetters() {
		String damagedPlate3 = "Bvemqe";
		String fixed3 = kingdom3.fixLetters(damagedPlate3);
		assertFalse(kingdom3.getKing() == fixed3);
		assertEquals(kingdom3.getKing(), fixed3);

		String damagedPlate4 = "Jxsx";
		String fixed4 = kingdom4.fixLetters(damagedPlate4);
		assertFalse(kingdom4.getKing() == fixed4);
		assertEquals(kingdom4.getKing(), fixed4);		
	}
	
	@Test
	public void testSpreadFakePrinces() {
		ArrayList<String> doc5 = new ArrayList<>(Arrays.asList("Alberto", "Harry", "Carlos", "Fernando", "Elvin", "Andres"));
		String[] fake5 = {"Alberto", "Carlos", "Fernando", "Elvin"};
		String[] returned5 = kingdom5.spreadFakePrinces(doc5);
		assertTrue(Arrays.equals(fake5, returned5));
		
		ArrayList<String> doc1 = new ArrayList<>(Arrays.asList("Alberto", "Harry", "Carlos", "Fernando", "Elvin", "Andres"));
		String[] fake1 = {"Harry", "Elvin", "Andres"};
		String[] returned1 = kingdom1.spreadFakePrinces(doc1);
		assertTrue(Arrays.equals(fake1, returned1));
	}
	
}
