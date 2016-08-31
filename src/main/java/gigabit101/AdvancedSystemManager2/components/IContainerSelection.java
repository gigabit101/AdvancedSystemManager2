package gigabit101.AdvancedSystemManager2.components;


import gigabit101.AdvancedSystemManager2.interfaces.GuiManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IContainerSelection {
    int getId();
    @SideOnly(Side.CLIENT)
    void draw(GuiManager gui, int x, int y);
    @SideOnly(Side.CLIENT)
    String getDescription(GuiManager gui);
    @SideOnly(Side.CLIENT)
    String getName(GuiManager gui);
    boolean isVariable(); //fast access
}
