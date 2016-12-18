# GWT Cesium Wrapper
[CesiumJS](http://cesiumjs.org) GWT Wrapper based on JsInterop for [GWT 2.8.0](http://www.gwtproject.org/release-notes.html#Release_Notes_2_8_0).

Java API looks like as JavaScript.
What was done:
- [x] CesiumJS API like as native JavaScript. Based on CesiumJS source code
- [x] Simple support Promise
- [x] Simple support Callback functions.
- [x] Full Cesium documentation in javadoc. You can see they on official [CesiumJS](http://cesiumjs.org/refdoc.html) or on site [gwt-cs Documentation](http://sergeserver.noip.me/docs/gwt-cs)
- [x] [Examples showcase](http://sergeserver.noip.me/gwt-cs-test/).
- [x] Integration with [gwt-olcs](https://github.com/iSergio/gwt-olcs)

### Issue
- [x] GXT work fine
- [x] GWT work fine
- [x] SmartGWT: ISC_DataBinding.js script destruct some functional of Cesium.js like as CesiumTerrain (what i find) (Fixed)

### Getting started
You not need include JavaScript of Cesium into main html file, injection realised in GWT code.
Now no need callback for ScriptInjection or AttachOrDetach, all worked "out from box".
See [Showcase](http://sergeserver.noip.me/gwt-cs-test/) or basic example:
```
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
