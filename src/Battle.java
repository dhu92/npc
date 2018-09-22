import monster.action.Action;
import monster.Monster;

import java.util.ArrayList;
import java.util.List;

public class Battle {

    private List<Monster> _monsters;
    private int _maxTurns = 100;

    /*
    * Just testing
    */
    public Battle(Monster monsterOne, Monster monsterTwo){
        _monsters = new ArrayList<>();
        _monsters.add(monsterOne);
        _monsters.add(monsterTwo);
    }

    public void fight(){
        int turn = 0;
        boolean winner = false;
        Action action;
        while(!winner && turn < _maxTurns){
            action = _monsters.get(turn%2).chooseAction(_monsters);
            action.execute(_monsters.get(turn%2), _monsters);
            System.out.print("monster.Monster " + ((turn%2)+1) + " used ");
            action.printAction();
            for(Monster monster : _monsters){
                if(!monster.isAlive()){
                    winner = true;
                }
            }
            _monsters.get(turn%2).reduceStatChanges();
            turn++;
            for(Monster monster : _monsters){
                System.out.println(monster.getStatsAsString());
            }
        }
        if(turn < _maxTurns) {
            System.out.println("monster.Monster " + ((turn % 2) + 1) + " won the battle!");
        } else {
            System.out.println("Draw!");
        }
    }

    /*
      Just testing
     */
    public static void main(String[] args){
        //too many changes, tests not working atm
//        List<Action> m1Actions = new LinkedList<>();
//        m1Actions.add(0, new Action(new Attack()));
//        m1Actions.add(1, new Action(new Heal()));
//        Monster m1 = new Monster(1, 100, 100, m1Actions);
//
//        List<Action> m2Actions = new LinkedList<>();
//        m2Actions.add(0, new Action(new Heal()));
//        m2Actions.add(1, new Action(new Attack()));
//        Monster m2 = new Monster(2, 150, 50, m2Actions);
//
//        Battle battle = new Battle(m1, m2);
//        battle.fight();
    }

}
