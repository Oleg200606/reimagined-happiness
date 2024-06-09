package net.shevtsov.elementalstones.block;

import net.shevtsov.elementalstones.ElementalStones;
import net.shevtsov.elementalstones.block.custom.UnderwaterBreathingBlock;
import net.shevtsov.elementalstones.block.custom.FreefallBlock;
import net.shevtsov.elementalstones.item.ModItems;
import net.shevtsov.elementalstones.item.ModCreativeTab;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ElementalStones.MOD_ID);

    public static final RegistryObject<Block> FIRESTONE_BLOCK = registerBlock("firestone_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3.0f, 3.0f)
                    .sound(SoundType.STONE)
                    .lightLevel((state) -> 15)), ModCreativeTab.ELST_TAB);

    public static final RegistryObject<Block> WATER_BREATHING_BLOCK = registerBlock("waterstone_block",
            () -> new UnderwaterBreathingBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3.0f, 3.0f)
                    .sound(SoundType.STONE)), ModCreativeTab.ELST_TAB);

    public static final RegistryObject<Block> EARTHSTONE_BLOCK = registerBlock("earthstone_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(50.0f, 1200.0f)
                    .sound(SoundType.STONE)), ModCreativeTab.ELST_TAB);

    public static final RegistryObject<Block> FREEFALL_BLOCK = registerBlock("airstone_block",
            () -> new FreefallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3.0f, 3.0f)
                    .sound(SoundType.STONE)), ModCreativeTab.ELST_TAB);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {

        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
