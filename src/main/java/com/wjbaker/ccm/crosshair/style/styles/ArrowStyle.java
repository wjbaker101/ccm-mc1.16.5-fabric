package com.wjbaker.ccm.crosshair.style.styles;

import com.wjbaker.ccm.crosshair.CustomCrosshair;
import com.wjbaker.ccm.crosshair.render.ComputedProperties;
import com.wjbaker.ccm.crosshair.style.AbstractCrosshairStyle;
import net.minecraft.client.util.math.MatrixStack;

public final class ArrowStyle extends AbstractCrosshairStyle {

    public ArrowStyle(final MatrixStack matrixStack, final CustomCrosshair crosshair) {
        super(matrixStack, crosshair);
    }

    @Override
    public void draw(final int x, final int y, final ComputedProperties computedProperties) {
        int width = this.crosshair.width.get();
        int height = this.crosshair.height.get();
        int thickness = this.crosshair.thickness.get();

        this.renderManager.drawLines(this.matrixStack, new float[] {
            x - width, y + height, x, y,
            x, y, x + width, y + height
        }, thickness, computedProperties.colour());
    }
}
