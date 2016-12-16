package org.codetaming.skillsmapper.client.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

import org.codetaming.skillsmapper.client.views.PeopleViewWidget;
import org.codetaming.skillsmapper.client.views.ProfileViewWidget;

public class MainPanel extends Composite {

    private static Binder uiBinder = GWT.create(Binder.class);

    private final EventBus eventBus;

    @UiField(provided = true)
    PeopleViewWidget peopleViewWidget;
    @UiField(provided = true)
    ProfileViewWidget profileViewWidget;

    @Inject
    public MainPanel(final EventBus eventBus, final PeopleViewWidget peopleViewWidget, final ProfileViewWidget profileViewWidget) {
        this.eventBus = eventBus;
        this.peopleViewWidget = peopleViewWidget;
        this.profileViewWidget = profileViewWidget;
        initWidget(uiBinder.createAndBindUi(this));
    }

    interface Binder extends UiBinder<Widget, MainPanel> {
    }

}
