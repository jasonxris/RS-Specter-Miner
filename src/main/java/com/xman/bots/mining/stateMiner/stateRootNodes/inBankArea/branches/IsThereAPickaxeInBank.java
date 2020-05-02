package com.xman.bots.mining.stateMiner.stateRootNodes.inBankArea.branches;

import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import com.xman.bots.mining.stateMiner.data.DataCache;
import com.xman.bots.mining.stateMiner.stateRootNodes.inBankArea.leaves.EquipPickaxe;
import com.xman.bots.mining.stateMiner.universalLeafStates.Stop;

public class IsThereAPickaxeInBank extends BranchTask {

    private String selectedPickaze = DataCache.getCache().getSelectedPickaxe();

    @Override
    public boolean validate() {

        return Bank.contains(selectedPickaze);
    }

    @Override
    public TreeTask successTask() {
        return new EquipPickaxe();
    }

    @Override
    public TreeTask failureTask() {
        return new Stop("No Pickaxe is in bank");
    }
}
