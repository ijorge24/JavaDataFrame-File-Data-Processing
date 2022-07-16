package Observer;
import java.lang.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

    /**
     * Class that controls access to the target object
     */
public class dynamicProxy implements InvocationHandler {
    private Object target;

    /**
     * Constructor of dynamicProxy
     * @param target the object target
     */
    private dynamicProxy(Object target) {
        this.target = target;
    }

    /**
     * Add the target object to the proxy
     * @param target the object (observer)
     * @return the proxy
     */
    public static Object newInstance(Object target){
        Class targetClass = target.getClass();
        Class[] interfaces = targetClass.getInterfaces();
        return Proxy. newProxyInstance(targetClass.getClassLoader(),
                interfaces, new dynamicProxy(target));
    }

    /**
     * Control and invoke a method
     * @param proxy the proxy
     * @param method the method to invoke
     * @param args args of the method
     * @return  the result of the method
     * @throws Throwable allows to invoke a method
     */
   public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        Object invocationResult = null;
        try
        {
            System.out.println("Before method " + method.getName());
            invocationResult = method.invoke(this.target, args);
            System.out.println("After method " + method.getName());
        }
        catch(InvocationTargetException ite)
        {
            throw ite.getTargetException();
        }
        catch(Exception e)
        {
            System.err.println("Invocation of " + method.getName() + " failed");
        }
        finally{
            return invocationResult;
        }
    }
}
