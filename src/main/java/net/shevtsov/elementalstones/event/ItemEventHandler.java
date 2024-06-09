package net.shevtsov.elementalstones.event;

import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.item.ItemEvent;
import net.minecraftforge.event.level.ExplosionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.shevtsov.elementalstones.ElementalStones;
import net.shevtsov.elementalstones.item.ModItems;

@Mod.EventBusSubscriber(modid = ElementalStones.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ItemEventHandler {

    @SubscribeEvent
    public static void onExplosionDetonate(ExplosionEvent.Detonate event) {
        // Получаем список всех предметов, находящихся в зоне взрыва
        for (ItemEntity itemEntity : event.getAffectedEntities().stream()
                .filter(e -> e instanceof ItemEntity)
                .map(e -> (ItemEntity) e)
                .toList()) {
            ItemStack itemStack = itemEntity.getItem();
            // Проверяем, является ли предмет одним из наших
            if (itemStack.is(ModItems.FIRE_STONE.get()) ||
                itemStack.is(ModItems.WATER_STONE.get()) ||
                itemStack.is(ModItems.AIR_STONE.get()) ||
                itemStack.is(ModItems.EARTH_STONE.get())) {
                // Удаляем предмет из списка затронутых взрывом
                event.getAffectedEntities().remove(itemEntity);
            }
        }
    }
}
