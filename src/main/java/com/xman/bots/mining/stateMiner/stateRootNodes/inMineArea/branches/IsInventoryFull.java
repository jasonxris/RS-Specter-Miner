package com.xman.bots.mining.stateMiner.stateRootNodes.inMineArea.branches;

import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import com.xman.bots.mining.stateMiner.stateRootNodes.inMineArea.leaves.MineRock;
import com.xman.bots.mining.stateMiner.universalLeafStates.SetRoute;

public class IsInventoryFull extends BranchTask {


    @Override
    public boolean validate() {
        return Inventory.isFull();
    }

    @Override
    public TreeTask successTask() {
        Environment.getBot().getLogger().info("Inventory is full go to bank");

        return new SetRoute("bank");
    }

    @Override
    public TreeTask failureTask() {
        Environment.getBot().getLogger().info("Inventory is not full, keep mining");

        return new MineRock();
    }
}
