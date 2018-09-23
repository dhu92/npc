package monster.action.trigger;

import monster.Monster;
import monster.action.TargetType;

import java.util.ArrayList;
import java.util.List;

public abstract class Trigger {

    private TargetType _targetType;

    public Trigger(TargetType target){
        _targetType = target;
    }

    public boolean isTriggered(Monster currentActive, List<Monster> monsters, int cooldown) {
        boolean triggered = false;
        if(cooldown <= 0) {
            List<Monster> targets = filterTargets(currentActive, monsters);
            for (Monster m : targets) {
                if (matchesTriggerConditions(m)) {
                    triggered = true;
                }
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
            //for now, last one to match
            //TODO: change selection
            case SingleAlly:
//                Monster matchingMonster = new Monster();
//                for(Monster m : targets){
//                    if(m.getTeam() == currentActive.getTeam()){
//                        if(matchesTriggerConditions(m)){
//                            matchingMonster = m;
//                        }
//                    }
//                }
//                possibleTargets.add(matchingMonster);
//                break;
            case Team:
                possibleTargets.add(currentActive);
//                possibleTargets.addAll(filterTargetsByTeam(currentActive.getTeam(), targets));
//                break;
//                Fall through just for fun
            case AllAllied:
                for(Monster m : targets){
                    if(m.getTeam() == currentActive.getTeam()){
                        filtered.add(m);
                    }
                }
                possibleTargets.addAll(filtered);
                break;
            case SingleEnemy:
//                Monster monster = new Monster();
//                for(Monster m : targets){
//                    if(m.getTeam() == currentActive.getTeam()){
//                        if(matchesTriggerConditions(m)){
//                            monster = m;
//                        }
//                    }
//                }
//                possibleTargets.add(monster);
//                break;

            case EnemyTeam:
                for(Monster m : targets){
                    if(m.getTeam() != currentActive.getTeam()){
                        filtered.add(m);
                    }
                }
                possibleTargets.addAll(filtered);
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
