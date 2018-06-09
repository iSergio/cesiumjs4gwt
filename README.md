# GWT Cesium Wrapper
[CesiumJS](http://cesiumjs.org) GWT Wrapper based on JsInterop 1.0.2 for [GWT 2.8.x](http://www.gwtproject.org/release-notes.html#Release_Notes_2_8_2).

Java API looks like as JavaScript.
What was done:
- [x] CesiumJS API like as native JavaScript. Based on CesiumJS source code
- [x] Simple support Promise
- [x] Simple support Callback functions.
- [x] Full Cesium documentation in javadoc. You can see they on official [CesiumJS](http://cesiumjs.org/refdoc.html) or on site [gwt-cs Documentation](https://sergeserver.noip.me/docs/cesiumjs4gwt)
- [x] [Examples showcase](https://sergeserver.noip.me/cesiumjs4gwt-showcase/).
- [x] Integration with [gwt-olcs](https://github.com/iSergio/gwt-olcs)

### DrawInteraction features:
 - [x] Pure java (Based on JsInterop wrapper without any JS code)
 - [x] Based on Cesium-Drawhelper (But on GroundPrimitives)
 - [x] Free hand mode (Shift pressed)
 - [x] Two markers type - PointPrimitive and Billboard (Canvas image)
 - [x] Draw works on EllipsoidTerrainProvider and other TerrainProvider's
 - [x] Dynamic colours style and marker styles
 - [x] Start and End draw listeners
### DrawInteraction TODO:
 - [ ] On draw listeners (mouse move listeners and primitive change)
 - [ ] Snap points
 - [ ] Maximum points (finish draw on current points == maximumPoints)
 - [ ] Outline colour and width
 - [ ] EditInteraction
 - [ ] BillboardPrimitive
 - [ ] EllipsePrimitive

### Issue
- [x] GXT work fine
- [x] GWT work fine
- [x] SmartGWT: ISC_DataBinding.js script destruct some functional of Cesium.js like as CesiumTerrain (what i find) (Fixed)

### Getting started
You not need include JavaScript of Cesium into main html file, injection realised in GWT code.
Now no need callback for ScriptInjection or AttachOrDetach, all worked "out from box".
See [Showcase](https://sergeserver.noip.me/cesiumjs4gwt-showcase/) or basic example:
```java
public class HelloWorld extends AbstractExample {

    @Inject
    public HelloWorld(ShowcaseExampleStore store) {
        super("Hello World", "Use Viewer to start building new applications or easily embed Cesium into existing applications", new String[]{"Showcase", "Cesium", "3d", "Viewer"}, store);
    }

    @Override
    public void buildPanel() {
        // Create Cesium Viewer
        ViewerPanel csVPanel = new ViewerPanel();

        contentPanel.add(new HTML("<p>Use Viewer to start building new applications or easily embed Cesium into existing applications.</p>"));
        contentPanel.add(csVPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "HelloWorld.txt";
        return sourceCodeURLs;
    }
}
```
### Build library and examples:
==
You need Java 8 for build examples.
 * mvn -U clean install
 
This project will be used in [gwt-olcs](https://github.com/iSergio/gwt-olcs) and replace [Cesium GWT](https://github.com/richkadel/cesium-gwt)
