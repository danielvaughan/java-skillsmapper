package org.codetaming.skillsmapper.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import org.codetaming.skillsmapper.client.events.SelectPersonEvent;
import org.codetaming.skillsmapper.client.events.SelectPersonEventHandler;
import org.codetaming.skillsmapper.client.widgets.ProfileDetailsWidget;
import org.codetaming.skillsmapper.client.widgets.ProfileImageWidget;
import org.codetaming.skillsmapper.client.widgets.ProtoWidget;
import org.codetaming.skillsmapper.client.widgets.SkillsWidget;

import java.util.logging.Logger;

public class ProfileViewWidget extends ProtoWidget implements SelectPersonEventHandler {

    private static final Logger LOGGER = Logger.getLogger("ProfileViewWidget");

    private static Binder uiBinder = GWT.create(ProfileViewWidget.Binder.class);

    private EventBus eventBus;

    @UiField(provided = true)
    ProfileImageWidget profileImageWidget;

    @UiField(provided = true)
    ProfileDetailsWidget profileDetailsWidget;

    @UiField(provided = true)
    SkillsWidget skillsWidget;

    @Inject
    public ProfileViewWidget(SimpleEventBus eventBus, ProfileImageWidget profileImageWidget, ProfileDetailsWidget profileDetailsWidget, SkillsWidget skillsWidget) {
        this.eventBus = eventBus;
        this.profileImageWidget = profileImageWidget;
        this.profileDetailsWidget = profileDetailsWidget;
        this.skillsWidget = skillsWidget;
        initWidget(uiBinder.createAndBindUi(this));
        initListeners();
    }

    private void initListeners() {
        eventBus.addHandler(SelectPersonEvent.TYPE, this);
    }

    @Override
    public void onSelectPerson(SelectPersonEvent selectPersonEvent) {

    }

    interface Binder extends UiBinder<Widget, ProfileViewWidget> {
    }
}
