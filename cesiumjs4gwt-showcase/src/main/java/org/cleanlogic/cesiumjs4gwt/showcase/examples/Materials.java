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
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ListBox;

import org.cesiumjs.cs.collections.PolylineCollection;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.PolylinePipeline;
import org.cesiumjs.cs.core.Rectangle;
import org.cesiumjs.cs.core.geometry.GeometryInstance;
import org.cesiumjs.cs.core.geometry.RectangleGeometry;
import org.cesiumjs.cs.core.geometry.options.RectangleGeometryOptions;
import org.cesiumjs.cs.core.options.GeometryInstanceOptions;
import org.cesiumjs.cs.core.options.PolylinePipelineOptions;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.scene.Material;
import org.cesiumjs.cs.scene.Polyline;
import org.cesiumjs.cs.scene.Primitive;
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.scene.apperances.EllipsoidSurfaceAppearance;
import org.cesiumjs.cs.scene.apperances.options.EllipsoidSurfaceAppearanceOptions;
import org.cesiumjs.cs.scene.options.MaterialOptions;
import org.cesiumjs.cs.scene.options.PolylineOptions;
import org.cesiumjs.cs.scene.options.PrimitiveOptions;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

/**
 * @author Serge Silaev aka iSergio
 */
public class Materials extends AbstractExample {

  private Primitive rectangle;
  private Primitive worldRectangle;
  private Polyline polyline;

  private ViewerPanel csVPanel;

  private ListBox commonMaterialLBox;
  private ListBox proceduralTexturesLBox;
  private ListBox baseMaterialsLBox;
  private ListBox miscMaterialsLBox;
  private ListBox exampleCompositeMaterialsLBox;
  private ListBox polylineMaterialsLBox;

  @Inject
  public Materials(ShowcaseExampleStore store) {
    super("Materials", "Browse Cesium's built in materials and define new ones using the Fabric schema",
        new String[] { "Showcase", "Cesium", "3d", "Viewer" }, store);
  }

