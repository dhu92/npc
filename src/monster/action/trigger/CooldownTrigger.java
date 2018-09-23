package monster.action.trigger;

import monster.Monster;
import monster.action.TargetType;

import java.util.List;

public class CooldownTrigger extends Trigger {

    public CooldownTrigger(TargetType target) {
        super(target);
    }

    @Override
    public boolean isTriggered(Monster currentActive, List<Monster> monsters, int cooldown) {
        if(cooldown <= 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean matchesTriggerConditions(Monster monster) {
        return true;
    }
}
