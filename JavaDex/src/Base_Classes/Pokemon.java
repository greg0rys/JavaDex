package Base_Classes;


public class Pokemon
{
    private int id_num;
    private String name;
    private String pkmn_sprite;

    public Pokemon()
    {
        id_num = 0;
        name = pkmn_sprite = null;
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
}
