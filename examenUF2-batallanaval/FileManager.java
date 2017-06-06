import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import static java.lang.Math.toIntExact;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Created by the Focking Jendoliver on 06/06/2017
 * GitHub: github.com/Jendoliver
 */
public class FileManager
{
    public static void save(BNGame game) throws IOException
    {
        // We extract the data from the game
        int width = Board.getWidth(); int height = Board.getHeight();
        int maxtries = game.getMaxTries();
        ArrayList<Boat> boats = Board.getBoats();
        ArrayList<int[]> shots = game.getShots();

        // General game data
        JSONObject data = new JSONObject();
        data.put("width", width);
        data.put("height", height);
        data.put("maxtries", maxtries);

        // Boats data
        JSONArray boatsJSON = new JSONArray();
        for(Boat boat : boats)
        {
            JSONObject boatJSON = new JSONObject();
            boatJSON.put("row", boat.getRow());
            boatJSON.put("col", boat.getCol());
            boatJSON.put("boatsize", boat.getBoatsize());
            boatJSON.put("orientation", boat.getOrientation());
            boatsJSON.add("boat: "+boatJSON);
        }
        data.put("boats", boatsJSON);

        // Shots data
        JSONArray shotsJSON = new JSONArray();
        if( ! shots.isEmpty()) {
            for (int[] shot : shots) {
                JSONObject shotJSON = new JSONObject();
                shotJSON.put("x", shot[0]);
                shotJSON.put("y", shot[1]);
                shotsJSON.add("shot: " + shotJSON);
            }
            data.put("shots", shotsJSON);
        }

        FileWriter file = new FileWriter("bngame.txt");
        try {
            file.write(data.toJSONString());
            System.out.println("Game successfully saved!");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("ERROR WHILE SAVING GAME");
        } finally {
            file.flush();
            file.close();
        }
    }

    public static BNGame load() throws IOException
    {
        BNGame game = null;
        JSONParser parser = new JSONParser();
        try
        {
            JSONObject data = (JSONObject) parser.parse(new FileReader("bngame.txt"));

            // General game data
            int maxtries = toIntExact((long)data.get("maxtries"));
            int width = toIntExact((long)data.get("width"));
            int height = toIntExact((long)data.get("height"));
            game = new BNGame(maxtries, width, height);

            // Boats data
            JSONArray boatsJSON = (JSONArray) data.get("boats");
            Iterator<JSONObject> it = boatsJSON.iterator();
            while (it.hasNext())
            {
                JSONObject boatJSON = it.next();
                int boatsize = (int)boatJSON.get("boatsize");
                int row = (int)boatJSON.get("row");
                int col = (int)boatJSON.get("col");
                Orientations orientation = (Orientations)boatJSON.get("orientation");
                Boat boat = new Boat(boatsize, orientation, row, col);
                Board.addBoat(boat);
            }

            // Shots data
            JSONArray shotsJSON = (JSONArray) data.get("shots");
            it = shotsJSON.iterator();
            while (it.hasNext())
            {
                JSONObject shotJSON = it.next();
                int x = (int)shotJSON.get("x");
                int y = (int)shotJSON.get("y");
                InputChecks check = game.checkPosition(x, y);
                game.processPosition(check, x, y);
            }

        } catch (ParseException e) {
            System.err.println("ERROR ON FILE PARSING");
            e.printStackTrace();
        }
        return game;
    }
}
