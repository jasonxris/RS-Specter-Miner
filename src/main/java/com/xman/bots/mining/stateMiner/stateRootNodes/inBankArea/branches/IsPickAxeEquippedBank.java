package com.xman.bots.mining.stateMiner.stateRootNodes.inBankArea.branches;

import com.runemate.game.api.hybrid.local.hud.interfaces.Equipment;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import com.xman.bots.mining.stateMiner.data.DataCache;
import com.xman.bots.mining.stateMiner.stateRootNodes.inBankArea.leaves.CloseBank;

public class IsPickAxeEquippedBank extends BranchTask {

    String[] PICKAXES = DataCache.getCache().getPICKAXES();
    @Override
    public boolean validate() {
        return Equipment.containsAnyOf(PICKAXES) || Inventory.containsAnyOf(PICKAXES);
    }

    @Override
    public TreeTask successTask() {
        return new CloseBank();
    }

    @Override
    public TreeTask failureTask() {
        return new IsThereAPickaxeInBank();
    }
}
