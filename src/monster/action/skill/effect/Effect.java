package monster.action.skill.effect;

import monster.Monster;
import monster.action.TargetType;
import monster.action.trigger.Trigger;

import java.util.ArrayList;
import java.util.List;

public abstract class Effect {

    private EffectType _type;

    public Effect(){}
    public Effect(EffectType type){
        _type = type;
    }

    //Just testing
    public static Effect createEffect(){
//        return new monster.action.skill.effect.Effect();
        return null;
    }

    //TODO: implement target selection
    public abstract void apply(Monster activeMonster, Monster target);

    public void execute(Monster activeMonster, List<Monster> possibleTargets, Trigger trigger){
        List<Monster> targets = trigger.filterTargets(activeMonster, possibleTargets);
        if(trigger.getTargetType() == TargetType.SingleEnemy || trigger.getTargetType() == TargetType.SingleAlly && targets.size() > 1){
                Monster m = findBestMatch(activeMonster, targets);
                apply(activeMonster, m);
        } else {
            for (Monster target : targets) {
                apply(activeMonster, target);
            }
        }
    }

    public abstract Monster findBestMatch(Monster activeMonster, List<Monster> monsters);
    public EffectType getType(){
        return _type;
    }


}
