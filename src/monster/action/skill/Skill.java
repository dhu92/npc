package monster.action.skill;

import monster.Monster;
import monster.action.skill.effect.Effect;
import monster.action.trigger.Trigger;

import java.util.ArrayList;
import java.util.List;

public class Skill {

    private String _name;
    private String _description;
    private List<Effect> _skillEffects;

    public Skill(String name){
        _name = name;
        _skillEffects = new ArrayList<>();
    }

    public void execute(Monster currentActive, List<Monster> monsters, Trigger trigger){
        for(Effect effect : _skillEffects){
            effect.execute(currentActive, monsters, trigger);
        }
    }

    public void addEffect(Effect effect){
        _skillEffects.add(effect);
    }

    public void removeEffect(Effect effect){
        _skillEffects.remove(effect);
    }

    public String getName(){
        return _name;
    }
    public String getDescription(){
        return _description;
    }
}
