package cpa.inventeur;

import java.util.List;

/**
 * @author Liu Jiaqi
 * @date 2018-4-02
 */
public class RobotSimple {
    private Table table;
    private String name;
    private PlayerConsole console;

    RobotSimple(String name, PlayerConsole console) {
        table = Table.getInstance();
        this.console = console;
        this.name = name;
    }

    void toPlay() {
        List<Inventor> libre;
        libre = console.getLibres();
        if (libre.isEmpty()) {
            console.setAllFree();
            System.out.println(this+" set All Free");
        }
        else {
            console.send(libre.get(0), table.getInventions().get(0));
            System.out.println(this + " send " + libre.get(0) + "-------->" + table.getInventions().get(0));
            if(table.getInventions().get(0).isFinished())
                console.addPoint();
        }
    }

    int getScore() {
        return console.getScore();
    }

    @Override
    public String toString() {
        return name;
    }
}
