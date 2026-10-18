package dev.sphinx.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Entrypoint. The menu itself is installed by {@link dev.sphinx.client.mixin.MinecraftClientMixin}. */
public final class SphinxClient implements ClientModInitializer {
    public static final String MOD_ID = "sphinxclient";
    public static final Logger LOGGER = LoggerFactory.getLogger("SphinxClient");

    @Override
    public void onInitializeClient() {
        LOGGER.info("Sphinx Client {} initialised", version());
    }

    /** Real version from fabric.mod.json (set by mod_version in gradle.properties). */
    public static String version() {
        return FabricLoader.getInstance().getModContainer(MOD_ID)
                .map(c -> c.getMetadata().getVersion().getFriendlyString())
                .orElse("dev");
    }
}
