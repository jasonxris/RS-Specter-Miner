package com.xman.bots.mining.stateMiner.stateRootNodes.inMineArea.leaves;

import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.local.Skill;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;
import com.xman.bots.mining.stateMiner.data.DataCache;

import java.awt.*;

public class MineRock extends LeafTask {

    DataCache cache = DataCache.getCache();
    private Color colorToMine = cache.getOreToMine().getAvailable();
    private Color empty = new Color(48,48,48);
    @Override
    public void execute() {
        Environment.getBot().getLogger().info("Attempting to mine rock");

        GameObject mineableRock = GameObjects.newQuery().within(cache.getMineRegion()).colorSubstitutions(empty,colorToMine).results().nearest();
        if(mineableRock != null){
            int miningXPbefore = Skill.MINING.getExperience();
            if(mineableRock.isVisible()){
                if(mineableRock.interact("Mine")){
                    Execution.delayUntil(()->!mineableRock.isValid() || Skill.MINING.getExperience() > miningXPbefore, 8000, 15000);
                }
            }
            else{
                Camera.turnTo(mineableRock);

            }
        }
        else{
            Environment.getBot().getLogger().info("The rock we looked for in MineRock was null");
        }

    }
}
