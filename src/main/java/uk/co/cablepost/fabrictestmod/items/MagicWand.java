package uk.co.cablepost.fabrictestmod.items;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.TntMinecartEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class MagicWand extends Item {

    public MagicWand(Settings settings) {
        super(settings);
    }

    protected final Vec3d getRotationVector(float pitch, float yaw) {
        float f = pitch * 0.017453292F;
        float g = -yaw * 0.017453292F;
        float h = MathHelper.cos(g);
        float i = MathHelper.sin(g);
        float j = MathHelper.cos(f);
        float k = MathHelper.sin(f);
        return new Vec3d((double)(i * j), (double)(-k), (double)(h * j));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        if (!world.isClient() ) {
            TntEntity tnt = EntityType.TNT.create(world);
            tnt.setFuse(100);
            tnt.setGlowing(true);
            tnt.setPos(playerEntity.getX() - 2, playerEntity.getY(), playerEntity.getZ() - 2);
            tnt.refreshPositionAndAngles(playerEntity.getX(), playerEntity.getY(), playerEntity.getZ(), playerEntity.yaw, 0.0F);
            tnt.setGlowing(true);
            Vec3d velVec = getRotationVector(playerEntity.pitch, playerEntity.headYaw).multiply(3d);
            tnt.addVelocity(velVec.x, velVec.y, velVec.z);
            world.spawnEntity(tnt);
        }
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}
