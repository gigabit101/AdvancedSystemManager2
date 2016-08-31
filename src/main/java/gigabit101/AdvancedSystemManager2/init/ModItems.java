package gigabit101.AdvancedSystemManager2.init;

import gigabit101.AdvancedSystemManager2.items.ItemDuplicator;
import gigabit101.AdvancedSystemManager2.items.ItemRemoteAccessor;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Gigabit101 on 31/08/2016.
 */
public class ModItems
{
    public static Item duplicator;
    public static Item remoteaccessor;

    public static void init()
    {
        duplicator = new ItemDuplicator().setRegistryName("duplicator");
        GameRegistry.register(duplicator);

        remoteaccessor = new ItemRemoteAccessor().setRegistryName("remoteaccessor");
        GameRegistry.register(remoteaccessor);
    }
}
