package kng.ruben.corefunctions.listener;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import net.kyori.adventure.text.Component;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class AsyncPlayerChatListener implements Listener {

    private final Cache<UUID, String> lastMessageCache = CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build();

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        var player = event.getPlayer();
        var uuid = player.getUniqueId();

        if (lastMessageCache.asMap().containsKey(uuid)) {
            var lastMessage = lastMessageCache.getIfPresent(uuid);
            double distance = StringUtils.getJaroWinklerDistance(event.getMessage(), lastMessage);
            if (distance >= 0.75) {
                player.sendMessage(Component.text("§cYour message is too similar to your last one."));
                event.setCancelled(true);
                return;
            }
        }
        lastMessageCache.put(uuid, event.getMessage());
    }


}
