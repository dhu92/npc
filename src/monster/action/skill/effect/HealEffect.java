package monster.action.skill.effect;

import monster.Monster;

import java.util.List;

public class HealEffect extends Effect{

    private double _healPercentage;

    public HealEffect(int healPercentage) {
        super(EffectType.Heal);
        _healPercentage = healPercentage;
    }

    @Override
    public void apply(Monster activeMonster, Monster target) {
        /*
        * Just testing
        */
        target.onHeal(calculateHealingValue(activeMonster, target));
//        int healValue = 0;
//        healValue = calculateHealingValue(activeMonster, target);
//        if (target.getCurrentHp() + healValue > target.getMaxHp()) {
//            target.setCurrentHp(target.getMaxHp());
//        } else {
//            target.setCurrentHp(target.getCurrentHp() + healValue);
//        }
    }

    @Override
    public Monster findBestMatch(Monster activeMonster, List<Monster> monsters) {
        Monster currentBestMatch = monsters.get(0);
        double highestPercentage = 0.0;
        for(Monster monster : monsters){
            if(calculateHealingValue(activeMonster, monster) > highestPercentage){
                highestPercentage = calculateHealingValue(activeMonster, monster);
                currentBestMatch = monster;
            }
        }
        return currentBestMatch;
    }


    private int calculateHealingValue(Monster healer, Monster target){
        //idk right now
        return (int) (target.getMaxHp()*(double)(_healPercentage/100.0));
    }
}
