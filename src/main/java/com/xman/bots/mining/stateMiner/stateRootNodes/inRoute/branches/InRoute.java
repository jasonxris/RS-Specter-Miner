package com.xman.bots.mining.stateMiner.stateRootNodes.inRoute.branches;

import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import com.xman.bots.mining.stateMiner.data.DataCache;
import com.xman.bots.mining.stateMiner.stateRootNodes.inRoute.leaves.WalkToLocation;

public class InRoute extends BranchTask {


    private String locationToWalkTo;
    private Player player;
    private Area areaToWalkTo;

    public InRoute(String locationToWalkTo){
        this.locationToWalkTo = locationToWalkTo;
    }

    @Override
    public boolean validate() {
        Environment.getLogger().debug("Is PLayer in Route to " + locationToWalkTo);
        boolean playerIsInArea;

        if(locationToWalkTo.equals("bank")){
            areaToWalkTo = DataCache.getCache().getBankRegion();
        }
        else{
            areaToWalkTo = DataCache.getCache().getMineRegion();
        }


        playerIsInArea = (player = Players.getLocal()) != null && areaToWalkTo.contains(player);
        if(playerIsInArea){
            Environment.getLogger().debug("playerISInArea is true");
        }
        playerIsInArea = !playerIsInArea;

        // Validate that the bot is not stuck
//        boolean isBotStuck = false;

        return playerIsInArea;

    }

    @Override
    public TreeTask successTask() {
        Environment.getLogger().debug("Player is still in route");
        // Keep walking to the location, still in route
        return new WalkToLocation(areaToWalkTo);
    }

    @Override
    public TreeTask failureTask() {
        Environment.getLogger().debug("Player is not in route");
        // Not in Route for some reason
        return new IsArrivedAtDestination(locationToWalkTo, areaToWalkTo);
    }
}
