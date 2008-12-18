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

package slash.navigation.tour;

import slash.navigation.NavigationFileParser;
import slash.navigation.ReadWriteBase;

import java.io.IOException;

public class TourReadWriteRoundtripTest extends ReadWriteBase {
    private void checkUnprocessedValue(TourPosition position, String name, String value) {
        assertNotNull(position);
        assertEquals(value, position.get(name));
    }

    public void testTourReadWriteRoundtrip() throws IOException {
        readWriteRoundtrip(TEST_PATH + "from.tour", new NavigationFileParserCallback() {
            public void test(NavigationFileParser source, NavigationFileParser target) {
                TourRoute sourceRoute = (TourRoute) source.getAllRoutes().get(0);
                checkUnprocessedValue(sourceRoute.getPositions().get(1), TourFormat.ASSEMBLY, "FalkNavigator");
                checkUnprocessedValue(sourceRoute.getPositions().get(1), TourFormat.CLASS, "FMI.FalkNavigator.DestinationFCGPOI");
                checkUnprocessedValue(sourceRoute.getPositions().get(1), TourFormat.VISITED, "1");
                checkUnprocessedValue(sourceRoute.getPositions().get(1), "PoiId", "46120");
                checkUnprocessedValue(sourceRoute.getPositions().get(1), "AreaId", "1001");
                TourRoute targetRoute = (TourRoute) target.getAllRoutes().get(0);
                checkUnprocessedValue(targetRoute.getPositions().get(1), TourFormat.ASSEMBLY, "FalkNavigator");
                checkUnprocessedValue(targetRoute.getPositions().get(1), TourFormat.CLASS, "FMI.FalkNavigator.DestinationFCGPOI");
                checkUnprocessedValue(targetRoute.getPositions().get(1), TourFormat.VISITED, "1");
                checkUnprocessedValue(targetRoute.getPositions().get(1), "PoiId", "46120");
                checkUnprocessedValue(targetRoute.getPositions().get(1), "AreaId", "1001");
            }
        });
    }
}
