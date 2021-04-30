package uk.co.cablepost.fabrictestmod.toolMaterials;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class MagicWandMaterial implements ToolMaterial {
    @Override
    public int getDurability() {
        return 420;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 0;
    }

    @Override
    public float getAttackDamage() {
        return 0;
    }

    @Override
    public int getMiningLevel() {
        return 0;
    }

    @Override
    public int getEnchantability() {
        return 0;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
}
