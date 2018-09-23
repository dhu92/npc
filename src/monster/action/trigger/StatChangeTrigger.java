package monster.action.trigger;

import monster.Monster;
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
//        return !statChanges.contains(_triggerStatChange);
        for(StatChange sc : statChanges){
            if(sc.equals(_triggerStatChange)){
                return true;
            }
        }
        return false;
    }
}
