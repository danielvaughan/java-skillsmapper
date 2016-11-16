package org.codetaming.skillsmapper.client.views;

import com.google.gwt.event.shared.SimpleEventBus;
import org.codetaming.skillsmapper.client.widgets.ProtoWidget;

public abstract class ProtoViewWidget extends ProtoWidget {

    protected SimpleEventBus eventBus;

    protected ProtoViewWidget(SimpleEventBus eventBus) {
        super();
        this.eventBus = eventBus;
    }

    protected abstract void fireSelectEvent(int key);

    protected abstract void initClickHandlers();

    protected void initElements() {
        initClickHandlers();
    }

}
