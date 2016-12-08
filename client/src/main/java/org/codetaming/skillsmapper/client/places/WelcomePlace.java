package org.codetaming.skillsmapper.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class WelcomePlace extends Place {

	@Prefix("")
	public static class Tokenizer implements PlaceTokenizer<WelcomePlace> {
		@Override
		public WelcomePlace getPlace(String token) {
			return new WelcomePlace();
		}
		@Override
		public String getToken(WelcomePlace place) {
			return "";
		}
	}
}
