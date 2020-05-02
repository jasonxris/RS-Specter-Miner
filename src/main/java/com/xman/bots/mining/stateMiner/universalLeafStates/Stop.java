package com.xman.bots.mining.stateMiner.universalLeafStates;

import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class Stop extends LeafTask {
    private String reasonForStop;
    public Stop(String reasonForStop){
        this.reasonForStop = reasonForStop;
    }
    @Override
    public void execute() {
        Environment.getLogger().debug("Stopping bot");
        Environment.getBot().stop(reasonForStop);
    }
}
