package org.codetaming.skillsmapper.client.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

import org.codetaming.skillsmapper.client.model.Group;
import org.codetaming.skillsmapper.client.model.Person;
import org.codetaming.skillsmapper.client.model.Title;
import org.gwtbootstrap3.client.ui.Heading;
import org.gwtbootstrap3.client.ui.Image;
import org.gwtbootstrap3.client.ui.PageHeader;

import java.util.List;
import java.util.logging.Logger;

public class ProfileDetailsWidget extends ProtoWidget {

    private static final Logger LOGGER = Logger.getLogger("ProfileDetailsWidget");

    private static final String DEFAULT_PHOTO_URL = "http://common.gcscc.site/img/silhouette.png";

    private static ProfileDetailsWidget.Binder uiBinder = GWT.create(ProfileDetailsWidget.Binder.class);

    @UiField
    PageHeader name;

    @UiField
    Image photo;

    @UiField
    Heading groupsHeader;

    @UiField
    Heading titlesHeader;

    private EventBus eventBus;

    @Inject
    public ProfileDetailsWidget(EventBus eventBus) {
        this.eventBus = eventBus;
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void showPerson(Person person) {
        clearPerson();
        name.setText(person.getName());
        photo.setUrl(person.getImageUrl() == null ? DEFAULT_PHOTO_URL : person.getImageUrl());
    }

    public void showGroups(List<Group> groups) {
        clearGroups();
        StringBuffer groupsStr = new StringBuffer();
        groups.forEach(group -> groupsStr.append(group.getName()));
        groupsHeader.setText(groupsStr.toString());
    }

    public void showTitles(List<Title> titles) {
        clearTitles();
        StringBuffer titlesStr = new StringBuffer();
        titles.forEach(title -> titlesStr.append(title.getName()));
        titlesHeader.setText(titlesStr.toString());
    }

    public void clearPerson() {
        name.clear();
        photo.setUrl(DEFAULT_PHOTO_URL);
    }

    public void clearGroups() {
        groupsHeader.clear();
    }

    public void clearTitles() {
        titlesHeader.clear();
    }

    interface Binder extends UiBinder<Widget, ProfileDetailsWidget> {
    }
}
