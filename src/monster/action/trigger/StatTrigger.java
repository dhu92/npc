package monster.action.trigger;

import monster.Monster;
import monster.action.TargetType;

public class StatTrigger extends Trigger{

    private double _lowPercentageHP;
    private double _highPercentageHP;
    private double _lowPercentageAttack;
    private double _highPercentageAttack;
    private double _lowPercentageDefense;
    private double _highPercentageDefense;
    private double _lowPercantageCritRate;
    private double _highPercentageCritRate;
    private double _lowPercentageCritDamage;
    private double _highPercentageCritDamage;
    private double _lowPercentageSpeed;
    private double _highPercentageSpeed;
    private double _lowPercentageAccuracy;
    private double _highPercentageAccurancy;
    private double _lowPercentageResistance;
    private double _highPercentageResistance;

    public StatTrigger(TargetType target, double lowHP, double highHP, double lowAttack, double highAttack, double lowDefense, double highDefense, double lowPercentageCritRate, double highPercentageCritRate,
                       double lowPercentageCritDamage, double highPercentageCritDamage, double lowPercentageSpeed, double highPercentageSpeed, double lowPercentageAccuracy, double highPercentageAccuracy,
                       double lowPercentageResistance, double highPercentageReistance){
        super(target);
        _lowPercentageAttack = lowAttack;
        _highPercentageAttack = highAttack;
        _lowPercentageHP = lowHP;
        _highPercentageHP = highHP;
        _lowPercentageDefense = lowDefense;
        _highPercentageDefense = highDefense;
        _lowPercantageCritRate = lowPercentageCritRate;
        _highPercentageCritRate = highPercentageCritRate;
        _lowPercentageCritDamage = lowPercentageCritDamage;
        _highPercentageCritDamage = highPercentageCritDamage;
        _lowPercentageSpeed = lowPercentageSpeed;
        _highPercentageSpeed = highPercentageSpeed;
        _lowPercentageAccuracy = lowPercentageAccuracy;
        _highPercentageAccurancy = highPercentageAccuracy;
        _lowPercentageResistance = lowPercentageResistance;
        _highPercentageResistance = highPercentageReistance;
    }

    //TODO: add remaining stats
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
