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
        monster.setName("TestAttackMonster");
        monster.setTeam(1);
        monster.setMonsterType(MonsterType.Attack);

        Stats stats = new Stats(1000, 1000, 100, 40, 120, 300, 100, 60, 30);
        monster.setStats(stats);

        monster.gainExperience(1000);

        Trigger trigger = new StatTrigger(TargetType.EnemyTeam, 0, 100, 0, 100, 0, 100);
        Effect effect = new AttackEffect(1.0);

        Skill skill = new Skill("Auto Attack");
        skill.addEffect(effect);

        Action autoAttack = new Action(skill, trigger);

        monster.addAction(autoAttack, 0);

        System.out.println(monster.getStatsAsString());

        monster = new Monster();
        monster.setName("TestSupportMonster");
        monster.setTeam(1);
        monster.setMonsterType(MonsterType.Support);

        stats = new Stats(1000, 1000, 100, 40, 120, 300, 100, 60, 30);
        monster.setStats(stats);

        monster.gainExperience(1000);

        trigger = new StatTrigger(TargetType.EnemyTeam, 0, 100, 0, 100, 0, 100);
        effect = new AttackEffect(1.0);

        skill = new Skill("Auto Attack");
        skill.addEffect(effect);

        autoAttack = new Action(skill, trigger);

        monster.addAction(autoAttack, 0);

        System.out.println(monster.getStatsAsString());

        monster = new Monster();
        monster.setName("TestTankMonster");
        monster.setTeam(1);
        monster.setMonsterType(MonsterType.Tank);

        stats = new Stats(1000, 1000, 100, 40, 120, 300, 100, 60, 30);
        monster.setStats(stats);

        monster.gainExperience(1000);

        trigger = new StatTrigger(TargetType.EnemyTeam, 0, 100, 0, 100, 0, 100);
        effect = new AttackEffect(1.0);

        skill = new Skill("Auto Attack");
        skill.addEffect(effect);

        autoAttack = new Action(skill, trigger);

        monster.addAction(autoAttack, 0);

        System.out.println(monster.getStatsAsString());

        return monster;
    }
}