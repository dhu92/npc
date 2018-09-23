package monster;

public class Stats {

    private double _maxHP;
    private double _currentHP;
    private double _attack;
    private double _critRate;
    private double _critDamage;
    private double _defense;
    private double _speed;
    private double _accuracy;
    private double _resistance;

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

    public Stats(double maxHP, double currentHP, double attack, double critRate, double critDamage, double defense, double speed, double accuracy, double resistance) {
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

    public void setMaxHP(double hp){
        _maxHP = hp;
    }

    public double getMaxHP(){
        return _maxHP;
    }

    public void setCurrentHP(double hp){
        _currentHP = hp;
    }

    public double getCurrentHP(){
        return _currentHP;
    }

    public void setAttack(double attack){
        _attack = attack;
    }

    public double getAttack(){
        return _attack;
    }

    public double getDefense(){return _defense;}

    public void setDefense(double defense){_defense = defense;}

    public void setCritRate(double critRate){
        if(critRate > 100){
            _critRate = 100;
        } else {
            _critRate = critRate;
        }
    }

    public double getCritRate(){
        return _critRate;
    }

    public void setCritDamage(double critDamage){

        _critDamage = critDamage;
    }

    public double getCritDamage(){
        return _critDamage;
    }

    public void setSpeed(double speed){
        _speed = speed;
    }

    public double getSpeed(){
        return _speed;
    }

    public void setAccuracy(double accuracy){
        if(accuracy > 100){
            _accuracy = 100;
        } else {
            _accuracy = accuracy;
        }
    }

    public double getAccuracy(){
        return _accuracy;
    }

    public void setResistance(double resistance){
        if(resistance > 100) {
            _resistance = 100;
        } else {
            _resistance = resistance;
        }
    }

    public double getResistance(){
        return _resistance;
    }
    public Stats copy(){
        Stats copy = new Stats();
        return new Stats(_maxHP, _currentHP, _attack, _critRate, _critDamage, _defense, _speed, _accuracy, _resistance);
    }
}
