package com.xman.bots.mining.stateMiner.stateRootNodes.inBankArea.leaves;

import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.script.framework.tree.LeafTask;
import com.xman.bots.mining.stateMiner.data.DataCache;

public class DepositUnwantedItems extends LeafTask {

    @Override
    public void execute() {
        Bank.depositAllExcept(DataCache.getCache().getWANTED_ITEMS());
    }
}
