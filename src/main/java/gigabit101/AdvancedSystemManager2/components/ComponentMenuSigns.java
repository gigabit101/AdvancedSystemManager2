package gigabit101.AdvancedSystemManager2.components;


import gigabit101.AdvancedSystemManager2.Localization;
import gigabit101.AdvancedSystemManager2.blocks.ConnectionBlockType;

import java.util.List;

public class ComponentMenuSigns extends ComponentMenuContainer {
    public ComponentMenuSigns(FlowComponent parent) {
        super(parent, ConnectionBlockType.SIGN);
    }

    @Override
    public String getName() {
        return Localization.SIGNS.toString();
    }

    @Override
    public void addErrors(List<String> errors) {
        if (selectedInventories.isEmpty() && isVisible()) {
            errors.add(Localization.NO_SIGNS_ERROR.toString());
        }
    }

    @Override
    protected void initRadioButtons() {

    }
}
