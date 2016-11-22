package org.codetaming.skillsmapper.client.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import org.codetaming.skillsmapper.client.events.SelectPersonEvent;
import org.codetaming.skillsmapper.client.events.SelectPersonEventHandler;
import org.codetaming.skillsmapper.client.model.Tag;
import org.codetaming.skillsmapper.client.services.SkillsService;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import java.util.Set;
import java.util.logging.Logger;

public class SkillsWidget extends ProtoWidget implements SelectPersonEventHandler {

    private static final Logger LOGGER = Logger.getLogger("SkillsWidget");

    private EventBus eventBus;

    @UiField
    TagBoxWidget interestedTagBoxWidget;

    @UiField
    TagBoxWidget learningTagBoxWidget;

    @UiField
    TagBoxWidget usingTagBoxWidget;

    @UiField
    TagBoxWidget usedTagBoxWidget;

    @Inject
    public SkillsWidget(SimpleEventBus eventBus) {
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

    interface Binder extends UiBinder<Widget, SkillsWidget> {
    }

    private void initListeners() {
        eventBus.addHandler(SelectPersonEvent.TYPE, this);
    }

    private static Binder uiBinder = GWT.create(Binder.class);

    @Override
    public void onSelectPerson(SelectPersonEvent selectPersonEvent) {
        SkillsService skillsService = GWT.create(SkillsService.class);
        skillsService.getInterestedInByHash(selectPersonEvent.getHash(), new MethodCallback<Set<Tag>>() {
            @Override
            public void onFailure(Method method, Throwable exception) {
                LOGGER.severe("Error getting interested skills: " + exception.getMessage());
            }

            @Override
            public void onSuccess(Method method, Set<Tag> response) {
                interestedTagBoxWidget.setTags(response);
            }
        });
        skillsService.getLearningInByHash(selectPersonEvent.getHash(), new MethodCallback<Set<Tag>>() {
            @Override
            public void onFailure(Method method, Throwable exception) {
                LOGGER.severe("Error getting learning skills: " + exception.getMessage());
            }

            @Override
            public void onSuccess(Method method, Set<Tag> response) {
                learningTagBoxWidget.setTags(response);
            }
        });
        skillsService.getUsingInByHash(selectPersonEvent.getHash(), new MethodCallback<Set<Tag>>() {
            @Override
            public void onFailure(Method method, Throwable exception) {
                LOGGER.severe("Error getting using skills: " + exception.getMessage());
            }

            @Override
            public void onSuccess(Method method, Set<Tag> response) {
                usingTagBoxWidget.setTags(response);
            }
        });
        skillsService.getUsedInByHash(selectPersonEvent.getHash(), new MethodCallback<Set<Tag>>() {
            @Override
            public void onFailure(Method method, Throwable exception) {
                LOGGER.severe("Error getting used skills: " + exception.getMessage());
            }

            @Override
            public void onSuccess(Method method, Set<Tag> response) {
                usedTagBoxWidget.setTags(response);
            }
        });
    }
}
