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

package org.cleanlogic.cesiumjs4gwt.showcase.examples;

import javax.inject.Inject;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.collections.TimeIntervalCollection;
import org.cesiumjs.cs.core.Cartesian2;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.Ellipsoid;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.core.JulianDate;
import org.cesiumjs.cs.core.Math;
import org.cesiumjs.cs.core.Matrix3;
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.core.Quaternion;
import org.cesiumjs.cs.core.TimeInterval;
import org.cesiumjs.cs.core.Transforms;
import org.cesiumjs.cs.core.TranslationRotationScale;
import org.cesiumjs.cs.core.enums.ClockRange;
import org.cesiumjs.cs.core.options.TimeIntervalOptions;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.graphics.ModelGraphics;
import org.cesiumjs.cs.datasources.graphics.options.ModelGraphicsOptions;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.ConstantPositionProperty;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.datasources.properties.Property;
import org.cesiumjs.cs.datasources.properties.SampledPositionProperty;
import org.cesiumjs.cs.datasources.properties.VelocityOrientationProperty;
import org.cesiumjs.cs.js.JsDate;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.scene.emitters.BoxEmitter;
import org.cesiumjs.cs.scene.emitters.CircleEmitter;
import org.cesiumjs.cs.scene.emitters.ConeEmitter;
import org.cesiumjs.cs.scene.emitters.SphereEmitter;
import org.cesiumjs.cs.scene.particle.Particle;
import org.cesiumjs.cs.scene.particle.ParticleBurst;
import org.cesiumjs.cs.scene.particle.options.ParticleSystemOptions;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.slider.Slider;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.slider.SliderEvent;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.slider.SliderListener;

/**
 * @author Serge Silaev aka iSergio
 */
public class ParticleSystem extends AbstractExample {
  private ViewModel viewModel = new ViewModel();

  private Slider rateSlider;
  private TextBox rateTBox;

  private Slider sizeSlider;
  private TextBox sizeTBox;

  private Slider minLifeSlider;
  private TextBox minLifeTBox;

  private Slider maxLifeSlider;
  private TextBox maxLifeTBox;

  private Slider minSpeedSlider;
  private TextBox minSpeedTBox;

  private Slider maxSpeedSlider;
  private TextBox maxSpeedTBox;

  private Slider startScaleSlider;
  private TextBox startScaleTBox;

  private Slider endScaleSlider;
  private TextBox endScaleTBox;

  private Slider gravitySlider;
  private TextBox gravityTBox;

  private TextBox translationXTBox;
  private TextBox translationYTBox;
  private TextBox translationZTBox;

  private TextBox rotationHTBox;
  private TextBox rotationPTBox;
  private TextBox rotationRTBox;

  private CheckBox spinCBox;
  private CheckBox flyCBox;
  private CheckBox showCBox;

  private SampledPositionProperty circularPosition;
  private Cartesian3 staticPosition;

  // Set bounds of our simulation time
  private JulianDate start = JulianDate.fromDate(new JsDate(2015, 2, 25, 16));
  private JulianDate stop = JulianDate.addSeconds(start, 360, new JulianDate());

  private Cartesian3 entityPosition = new Cartesian3();
  private Quaternion entityOrientation = new Quaternion();
  private Matrix3 rotationMatrix = new Matrix3();
  private Matrix4 modelMatrix = new Matrix4();

  private Matrix4 emitterModelMatrix = new Matrix4();
  private Cartesian3 translation = new Cartesian3();
  private Quaternion rotation = new Quaternion();
  private org.cesiumjs.cs.core.HeadingPitchRoll hpr = new org.cesiumjs.cs.core.HeadingPitchRoll();
  private TranslationRotationScale trs = new TranslationRotationScale();

  private Cartesian3 gravityScratch = new Cartesian3();

  private Entity entity;
  private org.cesiumjs.cs.scene.particle.ParticleSystem particleSystem;

