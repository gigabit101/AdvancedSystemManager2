package gigabit101.AdvancedSystemManager2.blocks;

import gigabit101.AdvancedSystemManager2.AdvancedSystemManager2;
import gigabit101.AdvancedSystemManager2.init.ModBlocks;
import gigabit101.AdvancedSystemManager2.lib.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;


public class ItemRelay extends ItemBlock {

    public ItemRelay(Block block) {
        super(block);
        setHasSubtypes(true);
        setMaxDamage(0);
    }

    @Override
    public String getUnlocalizedName(ItemStack item) {
        return "tile." + ModInfo.UNLOCALIZED_START + (ModBlocks.blockCableRelay.isAdvanced(item.getItemDamage()) ? ModBlocks.CABLE_ADVANCED_RELAY_UNLOCALIZED_NAME : ModBlocks.CABLE_RELAY_UNLOCALIZED_NAME);
    }

}
