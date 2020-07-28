/*
 * EpicGuard is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * EpicGuard is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package me.ishift.epicguard.velocity.util;

import com.velocitypowered.api.command.CommandSource;
import me.ishift.epicguard.core.util.ChatUtils;
import net.kyori.text.TextComponent;

public class VelocityUtils {
    public static TextComponent getTextComponent(String string) {
        return TextComponent.of(ChatUtils.coloredLegacy(string));
    }

    public static void sendMessage(CommandSource source, String message) {
        source.sendMessage(getTextComponent(message));
    }
}
