package com.app.client.engine.context.command;

import com.app.client.engine.context.ApplicationTasks;
import com.app.client.engine.context.Context;
import com.telcordia.granite.platform.ui.client.gui.events.TaskArguments;
import com.telcordia.granite.platform.ui.client.utils.ChainableCommand;
import com.telcordia.granite.platform.ui.client.utils.CommandChain;

/**
 * Command class for Building GUI. Create a ChainableCommand to build the gui.
 * Note this doesn't build the gui, it will invoke the Entry Point to do this
 * via the Task Handler.
 * 
 */
public class BuildGuiCommand extends ChainableCommand {
    private Context context;

    public BuildGuiCommand(Context context) {
        this.context = context;
    }

    @Override
    public void execute(CommandChain commandChain) {
        TaskArguments arguments = context.getTaskRequest().getTaskArguments();
        arguments.clear();
        arguments.setTask(ApplicationTasks.BUILD_GUI);
        context.getTaskRequest().fire();
        // Chain to the next command
        commandChain.executeNext();
    }
}
