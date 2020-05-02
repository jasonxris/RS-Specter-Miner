package com.xman.bots.mining.stateMiner.stateRootNodes.inBankArea.leaves;

import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;
import com.xman.bots.mining.stateMiner.data.DataCache;

public class OpenBank extends LeafTask {
    private Coordinate bankCoord = DataCache.getCache().getBankBoothCoord();
    private Player player;
    @Override
    public void execute() {
        Environment.getBot().getLogger().info("Open Bank");
        GameObject bankChest = GameObjects.newQuery().on(bankCoord).names("Bank booth").actions("Bank").results().first();
        if(bankChest != null){
            if(bankChest.isVisible()){
                if(bankChest.interact("Bank")){
                    Execution.delayUntil(()-> Bank.isOpen(), ()-> (player = Players.getLocal()) != null && player.isMoving(),100,1000);
                }
                else{
                    Camera.turnTo(bankChest);
                    Environment.getBot().getLogger().info("Bank Chest failed to open");

                }
            }else{
                Camera.turnTo(bankChest);
            }

        }else{
            Environment.getBot().getLogger().info("The Bank booth is null");
        }
    }
}
