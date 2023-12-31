package robotWars;

import java.util.ArrayList;

public class Aluminium3000 extends Robot{
    int weaponWeightLeft;
    int speed;
    int life;
    ArrayList<Weapon> weapons = new ArrayList<Weapon>();
    public Aluminium3000(){
        this.weaponWeightLeft = 50;
        this.speed = 90;
        this.life = 100;
        weapons = new ArrayList<Weapon>();
    }
    public int getSpeed() {
        int toReturn = speed;
        for (Weapon weapon : weapons) {
            toReturn -= weapon.speedImpact();
        }
        return toReturn;
    }

    @Override
    public int getLife() {
        return life;
    }

    @Override
    public void affectLife(int x) {
        this.life -= x;
    }

    @Override
    public int totalWeaponWeightLeft() {
        int toReturn = weaponWeightLeft;
        for (Weapon weapon : weapons) {
            toReturn -= weapon.getWeight();
        }
        return toReturn;
    }

    @Override
    public void addWeapon(Weapon weapon) {
        if(weapon.getWeight() > totalWeaponWeightLeft()){
            throw new RuntimeException("Weapon too heavy");
        }
        weapons.add(weapon);
    }

    @Override
    public void attack(Robot robotAttacked, Weapon weapon) {
        for (Weapon weapon1 : weapons) {
            if(weapon1.equals(weapon)){
                robotAttacked.getAttackedWith(weapon,this);
                return;
            }
        }
        throw new RuntimeException("Cannot attack with weapon not owned");}

    @Override
    protected void getAttackedWith(Weapon weapon, Robot robotAttacker) {
        weapon.attacksAtAluminium(this,robotAttacker);
    }

    @Override
    public void removeWeapon(Claw weapon) {
        weapons.remove(weapon);
    }

}
