public class Wand extends Equipment{
    Wand (int baseDmg, int baseDef){
        type = "wand";
        level = 1;
        this.baseDmg = baseDmg;
        this.baseDef = baseDef;
        equip = false;
    }
}
