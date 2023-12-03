import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RobotTest {
    @Test
    public void test00Alumium3000IsAtInitialState(){
        Aluminium3000 aluminium3000 = new Aluminium3000();
        assertEquals(100, aluminium3000.life());
        assertEquals(90, aluminium3000.speed());
        assertEquals(50, aluminium3000.maximumWeaponWeight());
    }

    @Test public void test01TankRoverIsAtInitialState(){
        TankRover tankRover = new TankRover();
        assertEquals(100, tankRover.life());
        assertEquals(40, tankRover.speed());
        assertEquals(200, tankRover.maximumWeaponWeight());
    }

    @Test public void test02Aluminium3000CanCarryClaw(){
        Aluminium3000 aluminium3000 = new Aluminium3000();
        Claw claw = new Claw();
        aluminium3000.carryWeaponWith(claw);
        assertEquals(1, aluminium3000.weaponsCarrying.size());
        assertEquals(claw, aluminium3000.weaponsCarrying.get(0));
        assertEquals(85,aluminium3000.speed());
    }

    @Test public void test03Aluminuim3000CamCarryBlaster(){
        Aluminium3000 aluminium3000 = new Aluminium3000();
        Blaster blaster = new Blaster();
        aluminium3000.carryWeaponWith(blaster);
        assertEquals(1, aluminium3000.weaponsCarrying.size());
        assertEquals(blaster, aluminium3000.weaponsCarrying.get(0));
        assertEquals(80,aluminium3000.speed());

    }

    @Test public void test04Alumium3000CanCarryClawAndBlaster(){
        Aluminium3000 aluminium3000 = new Aluminium3000();
        Claw claw = new Claw();
        Blaster blaster = new Blaster();
        aluminium3000.carryWeaponWith(claw);
        aluminium3000.carryWeaponWith(blaster);
        assertEquals(2, aluminium3000.weaponsCarrying.size());
        assertEquals(claw, aluminium3000.weaponsCarrying.get(0));
        assertEquals(blaster, aluminium3000.weaponsCarrying.get(1));
        assertEquals(75,aluminium3000.speed());
    }

    @Test public void test05TankRoverCanCarryClaw(){
        TankRover tankRover = new TankRover();
        Claw claw = new Claw();
        tankRover.carryWeaponWith(claw);
        assertEquals(1, tankRover.weaponsCarrying.size());
        assertEquals(claw, tankRover.weaponsCarrying.get(0));
        assertEquals(35,tankRover.speed());

    }

    @Test public void test06TankRoverCanCarryBlaster(){
        TankRover tankRover = new TankRover();
        Blaster blaster = new Blaster();
        tankRover.carryWeaponWith(blaster);
        assertEquals(1, tankRover.weaponsCarrying.size());
        assertEquals(blaster, tankRover.weaponsCarrying.get(0));
        assertEquals(30,tankRover.speed());

    }

    @Test public void test07TankRoverCanCarryClawAndBlaster(){
        TankRover tankRover = new TankRover();
        Claw claw = new Claw();
        Blaster blaster = new Blaster();
        tankRover.carryWeaponWith(claw);
        tankRover.carryWeaponWith(blaster);
        assertEquals(2, tankRover.weaponsCarrying.size());
        assertEquals(claw, tankRover.weaponsCarrying.get(0));
        assertEquals(blaster, tankRover.weaponsCarrying.get(1));
        assertEquals(25,tankRover.speed());
    }

    @Test public void test08ThrowsErrorWhenGarbbingClawTwoTimes(){
        Aluminium3000 aluminium3000 = new Aluminium3000();
        Claw claw = new Claw();
        aluminium3000.carryWeaponWith(claw);
        try {
            aluminium3000.carryWeaponWith(claw);
        } catch (RuntimeException e){
            assertEquals("Robot is already carrying this weapon", e.getMessage());
        }
    }
    @Test public void test09ThrowsErrorWhenGrabbingBlasterTwoTimes(){
        Aluminium3000 aluminium3000 = new Aluminium3000();
        Blaster blaster = new Blaster();
        aluminium3000.carryWeaponWith(blaster);
        try {
            aluminium3000.carryWeaponWith(blaster);
        } catch (RuntimeException e){
            assertEquals("Robot is already carrying this weapon", e.getMessage());
        }
    }

    @Test public void test10AluminiumRecoivesAttackByBlaster(){
        Aluminium3000 aluminium3000 = new Aluminium3000();
        Blaster blaster = new Blaster();
        aluminium3000.receiveAttack(blaster);
        assertEquals(95, aluminium3000.life());
    }

    @Test public void test11AlumiunimReceivesAttackByClaw(){
        Aluminium3000 aluminium3000 = new Aluminium3000();
        Claw claw = new Claw();
        aluminium3000.receiveAttack(claw);
        assertEquals(75, aluminium3000.life());
    }

    @Test public void test12TankRoverReceivesAttackByBlaster(){
        TankRover tankRover = new TankRover();
        Blaster blaster = new Blaster();
        tankRover.receiveAttack(blaster);
        assertEquals(50, tankRover.life());
    }
    @Test public void test13TankRoverReceivesAttackByClaw(){
        TankRover tankRover = new TankRover();
        Claw claw = new Claw();
        tankRover.receiveAttack(claw);
        assertEquals(95, tankRover.life());
    }

}
