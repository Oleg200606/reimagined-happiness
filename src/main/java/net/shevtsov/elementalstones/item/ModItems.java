package net.shevtsov.elementalstones.item;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.shevtsov.elementalstones.ElementalStones;
import net.shevtsov.elementalstones.item.ModCreativeTab;
public class ModItems {

    public static final DeferredRegister <Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ElementalStones.MOD_ID);

    public static void register (IEventBus eventBus){
        ITEMS.register(eventBus);
    }

    public static final RegistryObject<Item> FIRE_STONE = ITEMS.register("fire_stone",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.ELST_TAB)));

    public static final RegistryObject<Item> WATER_STONE = ITEMS.register("water_stone",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.ELST_TAB)));

    public static final RegistryObject<Item> AIR_STONE = ITEMS.register("air_stone",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.ELST_TAB)));

    public static final RegistryObject<Item> EARTH_STONE = ITEMS.register("earth_stone",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.ELST_TAB)));

}
