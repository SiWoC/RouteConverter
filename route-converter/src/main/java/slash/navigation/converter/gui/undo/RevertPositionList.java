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

package slash.navigation.converter.gui.undo;

import slash.navigation.converter.gui.models.PositionsModel;

import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoableEdit;

/**
 * Acts as a {@link UndoableEdit} for reverting all positions of a {@link PositionsModel}.
 *
 * @author Christian Pesch
 */

class RevertPositionList extends AbstractUndoableEdit {
    private final UndoPositionsModel positionsModel;

    public RevertPositionList(UndoPositionsModel positionsModel) {
        this.positionsModel = positionsModel;
    }

    public String getUndoPresentationName() {
        return "revert-all-positionlist-undo";
    }

    public String getRedoPresentationName() {
        return "revert-all-positionlist-redo";
    }

    public void undo() throws CannotUndoException {
        super.undo();
        positionsModel.revert(false);
    }

    public void redo() throws CannotRedoException {
        super.redo();
        positionsModel.revert(false);
    }
}
