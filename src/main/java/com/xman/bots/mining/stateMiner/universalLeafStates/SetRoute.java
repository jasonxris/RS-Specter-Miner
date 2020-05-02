package com.xman.bots.mining.stateMiner.universalLeafStates;

import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.script.framework.tree.LeafTask;
import com.xman.bots.mining.stateMiner.RootNodeWrapper;
import com.xman.bots.mining.stateMiner.stateRootNodes.inRoute.branches.InRoute;

public class SetRoute extends LeafTask {

    private String locationToWalkTo;

    public SetRoute(String locationToWalkTo){
        this.locationToWalkTo = locationToWalkTo;
    }

    @Override
    public void execute() {
        Environment.getLogger().debug("Setting state to InRoute");
        RootNodeWrapper.getInstance().setCurrentState(new InRoute(locationToWalkTo));
    }
}
