package com.xman.bots.mining.stateMiner.stateRootNodes.inBankArea.branches;

import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class IsBankOpen extends BranchTask {

    @Override
    public boolean validate() {
        return Bank.isOpen();
    }

    @Override
    public TreeTask successTask() {
        Environment.getBot().getLogger().info("Bank is open");

        return new IsInventoryEmptyBank();
    }

    @Override
    public TreeTask failureTask() {
        Environment.getBot().getLogger().info("Bank is not open");

        return new IsPickAxeEqippedOutside();
    }
}
