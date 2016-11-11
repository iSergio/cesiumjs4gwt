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

### Getting started
You not need include JavaScript of Cesium into main html file, injection realised in GWT code.
See [Showcase](http://sergeserver.noip.me/gwt-cs-test/) or basic example:
```
private class ViewerPanel implements IsWidget {
    private ViewerPanelAbstract _csPanelAbstract;
    private ViewerPanel() {
        super();
        asWidget();
    }

    @Override
    public Widget asWidget() {
        if (_csPanelAbstract == null) {
            final Configuration csConfiguration = new Configuration();
            csConfiguration.setPath(GWT.getModuleBaseURL() + "JavaScript/Cesium");
            _csPanelAbstract = new ViewerPanelAbstract(csConfiguration) {
                @Override
                public Viewer createViewer(Element element) {
                    Viewer csViewer = new Viewer(element);
                    return csViewer;
                }
            };
        }
        return _csPanelAbstract;
    }
}
```
### Build library and examples:
==
You need Java 8 for build examples.
 * mvn -U clean install
 
This project will be used in [gwt-olcs](https://github.com/iSergio/gwt-olcs) and replace [Cesium GWT](https://github.com/richkadel/cesium-gwt)
