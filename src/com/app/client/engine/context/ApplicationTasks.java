package com.app.client.engine.context;

import com.telcordia.granite.platform.ui.client.gui.events.TaskType;

/**
 * Build a Task Types interface that extends TaskTypes. Define integers for each
 * task to be handled by the task handler.
 * 
 */
public interface ApplicationTasks extends TaskType {
    int BUILD_GUI = _NEXT;
}
