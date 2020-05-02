package com.xman.bots.mining.stateMiner.stateRootNodes.inBankArea.leaves;

import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class CloseBank extends LeafTask {
    @Override
    public void execute() {
        Bank.close();
    }
}
