package monster.action.skill.effect;

import monster.Monster;
import monster.Stats;

import java.util.List;

public class StatChange extends Effect{

    private int _duration;
    private int _turnCount;
    private String _name;

    private double _maxHPMultiplier;
    private double _currentHPMultiplier;
    private double _attackMultiplier;
    private double _defenseMultiplier;

    public StatChange(String name, int duration){
        super(EffectType.StatChange);
        _duration= duration;
        _name = name;
        _turnCount = 0;

        //default attack buff for testing
        _defenseMultiplier = 1.0;
        _maxHPMultiplier = 1.0;
        _currentHPMultiplier = 1.0;
        _attackMultiplier = 1.5;
    }

    public StatChange(String name, int duration, double maxHPMultiplier, double currentHPMultiplier, double attackMultiplier, double defenseMultiplier){
        _name = name;
        _duration = duration;
        _maxHPMultiplier = maxHPMultiplier;
        _currentHPMultiplier = currentHPMultiplier;
        _attackMultiplier = attackMultiplier;
        _defenseMultiplier = defenseMultiplier;
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
    }


    @Override
    public void apply(Monster activeMonster, List<Monster> possibleTargets) {
        for(Monster target : possibleTargets){
            target.addStatChange(this);
        }
    }
}
