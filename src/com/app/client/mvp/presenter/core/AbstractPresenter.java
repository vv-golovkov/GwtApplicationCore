package com.app.client.mvp.presenter.core;

import com.app.client.engine.eventbus.EventBusController;
import com.app.client.engine.util.StatusbarManager;
import com.app.client.service.Service1;
import com.app.client.service.Service1Async;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;

public abstract class AbstractPresenter {
    protected final Service1Async rpc = Service1.Util.getInstance();
    protected static final EventBusController eventBus = new EventBusController();
    private StatusbarManager statusbar;
    
    public void setStatusbar(StatusbarManager statusbar) {
        this.statusbar = statusbar;
    }
    
    /****************************************** ABSTRACT ******************************************/
    public abstract void registerUIEventHandlers();

    /****************************************** PROTECTED ******************************************/
    protected void showLoadingDialog(String message) {
        SC.showPrompt(message);
    }

    protected void showInformation(String infoMessage) {
        statusbar.addInfoStatus(infoMessage);
        inform(infoMessage);
    }
    
    protected void showInformation(String infoMessage, BooleanCallback booleanCallback) {
        statusbar.addInfoStatus(infoMessage);
        inform(infoMessage, booleanCallback);
    }
    
    protected void showWarning(String warningMessage) {
        statusbar.addWarnStatus(warningMessage);
        warn(warningMessage);
    }
    
    protected void showWarning(String warningMessage, BooleanCallback booleanCallback) {
        statusbar.addWarnStatus(warningMessage);
        warn(warningMessage, booleanCallback);
    }

    /****************************************** PRIVATE ******************************************/
    private void warn(String message) {
        SC.warn(message);
    }
    
    private void warn(String message, BooleanCallback booleanCallback) {
        SC.warn(message, booleanCallback);
    }
    
    private void inform(String message) {
        SC.say(message);
    }
    
    private void inform(String message, BooleanCallback booleanCallback) {
        SC.say(message, booleanCallback);
    }
}
