package data.groups;

import data.single.Player;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The PlayerTree object contains the information for a whole group (or tree) of Players.
 */
public class PlayerTree implements Serializable {

    // * VARIABLES
    private ArrayList<Player> tree;

    // * CONSTRUCTORS
    public PlayerTree() {
        tree = new ArrayList<>();
    }

    public void add(Player player){

        // if the players PID is valid and the tree is populated
        if(player.pid > 0 && tree.size()>0){
            // sort the valid player into the list
            tree.add(player.pid,player);
        } else {
            // put the player at the end of the list
            tree.add(player);
        }

        tree.add(player);
    }

}
