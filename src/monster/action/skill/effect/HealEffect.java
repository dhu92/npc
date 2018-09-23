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
    public void apply(Monster activeMonster, List<Monster> possibleTargets) {
        /*
        * Just testing
        */
        int healValue = 0;
        for(Monster target : possibleTargets){
            //Just for testing
            if(target.getTeam() == activeMonster.getTeam()) {
                healValue = calculateHealingValue(activeMonster, target);
                if (target.getCurrentHp() + healValue > target.getMaxHp()) {
                    target.setCurrentHp(target.getMaxHp());
                } else {
                    target.setCurrentHp(target.getCurrentHp() + healValue);
                }
            }
        }
    }

    private int calculateHealingValue(Monster healer, Monster target){
        //idk right now
        return (int) (target.getMaxHp()*(double)(_healPercentage/100.0));
    }
}
