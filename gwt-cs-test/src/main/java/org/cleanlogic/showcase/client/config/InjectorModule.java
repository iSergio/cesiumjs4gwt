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
package org.cleanlogic.showcase.client.config;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.user.client.ui.Image;
import org.cleanlogic.showcase.client.config.provider.ShowcaseBrandsProvider;
import org.cleanlogic.showcase.client.config.provider.ShowcaseLogoProvider;
import org.cleanlogic.showcase.client.examples.*;
import org.cleanlogic.showcase.client.puregwt.ShowcaseEventBus;
import org.cleanlogic.showcase.client.puregwt.ShowcaseEventBusImpl;

import javax.inject.Singleton;
import java.util.List;

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
        bind(AtmosphereColor.class).asEagerSingleton();
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
        bind(Tiles3DFeaturePicking.class).asEagerSingleton();
        bind(Tiles3DBIM.class).asEagerSingleton();
        bind(Tiles3DPointCloud.class).asEagerSingleton();
        bind(Tiles3DInterior.class).asEagerSingleton();
        bind(Tiles3DPhotogrammetry.class).asEagerSingleton();
        bind(Tiles3DInspector.class).asEagerSingleton();
    }
}