  @Override
  public void buildPanel() {
    csVPanel = new ViewerPanel();
    createPrimitives(csVPanel.getViewer().scene());
    applyColorMaterial(rectangle);

    commonMaterialLBox = new ListBox();
    commonMaterialLBox.addChangeHandler(new MChangeHandler());
    commonMaterialLBox.addItem("Select", "0");
    commonMaterialLBox.addItem("Color", "1");
    commonMaterialLBox.addItem("Image", "2");

    proceduralTexturesLBox = new ListBox();
    proceduralTexturesLBox.addChangeHandler(new MChangeHandler());
    proceduralTexturesLBox.addItem("Select", "0");
    proceduralTexturesLBox.addItem("Checkerboard", "1");
    proceduralTexturesLBox.addItem("Dot", "2");
    proceduralTexturesLBox.addItem("Grid", "3");
    proceduralTexturesLBox.addItem("Stripe", "4");

    baseMaterialsLBox = new ListBox();
    baseMaterialsLBox.addChangeHandler(new MChangeHandler());
    baseMaterialsLBox.addItem("Select", "0");
    baseMaterialsLBox.addItem("Alpha Map", "1");
    baseMaterialsLBox.addItem("Bump Map", "2");
    baseMaterialsLBox.addItem("Diffuse", "3");
    baseMaterialsLBox.addItem("Emission Map", "4");
    baseMaterialsLBox.addItem("Normal Map", "5");
    baseMaterialsLBox.addItem("Specular Map", "6");

    miscMaterialsLBox = new ListBox();
    miscMaterialsLBox.addChangeHandler(new MChangeHandler());
    miscMaterialsLBox.addItem("Select", "0");
    miscMaterialsLBox.addItem("Rim Lighting", "1");
    miscMaterialsLBox.addItem("Water", "2");

    exampleCompositeMaterialsLBox = new ListBox();
    exampleCompositeMaterialsLBox.addChangeHandler(new MChangeHandler());
    exampleCompositeMaterialsLBox.addItem("Select", "0");
    exampleCompositeMaterialsLBox.addItem("Composite Example", "1");

    polylineMaterialsLBox = new ListBox();
    polylineMaterialsLBox.addChangeHandler(new MChangeHandler());
    polylineMaterialsLBox.addItem("Select", "0");
    polylineMaterialsLBox.addItem("Polyline Arrow", "1");
    polylineMaterialsLBox.addItem("Polyline Glow", "2");
    polylineMaterialsLBox.addItem("Polyline Outline", "3");

    FlexTable flexTable = new FlexTable();
    flexTable.setCellSpacing(1);
    flexTable.setCellPadding(1);
    flexTable.setHTML(1, 0, "<font color=\"white\">Common materials</font>");
    flexTable.setWidget(1, 1, commonMaterialLBox);
    flexTable.setHTML(2, 0, "<font color=\"white\">Procedural textures</font>");
    flexTable.setWidget(2, 1, proceduralTexturesLBox);
    flexTable.setHTML(3, 0, "<font color=\"white\">Base materials</font>");
    flexTable.setWidget(3, 1, baseMaterialsLBox);
    flexTable.setHTML(4, 0, "<font color=\"white\">Misc materials</font>");
    flexTable.setWidget(4, 1, miscMaterialsLBox);
    flexTable.setHTML(5, 0, "<font color=\"white\">Example composite materials</font>");
    flexTable.setWidget(5, 1, exampleCompositeMaterialsLBox);
    flexTable.setHTML(6, 0, "<font color=\"white\">Polyline materials</font>");
    flexTable.setWidget(6, 1, polylineMaterialsLBox);
    //
    AbsolutePanel aPanel = new AbsolutePanel();
    aPanel.add(csVPanel);
    aPanel.add(flexTable, 20, 20);

    contentPanel
        .add(new HTML("<p>Browse Cesium's built in materials and define new ones using the Fabric schema.</p>"));
    contentPanel.add(aPanel);

    initWidget(contentPanel);
  }

  @Override
  public String[] getSourceCodeURLs() {
    String[] sourceCodeURLs = new String[1];
    sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "Materials.txt";
    return sourceCodeURLs;
  }

  private class MChangeHandler implements ChangeHandler {
    @Override
    public void onChange(ChangeEvent changeEvent) {
      ListBox source = (ListBox) changeEvent.getSource();
      int value = Integer.parseInt(source.getSelectedValue());
      if (source.equals(commonMaterialLBox)) {
        toggleRectangleVisibility();
        if (value == 1) {
          applyColorMaterial(rectangle);
        } else if (value == 2) {
          applyImageMaterial(rectangle);
        }
      } else if (source.equals(proceduralTexturesLBox)) {
        toggleRectangleVisibility();
        if (value == 1) {
          applyCheckerboardMaterial(rectangle);
        } else if (value == 2) {
          applyDotMaterial(rectangle);
        } else if (value == 3) {
          applyGridMaterial(rectangle);
        } else if (value == 4) {
          applyStripeMaterial(rectangle);
        }
      } else if (source.equals(baseMaterialsLBox)) {
        toggleRectangleVisibility();
        if (value == 1) {
          applyAlphaMapMaterial(rectangle);
        } else if (value == 2) {
          applyBumpMapMaterial(rectangle);
        } else if (value == 3) {
          applyDiffuseMaterial(rectangle);
        } else if (value == 4) {
          applyEmissionMapMaterial(rectangle);
        } else if (value == 5) {
          applyNormalMapMaterial(rectangle);
        } else if (value == 6) {
          applySpecularMapMaterial(rectangle);
        }
      } else if (source.equals(miscMaterialsLBox)) {
        toggleWorldRectangleVisibility();
        if (value == 1) {
          applyRimLightingMaterial(worldRectangle);
        } else if (value == 2) {
          applyWaterMaterial(worldRectangle);
        }
      } else if (source.equals(exampleCompositeMaterialsLBox)) {
        toggleWorldRectangleVisibility();
        if (value == 1) {
          applyCompositeMaterial(worldRectangle);
        }
      } else if (source.equals(polylineMaterialsLBox)) {
        togglePolylineVisibility();
        if (value == 1) {
          applyPolylineArrowMaterial(polyline);
        } else if (value == 2) {
          applyPolylineGlowMaterial(polyline);
        } else if (value == 3) {
          applyPolylineOutlineMaterial(polyline);
        }
      }
    }
  }

