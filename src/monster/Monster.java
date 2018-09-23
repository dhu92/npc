package monster;

import monster.action.Action;
import monster.action.skill.effect.StatChange;

import java.util.ArrayList;
import java.util.List;

public class Monster {

    private String _name;
    private int _team;
    private boolean _alive;
    private Stats _stats;
    private List<Action> _actions;
    private List<StatChange> _statChanges;
    private MonsterType _type;
    private int _experience;


    public Monster(){
       _actions = new ArrayList<>();
       _statChanges = new ArrayList<>();
       _alive = true;
    }

    public void addAction(Action action, int priority){
        _actions.add(priority, action);
    }

    public void swapActionPriority(int a, int b){
        Action tmpA = _actions.get(a);
        Action tmpB = _actions.get(b);
        _actions.remove(tmpA);
        _actions.remove(tmpB);
        _actions.add(a, tmpB);
        _actions.add(b, tmpA);
    }

    public void reduceStatChanges(){
        List<StatChange> remove = new ArrayList<>();
        for(StatChange statChange : _statChanges){
            statChange.raiseTurnCount();
            if(statChange.getTurnCount() >= statChange.getDuration()){
                remove.add(statChange);
            }
        }
        _statChanges.removeAll(remove);
    }

    public void gainExperience(int experience){
        int currentLevel = calculateMonsterLevel();
        _experience += experience;
        int newLevel = calculateMonsterLevel();
        int levelUps = newLevel - currentLevel;
        for(int i = 0; i < levelUps; i++){
            levelUp();
        }
    }

    private void levelUp(){
        _stats.setMaxHP( _stats.getMaxHP() * _type.getHpLevelGrowth());
        _stats.setAttack( _stats.getAttack() * _type.getAttackLevelGrowth());
        _stats.setDefense(_stats.getDefense() * _type.getDefenseLevelGrowth());
        _stats.setCritRate(_stats.getCritRate() * _type.getCritRateLevelGrowth());
        _stats.setCritDamage(_stats.getCritDamage() * _type.getCritDamageLevelGrowth());
        _stats.setSpeed(_stats.getSpeed() * _type.getSpeedLevelGrowth());
        _stats.setAccuracy(_stats.getAccuracy() * _type.getAccuracyLevelGrowth());
        _stats.setResistance(_stats.getResistance() * _type.getResistanceLevelGrowth());
    }

    public int getMonsterLevel(){
        return calculateMonsterLevel();
    }

    private int calculateMonsterLevel(){
        //TODO: experience need for each level
        int xp = _experience;
        int neededXP = 100;
        double growth = 1.2;
        int level = 1;
        while(xp - neededXP > 0){
            level ++;
            neededXP = (int)(neededXP * growth);
        }
        return level;
    }

    public void setExperience(int experience) {
        _experience = experience;
    }

    public int getExperience(){
        return _experience;
    }

    public void setMonsterType(MonsterType type){
        _type = type;
    }

    public MonsterType getMonsterType(){
        return _type;
    }

    public void setStats(Stats stats){
        _stats = stats;
    }

    public void setTeam(int team){
        _team = team;
    }

    public List<Action> getActions(){
        return _actions;
    }

    public boolean isAlive(){
        return _alive;
    }

    public void die(){
        _alive = false;
    }

    public void setAlive(boolean alive){
        _alive = alive;
    }

    public Action chooseAction(List<Monster> monsters) {
        for(int i = 0; i < _actions.size(); i++){
            if(_actions.get(i).isTriggered(this, monsters)){
                    return _actions.get(i);
            }
        }
        return _actions.get(_actions.size()-1);
    }

    public void reduceAllCooldowns(){
        for(Action action : _actions){
            action.reduceCooldown();
        }
    }

    public void setCurrentHp(double value){
        _stats.setCurrentHP(value);
    }

    public String getStatsAsString(){
        String skillList = "\n";
        for(Action a : _actions){
            skillList += "+" + a.getSkillName() +" " + a.getCurrentCooldown() + "/" + a.getCooldown() + "\n";
        }
        return "Name: " + _name + "\nLevel: " + calculateMonsterLevel() + "\nMonster Type: " + _type.getName() + "\nHP: " + _stats.getCurrentHP() + "/" + _stats.getMaxHP() + "\nAttack: " + _stats.getAttack() + "\nCritical Rate: " + _stats.getCritRate() + "\nCritical Damage: " + _stats.getCritDamage()
                + "\nDefense: " + _stats.getDefense() + "\nSpeed: " + _stats.getSpeed() + "\nAccuracy: " + _stats.getAccuracy() + "\nResistance: " + _stats.getResistance() + "\nSkills: " + skillList;
    }

    public String getName(){return _name;}

    public void setName(String name){_name = name; }

    public int getTeam() {
        return _team;
    }

    public double getAttack() {
        return _stats.getAttack();
    }

    public double getCurrentHp() {
        return _stats.getCurrentHP();
    }

    public double getMaxHp() {
        return _stats.getMaxHP();
    }

    public double getDefense() {
        return _stats.getDefense();
    }

    public double getSpeed() {
        return _stats.getSpeed();
    }

    public double getAccuracy(){
        return _stats.getAccuracy();
    }

    public double getResistance(){
        return _stats.getResistance();
    }

    public double getCritRate(){
        return _stats.getCritRate();
    }

    public double getCritDamage(){
        return _stats.getCritDamage();
    }

    public List<StatChange> getStatChanges(){
        return _statChanges;
    }

    public Stats getStats(){
        return _stats;
    }

    public void addStatChange(StatChange change){
        _statChanges.add(change);
    }

    public void removeAllStatChanges(){
        _statChanges = new ArrayList<>();
    }

    public Stats getChangedStats() {
        Stats changedStats = _stats.copy();
        for(StatChange change : _statChanges){
            change.applyChange(changedStats);
        }
        return changedStats;
    }
}
