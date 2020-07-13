package me.ishift.epicguard.core.check.impl;

import me.ishift.epicguard.core.EpicGuard;
import me.ishift.epicguard.core.check.Check;
import me.ishift.epicguard.core.check.CheckMode;

import java.util.List;

public class GeographicalCheck extends Check {
    public GeographicalCheck(EpicGuard epicGuard) {
        super(epicGuard);
    }

    @Override
    public boolean check(String address, String nickname) {
        CheckMode mode = CheckMode.valueOf(this.getConfig().countryCheck);

        switch (mode) {
            case NEVER:
                return false;
            case ALWAYS:
                return this.geoCheck(address);
            case ATTACK:
                if (this.getEpicGuard().isAttack()) {
                    return this.geoCheck(address);
                }
        }
        return false;
    }

    private boolean geoCheck(String address) {
        String country = this.getEpicGuard().getGeoManager().getCountryCode(address);
        String city = this.getEpicGuard().getGeoManager().getCity(address);

        if (this.getConfig().cityBlacklist.contains(city)) {
            return true;
        }

        if (this.getConfig().countryCheckType.equals("WHITELIST")) {
            return !this.getConfig().countryCheckValues.contains(country);
        } else {
            return this.getConfig().countryCheckValues.contains(country);
        }
    }

    @Override
    public List<String> getKickMessage() {
        return this.getEpicGuard().getMessages().kickMessageGeo;
    }

    @Override
    public boolean blacklistUser() {
        return true;
    }
}
