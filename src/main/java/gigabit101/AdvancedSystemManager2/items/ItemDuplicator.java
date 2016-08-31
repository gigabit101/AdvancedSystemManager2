package gigabit101.AdvancedSystemManager2.items;

import gigabit101.AdvancedSystemManager2.init.ModBlocks;
import gigabit101.AdvancedSystemManager2.lib.ModInfo;
import net.minecraft.item.Item;

/**
 * Created by Gigabit101 on 31/08/2016.
 */
public class ItemDuplicator extends Item
{
    public ItemDuplicator()
    {
        setUnlocalizedName(ModInfo.UNLOCALIZED_START + "duplicator");
        setMaxStackSize(1);
        setCreativeTab(ModBlocks.creativeTab);
    }
}
