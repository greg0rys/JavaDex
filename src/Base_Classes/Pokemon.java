package Base_Classes;


import java.util.ArrayList;

public class Pokemon
{
    private int id_num;
    private String name;
    private String pkmn_sprite;
    private String pkmn_type;
    private ArrayList<String> type_advantage;
    private ArrayList<String> type_disadvantage;
    private boolean has_evolution;


    public Pokemon()
    {
        id_num = 0;
        name = pkmn_sprite = pkmn_type = null;
        has_evolution = false;

        type_advantage = type_disadvantage = new ArrayList<>();
    }

    public String get_name() {return name;}

    public String get_sprite() {return pkmn_sprite;}

    public int getId_num() {return id_num;}

    /**
     * TODO all setter methods require input validation if the user will supply it.
     */
    public void set_id(int id) { id_num = id;}
    public void set_name(String new_name) {name = new_name;}
    public void set_sprite(String sprite) {pkmn_sprite = sprite;}

    public void fill_advantages()
    {
        if(type_advantage == null)
            type_advantage = new ArrayList<>();
        // DB.get_advantages(pkmn_type); use a sqlite db to list the
    }
}
