package com.suchaos.jvm.classloader;

/**
 * 学习数组的类型
 *
 * 对于数组实例来说，其类型是由 JVM 在运行期动态生成的，表示为 [Lcom.suchaos.jvm.classloader.MyParent4
 * 这种形式。动态生成的类型，其父类就是 Object
 *
 * 对于数组来说，JavaDoc 经常将构成数组的元素称为 Component,实际上就是将数组降低一个维度后的类型
 *
 * 助记符：
 * anewarray：表示创建一个引用类型的（如类，接口，数组）数组，并将其引用值压入栈顶
 * newarray：表示创建一个指定的原始类型（如 int, float, char等）的数组，并将其引用值压入栈顶
 *
 * @author suchao
 * @date 2019/2/2
 */
public class MyTest4 {
    public static void main(String[] args) {
        // newarray       int
        int[] ints = new int[2];
        // class [I
        System.out.println(ints.getClass());
        // class java.lang.Object
        System.out.println(ints.getClass().getSuperclass());

        // anewarray     #6                // class "[I"
        int[][] ints2 = new int[2][];
        // class [[I
        System.out.println(ints2.getClass());

        // anewarray     #7                // class com/suchaos/jvm/classloader/MyParent4
        MyParent4[] myParent4s = new MyParent4[2];
        // class [Lcom.suchaos.jvm.classloader.MyParent4;
        System.out.println(myParent4s.getClass());
    }
}

class MyParent4 {
    static {
        System.out.println("MyParent4 static block");
    }
}
