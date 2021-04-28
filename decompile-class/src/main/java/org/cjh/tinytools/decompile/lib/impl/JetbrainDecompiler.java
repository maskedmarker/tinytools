package org.cjh.tinytools.decompile.lib.impl;

import cn.hutool.core.io.FileUtil;
import org.cjh.tinytools.decompile.lib.Decompiler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author: cjh
 * @time: 2021/4/28 23:02
 */
public class JetbrainDecompiler implements Decompiler {

    private static String CMD_PATTERN = "java -cp F:\\git-repo\\tinytools\\decompile-class\\src\\main\\resources\\lib\\java-decompiler.jar  org.jetbrains.java.decompiler.main.decompiler.ConsoleDecompiler -dgs=true %s %s";
    @Override
    public void decompile(String libFile, String srcDir) {
        if (FileUtil.exist(srcDir)) {
            FileUtil.del(srcDir);
        }
        FileUtil.mkdir(srcDir);

        Process p = null;
        InputStream is = null;
        BufferedReader reader = null;
        try {
            p = Runtime.getRuntime().exec(String.format(CMD_PATTERN, libFile, srcDir));
            is = p.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            p.waitFor();
            is.close();
            reader.close();
            p.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
