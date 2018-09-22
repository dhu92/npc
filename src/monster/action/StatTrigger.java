package monster.action;

import monster.Monster;

public class StatTrigger extends Trigger{

    //TODO: add remaining stats
    private double _lowPercentageHP;
    private double _highPercentageHP;
    private double _lowPercentageAttack;
    private double _highPercentageAttack;
    private double _lowPercentageDefense;
    private double _highPercentageDefense;

    public StatTrigger(TargetType target, double lowHP, double highHP, double lowAttack, double highAttack, double lowDefense, double highDefense){
        super(target);
        _lowPercentageAttack = lowAttack;
        _highPercentageAttack = highAttack;
        _lowPercentageHP = lowHP;
        _highPercentageHP = highHP;
        _lowPercentageDefense = lowDefense;
        _highPercentageDefense = highDefense;
    }


    @Override
    public boolean matchesTriggerConditions(Monster monster) {
        //for now just 1 stat trigger
        if(monster.getMaxHp() * _lowPercentageHP < monster.getCurrentHp() && monster.getMaxHp() * _highPercentageHP > monster.getCurrentHp()){
            return true;
        } else if(monster.getAttack() * _lowPercentageAttack < monster.getAttack() && monster.getAttack() * _highPercentageAttack > monster.getAttack()){
            return true;
        } else if(monster.getDefense() * _lowPercentageDefense < monster.getDefense() && monster.getDefense() * _highPercentageDefense > monster.getDefense()){
            return true;
        }
        return false;
    }
}