  public void createPrimitives(Scene scene) {
    PrimitiveOptions primitiveOptions = new PrimitiveOptions();
    GeometryInstanceOptions geometryInstanceOptions = new GeometryInstanceOptions();
    RectangleGeometryOptions rectangleGeometryOptions = new RectangleGeometryOptions();
    rectangleGeometryOptions.rectangle = Rectangle.fromDegrees(-120.0, 20.0, -60.0, 40.0);
    rectangleGeometryOptions.vertexFormat = EllipsoidSurfaceAppearance.VERTEX_FORMAT();
    geometryInstanceOptions.geometry = RectangleGeometry
        .createGeometry(new RectangleGeometry(rectangleGeometryOptions));
    primitiveOptions.geometryInstances = new GeometryInstance[] { new GeometryInstance(geometryInstanceOptions) };
    EllipsoidSurfaceAppearanceOptions ellipsoidSurfaceAppearanceOptions = new EllipsoidSurfaceAppearanceOptions();
    ellipsoidSurfaceAppearanceOptions.aboveGround = false;
    primitiveOptions.asynchronous = false;
    primitiveOptions.appearance = new EllipsoidSurfaceAppearance(ellipsoidSurfaceAppearanceOptions);
    rectangle = (Primitive) scene.primitives().add(new Primitive(primitiveOptions));

    primitiveOptions = new PrimitiveOptions();
    geometryInstanceOptions = new GeometryInstanceOptions();
    rectangleGeometryOptions = new RectangleGeometryOptions();
    rectangleGeometryOptions.rectangle = Rectangle.fromDegrees(-180.0, -90.0, 180.0, 90.0);
    rectangleGeometryOptions.vertexFormat = EllipsoidSurfaceAppearance.VERTEX_FORMAT();
    geometryInstanceOptions.geometry = RectangleGeometry
        .createGeometry(new RectangleGeometry(rectangleGeometryOptions));
    primitiveOptions.geometryInstances = new GeometryInstance[] { new GeometryInstance(geometryInstanceOptions) };
    ellipsoidSurfaceAppearanceOptions = new EllipsoidSurfaceAppearanceOptions();
    ellipsoidSurfaceAppearanceOptions.aboveGround = false;
    primitiveOptions.appearance = new EllipsoidSurfaceAppearance(ellipsoidSurfaceAppearanceOptions);
    primitiveOptions.show = false;
    primitiveOptions.asynchronous = false;
    worldRectangle = (Primitive) scene.primitives().add(new Primitive(primitiveOptions));

    PolylineCollection polylines = (PolylineCollection) scene.primitives().add(new PolylineCollection());
    PolylineOptions polylineOptions = new PolylineOptions();
    PolylinePipelineOptions polylinePipelineOptions = new PolylinePipelineOptions();
    polylinePipelineOptions.positions = Cartesian3
        .fromDegreesArray(new double[] { -110.0, 42.0, -85.0, 36.0, -100.0, 25.0, -77.0, 12.0 });
    polylineOptions.positions = PolylinePipeline.generateCartesianArc(polylinePipelineOptions);
    polylineOptions.width = 10.0;
    polylineOptions.show = false;
    polyline = polylines.add(polylineOptions);
  }

  public void toggleRectangleVisibility() {
    rectangle.show = true;
    worldRectangle.show = false;
    polyline.show = false;
  }

  public void toggleWorldRectangleVisibility() {
    rectangle.show = false;
    worldRectangle.show = true;
    polyline.show = false;
  }

