package com.taotao.mapper;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

/**
 * Created by dongly on 17-3-12.
 */
public class AbcTest {

    @Test
    public void test() {
        String str = "abc,asdfa,中欧难过";
        System.out.println(str.replaceAll("[\\,]{2}", "-"));
        String replace = str.replace(",", "-");
        System.out.println(replace);
        System.out.println(str.indexOf(","));
        int i1 = str.indexOf(",", str.indexOf(",") + 1);
        System.out.println(i1);
        char[] chars = str.toCharArray();

        chars[i1] = '-';

        // int count = 1;
        // for (int i = 0; i < chars.length; i++) {
        //     if (chars[i] == ',') {
        //         if (count++ > 1) {
        //             chars[i] = '-';
        //         }
        //     }
        // }

        String s = String.copyValueOf(chars);
        System.out.println(s);
    }

}
