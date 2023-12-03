public abstract class Character{
    protected String name;
    protected String classes;
    protected boolean alive;
    protected int level;
    protected int baseMaxHp;
    protected int maxHp;
    protected int hp;
    protected int baseMaxMana;
    protected int maxMana;
    protected int mana;
    protected int baseDmg;
    protected int damage;
    protected int baseDef;
    protected int defense;
    protected double baseRunSpd;
    protected double runSpd;
    protected double baseDmgLvlUp;
    protected double swordDmgLvlUp;
    protected double shieldDmgLvlUp;
    protected double wandDmgLvlUp;
    protected double baseDefLvlUp;
    protected double swordDefLvlUp;
    protected double shieldDefLvlUp;
    protected double wandDefLvlUp;
    protected double baseSpdLvlUp;
    protected double swordSpdDec;
    protected double shieldSpdDec;
    protected double wandSpdDec;
    protected Equipment equipment;
    protected Sword sword;
    protected Shield shield;
    protected Wand wand;
    protected Bracelet bracelet;
    protected Charm charm;
    protected Ring ring;

    protected void setDmg(double baseBonus, double equipBonus){
        baseDmg = (int) Math.floor(baseDmg + (baseBonus * level));
        equipment.setDmg((int) Math.floor(equipment.getBaseDmg() + (equipBonus * equipment.getLevel())));
        if (equipment.isEquip()) damage = baseDmg + equipment.getDmg();
        else damage = baseDmg;
    }
    protected void setDef(double baseBonus, double equipBonus){
        baseDef = (int) Math.floor(baseDef + (baseBonus * level));
        equipment.setDef((int) Math.floor(equipment.getBaseDef() + (equipBonus * equipment.getLevel())));
        if (equipment.isEquip()) defense = baseDef + equipment.getDef();
        else defense = baseDef;
    }
    protected void setSpd(double baseBonus, double equipDec){
        runSpd = baseRunSpd + (baseBonus * (level - 1)); //0.03
        int spdDecFac = equipment.getLevel() - level;
        equipment.setSpdDec(equipDec * (spdDecFac + 4));

        if (equipment.isEquip()) {
            runSpd -= equipment.getSpdDec() > 0 ? equipment.getSpdDec() : 0;
        }

        if (runSpd < 0.1) runSpd = 0.1;
    }
    protected void resetHp(){
        maxHp = baseMaxHp;
        if (hp > maxHp) hp = maxHp;
    }
    protected void resetMana(){
        maxMana = baseMaxMana;
        if (mana > maxMana) mana = maxMana;
    }
    protected void setStats(){
        double eqDmg = equipment.getType().equals("sword") ? swordDmgLvlUp : equipment.getType().equals("shield") ? shieldDmgLvlUp : wandDmgLvlUp;
        double eqDef = equipment.getType().equals("sword") ? swordDefLvlUp : equipment.getType().equals("shield") ? shieldDefLvlUp : wandDefLvlUp;
        double eqSpd = equipment.getType().equals("sword") ? swordSpdDec : equipment.getType().equals("shield") ? shieldSpdDec : wandSpdDec;

        //set stats from equipment & accessories
        setDmg(baseDmgLvlUp, eqDmg);
        setDef(baseDefLvlUp, eqDef);
        setSpd(baseSpdLvlUp, eqSpd);
        resetHp();
        resetMana();

        if (bracelet.isEquip()) bracelet.buffStats(this);
        if (charm.isEquip()) charm.buffStats(this);
        if (ring.isEquip()) ring.buffStats(this);
    }

    public void showStats(){
        System.out.println("Name: " + name);
        System.out.println("Class: " + (classes.equals("knight") ? "Knight" : classes.equals("mage") ? "Mage" : "Tank"));
        System.out.println("Lvl: " + level);
        System.out.println("HP: " + hp + "/" + maxHp);
        System.out.println("Mana: " + mana + "/" + maxMana);
        System.out.println("Speed: " + String.format("%.2f", runSpd));
        System.out.println("Damage:" + damage);
        System.out.println("Defense: " + defense);
        String eqLvl = equipment.isEquip() ? "(Lvl " + equipment.getLevel() + ")" : "";
        if (equipment.getType().equals("sword")) System.out.println("Sword Equipped" + eqLvl + ": " + equipment.isEquip());
        else if (equipment.getType().equals("shield")) System.out.println("Shield Equipped" + eqLvl + ": "+ equipment.isEquip());
        else if (equipment.getType().equals("wand")) System.out.println("Wand Equipped" + eqLvl + ": "+ equipment.isEquip());

        System.out.println("========================");
    }

    public abstract void levelUp(int lvl);

    public void eqLvlUp(int lvl){
        equipment.setLevel(equipment.getLevel() + lvl);

        setStats();
    }

    public void equipWeapon(boolean eq, String type){
        boolean sameType = equipment.getType().equals(type);
        String sType = equipment.getType().equals("sword") ? "Sword" : equipment.getType().equals("shield") ? "Shield" : "Wand";
        Equipment eType = type.equals("sword") ? sword : type.equals("shield") ? shield : wand;
        if (!sameType && !eq){
            System.out.println(sType + " is not equipped");
            return;
        }

        if (!sameType && eq){
            equipment.setEquip(false);
            equipment = eType;
            equipment.setEquip(true);
        }
        else{
            equipment.setEquip(eq);
        }

        setStats();
    }

    public void equipAccessory(boolean eq, String type){
        if (type.equals("bracelet")){
            bracelet.setEquip(eq);
        }
        else if (type.equals("charm")){
            charm.setEquip(eq);
        }
        else if (type.equals("ring")){
            ring.setEquip(eq);
        }

        setStats();
    }

    public void attack(Character c){
        if (!alive){
            System.out.println(name + " is Ded");
            return;
        }
        if (!c.getAlive()){
            System.out.println(c.getName() + " is already Ded...");
            return;
        }

        int dmgDone = damage - c.getDefense();
        if (dmgDone < 0) dmgDone = 0;

        if (c.getHp() <= dmgDone){
            c.setHp(0);
            c.setAlive(false);
            System.out.println("Eliminated " + c.getName() + " out of Existence.");
        }
        else{
            c.setHp(c.getHp() - dmgDone);
            System.out.println(name + " Deal " + dmgDone + " to " + c.getName() + ", " + c.getName() + " has " + c.getHp() + " health remaining.");
        }
    }

    public String getName() {
        return name;
    }

    public int getHp(){
        return hp;
    }
    public void setHp(int hp){
        this.hp = hp;
    }

    public int getMaxHp() {
        return maxHp;
    }
    public int getBaseMaxHp() {
        return baseMaxHp;
    }
    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public boolean getAlive(){
        return alive;
    }
    public void setAlive(boolean alive){
        this.alive = alive;
    }

    public double getRunSpd() {
        return runSpd;
    }
    public void setRunSpd(double runSpd) {
        this.runSpd = runSpd;
    }

    public int getLevel() {
        return level;
    }

    public int getMana() {
        return mana;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getBaseMaxMana() {
        return baseMaxMana;
    }
    public int getMaxMana() {
        return maxMana;
    }
    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public int getDefense() {
        return defense;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }

}
