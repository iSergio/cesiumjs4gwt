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

package org.cesiumjs.cs.core;

import jsinterop.annotations.*;
import org.cesiumjs.cs.core.options.ColorRandomOptions;

/**
 * A color, specified using red, green, blue, and alpha values, which range from 0 (no intensity) to 1.0 (full intensity).
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Color")
public class Color {
    /**
     * An immutable Color instance initialized to CSS color #F0F8FF
     */
    @JsProperty(name = "ALICEBLUE")
    public static native Color ALICEBLUE();
    /**
     * An immutable Color instance initialized to CSS color #FAEBD7
     */
    @JsProperty(name = "ANTIQUEWHITE")
    public static native Color ANTIQUEWHITE();
    /**
     * An immutable Color instance initialized to CSS color #00FFFF
     */
    @JsProperty(name = "AQUA")
    public static native Color AQUA();
    /**
     * An immutable Color instance initialized to CSS color #7FFFD4
     */
    @JsProperty(name = "AQUAMARINE")
    public static native Color AQUAMARINE();

    /**
     * An immutable Color instance initialized to CSS color #F0FFFF
     */
    @JsProperty(name = "AZURE")
    public static native Color AZURE();
    /**
     * An immutable Color instance initialized to CSS color #F5F5DC
     */
    @JsProperty(name = "BEIGE")
    public static native Color BEIGE();
    /**
     * An immutable Color instance initialized to CSS color #FFE4C4
     */
    @JsProperty(name = "BISQUE")
    public static native Color BISQUE();
    /**
     * An immutable Color instance initialized to CSS color #000000
     */
    @JsProperty(name = "BLACK")
    public static native Color BLACK();
    /**
     * An immutable Color instance initialized to CSS color #FFEBCD
     */
    @JsProperty(name = "BLANCHEDALMOND")
    public static native Color BLANCHEDALMOND();
    /**
     * An immutable Color instance initialized to CSS color #0000FF
     */
    @JsProperty(name = "BLUE")
    public static native Color BLUE();
    /**
     * An immutable Color instance initialized to CSS color #8A2BE2
     */
    @JsProperty(name = "BLUEVIOLET")
    public static native Color BLUEVIOLET();
    /**
     * An immutable Color instance initialized to CSS color #A52A2A
     */
    @JsProperty(name = "BROWN")
    public static native Color BROWN();
    /**
     * An immutable Color instance initialized to CSS color #DEB887
     */
    @JsProperty(name = "BURLYWOOD")
    public static native Color BURLYWOOD();
    /**
     * An immutable Color instance initialized to CSS color #5F9EA0
     */
    @JsProperty(name = "CADETBLUE")
    public static native Color CADETBLUE();
    /**
     * An immutable Color instance initialized to CSS color #7FFF00
     */
    @JsProperty(name = "CHARTREUSE")
    public static native Color CHARTREUSE();
    /**
     * An immutable Color instance initialized to CSS color #D2691E
     */
    @JsProperty(name = "CHOCOLATE")
    public static native Color CHOCOLATE();
    /**
     * An immutable Color instance initialized to CSS color #FF7F50
     */
    @JsProperty(name = "CORAL")
    public static native Color CORAL();
    /**
     * An immutable Color instance initialized to CSS color #6495ED
     */
    @JsProperty(name = "CORNFLOWERBLUE")
    public static native Color CORNFLOWERBLUE();
    /**
     * An immutable Color instance initialized to CSS color #FFF8DC
     */
    @JsProperty(name = "CORNSILK")
    public static native Color CORNSILK();
    /**
     * An immutable Color instance initialized to CSS color #DC143C
     */
    @JsProperty(name = "CRIMSON")
    public static native Color CRIMSON();
    /**
     * An immutable Color instance initialized to CSS color #00FFFF
     */
    @JsProperty(name = "CYAN")
    public static native Color CYAN();
    /**
     * An immutable Color instance initialized to CSS color #00008B
     */
    @JsProperty(name = "DARKBLUE")
    public static native Color DARKBLUE();
    /**
     * An immutable Color instance initialized to CSS color #008B8B
     */
    @JsProperty(name = "DARKCYAN")
    public static native Color DARKCYAN();
    /**
     * An immutable Color instance initialized to CSS color #B8860B
     */
    @JsProperty(name = "DARKGOLDENROD")
    public static native Color DARKGOLDENROD();
    /**
     * An immutable Color instance initialized to CSS color #A9A9A9
     */
    @JsProperty(name = "DARKGRAY")
    public static native Color DARKGRAY();
    /**
     * An immutable Color instance initialized to CSS color #006400
     */
    @JsProperty(name = "DARKGREEN")
    public static native Color DARKGREEN();
    /**
     * An immutable Color instance initialized to CSS color #A9A9A9
     */
    @JsProperty(name = "DARKGREY")
    public static native Color DARKGREY();
    /**
     * An immutable Color instance initialized to CSS color #BDB76B
     */
    @JsProperty(name = "DARKKHAKI")
    public static native Color DARKKHAKI();
    /**
     * An immutable Color instance initialized to CSS color #8B008B
     */
    @JsProperty(name = "DARKMAGENTA")
    public static native Color DARKMAGENTA();
    /**
     * An immutable Color instance initialized to CSS color #556B2F
     */
    @JsProperty(name = "DARKOLIVEGREEN")
    public static native Color DARKOLIVEGREEN();
    /**
     * An immutable Color instance initialized to CSS color #FF8C00
     */
    @JsProperty(name = "DARKORANGE")
    public static native Color DARKORANGE();
    /**
     * An immutable Color instance initialized to CSS color #9932CC
     */
    @JsProperty(name = "DARKORCHID")
    public static native Color DARKORCHID();
    /**
     * An immutable Color instance initialized to CSS color #8B0000
     */
    @JsProperty(name = "DARKRED")
    public static native Color DARKRED();
    /**
     * An immutable Color instance initialized to CSS color #E9967A
     */
    @JsProperty(name = "DARKSALMON")
    public static native Color DARKSALMON();
    /**
     * An immutable Color instance initialized to CSS color #8FBC8F
     */
    @JsProperty(name = "DARKSEAGREEN")
    public static native Color DARKSEAGREEN();
    /**
     * An immutable Color instance initialized to CSS color #483D8B
     */
    @JsProperty(name = "DARKSLATEBLUE")
    public static native Color DARKSLATEBLUE();
    /**
     * An immutable Color instance initialized to CSS color #2F4F4F
     */
    @JsProperty(name = "DARKSLATEGRAY")
    public static native Color DARKSLATEGRAY();
    /**
     * An immutable Color instance initialized to CSS color #2F4F4F
     */
    @JsProperty(name = "DARKSLATEGREY")
    public static native Color DARKSLATEGREY();
    /**
     * An immutable Color instance initialized to CSS color #00CED1
     */
    @JsProperty(name = "DARKTURQUOISE")
    public static native Color DARKTURQUOISE();
    /**
     * An immutable Color instance initialized to CSS color #9400D3
     */
    @JsProperty(name = "DARKVIOLET")
    public static native Color DARKVIOLET();
    /**
     * An immutable Color instance initialized to CSS color #FF1493
     */
    @JsProperty(name = "DEEPPINK")
    public static native Color DEEPPINK();
    /**
     * An immutable Color instance initialized to CSS color #00BFFF
     */
    @JsProperty(name = "DEEPSKYBLUE")
    public static native Color DEEPSKYBLUE();
    /**
     * An immutable Color instance initialized to CSS color #696969
     */
    @JsProperty(name = "DIMGRAY")
    public static native Color DIMGRAY();
    /**
     * An immutable Color instance initialized to CSS color #696969
     */
    @JsProperty(name = "DIMGREY")
    public static native Color DIMGREY();
    /**
    * An immutable Color instance initialized to CSS color #1E90FF
    */
    @JsProperty(name = "DODGERBLUE")
    public static native Color DODGERBLUE();
    /**
     * An immutable Color instance initialized to CSS color #B22222
     */
    @JsProperty(name = "FIREBRICK")
    public static native Color FIREBRICK();
    /**
     * An immutable Color instance initialized to CSS color #FFFAF0
     */
    @JsProperty(name = "FLORALWHITE")
    public static native Color FLORALWHITE();
    /**
     * An immutable Color instance initialized to CSS color #228B22
     */
    @JsProperty(name = "FORESTGREEN")
    public static native Color FORESTGREEN();
    /**
     * An immutable Color instance initialized to CSS color #FF00FF
     */
    @JsProperty(name = "FUCHSIA")
    public static native Color FUCHSIA();
    /**
     * An immutable Color instance initialized to CSS color #DCDCDC
     */
    @JsProperty(name = "GAINSBORO")
    public static native Color GAINSBORO();
    /**
     * An immutable Color instance initialized to CSS color #F8F8FF
     */
    @JsProperty(name = "GHOSTWHITE")
    public static native Color GHOSTWHITE();

    /**
     * An immutable Color instance initialized to CSS color #FFD700
     */
    @JsProperty(name = "GOLD")
    public static native Color GOLD();
    /**
    * An immutable Color instance initialized to CSS color #DAA520
    */
    @JsProperty(name = "GOLDENROD")
    public static native Color GOLDENROD();
    /**
     * An immutable Color instance initialized to CSS color #808080
     */
    @JsProperty(name = "GRAY")
    public static native Color GRAY();
    /**
     * An immutable Color instance initialized to CSS color #008000
     */
    @JsProperty(name = "GREEN")
    public static native Color GREEN();
    /**
     * An immutable Color instance initialized to CSS color #ADFF2F
     */
    @JsProperty(name = "GREENYELLOW")
    public static native Color GREENYELLOW();
    /**
     * An immutable Color instance initialized to CSS color #808080
     */
    @JsProperty(name = "GREY")
    public static native Color GREY();
    /**
     * An immutable Color instance initialized to CSS color #F0FFF0
     */
    @JsProperty(name = "HONEYDEW")
    public static native Color HONEYDEW();
    /**
     * An immutable Color instance initialized to CSS color #FF69B4
     */
    @JsProperty(name = "HOTPINK")
    public static native Color HOTPINK();
    /**
     * An immutable Color instance initialized to CSS color #CD5C5C
     */
    @JsProperty(name = "INDIANRED")
    public static native Color INDIANRED();
    /**
     * An immutable Color instance initialized to CSS color #4B0082
     */
    @JsProperty(name = "INDIGO")
    public static native Color INDIGO();
    /**
     * An immutable Color instance initialized to CSS color #FFFFF0
     */
    @JsProperty(name = "IVORY")
    public static native Color IVORY();
    /**
     * An immutable Color instance initialized to CSS color #F0E68C
     */
    @JsProperty(name = "KHAKI")
    public static native Color KHAKI();
    /**
     * An immutable Color instance initialized to CSS color #FFF0F5
     */
    @JsProperty(name = "LAVENDAR_BLUSH")
    public static native Color LAVENDAR_BLUSH();
    /**
     * An immutable Color instance initialized to CSS color #E6E6FA
     */
    @JsProperty(name = "LAVENDER")
    public static native Color LAVENDER();
    /**
     * An immutable Color instance initialized to CSS color #7CFC00
     */
    @JsProperty(name = "LAWNGREEN")
    public static native Color LAWNGREEN();
    /**
     * An immutable Color instance initialized to CSS color #FFFACD
     */
    @JsProperty(name = "LEMONCHIFFON")
    public static native Color LEMONCHIFFON();
    /**
     * An immutable Color instance initialized to CSS color #ADD8E6
     */
    @JsProperty(name = "LIGHTBLUE")
    public static native Color LIGHTBLUE();
    /**
     * An immutable Color instance initialized to CSS color #F08080
     */
    @JsProperty(name = "LIGHTCORAL")
    public static native Color LIGHTCORAL();
    /**
     * An immutable Color instance initialized to CSS color #E0FFFF
     */
    @JsProperty(name = "LIGHTCYAN")
    public static native Color LIGHTCYAN();
    /**
     * An immutable Color instance initialized to CSS color #FAFAD2
     */
    @JsProperty(name = "LIGHTGOLDENRODYELLOW")
    public static native Color LIGHTGOLDENRODYELLOW();
    /**
     * An immutable Color instance initialized to CSS color #D3D3D3
     */
    @JsProperty(name = "LIGHTGRAY")
    public static native Color LIGHTGRAY();
    /**
     * An immutable Color instance initialized to CSS color #90EE90
     */
    @JsProperty(name = "LIGHTGREEN")
    public static native Color LIGHTGREEN();
    /**
     * An immutable Color instance initialized to CSS color #D3D3D3
     */
    @JsProperty(name = "LIGHTGREY")
    public static native Color LIGHTGREY();
    /**
     * An immutable Color instance initialized to CSS color #FFB6C1
     */
    @JsProperty(name = "LIGHTPINK")
    public static native Color LIGHTPINK();
    /**
     * An immutable Color instance initialized to CSS color #20B2AA
     */
    @JsProperty(name = "LIGHTSEAGREEN")
    public static native Color LIGHTSEAGREEN();
    /**
     * An immutable Color instance initialized to CSS color #87CEFA
     */
    @JsProperty(name = "LIGHTSKYBLUE")
    public static native Color LIGHTSKYBLUE();
    /**
     * An immutable Color instance initialized to CSS color #778899
     */
    @JsProperty(name = "LIGHTSLATEGRAY")
    public static native Color LIGHTSLATEGRAY();
    /**
     * An immutable Color instance initialized to CSS color #778899
     */
    @JsProperty(name = "LIGHTSLATEGREY")
    public static native Color LIGHTSLATEGREY();
    /**
     * An immutable Color instance initialized to CSS color #B0C4DE
     */
    @JsProperty(name = "LIGHTSTEELBLUE")
    public static native Color LIGHTSTEELBLUE();
    /**
     * An immutable Color instance initialized to CSS color #FFFFE0
     */
    @JsProperty(name = "LIGHTYELLOW")
    public static native Color LIGHTYELLOW();
    /**
     * An immutable Color instance initialized to CSS color #00FF00
     */
    @JsProperty(name = "LIME")
    public static native Color LIME();
    /**
     * An immutable Color instance initialized to CSS color #32CD32
     */
    @JsProperty(name = "LIMEGREEN")
    public static native Color LIMEGREEN();
    /**
     * An immutable Color instance initialized to CSS color #FAF0E6
     */
    @JsProperty(name = "LINEN")
    public static native Color LINEN();
    /**
     * An immutable Color instance initialized to CSS color #FF00FF
     */
    @JsProperty(name = "MAGENTA")
    public static native Color MAGENTA();
    /**
     * An immutable Color instance initialized to CSS color #800000
     */
    @JsProperty(name = "MAROON")
    public static native Color MAROON();
    /**
     * An immutable Color instance initialized to CSS color #66CDAA
     */
    @JsProperty(name = "MEDIUMAQUAMARINE")
    public static native Color MEDIUMAQUAMARINE();
    /**
     * An immutable Color instance initialized to CSS color #0000CD
     */
    @JsProperty(name = "MEDIUMBLUE")
    public static native Color MEDIUMBLUE();
    /**
     * An immutable Color instance initialized to CSS color #BA55D3
     */
    @JsProperty(name = "MEDIUMORCHID")
    public static native Color MEDIUMORCHID();
    /**
     * An immutable Color instance initialized to CSS color #9370DB
     */
    @JsProperty(name = "MEDIUMPURPLE")
    public static native Color MEDIUMPURPLE();
    /**
     * An immutable Color instance initialized to CSS color #3CB371
     */
    @JsProperty(name = "MEDIUMSEAGREEN")
    public static native Color MEDIUMSEAGREEN();
    /**
     * An immutable Color instance initialized to CSS color #7B68EE
     */
    @JsProperty(name = "MEDIUMSLATEBLUE")
    public static native Color MEDIUMSLATEBLUE();
    /**
     * An immutable Color instance initialized to CSS color #00FA9A
     */
    @JsProperty(name = "MEDIUMSPRINGGREEN")
    public static native Color MEDIUMSPRINGGREEN();
    /**
     * An immutable Color instance initialized to CSS color #48D1CC
     */
    @JsProperty(name = "MEDIUMTURQUOISE")
    public static native Color MEDIUMTURQUOISE();
    /**
     * An immutable Color instance initialized to CSS color #C71585
     */
    @JsProperty(name = "MEDIUMVIOLETRED")
    public static native Color MEDIUMVIOLETRED();
    /**
     * An immutable Color instance initialized to CSS color #191970
     */
    @JsProperty(name = "MIDNIGHTBLUE")
    public static native Color MIDNIGHTBLUE();
    /**
     * An immutable Color instance initialized to CSS color #F5FFFA
    */
    @JsProperty(name = "MINTCREAM")
    public static native Color MINTCREAM();
    /**
     * An immutable Color instance initialized to CSS color #FFE4E1
     */
    @JsProperty(name = "MISTYROSE")
    public static native Color MISTYROSE();
    /**
     * An immutable Color instance initialized to CSS color #FFE4B5
     */
    @JsProperty(name = "MOCCASIN")
    public static native Color MOCCASIN();
    /**
     * An immutable Color instance initialized to CSS color #FFDEAD
     */
    @JsProperty(name = "NAVAJOWHITE")
    public static native Color NAVAJOWHITE();
    /**
     * An immutable Color instance initialized to CSS color #000080
     */
    @JsProperty(name = "NAVY")
    public static native Color NAVY();
    /**
     *  An immutable Color instance initialized to CSS color #FDF5E6
     */
    @JsProperty(name = "OLDLACE")
    public static native Color OLDLACE();
    /**
     * An immutable Color instance initialized to CSS color #808000
     */
    @JsProperty(name = "OLIVE")
    public static native Color OLIVE();
    /**
     * An immutable Color instance initialized to CSS color #6B8E23
     */
    @JsProperty(name = "OLIVEDRAB")
    public static native Color OLIVEDRAB();
    /**
     * An immutable Color instance initialized to CSS color #FFA500
     */
    @JsProperty(name = "ORANGE")
    public static native Color ORANGE();
    /**
     * An immutable Color instance initialized to CSS color #FF4500
     */
    @JsProperty(name = "ORANGERED")
    public static native Color ORANGERED();
    /**
     * An immutable Color instance initialized to CSS color #DA70D6
     */
    @JsProperty(name = "ORCHID")
    public static native Color ORCHID();
    /**
     * An immutable Color instance initialized to CSS color #EEE8AA
     */
    @JsProperty(name = "PALEGOLDENROD")
    public static native Color PALEGOLDENROD();
    /**
     * An immutable Color instance initialized to CSS color #98FB98
     */
    @JsProperty(name = "PALEGREEN")
    public static native Color PALEGREEN();
    /**
     * An immutable Color instance initialized to CSS color #AFEEEE
     */
    @JsProperty(name = "PALETURQUOISE")
    public static native Color PALETURQUOISE();
    /**
     * An immutable Color instance initialized to CSS color #DB7093
     */
    @JsProperty(name = "PALEVIOLETRED")
    public static native Color PALEVIOLETRED();
    /**
     * An immutable Color instance initialized to CSS color #FFEFD5
     */
    @JsProperty(name = "PAPAYAWHIP")
    public static native Color PAPAYAWHIP();
    /**
     * An immutable Color instance initialized to CSS color #FFDAB9
     */
    @JsProperty(name = "PEACHPUFF")
    public static native Color PEACHPUFF();
    /**
     * An immutable Color instance initialized to CSS color #CD853F
     */
    @JsProperty(name = "PERU")
    public static native Color PERU();
    /**
     * An immutable Color instance initialized to CSS color #FFC0CB
     */
    @JsProperty(name = "PINK")
    public static native Color PINK();
    /**
     * An immutable Color instance initialized to CSS color #DDA0DD
     */
    @JsProperty(name = "PLUM")
    public static native Color PLUM();
    /**
     * An immutable Color instance initialized to CSS color #B0E0E6
     */
    @JsProperty(name = "POWDERBLUE")
    public static native Color POWDERBLUE();
    /**
     * An immutable Color instance initialized to CSS color #800080
     */
    @JsProperty(name = "PURPLE")
    public static native Color PURPLE();
    /**
     * An immutable Color instance initialized to CSS color #FF0000
     */
    @JsProperty(name = "RED")
    public static native Color RED();
    /**
     * An immutable Color instance initialized to CSS color #BC8F8F
     */
    @JsProperty(name = "ROSYBROWN")
    public static native Color ROSYBROWN();
    /**
     * An immutable Color instance initialized to CSS color #4169E1
     */
    @JsProperty(name = "ROYALBLUE")
    public static native Color ROYALBLUE();
    /**
     * An immutable Color instance initialized to CSS color #8B4513
     */
    @JsProperty(name = "SADDLEBROWN")
    public static native Color SADDLEBROWN();
    /**
     * An immutable Color instance initialized to CSS color #FA8072
     */
    @JsProperty(name = "SALMON")
    public static native Color SALMON();
    /**
     * An immutable Color instance initialized to CSS color #F4A460
     */
    @JsProperty(name = "SANDYBROWN")
    public static native Color SANDYBROWN();
    /**
     * An immutable Color instance initialized to CSS color #2E8B57
     */
    @JsProperty(name = "SEAGREEN")
    public static native Color SEAGREEN();
    /**
     * An immutable Color instance initialized to CSS color #FFF5EE
     */
    @JsProperty(name = "SEASHELL")
    public static native Color SEASHELL();
    /**
     * An immutable Color instance initialized to CSS color #A0522D
     */
    @JsProperty(name = "SIENNA")
    public static native Color SIENNA();
    /**
     * An immutable Color instance initialized to CSS color #C0C0C0
     */
    @JsProperty(name = "SILVER")
    public static native Color SILVER();
    /**
     * An immutable Color instance initialized to CSS color #87CEEB
     */
    @JsProperty(name = "SKYBLUE")
    public static native Color SKYBLUE();
    /**
     * An immutable Color instance initialized to CSS color #6A5ACD
     */
    @JsProperty(name = "SLATEBLUE")
    public static native Color SLATEBLUE();
    /**
     * An immutable Color instance initialized to CSS color #708090
     */
    @JsProperty(name = "SLATEGRAY")
    public static native Color SLATEGRAY();
    /**
     * An immutable Color instance initialized to CSS color #708090
     */
    @JsProperty(name = "SLATEGREY")
    public static native Color SLATEGREY();
    /**
     * An immutable Color instance initialized to CSS color #FFFAFA
     */
    @JsProperty(name = "SNOW")
    public static native Color SNOW();
    /**
     * An immutable Color instance initialized to CSS color #00FF7F
     */
    @JsProperty(name = "SPRINGGREEN")
    public static native Color SPRINGGREEN();
    /**
     * An immutable Color instance initialized to CSS color #4682B4
     */
    @JsProperty(name = "STEELBLUE")
    public static native Color STEELBLUE();
    /**
     * An immutable Color instance initialized to CSS color #D2B48C
     */
    @JsProperty(name = "TAN")
    public static native Color TAN();
    /**
     * An immutable Color instance initialized to CSS color #008080
     */
    @JsProperty(name = "TEAL")
    public static native Color TEAL();
    /**
     * An immutable Color instance initialized to CSS color #D8BFD8
     */
    @JsProperty(name = "THISTLE")
    public static native Color THISTLE();
    /**
     * An immutable Color instance initialized to CSS color #FF6347
     */
    @JsProperty(name = "TOMATO")
    public static native Color TOMATO();
    /**
     * An immutable Color instance initialized to CSS transparent.
     */
    @JsProperty(name = "TRANSPARENT")
    public static native Color TRANSPARENT();
    /**
     * An immutable Color instance initialized to CSS color #40E0D0
     */
    @JsProperty(name = "TURQUOISE")
    public static native Color TURQUOISE();
    /**
     * An immutable Color instance initialized to CSS color #EE82EE
     */
    @JsProperty(name = "VIOLET")
    public static native Color VIOLET();
    /**
     * An immutable Color instance initialized to CSS color #F5DEB3
     */
    @JsProperty(name = "WHEAT")
    public static native Color WHEAT();
    /**
     * An immutable Color instance initialized to CSS color #FFFFFF
     */
    @JsProperty(name = "WHITE")
    public static native Color WHITE();
    /**
     * An immutable Color instance initialized to CSS color #F5F5F5
     */
    @JsProperty(name = "WHITESMOKE")
    public static native Color WHITESMOKE();
    /**
     * An immutable Color instance initialized to CSS color #FFFF00
     */
    @JsProperty(name = "YELLOW")
    public static native Color YELLOW();
    /**
     * An immutable Color instance initialized to CSS color #9ACD32
     */
    @JsProperty(name = "YELLOWGREEN")
    public static native Color YELLOWGREEN();
    /**
     * The alpha component.
     * Default: 1.0
     */
    @JsProperty
    public double alpha;
    /**
     * The blue component.
     * Default: 1.0
     */
    @JsProperty
    public double blue;
    /**
     * The green component.
     * Default: 1.0
     */
    @JsProperty
    public double green;
    /**
     * The red component.
     * Default: 1.0
     */
    @JsProperty
    public double red;
    /**
     * The number of elements used to pack the object into an array.
     */
    @JsProperty
    public static double packedLength;

    /**
     * A color, specified using red, green, blue, and alpha values, which range from 0 (no intensity) to 1.0 (full intensity).
     * (1.0, 1.0, 1.0, 1.0)
     */
    @JsConstructor
    public Color() {}

    /**
     * A color, specified using red, green, blue, and alpha values, which range from 0 (no intensity) to 1.0 (full intensity).
     * @param red The red component.
     * @param green The green component.
     * @param blue The blue component.
     * @param alpha The alpha component.
     */
    @JsConstructor
    public Color(double red, double green, double blue, double alpha) {}

    /**
     * Computes the componentwise sum of two Colors.
     * @param left The first Color.
     * @param right The second Color.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Color add(Color left, Color right);

    /**
     * Computes the componentwise sum of two Colors.
     * @param left The first Color.
     * @param right The second Color.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Color add(Color left, Color right, Color result);

    /**
     * Converts a 'byte' color component in the range of 0 to 255 into a 'float' color component in the range of 0 to 1.0.
     * @param number The number to be converted.
     * @return The converted number.
     */
    @JsMethod
    public static native float byteToFloat(int number);

    /**
     * Duplicates a Color.
     * @param color The Color to duplicate.
     * @param result The object to store the result in, if undefined a new instance will be created. Optional.
     * @return The modified result parameter or a new instance if result was undefined. (Returns undefined if color is undefined)
     */
    @JsMethod
    public static native Color clone(Color color, Color result);

    /**
     * Computes the componentwise quotient of two Colors.
     * @param left The first Color.
     * @param right The second Color.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Color divide(Color left, Color right);

    /**
     * Computes the componentwise quotient of two Colors.
     * @param left The first Color.
     * @param right The second Color.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Color divide(Color left, Color right, Color result);

    /**
     * Divides the provided Color componentwise by the provided scalar.
     * @param color The Color to be divided.
     * @param scalar The scalar to divide with.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Color divideByScalar(Color color, double scalar);

    /**
     * Divides the provided Color componentwise by the provided scalar.
     * @param color The Color to be divided.
     * @param scalar The scalar to divide with.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Color divideByScalar(Color color, double scalar, Color result);

    /**
     * Returns true if the first Color equals the second color.
     * @param left The first Color to compare for equality.
     * @param right The second Color to compare for equality.
     * @return true if the Colors are equal; otherwise, false.
     */
    @JsMethod
    public static native boolean equals(Color left, Color right);

    /**
     * Converts a 'float' color component in the range of 0 to 1.0 into a 'byte' color component in the range of 0 to 255.
     * @param number The number to be converted.
     * @return The converted number.
     */
    @JsMethod
    public static native int floatToByte(float number);

    /**
     * Creates a new Color that has the same red, green, and blue components of the specified color, but with the specified alpha value.
     * <pre>
     *     {@code
     *     Color translucentRed = Color.fromAlpha(Color.RED(), 0.9);
     *     }
     * </pre>
     * @param color The base color
     * @param alpha The new alpha component.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new Color instance if one was not provided.
     */
    @JsMethod
    public static native Color fromAlpha(Color color, double alpha, Color result);

    /**
     * Creates a new Color specified using red, green, blue, and alpha values that are in the range of 0 to 255, converting them internally to a range of 0.0 to 1.0.
     * @param red The red component.
     * @param green The green component.
     * @param blue The blue component.
     * @param alpha The alpha component.
     * @return The modified result parameter or a new Color instance if one was not provided.
     */
    @JsMethod
    public static native Color fromBytes(int red, int green, int blue, int alpha);

    /**
     * Creates a new Color specified using red, green, blue, and alpha values that are in the range of 0 to 255, converting them internally to a range of 0.0 to 1.0.
     * @param red The red component.
     * @param green The green component.
     * @param blue The blue component.
     * @param alpha The alpha component.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new Color instance if one was not provided.
     */
    @JsMethod
    public static native Color fromBytes(int red, int green, int blue, int alpha, Color result);

    /**
     *  Creates a Color instance from a Cartesian4. x, y, z, and w map to red, green, blue, and alpha, respectively.
     * @param cartesian The source cartesian.
     * @return The modified result parameter or a new Color instance if one was not provided.
     */
    @JsMethod
    public static native Color fromCartesian4(Cartesian4 cartesian);

    /**
     *  Creates a Color instance from a Cartesian4. x, y, z, and w map to red, green, blue, and alpha, respectively.
     * @param cartesian The source cartesian.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new Color instance if one was not provided.
     */
    @JsMethod
    public static native Color fromCartesian4(Cartesian4 cartesian, Color result);

    /**
     * Creates a Color instance from a CSS color value.
     * <pre>
     *     {@code
     *         Color cesiumBlue = Color.fromCssColorString("#67ADDF");
     *         Color green = Color.fromCssColorString("green");
     *     }
     * </pre>
     * @param color The CSS color value in #rgb, #rrggbb, rgb(), rgba(), hsl(), or hsla() format.
     * @param result The object to store the result in, if undefined a new instance will be created.
     * @return The color object, or undefined if the string was not a valid CSS color.
     * @see <a href="http://www.w3.org/TR/css3-color">CSS color values</a>
     */
    @JsMethod
    public static native Color fromCssColorString(String color, Color result);

    /**
     * Creates a Color instance from hue, saturation, and lightness.
     * @param hue The hue angle 0...1
     * @param saturation The saturation value 0...1
     * @param lightness The lightness value 0...1
     * @param alpha The alpha component 0...1
     * @param result The object to store the result in, if undefined a new instance will be created.
     * @return The color object.
     * @see <a href="https://www.w3.org/TR/css3-color/#hsl-color">CSS color values</a>
     */
    @JsMethod
    public static native Color fromHsl(float hue, float saturation, float lightness, float alpha, Color result);

    /**
     * Creates a random color using the provided options. For reproducible random colors, you should call
     * CesiumMath#setRandomNumberSeed once at the beginning of your application.
     * <pre>
     *     Example:
     *     {@code
     *     //Create a completely random color
     *     Color color = Color.fromRandom();
     *     }
     * </pre>
     * @return The modified result parameter or a new instance if result was undefined.
     */
    @JsMethod
    public static native Color fromRandom();

    /**
     * Creates a random color using the provided options. For reproducible random colors, you should call
     * CesiumMath#setRandomNumberSeed once at the beginning of your application.
     * <pre>
     *     {@code
     *         //Create a random shade of yellow.
     *         ColorRandomOptions options = new ColorRandomOptions();
     *         options.red = 1.0f;
     *         options.green = 1.0f;
     *         options.alpha = 1.0f;
     *         Color color = Color.fromRandom(options);
     *
     *         //Create a random bright color.
     *         ColorRandomOptions options2 = new ColorRandomOptions();
     *         options2.minimumRed : 0.75f;
     *         options2.minimumGreen : 0.75f;
     *         options2.minimumBlue : 0.75f;
     *         options2.alpha = 1.0f;
     *         Color color = Color.fromRandom(options2);
     *     }
     * </pre>
     * @param options Options object.
     * @return The modified result parameter or a new instance if result was undefined.
     */
    @JsMethod
    public static native Color fromRandom(ColorRandomOptions options);

    /**
     * Creates a random color using the provided options. For reproducible random colors, you should call
     * CesiumMath#setRandomNumberSeed once at the beginning of your application.
     * @param options Options object.
     * @param result The object to store the result in, if undefined a new instance will be created.
     * @return The modified result parameter or a new instance if result was undefined.
     */
    @JsMethod
    public static native Color fromRandom(ColorRandomOptions options, Color result);

    /**
     * Creates a new Color from a single numeric unsigned 32-bit RGBA value, using the endianness of the system.
     * <pre>
     *     {@code
     *      Color color = Color.fromRgba(0x67ADDFFF);
     *     }
     * </pre>
     * @param rgba A single numeric unsigned 32-bit RGBA value.
     * @return The color object.
     */
    @JsMethod
    public static native Color fromRgba(int rgba);

    /**
     * Creates a new Color from a single numeric unsigned 32-bit RGBA value, using the endianness of the system.
     * <pre>
     *     {@code
     *      Color color = Color.fromRgba(0x67ADDFFF);
     *     }
     * </pre>
     * @param rgba A single numeric unsigned 32-bit RGBA value.
     * @param result The object to store the result in, if undefined a new instance will be created.
     * @return The color object.
     * @see #toRgba()
     */
    @JsMethod
    public static native Color fromRgba(int rgba, Color result);

    /**
     * Computes the componentwise modulus of two Colors.
     * @param left The first Color.
     * @param right The second Color.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Color mod(Color left, Color right);

    /**
     * Computes the componentwise modulus of two Colors.
     * @param left The first Color.
     * @param right The second Color.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Color mod(Color left, Color right, Color result);

    /**
     * Computes the componentwise product of two Colors.
     * @param left The first Color.
     * @param right The second Color.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Color multiply(Color left, Color right);

    /**
     * Computes the componentwise product of two Colors.
     * @param left The first Color.
     * @param right The second Color.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Color multiply(Color left, Color right, Color result);

    /**
     * Multiplies the provided Color componentwise by the provided scalar.
     * @param color The Color to be scaled.
     * @param scalar The scalar to multiply with.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Color multiplyByScalar(Color color, double scalar);

    /**
     * Multiplies the provided Color componentwise by the provided scalar.
     * @param color The Color to be scaled.
     * @param scalar The scalar to multiply with.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Color multiplyByScalar(Color color, double scalar, Color result);

    /**
     * Stores the provided instance into the provided array.
     * @param value The value to pack.
     * @return The array that was packed into
     */
    @JsMethod
    public static native double[] pack(Color value);

    /**
     * Stores the provided instance into the provided array.
     * @param value The value to pack.
     * @param array The array to pack into.
     * @return The array that was packed into
     */
    @JsMethod
    public static native double[] pack(Color value, double[] array);

    /**
     * Stores the provided instance into the provided array.
     * @param value The value to pack.
     * @param array The array to pack into.
     * @param startingIndex The index into the array at which to start packing the elements.
     * @return The array that was packed into
     */
    @JsMethod
    public static native double[] pack(Color value, double[] array, int startingIndex);

    /**
     * Computes the componentwise difference of two Colors.
     * @param left The first Color.
     * @param right The second Color.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Color subtract(Color left, Color right);

    /**
     * Computes the componentwise difference of two Colors.
     * @param left The first Color.
     * @param right The second Color.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Color subtract(Color left, Color right, Color result);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @return The modified result parameter or a new Color instance if one was not provided.
     */
    @JsMethod
    public static native Color unpack(double[] array);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @param startingIndex The starting index of the element to be unpacked.
     * @return The modified result parameter or a new Color instance if one was not provided.
     */
    @JsMethod
    public static native Color unpack(double[] array, int startingIndex);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @param startingIndex The starting index of the element to be unpacked.
     * @param result The object into which to store the result.
     * @return The modified result parameter or a new Color instance if one was not provided.
     */
    @JsMethod
    public static native Color unpack(double[] array, int startingIndex, Color result);

    /**
     * Brightens this color by the provided magnitude.
     * <pre>
     *     {@code
     *     Color brightBlue = Color.BLUE().brighten(0.5, new Color());
     *     }
     * </pre>
     * @param magnitude A positive number indicating the amount to brighten.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public native Color brighten(double magnitude, Color result);

    /**
     * Returns a duplicate of a Color instance.
     * @return The modified result parameter or a new instance if result was undefined.
     */
    @JsMethod
    public native Color clone();

    /**
     * Returns a duplicate of a Color instance.
     * @param result The object to store the result in, if undefined a new instance will be created.
     * @return The modified result parameter or a new instance if result was undefined.
     */
    @JsMethod
    public native Color clone(Color result);

    /**
     * Darkens this color by the provided magnitude.
     * <pre>
     *     Example:
     *     {@code
     *     Color darkBlue = Color.BLUE().darken(0.5, new Color());
     *     }
     * </pre>
     * @param magnitude A positive number indicating the amount to darken.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public native Color darken(double magnitude, Color result);

    /**
     * Returns true if this Color equals other.
     * @param other The Color to compare for equality.
     * @return true if the Colors are equal; otherwise, false.
     */
    @JsMethod
    public native boolean equals(Color other);

    /**
     * Returns true if this Color equals other componentwise within the specified epsilon.
     * @param other The Color to compare for equality.
     * @return true if the Colors are equal within the specified epsilon; otherwise, false.
     */
    @JsMethod
    public native boolean equalsEpsilon(Color other);


    /**
     * Returns true if this Color equals other componentwise within the specified epsilon.
     * @param other The Color to compare for equality.
     * @param epsilon The epsilon to use for equality testing.
     * @return true if the Colors are equal within the specified epsilon; otherwise, false.
     */
    @JsMethod
    public native boolean equalsEpsilon(Color other, double epsilon);

    /**
     * Converts this color to an array of red, green, blue, and alpha values that are in the range of 0 to 255.
     * @return The modified result parameter or a new instance if result was undefined.
     */
    @JsMethod
    public native int[] toBytes();

    /**
     * Converts this color to an array of red, green, blue, and alpha values that are in the range of 0 to 255.
     * @param result The array to store the result in, if undefined a new instance will be created.
     * @return The modified result parameter or a new instance if result was undefined.
     */
    public native int[] toBytes(Color result);

    /**
     * Creates a string containing the CSS color value for this color.
     * @return The CSS equivalent of this color.
     * @see <a href="http://www.w3.org/TR/css3-color/#rgba-color">CSS RGB or RGBA color values</a>
     */
    @JsMethod
    public native String toCssColorString();

    /**
     * Converts this color to a single numeric unsigned 32-bit RGBA value, using the endianness of the system.
     * @return A single numeric unsigned 32-bit RGBA value.
     * @see #fromRgba(int)
     * @see #fromRgba(int, Color)
     */
    @JsMethod
    public native int toRgba();

    /**
     * Creates a string representing this Color in the format '(red, green, blue, alpha)'.
     * @return A string representing this Color in the format '(red, green, blue, alpha)'.
     */
    @JsMethod
    public native String toString();
    /**
     * Creates a new Color that has the same red, green, and blue components as this Color, but with the specified alpha value.
     * <pre>
     *     Example:
     *     {@code
     *      Color translucentRed = Color.RED().withAlpha(0.9);
     *     }
     * </pre>
     * @param alpha The new alpha component.
     * @return The modified result parameter or a new Color instance if one was not provided.
     */
    @JsMethod
    public native Color withAlpha(float alpha);


    /**
     * Creates a new Color that has the same red, green, and blue components as this Color, but with the specified alpha value.
     * <pre>
     *     Example:
     *     {@code
     *      Color translucentRed = Color.RED().withAlpha(0.9);
     *     }
     * </pre>
     * @param alpha The new alpha component.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new Color instance if one was not provided.
     */
    @JsMethod
    public native Color withAlpha(float alpha, Color result);
}
