package com.xman.bots.mining.stateMiner.stateRootNodes.inRoute.leaves;

import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.script.framework.tree.LeafTask;
import com.xman.bots.mining.stateMiner.RootNodeWrapper;
import com.xman.bots.mining.stateMiner.stateRootNodes.inBankArea.branches.InBankArea;
import com.xman.bots.mining.stateMiner.stateRootNodes.inMineArea.branches.InMineArea;

public class SetStateToArea extends LeafTask {

    private String area;
    public SetStateToArea(String area){
        this.area = area;
    }

    @Override
    public void execute() {
        Environment.getLogger().debug("Setting state to InArea");
        //set State
        if(area.equals("bank")){
            RootNodeWrapper.getInstance().setCurrentState(new InBankArea());
        }
        else if(area.equals("mine")){
            RootNodeWrapper.getInstance().setCurrentState(new InMineArea());
        }
    }
}