  public void togglePolylineVisibility() {
    rectangle.show = false;
    worldRectangle.show = false;
    polyline.show = true;
  }

  public void applyColorMaterial(Primitive primitive) {
    primitive.appearance.material = Material.fromType("Color");
  }

  public void applyImageMaterial(Primitive primitive) {
    JSONObject uniforms = new JSONObject();
    uniforms.put("image", new JSONString(GWT.getModuleBaseURL() + "images/Cesium_Logo_Color.jpg"));

    JSONObject fabric = new JSONObject();
    fabric.put("type", new JSONString("Image"));
    fabric.put("uniforms", uniforms);

    MaterialOptions materialOptions = new MaterialOptions();
    materialOptions.fabric = JsonUtils.safeEval(fabric.toString());
    primitive.appearance.material = new Material(materialOptions);
  }

  public void applyCheckerboardMaterial(Primitive primitive) {
    primitive.appearance.material = Material.fromType("Checkerboard");
  }

  public void applyDotMaterial(Primitive primitive) {
    primitive.appearance.material = Material.fromType("Dot");
  }

  public void applyGridMaterial(Primitive primitive) {
    primitive.appearance.material = Material.fromType("Grid");
  }

  public void applyStripeMaterial(Primitive primitive) {
    primitive.appearance.material = Material.fromType("Stripe");
  }

  public void applyAlphaMapMaterial(Primitive primitive) {
    JSONObject uniforms = new JSONObject();
    uniforms.put("image", new JSONString(GWT.getModuleBaseURL() + "images/Cesium_Logo_Color.jpg"));
    uniforms.put("channel", new JSONString("r"));

    JSONObject alphaMaterial = new JSONObject();
    alphaMaterial.put("type", new JSONString("AlphaMap"));
    alphaMaterial.put("uniforms", uniforms);

    JSONObject materials = new JSONObject();
    materials.put("alphaMaterial", alphaMaterial);

    JSONObject components = new JSONObject();
    components.put("diffuse", new JSONString("vec3(1.0)"));
    components.put("alpha", new JSONString("alphaMaterial.alpha"));

    JSONObject fabric = new JSONObject();
    fabric.put("materials", materials);
    fabric.put("components", components);

    MaterialOptions materialOptions = new MaterialOptions();
    materialOptions.fabric = JsonUtils.safeEval(fabric.toString());
    primitive.appearance.material = new Material(materialOptions);
  }

  public void applyBumpMapMaterial(Primitive primitive) {
    JSONObject uniforms = new JSONObject();
    uniforms.put("image", new JSONString(GWT.getModuleBaseURL() + "images/bumpmap.png"));

    JSONObject diffuseMaterial = new JSONObject();
    diffuseMaterial.put("type", new JSONString("DiffuseMap"));
    diffuseMaterial.put("uniforms", uniforms);

    uniforms = new JSONObject();
    uniforms.put("image", new JSONString(GWT.getModuleBaseURL() + "images/bumpmap.png"));
    uniforms.put("strength", new JSONNumber(0.8));

    JSONObject bumpMaterial = new JSONObject();
    bumpMaterial.put("type", new JSONString("BumpMap"));
    bumpMaterial.put("uniforms", uniforms);

    JSONObject materials = new JSONObject();
    materials.put("diffuseMaterial", diffuseMaterial);
    materials.put("bumpMaterial", bumpMaterial);

    JSONObject components = new JSONObject();
    components.put("diffuse", new JSONString("diffuseMaterial.diffuse"));
    components.put("specular", new JSONNumber(0.01));
    components.put("normal", new JSONString("bumpMaterial.normal"));

    JSONObject fabric = new JSONObject();
    fabric.put("materials", materials);
    fabric.put("components", components);

    MaterialOptions materialOptions = new MaterialOptions();
    materialOptions.fabric = JsonUtils.safeEval(fabric.toString());
    primitive.appearance.material = new Material(materialOptions);
  }

