package net.shevtsov.elementalstones.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTab {
    public static final CreativeModeTab ELST_TAB = new CreativeModeTab("Elemental Stones Tab") {
    @Override
        public ItemStack makeIcon() {
        return new ItemStack(ModItems.FIRE_STONE.get());
        }

    };
}
