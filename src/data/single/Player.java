package data.single;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The Player class represents a singular player to be placed inside a PlayerTree. Each player has variables for
 * basic information, such as name, phone number, and notes/bio. Each player also has a group of targets stored as
 * Integers in an ArrayList. The PlayerTree is responsible for the lookup of other Players outside this object.
 */
public class Player implements Serializable, Comparable {

    // * CONSTANTS
    /**
     * The default amount of starting lives for each player.
     * Upon instantiation, players will be assigned this value
     * of lives if not otherwise specified in the constructor.
     */
    public final static int STARTING_LIVES = 3;
    /**
     * The default starting score for each player upon instantiation. If a player is constructed without
     * a score parameter, then the player's starting score will be set to this value.
     */
    public final static int STARTING_SCORE = 0;

    // * PLAYER INFORMATION
    // basic info
    public String name;
    public String phoneNumber;
    public String bio;

    // game info
    public int score = STARTING_SCORE;
    public int lives = STARTING_LIVES;
    public int pid = -1;

    // player links
    /**
     * An ArrayList of Integers that point to the player ids of each target. For example, if
     * a target of a player is: John Cutler with a player id of 5, then the target list would contain his
     * player id– 5. The PlayerTree object can look up the player at the index that is provided.
     */
    public ArrayList<Integer> targets;

    /**
     * An ArrayList of Integers that point to the player ids of the player's assassins. For example, if
     * John Cutler (with a player id of 5) is targeting this player, then the assassin list would contain his
     * player id– 5. The PlayerTree object can look up the player at the index that is provided.
     */
    public ArrayList<Integer> assassins;

    //* CONSTRUCTORS

    /**
     * Constructs a player using three known values. All other data is assigned null.
     * @param name The name of the player
     * @param phoneNumber The phone number of the player
     * @param bio The notes/bio of the player
     */
    public Player(String name, String phoneNumber, String bio){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.bio = bio;

        targets = null;
        assassins = null;
    }

    /**
     * Constructs a player from a simple save. A simple save includes data that was created on player load,
     * but does not include detailed game data. A simple save String is formatted like the following:
     * [ Name ≈ PhoneNumber ≈ bio ] Upon using this constructor, other values inside game data will be set to null.
     * @param simpleSave
     */
    public Player(String simpleSave){
        String[] info = simpleSave.split("≈");

        // if the length of the split data is 3, then it's valid.
        if(info.length>=3) {
            this.name = info[0];
            this.phoneNumber = info[1];
            this.bio = info[2];

            targets = null;
            assassins = null;
        } else {
            // throw error
            System.out.println("\t! REGEX SPLIT RESULTED IN [" + info.length + "] SLOTS; EXPECTED 3.");
            throw new Error("REGEX SPLIT RESULTED IN [" + info.length + "] SLOTS; EXPECTED 3.");
        }
    }

    /**
     * Compares this Player object to another Player object based on the player ids.
     * @param o the object to be compared.
     * @return 0 if equal; -1 if this object's
     * pid is less than the one being compared to; 1 if
     * this object's pid is greater than the one being compared to; -2 if the object had an error comparing
     */
    @Override
    public int compareTo(Object o) {

        Player tmp = (Player) o;

        if(tmp.pid == this.pid){
            return 0;
        }

        if(tmp.pid > this.pid){
            // this pid is less than the object
            return -1;
        }

        if(tmp.pid < this.pid){
            // this pid is more than the object
            return 1;
        }

        return -2;
    }
}
