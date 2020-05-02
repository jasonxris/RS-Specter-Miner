package com.xman.bots.mining.stateMiner.stateRootNodes.isMinerReady.branches;

import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.hybrid.local.hud.interfaces.Equipment;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import com.xman.bots.mining.stateMiner.data.DataCache;
import com.xman.bots.mining.stateMiner.universalLeafStates.SetRoute;

public class  IsMinerReady extends BranchTask {

    @Override
    public boolean validate() {
        Environment.getLogger().debug("Is Miner Ready?");
        String[] PICKAXES = DataCache.getCache().getPICKAXES();
        boolean isPickAxeGood = (Equipment.containsAnyOf(PICKAXES) || Inventory.containsAnyOf(PICKAXES));
        boolean isInventoryReady = !Inventory.isFull();
        return isInventoryReady && isPickAxeGood;
    }

    @Override
    public TreeTask successTask() {
        Environment.getLogger().debug("Miner is Ready");
        return new SetRoute("mine");
    }

    @Override
    public TreeTask failureTask() {
        Environment.getLogger().debug("Miner is not ready");
        return new SetRoute("bank");
    }
}