  @Inject
  public ParticleSystem(ShowcaseExampleStore store) {
    super("Particle System", "Particle systems.", new String[] { "Showcase", "Cesium", "3d", "Viewer", "Particle" },
        store);
  }

  @Override
  public void buildPanel() {
    ViewerPanel csVPanel = new ViewerPanel();

    // Set the random number seed for consistent results.
    Math.setRandomNumberSeed(3);

    // Make sure viewer is at the desired time.
    csVPanel.getViewer().clock().startTime = start.clone();
    csVPanel.getViewer().clock().stopTime = stop.clone();
    csVPanel.getViewer().clock().currentTime = start.clone();
    csVPanel.getViewer().clock().clockRange = ClockRange.LOOP_STOP(); // Loop at the end
    csVPanel.getViewer().clock().multiplier = 1;
    csVPanel.getViewer().clock().shouldAnimate = true;

    // Set timeline to simulation bounds
    csVPanel.getViewer().timeline().zoomTo(start, stop);

    // Compute the entity position property.
    circularPosition = computeCirclularFlight(-112.110693, 36.0994841, 0.03);
    staticPosition = Cartesian3.fromDegrees(-112.110693, 36.0994841, 1000);

    TimeIntervalOptions timeIntervalOptions = new TimeIntervalOptions();
    timeIntervalOptions.start = start;
    timeIntervalOptions.stop = stop;

    ModelGraphicsOptions modelGraphicsOptions = new ModelGraphicsOptions();
    modelGraphicsOptions.uri = new ConstantProperty<>(
        GWT.getModuleBaseURL() + "SampleData/models/CesiumAir/Cesium_Air.gltf");
    modelGraphicsOptions.minimumPixelSize = new ConstantProperty<>(64);

    EntityOptions entityOptions = new EntityOptions();
    entityOptions.availability = new TimeIntervalCollection(
        new TimeInterval[] { new TimeInterval(timeIntervalOptions) });
    entityOptions.model = new ModelGraphics(modelGraphicsOptions);
    entityOptions.position = new ConstantPositionProperty(staticPosition);
    entity = csVPanel.getViewer().entities().add(entityOptions);
    csVPanel.getViewer().trackedEntity = entity;

    ParticleSystemOptions particleSystemOptions = new ParticleSystemOptions();
    particleSystemOptions.image = GWT.getModuleBaseURL() + "SampleData/fire.png";

    particleSystemOptions.startColor = Color.RED().withAlpha(0.7f);
    particleSystemOptions.endColor = Color.YELLOW().withAlpha(0.3f);

    particleSystemOptions.startScale = viewModel.startScale;
    particleSystemOptions.endScale = viewModel.endScale;

    particleSystemOptions.minimumParticleLife = viewModel.minimumParticleLife;
    particleSystemOptions.maximumParticleLife = viewModel.maximumParticleLife;

    particleSystemOptions.minimumSpeed = viewModel.minimumSpeed;
    particleSystemOptions.maximumSpeed = viewModel.maximumSpeed;

    particleSystemOptions.imageSize = new Cartesian2(viewModel.particleSize, viewModel.particleSize);

    particleSystemOptions.emissionRate = viewModel.emissionRate;

    particleSystemOptions.bursts = new ParticleBurst[] { ParticleBurst.create(5.0, 300, 500),
        ParticleBurst.create(10.0, 50, 100), ParticleBurst.create(15.0, 200, 300) };

    particleSystemOptions.lifetime = 16.0;

    particleSystemOptions.emitter = new CircleEmitter(2.0);

    particleSystemOptions.emitterModelMatrix = computeEmitterModelMatrix();

    particleSystemOptions.updateCallback = new org.cesiumjs.cs.scene.particle.ParticleSystem.UpdateCallback() {
      @Override
      public void function(Particle particle, double dt) {
        Cartesian3 position = particle.position;

        Cartesian3.normalize(position, gravityScratch);
        Cartesian3.multiplyByScalar(gravityScratch, viewModel.gravity * dt, gravityScratch);

        particle.velocity = Cartesian3.add(particle.velocity, gravityScratch, particle.velocity);
      }
    };

    particleSystem = (org.cesiumjs.cs.scene.particle.ParticleSystem) csVPanel.getViewer().scene().primitives()
        .add(new org.cesiumjs.cs.scene.particle.ParticleSystem(particleSystemOptions));

    csVPanel.getViewer().scene().preRender().addEventListener(new Event.Listener() {
      @Override
      public void function(Object... o) {
        Scene scene = (Scene) o[0];
        JulianDate time = (JulianDate) o[1];
        particleSystem.modelMatrix = computeModelMatrix(entity, time);

        // Account for any changes to the emitter model matrix.
        particleSystem.emitterModelMatrix = computeEmitterModelMatrix();

        // Spin the emitter if enabled.
        if (viewModel.spin) {
          viewModel.heading += 1.0;
          viewModel.pitch += 1.0;
          viewModel.roll += 1.0;

          rotationHTBox.setValue(viewModel.heading + "");
          rotationPTBox.setValue(viewModel.pitch + "");
          rotationRTBox.setValue(viewModel.roll + "");
        }
      }
    });

    AbsolutePanel aPanel = new AbsolutePanel();
    aPanel.add(csVPanel);
    aPanel.add(createWidget(), 20, 20);

    contentPanel.add(new HTML("<p>Particle systems.</p>"));
    contentPanel.add(aPanel);

    initWidget(contentPanel);
  }

