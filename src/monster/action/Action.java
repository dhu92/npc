package monster.action;

import monster.Monster;
import monster.action.skill.Skill;
import monster.action.trigger.Trigger;

import java.util.List;

public class Action {

    private Skill _skill;
    private Trigger _trigger;
    private int _cooldown;
    private int _currentCooldown;

    public Action(){

    }

    public Action(Skill skill, Trigger trigger, int cooldown){
        _skill = skill;
        _trigger = trigger;
        _cooldown = cooldown;
        _currentCooldown = 0;
    }

    public Action(Skill skill){
        _skill = skill;
    }

    public boolean isTriggered(Monster currentActive, List<Monster> monsters){
        return _trigger.isTriggered(currentActive, monsters, _currentCooldown);
    }

    public void execute(Monster currentActive, List<Monster> monsters){
        _skill.execute(currentActive, monsters, _trigger);
        //TODO: remove +1
        _currentCooldown = _cooldown + 1;
    }

    public int getCooldown(){
        return _cooldown;
    }
    public int getCurrentCooldown() { return _currentCooldown;}

    public void reduceCooldown(){
        if(_currentCooldown-1 < 0){
            _currentCooldown = 0;
        } else {
            _currentCooldown--;
        }
    }

    public Skill getSkill(){return _skill;}
    public void printAction(){
        System.out.println(_skill.getName());
    }
    public String getSkillName(){
        return _skill.getName();
    }
}
