package com.app.client.engine.util;

import com.telcordia.granite.platform.ui.client.gui.Statusbar;

/**
 * Manager class for {@link Statusbar}. Supports adding Information message,
 * Warning message, Debug message, Error message.
 */
public class StatusbarManager {
    private static final String ENTER = "\n";
    private static final String BR = "<br>";
    private Statusbar statusbar;
    
    public StatusbarManager(Statusbar statusbar) {
        this.statusbar = statusbar;
    }

    /**
     * Add information status message.
     * 
     * @param message
     *            - information message.
     */
    public void addInfoStatus(String message) {
        statusbar.setInfoStatus(formatMessage(message));
    }

    /**
     * Add debug status message.
     * 
     * @param message
     *            - debug message.
     */
    public void addDebugStatus(String message) {
        statusbar.setDebugStatus(formatMessage(message));
    }

    /**
     * Add warning status to status bar.
     * 
     * @param message
     *            - warning message.
     */
    public void addWarnStatus(String message) {
        statusbar.setWarnStatus(formatMessage(message));
    }

    /**
     * Add error status message.
     * 
     * @param caught
     *            - caught exception.
     */
    public void addErrorStatus(Throwable caught) {
        String message = formatMessage(caught.getMessage());
        statusbar.setErrorStatus(message, caught);
    }

    /**
     * Format message before track.
     * 
     * @param message
     *            - string message.
     * @return formatted string.
     */
    private String formatMessage(String message) {
        return (CustomStringUtils.isNotEmpty(message)) ? message.replaceAll(BR, ENTER) : message;
    }
}
