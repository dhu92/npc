package monster.action.skill.effect;

import monster.Monster;
import monster.Stats;

import java.util.List;

public class AttackEffect extends Effect {

    private double _multiplier;

    public AttackEffect() {
        super(EffectType.Attack);
        _multiplier = 1.0;
    }

    public AttackEffect(double multiplier){
        super(EffectType.Attack);
        _multiplier = multiplier;
    }

    @Override
    public void apply(Monster activeMonster, List<Monster> possibleTargets) {
        for(Monster target : possibleTargets){
            //Just for testing attack every enemy
            if(target.getTeam() != activeMonster.getTeam()) {
                target.setCurrentHp(target.getCurrentHp() - calculateDamage(activeMonster, target));
                if (target.getCurrentHp() <= 0) {
                    target.die();
                }
            }
        }
    }

    public int calculateDamage(Monster attacker, Monster defender){
        Stats attackerStats = attacker.getChangedStats();
        Stats defenderStats = defender.getChangedStats();

        //No def stat or something like that right now, so just return attack stat of attacker
        // formula from the internet:
        // realDamage = SkillDmg * BaseDamage * BaseDamage / (BaseDamage + Defense)

        return (int) (_multiplier * attackerStats.getAttack() * (attackerStats.getAttack() / (attackerStats.getAttack() * defenderStats.getDefense())));

    }

}
