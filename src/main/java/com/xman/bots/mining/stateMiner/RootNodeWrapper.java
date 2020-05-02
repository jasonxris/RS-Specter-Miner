package com.xman.bots.mining.stateMiner;

import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import com.xman.bots.mining.stateMiner.stateRootNodes.isMinerReady.branches.IsMinerReady;

public class RootNodeWrapper extends BranchTask {

    private BranchTask currentState;
    private static RootNodeWrapper instance;

    private RootNodeWrapper(){
        currentState = new IsMinerReady();
    }

    public static RootNodeWrapper getInstance(){
        if(instance == null){
            instance = new RootNodeWrapper();
        }
        return instance;
    }


    @Override
    public boolean validate() {
        return currentState.validate();
    }

    @Override
    public TreeTask successTask() {
        return currentState.successTask();
    }

    @Override
    public TreeTask failureTask() {
        return currentState.failureTask();
    }


    public BranchTask getCurrentState() {
        return currentState;
    }

    public void setCurrentState(BranchTask currentState) {
        this.currentState = currentState;
    }
}
