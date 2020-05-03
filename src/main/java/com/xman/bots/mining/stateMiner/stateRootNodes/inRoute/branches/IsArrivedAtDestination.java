package com.xman.bots.mining.stateMiner.stateRootNodes.inRoute.branches;

import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import com.xman.bots.mining.stateMiner.stateRootNodes.inRoute.leaves.SetStateToArea;
import com.xman.bots.mining.stateMiner.universalLeafStates.Stop;

public class IsArrivedAtDestination extends BranchTask {

    private String area;
    private Area areaToGo;
    private Player player;

    public IsArrivedAtDestination(String area, Area areaToGo){
        this.area = area;
        this.areaToGo = areaToGo;
    }

    @Override
    public boolean validate() {
        Environment.getLogger().debug("Did Bot Arrive?");
        return  (player = Players.getLocal()) != null && areaToGo.contains(player);
    }

    @Override
    public TreeTask successTask() {
        return new SetStateToArea(area);
    }

    @Override
    public TreeTask failureTask() {
        // if it failed, STOP
        return new Stop("Not in Route, Not Moving ");
    }
}
