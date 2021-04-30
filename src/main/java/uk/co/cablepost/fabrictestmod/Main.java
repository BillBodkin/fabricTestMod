package uk.co.cablepost.fabrictestmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import uk.co.cablepost.fabrictestmod.items.MagicWand;
import uk.co.cablepost.fabrictestmod.items.Ting;

import java.util.HashMap;
import java.util.Map;

public class Main implements ModInitializer {
	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
		new Identifier("fabrictestmod", "stuff"),
		() -> new ItemStack(Blocks.BASALT)
	);

	public static final Map<String, Item> items = new HashMap<String, Item>()
	{{
		put("ting", new Ting(new FabricItemSettings().group(ITEM_GROUP)));
		put("magic_wand", new MagicWand(new FabricItemSettings().group(ITEM_GROUP)));
	}};

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Bod Is POG!");

		for (Map.Entry<String, Item> item : items.entrySet()) {
			Registry.register(Registry.ITEM, new Identifier("fabrictestmod", item.getKey()), item.getValue());
		}
	}
}
