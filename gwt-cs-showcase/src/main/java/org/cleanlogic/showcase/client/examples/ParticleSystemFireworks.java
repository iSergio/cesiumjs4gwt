/*
 * Copyright 2017 iserge.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cleanlogic.showcase.client.examples;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.core.*;
import org.cesiumjs.cs.core.Math;
import org.cesiumjs.cs.core.options.ColorRandomOptions;
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.scene.emitters.SphereEmitter;
import org.cesiumjs.cs.scene.particle.Particle;
import org.cesiumjs.cs.scene.particle.ParticleBurst;
import org.cesiumjs.cs.scene.particle.ParticleSystem;
import org.cesiumjs.cs.scene.particle.options.ParticleBurstOptions;
import org.cesiumjs.cs.scene.particle.options.ParticleSystemOptions;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.showcase.client.basic.AbstractExample;
import org.cleanlogic.showcase.client.components.store.ShowcaseExampleStore;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class ParticleSystemFireworks extends AbstractExample {
    private Matrix4 emitterModelMatrixScratch = new Matrix4();
    private Cartesian3 emitterInitialLocation = new Cartesian3(0.0, 0.0, 100.0);
    private Matrix4 modelMatrix = Transforms.eastNorthUpToFixedFrame(Cartesian3.fromDegrees(-75.59777, 40.03883));

    private CanvasElement particleCanvas;

    private double minimumExplosionSize = 30.0;
    private double maximumExplosionSize = 100.0;
    private double particlePixelSize = 7.0;
    private double burstSize = 400.0;
    private double lifetime = 10.0;
    private double numberOfFireworks = 20.0;

    private double xMin = -100.0;
    private double xMax = 100.0;
    private double yMin = -80.0;
    private double yMax = 100.0;
    private double zMin = -50.0;
    private double zMax = 50.0;

    @Inject
    public ParticleSystemFireworks(ShowcaseExampleStore store) {
        super("Particle System Fireworks", "Particle system fireworks.", new String[]{"Showcase", "Cesium", "3d", "Viewer", "Particle"}, store);
    }

    @Override
    public void buildPanel() {
        ViewerPanel csVPanel = new ViewerPanel();

        csVPanel.getViewer().scene().debugShowFramesPerSecond = true;

        Math.setRandomNumberSeed(315);

        ColorRandomOptions[] colorRandomOptions = new ColorRandomOptions[4];
        for (int i = 0; i < 4; i++) {
            colorRandomOptions[i] = new ColorRandomOptions();
        }
        colorRandomOptions[0].minimumRed = 0.75f;
        colorRandomOptions[0].green = 0.0f;
        colorRandomOptions[0].minimumBlue = 0.8f;
        colorRandomOptions[0].alpha = 1.0f;
        colorRandomOptions[1].red = 0.0f;
        colorRandomOptions[1].minimumGreen = 0.75f;
        colorRandomOptions[1].minimumBlue = 0.8f;
        colorRandomOptions[1].alpha = 1.0f;
        colorRandomOptions[2].red = 0.0f;
        colorRandomOptions[2].green = 0.0f;
        colorRandomOptions[2].minimumBlue = 0.8f;
        colorRandomOptions[2].alpha = 1.0f;
        colorRandomOptions[3].minimumRed = 0.75f;
        colorRandomOptions[3].minimumGreen = 0.75f;
        colorRandomOptions[3].blue = 0.0f;
        colorRandomOptions[3].alpha = 1.0f;

        for (int i = 0; i < numberOfFireworks; ++i) {
            double x = Math.randomBetween(xMin, xMax);
            double y = Math.randomBetween(yMin, yMax);
            double z = Math.randomBetween(zMin, zMax);
            Cartesian3 offset = new Cartesian3(x, y, z);
            Color color = Color.fromRandom(colorRandomOptions[i % colorRandomOptions.length]);

            List<ParticleBurst> bursts = new ArrayList<>();
            for (int j = 0; j < 3; ++j) {
                ParticleBurstOptions particleBurstOptions = new ParticleBurstOptions();
                particleBurstOptions.time = Math.nextRandomNumber() * lifetime;
                particleBurstOptions.minimum = burstSize;
                particleBurstOptions.maximum = burstSize;
                bursts.add(new ParticleBurst(particleBurstOptions));
            }

            createFirework(csVPanel.getViewer().scene(), offset, color, bursts.toArray(new ParticleBurst[bursts.size()]));
        }

        org.cesiumjs.cs.scene.Camera camera = csVPanel.getViewer().scene().camera();
        Cartesian3 cameraOffset = new Cartesian3(-300.0, 0.0, 0.0);
        camera.lookAtTransform(modelMatrix, cameraOffset);
        camera.lookAtTransform(Matrix4.IDENTITY());

        Cartesian3 toFireworks = Cartesian3.subtract(emitterInitialLocation, cameraOffset, new Cartesian3());
        Cartesian3.normalize(toFireworks, toFireworks);
        double angle = Math.PI_OVER_TWO() - java.lang.Math.acos(Cartesian3.dot(toFireworks, Cartesian3.UNIT_Z()));
        camera.lookUp(angle);


        contentPanel.add(new HTML("<p></p>"));
        contentPanel.add(csVPanel);

        initWidget(contentPanel);
    }

    private CanvasElement getImage() {
        if (!Cesium.defined(particleCanvas)) {
            particleCanvas = RootPanel.get().getElement().getOwnerDocument().createCanvasElement();
            particleCanvas.setWidth(20);
            particleCanvas.setHeight(20);
            Context2d context2d = particleCanvas.getContext2d();
            context2d.beginPath();
            context2d.arc(8, 8, 8, 0, Math.TWO_PI(), true);
            context2d.closePath();
            context2d.setFillStyle("rgb(255, 255, 255)");
            context2d.fill();
            Cesium.log(particleCanvas);
        }
        return particleCanvas;
    }

    private void createFirework(Scene scene, Cartesian3 offset, Color color, ParticleBurst[] bursts) {
        Cartesian3 position = Cartesian3.add(emitterInitialLocation, offset, new Cartesian3());
        Matrix4 emitterModelMatrix = Matrix4.fromTranslation(position, emitterModelMatrixScratch);
        Matrix4 particleToWorld = Matrix4.multiply(modelMatrix, emitterModelMatrix, new Matrix4());
        final Matrix4 worldToParticle = Matrix4.inverseTransformation(particleToWorld, particleToWorld);

        final double size = Math.randomBetween(minimumExplosionSize, maximumExplosionSize);
        final Cartesian3 particlePositionScratch = new Cartesian3();

        ParticleSystem.ApplyForce force = new ParticleSystem.ApplyForce() {
            @Override
            public void function(Particle particle, double dt) {
                Cartesian3 position = Matrix4.multiplyByPoint(worldToParticle, particle.position, particlePositionScratch);
                if (Cartesian3.magnitudeSquared(position) >= size * size) {
                    Cartesian3.clone(Cartesian3.ZERO(), particle.velocity);
                }
            }
        };
        double normalSize = (size - minimumExplosionSize) / (maximumExplosionSize - minimumExplosionSize);
        double minLife = 0.3;
        double maxLife = 1.0;
        double life = normalSize * (maxLife - minLife) + minLife;

        ParticleSystemOptions particleSystemOptions = new ParticleSystemOptions();
        particleSystemOptions.image = getImage();
        particleSystemOptions.startColor = color;
        particleSystemOptions.endColor = color.withAlpha(0.0f);
        particleSystemOptions.life = life;
        particleSystemOptions.speed = 100.0;
        particleSystemOptions.width = particlePixelSize;
        particleSystemOptions.height = particlePixelSize;
        particleSystemOptions.rate = 0;
        particleSystemOptions.emitter = new SphereEmitter(0.1);
        particleSystemOptions.bursts = bursts;
        particleSystemOptions.lifeTime = lifetime;
        particleSystemOptions.forces = new ParticleSystem.ApplyForce[] {force};
        particleSystemOptions.modelMatrix = modelMatrix;
        particleSystemOptions.emitterModelMatrix = emitterModelMatrix;
        scene.primitives().add(new ParticleSystem(particleSystemOptions));
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "ParticleSysteFireworks.txt";
        return sourceCodeURLs;
    }
}