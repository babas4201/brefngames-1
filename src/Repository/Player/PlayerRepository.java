package Repository.Player;

import Parameter.Factory.ColorFactory;
import Parameter.Factory.IconFactory;
import Player.*;
import Repository.AbstractDataRepository;
import Repository.ModifyFiles;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class PlayerRepository extends AbstractDataRepository {

    // Name of the node where there are all players
    private static final String DEFAULT_NODE = "players";
    // node
    private static final String NAME = "name";
    private static final String COLOR = "color";
    private static final String ICON = "icon";

    // Get all players in a list of local player
    public static ArrayList<LocalPlayer> getAll() {
        ArrayList<LocalPlayer> listPlayers = new ArrayList<LocalPlayer>();

        JSONArray statsJSONArray = (JSONArray) getDataFile().get(DEFAULT_NODE);
        Iterator<JSONObject> statsIterator = statsJSONArray.iterator();

        while (statsIterator.hasNext()) {
            JSONObject current = statsIterator.next();
            listPlayers.add(new LocalPlayer(
                                (String) current.get(NAME),
                                ColorFactory.getColor((String)current.get(COLOR)),
                                IconFactory.getIcon((String) current.get(ICON))));
        }

        return listPlayers;
    }

    // Get one local player with his name
    public static LocalPlayer getById(String name) {
        for (LocalPlayer p : getAll()) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Function to create player
     */
    public static void createPlayer(LocalPlayer p) {

        // Copy JSON file
        ModifyFiles.saveJSONFile(DATA_JSON_FILE);

        // Test if the player already exist
        if (getById(p.getName()) != null){
            ModifyFiles.removeCopyJSONFile(DATA_JSON_FILE);
        } else {
            JSONArray players = (JSONArray) getDataFile().get(DEFAULT_NODE);
            JSONObject newPlayer = new JSONObject();// new player
            newPlayer.put(NAME, p.getName());
            newPlayer.put(COLOR, ColorFactory.getStringColor(p.getColor()));
            newPlayer.put(ICON, IconFactory.getStringIcon(p.getIcon()));
            players.add(newPlayer);

            // Create a copy
            ModifyFiles.saveJSONFile(DATA_JSON_FILE);

            JSONObject dataJSON = getDataFile();
            dataJSON.put(DEFAULT_NODE, players);

            ModifyFiles.write(DATA_JSON_FILE, dataJSON);
        }
    }
}