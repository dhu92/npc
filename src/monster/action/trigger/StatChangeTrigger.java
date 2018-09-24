package monster.action.trigger;

import monster.Monster;
import monster.action.TargetType;
import monster.action.skill.effect.StatChange;

import java.util.List;

public class StatChangeTrigger extends Trigger {

    private StatChange _triggerStatChange;

    public StatChangeTrigger(TargetType target, StatChange triggerStatChange) {
        super(target);
        _triggerStatChange = triggerStatChange;
    }

    @Override
    public boolean matchesTriggerConditions(Monster monster) {
        List<StatChange> statChanges = monster.getStatChanges();
        if(statChanges.size() == 0){
            return true;
        }
        for(StatChange sc : statChanges){
            if(sc.equals(_triggerStatChange)){
                return true;
            }
        }
        return false;
    }
}
