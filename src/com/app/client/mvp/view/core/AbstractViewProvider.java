package com.app.client.mvp.view.core;

import com.telcordia.granite.platform.ui.client.gui.AbstractContext;
import com.telcordia.granite.platform.ui.client.gui.GuiFactory;

public abstract class AbstractViewProvider {
    private AbstractContext context;

    public AbstractViewProvider(AbstractContext context) {
        this.context = context;
    }

    public final void load() {
        buildUI(context.gui());
        drawUI();
    }

    protected abstract void buildUI(GuiFactory gui);
    protected abstract void drawUI();
}
