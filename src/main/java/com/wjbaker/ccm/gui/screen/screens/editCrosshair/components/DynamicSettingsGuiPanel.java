package com.wjbaker.ccm.gui.screen.screens.editCrosshair.components;

import com.wjbaker.ccm.crosshair.CustomCrosshair;
import com.wjbaker.ccm.gui.component.components.CheckBoxGuiComponent;
import com.wjbaker.ccm.gui.component.components.HeadingGuiComponent;
import com.wjbaker.ccm.gui.component.components.PanelGuiComponent;
import com.wjbaker.ccm.gui.screen.GuiScreen;

public final class DynamicSettingsGuiPanel extends PanelGuiComponent {

    public DynamicSettingsGuiPanel(
        final GuiScreen parentGuiScreen,
        final CustomCrosshair crosshair,
        final int x,
        final int y,
        final int width,
        final int height) {

        super(parentGuiScreen, x, y, width, height);

        var heading = new HeadingGuiComponent(this.parentGuiScreen, -1, -1, "Dynamic Crosshair Settings");

        var isDynamicAttackIndicatorEnabledCheckBox = new CheckBoxGuiComponent(
            this.parentGuiScreen,
            -1, -1,
            "Enable Dynamic Attack Indicator",
            crosshair.isDynamicAttackIndicatorEnabled.get());
        isDynamicAttackIndicatorEnabledCheckBox.bind(crosshair.isDynamicAttackIndicatorEnabled);

        var isDynamicBowEnabledCheckBox = new CheckBoxGuiComponent(
            this.parentGuiScreen,
            -1, -1,
            "Enable Dynamic Pull Progress",
            crosshair.isDynamicBowEnabled.get());
        isDynamicBowEnabledCheckBox.bind(crosshair.isDynamicBowEnabled);

        this.addComponent(heading);
        this.addComponent(isDynamicAttackIndicatorEnabledCheckBox);
        this.addComponent(isDynamicBowEnabledCheckBox);
        this.pack();
    }
}
