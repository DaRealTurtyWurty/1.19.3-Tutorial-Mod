package dev.turtywurty.tutorialmod.client.renderer;

import dev.turtywurty.tutorialmod.TutorialMod;
import dev.turtywurty.tutorialmod.client.models.ExampleEntityModel;
import dev.turtywurty.tutorialmod.entity.ExampleEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ExampleEntityRenderer extends MobRenderer<ExampleEntity, ExampleEntityModel<ExampleEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(TutorialMod.MODID,
            "textures/entity/example_entity.png");

    public ExampleEntityRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ExampleEntityModel<>(pContext.bakeLayer(ExampleEntityModel.LAYER_LOCATION)), 0.75f);
    }

    @Override
    public ResourceLocation getTextureLocation(ExampleEntity pEntity) {
        return TEXTURE;
    }
}
