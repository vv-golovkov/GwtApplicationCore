package com.app.client.engine.context;

import com.telcordia.granite.platform.ui.client.gui.AbstractContext;
import com.telcordia.granite.platform.ui.client.gui.events.TaskHandler;

/**
 * Application context.
 */
public class Context extends AbstractContext {
    
    public Context(TaskHandler taskHandler) {
        super(taskHandler);
    }
}
