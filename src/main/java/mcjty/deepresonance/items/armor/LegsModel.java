package mcjty.deepresonance.items.armor;

// Date: 24/10/2015 20:14:30
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX


import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class LegsModel extends ModelBiped {

    public static LegsModel legsModel = new LegsModel();

    //fields
    ModelRenderer leftfront;
    ModelRenderer rightfront;
    ModelRenderer leftback;
    ModelRenderer rightback;
    ModelRenderer leftside1;
    ModelRenderer rightside1;
    ModelRenderer leftside2;
    ModelRenderer rightside2;

    public LegsModel() {
        textureWidth = 64;
        textureHeight = 32;

        leftfront = new ModelRenderer(this, 0, 0);
        leftfront.addBox(0F, 0F, 0F, 4, 8, 1);
        leftfront.setRotationPoint(0F, 12F, -3F);
        leftfront.setTextureSize(64, 32);
        leftfront.mirror = true;
        setRotation(leftfront, 0F, 0F, 0F);
        rightfront = new ModelRenderer(this, 0, 0);
        rightfront.addBox(0F, 0F, 0F, 4, 8, 1);
        rightfront.setRotationPoint(-4F, 12F, -3F);
        rightfront.setTextureSize(64, 32);
        rightfront.mirror = true;
        setRotation(rightfront, 0F, 0F, 0F);
        leftback = new ModelRenderer(this, 0, 0);
        leftback.addBox(0F, 0F, 0F, 4, 8, 1);
        leftback.setRotationPoint(0F, 12F, 2F);
        leftback.setTextureSize(64, 32);
        leftback.mirror = true;
        setRotation(leftback, 0F, 0F, 0F);
        rightback = new ModelRenderer(this, 0, 0);
        rightback.addBox(0F, 0F, 0F, 4, 8, 1);
        rightback.setRotationPoint(-4F, 12F, 2F);
        rightback.setTextureSize(64, 32);
        rightback.mirror = true;
        setRotation(rightback, 0F, 0F, 0F);
        leftside1 = new ModelRenderer(this, 0, 9);
        leftside1.addBox(0F, 0F, 0F, 1, 8, 4);
        leftside1.setRotationPoint(4F, 12F, -2F);
        leftside1.setTextureSize(64, 32);
        leftside1.mirror = true;
        setRotation(leftside1, 0F, 0F, 0F);
        rightside1 = new ModelRenderer(this, 0, 9);
        rightside1.addBox(0F, 0F, 0F, 1, 8, 4);
        rightside1.setRotationPoint(0F, 12F, -2F);
        rightside1.setTextureSize(64, 32);
        rightside1.mirror = true;
        setRotation(rightside1, 0F, 0F, 0F);
        leftside2 = new ModelRenderer(this, 0, 9);
        leftside2.addBox(0F, 0F, 0F, 1, 8, 4);
        leftside2.setRotationPoint(-1F, 12F, -2F);
        leftside2.setTextureSize(64, 32);
        leftside2.mirror = true;
        setRotation(leftside2, 0F, 0F, 0F);
        rightside2 = new ModelRenderer(this, 0, 9);
        rightside2.addBox(0F, 0F, 0F, 1, 8, 4);
        rightside2.setRotationPoint(-5F, 12F, -2F);
        rightside2.setTextureSize(64, 32);
        rightside2.mirror = true;
        setRotation(rightside2, 0F, 0F, 0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float scale) {
        super.render(entity, f, f1, f2, f3, f4, scale);
        setRotationAngles(entity, f, f1, f2, f3, f4, scale);

        leftfront.render(scale);
        rightfront.render(scale);
        leftback.render(scale);
        rightback.render(scale);
        leftside1.render(scale);
        rightside1.render(scale);
        leftside2.render(scale);
        rightside2.render(scale);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);

        copyAngles(bipedLeftLeg, leftfront);
        copyAngles(bipedLeftLeg, leftback);
        copyAngles(bipedLeftLeg, leftside1);
        copyAngles(bipedLeftLeg, leftside2);
        copyAngles(bipedRightLeg, rightfront);
        copyAngles(bipedRightLeg, rightback);
        copyAngles(bipedRightLeg, rightside1);
        copyAngles(bipedRightLeg, rightside2);
    }

    public static void copyAngles(ModelRenderer source, ModelRenderer dest) {
//        dest.rotateAngleX = source.rotateAngleX;
//        dest.rotateAngleY = source.rotateAngleY;
//        dest.rotateAngleZ = source.rotateAngleZ;
    }

}