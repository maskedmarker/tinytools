package org.cjh.tinytools.decompile.lib;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.io.FileUtil;
import org.cjh.tinytools.decompile.lib.impl.JetbrainDecompileFactory;
import sun.reflect.generics.tree.ByteSignature;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: cjh
 * @time: 2021/4/28 22:33
 */
public class LibDecompiler {

    public static void main(String[] args) throws IOException {
        if (args == null || args.length == 0) {
            return;
        }

        System.out.println("如下目录内的所有jar包都会被反编译为java源码.");
        for (String arg : args) {
            System.out.println(arg);
        }

        System.out.println("请按任意键,确认!");
        System.in.read();
        System.out.println("开始反编译!");

        String[] rootDirs = args;
        for (String rootDir : rootDirs) {
            List<String> files = FileUtil.listFileNames(rootDir);
            List<String> jarNames = files.stream().filter(fileName -> fileName.endsWith(".jar")).collect(Collectors.toList());
            for (String jarName : jarNames) {
                String jarPath = rootDir + File.separator + jarName;
                String srcPath = rootDir + File.separator + jarName.substring(0, jarName.indexOf(".jar"));
                DecompilerFactory decompilerFactory = new JetbrainDecompileFactory();
                Decompiler decompiler = decompilerFactory.create();
                decompiler.decompile(jarPath, srcPath);
            }
        }

    }
}
