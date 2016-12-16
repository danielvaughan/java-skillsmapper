package org.codetaming.skillsmapper.client.presenters;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;

import org.codetaming.skillsmapper.client.places.PeoplePlace;
import org.codetaming.skillsmapper.client.places.ProfilePlace;

public class SkillsMapperActivityMapper implements ActivityMapper {

    @Inject
    ActivityFactory factory;

    @Override
    public Activity getActivity(Place place) {
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
