public class Bracelet extends Accessories{
    private boolean equip;

    Bracelet(){
        equip = false;
    }

    public void buffStats(Character c){
        c.setDamage((int) Math.floor(c.getDamage() + (0.5 * (c.getLevel()))));
        c.setDefense((int) Math.floor(c.getDefense() + (0.4 * c.getLevel())));
        c.setMaxHp(c.getMaxHp() + (6 * c.getLevel()));
        c.setHp(c.getHp() == c.getBaseMaxHp() ? c.getMaxHp() : c.getHp());
    }

    public boolean isEquip(){
        return equip;
    }
    public void setEquip(boolean eq){
        equip = eq;
    }
}
