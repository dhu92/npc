package monster.action.skill.effect;

import monster.Monster;

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
    public abstract void apply(Monster activeMonster, List<Monster> possibleTargets);

    public EffectType getType(){
        return _type;
    }


}
