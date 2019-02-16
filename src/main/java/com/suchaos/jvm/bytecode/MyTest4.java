package com.suchaos.jvm.bytecode;

import java.io.FileNotFoundException;

/**
 * java try catch 中 return 的处理：
 * <p>
 * try catch语句块中的 return 语句，在字节码中，return后的计算结果已经放到栈顶了，
 * 然后store到局部变量表中（对于基本类型，就是复制了一份，对于引用类型，就是多了一个引用，
 * 如果别的指向这个对象的引用修改了对象，那么这个引用指向的对象当然也被修改了），
 * 但是，接着执行 finally 块的内容，然后再将变量从表中取出来，执行刚刚的 return 指令。
 * 因此，如果在 finally 块中有 return，那么try, catch 中的return都无法执行了
 *
 * @author suchao
 * @date 2019/2/15
 */
public class MyTest4 {
    public static void main(String[] args) {
        System.out.println(get2());
    }

    public static int get() {
        int i = 1;
        try {
            throw new FileNotFoundException();
        } catch (Exception e) {
            System.out.println("error");
            System.out.println(1 / 0);
            return i;
        } finally {
            i++;
            System.out.println("finally中的 i = " + i);
        }
    }

    public static StringBuilder get2() {
        StringBuilder builder = new StringBuilder("ok");
        try {
            throw new FileNotFoundException();
        } catch (Exception e) {
            System.out.println("error");
            //System.out.println(1 / 0);
            return builder;
        } finally {
            builder.append("xxx");
            System.out.println("finally中的 i = " + builder);
        }
    }

    public int test() {
        try {
            int i = 1;
            return i;
        } catch (Exception e) {
            return 4;
        } finally {
            //return 2;
            System.out.println("2");
        }
    }

    public int calculate() {
        int x = 1;
        try {
            System.out.println("A");
            return ++x;
            //return x++;

        } catch (Exception e) {
            System.out.println("D");
        } finally {
            System.out.println("B");
            ++x;
        }
        System.out.println("C");
        return x;
    }
}
