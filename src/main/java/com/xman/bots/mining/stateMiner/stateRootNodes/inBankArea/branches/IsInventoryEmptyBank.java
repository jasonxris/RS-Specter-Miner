package com.xman.bots.mining.stateMiner.stateRootNodes.inBankArea.branches;

import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import com.xman.bots.mining.stateMiner.stateRootNodes.inBankArea.leaves.DepositUnwantedItems;

public class IsInventoryEmptyBank extends BranchTask {

    @Override
    public boolean validate() {
        return Inventory.getEmptySlots() >= 27;
    }

    @Override
    public TreeTask successTask() {
        return new IsPickAxeEquippedBank();
    }

    @Override
    public TreeTask failureTask() {
        return new DepositUnwantedItems();
    }
}
