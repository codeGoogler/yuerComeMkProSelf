package mk.yuer.com.yuercomemkproself.designmode;

/**
 * 类功能描述：</br>
 * 使用枚举的单例模式
 * @author 于亚豪
 * @version 1.0 </p> 修改时间：2019/5/16</br> 修改备注：</br>
 *
 */

public class EnumSingleton {
//    https://www.cnblogs.com/yangzhilong/p/6148639.html
    private EnumSingleton(){}
    public static EnumSingleton getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private static enum Singleton{
        INSTANCE;

        private EnumSingleton singleton;
        //JVM会保证此方法绝对只调用一次
        private Singleton(){
            singleton = new EnumSingleton();
        }
        public EnumSingleton getInstance(){
            return singleton;
        }
    }

}
