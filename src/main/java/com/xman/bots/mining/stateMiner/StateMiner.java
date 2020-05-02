package com.xman.bots.mining.stateMiner;

import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.script.framework.tree.TreeBot;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class StateMiner extends TreeBot {

    @Override
    public TreeTask createRootTask() {
        Environment.getLogger().debug("Getting RootNodeWrapper Instance");
        RootNodeWrapper wrap = RootNodeWrapper.getInstance();
        Environment.getLogger().debug("Instance Created");
        return wrap;
    }

}
