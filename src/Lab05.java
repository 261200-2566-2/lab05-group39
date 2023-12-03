public class Lab05 {

    public static void main(String[] args){
        Knight a = new Knight("aragon");
        Mage b = new Mage("gandalf");
        Tank c = new Tank("Arthur");
        c.showStats();
        a.showStats();
        b.showStats();
        a.equipWeapon(true,"sword");
        c.equipWeapon(true,"shield");
        b.equipWeapon(true,"wand");
        b.levelUp(47);
        a.levelUp(48);
        b.eqLvlUp(20);
        a.eqLvlUp(20);
        a.showStats();
        c.showStats();
        b.equipAccessory(true,"ring");
        a.equipAccessory(true,"charm");
        a.showStats();
        b.showStats();
        a.Skill(b);
        b.Skill();
        a.attack(b);
        b.Skill();
        b.showStats();
        b.attack(a);
        a.showStats();
        b.showStats();
    }
}
