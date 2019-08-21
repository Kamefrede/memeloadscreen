package com.kamefrede.memeloadscreen.asm;

import net.minecraft.launchwrapper.IClassTransformer;
import org.apache.logging.log4j.LogManager;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

// Code also taken from Random PSideas
// Boilerplate code taken with love from Vazkii's Quark mod and JamiesWhiteShirt's Clothesline
// Quark is distributed at https://github.com/Vazkii/Quark
// Clothesline is distributed at https://github.com/JamiesWhiteShirt/clothesline

public class ClassTransformer implements IClassTransformer {

    public byte[] transform(final String name, final String transformedName, final byte[] basicClass) {
        if (name.equals("net.minecraftforge.fml.client.SplashProgress")) {
            final ClassNode classNode = new ClassNode();
            final ClassReader classReader = new ClassReader(basicClass);
            classReader.accept(classNode, 0);
            for (final MethodNode methodNode : classNode.methods)
                if (methodNode.name.equals("start"))
                    for (final  AbstractInsnNode insnNode : methodNode.instructions.toArray() ){
                        if (insnNode instanceof LdcInsnNode) {
                            final LdcInsnNode ldcInsnNode = (LdcInsnNode)insnNode;
                            if (ldcInsnNode.cst.equals("textures/gui/title/mojang.png")) {
                                ldcInsnNode.cst = "memeloadscreen:textures/gui/title/mojang.png";
                                break;
                            }
                        }
                    }
            final ClassWriter writer = new ClassWriter(3);
            classNode.accept(writer);
            return writer.toByteArray();
        }
        return basicClass;
    }



}
