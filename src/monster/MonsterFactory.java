package monster;

import monster.action.Action;
import monster.action.skill.Skill;
import monster.action.skill.effect.AttackEffect;
import monster.action.skill.effect.Effect;
import monster.action.skill.effect.HealEffect;
import monster.action.skill.effect.StatChange;
import monster.action.trigger.StatChangeTrigger;
import monster.action.trigger.StatTrigger;
import monster.action.TargetType;
import monster.action.trigger.Trigger;


public class MonsterFactory {

    public Monster createMonsterFromJson(){
        return null;
    }

    public Monster createTestMonster(){
        //just test data for now
        Monster monster = new Monster();
        monster.setName("TestAttackMonster");
        monster.setTeam(1);
        monster.setMonsterType(MonsterType.Attack);

        Stats stats = new Stats(1000, 1000, 100, 40, 120, 300, 100, 60, 30);
        monster.setStats(stats);

        monster.gainExperience(1000);

        //just for now
        monster.setCurrentHp(monster.getMaxHp());

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

        //Just for now
        monster.setCurrentHp(monster.getMaxHp());

        trigger = new StatTrigger(TargetType.EnemyTeam, 0, 100, 0, 100, 0, 100);
        effect = new AttackEffect(1.0);

        skill = new Skill("Auto Attack");
        skill.addEffect(effect);

        autoAttack = new Action(skill, trigger);


        Effect buffEffect = new StatChange(2);
        Trigger buffTrigger = new StatChangeTrigger(TargetType.Team, (StatChange) buffEffect);

        Skill atkBuff = new Skill("Attack Buff");
        atkBuff.addEffect(buffEffect);

        monster.addAction(new Action(atkBuff, buffTrigger), 0);
        monster.addAction(autoAttack, 1);

        System.out.println(monster.getStatsAsString());

        monster = new Monster();
        monster.setName("TestTankMonster");
        monster.setTeam(1);
        monster.setMonsterType(MonsterType.Tank);

        stats = new Stats(1000, 1000, 100, 40, 120, 300, 100, 60, 30);
        monster.setStats(stats);

        monster.gainExperience(1000);

        //Just for now
        monster.setCurrentHp(monster.getMaxHp());

        trigger = new StatTrigger(TargetType.EnemyTeam, 0, 100, 0, 100, 0, 100);
        effect = new AttackEffect(1.0);

        skill = new Skill("Auto Attack");
        skill.addEffect(effect);

        autoAttack = new Action(skill, trigger);

        Trigger healTrigger = new StatTrigger(TargetType.Self, 0, 70, 0, 100, 0, 100);
        Effect healEffect = new HealEffect(20);

        Skill healSkill = new Skill("SelfHeal");
        healSkill.addEffect(healEffect);

        Action heal = new Action(healSkill, healTrigger);

        monster.addAction(heal, 0);

        monster.addAction(autoAttack, 1);

        System.out.println(monster.getStatsAsString());

        return monster;
    }
}
