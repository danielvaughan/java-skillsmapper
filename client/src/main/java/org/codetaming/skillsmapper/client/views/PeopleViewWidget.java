package org.codetaming.skillsmapper.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import org.codetaming.skillsmapper.client.widgets.PeopleListWidget;

public class PeopleViewWidget extends ProtoViewWidget {

    private static Binder uiBinder = GWT.create(Binder.class);

    @UiField(provided = true)
    PeopleListWidget peopleListWidget;

    @Inject
    public PeopleViewWidget(SimpleEventBus eventBus, PeopleListWidget peopleListWidget) {
        super(eventBus);
        this.peopleListWidget = peopleListWidget;
        initWidget(uiBinder.createAndBindUi(this));
        initElements();
    }

    @Override
    protected void fireSelectEvent(int key) {
    }

    @Override
    protected void initClickHandlers() {
        
    }

    interface Binder extends UiBinder<Widget, PeopleViewWidget> {
    }

}
