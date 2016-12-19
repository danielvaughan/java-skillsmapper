package org.codetaming.skillsmapper.client.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

import org.codetaming.skillsmapper.client.events.ProfileSelectedEvent;
import org.codetaming.skillsmapper.client.model.Person;
import org.codetaming.skillsmapper.client.model.TagsWrapper;
import org.codetaming.skillsmapper.client.services.PeopleService;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import java.util.logging.Logger;

public class SkillsWidget extends ProtoWidget implements ProfileSelectedEvent.Handler {

    private static final Logger LOGGER = Logger.getLogger(SkillsWidget.class.getName());

    private static Binder uiBinder = GWT.create(Binder.class);

    @UiField
    TagBoxWidget interestedTagBoxWidget;
    @UiField
    TagBoxWidget learningTagBoxWidget;
    @UiField
    TagBoxWidget usingTagBoxWidget;
    @UiField
    TagBoxWidget usedTagBoxWidget;

    private PeopleService peopleService = GWT.create(PeopleService.class);

    private EventBus eventBus;

    @Inject
    public SkillsWidget(EventBus eventBus) {
        this.eventBus = eventBus;
        initWidget(uiBinder.createAndBindUi(this));
        initHeaders();
        initListeners();
    }

    private void initHeaders() {
        interestedTagBoxWidget.setHeading("Interested in");
        learningTagBoxWidget.setHeading("Learning");
        usingTagBoxWidget.setHeading("Using");
        usedTagBoxWidget.setHeading("Has Used");
    }

    private void initListeners() {
        eventBus.addHandler(ProfileSelectedEvent.TYPE, this);
    }

    public void showPerson(Person person) {
    }

    @Override
    public void onProfileSelected(ProfileSelectedEvent profileSelectedEvent) {
        String id = profileSelectedEvent.getId();
        peopleService.getInterested(id, new MethodCallback<TagsWrapper>() {
            @Override
            public void onFailure(Method method, Throwable exception) {
                LOGGER.severe("Error getting interested skills: " + exception.getMessage());
            }

            @Override
            public void onSuccess(Method method, TagsWrapper response) {
                LOGGER.info(response.toString());
                interestedTagBoxWidget.setTags(response.get_embedded().getTags());
            }
        });
        peopleService.getLearning(id, new MethodCallback<TagsWrapper>() {
            @Override
            public void onFailure(Method method, Throwable exception) {
                LOGGER.severe("Error getting learning skills: " + exception.getMessage());
            }

            @Override
            public void onSuccess(Method method, TagsWrapper response) {
                LOGGER.info(response.toString());
                learningTagBoxWidget.setTags(response.get_embedded().getTags());
            }
        });
        peopleService.getUsing(id, new MethodCallback<TagsWrapper>() {
            @Override
            public void onFailure(Method method, Throwable exception) {
                LOGGER.severe("Error getting using skills: " + exception.getMessage());
            }

            @Override
            public void onSuccess(Method method, TagsWrapper response) {
                LOGGER.info(response.toString());
                usingTagBoxWidget.setTags(response.get_embedded().getTags());
            }
        });
        peopleService.getUsed(id, new MethodCallback<TagsWrapper>() {
            @Override
            public void onFailure(Method method, Throwable exception) {
                LOGGER.severe("Error getting used skills: " + exception.getMessage());
            }

            @Override
            public void onSuccess(Method method, TagsWrapper response) {
                LOGGER.info(response.toString());
                usedTagBoxWidget.setTags(response.get_embedded().getTags());
            }
        });
    }

    interface Binder extends UiBinder<Widget, SkillsWidget> {
    }
}
