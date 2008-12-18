/*
    This file is part of RouteConverter.

    RouteConverter is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    RouteConverter is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Foobar; if not, write to the Free Software
    Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA

    Copyright (C) 2007 Christian Pesch. All Rights Reserved.
*/

package slash.navigation.converter.gui.renderer;

import slash.navigation.BaseRoute;
import slash.navigation.converter.gui.RouteConverter;

import javax.swing.*;
import java.awt.*;

/**
 * Renders the route labels of the route combo box.
 *
 * @author Christian Pesch
 */

public class RouteListCellRenderer extends DefaultListCellRenderer {
    private static final int MAXIMUM_ROUTE_NAME_LENGTH = 50;

    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        BaseRoute route = (BaseRoute) value;
        String text = "?";
        if (route != null) {
            if (route.getName() != null)
                text = route.getName();
            if(text.length() > MAXIMUM_ROUTE_NAME_LENGTH)
                text = text.substring(0, MAXIMUM_ROUTE_NAME_LENGTH) + "...";
            String characteristics = RouteConverter.BUNDLE.getString(route.getCharacteristics().name().toLowerCase() + "-characteristics");
            text += " (" + characteristics + ")";
        }
        label.setText(text);
        return label;
    }
}
