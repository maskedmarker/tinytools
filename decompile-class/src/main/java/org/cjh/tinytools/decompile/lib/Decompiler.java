package org.cjh.tinytools.decompile.lib;

public interface Decompiler {
    /**
     * decompile the jar file to src dir
     * @param libFile the lib to be decompiled
     * @param srcDir  the dir that contains the decompiled java file
     */
    void decompile(String libFile, String srcDir);
}