  public FlexTable createWidget() {
    MSliderListener sliderListener = new MSliderListener();
    MChangeHandler tboxListener = new MChangeHandler();

    rateSlider = new Slider("rate", 0, 100, (int) viewModel.emissionRate);
    rateSlider.setStep(1);
    rateSlider.setWidth("150px");
    rateSlider.addListener(sliderListener);
    rateTBox = new TextBox();
    rateTBox.setValue("" + (int) viewModel.emissionRate);
    rateTBox.setSize("30px", "12px");
    rateTBox.addChangeHandler(tboxListener);

    sizeSlider = new Slider("size", 2, 60, (int) viewModel.particleSize);
    sizeSlider.setStep(1);
    sizeSlider.setWidth("150px");
    sizeSlider.addListener(sliderListener);
    sizeTBox = new TextBox();
    sizeTBox.setValue("" + (int) viewModel.particleSize);
    sizeTBox.setSize("30px", "12px");
    sizeTBox.addChangeHandler(tboxListener);

    minLifeSlider = new Slider("minLife", 1, 30, (int) viewModel.minimumParticleLife);
    minLifeSlider.setStep(1);
    minLifeSlider.setWidth("150px");
    minLifeSlider.addListener(sliderListener);
    minLifeTBox = new TextBox();
    minLifeTBox.setValue("" + (int) viewModel.minimumParticleLife);
    minLifeTBox.setSize("30px", "12px");
    minLifeTBox.addChangeHandler(tboxListener);

    maxLifeSlider = new Slider("maxLife", 1, 30, (int) viewModel.maximumParticleLife);
    maxLifeSlider.setStep(1);
    maxLifeSlider.setWidth("150px");
    maxLifeSlider.addListener(sliderListener);
    maxLifeTBox = new TextBox();
    maxLifeTBox.setValue("" + (int) viewModel.maximumParticleLife);
    maxLifeTBox.setSize("30px", "12px");
    maxLifeTBox.addChangeHandler(tboxListener);

    minSpeedSlider = new Slider("minSpeed", 0, 30, (int) viewModel.minimumSpeed);
    minSpeedSlider.setStep(1);
    minSpeedSlider.setWidth("150px");
    minSpeedSlider.addListener(sliderListener);
    minSpeedTBox = new TextBox();
    minSpeedTBox.setValue("" + (int) viewModel.minimumSpeed);
    minSpeedTBox.setSize("30px", "12px");
    minSpeedTBox.addChangeHandler(tboxListener);

    maxSpeedSlider = new Slider("maxSpeed", 0, 30, (int) viewModel.maximumSpeed);
    maxSpeedSlider.setStep(1);
    maxSpeedSlider.setWidth("150px");
    maxSpeedSlider.addListener(sliderListener);
    maxSpeedTBox = new TextBox();
    maxSpeedTBox.setValue("" + (int) viewModel.maximumSpeed);
    maxSpeedTBox.setSize("30px", "12px");
    maxSpeedTBox.addChangeHandler(tboxListener);

    startScaleSlider = new Slider("startScale", 0, 10, (int) viewModel.startScale);
    startScaleSlider.setStep(1);
    startScaleSlider.setWidth("150px");
    startScaleSlider.addListener(sliderListener);
    startScaleTBox = new TextBox();
    startScaleTBox.setValue("" + (int) viewModel.startScale);
    startScaleTBox.setSize("30px", "12px");
    startScaleTBox.addChangeHandler(tboxListener);

    endScaleSlider = new Slider("endScale", 0, 10, (int) viewModel.endScale);
    endScaleSlider.setStep(1);
    endScaleSlider.setWidth("150px");
    endScaleSlider.addListener(sliderListener);
    endScaleTBox = new TextBox();
    endScaleTBox.setValue("" + (int) viewModel.endScale);
    endScaleTBox.setSize("30px", "12px");
    endScaleTBox.addChangeHandler(tboxListener);

    gravitySlider = new Slider("gravity", -20, 20, (int) viewModel.gravity);
    gravitySlider.setStep(1);
    gravitySlider.setWidth("150px");
    gravitySlider.addListener(sliderListener);
    gravityTBox = new TextBox();
    gravityTBox.setValue("" + (int) viewModel.gravity);
    gravityTBox.setSize("30px", "12px");
    gravityTBox.addChangeHandler(tboxListener);

    translationXTBox = new TextBox();
    translationXTBox.setSize("30px", "12px");
    translationXTBox.setValue(viewModel.transX + "");
    translationXTBox.addChangeHandler(tboxListener);
    translationYTBox = new TextBox();
    translationYTBox.setSize("30px", "12px");
    translationYTBox.setValue(viewModel.transY + "");
    translationYTBox.addChangeHandler(tboxListener);
    translationZTBox = new TextBox();
    translationZTBox.setSize("30px", "12px");
    translationZTBox.setValue(viewModel.transZ + "");
    translationZTBox.addChangeHandler(tboxListener);

    rotationHTBox = new TextBox();
    rotationHTBox.setSize("30px", "12px");
    rotationHTBox.setValue(viewModel.heading + "");
    rotationHTBox.addChangeHandler(tboxListener);
    rotationPTBox = new TextBox();
    rotationPTBox.setSize("30px", "12px");
    rotationPTBox.setValue(viewModel.pitch + "");
    rotationPTBox.addChangeHandler(tboxListener);
    rotationRTBox = new TextBox();
    rotationRTBox.setSize("30px", "12px");
    rotationRTBox.setValue(viewModel.roll + "");
    rotationRTBox.addChangeHandler(tboxListener);

    spinCBox = new CheckBox();
    spinCBox.setHTML("<font color=\"white\">Spin</font>");
    spinCBox.addValueChangeHandler(new MValueChangeHandler());

    flyCBox = new CheckBox();
    flyCBox.setHTML("<font color=\"white\">Fly</font>");
    flyCBox.addValueChangeHandler(new MValueChangeHandler());

    showCBox = new CheckBox();
    showCBox.setHTML("<font color=\"white\">Show</font>");
    showCBox.setValue(true);
    showCBox.addValueChangeHandler(new MValueChangeHandler());

    ListBox emitterLBox = new ListBox();
    emitterLBox.addItem("Circle", "Circle");
    emitterLBox.addItem("Cone", "Cone");
    emitterLBox.addItem("Box", "Box");
    emitterLBox.addItem("Sphere", "Sphere");
    emitterLBox.addChangeHandler(new ChangeHandler() {
      @Override
      public void onChange(ChangeEvent changeEvent) {
        ListBox source = (ListBox) changeEvent.getSource();
        switch (source.getSelectedValue()) {
          case "Circle":
            particleSystem.emitter = new CircleEmitter(0.5);
            break;
          case "Cone":
            particleSystem.emitter = new ConeEmitter(Math.toRadians(45.0));
            break;
          case "Box":
            particleSystem.emitter = new BoxEmitter(new Cartesian3(10.0, 10.0, 10.0));
            break;
          case "Sphere":
            particleSystem.emitter = new SphereEmitter(5.0);
            break;
          default:
            break;
        }
      }
    });

    FlexTable flexTable = new FlexTable();
    flexTable.getElement().getStyle().setBackgroundColor("rgba(0, 0, 0, 0.5)");
    flexTable.setCellSpacing(2);
    flexTable.setCellPadding(2);

    flexTable.setHTML(0, 0, "<font color=\"white\">Rate</font>");
    flexTable.setWidget(0, 1, rateSlider);
    flexTable.setWidget(0, 2, rateTBox);

    flexTable.setHTML(1, 0, "<font color=\"white\">Size</font>");
    flexTable.setWidget(1, 1, sizeSlider);
    flexTable.setWidget(1, 2, sizeTBox);

    flexTable.setHTML(2, 0, "<font color=\"white\">Min Life</font>");
    flexTable.setWidget(2, 1, minLifeSlider);
    flexTable.setWidget(2, 2, minLifeTBox);

    flexTable.setHTML(3, 0, "<font color=\"white\">Max Life</font>");
    flexTable.setWidget(3, 1, maxLifeSlider);
    flexTable.setWidget(3, 2, maxLifeTBox);

    flexTable.setHTML(4, 0, "<font color=\"white\">Min Speed</font>");
    flexTable.setWidget(4, 1, minSpeedSlider);
    flexTable.setWidget(4, 2, minSpeedTBox);

    flexTable.setHTML(5, 0, "<font color=\"white\">Max Speed</font>");
    flexTable.setWidget(5, 1, maxSpeedSlider);
    flexTable.setWidget(5, 2, maxSpeedTBox);

    flexTable.setHTML(6, 0, "<font color=\"white\">Start Scale</font>");
    flexTable.setWidget(6, 1, startScaleSlider);
    flexTable.setWidget(6, 2, startScaleTBox);

    flexTable.setHTML(7, 0, "<font color=\"white\">End Scale</font>");
    flexTable.setWidget(7, 1, endScaleSlider);
    flexTable.setWidget(7, 2, endScaleTBox);

    flexTable.setHTML(8, 0, "<font color=\"white\">Gravity</font>");
    flexTable.setWidget(8, 1, gravitySlider);
    flexTable.setWidget(8, 2, gravityTBox);

    FlexTable transactionFTable = new FlexTable();
    transactionFTable.setHTML(0, 0, "<font color=\"white\">X</font>");
    transactionFTable.setWidget(0, 1, translationXTBox);
    transactionFTable.setHTML(0, 2, "<font color=\"white\">Y</font>");
    transactionFTable.setWidget(0, 3, translationYTBox);
    transactionFTable.setHTML(0, 4, "<font color=\"white\">Z</font>");
    transactionFTable.setWidget(0, 5, translationZTBox);

    flexTable.setHTML(9, 0, "<font color=\"white\">Translation</font>");
    flexTable.setWidget(9, 1, transactionFTable);

    FlexTable rotationFTable = new FlexTable();
    rotationFTable.setHTML(0, 0, "<font color=\"white\">H</font>");
    rotationFTable.setWidget(0, 1, rotationHTBox);
    rotationFTable.setHTML(0, 2, "<font color=\"white\">P</font>");
    rotationFTable.setWidget(0, 3, rotationPTBox);
    rotationFTable.setHTML(0, 4, "<font color=\"white\">R</font>");
    rotationFTable.setWidget(0, 5, rotationRTBox);

    flexTable.setHTML(10, 0, "<font color=\"white\">Rotation</font>");
    flexTable.setWidget(10, 1, rotationFTable);

    FlexTable btnFTable = new FlexTable();
    btnFTable.setWidget(0, 0, spinCBox);
    btnFTable.setWidget(0, 1, flyCBox);
    btnFTable.setWidget(0, 2, showCBox);
    btnFTable.setWidget(0, 3, emitterLBox);

    flexTable.setWidget(11, 1, btnFTable);

    return flexTable;
  }

