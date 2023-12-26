package earth.terrarium.adastra.client.forge;

import earth.terrarium.adastra.client.ClientPlatformUtils;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.HashMap;
import java.util.Map;

public class ClientPlatformUtilsImpl {
    public static final Map<Item, ArmorRenderer> ARMOR_RENDERERS = new HashMap<>();

    public static BakedModel getModel(ModelManager dispatcher, ResourceLocation id) {
        return dispatcher.getModel(id);
    }

    public static void registerArmor(ResourceLocation texture, ModelLayerLocation layer, ClientPlatformUtils.ArmorFactory factory, Item... items) {
        for (Item item : items) {
            ARMOR_RENDERERS.put(item, new ArmorRenderer(texture, layer, factory));
        }
    }

    public record ArmorRenderer(ResourceLocation texture, ModelLayerLocation layer,
                                ClientPlatformUtils.ArmorFactory factory) {}
}