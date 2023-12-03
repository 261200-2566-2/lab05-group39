public class Sword extends Equipment{

    Sword(int baseDmg, int baseDef){
        type = "sword";
        level = 1;
        this.baseDmg = baseDmg;
        this.baseDef = baseDef;
        equip = false;
    }

}
