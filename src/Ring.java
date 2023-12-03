public class Ring extends Accessories{
    private boolean equip;

    Ring(){
        equip = false;
    }

    public void buffStats(Character c){
        c.setMaxMana(c.getBaseMaxMana() + (5 * c.getLevel()));
        c.setDamage((int) Math.floor(c.getDamage() + (0.45 * c.getLevel())));
        c.setRunSpd(c.getRunSpd() + (0.01 * c.getLevel()));
    }

    public boolean isEquip(){
        return equip;
    }
    public void setEquip(boolean eq){
        equip = eq;
    }
}
