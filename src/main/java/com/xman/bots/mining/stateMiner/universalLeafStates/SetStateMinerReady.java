package com.xman.bots.mining.stateMiner.universalLeafStates;

import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.script.framework.tree.LeafTask;
import com.xman.bots.mining.stateMiner.RootNodeWrapper;
import com.xman.bots.mining.stateMiner.stateRootNodes.isMinerReady.branches.IsMinerReady;

public class SetStateMinerReady extends LeafTask {

    @Override
    public void execute() {
        Environment.getLogger().debug("Setting state to ready");
        RootNodeWrapper.getInstance().setCurrentState(new IsMinerReady());
    }
}