  @Override
  public String[] getSourceCodeURLs() {
    String[] sourceCodeURLs = new String[1];
    sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "ParticleSystem.txt";
    return sourceCodeURLs;
  }

  public static class ViewModel {
    double emissionRate = 5.0;
    double gravity = 0.0;
    double minimumParticleLife = 1.0;
    double maximumParticleLife = 1.0;
    double minimumSpeed = 1.0;
    double maximumSpeed = 4.0;
    double startScale = 1.0;
    double endScale = 5.0;
    double particleSize = 25.0;
    double transX = 2.5;
    double transY = 4.0;
    double transZ = 1.0;
    double heading = 0.0;
    double pitch = 0.0;
    double roll = 0.0;
    boolean fly = true;
    boolean spin = true;
    boolean show = true;
  }

  private Matrix4 computeModelMatrix(Entity entity, JulianDate time) {
    Cartesian3 position = Property.getValueOrUndefined(entity.position, time, entityPosition);
    if (!Cesium.defined(position)) {
      return (Matrix4) JsObject.undefined();
    }

    Quaternion orientation = Property.getValueOrUndefined(entity.orientation, time, entityOrientation);
    if (!Cesium.defined(orientation)) {
      modelMatrix = Transforms.eastNorthUpToFixedFrame(position, (Ellipsoid) JsObject.undefined(), modelMatrix);
    } else {
      modelMatrix = Matrix4.fromRotationTranslation(Matrix3.fromQuaternion(orientation, rotationMatrix), position,
          modelMatrix);
    }
    return modelMatrix;
  }

