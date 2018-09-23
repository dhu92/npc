package monster;

public class Stats {

    private int _maxHP;
    private int _currentHP;
    private int _attack;
    private int _critRate;
    private int _critDamage;
    private int _defense;
    private int _speed;
    private int _accuracy;
    private int _resistance;

    public Stats(){

    }

//    public Stats(int hp, int attack, int defense){
//        _maxHP = hp;
//        _attack = attack;
//        _currentHP = _maxHP;
//        _defense = defense;
//    }

//    public Stats(int maxHP, int currentHP, int attack, int defense){
//        _maxHP = maxHP;
//        _currentHP = currentHP;
//        _attack = attack;
//        _defense = defense;
//    }

    public Stats(int maxHP, int currentHP, int attack, int critRate, int critDamage, int defense, int speed, int accuracy, int resistance) {
        _maxHP = maxHP;
        _currentHP = currentHP;
        _attack = attack;
        _defense = defense;
        if(critRate > 100){
            _critRate = 100;
        } else {
            _critRate = critRate;
        }
        _critDamage = critDamage;
        _speed = speed;
        if(accuracy > 100) {
            _accuracy = 100;
        } else {
            _accuracy = accuracy;
        }
        if(resistance > 100){
            _resistance = 100;
        } else {
            _resistance = resistance;
        }
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

    public void setCritRate(int critRate){
        if(critRate > 100){
            _critRate = 100;
        } else {
            _critRate = critRate;
        }
    }

    public int getCritRate(){
        return _critRate;
    }

    public void setCritDamage(int critDamage){

        _critDamage = critDamage;
    }

    public int getCritDamage(){
        return _critDamage;
    }

    public void setSpeed(int speed){
        _speed = speed;
    }

    public int getSpeed(){
        return _speed;
    }

    public void setAccuracy(int accuracy){
        if(accuracy > 100){
            _accuracy = 100;
        } else {
            _accuracy = accuracy;
        }
    }

    public int getAccuracy(){
        return _accuracy;
    }

    public void setResistance(int resistance){
        if(resistance > 100) {
            _resistance = 100;
        } else {
            _resistance = resistance;
        }
    }

    public int getResistance(){
        return _resistance;
    }
    public Stats copy(){
        Stats copy = new Stats();
        return new Stats(_maxHP, _currentHP, _attack, _critRate, _critDamage, _defense, _speed, _accuracy, _resistance);
    }
}
