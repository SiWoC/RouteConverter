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
    along with RouteConverter; if not, write to the Free Software
    Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA

    Copyright (C) 2007 Christian Pesch. All Rights Reserved.
*/

package slash.navigation.copilot;

import org.junit.Test;
import slash.navigation.base.*;
import slash.navigation.gpx.GpxUtil;
import slash.navigation.gpx.binding10.Gpx;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static slash.common.TestCase.assertDoubleEquals;
import static slash.navigation.base.NavigationTestCase.ROUTE_PATH;
import static slash.navigation.base.NavigationTestCase.SAMPLE_PATH;
import static slash.navigation.base.ReadWriteBase.readWriteRoundtrip;

public class CoPilot10FormatTest {
    private final CoPilot10Format format = new CoPilot10Format();

    @Test
    public void testRead() throws IOException {
        readWriteRoundtrip("../" + SAMPLE_PATH + "copilot-10-sample-file-pretty.trp");

        /*
            Map<String,String> map = new HashMap<>();


            map.put("Longitude", "11753270");
        map.put("Latitude", "47688350");

        Wgs84Position position1 = format.parsePosition(map);
        assertNotNull(position1);
        assertDoubleEquals(11.75327, position1.getLongitude());
        assertDoubleEquals(47.68835, position1.getLatitude());
        assertNull(position1.getElevation());
        assertNull(position1.getTime());
        assertNull(position1.getDescription());

        map.put("City", "Innsbruck");
        map.put("County","Tirol");

        Wgs84Position position2 = format.parsePosition(map);
        assertNotNull(position2);
        assertEquals("Innsbruck, Tirol", position2.getDescription());

        map.put("State","A");

        Wgs84Position position3 = format.parsePosition(map);
        assertNotNull(position3);
        assertEquals("A Innsbruck, Tirol", position3.getDescription());

        map.put("Address","39 Gumppstrasse");
        map.put("Zip","6020");

        Wgs84Position position4 = format.parsePosition(map);
        assertNotNull(position4);
        assertEquals("A-6020 Innsbruck, Tirol, 39 Gumppstrasse", position4.getDescription());

         */
    }

}
