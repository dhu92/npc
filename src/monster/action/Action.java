package monster.action;

import monster.Monster;
import monster.action.skill.Skill;
import monster.action.trigger.Trigger;

import java.util.List;

public class Action {

    private Skill _skill;
    private Trigger _trigger;
    private int _cooldown;

    public Action(){

    }

    public Action(Skill skill, Trigger trigger){
        _skill = skill;
        _trigger = trigger;
    }

    public Action(Skill skill){
        _skill = skill;
    }

    public boolean isTriggered(Monster currentActive, List<Monster> monsters){
        return _trigger.isTriggered(currentActive, monsters);
        //return true;
    }

    public void execute(Monster currentActive, List<Monster> monsters){
        _skill.execute(currentActive, monsters, _trigger);
    }

    public int getCooldown(){
        return _cooldown;
    }

    public void reduceCooldown(){
        if(_cooldown-1 < 0){
            _cooldown = 0;
        } else {
            _cooldown--;
        }
    }

    public void printAction(){
        System.out.println(_skill.getName());
    }
    public String getSkillName(){
        return _skill.getName();
    }
}
