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

package org.cesiumjs.linker;

import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.linker.EmittedArtifact;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class CesiumLinkerUtils {
    static String getContents(EmittedArtifact emittedArtifact, TreeLogger logger) throws UnableToCompleteException {
        InputStream in = emittedArtifact.getContents(logger);
        BufferedInputStream bis = new BufferedInputStream(in);
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        try {
            // Fix for SmartGWT. Thanks for Mark Erikson (https://groups.google.com/forum/#!msg/cesium-dev/ZfyW0CNRsSU/lP6KTaUpEQAJ)
            buf.write("if (window.buildInDataView === undefined) {window.buildInDataView = window.DataView;}\n".getBytes());
            int result = bis.read();
            while (result != -1) {
                byte b = (byte) result;
                buf.write(b);
                result = bis.read();

            }
        } catch (IOException e) {
            logger.log(TreeLogger.ERROR, "Unable to read resource", e);
            throw new UnableToCompleteException();
        }
        return buf.toString();
    }
}
