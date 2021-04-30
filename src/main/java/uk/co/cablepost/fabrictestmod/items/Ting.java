package uk.co.cablepost.fabrictestmod.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Ting extends Item {

    public Ting(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        playerEntity.playSound(SoundEvents.AMBIENT_CAVE, 1.0F, 2.0F);
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}
