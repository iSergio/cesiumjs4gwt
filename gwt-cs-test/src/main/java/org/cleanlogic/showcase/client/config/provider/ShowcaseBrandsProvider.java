/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cleanlogic.showcase.client.config.provider;

import com.google.gwt.user.client.ui.Anchor;

import javax.inject.Provider;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iserge
 */
public class ShowcaseBrandsProvider implements Provider<List<Anchor>> {

    @Override
    public List<Anchor> get() {
        Anchor anchor = new Anchor("Ol3-Cesium");
        List<Anchor> list = new ArrayList<Anchor>();
        list.add(anchor);
        return list;
    }
}
