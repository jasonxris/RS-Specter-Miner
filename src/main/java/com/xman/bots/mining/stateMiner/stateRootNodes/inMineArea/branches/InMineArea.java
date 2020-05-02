package com.xman.bots.mining.stateMiner.stateRootNodes.inMineArea.branches;

import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import com.xman.bots.mining.stateMiner.data.DataCache;
import com.xman.bots.mining.stateMiner.universalLeafStates.SetStateMinerReady;

public class InMineArea extends BranchTask {

    private Player player;

    @Override
    public boolean validate() {
        return (player = Players.getLocal()) != null && DataCache.getCache().getMineRegion().contains(player);
    }

    @Override
    public TreeTask successTask() {

        return new IsInventoryFull();
    }

    @Override
    public TreeTask failureTask() {
        return new SetStateMinerReady();
    }
}
