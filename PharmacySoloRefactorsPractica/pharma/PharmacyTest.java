package pharma;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.function.Executable;

import org.junit.Before;
import org.junit.jupiter.api.Test;

public class PharmacyTest {
  Pharmacy pharma = new Pharmacy();
  @Before
  public void setUp(){
    Pharmacy pharma = new Pharmacy();
  }


  @Test public void testNewPharmacy() {
    assertTrue( new Pharmacy().medication( "fever" ).isEmpty() );
  }
  
  @Test public void testPharmacyT1() {
    registerParacetamolWithAssertSymtomAndContainsParacetamol("fever");
    assertFalse( pharma.medication( "fever" ).isEmpty() );
  }

  @Test public void testPharmacyT3() {
    registerParacetamolWithAssertSymtomAndContainsParacetamol("headache");
  }

  @Test public void testPharmacyT2() {
    registerIbuprofenoAndParacetamolWithAssertTrueContainment("fever");
  }

  @Test public void testPharmacyT4() {
    registerIbuprofenoAndParacetamolWithAssertTrueContainment("headache");
    assertTrue( pharma.medication( "headache" ).contains( "ibuprofeno" ) );    
  }

  @Test public void testPharmacyT5() {
    registerIbuprofenoAndParacetamol();
    assertFalse( pharma.safeMedicationFor( "headache", "stomachache" ).contains( "ibuprofeno" ) );
  }
    
  
  @Test public void testPharmacyT6() {
    registerParacetablosWithClonachoAssertFalseAndReplacement(pharmaMedicationContains());
    assertTrue(pharmaMedicationContains());
  }

  @Test public void testPharmacyT6b() {
    registerParacetablosWithClonachoAssertFalseAndReplacement(pharmaSafeMedicationContains());
    assertTrue(pharmaSafeMedicationContains());
  }

  @Test public void testPharmacyT7() {
    registerParacetamolWithAssertThrowsLike( () -> pharma.register( new Drug( "paracetamol" ).releaves( "fever", "headache") ),"Droga ya registrada");
  }

  @Test public void testPharmacyT8() {
    assertThrowsLike( () -> pharma.replacement( "paracetamol", "clonacho" ), "No se puede reemplazar: paracetamol" );
  }

  @Test public void testPharmacyT9() {
    registerParacetamolWithAssertThrowsLike( () -> pharma.replacement( "paracetamol", "clonacho" ),"clonacho no puede ser reemplazo");
  }
  
  @Test public void testPharmacyT10() {
    registerIbuprofenoAndParacetamol();
    pharma.register( new Drug( "clonacho" ).releaves( "anxiety" ).collateral( "testophobia", "insomnia") );
    pharma.replacement( "paracetamol", "clonacho" );
    assertEquals( 3, pharma.medication( "headache" ).size() );  
    assertEquals( 2, pharma.safeMedicationFor( "headache", "stomachache" ).size() );  
  }

  @Test public void testPharmacyT11() {
    registerAllThreeAndReplacementWithAssertSizeMedicationAndSafeMedicationWithFeverAnd("heartburn");
  }

  @Test public void testPharmacyT13() {
    registerAllThreeAndReplacementWithAssertSizeMedicationAndSafeMedicationWithFeverAnd("insomnia");
  }

  private void assertThrowsLike(Executable executable, String message) {
    assertEquals(message, assertThrows(Exception.class, executable).getMessage());
  }
  private void registerIbuprofenoAndParacetamol() {
    pharma.register( new Drug( "paracetamol" ).releaves( "fever", "headache") );
    pharma.register( new Drug( "ibuprofeno" ).releaves( "headache" ).collateral( "stomachache") );
  }
  private void registerParacetamolWithClonacho() {
    pharma.register( new Drug( "paracetamol" ).releaves( "fever", "headache") );
    pharma.register( new Drug( "clonacho" ).releaves( "anxiety" ).collateral( "testophobia", "insomnia") );
  }
  private void registerIbuprofenoAndParacetamolWithAssertTrueContainment(String headache) {
    registerIbuprofenoAndParacetamol();
    assertTrue(pharma.medication(headache).contains("paracetamol"));
  }
  private void registerParacetamolWithAssertSymtomAndContainsParacetamol(String symtom) {
    pharma.register( new Drug( "paracetamol" ).releaves( "fever", "headache") );
    assertTrue( pharma.medication( symtom ).contains( "paracetamol" ) );
  }
  private void registerParacetamolWithAssertThrowsLike(Executable executable, String message) {
    pharma.register( new Drug( "paracetamol" ).releaves( "fever", "headache") );
    assertThrowsLike(executable, message );
  }
  private void registerAllThreeAndReplacement() {
    pharma.register( new Drug( "paracetamol" ).releaves( "fever", "headache" ).collateral( "heartburn" ) );
    pharma.register( new Drug( "ibuprofeno" ).releaves( "headache" ).collateral( "stomachache") );
    pharma.register( new Drug( "clonacho" ).releaves( "anxiety" ).collateral( "testophobia", "insomnia") );

    pharma.replacement( "paracetamol", "clonacho" );
  }
  private void registerAllThreeAndReplacementWithAssertSizeMedicationAndSafeMedicationWithFeverAnd(String insomnia) {
    registerAllThreeAndReplacement();
    assertEquals(2, pharma.medication("fever").size());
    assertEquals(1, pharma.safeMedicationFor("fever", insomnia).size());
  }
  private boolean pharmaSafeMedicationContains() {
    return pharma.safeMedicationFor("headache", "fever").contains("clonacho");
  }
  private boolean pharmaMedicationContains() {
    return pharma.medication("headache").contains("clonacho");
  }
  private void registerParacetablosWithClonachoAssertFalseAndReplacement(boolean condition) {
    registerParacetamolWithClonacho();
    assertFalse(condition);
    pharma.replacement("paracetamol", "clonacho");
  }


}
