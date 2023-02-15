package program.test;

import data.single.Player;

public class DataTest {

    public static void testPlayerDecode(){
        // create the string to be decoded
        String toDecode = "John≈100-200-3004≈Likes to take long walks on the beach";

        // construct the player with the simple save string
        Player decodedSimplePlayer = new Player(toDecode);

        // print out the (simple) results of the decoded player
        System.out.println("--- PLAYER DECODE ---");
        System.out.println("NAME: \t\t\t"+decodedSimplePlayer.name);
        System.out.println("PHONE NUMBER: \t"+decodedSimplePlayer.phoneNumber);
        System.out.println("BIO/NOTES: \t\t"+decodedSimplePlayer.bio);
        System.out.println("---------------------");
    }

    public static void main(String[] args) {
        testPlayerDecode();
    }

}
