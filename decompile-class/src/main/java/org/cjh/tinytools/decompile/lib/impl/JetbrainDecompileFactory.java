package org.cjh.tinytools.decompile.lib.impl;

import org.cjh.tinytools.decompile.lib.Decompiler;
import org.cjh.tinytools.decompile.lib.DecompilerFactory;

/**
 * @author: cjh
 * @time: 2021/4/28 23:09
 */
public class JetbrainDecompileFactory implements DecompilerFactory {
    @Override
    public Decompiler create() {
        return new JetbrainDecompiler();
    }
}
