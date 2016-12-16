package org.codetaming.skillsmapper.client.presenters;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;

import org.codetaming.skillsmapper.client.places.PeoplePlace;
import org.codetaming.skillsmapper.client.places.ProfilePlace;

import java.util.logging.Logger;

public class SkillsMapperActivityMapper implements ActivityMapper {

    private static final Logger LOGGER = Logger.getLogger(SkillsMapperActivityMapper.class.getName());

    @Inject
    ActivityFactory factory;

    @Override
    public Activity getActivity(Place place) {
        LOGGER.info("getActivity: " + place.toString());
        if (place instanceof PeoplePlace) {
            return factory.createPeoplePresenter((PeoplePlace) place);
        }
        if (place instanceof ProfilePlace) {
            return factory.createProfilePresenter((ProfilePlace) place);
        }
        return null;
    }

    public interface ActivityFactory {
        PeoplePresenter createPeoplePresenter(PeoplePlace place);

        ProfilePresenter createProfilePresenter(ProfilePlace place);
    }
}