  private Matrix4 computeEmitterModelMatrix() {
    hpr = org.cesiumjs.cs.core.HeadingPitchRoll.fromDegrees(viewModel.heading, viewModel.pitch, viewModel.roll, hpr);

    trs.translation = Cartesian3.fromElements(viewModel.transX, viewModel.transY, viewModel.transZ, translation);
    trs.rotation = Quaternion.fromHeadingPitchRoll(hpr, rotation);

    return Matrix4.fromTranslationRotationScale(trs, emitterModelMatrix);
  }

  // Generate a random circular pattern with varying heights.
  private SampledPositionProperty computeCirclularFlight(double lon, double lat, double radius) {
    SampledPositionProperty property = new SampledPositionProperty();
    for (int i = 0; i <= 360; i += 45) {
      double radians = Math.toRadians(i);
      JulianDate time = JulianDate.addSeconds(start, i, new JulianDate());
      Cartesian3 position = Cartesian3.fromDegrees(lon + (radius * 1.5 * java.lang.Math.cos(radians)),
          lat + (radius * java.lang.Math.sin(radians)), Math.nextRandomNumber() * 500 + 1750);
      property.addSample(time, position);
    }
    return property;
  }

  private class MSliderListener implements SliderListener {

    @Override
    public void onStart(SliderEvent e) {

    }

