package com.classloader.test.classloader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IDEA by tiaotiao
 *
 * @author: shixiongzhou
 * @date: 2019/4/28 下午5:34
 */
public interface FileLoader {

    /**
     * Read the class file as bytes array
     *
     * @param s class full name
     * @return the file content
     * @throws IOException if load file fail, then throw a IOException
     */
    default byte[] readClassAsBytes(String s) throws IOException {
        String alias = String.format("/%s.class", s.replaceAll("\\.", "/"));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try(InputStream is = this.getClass().getResourceAsStream(alias)) {
            int len = 1024;
            byte[] tmp = new byte[len];
            int i;

            while ((i = is.read(tmp, 0, len)) > 0) {
                baos.write(tmp, 0, i);
            }
            return baos.toByteArray();
        }
    }

}
