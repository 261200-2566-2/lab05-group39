public class Charm extends Accessories{
    private boolean equip;

    Charm(){
        equip = false;
    }

    public void buffStats(Character c){
        c.setMaxMana(c.getMaxMana() + (3 * c.getLevel()));
        c.setMana(c.getMana() == c.getBaseMaxMana() ? c.getMaxMana() : c.getMana());
        c.setDefense((int) Math.floor(c.getDefense() + (0.2 * c.getLevel())));
        c.setMaxHp(c.getMaxHp() + (5 * c.getLevel()));
        c.setHp(c.getHp() == c.getBaseMaxHp() ? c.getMaxHp() : c.getHp());
    }

    public boolean isEquip(){
        return equip;
    }
    public void setEquip(boolean eq){
        equip = eq;
    }
}
