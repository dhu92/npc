package monster;

public class Stats {

    private int _maxHP;
    private int _currentHP;
    private int _attack;
    private int _defense;

    public Stats(){

    }

    public Stats(int hp, int attack, int defense){
        _maxHP = hp;
        _attack = attack;
        _currentHP = _maxHP;
        _defense = defense;
    }

    public Stats(int maxHP, int currentHP, int attack, int defense){
        _maxHP = maxHP;
        _currentHP = currentHP;
        _attack = attack;
        _defense = defense;
    }

    public void setMaxHP(int hp){
        _maxHP = hp;
    }

    public int getMaxHP(){
        return _maxHP;
    }

    public void setCurrentHP(int hp){
        _currentHP = hp;
    }

    public int getCurrentHP(){
        return _currentHP;
    }

    public void setAttack(int attack){
        _attack = attack;
    }

    public int getAttack(){
        return _attack;
    }

    public int getDefense(){return _defense;}

    public void setDefense(int defense){_defense = defense;}

    public Stats copy(){
        return new Stats(_maxHP, _currentHP, _attack);
    }
}
