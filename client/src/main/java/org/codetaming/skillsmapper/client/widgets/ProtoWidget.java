package org.codetaming.skillsmapper.client.widgets;

import com.google.gwt.user.client.ui.Composite;
import org.codetaming.skillsmapper.client.feature.CanDisable;

import java.util.logging.Logger;

public abstract class ProtoWidget extends Composite implements CanDisable {

    private static final Logger LOGGER = Logger.getLogger("ProtoWidget");

    protected boolean enabled = true;

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
