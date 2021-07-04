/**
 * Copyright 2015 sourceforge.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.cleanlogic.cesiumjs4gwt.showcase.config;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.user.client.ui.Image;
import org.cleanlogic.cesiumjs4gwt.showcase.config.provider.ShowcaseBrandsProvider;
import org.cleanlogic.cesiumjs4gwt.showcase.config.provider.ShowcaseLogoProvider;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.*;
import org.cleanlogic.cesiumjs4gwt.showcase.puregwt.ShowcaseEventBus;
import org.cleanlogic.cesiumjs4gwt.showcase.puregwt.ShowcaseEventBusImpl;

import javax.inject.Singleton;
import java.util.List;

/**
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
        bind(ElevationBandMaterial.class).asEagerSingleton();

        bind(ProceduralTerrain.class).asEagerSingleton();
    }
}
