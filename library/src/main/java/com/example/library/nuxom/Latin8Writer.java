//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.library.nuxom;

import java.io.Writer;

class Latin8Writer extends TextWriter {
    Latin8Writer(Writer var1, String var2) {
        super(var1, var2);
    }

    boolean needsEscaping(char var1) {
        if (var1 <= 160) {
            return false;
        } else {
            switch(var1) {
                case '£':
                    return false;
                case '¤':
                    return true;
                case '¥':
                    return true;
                case '¦':
                    return true;
                case '§':
                    return false;
                case '¨':
                    return true;
                case '©':
                    return false;
                case 'ª':
                    return true;
                case '«':
                    return true;
                case '¬':
                    return true;
                case '\u00ad':
                    return false;
                case '®':
                    return false;
                case '¯':
                    return true;
                case '°':
                    return true;
                case '±':
                    return true;
                case '²':
                    return true;
                case '³':
                    return true;
                case '´':
                    return true;
                case 'µ':
                    return true;
                case '¶':
                    return false;
                case '·':
                    return true;
                case '¸':
                    return true;
                case '¹':
                    return true;
                case 'º':
                    return true;
                case '»':
                    return true;
                case '¼':
                    return true;
                case '½':
                    return true;
                case '¾':
                    return true;
                case '¿':
                    return true;
                case 'À':
                    return false;
                case 'Á':
                    return false;
                case 'Â':
                    return false;
                case 'Ã':
                    return false;
                case 'Ä':
                    return false;
                case 'Å':
                    return false;
                case 'Æ':
                    return false;
                case 'Ç':
                    return false;
                case 'È':
                    return false;
                case 'É':
                    return false;
                case 'Ê':
                    return false;
                case 'Ë':
                    return false;
                case 'Ì':
                    return false;
                case 'Í':
                    return false;
                case 'Î':
                    return false;
                case 'Ï':
                    return false;
                case 'Ð':
                    return true;
                case 'Ñ':
                    return false;
                case 'Ò':
                    return false;
                case 'Ó':
                    return false;
                case 'Ô':
                    return false;
                case 'Õ':
                    return false;
                case 'Ö':
                    return false;
                case '×':
                    return true;
                case 'Ø':
                    return false;
                case 'Ù':
                    return false;
                case 'Ú':
                    return false;
                case 'Û':
                    return false;
                case 'Ü':
                    return false;
                case 'Ý':
                    return false;
                case 'Þ':
                    return true;
                case 'ß':
                    return false;
                case 'à':
                    return false;
                case 'á':
                    return false;
                case 'â':
                    return false;
                case 'ã':
                    return false;
                case 'ä':
                    return false;
                case 'å':
                    return false;
                case 'æ':
                    return false;
                case 'ç':
                    return false;
                case 'è':
                    return false;
                case 'é':
                    return false;
                case 'ê':
                    return false;
                case 'ë':
                    return false;
                case 'ì':
                    return false;
                case 'í':
                    return false;
                case 'î':
                    return false;
                case 'ï':
                    return false;
                case 'ð':
                    return true;
                case 'ñ':
                    return false;
                case 'ò':
                    return false;
                case 'ó':
                    return false;
                case 'ô':
                    return false;
                case 'õ':
                    return false;
                case 'ö':
                    return false;
                case '÷':
                default:
                    switch(var1) {
                        case 'Ŵ':
                            return false;
                        case 'ŵ':
                            return false;
                        case 'Ŷ':
                            return false;
                        case 'ŷ':
                            return false;
                        case 'Ÿ':
                            return false;
                        default:
                            switch(var1) {
                                case 'Ḃ':
                                    return false;
                                case 'ḃ':
                                    return false;
                                case 'Ḅ':
                                    return true;
                                case 'ḅ':
                                    return true;
                                case 'Ḇ':
                                    return true;
                                case 'ḇ':
                                    return true;
                                case 'Ḉ':
                                    return true;
                                case 'ḉ':
                                    return true;
                                case 'Ḋ':
                                    return false;
                                case 'ḋ':
                                    return false;
                                case 'Ḍ':
                                    return true;
                                case 'ḍ':
                                    return true;
                                case 'Ḏ':
                                    return true;
                                case 'ḏ':
                                    return true;
                                case 'Ḑ':
                                    return true;
                                case 'ḑ':
                                    return true;
                                case 'Ḓ':
                                    return true;
                                case 'ḓ':
                                    return true;
                                case 'Ḕ':
                                    return true;
                                case 'ḕ':
                                    return true;
                                case 'Ḗ':
                                    return true;
                                case 'ḗ':
                                    return true;
                                case 'Ḙ':
                                    return true;
                                case 'ḙ':
                                    return true;
                                case 'Ḛ':
                                    return true;
                                case 'ḛ':
                                    return true;
                                case 'Ḝ':
                                    return true;
                                case 'ḝ':
                                    return true;
                                case 'Ḟ':
                                    return false;
                                case 'ḟ':
                                    return false;
                                case 'Ḡ':
                                    return true;
                                case 'ḡ':
                                    return true;
                                case 'Ḣ':
                                    return true;
                                case 'ḣ':
                                    return true;
                                case 'Ḥ':
                                    return true;
                                case 'ḥ':
                                    return true;
                                case 'Ḧ':
                                    return true;
                                case 'ḧ':
                                    return true;
                                case 'Ḩ':
                                    return true;
                                case 'ḩ':
                                    return true;
                                case 'Ḫ':
                                    return true;
                                case 'ḫ':
                                    return true;
                                case 'Ḭ':
                                    return true;
                                case 'ḭ':
                                    return true;
                                case 'Ḯ':
                                    return true;
                                case 'ḯ':
                                    return true;
                                case 'Ḱ':
                                    return true;
                                case 'ḱ':
                                    return true;
                                case 'Ḳ':
                                    return true;
                                case 'ḳ':
                                    return true;
                                case 'Ḵ':
                                    return true;
                                case 'ḵ':
                                    return true;
                                case 'Ḷ':
                                    return true;
                                case 'ḷ':
                                    return true;
                                case 'Ḹ':
                                    return true;
                                case 'ḹ':
                                    return true;
                                case 'Ḻ':
                                    return true;
                                case 'ḻ':
                                    return true;
                                case 'Ḽ':
                                    return true;
                                case 'ḽ':
                                    return true;
                                case 'Ḿ':
                                    return true;
                                case 'ḿ':
                                    return true;
                                case 'Ṁ':
                                    return false;
                                case 'ṁ':
                                    return false;
                                case 'Ṃ':
                                    return true;
                                case 'ṃ':
                                    return true;
                                case 'Ṅ':
                                    return true;
                                case 'ṅ':
                                    return true;
                                case 'Ṇ':
                                    return true;
                                case 'ṇ':
                                    return true;
                                case 'Ṉ':
                                    return true;
                                case 'ṉ':
                                    return true;
                                case 'Ṋ':
                                    return true;
                                case 'ṋ':
                                    return true;
                                case 'Ṍ':
                                    return true;
                                case 'ṍ':
                                    return true;
                                case 'Ṏ':
                                    return true;
                                case 'ṏ':
                                    return true;
                                case 'Ṑ':
                                    return true;
                                case 'ṑ':
                                    return true;
                                case 'Ṓ':
                                    return true;
                                case 'ṓ':
                                    return true;
                                case 'Ṕ':
                                    return true;
                                case 'ṕ':
                                    return true;
                                case 'Ṗ':
                                    return false;
                                case 'ṗ':
                                    return false;
                                case 'Ṙ':
                                    return true;
                                case 'ṙ':
                                    return true;
                                case 'Ṛ':
                                    return true;
                                case 'ṛ':
                                    return true;
                                case 'Ṝ':
                                    return true;
                                case 'ṝ':
                                    return true;
                                case 'Ṟ':
                                    return true;
                                case 'ṟ':
                                    return true;
                                case 'Ṡ':
                                    return false;
                                case 'ṡ':
                                    return false;
                                case 'Ṣ':
                                    return true;
                                case 'ṣ':
                                    return true;
                                case 'Ṥ':
                                    return true;
                                case 'ṥ':
                                    return true;
                                case 'Ṧ':
                                    return true;
                                case 'ṧ':
                                    return true;
                                case 'Ṩ':
                                    return true;
                                case 'ṩ':
                                    return true;
                                case 'Ṫ':
                                    return false;
                                case 'ṫ':
                                    return false;
                                case 'Ṭ':
                                    return true;
                                case 'ṭ':
                                    return true;
                                case 'Ṯ':
                                    return true;
                                case 'ṯ':
                                    return true;
                                case 'Ṱ':
                                    return true;
                                case 'ṱ':
                                    return true;
                                case 'Ṳ':
                                    return true;
                                case 'ṳ':
                                    return true;
                                case 'Ṵ':
                                    return true;
                                case 'ṵ':
                                    return true;
                                case 'Ṷ':
                                    return true;
                                case 'ṷ':
                                    return true;
                                case 'Ṹ':
                                    return true;
                                case 'ṹ':
                                    return true;
                                case 'Ṻ':
                                    return true;
                                case 'ṻ':
                                    return true;
                                case 'Ṽ':
                                    return true;
                                case 'ṽ':
                                    return true;
                                case 'Ṿ':
                                    return true;
                                case 'ṿ':
                                    return true;
                                case 'Ẁ':
                                    return false;
                                case 'ẁ':
                                    return false;
                                case 'Ẃ':
                                    return false;
                                case 'ẃ':
                                    return false;
                                case 'Ẅ':
                                    return false;
                                case 'ẅ':
                                    return false;
                                default:
                                    switch(var1) {
                                        case 'Ỳ':
                                            return false;
                                        case 'ỳ':
                                            return false;
                                        default:
                                            return true;
                                    }
                            }
                    }
                case 'ø':
                    return false;
                case 'ù':
                    return false;
                case 'ú':
                    return false;
                case 'û':
                    return false;
                case 'ü':
                    return false;
                case 'ý':
                    return false;
                case 'þ':
                    return true;
                case 'ÿ':
                    return false;
                case 'Ā':
                    return true;
                case 'ā':
                    return true;
                case 'Ă':
                    return true;
                case 'ă':
                    return true;
                case 'Ą':
                    return true;
                case 'ą':
                    return true;
                case 'Ć':
                    return true;
                case 'ć':
                    return true;
                case 'Ĉ':
                    return true;
                case 'ĉ':
                    return true;
                case 'Ċ':
                    return false;
                case 'ċ':
                    return false;
                case 'Č':
                    return true;
                case 'č':
                    return true;
                case 'Ď':
                    return true;
                case 'ď':
                    return true;
                case 'Đ':
                    return true;
                case 'đ':
                    return true;
                case 'Ē':
                    return true;
                case 'ē':
                    return true;
                case 'Ĕ':
                    return true;
                case 'ĕ':
                    return true;
                case 'Ė':
                    return true;
                case 'ė':
                    return true;
                case 'Ę':
                    return true;
                case 'ę':
                    return true;
                case 'Ě':
                    return true;
                case 'ě':
                    return true;
                case 'Ĝ':
                    return true;
                case 'ĝ':
                    return true;
                case 'Ğ':
                    return true;
                case 'ğ':
                    return true;
                case 'Ġ':
                    return false;
                case 'ġ':
                    return false;
            }
        }
    }
}
