package gigabit101.AdvancedSystemManager2.items;

import gigabit101.AdvancedSystemManager2.init.ModBlocks;
import gigabit101.AdvancedSystemManager2.lib.ModInfo;
import net.minecraft.item.Item;

/**
 * Created by Gigabit101 on 31/08/2016.
 */
public class ItemRemoteAccessor extends Item
{
    public ItemRemoteAccessor()
    {
        setCreativeTab(ModBlocks.creativeTab);
        setUnlocalizedName(ModInfo.UNLOCALIZED_START + "remoteaccessor");
        setMaxStackSize(1);
    }
}
