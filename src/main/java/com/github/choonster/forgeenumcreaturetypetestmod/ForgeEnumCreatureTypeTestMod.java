package com.github.choonster.forgeenumcreaturetypetestmod;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.init.Biomes;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

@Mod(modid = ForgeEnumCreatureTypeTestMod.MODID, name = ForgeEnumCreatureTypeTestMod.NAME, acceptedMinecraftVersions = "[1.11.2]")
public class ForgeEnumCreatureTypeTestMod {
	static final String MODID = "forgeenumcreaturetypetestmod";
	static final String NAME = "Forge EnumCreatureType Test Mod";

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		// Create an EnumCreatureType
		final EnumCreatureType creatureTypeHorse = EnumHelper.addCreatureType(MODID + ":horse", AbstractHorse.class, 20, Material.AIR, true, true);

		// Try to add a spawn using it, causing an UnsupportedOperationException to be thrown by AbstractList#add because Biome#getSpawnableList returned an EmptyList
		EntityRegistry.addSpawn(EntityHorse.class, 1, 1, 20, creatureTypeHorse, Biomes.PLAINS);
	}
}
