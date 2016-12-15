package org.codetaming.skillsmapper.client.views;

import com.google.web.bindery.event.shared.EventBus;

import org.codetaming.skillsmapper.client.widgets.ProtoWidget;

public abstract class ProtoViewWidget extends ProtoWidget {

    protected EventBus eventBus;

    protected ProtoViewWidget(EventBus eventBus) {
        super();
        this.eventBus = eventBus;
    }

    protected abstract void fireSelectEvent(int key);

    protected abstract void initClickHandlers();

    protected void initElements() {
        initClickHandlers();
    }

}
