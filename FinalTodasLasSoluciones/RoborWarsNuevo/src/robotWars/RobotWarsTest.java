package robotWars;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.function.Executable;

import static org.junit.Assert.assertEquals;

public class RobotWarsTest {
    Robot aluminium = createAluminium3000();
    Robot aluminium2 = createAluminium3000();

    Robot tankRover = createTankRover();
    Robot tankRover2 = createTankRover();

    Weapon claw = createClaw();

    Weapon blaster = createBlaster();

    @Before public void setup(){
        aluminium = new Aluminium3000();
        tankRover = createTankRover();
        claw = createClaw();
        blaster = createBlaster();
        aluminium2 = createAluminium3000();
        tankRover2 = createTankRover();
    }
    @Test public void test00AluminiumWithNoWeaponsIsAtInitialState(){
        assertEquals(50, aluminium.totalWeaponWeightLeft());
        assertEquals(90, aluminium.getSpeed());
        assertEquals(100,aluminium.getLife());
    }
    @Test public void test01TankRoverWithNoWeaponsIsAtInitialState(){
        assertEquals(200, tankRover.totalWeaponWeightLeft());
        assertEquals(50, tankRover.getSpeed());
        assertEquals(100,tankRover.getLife());
    }
    @Test
    public void test02AluminiumCaNCarryBlaster(){
        aluminium.addWeapon(blaster);
        assertEquals(30, aluminium.totalWeaponWeightLeft());
        assertEquals(80,aluminium.getSpeed());
    }
    @Test public void test03AluniumCanCarryClaw(){
        aluminium.addWeapon(claw);
        assertEquals(40, aluminium.totalWeaponWeightLeft());
        assertEquals(85,aluminium.getSpeed());
    }
    @Test public void test04TankRoverCanCarryBlaster(){
        tankRover.addWeapon(blaster);
        assertEquals(180, tankRover.totalWeaponWeightLeft());
        assertEquals(40,tankRover.getSpeed());
    }
    @Test public void test05TankRoverCanCarryClaw(){
        tankRover.addWeapon(claw);
        assertEquals(190, tankRover.totalWeaponWeightLeft());
        assertEquals(45,tankRover.getSpeed());
    }
    @Test public void test06AluminiumCanCarryBlasterAndClaw(){
        aluminium.addWeapon(blaster);
        aluminium.addWeapon(claw);
        assertEquals(20, aluminium.totalWeaponWeightLeft());
        assertEquals(75,aluminium.getSpeed());
    }
    @Test public void test07TankRoverCanCarryBlasterAndClaw(){
        tankRover.addWeapon(blaster);
        tankRover.addWeapon(claw);
        assertEquals(170, tankRover.totalWeaponWeightLeft());
        assertEquals(35,tankRover.getSpeed());
    }
    @Test public void test09AluminiumCanAttackAluminiumWithBlaster(){
        aluminium.addWeapon(blaster);
        aluminium.attack(aluminium2,blaster);
        assertEquals(95,aluminium2.getLife());
    }
    @Test public void test10AluminiumCanAttackAluminiumWithClaw(){
        aluminium.addWeapon(claw);
        aluminium.attack(aluminium2,claw);
        assertEquals(75,aluminium2.getLife());
    }
    @Test public void test11AluminiumCanAttackTankRoverWithBlaster(){
        aluminium.addWeapon(blaster);
        aluminium.attack(tankRover,blaster);
        assertEquals(50,tankRover.getLife());
    }
    @Test public void test12AluminiumCanAttackTankRoverWithClaw(){
        aluminium.addWeapon(claw);
        aluminium.attack(tankRover,claw);
        assertEquals(95,tankRover.getLife());
    }
    @Test public void test13TankRoverCanAttackTankRoverWithBlaster(){
        tankRover.addWeapon(blaster);
        tankRover.attack(tankRover2,blaster);
        assertEquals(50,tankRover2.getLife());
    }
    @Test public void test14TankRoverCanAttackTankRoverWithClaw(){
        tankRover.addWeapon(claw);
        tankRover.attack(tankRover2,claw);
        assertEquals(95,tankRover2.getLife());
    }
    @Test public void test15TankRoverCanAttackAluminiumWithBlaster(){
        tankRover.addWeapon(blaster);
        tankRover.attack(aluminium,blaster);
        assertEquals(95,aluminium.getLife());
    }
    @Test public void test16TankRoverCanAttackAluminiumWithClaw(){
        tankRover.addWeapon(claw);
        tankRover.attack(aluminium,claw);
        assertEquals(75,aluminium.getLife());
    }
    @Test public void test17AluminiumCanNotAttackWithWeaponNotBelongingToRobot(){
        assertThrowsLike(() -> aluminium.attack(aluminium2,claw),
                "Cannot attack with weapon not owned");
    }
    @Test public void test18TankRoverCanNotAttackWithWeaponNotBelongingToRobot(){
        assertThrowsLike(() -> tankRover.attack(tankRover2,claw),
                "Cannot attack with weapon not owned");
    }
    @Test public void test19AluminiumCanNotCarryWeaponTooHeavy(){
        aluminium.addWeapon(blaster);
        aluminium.addWeapon(blaster);
        assertThrowsLike(() -> aluminium.addWeapon(blaster),
                "Weapon too heavy");
    }
    @Test public void test20TankRoverCanNotCarryWeaponTooHeavy(){
        tankRover.addWeapon(blaster);
        tankRover.addWeapon(blaster);
        tankRover.addWeapon(blaster);
        tankRover.addWeapon(blaster);
        tankRover.addWeapon(blaster);
        tankRover.addWeapon(blaster);
        tankRover.addWeapon(blaster);
        tankRover.addWeapon(blaster);
        tankRover.addWeapon(blaster);
        tankRover.addWeapon(blaster);
        assertThrowsLike(() -> tankRover.addWeapon(blaster),
                "Weapon too heavy");
    }
    @Test public void test21TankRoverCanNotAttackTwiceWithClaw(){
        tankRover.addWeapon(claw);
        tankRover.attack(tankRover,claw);
        assertThrowsLike(() -> tankRover.attack(aluminium,claw),
                "Cannot attack with weapon not owned");
    }
    @Test public void test22AluminiumCanNotAttackThreeTimesWithClaw(){
        aluminium.addWeapon(claw);
        aluminium.attack(aluminium,claw);
        aluminium.attack(aluminium,claw);
        assertThrowsLike(() -> aluminium.attack(tankRover,claw),
                "Cannot attack with weapon not owned");
    }
    private void assertThrowsLike(Executable executable, String message) {
        assertEquals(message, assertThrows(Exception.class, executable).getMessage());
    }


    private Robot createAluminium3000() {
        return new Aluminium3000();
    }
    private Robot createTankRover() {
        return new TankRover();
    }
    private Weapon createClaw() {
        return new Claw();
    }
    private Weapon createBlaster() {
        return new Blaster();
    }

}