    @Override
    public boolean onSlide(SliderEvent e) {
      Slider source = e.getSource();
      int value = source.getValue();
      if (source == rateSlider) {
        particleSystem.emissionRate = value;
        rateTBox.setValue("" + value);
      } else if (source == sizeSlider) {
        particleSystem.minimumImageSize.x = value;
        particleSystem.minimumImageSize.y = value;
        particleSystem.maximumImageSize.x = value;
        particleSystem.maximumImageSize.y = value;
        sizeTBox.setValue("" + value);
      } else if (source == minLifeSlider) {
        particleSystem.minimumParticleLife = value;
        minLifeTBox.setValue("" + value);
      } else if (source == maxLifeSlider) {
        particleSystem.maximumParticleLife = value;
        maxLifeTBox.setValue("" + value);
      } else if (source == minSpeedSlider) {
        particleSystem.minimumSpeed = value;
        minSpeedTBox.setValue("" + value);
      } else if (source == maxSpeedSlider) {
        particleSystem.maximumSpeed = value;
        maxSpeedTBox.setValue("" + value);
      } else if (source == startScaleSlider) {
        particleSystem.startScale = value;
        startScaleTBox.setValue("" + value);
      } else if (source == endScaleSlider) {
        particleSystem.endScale = value;
        endScaleTBox.setValue("" + value);
      } else if (source == gravitySlider) {
        viewModel.gravity = value;
        gravityTBox.setValue("" + value);
      }
      return true;
    }

