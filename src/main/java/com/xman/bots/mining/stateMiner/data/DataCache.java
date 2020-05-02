package com.xman.bots.mining.stateMiner.data;

import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.location.navigation.web.Web;
import com.xman.bots.mining.stateMiner.data.model.Tin;

import java.util.ArrayList;
import java.util.Random;

public class DataCache {
    //Resources to create
    private static DataCache cache;

    private DataCache(){
        bankBooths.add(new Coordinate(3186,3440,0));
        bankBooths.add(new Coordinate(3186,3438,0));
        bankBooths.add(new Coordinate(3186,3436,0));
        bankBooths.add(new Coordinate(3186,3442,0));

        if(pathToWebNavFile != null){
            CustomWeb web = new CustomWeb(pathToWebNavFile);
            botWeb = web.getWeb();
        }
    }

    public static DataCache getCache(){
        if(cache == null) {
            cache = new DataCache();
        }
        return cache;
    }

    private Web botWeb;
    private String[] PICKAXES = {"Bronze pickaxe","Iron pickaxe","Steel pickaxe","Black pickaxe","Mithril pickaxe","Adamant pickaxe","Rune pickaxe","Dragon pickaxe","Infernal pickaxe"};
    private String[] ORETOMINE = {"Bronze","Tin"};
    private String[] WANTED_ITEMS = PICKAXES;
    private String pathToWebNavFile = "src\\main\\resources\\web.nav";
    private Tin oreToMine = new Tin();
    private String selectedPickaxe = "Mithril pickaxe";
    private Coordinate mineCoordinate = new Coordinate(3179,3368,0);
    private Coordinate bankCoordinate = new Coordinate(3183,3439,0);
    private Area bankLocation = new Area.Rectangular(new Coordinate(3181,3437,0),new Coordinate(3185,3446,0));
    private Area mineRegion = new Area.Rectangular(new Coordinate(3181,3372,0),new Coordinate(3184,3378,0));

    private ArrayList<Coordinate> bankBooths = new ArrayList<>();


    public String[] getPICKAXES() {
        return PICKAXES;
    }

    public Area getBankRegion() {
        return bankLocation;
    }

    public Area getMineRegion() {
        return mineRegion;
    }

    public String[] getWANTED_ITEMS() {
        return WANTED_ITEMS;
    }

    public Tin getOreToMine() {
        return oreToMine;
    }
    public Coordinate getBankBoothCoord(){
        Random random = new Random();
        int randomInteger = random.nextInt(3);
        return bankBooths.get(randomInteger);
    }

    public Web getBotWeb() {
        return botWeb;
    }

    public String getSelectedPickaxe() {
        return selectedPickaxe;
    }
}
