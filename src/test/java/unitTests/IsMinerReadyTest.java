package unitTests;

import com.runemate.game.api.hybrid.local.hud.interfaces.Equipment;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.xman.bots.mining.stateMiner.data.DataCache;

import com.xman.bots.mining.stateMiner.stateRootNodes.isMinerReady.branches.IsMinerReady;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Equipment.class, Inventory.class})
public class IsMinerReadyTest {

    DataCache cache = DataCache.getCache();


    @Test
    public void equipmentIsReady(){
        boolean pickaxeInInventoryBuyNotEquipped;
        boolean pickaxeEquippedButNotInInventory;

        PowerMockito.mockStatic(Equipment.class);
        PowerMockito.mockStatic(Inventory.class);

        PowerMockito.when((Equipment.containsAnyOf(cache.getPICKAXES()))).thenReturn(true);
        PowerMockito.when((Inventory.containsAnyOf(cache.getPICKAXES()))).thenReturn(false);
        PowerMockito.when((Inventory.isFull())).thenReturn(false);

        IsMinerReady isMinerReady = new IsMinerReady();

        pickaxeEquippedButNotInInventory = isMinerReady.validate();
        PowerMockito.when((Equipment.containsAnyOf(cache.getPICKAXES()))).thenReturn(false);
        PowerMockito.when((Inventory.containsAnyOf(cache.getPICKAXES()))).thenReturn(true);
        pickaxeInInventoryBuyNotEquipped = isMinerReady.validate();


        assertTrue(pickaxeEquippedButNotInInventory);
        assertTrue(pickaxeInInventoryBuyNotEquipped);
    }

    @Test
    public void equipmentIsNotReady(){
        boolean noPickaxeOnPersonInventoryReady;
        boolean noPickaxeOnPersonInventoryNotReady;
        boolean inventoryIsNotReadyPickAxeInInventory;
        boolean inventoryIsNotReadyPickAxeInIEquipment;

        IsMinerReady isMinerReady = new IsMinerReady();
        PowerMockito.mockStatic(Equipment.class);
        PowerMockito.mockStatic(Inventory.class);

        PowerMockito.when((Equipment.containsAnyOf(cache.getPICKAXES()))).thenReturn(false);
        PowerMockito.when((Inventory.containsAnyOf(cache.getPICKAXES()))).thenReturn(false);
        PowerMockito.when((Inventory.isFull())).thenReturn(false);
        noPickaxeOnPersonInventoryReady = isMinerReady.validate();

        PowerMockito.when((Equipment.containsAnyOf(cache.getPICKAXES()))).thenReturn(false);
        PowerMockito.when((Inventory.containsAnyOf(cache.getPICKAXES()))).thenReturn(false);
        PowerMockito.when((Inventory.isFull())).thenReturn(true);
        noPickaxeOnPersonInventoryNotReady = isMinerReady.validate();

        PowerMockito.when((Equipment.containsAnyOf(cache.getPICKAXES()))).thenReturn(false);
        PowerMockito.when((Inventory.containsAnyOf(cache.getPICKAXES()))).thenReturn(true);
        PowerMockito.when((Inventory.isFull())).thenReturn(true);
        inventoryIsNotReadyPickAxeInInventory = isMinerReady.validate();

        PowerMockito.when((Equipment.containsAnyOf(cache.getPICKAXES()))).thenReturn(true);
        PowerMockito.when((Inventory.containsAnyOf(cache.getPICKAXES()))).thenReturn(false);
        PowerMockito.when((Inventory.isFull())).thenReturn(true);
        inventoryIsNotReadyPickAxeInIEquipment = isMinerReady.validate();


        assertFalse(noPickaxeOnPersonInventoryReady);
        assertFalse(noPickaxeOnPersonInventoryNotReady);
        assertFalse(inventoryIsNotReadyPickAxeInInventory);
        assertFalse(inventoryIsNotReadyPickAxeInIEquipment);
    }


}
