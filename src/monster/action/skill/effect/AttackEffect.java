package monster.action.skill.effect;

import monster.Monster;
import monster.Stats;

import java.util.List;
import java.util.Random;

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

        //TODO: apply crit rate + crit damage
        // formula from the internet:
        // realDamage = SkillDmg * BaseDamage * BaseDamage / (BaseDamage + Defense)
        Random rand = new Random();
        int rng = rand.nextInt(100)+1;
        int dmg = attackerStats.getAttack();
        if(rng <= attackerStats.getCritRate()){
            dmg *= attackerStats.getCritDamage();
        }
        return (int) (_multiplier * dmg * (dmg / (dmg * defenderStats.getDefense())));
    }

}
