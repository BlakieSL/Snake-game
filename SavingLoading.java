package Helpers;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SavingLoading {
    public static void save(String name, int points){
        try(OutputStream os = new FileOutputStream("file4",true)){
            char [] letters = name.toCharArray();
            os.write(letters.length);
            int counter = 0;
            while(counter < letters.length){
                byte character = (byte) letters[counter++];
                os.write(character>>8);
                os.write(character);
            }
            for(int i = 3; i>=0;i--){
                os.write((points>>i*8));
            }

        }catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }
    }
    public static ArrayList<Player> load(){
        ArrayList<Player> players = new ArrayList<Player>();
        try(InputStream is = new FileInputStream("file4")){
            while(true) {
                int nameLength = is.read();
                if(nameLength == -1){
                    is.close();
                    return players;
                }
                String name = "";
                for (int i = 0; i < nameLength; i++) {
                    char first = (char) is.read();
                    char second = (char) is.read();
                    char letter = (char) ((first << 8) | second);
                    name += letter;
                }
                int points = 0;
                for(int i = 0; i < 4; i++){
                    int a = is.read();
                    points = (points<<8) | a;
                }

                Player player = new Player(name, points);
                players.add(player);
            }
        }catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }
        return players;
    }
    public static ArrayList<Player> getTopPlayers(){
        ArrayList<Player> players = load();
        Collections.sort(players);

        int min = Math.min(players.size(),10);
        List<Player> topPlayers =  players.subList(0,min);
        return new ArrayList<>(topPlayers);
    }

}
