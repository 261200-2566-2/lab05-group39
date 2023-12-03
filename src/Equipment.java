public abstract class Equipment {
    protected String type;
    protected int baseDmg;
    protected int baseDef;
    protected int dmg;
    protected int def;
    protected int level;
    protected double spdDec;
    protected boolean equip;

    public void setDmg(int dmg){
        this.dmg = dmg;
    }
    public int getDmg(){
        return dmg;
    }
    public void setDef(int def){
        this.def = def;
    }
    public int getDef(){
        return def;
    }

    public int getBaseDmg(){
        return baseDmg;
    }
    public int getBaseDef(){
        return baseDef;
    }

    public double getSpdDec() {
        return spdDec;
    }
    public void setSpdDec(double spdDec) {
        this.spdDec = spdDec;
    }

    public boolean isEquip() {
        return equip;
    }
    public void setEquip(boolean equip) {
        this.equip = equip;
    }
    public String getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
}
