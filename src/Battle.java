import monster.MonsterFactory;
import monster.action.Action;
import monster.Monster;

import java.util.ArrayList;
import java.util.List;

public class Battle {

    private List<Monster> _monsters;
    private int _maxTurns = 10;

    /*
    * Just testing
    */
    public Battle(Monster monsterOne, Monster monsterTwo){
        _monsters = new ArrayList<>();
        _monsters.add(monsterOne);
        monsterOne.setTeam(1);
        _monsters.add(monsterTwo);
        monsterTwo.setTeam(2);
    }

    public void fight(){
        int turn = 0;
        boolean winner = false;
        Action action;
        System.out.println("======================FIGHT START======================");
        for(Monster m : _monsters){
            System.out.println(m.getStatsAsString());
        }
        Monster activeMonster = _monsters.get(turn%2);
        while(!winner && turn < _maxTurns){
            activeMonster = _monsters.get(turn%2);
            action = activeMonster.chooseAction(_monsters);
            action.execute(activeMonster, _monsters);
            System.out.print(activeMonster.getName() + " used ");
            action.printAction();
            for(Monster monster : _monsters){
                if(!monster.isAlive()){
                    winner = true;
                }
            }
            activeMonster.reduceStatChanges();
            activeMonster.reduceAllCooldowns();
            turn++;
            for(Monster monster : _monsters){
                System.out.println(monster.getStatsAsString());
            }
        }
        if(turn < _maxTurns) {
            System.out.println(activeMonster.getName() + " won the battle!");
        } else {
            System.out.println("Draw!");
        }
    }

    /*
      Just testing
     */
    public static void main(String[] args){
        //Test with default
        MonsterFactory factory = new MonsterFactory();
        List<Monster> allTypes = factory.createTestMonster();

        //Test 1:
        resetMonster(allTypes);
        Battle attackervssupport = new Battle(allTypes.get(0), allTypes.get(1));
        attackervssupport.fight();

        //Test2
        resetMonster(allTypes);
        Battle attackervstank = new Battle(allTypes.get(0), allTypes.get(2));
        attackervstank.fight();

        //Test3
        resetMonster(allTypes);
        Battle supportvstank = new Battle(allTypes.get(1), allTypes.get(2));
        supportvstank.fight();

    }

    public static void resetMonster(List<Monster> monsters){
        for(Monster m : monsters){
            m.setAlive(true);
            m.setCurrentHp(m.getMaxHp());
        }
    }

}
