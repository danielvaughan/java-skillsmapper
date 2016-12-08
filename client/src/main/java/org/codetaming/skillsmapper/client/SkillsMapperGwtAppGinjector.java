package org.codetaming.skillsmapper.client;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

import org.codetaming.skillsmapper.client.controllers.LoggingController;
import org.codetaming.skillsmapper.client.views.PeopleViewWidget;
import org.codetaming.skillsmapper.client.widgets.PeopleListWidget;
import org.codetaming.skillsmapper.client.widgets.ProfileDetailsWidget;
import org.codetaming.skillsmapper.client.widgets.SkillsWidget;

import static org.codetaming.skillsmapper.client.places.SkillsMapperPlaceHistoryMapper.SkillsMapperPlaceTokenizers;

@GinModules(SkillsMapperGwtGinModule.class)
public interface SkillsMapperGwtAppGinjector extends Ginjector, SkillsMapperPlaceTokenizers {

    void inject(SkillsMapperGwt skillsMapperGwt);

    SimpleEventBus getEventBus();

    MainPanel getMainPanel();

    ProfileDetailsWidget getProfileDetailsWidget();

    PeopleViewWidget getPeopleViewWidget();

    PeopleListWidget getPeopleListWidget();

    SkillsWidget getSkillsWidget();

    LoggingController getLoggingController();
}