  public void applyDiffuseMaterial(Primitive primitive) {
    JSONObject uniforms = new JSONObject();
    uniforms.put("image", new JSONString(GWT.getModuleBaseURL() + "images/Cesium_Logo_Color.jpg"));

    JSONObject fabric = new JSONObject();
    fabric.put("type", new JSONString("DiffuseMap"));
    fabric.put("uniforms", uniforms);

    MaterialOptions materialOptions = new MaterialOptions();
    materialOptions.fabric = JsonUtils.safeEval(fabric.toString());
    primitive.appearance.material = new Material(materialOptions);
  }

  public void applyEmissionMapMaterial(Primitive primitive) {
    JSONObject uniforms = new JSONObject();
    uniforms.put("image", new JSONString(GWT.getModuleBaseURL() + "images/Cesium_Logo_Color.jpg"));

    JSONObject diffuseMaterial = new JSONObject();
    diffuseMaterial.put("type", new JSONString("DiffuseMap"));
    diffuseMaterial.put("uniforms", uniforms);

    JSONObject repeat = new JSONObject();
    repeat.put("x", new JSONNumber(1));
    repeat.put("y", new JSONNumber(0.5));

    uniforms = new JSONObject();
    uniforms.put("image", new JSONString(GWT.getModuleBaseURL() + "images/checkerboard.png"));
    uniforms.put("repeat", repeat);

    JSONObject emissionMaterial = new JSONObject();
    emissionMaterial.put("type", new JSONString("EmissionMap"));
    emissionMaterial.put("uniforms", uniforms);

    JSONObject materials = new JSONObject();
    materials.put("diffuseMaterial", diffuseMaterial);
    materials.put("emissionMaterial", emissionMaterial);

    JSONObject components = new JSONObject();
    components.put("diffuse", new JSONString("diffuseMaterial.diffuse"));
    components.put("emission", new JSONString("emissionMaterial.emission * 0.2"));

    JSONObject fabric = new JSONObject();
    fabric.put("materials", materials);
    fabric.put("components", components);

    MaterialOptions materialOptions = new MaterialOptions();
    materialOptions.fabric = JsonUtils.safeEval(fabric.toString());
    primitive.appearance.material = new Material(materialOptions);
  }

  public void applyNormalMapMaterial(Primitive primitive) {
    JSONObject uniforms = new JSONObject();
    uniforms.put("image", new JSONString(GWT.getModuleBaseURL() + "images/bumpmap.png"));

    JSONObject diffuseMaterial = new JSONObject();
    diffuseMaterial.put("type", new JSONString("DiffuseMap"));
    diffuseMaterial.put("uniforms", uniforms);

    uniforms = new JSONObject();
    uniforms.put("image", new JSONString(GWT.getModuleBaseURL() + "images/normalmap.png"));
    uniforms.put("strength", new JSONNumber(0.6));

    JSONObject normalMap = new JSONObject();
    normalMap.put("type", new JSONString("NormalMap"));
    normalMap.put("uniforms", uniforms);

    JSONObject materials = new JSONObject();
    materials.put("diffuseMaterial", diffuseMaterial);
    materials.put("normalMap", normalMap);

    JSONObject components = new JSONObject();
    components.put("diffuse", new JSONString("diffuseMaterial.diffuse"));
    components.put("specular", new JSONNumber(0.01));
    components.put("normal", new JSONString("normalMap.normal"));

    JSONObject fabric = new JSONObject();
    fabric.put("materials", materials);
    fabric.put("components", components);

    MaterialOptions materialOptions = new MaterialOptions();
    materialOptions.fabric = JsonUtils.safeEval(fabric.toString());
    primitive.appearance.material = new Material(materialOptions);
  }

