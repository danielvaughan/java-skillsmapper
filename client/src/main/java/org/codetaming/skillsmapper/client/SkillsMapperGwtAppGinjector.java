package org.codetaming.skillsmapper.client;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

import org.codetaming.skillsmapper.client.controllers.LoggingController;
import org.codetaming.skillsmapper.client.views.PeopleViewWidget;
import org.codetaming.skillsmapper.client.widgets.PeopleListWidget;
import org.codetaming.skillsmapper.client.widgets.ProfileDetailsWidget;
import org.codetaming.skillsmapper.client.widgets.SkillsWidget;

@GinModules(SkillsMapperGwtGinModule.class)
public interface SkillsMapperGwtAppGinjector extends Ginjector {

    SimpleEventBus getEventBus();

    MainPanel getMainPanel();

    ProfileDetailsWidget getProfileDetailsWidget();

    PeopleViewWidget getPeopleViewWidget();

    PeopleListWidget getPeopleListWidget();

    SkillsWidget getSkillsWidget();

    LoggingController getLoggingController();
}
