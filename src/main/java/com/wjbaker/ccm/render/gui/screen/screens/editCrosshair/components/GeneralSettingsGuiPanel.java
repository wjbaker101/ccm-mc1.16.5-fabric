package com.wjbaker.ccm.render.gui.screen.screens.editCrosshair.components;

import com.wjbaker.ccm.CustomCrosshairMod;
import com.wjbaker.ccm.crosshair.CustomCrosshair;
import com.wjbaker.ccm.render.gui.component.components.*;
import com.wjbaker.ccm.render.gui.screen.GuiScreen;

public final class GeneralSettingsGuiPanel extends PanelGuiComponent {

    public GeneralSettingsGuiPanel(
        final GuiScreen parentGuiScreen,
        final CustomCrosshair crosshair,
        final int x,
        final int y,
        final int width,
        final int height) {

        super(parentGuiScreen, x, y, width, height);

        var heading = new HeadingGuiComponent(this.parentGuiScreen, -1, -1, "General Settings");

        var isModEnabledCheckbox = new CheckBoxGuiComponent(
            this.parentGuiScreen,
            -1, -1,
            "Enable " + CustomCrosshairMod.TITLE,
            CustomCrosshairMod.INSTANCE.properties().getIsModEnabled().get());
        isModEnabledCheckbox.bind(CustomCrosshairMod.INSTANCE.properties().getIsModEnabled());

        var crosshairStyleSlider = new EnumSliderGuiComponent<>(
            this.parentGuiScreen,
            -1, -1,
            50,
            "Crosshair Style",
            crosshair.style.get());
        crosshairStyleSlider.bind(crosshair.style);

        var isKeepDebugEnabledCheckbox = new CheckBoxGuiComponent(
            this.parentGuiScreen,
            -1, -1,
            "Keep Default Debug Crosshair When HUD Is Visible",
            crosshair.isKeepDebugEnabled.get());
        isKeepDebugEnabledCheckbox.bind(crosshair.isKeepDebugEnabled);

        var blockOutlineColourColourPicker = new ColourPickerGuiComponent(
            this.parentGuiScreen,
            crosshair,
            -1, -1,
            "Block Outline Colour");
        blockOutlineColourColourPicker.bind(CustomCrosshairMod.INSTANCE.properties().getBlockOutlineColour());

        this.addComponent(heading);
        this.addComponent(isModEnabledCheckbox);
        this.addComponent(crosshairStyleSlider);
        this.addComponent(isKeepDebugEnabledCheckbox);
        this.addComponent(blockOutlineColourColourPicker);
        this.pack();
    }
}
