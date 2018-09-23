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

//    private int _maxHp;
//    private int _attack;
//    private int _currentHp;

//    public Monster(int team, int hp, int attack, int defense, List<Action> actions){
//        _actions = actions;
//        _alive = true;
//        _team = team;
//        _stats = new Stats(hp, attack, defense);
//        _statChanges = new ArrayList<>();
//        _maxHp = hp;
//        _attack = attack;
//        _currentHp = _maxHp;
//    }

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
        _stats.setMaxHP((int) (_stats.getMaxHP() * _type.getHpLevelGrowth()));
        _stats.setAttack((int) (_stats.getAttack() * _type.getAttackLevelGrowth()));
        _stats.setDefense((int) (_stats.getDefense() * _type.getDefenseLevelGrowth()));
        _stats.setCritRate((int) (_stats.getCritRate() * _type.getCritRateLevelGrowth()));
        _stats.setCritDamage((int) (_stats.getCritDamage() * _type.getCritDamageLevelGrowth()));
        _stats.setSpeed((int) (_stats.getSpeed() * _type.getSpeedLevelGrowth()));
        _stats.setAccuracy((int) (_stats.getAccuracy() * _type.getAccuracyLevelGrowth()));
        _stats.setResistance((int) (_stats.getResistance() * _type.getResistanceLevelGrowth()));
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
//    public void getHit(int dmg){
//        _stats.setCurrentHP(_stats.getCurrentHP() - dmg);
//        if(_stats.getCurrentHP() <= 0){
//            _alive = false;
//        }
//    }
//
//
//    public void heal(int heal){
//        if(_currentHp + heal > _maxHp){
//            _currentHp = _maxHp;
//        } else {
//            _currentHp += heal;
//        }
//    }

    public List<Action> getActions(){
        return _actions;
    }

    public boolean isAlive(){
        return _alive;
    }

    public void die(){
        _alive = false;
    }


    public Action chooseAction(List monsters) {
        for(int i = 0; i < _actions.size(); i++){
            if(_actions.get(i).isTriggered(this, monsters)){
                return _actions.get(i);
            }
        }
        return _actions.get(_actions.size()-1);
    }

    public void setCurrentHp(int value){
        _stats.setCurrentHP(value);
    }

    public String getStatsAsString(){
        return "HP: " + _stats.getCurrentHP() + "/" + _stats.getMaxHP() + " | Attack: " + _stats.getAttack() + " | Defense: " + _stats.getDefense();
    }

    public String getName(){return _name;}

    public void setName(String name){_name = name; }

    public int getTeam() {
        return _team;
    }

    public int getAttack() {
        return _stats.getAttack();
    }

    public int getCurrentHp() {
        return _stats.getCurrentHP();
    }

    public int getMaxHp() {
        return _stats.getCurrentHP();
    }

    public int getDefense() {
        return _stats.getDefense();
    }

    public int getSpeed() {
        return _stats.getSpeed();
    }

    public int getAccuracy(){
        return _stats.getAccuracy();
    }

    public int getResistance(){
        return _stats.getResistance();
    }

    public int getCritRate(){
        return _stats.getCritRate();
    }

    public int getCritDamage(){
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

    public Stats getChangedStats() {
        Stats changedStats = _stats.copy();
        for(StatChange change : _statChanges){
            change.applyChange(changedStats);
        }
        return changedStats;
    }
}
