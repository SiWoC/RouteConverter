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

package slash.navigation;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * Encapsulates a {@link BaseNavigationFormat} and a {@link List} of {@link BaseRoute}s.
 *
 * @author Christian Pesch
 */

public class FormatAndRoutes<F extends BaseNavigationFormat,R extends BaseRoute,P extends BaseNavigationPosition> {
    private NavigationFormat<R> format;
    private List<BaseRoute<P,F>> routes;

    public FormatAndRoutes(NavigationFormat<R> format, List<BaseRoute<P,F>> routes) {
        this.format = format;
        this.routes = new ArrayList<BaseRoute<P,F>>(routes);
    }

    public FormatAndRoutes(NavigationFormat<R> format, BaseRoute<P,F> route) {
        this(format, Arrays.asList(route));
    }

    public NavigationFormat getFormat() {
        return format;
    }

    public BaseRoute<P,F> getRoute() {
       return getRoutes().size() > 0 ? getRoutes().get(0) : null;
    }

    public List<BaseRoute<P,F>> getRoutes() {
        return routes;
    }
}
