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
    public void apply(Monster activeMonster, Monster target) {
        target.onHit(calculateDamage(activeMonster, target));
//        target.setCurrentHp((int) (target.getCurrentHp() - calculateDamage(activeMonster, target)));
//        if (target.getCurrentHp() <= 0) {
//            target.die();
//        }
    }

    //For now, highest damage is best match
    @Override
    public Monster findBestMatch(Monster activeMonster, List<Monster> monsters) {
        Monster currentBestMatch = monsters.get(0);
        int highestDamage = 0;
        for(Monster monster : monsters){
            if(calculateDamage(activeMonster, monster) > highestDamage){
                highestDamage = (int) calculateDamage(activeMonster, monster);
                currentBestMatch = monster;
            }
        }
        return currentBestMatch;
    }


    public double calculateDamage(Monster attacker, Monster defender){
        Stats attackerStats = attacker.getChangedStats();
        Stats defenderStats = defender.getChangedStats();

        //TODO: apply crit rate + crit damage
        // formula from the internet:
        // realDamage = SkillDmg * BaseDamage * BaseDamage / (BaseDamage + Defense)
        Random rand = new Random();
        int rng = rand.nextInt(100)+1;
        double dmg = attackerStats.getAttack();

        if(rng <= attackerStats.getCritRate()){
            dmg += attackerStats.getAttack() * (attackerStats.getCritDamage()/100.0);
        }
        return (_multiplier * dmg * (dmg / (dmg + defenderStats.getDefense())));
    }

}
