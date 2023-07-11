package earth.terrarium.adastra.common.items;

import earth.terrarium.adastra.api.ti69.client.Ti69AppApi;
import earth.terrarium.adastra.client.ti69.apps.SensorApp;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;

public class Ti69Item extends Item {
    public static ResourceLocation selectedApp = SensorApp.ID;

    public Ti69Item(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        if (level.isClientSide()) {
            List<ResourceLocation> apps = new ArrayList<>(Ti69AppApi.API.apps().keySet());
            apps.sort(ResourceLocation::compareTo);
            int index = apps.indexOf(selectedApp);
            if (index == -1) {
                index = 0;
            } else {
                index = (index + 1) % apps.size();
            }
            selectedApp = apps.get(index);
        }
        return super.use(level, player, usedHand);
    }
}