package net.womp.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.NoRenderParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.NotNull;
import reascer.wom.particle.WOMParticles;
import yesman.epicfight.particle.HitParticleType;


public class RandomSharpCutParticle extends NoRenderParticle {


    protected RandomSharpCutParticle(ClientLevel world, double x, double y, double z) {
        super(world, x, y, z);

        this.level.addParticle(randomSlashHitParticleTYPE(), this.x, this.y, this.z, 0.0f, 0f ,0f);

    }

    public static HitParticleType randomSlashHitParticleTYPE(){
        int randomInt = (int)(Math.random() * (double)4.0F);
        HitParticleType RandomHitParticle;
        switch (randomInt) {
            case 0 -> RandomHitParticle = WOMParticles.SHARPCUT_SLASH.get();
            case 1 -> RandomHitParticle = WOMParticles.SHARPCUT_LEFT_SLASH.get();
            case 2 -> RandomHitParticle = WOMParticles.SHARPCUT_RIGHT_SLASH.get();
            case 3 -> RandomHitParticle = WOMParticles.SHARPCUT_ANGLED_UP_RIGHT_SLASH.get();
            default -> RandomHitParticle = WOMParticles.SHARPCUT_ANGLED_DOWN_LEFT_SLASH.get();
        }
        return RandomHitParticle;
    }


    public static class Provider implements ParticleProvider<SimpleParticleType> {
        public Particle createParticle(@NotNull SimpleParticleType typeIn, @NotNull ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            return new RandomSharpCutParticle(worldIn, x, y, z);
        }
    }
}
