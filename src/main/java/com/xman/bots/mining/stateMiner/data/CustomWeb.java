package com.xman.bots.mining.stateMiner.data;

import com.runemate.game.api.hybrid.location.navigation.web.SerializableWeb;
import com.runemate.game.api.hybrid.location.navigation.web.Web;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

import static com.runemate.game.api.hybrid.Environment.getLogger;

public class CustomWeb implements Serializable {

    private SerializableWeb serializableWeb;

    public CustomWeb(String pathToNavFile) {
        serializableWeb = new SerializableWeb();
        getLogger().debug("Initialized Serializable Web");
        File javaRepresentationOfFile = new File(pathToNavFile);
        loadWebFromNavFile(javaRepresentationOfFile);
    }

    public Web getWeb() {
        return serializableWeb;
    }

    public void loadWebFromNavFile(File pathToNavFile){
        getLogger().debug("Loading Graphs");
        SerializableWeb loadedWeb = new SerializableWeb();
        try {
            FileInputStream inputStream = new FileInputStream(pathToNavFile);
            ObjectInputStream ois = new ObjectInputStream(inputStream);
            loadedWeb.readExternal(ois);
        } catch (Exception e) {
            getLogger().debug("Error loading Web.nav file " + e.getMessage());
        }

        serializableWeb = loadedWeb;

        if(getWeb() != null) {
            getLogger().debug("Web, Size: " + getWeb().getVertices().size());
        }

    }

}
