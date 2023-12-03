public class Shield extends Equipment{
    Shield(int baseDmg, int baseDef){
        type = "shield";
        level = 1;
        this.baseDef = baseDef;
        this.baseDmg = baseDmg;
        equip = false;
    }

}
