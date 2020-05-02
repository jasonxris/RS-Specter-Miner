package com.xman.bots.mining.stateMiner.stateRootNodes.inRoute.leaves;

import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.navigation.web.Web;
import com.runemate.game.api.hybrid.location.navigation.web.WebPath;
import com.runemate.game.api.script.framework.tree.LeafTask;
import com.xman.bots.mining.stateMiner.data.DataCache;

public class WalkToLocation extends LeafTask {

    private Area locationToWalkTo;
    public WalkToLocation(Area locationToWalkTo){
        this.locationToWalkTo = locationToWalkTo;
    }

    @Override
    public void execute() {
        // find location
        // initiate walking to it
        Web webPath = DataCache.getCache().getBotWeb();
        WebPath pathToBank = webPath.getPathBuilder().buildTo(locationToWalkTo.getRandomCoordinate());

        if(pathToBank != null){
            pathToBank.step();
        }else {
            Environment.getBot().getLogger().info("Path to area was null");
        }

    }
}
