package monster;

import monster.action.Action;
import monster.action.skill.Skill;
import monster.action.skill.effect.AttackEffect;
import monster.action.skill.effect.Effect;
import monster.action.trigger.StatTrigger;
import monster.action.trigger.TargetType;
import monster.action.trigger.Trigger;

public class MonsterFactory {

    public Monster createMonster(){
        //just test data for now
        Monster monster = new Monster();
        monster.setName("TestMonster");
        monster.setTeam(1);

        Stats stats = new Stats(1000, 1000, 100, 40, 120, 300, 100, 60, 30);
        monster.setStats(stats);

        Trigger trigger = new StatTrigger(TargetType.EnemyTeam, 0, 100, 0, 100, 0, 100);
        Effect effect = new AttackEffect(1.0);

        Skill skill = new Skill("Auto Attack");
        skill.addEffect(effect);

        Action autoAttack = new Action(skill, trigger);

        monster.addAction(autoAttack, 0);

        return monster;
    }
}
