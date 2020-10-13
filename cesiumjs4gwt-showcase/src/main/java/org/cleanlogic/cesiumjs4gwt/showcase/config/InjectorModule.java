/**
 *
 *   Copyright 2015 sourceforge.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package org.cleanlogic.cesiumjs4gwt.showcase.config;

import java.util.List;

import javax.inject.Singleton;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.user.client.ui.Image;

import org.cleanlogic.cesiumjs4gwt.showcase.config.provider.ShowcaseBrandsProvider;
import org.cleanlogic.cesiumjs4gwt.showcase.config.provider.ShowcaseLogoProvider;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.AmbientOcclusion;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.ArcGISTiledElevationTerrain;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.Billboards;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.Bloom;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.CZML;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.CZMLModelArticulations;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.CallbackProperty;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.Camera;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.CameraTutorial;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.Cardboard;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.CartographicLimitRectangle;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.CesiumInspector;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.CesiumNavigation;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.Clampto3DModel;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.Clampto3DTiles;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.ClamptoTerrain;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.Clustering;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.CustomBaseLayerPicker;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.CustomGeocoder;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.CustomHomeButton;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.CustomPerFeaturePostProcess;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.CustomPostProcess;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.DepthOfField;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.Drawing;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.DrawingOnTerrain;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.ExportKML;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.GeoJSONAndTopoJSON;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.GeoJSONsimplestyle;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.GeometryAndAppearances;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.GeometryHeightReference;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.GoogleEarthEnterprise;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.GroundAtmosphere;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.GroundPolylinePrimitive;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.HeadingPitchRoll;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.HelloWorld;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.ImageBasedLighting;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.ImageryAdjustment;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.ImageryColorToAlpha;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.ImageryCutout;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.ImageryLayers;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.ImageryLayersManipulation;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.ImageryLayersSplit;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.Interpolation;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.KML;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.Labels;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.LensFlare;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.LoadImages;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.Materials;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.Models3D;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.Models3DColoring;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.MultipleSyncedViews;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.ParticleSystem;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.ParticleSystemFireworks;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.PerFeaturePostProcessing;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.Picking;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.PolylineArrow;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.PolylineDash;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.PolylinesOn3DTiles;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.PostProcessing;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.SampleHeightFrom3DTiles;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.Shadows;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.SkyAtmosphere;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.SpheresAndEllipsoids;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.Terrain;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.TerrainClippingPlanes;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.Tiles3DBIM;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.Tiles3DClippingPlanes;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.Tiles3DFeaturePicking;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.Tiles3DInspector;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.Tiles3DInterior;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.Tiles3DPhotogrammetry;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.Tiles3DPointCloud;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.TimeDynamicPointCloud;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.TimeDynamicWheels;
import org.cleanlogic.cesiumjs4gwt.showcase.puregwt.ShowcaseEventBus;
import org.cleanlogic.cesiumjs4gwt.showcase.puregwt.ShowcaseEventBusImpl;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class InjectorModule extends AbstractGinModule {

  @Override
  protected void configure() {
    bind(ShowcaseEventBus.class).to(ShowcaseEventBusImpl.class).in(Singleton.class);

    bind(Image.class).toProvider(ShowcaseLogoProvider.class).in(Singleton.class);
    bind(List.class).toProvider(ShowcaseBrandsProvider.class).in(Singleton.class);

    bind(GeometryAndAppearances.class).asEagerSingleton();
    bind(HelloWorld.class).asEagerSingleton();
    bind(Billboards.class).asEagerSingleton();
    bind(Models3D.class).asEagerSingleton();
    bind(Models3DColoring.class).asEagerSingleton();
    bind(SkyAtmosphere.class).asEagerSingleton();
    bind(Terrain.class).asEagerSingleton();
    bind(Picking.class).asEagerSingleton();
    bind(Camera.class).asEagerSingleton();
    bind(ImageryLayersManipulation.class).asEagerSingleton();
    bind(SpheresAndEllipsoids.class).asEagerSingleton();
    bind(GeoJSONAndTopoJSON.class).asEagerSingleton();
    bind(GeoJSONsimplestyle.class).asEagerSingleton();
    bind(Interpolation.class).asEagerSingleton();
    bind(Shadows.class).asEagerSingleton();
    bind(Clustering.class).asEagerSingleton();
    bind(CZML.class).asEagerSingleton();
    bind(CameraTutorial.class).asEagerSingleton();
    bind(CesiumInspector.class).asEagerSingleton();
    bind(Cardboard.class).asEagerSingleton();
    bind(ImageryAdjustment.class).asEagerSingleton();
    bind(ImageryLayers.class).asEagerSingleton();
    bind(KML.class).asEagerSingleton();
    bind(Materials.class).asEagerSingleton();
    bind(Labels.class).asEagerSingleton();
    bind(CustomGeocoder.class).asEagerSingleton();
    bind(CesiumNavigation.class).asEagerSingleton();
    bind(PolylineDash.class).asEagerSingleton();
    bind(GoogleEarthEnterprise.class).asEagerSingleton();
    bind(HeadingPitchRoll.class).asEagerSingleton();
    bind(ImageryLayersSplit.class).asEagerSingleton();
    bind(ParticleSystemFireworks.class).asEagerSingleton();
    bind(ParticleSystem.class).asEagerSingleton();
    bind(Drawing.class).asEagerSingleton();
    bind(Tiles3DFeaturePicking.class).asEagerSingleton();
    bind(Tiles3DBIM.class).asEagerSingleton();
    bind(Tiles3DPointCloud.class).asEagerSingleton();
    bind(Tiles3DInterior.class).asEagerSingleton();
    bind(Tiles3DPhotogrammetry.class).asEagerSingleton();
    bind(Tiles3DInspector.class).asEagerSingleton();
    bind(LoadImages.class).asEagerSingleton();
    bind(TerrainClippingPlanes.class).asEagerSingleton();
    bind(Tiles3DClippingPlanes.class).asEagerSingleton();
    bind(CustomBaseLayerPicker.class).asEagerSingleton();
    bind(CustomHomeButton.class).asEagerSingleton();
    bind(PolylineArrow.class).asEagerSingleton();
    bind(CallbackProperty.class).asEagerSingleton();
    bind(PostProcessing.class).asEagerSingleton();
    bind(AmbientOcclusion.class).asEagerSingleton();
    bind(Bloom.class).asEagerSingleton();
    bind(CustomPostProcess.class).asEagerSingleton();
    bind(DepthOfField.class).asEagerSingleton();
    bind(LensFlare.class).asEagerSingleton();
    bind(CustomPerFeaturePostProcess.class).asEagerSingleton();
    bind(PerFeaturePostProcessing.class).asEagerSingleton();
    bind(GroundPolylinePrimitive.class).asEagerSingleton();
    bind(DrawingOnTerrain.class).asEagerSingleton();
    bind(GeometryHeightReference.class).asEagerSingleton();
    bind(MultipleSyncedViews.class).asEagerSingleton();
    bind(TimeDynamicPointCloud.class).asEagerSingleton();
    bind(GroundAtmosphere.class).asEagerSingleton();
    bind(CartographicLimitRectangle.class).asEagerSingleton();
    bind(Clampto3DModel.class).asEagerSingleton();
    bind(Clampto3DTiles.class).asEagerSingleton();
    bind(ClamptoTerrain.class).asEagerSingleton();
    bind(ImageryCutout.class).asEagerSingleton();
    bind(SampleHeightFrom3DTiles.class).asEagerSingleton();
    bind(ImageBasedLighting.class).asEagerSingleton();
    bind(PolylinesOn3DTiles.class).asEagerSingleton();
    bind(TimeDynamicWheels.class).asEagerSingleton();
    bind(ImageryColorToAlpha.class).asEagerSingleton();

    bind(ExportKML.class).asEagerSingleton();
    bind(ArcGISTiledElevationTerrain.class).asEagerSingleton();
    bind(CZMLModelArticulations.class).asEagerSingleton();
  }
}
