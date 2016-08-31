package gigabit101.AdvancedSystemManager2.components;


import gigabit101.AdvancedSystemManager2.Localization;

public class ComponentMenuRedstoneSidesNodes extends ComponentMenuRedstoneSidesTrigger{

    public ComponentMenuRedstoneSidesNodes(FlowComponent parent) {
        super(parent);
    }

    @Override
    public String getName() {
        return Localization.REDSTONE_SIDES_MENU.toString();
    }

    @Override
    public boolean isVisible() {
        return true;
    }
}
