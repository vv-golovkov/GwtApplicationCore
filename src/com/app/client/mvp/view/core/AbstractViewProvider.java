package com.app.client.mvp.view.core;

import com.app.client.engine.util.StatusbarManager;
import com.app.client.mvp.presenter.core.AbstractPresenter;
import com.telcordia.granite.platform.ui.client.gui.AbstractContext;
import com.telcordia.granite.platform.ui.client.gui.GuiFactory;

public abstract class AbstractViewProvider<T extends AbstractPresenter> {
    private AbstractContext context;
    private T presenter;
    
    public AbstractViewProvider(AbstractContext context) {
        this.context = context;
    }
    
    protected T getPresenter() {
        return presenter;
    }
    
    public final void load() {
        presenter = definePresenter();
        presenter.setStatusbar(new StatusbarManager(context.statusBar()));
        buildUI(context.gui());
        registerUIEventHandlers();
        drawUI();
    }
    
    private void registerUIEventHandlers() {
        presenter.registerUIEventHandlers();
    }

    protected abstract T definePresenter();
    protected abstract void buildUI(GuiFactory gui);
    protected abstract void drawUI();
}
