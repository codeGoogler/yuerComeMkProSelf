package mk.yuer.com.yuercomemkproself.designmode;

/**
 * 类功能描述：</br>
 *
 * @author 于亚豪
 * @version 1.0 </p> 修改时间：2019/5/16</br> 修改备注：</br>
 */
public class LazySafetySingleton {
    // 饿汉式
    public static class LazySafetySingleton1{
        private  static LazySafetySingleton1 singleton = new LazySafetySingleton1();
        public  static LazySafetySingleton1 getInstance(){
            return singleton;
        }
    }

    // 懒汉式
    public static class LazySafetySingleton2{
        private  static LazySafetySingleton2 singleton;
        public  static LazySafetySingleton2 getInstance(){
            if(singleton == null){
                singleton = new LazySafetySingleton2();
            }
            return singleton;
        }
    }

    // 懒汉式 线程安全

    public static class LazySafetySingleton3{
        private  static LazySafetySingleton3 singleton;

        // synchronized 避免多个同一时间内，只允许进入一个 LazySafetySingleton getInstance方法
        public  static synchronized LazySafetySingleton3 getInstance(){
            if(singleton == null){
                singleton = new LazySafetySingleton3();
            }
            return singleton;
        }

        //第二种懒汉线程安全，适用于同步代码块中的
        public  static  LazySafetySingleton3 getInstance2(){
            synchronized (LazySafetySingleton3.class){
                if(singleton == null){
                    singleton = new LazySafetySingleton3();
                }
            }
            return singleton;
        }
    }




    //  DCL
    public static class LazySafetySingleton4{
        private  static  volatile LazySafetySingleton4 singleton;

        public  static  LazySafetySingleton4 getInstance3(){
            //避免不必要的同步
            if(singleton == null){
                //同步
                synchronized (LazySafetySingleton4.class){
                    if(singleton == null){
                        //对此调用初始化
                        singleton = new LazySafetySingleton4();
                    }
                }
            }
            return singleton;
        }

    }

    // 利用静态变量的唯一性

    /**
     * 1，节约虚拟机本身的机制，保证来数据的安全，提供了static final 关键字等
     * 2、并没有使用我们的关键字synchronized,因为synchronize虽然能保证我们的线程安全，但是他飞长影响性能的，因为它只能有一个线程来读取里面的数据
     * 这样读取实例的实例，另外的就不能读取，而静态内部类就不一样，可以同时读取实例，利用类中静态变量的唯一性
     *  3.singletonHolder是私有的，处理getInstance方法，其他地方没有办法访问他
     */
    //静态内部类
    public  static class  LazySafetySingleton5{

        private LazySafetySingleton5(){}
        public LazySafetySingleton5 getInstances(){
            return LazySafetySingleton5Holder.instance;
        }

        private static class LazySafetySingleton5Holder{
            private static final LazySafetySingleton5 instance = new LazySafetySingleton5();
        }
    }


    public static  void main(String [] args){
        System.out.print("================");
    }
}
