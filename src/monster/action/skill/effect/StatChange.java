package monster.action.skill.effect;

import monster.Monster;
import monster.Stats;

import java.util.List;
import java.util.Random;

public class StatChange extends Effect{

    private int _duration;
    private int _turnCount;
    private String _name;

    private double _maxHPMultiplier;
    private double _currentHPMultiplier;
    private double _attackMultiplier;
    private double _defenseMultiplier;
    private double _critRateMultiplier;
    private double _critDamageMultiplier;
    private double _accuracyMultiplier;
    private double _resistanceMultiplier;
    private double _speedMultiplier;

    public StatChange(String name, int duration){
//        super(EffectType.StatChange);

        //default attack buff for testing
        this(name, duration, 1.0, 1.0, 1.5, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0);
//        _duration= duration;
//        _name = name;
//        _turnCount = 0;


//        _defenseMultiplier = 1.0;
//        _maxHPMultiplier = 1.0;
//        _currentHPMultiplier = 1.0;
//        _attackMultiplier = 1.5;
    }

    public StatChange(String name, int duration, double maxHPMultiplier, double currentHPMultiplier, double attackMultiplier, double defenseMultiplier, double critRateMultiplier, double critDamageMultiplier, double accuracyMultiplier, double resistanceMultiplier, double speedMultiplier){
        super(EffectType.StatChange);
        _name = name;
        _duration = duration;
        _turnCount = 0;
        _maxHPMultiplier = maxHPMultiplier;
        _currentHPMultiplier = currentHPMultiplier;
        _attackMultiplier = attackMultiplier;
        _defenseMultiplier = defenseMultiplier;
        _critRateMultiplier = critRateMultiplier;
        _critDamageMultiplier = critDamageMultiplier;
        _accuracyMultiplier = accuracyMultiplier;
        _resistanceMultiplier = resistanceMultiplier;
        _speedMultiplier = speedMultiplier;
    }

    public void raiseTurnCount(){
        _turnCount++;
    }

    public int getDuration(){
        return _duration;
    }

    public int getTurnCount(){
        return _turnCount;
    }

    public String getName(){
        return _name;
    }

    public void applyChange(Stats monsterStats){
        monsterStats.setMaxHP((int) (monsterStats.getMaxHP() * _maxHPMultiplier));
        monsterStats.setCurrentHP((int) (monsterStats.getCurrentHP() * _currentHPMultiplier));
        monsterStats.setAttack((int) (monsterStats.getAttack() * _attackMultiplier));
        monsterStats.setDefense((int)(monsterStats.getDefense() * _defenseMultiplier));
        monsterStats.setCritRate((int) (monsterStats.getCritRate() * _critRateMultiplier));
        monsterStats.setCritDamage((int) (monsterStats.getCritDamage() * _critDamageMultiplier));
        monsterStats.setAccuracy((int) (monsterStats.getAccuracy() * _accuracyMultiplier));
        monsterStats.setResistance((int) (monsterStats.getResistance() * _resistanceMultiplier));
        monsterStats.setSpeed((int) (monsterStats.getSpeed() * _speedMultiplier));
    }


    @Override
    public void apply(Monster activeMonster, List<Monster> possibleTargets) {
        Random rand = new Random();
        for(Monster target : possibleTargets){
            int rng = rand.nextInt(activeMonster.getAccuracy() + target.getResistance());
            if(rng > activeMonster.getAccuracy()){
                target.addStatChange(this);
            }
        }
    }
}
