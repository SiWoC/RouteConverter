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

package slash.navigation.tcx;

import slash.navigation.tcx.binding2.TrainingCenterDatabaseT;

import java.util.ArrayList;

/**
 * A list of Training Center Database (.tcx) routes.
 *
 * @author Christian Pesch
 */

public class TcxRouteList extends ArrayList<TcxRoute> {
    private TrainingCenterDatabaseT trainingCenterDatabaseT;

    public TcxRouteList(TrainingCenterDatabaseT trainingCenterDatabaseT) {
        this.trainingCenterDatabaseT = trainingCenterDatabaseT;
    }

    public TrainingCenterDatabaseT getTrainingCenterDatabaseT() {
        return trainingCenterDatabaseT;
    }
}
