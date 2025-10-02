package net.treerodent.blockfish.entity.animation;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

public class FlockfishAnimations {

    public static final Animation IDLE = Animation.Builder.create(1.4583433f).looping()
            .addBoneAnimation("back",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, 2.5f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(1f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(1.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC))).build();
    public static final Animation FLOP = Animation.Builder.create(0.7083434f).looping()
            .addBoneAnimation("flockfish",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, -90f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("back",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(0.25f, AnimationHelper.createRotationalVector(0f, -10f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(0.75f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC)))
            .addBoneAnimation("front",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, -10f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(0.75f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC))).build();
}
