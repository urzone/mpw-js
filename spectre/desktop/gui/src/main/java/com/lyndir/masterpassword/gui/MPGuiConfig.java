//==============================================================================
// This file is part of Master Password.
// Copyright (c) 2011-2017, Maarten Billemont.
//
// Master Password is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Master Password is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You can find a copy of the GNU General Public License in the
// LICENSE file.  Alternatively, see <http://www.gnu.org/licenses/>.
//==============================================================================

package com.lyndir.masterpassword.gui;

import com.lyndir.lhunath.opal.system.util.ConversionUtils;
import com.lyndir.masterpassword.gui.util.State;
import com.lyndir.masterpassword.model.MPConfig;
import com.lyndir.masterpassword.model.MPModelConstants;


/**
 * @author lhunath, 2014-08-31
 */
@SuppressWarnings("CallToSystemGetenv")
public class MPGuiConfig extends MPConfig {

    public static MPGuiConfig get() {
        return get( MPGuiConfig.class );
    }

    Boolean checkForUpdates;
    Boolean stayResident;

    public boolean checkForUpdates() {
        return (checkForUpdates != null)? checkForUpdates:
                ConversionUtils.toBoolean( System.getenv( MPModelConstants.env_checkUpdates ) ).orElse( true );
    }

    public void setCheckForUpdates(final boolean checkForUpdates) {
        this.checkForUpdates = checkForUpdates;
        State.get().updateCheck();
        setChanged();
    }

    public boolean stayResident() {
        return (stayResident != null)? stayResident: false;
    }

    public void setStayResident(final boolean stayResident) {
        this.stayResident = stayResident;
        setChanged();
    }
}
