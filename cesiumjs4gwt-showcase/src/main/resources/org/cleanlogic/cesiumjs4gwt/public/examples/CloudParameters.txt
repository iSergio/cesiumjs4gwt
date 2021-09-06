package org.cleanlogic.cesiumjs4gwt.showcase.examples;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.*;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.collections.CloudCollection;
import org.cesiumjs.cs.collections.options.CloudCollectionOptions;
import org.cesiumjs.cs.collections.options.CumulusCloudAddOptions;
import org.cesiumjs.cs.core.Cartesian2;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.scene.CumulusCloud;
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.widgets.Viewer;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.slider.Slider;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.slider.SliderEvent;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.slider.SliderListener;

import javax.inject.Inject;

public class CloudParameters extends AbstractExample {
    static final class ICloudParameters {
        boolean scaleWithMaximumSize = true;
        double scaleX = 25;
        double scaleY = 12;
        double maximumSizeX = 25;
        double maximumSizeY = 12;
        double maximumSizeZ = 15;
        boolean renderSlice = true; // if false, renders the entire surface of the ellipsoid
        double slice = 0.36;
        double brightness = 1.0;
    }

    ICloudParameters cloudParameters = new ICloudParameters();

    CumulusCloud cloud = null;

    CheckBox maxScaleCBox;
    HorizontalPanel scaleXHPanel;
    HorizontalPanel scaleYHPanel;
    Slider scaleXSlider;
    TextBox scaleXTBox;
    Slider scaleYSlider;
    TextBox scaleYTBox;
    Slider maxSizeXSlider;
    TextBox maxSizeXTBox;
    Slider maxSizeYSlider;
    TextBox maxSizeYTBox;
    Slider maxSizeZSlider;
    TextBox maxSizeZTBox;
    CheckBox renderSliceCBox;
    Slider sliceSlider;
    TextBox sliceTBox;
    Slider brightnessSlider;
    TextBox brightnessTBox;

    FlexTable flexTable;

    @Inject
    public CloudParameters(ShowcaseExampleStore store) {
        super("Cloud Parameters",
                "Modify the appearance of a procedural cumulus cloud",
                new String[]{"Showcase", "Cesium", "3d", "Clouds", "Params"}, store);
    }

