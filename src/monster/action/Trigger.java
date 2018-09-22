package monster.action;

import monster.Monster;

import java.util.ArrayList;
import java.util.List;

public abstract class Trigger {

    private TargetType _targetType;

    public Trigger(TargetType target){
        _targetType = target;
    }

    public boolean isTriggered(Monster currentActive, List<Monster> monsters) {
        List<Monster> targets = filterTargets(currentActive, monsters);
        boolean triggered = false;
        for(Monster m : targets){
            if(matchesTriggerConditions(m)){
                triggered = true;
            }
        }
        return triggered;
    }

    public abstract boolean matchesTriggerConditions(Monster monster);

    public List<Monster> filterTargets(Monster currentActive, List<Monster> targets){
        List<Monster> possibleTargets = new ArrayList<>();
        List<Monster> filtered = new ArrayList<>();
        switch(_targetType){
            case Self:
                possibleTargets.add(currentActive);
                break;
            case All:
                possibleTargets.add(currentActive);
                possibleTargets.addAll(targets);
                break;
            case Team:
                possibleTargets.add(currentActive);
//                possibleTargets.addAll(filterTargetsByTeam(currentActive.getTeam(), targets));
//                break;
//                Fall through just for fun
            case SingleAlly:
            case AllAllied:
                filtered = new ArrayList<>();
                for(Monster m : targets){
                    if(m.getTeam() == currentActive.getTeam()){
                        filtered.add(m);
                    }
                }
                possibleTargets.addAll(filtered);
                break;
            case SingleEnemy:
            case EnemyTeam:
                filtered = new ArrayList<>();
                for(Monster m : targets){
                    if(m.getTeam() != currentActive.getTeam()){
                        filtered.add(m);
                    }
                }
                break;

        }
        return possibleTargets;
    }

    public TargetType getTargetType(){
        return _targetType;
    }

    public void setTriggerTarget(TargetType targetType){
        _targetType = targetType;
    }

    public List<Monster> filterTargetsByTeam(int team, List<Monster> monsters){
        List<Monster> filtered = new ArrayList<>();
        for(Monster m : monsters){
            if(m.getTeam() == team){
                filtered.add(m);
            }
        }
        return filtered;
    }
}
