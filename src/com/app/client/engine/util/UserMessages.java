package com.app.client.engine.util;

import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;

public class UserMessages {
    private StatusbarManager statusbar;

    public UserMessages(StatusbarManager statusbar) {
        this.statusbar = statusbar;
    }

    public void showLoadingDialog(String message) {
        SC.showPrompt(message);
    }

    public void showInformation(String infoMessage) {
        statusbar.addInfoStatus(infoMessage);
        inform(infoMessage);
    }

    public void showInformation(String infoMessage, BooleanCallback booleanCallback) {
        statusbar.addInfoStatus(infoMessage);
        inform(infoMessage, booleanCallback);
    }

    public void showWarning(String warningMessage) {
        statusbar.addWarnStatus(warningMessage);
        warn(warningMessage);
    }

    public void showWarning(String warningMessage, BooleanCallback booleanCallback) {
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
