import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import org.json.JSONTokener;

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
            boatsJSON.put(boatJSON);
        }
        data.put("boats", boatsJSON);

        // Shots data
        JSONArray shotsJSON = new JSONArray();
        if( ! shots.isEmpty()) {
            for (int[] shot : shots) {
                JSONObject shotJSON = new JSONObject();
                shotJSON.put("x", shot[0]);
                shotJSON.put("y", shot[1]);
                shotsJSON.put(shotJSON);
            }
            data.put("shots", shotsJSON);
        }

        FileWriter file = new FileWriter("bngame.txt");
        try {
            file.write(data.toString());
            System.out.println("Game successfully saved!");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("ERROR WHILE SAVING GAME");
        } finally {
            file.flush();
            file.close();
            System.exit(0);
        }
    }

    public static BNGame load() throws IOException
    {
        BNGame game;
        JSONObject data = (JSONObject) new JSONTokener(new FileReader("bngame.txt")).nextValue();

        // General game data
        int maxtries = data.getInt("maxtries");
        int width = data.getInt("width");
        int height = data.getInt("height");
        game = new BNGame(maxtries, width, height);

        // Boats data
        JSONArray boatsJSON = data.getJSONArray("boats");
        for(int i=0; i < boatsJSON.length(); i++)
        {
            JSONObject boatJSON = boatsJSON.getJSONObject(i);
            int boatsize = boatJSON.getInt("boatsize");
            int row = boatJSON.getInt("row");
            int col = boatJSON.getInt("col");
            String orientationStr = boatJSON.getString("orientation");
            Orientations orientation = Orientations.H;
            switch(orientationStr)
            {
                case "V": orientation = Orientations.V; break;
                case "H": orientation = Orientations.H; break;
            }
            Boat boat = new Boat(boatsize, orientation, row, col);
            Board.addBoat(boat);
        }

        // Shots data
        JSONArray shotsJSON = data.getJSONArray("shots");
        for (int i=0; i < shotsJSON.length(); i++)
        {
            JSONObject shotJSON = shotsJSON.getJSONObject(i);
            int x = shotJSON.getInt("x");
            int y = shotJSON.getInt("y");
            InputChecks check = game.checkPosition(x, y);
            game.processPosition(check, x, y);
        }
        return game;
    }
}
