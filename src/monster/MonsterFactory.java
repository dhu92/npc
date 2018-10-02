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

import java.util.ArrayList;
import java.util.List;


public class MonsterFactory {

    public Monster createMonsterFromJson(){
        return null;
    }

    public List<Monster> createTestMonster(){
        //just test data for now
        Monster attackMonster = new Monster();
        attackMonster.setName("TestAttackMonster");
        attackMonster.setTeam(1);
        attackMonster.setMonsterType(MonsterType.Attack);

        Stats stats = new Stats(1000, 1000, 100, 40, 120, 300, 100, 60, 30);
        attackMonster.setStats(stats);

        attackMonster.gainExperience(1000);

        //just for now
        attackMonster.setCurrentHp(attackMonster.getMaxHp());

        Trigger trigger = new StatTrigger(TargetType.EnemyTeam, 0, 100, 0, 100, 0, 100, 0, 100, 0, 100, 0, 100, 0, 100, 0, 100);
        Effect effect = new AttackEffect(1.0);

        Skill skill = new Skill("Auto Attack");
        skill.addEffect(effect);

        Action autoAttack = new Action(skill, trigger, 0);

        attackMonster.addAction(autoAttack, 0);

        System.out.println(attackMonster.getStatsAsString());

        Monster supportMonster = new Monster();
        supportMonster.setName("TestSupportMonster");
        supportMonster.setTeam(1);
        supportMonster.setMonsterType(MonsterType.Support);

        Stats stats1 = new Stats(1000, 1000, 100, 40, 120, 300, 100, 60, 30);
        supportMonster.setStats(stats1);

        supportMonster.gainExperience(1000);

        //Just for now
        supportMonster.setCurrentHp(supportMonster.getMaxHp());

        Trigger trigger1 = new StatTrigger(TargetType.EnemyTeam, 0, 100, 0, 100, 0, 100,0,100,0,100,0,100,0,100,0,100);
        Effect effect1 = new AttackEffect(1.0);

        Skill skill1 = new Skill("Auto Attack");
        skill1.addEffect(effect1);

        Action autoAttack1 = new Action(skill1, trigger1, 0);

        Effect buffEffect = new StatChange(2);
        Trigger buffTrigger = new StatChangeTrigger(TargetType.Team, (StatChange) buffEffect);

        Skill atkBuff = new Skill("Attack Buff");
        atkBuff.addEffect(buffEffect);

        supportMonster.addAction(new Action(atkBuff, buffTrigger, 2), 0);
        supportMonster.addAction(autoAttack1, 1);

        System.out.println(supportMonster.getStatsAsString());

        Monster tankMonster = new Monster();
        tankMonster.setName("TestTankMonster");
        tankMonster.setTeam(1);
        tankMonster.setMonsterType(MonsterType.Tank);

        Stats stats2 = new Stats(1000, 1000, 100, 40, 120, 300, 100, 60, 30);
        tankMonster.setStats(stats2);

        tankMonster.gainExperience(1000);

        //Just for now
        tankMonster.setCurrentHp(tankMonster.getMaxHp());

        Trigger trigger2 = new StatTrigger(TargetType.EnemyTeam, 0, 100, 0, 100, 0, 1000,0,100,0,100,0,100,0,100,0,100);
        Effect effect2 = new AttackEffect(1.0);

        Skill skill2 = new Skill("Auto Attack");
        skill2.addEffect(effect2);

        Action autoAttack3 = new Action(skill2, trigger2, 0);

        Trigger healTrigger = new StatTrigger(TargetType.Self, 0, 70, 0, 100, 0, 100, 0,100,0,100,0,100,0,100,0,100);
        Effect healEffect = new HealEffect(20);

        Skill healSkill = new Skill("SelfHeal");
        healSkill.addEffect(healEffect);

        Action heal = new Action(healSkill, healTrigger, 2);

        tankMonster.addAction(heal, 0);

        tankMonster.addAction(autoAttack3, 1);

        System.out.println(tankMonster.getStatsAsString());

        test(attackMonster, supportMonster, tankMonster);
        List<Monster> monsters = new ArrayList<>();
        monsters.add(attackMonster);
        monsters.add(supportMonster);
        monsters.add(tankMonster);
        return monsters;
    }

    public void test(Monster attackMonster, Monster supportMonster, Monster tankMonster){
        AttackEffect attackEffect = new AttackEffect(1.0);
            System.out.println("Attacker vs. Tank damage: " +attackEffect.calculateDamage(attackMonster, tankMonster));
            System.out.println("Attacker vs. Support damage: " +attackEffect.calculateDamage(attackMonster, supportMonster));
            System.out.println("Tank vs. Support damage: " + attackEffect.calculateDamage(tankMonster, supportMonster));
            System.out.println("Tank vs. Attacker damage: " + attackEffect.calculateDamage(tankMonster, attackMonster));
            System.out.println("Support vs. Tank damage: " + attackEffect.calculateDamage(supportMonster, tankMonster));
            System.out.println("Support vs. Attacker damage: " + attackEffect.calculateDamage(supportMonster, attackMonster));

    }

    public void healMonster(Monster monster){
        monster.setCurrentHp(monster.getMaxHp());
    }
}
