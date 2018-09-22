package monster.action.skill;

import monster.Monster;
import monster.action.skill.effect.Effect;

import java.util.ArrayList;
import java.util.List;

public class Skill {

    private String _name;
    private List<Effect> _skillEffects;

    public Skill(String name){
        _name = name;
        _skillEffects = new ArrayList<>();
    }

    public void execute(Monster currentActive, List<Monster> monsters){
        for(Effect effect : _skillEffects){
            //TODO: target selection
            effect.apply(currentActive, monsters);
        }
    }

    private void setName(String name){
        _name = name;
    }

    private void addEffect(Effect effect){
        _skillEffects.add(effect);
    }

    private void removeEffect(Effect effect){
        _skillEffects.remove(effect);
    }

    public String getName(){
        return _name;
    }
}
