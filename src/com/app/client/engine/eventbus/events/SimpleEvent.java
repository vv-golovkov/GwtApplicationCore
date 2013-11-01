package com.app.client.engine.eventbus.events;

import com.app.client.engine.eventbus.GwtEventSupport;
import com.app.client.engine.eventbus.handlers.SimpleEventHandler;

/**
 * Class for creating simple events. To create event/s, just needs to add
 * {@link EventKey} initialization with 'event_' prefix and relevant event name.
 * 
 */
public class SimpleEvent extends GwtEventSupport<SimpleEventHandler> {
    
    public SimpleEvent(EventKey<SimpleEventHandler> eventKey) {
        super(eventKey);
    }

    @Override
    public void dispatch(SimpleEventHandler handler) {
        handler.onOperationPerformed();
    }
}