  public void applySpecularMapMaterial(Primitive primitive) {
    JSONObject uniforms = new JSONObject();
    uniforms.put("image", new JSONString(GWT.getModuleBaseURL() + "images/Cesium_Logo_Color.jpg"));
    uniforms.put("channel", new JSONString("r"));

    JSONObject fabric = new JSONObject();
    fabric.put("type", new JSONString("SpecularMap"));
    fabric.put("uniforms", uniforms);

    MaterialOptions materialOptions = new MaterialOptions();
    materialOptions.fabric = JsonUtils.safeEval(fabric.toString());
    primitive.appearance.material = new Material(materialOptions);
  }

  public void applyRimLightingMaterial(Primitive primitive) {
    primitive.appearance.material = Material.fromType("RimLighting");
  }

  public void applyWaterMaterial(Primitive primitive) {
    JSONObject uniforms = new JSONObject();
    uniforms.put("specularMap", new JSONString(GWT.getModuleBaseURL() + "images/earthspec1k.jpg"));
    uniforms.put("normalMap", new JSONString(GWT.getModuleBaseURL() + "images/waterNormals.jpg"));
    uniforms.put("frequency", new JSONNumber(10000.0));
    uniforms.put("animationSpeed", new JSONNumber(0.01));
    uniforms.put("amplitude", new JSONNumber(1.0));

    JSONObject fabric = new JSONObject();
    fabric.put("type", new JSONString("Water"));
    fabric.put("uniforms", uniforms);

    MaterialOptions materialOptions = new MaterialOptions();
    materialOptions.fabric = JsonUtils.safeEval(fabric.toString());
    primitive.appearance.material = new Material(materialOptions);
  }

  public void applyCompositeMaterial(Primitive primitive) {
    JSONObject fabric = new JSONObject();

    JSONObject uniforms = new JSONObject();
    uniforms.put("image", new JSONString(GWT.getModuleBaseURL() + "images/earthspec1k.jpg"));
    uniforms.put("heightField", new JSONString(GWT.getModuleBaseURL() + "images/earthbump1k.jpg"));
    fabric.put("uniforms", uniforms);

    uniforms = new JSONObject();
    uniforms.put("image", new JSONString(GWT.getModuleBaseURL() + "images/earthbump1k.jpg"));

    JSONObject bumpMap = new JSONObject();
    bumpMap.put("type", new JSONString("BumpMap"));
    bumpMap.put("uniforms", uniforms);

    JSONObject materials = new JSONObject();
    materials.put("bumpMap", bumpMap);

    fabric.put("materials", materials);
    fabric.put("source",
        new JSONString("czm_material czm_getMaterial(czm_materialInput materialInput) {"
            + "czm_material material = czm_getDefaultMaterial(materialInput);"
            + "float heightValue = texture2D(heightField, materialInput.st).r;"
            + "material.diffuse = mix(vec3(0.2, 0.6, 0.2), vec3(1.0, 0.5, 0.2), heightValue);"
            + "material.alpha = (1.0 - texture2D(image, materialInput.st).r) * 0.7;"
            + "material.normal = bumpMap.normal;" + "material.specular = step(0.1, heightValue);" + // Specular mountain
                                                                                                    // tops
            "material.shininess = 8.0;" + // Sharpen highlight
            "return material;" + "}"));

    MaterialOptions materialOptions = new MaterialOptions();
    materialOptions.fabric = JsonUtils.safeEval(fabric.toString());
    primitive.appearance.material = new Material(materialOptions);
  }

  public void applyPolylineArrowMaterial(Polyline primitive) {
    primitive.material = Material.fromType("PolylineArrow");
  }

  public void applyPolylineGlowMaterial(Polyline primitive) {
    JsObject jsOobject = JsObject.create();
    primitive.material = Material.fromType("PolylineGlow", JsObject.$(jsOobject, "innerWidth", primitive.width / 2.0));
  }

  public void applyPolylineOutlineMaterial(Polyline primitive) {
    JsObject jsOobject = JsObject.create();
    primitive.material = Material.fromType("PolylineOutline",
        JsObject.$(jsOobject, "outlineWidth", primitive.width / 2.0));
  }
}