public class Knight extends Character{

    Knight(String name){
        this.name = new String(name);
        classes = "knight";
        alive = true;
        level = 1;
        baseMaxHp = 100 + (10 * level);
        maxHp = baseMaxHp;
        hp = maxHp;
        baseMaxMana = 55 + (4 * level);
        maxMana = baseMaxMana;
        mana = maxMana;
        baseDmg = 3;
        damage = baseDmg;
        baseDef = 1;
        defense = baseDef;
        baseRunSpd = 1;
        baseDmgLvlUp = 0.7;
        swordDmgLvlUp = 1.3;
        shieldDmgLvlUp = 0.4;
        wandDmgLvlUp = 0.1;
        baseDefLvlUp = 0.2;
        swordDefLvlUp = 0.4;
        shieldDefLvlUp = 0.7;
        baseSpdLvlUp = 0.04;
        swordSpdDec = 0.02;
        shieldSpdDec = 0.05;
        wandSpdDec = 0.015;

        sword = new Sword(6, 3);
        shield = new Shield(1, 5);
        wand = new Wand(3,1);
        bracelet = new Bracelet();
        charm = new Charm();
        ring = new Ring();

        equipment = sword;

        setStats();
    }
    public void Skill(Character c){
        if(alive){
            if(mana>=10){
                System.out.println(name+" Use Tackle");
                if (!c.getAlive()){
                    System.out.println(c.getName() + " is already Ded...");
                    return;
                }
                mana -= 10;
                int dmgDone = damage*2 - c.getDefense();
                if (dmgDone < 0) dmgDone = 0;

                if (c.getHp() <= dmgDone){
                    c.setHp(0);
                    System.out.println("Eliminated " + c.getName() + " out of Existence.");
                    return;
                }
                else{
                    c.setHp(c.getHp() - dmgDone);
                    System.out.println("Deal " + dmgDone + " to " + c.getName() + ", " + c.getName() + " has " + c.getHp() + " health remaining.");
                }
            }
            else System.out.println("Your mana is low");

        }
        else System.out.println(name + " is dead.");
    }

    @Override
    public void levelUp(int lvl){
        level += lvl;

        baseMaxHp = 100 + (10 * level);
        maxHp = baseMaxHp;
        hp = maxHp;
        baseMaxMana = 55 + (4 * level);
        maxMana = baseMaxMana;
        mana = maxMana;

        setStats();
    }

}
