package gigabit101.AdvancedSystemManager2;

import gigabit101.AdvancedSystemManager2.init.ModBlocks;
import gigabit101.AdvancedSystemManager2.components.ModItemHelper;
import gigabit101.AdvancedSystemManager2.init.ModRecipes;
import gigabit101.AdvancedSystemManager2.network.FileHelper;
import gigabit101.AdvancedSystemManager2.network.PacketEventHandler;
import gigabit101.AdvancedSystemManager2.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.FMLEventChannel;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(modid = AdvancedSystemManager2.MODID, name = "AdvancedSystemManager2", version = GeneratedInfo.version)
public class AdvancedSystemManager2
{
    public static final String MODID = "AdvancedSystemManager2";
    public static final String RESOURCE_LOCATION = "advancedsystemmanager2";
    public static final String CHANNEL = "AdvancedSystemManager2";
    public static final String UNLOCALIZED_START = "afm.";

    public static FMLEventChannel packetHandler;

    @SidedProxy(clientSide = "gigabit101.AdvancedSystemManager2.proxy.ClientProxy", serverSide = " gigabit101.AdvancedSystemManager2.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance(MODID)
    public static AdvancedSystemManager2 instance;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        packetHandler = NetworkRegistry.INSTANCE.newEventDrivenChannel(CHANNEL);
        ModBlocks.init();
        proxy.preInit();
        FileHelper.setConfigDir(event.getModConfigurationDirectory());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        packetHandler.register(new PacketEventHandler());
        ModRecipes.init();
        //new ChatListener();
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
        FMLInterModComms.sendMessage("Waila", "register", "Provider.callbackRegister");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        ModItemHelper.init();
    }

}