    @Override
    public void buildPanel() {
        ViewerPanel csVPanel = new ViewerPanel();

        Viewer viewer = csVPanel.getViewer();
        Scene scene = viewer.scene();
        Cartesian3 position = Cartesian3.fromDegrees(-123.0744619, 44.0503706, 50);

        // These noise parameters are set to default, but can be changed
        // to produce different cloud results. However, the noise is precomputed,
        // so this cannot be changed dynamically.
        CloudCollectionOptions cloudCollectionOptions = new CloudCollectionOptions();
        cloudCollectionOptions.noiseDetail = 16.0;
        cloudCollectionOptions.noiseOffset = Cartesian3.ZERO();
        CloudCollection clouds = (CloudCollection) scene.primitives().add(new CloudCollection(cloudCollectionOptions));
        // Fix texture size
        // TODO: remove this fix after Cesium fixed them in core
        ((JsObject) (Object) clouds).setProperty("_noiseTextureLength", 64.0);
        Cesium.log(((JsObject) (Object) clouds).getNumber("_noiseTextureLength"));

        CumulusCloudAddOptions options = new CumulusCloudAddOptions();
        options.position = position;
        options.scale = new Cartesian2(cloudParameters.scaleX, cloudParameters.scaleY);
        options.maximumSize = new Cartesian3(cloudParameters.maximumSizeX, cloudParameters.maximumSizeY, cloudParameters.maximumSizeZ);
        options.slice = cloudParameters.renderSlice ? cloudParameters.slice : -1.0;
        options.brightness = cloudParameters.brightness;
        cloud = clouds.add(options);

        viewer.camera.lookAt(position, new Cartesian3(30, 30, -10));

        ChangeHandler handler = (event) -> {

        };

        maxScaleCBox = new CheckBox();
        maxScaleCBox.setWidth("100px");
        maxScaleCBox.setValue(true);
        maxScaleCBox.addValueChangeHandler(value -> {
            if (value.getValue()) {
                cloudParameters.scaleX = cloudParameters.maximumSizeX;
                cloudParameters.scaleY = cloudParameters.maximumSizeY;
            }
            visibleScaleXY(!value.getValue());
        });

        scaleXHPanel = new HorizontalPanel();
        scaleXHPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        scaleXHPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        scaleXHPanel.setSpacing(10);
        scaleXSlider = new Slider("scaleX", 5, 50, (int) cloudParameters.scaleX);
        scaleXSlider.setStep(1);
        scaleXSlider.setWidth("150px");
        scaleXSlider.addListener(new MSliderListener());
        scaleXTBox = new TextBox();
        scaleXTBox.addChangeHandler(handler);
        scaleXTBox.setText(cloudParameters.scaleX + "");
        scaleXTBox.setSize("30px", "12px");
        scaleXHPanel.add(scaleXSlider);
        scaleXHPanel.add(scaleXTBox);

        scaleYHPanel = new HorizontalPanel();
        scaleYHPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        scaleYHPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        scaleYHPanel.setSpacing(10);
        scaleYSlider = new Slider("scaleY", 5, 50, (int) cloudParameters.scaleY);
        scaleYSlider.setStep(1);
        scaleYSlider.setWidth("150px");
        scaleYSlider.addListener(new MSliderListener());
        scaleYTBox = new TextBox();
        scaleXTBox.addChangeHandler(handler);
        scaleYTBox.setText(cloudParameters.scaleY + "");
        scaleYTBox.setSize("30px", "12px");
        scaleYHPanel.add(scaleYSlider);
        scaleYHPanel.add(scaleYTBox);

        HorizontalPanel maxSizeXHPanel = new HorizontalPanel();
        maxSizeXHPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        maxSizeXHPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        maxSizeXHPanel.setSpacing(10);
        maxSizeXSlider = new Slider("maxSizeX", 5, 50, (int) cloudParameters.maximumSizeX);
        maxSizeXSlider.setStep(1);
        maxSizeXSlider.setWidth("150px");
        maxSizeXSlider.addListener(new MSliderListener());
        maxSizeXTBox = new TextBox();
        maxSizeXTBox.addChangeHandler(handler);
        maxSizeXTBox.setText(cloudParameters.maximumSizeX + "");
        maxSizeXTBox.setSize("30px", "12px");
        maxSizeXHPanel.add(maxSizeXSlider);
        maxSizeXHPanel.add(maxSizeXTBox);

        HorizontalPanel maxSizeYHPanel = new HorizontalPanel();
        maxSizeYHPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        maxSizeYHPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        maxSizeYHPanel.setSpacing(10);
        maxSizeYSlider = new Slider("maxSizeY", 5, 50, (int) cloudParameters.maximumSizeY);
        maxSizeYSlider.setStep(1);
        maxSizeYSlider.setWidth("150px");
        maxSizeYSlider.addListener(new MSliderListener());
        maxSizeYTBox = new TextBox();
        maxSizeYTBox.addChangeHandler(handler);
        maxSizeYTBox.setText(cloudParameters.maximumSizeY + "");
        maxSizeYTBox.setSize("30px", "12px");
        maxSizeYHPanel.add(maxSizeYSlider);
        maxSizeYHPanel.add(maxSizeYTBox);

        HorizontalPanel maxSizeZHPanel = new HorizontalPanel();
        maxSizeZHPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        maxSizeZHPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        maxSizeZHPanel.setSpacing(10);
        maxSizeZSlider = new Slider("maxSizeZ", 5, 50, (int) cloudParameters.maximumSizeZ);
        maxSizeZSlider.setStep(1);
        maxSizeZSlider.setWidth("150px");
        maxSizeZSlider.addListener(new MSliderListener());
        maxSizeZTBox = new TextBox();
        maxSizeZTBox.addChangeHandler(handler);
        maxSizeZTBox.setText(cloudParameters.maximumSizeZ + "");
        maxSizeZTBox.setSize("30px", "12px");
        maxSizeZHPanel.add(maxSizeZSlider);
        maxSizeZHPanel.add(maxSizeZTBox);

        renderSliceCBox = new CheckBox();
        renderSliceCBox.setWidth("100px");
        renderSliceCBox.setValue(true);
        renderSliceCBox.addValueChangeHandler(value -> {
            flexTable.getWidget(8, 0).setVisible(value.getValue());
            flexTable.getWidget(8, 1).setVisible(value.getValue());
        });

        HorizontalPanel sliceHPanel = new HorizontalPanel();
        sliceHPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        sliceHPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        sliceHPanel.setSpacing(10);
        sliceSlider = new Slider("slice", 0, 100, (int) (cloudParameters.slice * 100));
        sliceSlider.setStep(1);
        sliceSlider.setWidth("150px");
        sliceSlider.addListener(new MSliderListener());
        sliceTBox = new TextBox();
        sliceTBox.addChangeHandler(handler);
        sliceTBox.setText(cloudParameters.slice + "");
        sliceTBox.setSize("30px", "12px");
        sliceHPanel.add(sliceSlider);
        sliceHPanel.add(sliceTBox);

        HorizontalPanel brightnessHPanel = new HorizontalPanel();
        brightnessHPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        brightnessHPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        brightnessHPanel.setSpacing(10);
        brightnessSlider = new Slider("brightness", 0, 100, (int) (cloudParameters.brightness * 100));
        brightnessSlider.setStep(1);
        brightnessSlider.setWidth("150px");
        brightnessSlider.addListener(new MSliderListener());
        brightnessTBox = new TextBox();
        brightnessTBox.addChangeHandler(handler);
        brightnessTBox.setText(cloudParameters.brightness + "");
        brightnessTBox.setSize("30px", "12px");
        brightnessHPanel.add(brightnessSlider);
        brightnessHPanel.add(brightnessTBox);

        flexTable = new FlexTable();
        flexTable.setHTML(1, 0, "<font color=\"white\">Scale with Max Size</font>");
        flexTable.setWidget(1, 1, maxScaleCBox);
        flexTable.setWidget(2, 0, new HTML("<font color=\"white\">Scale X</font>"));
        flexTable.setWidget(2, 1, scaleXHPanel);
        flexTable.setWidget(3, 0, new HTML("<font color=\"white\">Scale Y</font>"));
        flexTable.setWidget(3, 1, scaleYHPanel);
        flexTable.setHTML(4, 0, "<font color=\"white\">Maximum Size X</font>");
        flexTable.setWidget(4, 1, maxSizeXHPanel);
        flexTable.setHTML(5, 0, "<font color=\"white\">Maximum Size Y</font>");
        flexTable.setWidget(5, 1, maxSizeYHPanel);
        flexTable.setHTML(6, 0, "<font color=\"white\">Maximum Size Z</font>");
        flexTable.setWidget(6, 1, maxSizeZHPanel);
        flexTable.setHTML(7, 0, "<font color=\"white\">Render Slice</font>");
        flexTable.setWidget(7, 1, renderSliceCBox);
        flexTable.setWidget(8, 0, new HTML("<font color=\"white\">Slice</font>"));
        flexTable.setWidget(8, 1, sliceHPanel);
        flexTable.setHTML(9, 0, "<font color=\"white\">Brightness</font>");
        flexTable.setWidget(9, 1, brightnessHPanel);

        visibleScaleXY(false);

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(flexTable, 20, 20);

        contentPanel.add(new HTML(
                "<p>Modify the appearance of a procedural cumulus cloud.</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);
    }

    private void visibleScaleXY(boolean visible) {
        flexTable.getWidget(2, 0).setVisible(visible);
        flexTable.getWidget(2, 1).setVisible(visible);
        flexTable.getWidget(3, 0).setVisible(visible);
        flexTable.getWidget(3, 1).setVisible(visible);
    }

    private class MSliderListener implements SliderListener {

        @Override
        public void onStart(SliderEvent e) {
            //
        }

        @Override
        public boolean onSlide(SliderEvent e) {
            Slider source = e.getSource();
            double value = source.getValue();
            if (source.equals(scaleXSlider)) {
                scaleXTBox.setText(String.valueOf(value));
                cloud.scale = new Cartesian2(value, cloud.scale.y);
            } else if (source.equals(scaleYSlider)) {
                scaleYTBox.setText(String.valueOf(value));
                cloud.scale = new Cartesian2(cloud.scale.x, value);
            } else if (source.equals(maxSizeXSlider)) {
                maxSizeXTBox.setText(String.valueOf(value));
                cloud.maximumSize = new Cartesian3(value, cloud.maximumSize.y, cloud.maximumSize.z);
                if (cloudParameters.scaleWithMaximumSize) {
                    cloud.scale = new Cartesian2(value, cloud.scale.y);
                }
            } else if (source.equals(maxSizeYSlider)) {
                maxSizeYTBox.setText(String.valueOf(value));
                cloud.maximumSize = new Cartesian3(cloud.maximumSize.x, value, cloud.maximumSize.z);
                if (cloudParameters.scaleWithMaximumSize) {
                    cloud.scale = new Cartesian2(cloud.scale.x, value);
                }
            } else if (source.equals(maxSizeZSlider)) {
                maxSizeZTBox.setText(String.valueOf(value));
                cloud.maximumSize = new Cartesian3(cloud.maximumSize.x, cloud.maximumSize.y, value);
            } else if (source.equals(sliceSlider)) {
                value /= 100;
                sliceTBox.setText(String.valueOf(value));
                cloud.slice = (float) value;
            } else if (source.equals(brightnessSlider)) {
                value /= 100;
                brightnessTBox.setText(String.valueOf(value));
                cloud.brightness = (float) value;
            }
            return true;
        }

        @Override
        public void onChange(SliderEvent e) {
            //
        }

        @Override
        public void onStop(SliderEvent e) {
            //
        }
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "CloudParameters.txt";
        return sourceCodeURLs;
    }
}
