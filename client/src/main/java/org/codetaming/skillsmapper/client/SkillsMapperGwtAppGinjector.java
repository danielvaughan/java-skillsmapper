package org.codetaming.skillsmapper.client;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.web.bindery.event.shared.EventBus;

import org.codetaming.skillsmapper.client.auth0.AuthenticationClient;
import org.codetaming.skillsmapper.client.controllers.LoggingController;
import org.codetaming.skillsmapper.client.controllers.NavigationController;
import org.codetaming.skillsmapper.client.views.PeopleViewWidget;
import org.codetaming.skillsmapper.client.widgets.MainPanel;
import org.codetaming.skillsmapper.client.widgets.PeopleListWidget;
import org.codetaming.skillsmapper.client.widgets.ProfileDetailsWidget;
import org.codetaming.skillsmapper.client.widgets.SkillsWidget;
import org.fusesource.restygwt.client.Dispatcher;

import static org.codetaming.skillsmapper.client.places.SkillsMapperPlaceHistoryMapper.SkillsMapperPlaceTokenizers;

@GinModules(SkillsMapperGwtGinModule.class)
public interface SkillsMapperGwtAppGinjector extends Ginjector, SkillsMapperPlaceTokenizers {

    void inject(SkillsMapperGwt skillsMapperGwt);

    AuthenticationClient getAuthenticationClient();

    EventBus getEventBus();

    MainPanel getMainPanel();

    ProfileDetailsWidget getProfileDetailsWidget();

    PeopleViewWidget getPeopleViewWidget();

    PeopleListWidget getPeopleListWidget();

    SkillsWidget getSkillsWidget();

    LoggingController getLoggingController();

    NavigationController getNavigationController();

    Dispatcher getDispatcher();
}