    @Override
    public void onChange(SliderEvent e) {

    }

    @Override
    public void onStop(SliderEvent e) {

    }
  }

  private class MChangeHandler implements ChangeHandler {
    @Override
    public void onChange(ChangeEvent changeEvent) {
      TextBox source = (TextBox) changeEvent.getSource();
      int value = Integer.parseInt(source.getValue());
      if (source == rateTBox) {
        rateSlider.setValue(value);
        particleSystem.emissionRate = value;
      } else if (source == sizeTBox) {
        particleSystem.minimumImageSize.x = value;
        particleSystem.minimumImageSize.y = value;
        particleSystem.maximumImageSize.x = value;
        particleSystem.maximumImageSize.y = value;
        sizeSlider.setValue(value);
      } else if (source == minLifeTBox) {
        particleSystem.minimumParticleLife = value;
        minLifeSlider.setValue(value);
      } else if (source == maxLifeTBox) {
        particleSystem.maximumParticleLife = value;
        maxLifeSlider.setValue(value);
      } else if (source == minSpeedTBox) {
        particleSystem.minimumSpeed = value;
        minSpeedSlider.setValue(value);
      } else if (source == maxSpeedTBox) {
        particleSystem.maximumSpeed = value;
        maxSpeedSlider.setValue(value);
      } else if (source == startScaleTBox) {
        particleSystem.startScale = value;
        startScaleSlider.setValue(value);
      } else if (source == endScaleTBox) {
        particleSystem.endScale = value;
        endScaleSlider.setValue(value);
      } else if (source == gravityTBox) {
        viewModel.gravity = value;
        gravitySlider.setValue(value);
      } else if (source == translationXTBox) {
        viewModel.transX = value;
      } else if (source == translationYTBox) {
        viewModel.transY = value;
      } else if (source == translationZTBox) {
        viewModel.transZ = value;
      } else if (source == rotationHTBox) {
        viewModel.heading = value;
      } else if (source == rotationPTBox) {
        viewModel.pitch = value;
      } else if (source == rotationRTBox) {
        viewModel.roll = value;
      }
    }
  }

  private class MValueChangeHandler implements ValueChangeHandler<Boolean> {
    @Override
    public void onValueChange(ValueChangeEvent<Boolean> valueChangeEvent) {
      CheckBox source = (CheckBox) valueChangeEvent.getSource();
      boolean value = valueChangeEvent.getValue();
      if (source == spinCBox) {
        viewModel.spin = value;
      } else if (source == flyCBox) {
        if (value) {
          entity.position = circularPosition;
          entity.orientation = new VelocityOrientationProperty(circularPosition);
        } else {
          entity.position = new ConstantPositionProperty(staticPosition);
          entity.orientation = (Property) JsObject.undefined();
        }
      } else if (source == showCBox) {
        viewModel.show = value;
        entity.show = value;
        particleSystem.show = value;
      }
    }
  }
}